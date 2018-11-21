<%--suppress JSUnresolvedVariable --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>添加出入库</title>
    <jsp:include page="/common/common.jsp"/>
</head>
<body class="no-skin init-iframe-box" youdao="bind" style="background: white;overflow-scrolling: auto;">

<input id="gritter-light" checked="" type="checkbox" class="ace ace-switch ace-switch-5"/>


<div class="iframe-child">

    <div class="page-header">
        <h1>
            出入库管理
            <small>
                <i class="ace-icon fa fa-angle-double-right"></i>
                <label class="storage-title"></label>
            </small>
        </h1>
    </div>

    <div class="main-content-inner">

        <div class="col-sm-9">
            <div class="table-header"><label class="storage-title"></label> </div>
            <form class="form form-horizontal row-20" id="storageForm" name="storageForm">

                <input type="hidden" name="id" id="storage-id" value="${storageId}">
                <table class="ud-table">
                    <tr>
                        <td rowspan="4">
                            <img src="" id="storage-image-url" width="150" height="150" >
                            <input type="hidden" name="imageUrl" id="hidden-image-url">
                        </td>
                        <td class="td1">商品名称</td>
                        <td colspan="4">
                            <input type="hidden" name="comName" id="commodity-name">
                            <input type="hidden" name="comId" id="commodity-id" value="${commodityId}">
                            <label style="color:red;" id="storage-com-name"></label>
                        </td>
                    </tr>

                    <tr>
                        <td>仓库</td>
                        <td>
                            <select name="warId" id="warSelectId" class="form-control">
                            </select>
                        </td>
                        <td class="td2">出入库时间</td>
                        <td colspan="2"><input type="text" id="storage-created" class="form-control"
                                   placeholder="可以为空,空时默认当前时间" name="created">
                        </td>
                    </tr>
                    <tr>
                        <td>商品所在仓库</td>
                        <td colspan="4">
                            <i id="warehouse-list"></i>
                        </td>
                    </tr>

                    <tr>
                        <td>出入方向</td>
                        <td>
                            <select name="direction" id="selectDirection" class="form-control">
                                <option value="-1">--选择出入库--</option>
                                <option value="0">入库</option>
                                <option value="1">出库</option>
                            </select>
                        </td>
                        <td class="td2">总数</td>
                        <td class="td1">
                            <h4><i style="color:red" id="storage-total">0</i></h4>
                        </td>
                        <td>
                            <i id="add-i-0" onclick="addStorageDetail(0);" title="添加出入库明细"
                               class="blue fa fa-plus bigger-180 add-storage-detail"></i>
                            <i id="storage-save" class="orange fa fa-floppy-o bigger-180"></i>
                        </td>
                    </tr>

                </table>

                <div class="col-sm-12" id="storageDetailList">

                </div>
            </form>
        </div>

        <div class="col-sm-3">

        </div>
    </div>
</div>

<script src="/js/defined/image.js"></script>
<script src="/js/valid/base-valid.js"></script>

<script type="text/javascript">

    var storagePageMap = {};
    var optionColorStr = "";
    var optionStr = "";
    //出入库方向 默认为 -1
    var storageDirection = -1;
    //仓库编号 默认为 -1
    var warehouseSelectId = -1;
    //商品编号
    var commodityId;
    //出入库编号
    var storageId;
    //起始 序列 默认为 0
    var origin = 0;
    //累加颜色编号  起始序列 用 ',' 分开
    var accumulation = "";
    //颜色Map 集合
    var tempAppendColorMap = {};
    //出入库页面 集合[出入库页面含有 颜色编号,颜色名称,数量,库存数量],可用于数据回显
    var storagePageList = new Array();
    //库存数量 默认为 -1
    var inventoryQuantity = -1;
    //保存与更新 状态 切换 默认为 false
    var saveStatus = false;

    //初始化时间控件
    datetimeUtil("#storage-created");

    $(function () {
        loadPage();
        //加载页面 方法
        function loadPage() {
            commodityId = $("#commodity-id").val();
            storageId = $("#storage-id").val();
            $.ajax({
                url:"/sys/stor/obtainstorage.json",
                data : {
                    commodityId : commodityId ,
                    storageId : storageId
                },
                async : false,
                success : function (result) {
                    if (result.status == 200) {
                        var commodity = result.data.commodity;
                        var warehouseList = result.data.warehouseList;
                        if (commodity) {
                            $("#commodity-id").val(commodity.id);
                            $("#commodity-name").val(commodity.name);
                            $("#storage-com-name").html(commodity.name);
                            $("#storage-image-url").attr("src",commodity.mainImg);
                            $("#hidden-image-url").val(commodity.mainImg);
                            $("#warehouse-list").html(result.data.displayInventory)

                        }
                        if (warehouseList) {
                            optionStr = '<option value="-1">--选择仓库--</option>';
                            renderWarehouseSelect(warehouseList);
                            warehouseSelectId = result.data.warId;
                            $("#warSelectId").html(optionStr);
                            $("#warSelectId").val(warehouseSelectId);
                        }
                        //表示更新状态
                        if(!existNotBlank(storageId)){
                            var storage = result.data.storage;
                            var storageDetailParams = storage.storageDetailParams;
                            storagePageList = storage.storagePages;
                            $("#storage-created").val(storage.created);
                            $("#storage-created").attr("disabled",true);

                            storageDirection = storage.direction;
                            $("#selectDirection").val(storage.direction);
                            $("#selectDirection").attr("disabled", true);
                            $("#storage-total").html(storage.total);
                            triggerAddStorageDetailBtn("none");
                            $("#warSelectId").attr("disabled", true);

                            var length = storageDetailParams.length;
                            origin = 0;
                            accumulation = "";
                            for(var i = 0; i < length; i++){
                                origin ++;
                                accumulation += origin + ",";
                                //调用创建HTML 方法
                                createStorageDetailHtml();
                                if(i != length -1){
                                    triggerAddStorageDetailBtn("none");
                                }
                                var tColId = storageDetailParams[i].colId;
                                $("#quantity-" + origin).val(storageDetailParams[i].quantity);
                                $("#colId-" + origin).val(tColId);
                                $("#inventory-quantity-" + origin).val(storagePageMap[tColId].inventoryQuantity);
                            }
                        }
                    }
                }
            });
            if (existNotBlank(storageId)){
                $(".storage-title").html("添加出入库");
                $("#storage-save").attr("title","保存");
                saveStatus = false;
            }else {
                $(".storage-title").html("更新出入库")
                $("#storage-save").attr("title","更新");
                saveStatus = true;
            }
        }
        //取消 点击事件
        $("#storage-cancel").click(function (e) {
            e.preventDefault();
            window.location.href = '/sys/stor/commodity.page';
        });
    });

    //出入库方向 change 事件
    $("#selectDirection").change(function (e) {
        storageDirection = $(this).val();
        if (storageDirection == -1){
            return;
        }
        if(warehouseSelectId == -1){
            showMessage("提示","请选择仓库");
            return;
        }
        storagePageList = new Array();
        //根据出入库方向获取相应的数据
        $.ajax({
            url : '/sys/stor/obtainstoragepages.json',
            data : {
                commodityId:commodityId,
                warehouseId : warehouseSelectId,
                direction : storageDirection
            },
            type : 'POST',
            async: false,
            success : function(result) {
                if (result.status == 200) {
                    storagePageList = result.data;
                    optionColorStr = "";
                    renderColorSelect(storagePageList);
                    //storageDetailList 子类
                    $("#storageDetailList").html("");

                }else {
                    showMessage("提示信息", result.msg, false);
                    $("#selectDirection").val(-1);
                }
            }

        });
    });

    //仓库 change 事件
    $("#warSelectId").change(function (e) {
        e.preventDefault();
        warehouseSelectId = $("#warSelectId option:selected").val();
    });

    /**
     * <h4>输入框失去焦点事件</h4>
    */
    function quantityBlur() {
        calcTotal();
    }

    /**
     * <h4>disabled 下拉框</h4>
     * @param b
     */
    function disabledSelect(b) {
        $("#selectDirection").attr("disabled",b);
        $("#warSelectId").attr("disabled",b);
    }

    //添加 出入库明细
    function addStorageDetail(id) {

        if (storageDirection == -1 ){
            showMessage("提示", "请选择出入库方向", false);
            return;
        }
        if (id == 0){
            if (warehouseSelectId == -1){
                showMessage("提示", "请选择仓库", false);
                return;
            }
            disabledSelect(true);
        }else {
            var idList = [id];
            //调用验证
            if(validAddStorageDetail(idList)){
                return;
            }
            var tColor = $("#colId-" + id);
            tempAppendColorMap[tColor.val()] = tColor;
        }

        origin ++;
        accumulation += origin + ",";
        triggerAddStorageDetailBtn("none");
        createStorageDetailHtml();
    }
    //删除 出入库明细一行
    function deleteStorageDetail(id) {
        var list = conventList();
        var length = list.length;
        if (id == list[length -1]) {
            if (length == 1) {
                if (!validNotBlank(storageId)){
                    showMessage("删除提示", "最少保留一条信息", false);
                    return;
                }
                triggerAddStorageDetailBtn("inline");
                disabledSelect(false);
            }else {
                $("#add-i-" + list[length - 2]).show();
            }
        }
        //获取 隐藏的颜色编号
        var key = $("#hidden-colId-" + id).val();
        // 移除 出入库明细一行 div层
        $("#div-controller-"+ id).remove();
        //把id 从accumulation字符串中移除
        accumulation = accumulation.replace(id + ",", "");
        //
        delete tempAppendColorMap[key];
        //调用计算
        calcTotal();
    }

    //颜色 下拉框 change 事件
    function colorSelectChange(self) {
        var id = self.id;
        id = id.substring(id.lastIndexOf("-") + 1);
        var colId = $("#hidden-colId-" + id).val();
        var key = self.value;
        if (!validNotBlank(colId)) {
            delete tempAppendColorMap[colId];
        }
        if (key == -1){
            inventoryQuantity = -1;
            return;
        }
        if (tempAppendColorMap.hasOwnProperty(key)){
            showMessage("提示", "请选择不同的颜色", false);
            if (validNotBlank(colId)){
                $(self).val(-1);
            }else {
                $(self).val(colId);
            }
            return;
        }

        //获取到相应的库存数量
        inventoryQuantity = storagePageMap[key].inventoryQuantity;
        $("#quantity-" + id).val('');
        $("#hidden-colId-" + id).val(key);
        $("#inventory-quantity-" + id).val(inventoryQuantity);
        tempAppendColorMap[key] = self;
    }

    $("#storage-save").click(function (e) {
        e.preventDefault();
        var tList = conventList();
        var tLength = tList.length;
        if (tList < 1){
            showMessage("提示","请添加出入库明细信息", false);
            return;
        }
        if(validAddStorageDetail(tList)){
            return;
        }
        var url = saveStatus ? '/sys/stor/update.json' : '/sys/stor/save.json';

        var form = $("#storageForm")[0];
        var formData = new FormData(form);
        formData.append("id", $("#storage-id").val());
        formData.append("warName",$("#warSelectId option:selected").text());
        formData.append("warId", warehouseSelectId);
        formData.append("total",$("#storage-total").html());
        formData.append("direction",$("#selectDirection option:selected").val());

        $.ajax({
            url : url,
            data : formData,
            type : 'POST',
            // dataType: "application/json;charset=utf-8", //jsonp会把请求类型强制转换为get请求
            contentType: false,
            processData: false,
            async: false, //同步请求
            // cache: false, //是否缓存
            success : function(res){
                if (res.status == 200){
                    window.location.href = '/sys/stor/storage.page';
                }else {
                    showMessage("保存提示", res.msg, false);
                }
            }
        });
    });

    //字符串转成集合
    function conventList() {
        var temp = accumulation.substring(0, accumulation.length - 1);
        return temp.split(",");
    }

    //验证 添加 每一行出入库明细
    function validAddStorageDetail(idList) {
        var length = idList.length;
        for(var i=0;i<length;i++){
            var tId = idList[i];

            var colId = $("#colId-" + tId).val();
            if (colId == -1){
                showMessage("提示","请选择颜色", false);
                $("#colId-" + tId).focus();
                return true;
            }
            var quantity = $("#quantity-" + tId).val();
            if (validNotBlank(quantity) ){
                showMessage("提示","请输入数量", false);
                $("#quantity-" + tId).focus();
                return true;
            }
            if(regexp(quantity,REGEX_INT_SIMPLE)){
                showMessage("提示","请输入正确数字格式并且要大于0的数", false);
                $("#quantity-" + tId).focus();
                return true;
            }
            var tInventoryQuantity = $("#inventory-quantity-" + tId).val();
            if (storageDirection == 1 && quantity > Number(tInventoryQuantity)){
                showMessage("提示1111","库存数量不足", false);
                $("#quantity-" + tId).focus();
                return true;
            }
        }
        return false;
    }

    /**
     * <h4>计算总数量</h4>
     */
    function calcTotal() {
        var arr = $("#storageDetailList").find(":text");
        var num = Number(0);
        for(var i =0 ; i < arr.length; i++){
            num += Number(arr.eq(i).val());
        }
        $("#storage-total").html(num);
    }

    /**
     * <h4>创建出入库明细 [每行 信息]</h4>
     */
    function createStorageDetailHtml() {
        optionColorStr = "";
        renderColorSelect(storagePageList);
        var splitJoint = '<div id="div-controller-' + origin + '" class="row ud-storage">' +
            '<label class="ud-title">颜色</label>' +
            '<select class="ud-select" id="colId-' + origin + '" name="colIds" onchange="colorSelectChange(this);">' +
            '<option value="-1">--选择颜色--</option>' + optionColorStr  +
            '</select>' +
            '<label class="ud-title">数量</label>' +
            '<input type="text" name="quantities" id="quantity-' + origin +'" onblur="quantityBlur();" class="ud-input">' +
            '<input type="hidden" id="hidden-colId-' + origin + '" value="">' +
            '<i id="add-i-' + origin + '" onclick="addStorageDetail(' + origin + ');" class="blue fa fa-plus bigger-180 add-storage-detail"></i>' +
            '<i onclick="deleteStorageDetail(' + origin + ');" class="red fa fa-minus bigger-180 delete-storage-detail"></i>' +
            '<input type="hidden" name="inventoryQuantity" id="inventory-quantity-' + origin +'">' +
            '</div>';

        $("#storageDetailList").append(splitJoint);

    }

    //渲染产地 下拉框
    function renderWarehouseSelect(warehouseList) {
        if (warehouseList && warehouseList.length > 0) {
            $(warehouseList).each(function (i, warehouse) {
                optionStr += Mustache.render("<option value='{{id}}'>{{name}}</option>",
                    {id: warehouse.id, name: warehouse.name});
            });
        }
    }

    //渲染颜色 下拉框
    function renderColorSelect(storagePageList) {
        storagePageMap = {};
        if (storagePageList && storagePageList.length > 0) {
            $(storagePageList).each(function (i, storagePage) {
                storagePageMap[storagePage.colId] = storagePage;
                optionColorStr += Mustache.render("<option value='{{id}}'>{{name}}</option>",
                    {id: storagePage.colId, name: storagePage.colName});
            });
        }
    }
    //切换添加出入库明细按钮
    function triggerAddStorageDetailBtn(bo) {
        $(".add-storage-detail").css("display", bo);
    }

</script>

</body>
</html>
