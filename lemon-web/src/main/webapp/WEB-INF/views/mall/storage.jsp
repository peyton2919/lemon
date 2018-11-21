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
            出入库管理
            <small>
                <i class="ace-icon fa fa-angle-double-right"></i>
                维护出入库
            </small>
        </h1>
    </div>

    <div class="ud-search-container">
        <form id="storageSearchForm">
        <label>仓库:</label><select id="warehouseSelectId" name="warId"></select>
        <label>出入库方向:</label>
        <select id="selectDirection" name="direction">
            <option value="-1">---选择方向---</option>
            <option value="0">入库</option>
            <option value="1">出库</option>
        </select>
        <label>开始时间:</label><input type="text" name="beginTime" id="beginTime" placeholder="开始时间要小于结束时间" readonly>
        <label>结束时间:</label><input type="text" name="endTime" id="endTime" placeholder="结束时间要大于开始时间" readonly>
        <label for="storage-search">商品名称</label>
        <input type="text" name="comName" id="storage-search" placeholder="请输入商品关键字" class="text ui-widget-content ui-corner-all">

        <button class="btn btn-primary ud-radius storage-search-btn">
            <i class="fa fa-search">&nbsp;&nbsp;</i>搜索
        </button>
        </form>
    </div>

    <div class="main-content-inner">
        <div class="col-xs-12">
            <div class="table-header">
                出入库列表
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
                            图片
                        </th>
                        <th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
                            商品名称
                        </th>
                        <th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
                            数量
                        </th>
                        <th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
                            出入库状态
                        </th>
                        <th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
                            仓库名称
                        </th>
                        <th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
                            员工名称
                        </th>
                        <th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
                            创建时间
                        </th>
                        <th class="sorting_disabled" rowspan="1" colspan="1" aria-label=""></th>
                    </tr>
                    </thead>
                    <tbody id="storageList"></tbody>
                </table>
                <div class="row" id="storagePage">
                </div>
            </div>
        </div>
    </div>

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
                    &nbsp;&nbsp;出入库方式:&nbsp;&nbsp;<i class="red" id="storage-detail-direction"></i>
                    <label style="color: red;font-weight: bold; font-size: larger; float: right; padding-right: 20px;">
                    总计:&nbsp; <i id="storage-detail-total"></i>&nbsp;&nbsp; 个
                </label></td>
            </tr>
        </thead>
    </table>
</div>

<script id="storageDetailListTemplate" type="x-tmpl-mustache">
{{#storageDetailList}}
<tr role="row" class="storage-detail-name odd" data-id="{{colId}}"><!--even -->
 <td>{{colName}}</td>
 <td>{{quantity}}</td>
 </tr>
{{/storageDetailList}}
</script>

<script id="storageListTemplate" type="x-tmpl-mustache">
{{#storageList}}
<tr role="row" class="storage-name odd" data-id="{{id}}"><!--even -->
    <td><a href="#" class="storage-edit" data-id="{{id}}" data-com-id="{{comId}}"><img src="{{imageUrl}}" width="80" height="80"></a></td>
    <td>{{comName}}</td>
    <td>{{total}}</td>
    <td>{{#showDirection}}{{direction}}{{/showDirection}}</td>
    <td>{{warName}}</td>
    <td>{{empName}}</td>
    <td>{{created}}</td><!-- 此处套用函数对status做特殊处理 -->
    <td>
        <div class="hidden-sm hidden-xs action-buttons">
            <a class="green storage-add" href="#" data-id="{{comId}}">
                <i class="ace-icon fa fa-plus orange bigger-110" title="添加"></i>
            </a>&nbsp;
            <a class="green storage-edit" href="#" data-id="{{id}}" data-com-id="{{comId}}">
                <i class="ace-icon fa fa-pencil bigger-110" title="编辑"></i>
            </a>&nbsp;

            <a class="blue storage-detail" href="#" data-id="{{id}}" data-direction="{{direction}}">
                <i class="ace-icon glyphicon glyphicon-list-alt bigger-110" title="详细"></i>
            </a>&nbsp;
            <a class="red storage-delete" href="#" data-id="{{id}}"  data-name="{{comName}}" title="删除">
                <i class="glyphicon glyphicon-trash bigger-110"></i></a> &nbsp;
        </div>
    </td>
</tr>
{{/storageList}}
</script>

<script src="/js/valid/base-valid.js"></script>

<script type="application/javascript">

    $(function () {
        //表示 加载初始化的列表, false表示 加载 搜索的列表
        var addAndUpdateLoadMethod = true;

        var formData;

        // datetimeUtil("#beginTime");
        // datetimeUtil("#endTime");
        $("#beginTime").datetime();
        $("#endTime").datetime();

        //类目列表模板
        var storageListTemplate = $('#storageListTemplate').html();
        Mustache.parse(storageListTemplate); //用 Mustache 解析

        var storageDetailListTemplate = $('#storageDetailListTemplate').html();
        Mustache.parse(storageDetailListTemplate); //用 Mustache 解析

        //加载
        load();

        function load() {
            var url = "/sys/stor/obtainwarehouse.json";
            $.ajax({
                url :url,
                async:false,
                success : function (res) {
                    if (res.status == 200){
                        var warehouseList = res.data;
                        var str = '<option value="-1">---选择仓库---</option>';
                        $(warehouseList).each(function (i,warehouse) {
                            str += Mustache.render('<option value="{{id}}">{{name}}</option>',
                                {id:warehouse.id,name:warehouse.name});
                        });
                        $("#warehouseSelectId").html(str);
                    }else {
                        showMessage("提示", res.msg, false);
                    }
                }
            });
            loadStorage();
        }
        //加载页面
        function loadStorage() {
            addAndUpdateLoadMethod = true;
            var url = "/sys/stor/list.json";
            var pageSize = $("#pageSize").val();
            var pageNo = $("#storagePage .pageNo").val() || 1;
            formData = new FormData();
            formData.append("pageSize",pageSize);
            formData.append("pageNo",pageNo);

            loadInit(url, loadStorage, pageSize, pageNo);

        }

        //搜索
        $(".storage-search-btn").click(function (e) {
            e.preventDefault();
            e.stopPropagation();
            $("#storagePage .pageNo").val(1);
            search();
        });

        //加载搜索
        function search() {
            addAndUpdateLoadMethod = false;
            var url = "/sys/stor/search.json";
            var pageSize = $("#pageSize").val();
            var pageNo = $("#storagePage .pageNo").val() || 1;
            formData = new FormData($("#storageSearchForm")[0]);
            formData.append("pageSize",pageSize);
            formData.append("pageNo",pageNo);
            loadInit(url, search,pageSize, pageNo);
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
                        var storageList = result.data.data;

                        var rendered = Mustache.render(storageListTemplate,
                            {storageList: storageList,
                                "showDirection" : function () {
                                    return function (text,render) {
                                        var tDirection = render(text);
                                        if (tDirection == 0){
                                            return "<span class='label label-lg label-purple'>入库</span>";
                                        }else if (tDirection == 1) {
                                            return "<span class='label label-lg label-warning'>出库</span>";
                                        }
                                        return "<span class='label label-lg label-grey'>未知</span>";
                                    }
                                }
                            });
                        $("#storageList").html(rendered);
                        bindStorageClick();
                        //渲染分页
                        renderPage(url, result.data.total, pageNo, pageSize,result.data.total > 0 ?
                            storageList.length : 0, "storagePage", callback);
                    } else {
                        showMessage("加载出入库列表", result.msg, false);
                    }
                }
            });
        }

        // 绑定部门点击事件
        function bindStorageClick() {

            $(".storage-delete").click(function (e) {
                e.preventDefault();
                e.stopPropagation();
                var storageId = $(this).attr("data-id");
                var commodityName = $(this).attr("data-name");
                if (confirm("确定要删除商品[" + commodityName + "]吗?")) {
                    $.ajax({
                        url: "/sys/stor/delete.json",
                        data: {
                            id: storageId
                        },
                        type : 'post',
                        success: function (result) {
                            if (result.status == 200) {
                                showMessage("删除出入库[" + commodityName + "]", "操作成功", true);
                                refresh(addAndUpdateLoadMethod, loadStorage, search);
                            } else {
                                showMessage("删除出入库[" + commodityName + "]", result.msg, false);
                            }
                        }
                    });
                }
            });

            $(".storage-edit").click(function (e) {
                e.preventDefault();
                e.stopPropagation();
                var id = $(this).attr("data-id");
                var commodityId = $(this).attr("data-com-id");
                window.location.href = '/sys/stor/change.page?id='+id +'&commodityId=' + commodityId;
            });

            $(".storage-detail").click(function(e){
                e.preventDefault();
                e.stopPropagation();
                var storageId = $(this).attr("data-id");
                var direction = $(this).attr("data-direction");
                var url = '/sys/stor/obtainstoragedetail.json';
                $.ajax({
                    url:url,
                    data:{storageId:storageId},
                    type:'post',
                    success:function (res) {
                        if (res.status == 200) {
                            $("#dialog-storage-detail").dialog({
                                width: 580,
                                model:true,
                                title:"出入库明细",
                                open:function (event,ui) {
                                    $(".ui-dialog-titlebar-close", $(this).parent()).hide();
                                    var storageDetailList = res.data.storageDetails;
                                    var total = res.data.total;

                                    var rendered = Mustache.render(storageDetailListTemplate,
                                        {storageDetailList : storageDetailList}
                                    );
                                    $("#storageDetailList").html(rendered);
                                    $("#storage-detail-direction").html(direction == 0 ? '入库':'出库');
                                    $("#storage-detail-total").html(total);
                                },
                                buttons:{
                                    "取消": function () {
                                        $("#dialog-storage-detail").dialog("close");
                                    }
                                }
                            });
                        }else {
                            showMessage("出入库提示", res.msg, false);
                        }
                    }
                });

            });

            $(".storage-add").click(function (e) {
                e.preventDefault();
                e.stopPropagation();
                var commodityId = $(this).attr("data-id");
                window.location.href = '/sys/stor/change.page?commodityId=' + commodityId;
            });
        }

        //添加点击 事件
        $(".storage-add").click(function () {
            window.location.href = '/sys/stor/change.page';
        });

        $(".input-sm").change(function () {
            $("#storagePage .pageNo").val(1);
            refresh(addAndUpdateLoadMethod, loadStorage, search);
        });
    });
</script>

<script src="/js/defined/manager.js"></script>

</body>
</html>
