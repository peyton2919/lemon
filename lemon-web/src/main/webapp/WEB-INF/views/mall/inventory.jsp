<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>出入库管理</title>
    <jsp:include page="/common/common.jsp"/>
    <jsp:include page="/common/page.jsp"/>
</head>
<body class="no-skin init-iframe-box" youdao="bind" style="background: white">

<input id="gritter-light" checked="" type="checkbox" class="ace ace-switch ace-switch-5"/>

<div class="iframe-child">
    <div class="page-header">
        <h1>
            主库存管理
            <small>
                <i class="ace-icon fa fa-angle-double-right"></i>
                维护主库存
            </small>
        </h1>
    </div>

    <div class="ud-search-container">
        <form id="inventorySearchForm">
        <label>仓库:</label><select id="warehouseSelectId" name="warId"></select>
            <label>开始时间:</label><input type="text" name="beginTime" id="beginTime" placeholder="开始时间要小于结束时间" readonly>
            <label>结束时间:</label><input type="text" name="endTime" id="endTime" placeholder="结束时间要大于开始时间" readonly>
        <label for="storage-search">商品名称</label>
        <input type="text" name="comName" id="storage-search" placeholder="请输入商品关键字" class="text ui-widget-content ui-corner-all">

        <button class="btn btn-primary ud-radius inventory-search-btn">
            <i class="fa fa-search">&nbsp;&nbsp;</i>搜索
        </button>
        </form>
    </div>

    <div class="main-content-inner">
        <div class="col-xs-12">
            <div class="table-header">
                主库存列表
            </div>

            <div id="dynamic-table_wrapper" class="dataTables_wrapper form-inline no-footer">
                <div class="row">
                    <div class="col-xs-6">
                        <div class="dataTables_length" id="dynamic-table_length"><label>
                            展示
                            <select id="pageSize" name="dynamic-table_length" aria-controls="dynamic-table" class="form-control input-sm">
                                <option value="10">10</option>
                                <option value="25">25</option>
                                <option value="50">50</option>
                                <option value="100">100</option>
                            </select> 条记录 </label>
                        </div>
                    </div>
                </div>

                <table id="dynamic-table" class="table table-striped table-bordered table-hover dataTable no-footer" role="grid"
                       aria-describedby="dynamic-table_info" style="font-size:14px">
                    <thead>
                    <tr role="row">
                        <th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
                            商品名称
                        </th>
                        <th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
                            数量
                        </th>
                        <th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
                            仓库名称
                        </th>
                        <th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
                            创建时间
                        </th>
                        <th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1"> </th>
                    </tr>
                    </thead>
                    <tbody id="inventoryList"></tbody>
                </table>
                <div class="row" id="inventoryPage">
                </div>
            </div>
        </div>
    </div>

</div>

<div id="dialog-commodity-main-img" style="display: none; text-align: center">
    <img id="dialog-main-img" src="" width="400" height="400">
</div>

<div id="dialog-storage-detail" style="display: none;">
    <table class="table table-bordered" role="grid">
        <thead>
        <tr role="row">
            <th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
                颜色
            </th>
            <th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
                数量
            </th>
        </tr>
        </thead>
        <tbody id="storageDetailList"></tbody>
        <thead>
            <tr role="row">
                <td colspan="2">
                    <label style="color: red;font-weight: bold; font-size: larger; float: right; padding-right: 20px;">
                    总计:&nbsp; <i id="storage-detail-total"></i>&nbsp;&nbsp; 个
                </label></td>
            </tr>
        </thead>
    </table>
</div>

<script id="inventoryListTemplate" type="x-tmpl-mustache">
{{#inventoryList}}
<tr role="row" class="inventory-name odd" data-id="{{id}}"><!--even -->
    <td><a href="#" class="commodity-detail" data-id="{{comId}}">{{comName}}</a></td>
    <td><a href="#" class="inventory-detail" data-total="{{total}}" data-detail="{{detail}}">{{total}}</a></td>
    <td>{{warName}}</td>
    <td>{{created}}</td><!-- 此处套用函数对status做特殊处理 -->
    <td>
        <div class="hidden-sm hidden-xs action-buttons">
            <a class="blue inventory-storage-detail" href="#" data-comId="{{comId}}" data-warId="{{warId}}">
                <i class="ace-icon glyphicon glyphicon-list-alt bigger-110" title="详细出入库"></i>
            </a>
        </div>
    </td>
</tr>
{{/inventoryList}}
</script>

<script src="/js/valid/base-valid.js"></script>

<script type="application/javascript">
    $(function () {
        //仓库Map
        var warehouseMap = {};
        //颜色Map
        var colorMap = {};
        //表示 加载初始化的列表, false表示 加载 搜索的列表
        var addAndUpdateLoadMethod = true;

        var formData;
        // datetimeUtil("#beginTime");
        // datetimeUtil("#endTime");
        $("#beginTime").datetime();
        $("#endTime").datetime();

        //列表模板
        var inventoryListTemplate = $('#inventoryListTemplate').html();
        Mustache.parse(inventoryListTemplate); //用 Mustache 解析

        //加载
        load();

        function load() {
            $.ajax({
                url : "/sys/stor/obtainwarehouse.json",
                async:false,
                success : function (res) {
                    if (res.status == 200){
                        var warehouseList = res.data;
                        var str = '<option value="-1">---选择仓库---</option>';
                        $(warehouseList).each(function (i,warehouse) {
                            warehouseMap[warehouse.id] = warehouse;
                            str += Mustache.render('<option value="{{id}}">{{name}}</option>',
                                {id:warehouse.id,name:warehouse.name});
                        });
                        $("#warehouseSelectId").html(str);
                    }else {
                        showMessage("仓库提示", res.msg, false);
                    }
                }
            });

            $.ajax({
                url :'/color/obtaincolor.json',
                success : function (res) {
                    if (res.status == 200){
                        var colorList = res.data;
                        $(colorList).each(function (i,color) {
                            colorMap[color.id] = color;
                        });
                    }else {
                        showMessage("颜色提示", res.msg, false);
                    }
                }
            });
            loadInventory();
        }
        //加载页面
        function loadInventory() {
            addAndUpdateLoadMethod = true;
            var url = "/sys/inve/list.json";
            var pageSize = $("#pageSize").val();
            var pageNo = $("#inventoryPage .pageNo").val() || 1;
            formData = new FormData();
            formData.append("pageSize",pageSize);
            formData.append("pageNo",pageNo);

            loadInit(url, loadInventory, pageSize, pageNo);
        }
        //搜索
        $(".inventory-search-btn").click(function (e) {
            e.preventDefault();
            e.stopPropagation();
            $("#inventoryPage .pageNo").val(1);
            loadSearch();
        });
        //加载搜索
        function loadSearch() {
            addAndUpdateLoadMethod = false;
            var url = "/sys/inve/search.json";
            var pageSize = $("#pageSize").val();
            var pageNo = $("#inventoryPage .pageNo").val() || 1;
            formData = new FormData($("#inventorySearchForm")[0]);
            formData.append("pageSize",pageSize);
            formData.append("pageNo",pageNo);
            loadInit(url, loadSearch,pageSize, pageNo);
        }
        //初始化列表
        function loadInit(url, callback, pageSize, pageNo) {
            $.ajax({
                url: url,
                data: formData,
                type: 'post',
                contentType: false,
                processData: false,
                success: function (result) {
                    if (result.status == 200) {
                        var inventoryList = result.data.data;
                        var rendered = Mustache.render(inventoryListTemplate,
                            {inventoryList: inventoryList,
                                "warName" : function () {
                                    return warehouseMap[this.warId].name;
                                }
                            });
                        $("#inventoryList").html(rendered);
                        bindStorageClick();
                        //渲染分页
                        renderPage(url, result.data.total, pageNo, pageSize,result.data.total > 0 ?
                            inventoryList.length : 0, "inventoryPage", callback);
                    } else {
                        showMessage("加载主库存列表", result.msg, false);
                    }
                }
            });
        }

        // 绑定部门点击事件
        function bindStorageClick() {

            $(".inventory-detail").click(function (e) {
                e.preventDefault();
                e.stopPropagation();
                var detail = $(this).attr("data-detail");
                var total = $(this).attr("data-total");
                $("#dialog-storage-detail").dialog({
                    width: 450,
                    model: true,
                    title: "商品图片",
                    open: function (event, ui) {
                        $(".ui-dialog-titlebar-close", $(this).parent()).hide();
                        var first = detail.split(",");
                        var length = first.length;
                        var rendered = "";
                        for(var i = 0; i < length; i++){
                            var second = first[i].split(":");
                            rendered += Mustache.render('<tr><td>{{name}}</td><td>{{quantity}}</td></tr>',
                                {name:colorMap[second[0]].name , quantity : second[1]});
                        }
                        $("#storageDetailList").html(rendered);
                        $("#storage-detail-total").html(total);
                    },
                    buttons: {
                        "取消": function () {
                            $("#dialog-storage-detail").dialog("close");
                        }
                    }
                });
            });

            $(".commodity-detail").click(function(e){
                e.preventDefault();
                e.stopPropagation();
                var commodityId = $(this).attr("data-id");
                var url = '/sys/comm/obtainmainimg.json';
                $.ajax({
                    url:url,
                    data:{id:commodityId},
                    success:function (res) {
                        if (res.status == 200) {
                            $("#dialog-commodity-main-img").dialog({
                                width: 450,
                                model:true,
                                title:"商品图片",
                                open:function (event,ui) {
                                    $(".ui-dialog-titlebar-close", $(this).parent()).hide();
                                    $("#dialog-main-img").attr("src",res.data.mainImg);
                                },
                                buttons:{
                                    "取消": function () {
                                        $("#dialog-commodity-main-img").dialog("close");
                                    }
                                }
                            });
                        }else {
                            showMessage("商品图片提示", res.msg, false);
                        }
                    }
                });
            });

            $(".inventory-storage-detail").click(function (e) {
                e.preventDefault();
                e.stopPropagation();
                var commodityId = $(this).attr("data-comId");
                var warehouseId = $(this).attr("data-warId");
               //todo
            });
        }
        //记录改变事件
        $(".input-sm").change(function () {
            $("#inventoryPage .pageNo").val(1);
            refresh(addAndUpdateLoadMethod, loadInventory, loadSearch);
        });
    });
</script>

<script src="/js/defined/manager.js"></script>

</body>
</html>
