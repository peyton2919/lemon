<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>仓库管理</title>
    <jsp:include page="/common/common.jsp"/>
    <jsp:include page="/common/page.jsp"/>
</head>
<body class="no-skin init-iframe-box" youdao="bind" style="background: white">

<input id="gritter-light" checked="" type="checkbox" class="ace ace-switch ace-switch-5"/>

<div class="iframe-child">
    <div class="page-header">
        <h1>
            运输信息管理
            <small>
                <i class="ace-icon fa fa-angle-double-right"></i>
                维护运输信息
            </small>
        </h1>
    </div>

    <div class="ud-search-container">
        <label for="sp_search">名称</label>
        <input type="text" name="name" id="sp_search" placeholder="请输入关键字" class="text ui-widget-content ui-corner-all">
        <button class="btn btn-primary ud-radius shipping-search-btn popstyle">
            <i class="fa fa-search">&nbsp;&nbsp;</i>搜索
        </button>
    </div>

    <div class="main-content-inner">

    <div class="col-xs-12">
        <div class="table-header">
            运输信息列表&nbsp;&nbsp;
            <a class="green" href="#">
                <i class="ace-icon fa fa-plus-circle orange bigger-130 shipping-add"></i>
            </a>
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
                        名称
                    </th>
                    <th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
                        电话
                    </th>
                    <th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
                        手机
                    </th>
                    <th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
                        QQ
                    </th>
                    <th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
                        位置
                    </th>
                    <th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
                        地址
                    </th>
                    <th class="sorting_disabled" rowspan="1" colspan="1" aria-label=""></th>
                </tr>
                </thead>
                <tbody id="warehouseList"></tbody>
            </table>

            <div class="row" id="warehousePage">
            </div>
        </div>

    </div>
</div>
</div>

<div id="dialog-warehouse-form" style="display: none;">
    <form id="warehouseForm">
        <table class="table table-bordered dataTable no-footer" role="grid">
            <tr>
                <td style="min-width: 80px;"><label for="wh-name">名称</label></td>
                <input type="hidden" name="id" id="wh-id"/>
                <td><input type="text" name="name" id="wh-name" value="" class="text form-control"></td>
            </tr>
            <tr>
                <td style="min-width: 80px;"><label for="wh-tel">电话</label></td>
                <td><input type="text" name="tel" id="wh-tel" value="" class="text form-control"></td>
            </tr>
            <tr>
                <td><label for="wh-phone">手机</label></td>
                <td><input type="text" name="phone" id="wh-phone" value="" class="text form-control"></td>
            </tr>
            <tr>
                <td><label for="wh-qq">QQ</label></td>
                <td><input type="text" name="qq" id="wh-qq" value="" class="text form-control"></td>
            </tr><tr>
                <td><label for="wh-location">位置</label></td>
                <td><input type="text" name="location" id="wh-location" value="" class="text form-control"></td>
            </tr>
            <tr>
                <td><label for="wh-add">地址</label></td>
                <td colspan="3">
                    <textarea rows="4" cols="65" id="wh-add" name="add" class="text form-control"></textarea>
                </td>
            </tr>
            <tr>
                <td><label for="wh-explain">说明</label></td>
                <td colspan="3">
                    <textarea rows="4" cols="65" name="explain" id="wh-explain" class="text form-control"></textarea>
                </td>
            </tr>

        </table>
    </form>
</div>

<div id="dialog-warehouse-detail" style="display: none;">
    <table id="detail-table" class="table table-bordered dataTable no-footer" role="grid"
           aria-describedby="dynamic-table_info" style="font-size:14px">
        <tbody id="warehouseDetail"></tbody>
    </table>
</div>

<script id="warehouseListTemplate" type="x-tmpl-mustache">
{{#warehouseList}}
<tr role="row" class="warehouse-name odd" data-id="{{id}}"><!--even -->
    <td><a href="#" class="warehouse-edit" data-id="{{id}}">{{name}}</a></td>
    <td>{{tel}}</td>
    <td>{{phone}}</td>
    <td>{{qq}}</td>
    <td>{{location}}</td>
    <td>{{add}}</td> <!-- 此处套用函数对status做特殊处理 -->
    <td>
        <div class="hidden-sm hidden-xs action-buttons">
            <a class="green warehouse-edit" href="#" data-id="{{id}}">
                <i class="ace-icon fa fa-pencil bigger-100" title="编辑"></i>
            </a>
            <a class="red warehouse-detail" href="#" data-id="{{id}}">
                <i class="ace-icon glyphicon glyphicon-list-alt bigger-100" title="详细"></i>
            </a>
            <a class="red warehouse-delete" href="#" data-id="{{id}}"  data-name="{{name}}" title="删除">
                <i class="glyphicon glyphicon-trash bigger-100"></i></a> &nbsp;
        </div>
    </td>
</tr>
{{/warehouseList}}
</script>

<script id="warehouseDetailTemplate" type="x-tmpl-mustache">
    <tr role="row" class="wh-detail-name odd" data-id="{{id}}">
        <td style="min-width:100px;">名称</td><td>{{warehouse.name}}</td>
    </tr>
    <tr>
        <td>电话</td><td style="min-width:240px;">{{warehouse.tel}}</td>
    </tr>
    <tr>
        <td>手机</td><td>{{warehouse.phone}}</td>
    </tr>
    <tr>
        <td>QQ</td><td>{{warehouse.qq}}</td>
    </tr>
    <tr>
        <td>地址</td><td>{{warehouse.add}}</td>
    </tr>
    <tr>
        <td>说明</td><td style="word-wrap:break-word ;">{{warehouse.explain}}</td>
    </tr>
</script>

<script src="/js/valid/base-valid.js"></script>
<script src="/js/valid/warehouse-valid.js"></script>

<script type="application/javascript">
    $(function () {
        //数据初始化
        var warehouseList; // 存储栏目列表

        //表示 加载初始化的列表, false表示 加载 搜索的列表
        var addAndUpdateLoadMethod = true;

        //货运类型列表模板
        var warehouseListTemplate = $('#warehouseListTemplate').html();
        Mustache.parse(warehouseListTemplate); //用 Mustache 解析

        var warehouseDetailTemplate = $('#warehouseDetailTemplate').html();
        Mustache.parse(warehouseDetailTemplate); //用 Mustache 解析


        //加载栏目
        loadWarehouse();

        /**
         * 加载
         */
        function loadWarehouse() {
            addAndUpdateLoadMethod = true;
            var url = "/sys/wh/list.json";
            var pageSize = $("#pageSize").val();
            var pageNo = $("#warehousePage .pageNo").val() || 1;
            loadInit(url,loadWarehouse, pageSize, pageNo);
        }

        //初始化列表
        function loadInit(url,callback,pageSize,pageNo) {
            $.ajax({
                url : url,
                data: {
                    pageSize: pageSize,
                    pageNo: pageNo
                },
                success: function (result) {
                    if (result.status == 200) {
                        var _obj = result.data;
                        warehouseList = _obj.data;
                        var rendered = Mustache.render(warehouseListTemplate,
                            {warehouseList: warehouseList});

                        $("#warehouseList").html(rendered);
                        bindWarehouseClick();
                        //渲染分页
                        renderPage(url, _obj.total, pageNo, pageSize, _obj.total > 0 ? warehouseList.length : 0, "warehousePage", callback);
                    } else {
                        showMessage("加载仓库", result.msg, false);
                    }
                }
            });
        }

        //绑定事件
        function bindWarehouseClick() {
            $(".warehouse-delete").click(function (e) {
                e.preventDefault();
                e.stopPropagation();
                var id = $(this).attr("data-id");
                var name = $(this).attr("data-name");
                if (confirm("确定要删除仓库[" + name + "]吗?")) {
                    $.ajax({
                        url: "/sys/wh/delete.json",
                        data: {
                            id: id
                        },
                        success: function (result) {
                            if (result.status == 200) {
                                showMessage("删除仓库[" + name + "]", "操作成功", true);
                                if (addAndUpdateLoadMethod){
                                    loadWarehouse();
                                }else{
                                    loadSearch();
                                }
                            } else {
                                showMessage("删除仓库[" + name + "]", result.msg, false);
                            }
                        }
                    });
                }
            });

            $(".warehouse-edit").click(function (e) {
                e.preventDefault();
                e.stopPropagation();
                var id = $(this).attr("data-id");
                $.ajax({
                    url: '/wh/detail.json',
                    data: {id: id},
                    type: 'POST',
                    success: function (result) {
                        if (result.status == 200) {

                            $("#dialog-warehouse-form").dialog({
                                model: true,
                                width: 580,
                                title: "编辑货运类型",
                                resizable:false,
                                position: { using:function(pos){
                                    var topOffset = $(this).css(pos).offset().top;
                                    if (topOffset == 0||topOffset>0) {
                                        $(this).css('top', 20);
                                    }
                                }},
                                open: function (event, ui) {
                                    $(".ui-dialog-titlebar-close", $(this).parent()).hide();
                                    $("#warehouseForm")[0].reset();
                                    $("#wh-id").val(id);
                                    var targetWarehouse = result.data;
                                    if (targetWarehouse) {
                                        $("#wh-name").val(targetWarehouse.name);
                                        $("#wh-tel").val(targetWarehouse.tel);
                                        $("#wh-phone").val(targetWarehouse.phone);
                                        $("#wh-qq").val(targetWarehouse.qq);
                                        $("#wh-location").val(targetWarehouse.location);
                                        $("#wh-add").val(targetWarehouse.add);
                                        $("#wh-explain").val(targetWarehouse.explain);
                                    }
                                },
                                buttons: {
                                    "更新": function (e) {
                                        e.preventDefault();
                                        updateWarehouse(false, function (data) {
                                            clearData("warehouseForm");
                                            $("#dialog-warehouse-form").dialog("close");
                                        }, function (data) {
                                            showMessage("更新仓库", data.msg, false);
                                        })
                                    },
                                    "取消": function () {
                                        clearData("warehouseForm");
                                        $("#dialog-warehouse-form").dialog("close");
                                    }
                                }
                            });

                        }
                    }
                });
            });

            $(".warehouse-detail").click(function (e) {
                e.preventDefault();
                e.stopPropagation();
                var id = $(this).attr("data-id");
                $.ajax({
                    url:'/wh/detail.json',
                    type:'POST',
                    data:{id:id},
                    success:function (result) {
                        if (result.status == 200){
                            $("#dialog-warehouse-detail").dialog({
                                width:"580",
                                model: true,
                                title: "仓库详细信息",
                                resizable:false,
                                position: { using:function(pos){
                                    var topOffset = $(this).css(pos).offset().top;
                                    if (topOffset == 0||topOffset>0) {
                                        $(this).css('top', 20);
                                    }
                                }},
                                open: function(event, ui) {
                                    $(".ui-dialog-titlebar-close", $(this).parent()).hide();
                                    var warehouse = result.data;

                                    var rendered = Mustache.render(warehouseDetailTemplate, {
                                        warehouse: warehouse});
                                    $("#warehouseDetail").html(rendered);
                                },
                                buttons : {
                                    "取消": function () {
                                        $("#dialog-warehouse-detail").dialog("close");
                                    }
                                }
                            });
                        }
                    }
                });
            });
        }

        //添加
        $(".warehouse-add").click(function (e) {
            e.preventDefault();
            e.stopPropagation();

            $("#warehouseForm")[0].reset();

            $("#dialog-warehouse-form").dialog({
                model: true,
                width: 580,
                title: "添加仓库",
                resizable:false,
                position: { using:function(pos){
                    var topOffset = $(this).css(pos).offset().top;
                    if (topOffset == 0||topOffset>0) {
                        $(this).css('top', 20);
                    }
                }},
                open: function (event, ui) {
                    $(".ui-dialog-titlebar-close", $(this).parent()).hide();
                },
                buttons: {
                    "添加": function (e) {
                        e.preventDefault();
                        updateWarehouse(true, function (data) {
                            $("#dialog-warehouse-form").dialog("close");
                        }, function (data) {
                            showMessage("新增仓库", data.msg, false);
                        })
                    },
                    "取消": function () {
                        $("#dialog-warehouse-form").dialog("close");
                    }
                }
            });
        });

        //搜索
        $(".warehouse-search-btn").click(function (e) {
            e.preventDefault();
            e.stopPropagation();
            var name = $("#wh_search").val();
            if(name == undefined || name == null || name == "" || $.trim(name) == ""){
                return;
            }
            $("#freightTypePage .pageNo").val(1)
            loadSearch();
        });

        //加载 搜索
        function loadSearch() {
            addAndUpdateLoadMethod = false;
            var pageSize = $("#pageSize").val();
            var pageNo = $("#freightTypePage .pageNo").val() || 1;

            var keyword = $("#wh_search").val();
            var url = "/sys/wh/search.json?keyword=" + keyword;
            loadInit(url, loadSearch,pageSize, pageNo);
        }

        //更新栏目信息
        function updateWarehouse(isCreate, successCallback, failCallback) {
            if (validWarehouse()){
                return;
            }
            $.ajax({
                url: isCreate ? "/sys/wh/save.json" : "/sys/wh/update.json",
                data: $("#warehouseForm").serializeArray(),
                type: 'POST',
                success: function (result) {
                    if (result.status == 200) {
                        if (addAndUpdateLoadMethod){
                            loadWarehouse();
                        }else{
                            loadSearch();
                        }
                        if (successCallback) {
                            successCallback(result);
                        }
                    } else {
                        if (failCallback) {
                            failCallback(result);
                        }
                    }
                }
            });
        }

        //绑定展示条数
        //绑定展示条数
        $(".input-sm").change(function () {
            if (addAndUpdateLoadMethod){
                loadWarehouse();
            }else {
                loadSearch();
            }
        });

    });
</script>
<script src="/js/defined/manager.js"></script>
</body>
</html>

