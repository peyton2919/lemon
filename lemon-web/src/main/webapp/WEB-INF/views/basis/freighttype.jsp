<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>货运类型管理</title>
    <jsp:include page="/common/common.jsp"/>
    <jsp:include page="/common/page.jsp"/>
</head>
<body class="no-skin init-iframe-box" youdao="bind" style="background: white">

<input id="gritter-light" checked="" type="checkbox" class="ace ace-switch ace-switch-5"/>

<div class="iframe-child">
    <div class="page-header">
        <h1>
            货运类型管理
            <small>
                <i class="ace-icon fa fa-angle-double-right"></i>
                维护货运类型
            </small>
        </h1>
    </div>

    <div class="ud-search-container">
        <label for="freight-type-search">名称</label>
        <input type="text" name="name" id="freight-type-search" placeholder="请输入关键字" class="text ui-widget-content ui-corner-all">
        <button class="btn btn-primary ud-radius freight-type-search-btn">
            <i class="fa fa-search">&nbsp;&nbsp;</i>搜索
        </button>
    </div>

    <div class="main-content-inner">

    <div class="col-xs-12">
        <div class="ud-title-header">
            货运类型列表&nbsp;&nbsp;
            <a class="green" href="#">
                <i class="ace-icon fa fa-plus-circle orange bigger-130 freight-type-add"></i>
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
                        传真
                    </th>
                    <th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
                        QQ
                    </th>
                    <th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
                        邮箱
                    </th>
                    <th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
                        创建时间
                    </th>
                    <th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
                        更新时间
                    </th>
                    <th class="sorting_disabled" rowspan="1" colspan="1" aria-label=""></th>
                </tr>
                </thead>
                <tbody id="freightTypeList"></tbody>
            </table>

            <div class="row" id="freightTypePage">
            </div>
        </div>

    </div>
</div>
</div>

<div id="dialog-freightType-form" style="display: none;">
    <form id="freightTypeForm">
        <table class="table table-bordered dataTable no-footer" role="grid">
            <tr>
                <td style="min-width: 80px;"><label for="ft-name">名称</label></td>
                <input type="hidden" name="id" id="ft-id"/>
                <td><input type="text" name="name" id="ft-name" value="" class="text form-control"></td>
                <td style="min-width: 80px;"><label for="ft-tel">电话</label></td>
                <td><input type="text" name="tel" id="ft-tel" value="" class="text form-control"></td>
            </tr>
            <tr>
                <td><label for="ft-phone">手机</label></td>
                <td><input type="text" name="phone" id="ft-phone" value="" class="text form-control"></td>
                <td><label for="ft-fax">传真</label></td>
                <td><input type="text" name="fax" id="ft-fax" value="" class="text form-control"></td>
            </tr>
            <tr>
                <td><label for="ft-qq">QQ</label></td>
                <td><input type="text" name="qq" id="ft-qq" value="" class="text form-control"></td>
                <td><label for="ft-email">邮箱</label></td>
                <td><input type="text" name="email" id="ft-email" value="" class="text form-control"></td>
            </tr>
            <tr>
                <td><label for="ft-add">地址</label></td>
                <td colspan="3">
                    <textarea rows="4" cols="65" id="ft-add" name="add" class="text form-control"></textarea>
                </td>
            </tr>
            <tr>
                <td><label for="ft-explain">说明</label></td>
                <td colspan="3">
                    <textarea rows="4" cols="75" name="explain" id="ft-explain" class="text form-control"></textarea>
                </td>
            </tr>

        </table>
    </form>
</div>

<div id="dialog-freightType-detail" style="display: none;">
    <table id="detail-table" class="table table-bordered dataTable no-footer" role="grid"
           aria-describedby="dynamic-table_info" style="font-size:14px">
        <tbody id="freightTypeDetail"></tbody>
    </table>
</div>

<script id="freightTypeListTemplate" type="x-tmpl-mustache">
{{#freightTypeList}}
<tr role="row" class="freight-type-name odd" data-id="{{id}}"><!--even -->
    <td><a href="#" class="freight-type-edit" data-id="{{id}}">{{name}}</a></td>
    <td>{{tel}}</td>
    <td>{{phone}}</td>
    <td>{{fax}}</td>
    <td>{{qq}}</td>
    <td>{{email}}</td>
    <td>{{created}}</td>
    <td>{{updated}}</td> <!-- 此处套用函数对status做特殊处理 -->
    <td>
        <div class="hidden-sm hidden-xs action-buttons">
            <a class="green freight-type-edit" href="#" data-id="{{id}}">
                <i class="ace-icon fa fa-pencil bigger-100" title="编辑"></i>
            </a>
            <a class="red freight-type-detail" href="#" data-id="{{id}}">
                <i class="ace-icon glyphicon glyphicon-list-alt bigger-100" title="详细"></i>
            </a>
            <a class="red freight-type-delete" href="#" data-id="{{id}}"  data-name="{{name}}" title="删除">
                <i class="glyphicon glyphicon-trash bigger-100"></i></a> &nbsp;
        </div>
    </td>
</tr>
{{/freightTypeList}}
</script>

<script id="freightTypeDetailTemplate" type="x-tmpl-mustache">
    <tr role="row" class="ft-detail-name odd" data-id="{{id}}">
        <td style="min-width:100px;">名称</td><td style="min-width:240px;">{{freightType.name}}</td>
        <td style="min-width:100px;" class="ud-td">电话</td><td style="min-width:240px;">{{freightType.tel}}</td>
    </tr>
    <tr>
        <td>手机</td><td>{{freightType.phone}}</td>
        <td>传真</td><td>{{freightType.fax}}</td>
    </tr>
    <tr>
        <td>QQ</td><td>{{freightType.qq}}</td>
        <td>邮箱</td><td>{{freightType.email}}</td>
    </tr>
    <tr>
        <td>创建时间</td><td>{{freightType.created}}</td>
        <td>更新时间</td><td>{{freightType.updated}}</td>
    </tr>
    <tr>
        <td>地址</td><td colspan="3">{{freightType.add}}</td>
    </tr>
    <tr>
        <td>说明</td><td colspan="3" style="word-wrap:break-word ;">{{freightType.explain}}</td>
    </tr>
</script>

<script src="/js/valid/base-valid.js"></script>
<script src="/js/valid/freight-type-valid.js"></script>

<script type="application/javascript">
    $(function () {

        //表示 加载初始化的列表, false表示 加载 搜索的列表
        var addAndUpdateLoadMethod = true;

        //货运类型列表模板
        var freightTypeListTemplate = $('#freightTypeListTemplate').html();
        Mustache.parse(freightTypeListTemplate); //用 Mustache 解析

        var freightTypeDetailTemplate = $('#freightTypeDetailTemplate').html();
        Mustache.parse(freightTypeDetailTemplate); //用 Mustache 解析


        //加载
        load();

        /**
         * 加载
         */
        function load() {
            addAndUpdateLoadMethod = true;
            var url = "/ft/list.json";
            var pageSize = $("#pageSize").val();
            var pageNo = $("#freightTypePage .pageNo").val() || 1;
            loadInit(url,load, pageSize, pageNo);
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
                        var freightTypeList = _obj.data;
                        var rendered = Mustache.render(freightTypeListTemplate,
                            {freightTypeList: freightTypeList});

                        $("#freightTypeList").html(rendered);
                        bindFreightTypeClick();
                        //渲染分页
                        renderPage(url, _obj.total, pageNo, pageSize, _obj.total > 0 ? freightTypeList.length : 0,
                                "freightTypePage", callback);
                    } else {
                        showMessage("加载货运列表", result.msg, false);
                    }
                }
            });
        }

        //绑定事件
        function bindFreightTypeClick() {
            $(".freight-type-delete").click(function (e) {
                e.preventDefault();
                e.stopPropagation();
                var id = $(this).attr("data-id");
                var name = $(this).attr("data-name");
                if (confirm("确定要删除货运类型[" + name + "]吗?")) {
                    $.ajax({
                        url: "/sys/ft/delete.json",
                        data: {
                            id: id
                        },
                        success: function (result) {
                            if (result.status == 200) {
                                showMessage("删除货运类型[" + name + "]", "操作成功", true);
                                refresh(addAndUpdateLoadMethod, load, search);
                            } else {
                                showMessage("删除货运类型[" + name + "]", result.msg, false);
                            }
                        }
                    });
                }
            });

            $(".freight-type-edit").click(function (e) {
                e.preventDefault();
                e.stopPropagation();
                var id = $(this).attr("data-id");
                $.ajax({
                    url: '/ft/detail.json',
                    data: {id: id},
                    type: 'POST',
                    success: function (result) {
                        if (result.status == 200) {

                            $("#dialog-freightType-form").dialog({
                                model: true,
                                width: 680,
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
                                    $("#freightTypeForm")[0].reset();
                                    $("#ft-id").val(id);
                                    var targetFreightType = result.data;
                                    if (targetFreightType) {
                                        $("#ft-name").val(targetFreightType.name);
                                        $("#ft-tel").val(targetFreightType.tel);
                                        $("#ft-phone").val(targetFreightType.phone);
                                        $("#ft-fax").val(targetFreightType.fax);
                                        $("#ft-qq").val(targetFreightType.qq);
                                        $("#ft-email").val(targetFreightType.email);
                                        $("#ft-add").val(targetFreightType.add);
                                        $("#ft-explain").val(targetFreightType.explain);
                                    }
                                },
                                buttons: {
                                    "更新": function (e) {
                                        e.preventDefault();
                                        updateFreightType(false, function (data) {
                                            clearData("freightTypeForm");
                                            $("#dialog-freightType-form").dialog("close");
                                        }, function (data) {
                                            showMessage("更新货运类型", data.msg, false);
                                        })
                                    },
                                    "取消": function () {
                                        clearData("freightTypeForm");
                                        $("#dialog-freightType-form").dialog("close");
                                    }
                                }
                            });

                        }
                    }
                });
            });

            $(".freight-type-detail").click(function (e) {
                e.preventDefault();
                e.stopPropagation();
                var id = $(this).attr("data-id");
                $.ajax({
                    url:'/ft/detail.json',
                    type:'POST',
                    data:{id:id},
                    success:function (result) {
                        if (result.status == 200){
                            $("#dialog-freightType-detail").dialog({
                                width:"700",
                                model: true,
                                title: "货运类型详细信息",
                                resizable:false,
                                position: { using:function(pos){
                                    var topOffset = $(this).css(pos).offset().top;
                                    if (topOffset == 0||topOffset>0) {
                                        $(this).css('top', 20);
                                    }
                                }},
                                open: function(event, ui) {
                                    $(".ui-dialog-titlebar-close", $(this).parent()).hide();
                                    var freightType = result.data;

                                    var rendered = Mustache.render(freightTypeDetailTemplate, {
                                        freightType: freightType});
                                    $("#freightTypeDetail").html(rendered);
                                },
                                buttons : {
                                    "取消": function () {
                                        $("#dialog-freightType-detail").dialog("close");
                                    }
                                }
                            });
                        }
                    }
                });
            });
        }

        //添加
        $(".freight-type-add").click(function (e) {
            e.preventDefault();
            e.stopPropagation();

            $("#dialog-freightType-form").dialog({
                model: true,
                width: 680,
                title: "添加货运类型",
                resizable:false,
                position: { using:function(pos){
                    var topOffset = $(this).css(pos).offset().top;
                    if (topOffset == 0||topOffset>0) {
                        $(this).css('top', 20);
                    }
                }},
                open: function (event, ui) {
                    $(".ui-dialog-titlebar-close", $(this).parent()).hide();
                    $("#freightTypeForm")[0].reset();
                },
                buttons: {
                    "添加": function (e) {
                        e.preventDefault();
                        updateFreightType(true, function (data) {
                            $("#dialog-freightType-form").dialog("close");
                        }, function (data) {
                            showMessage("新增货运类型", data.msg, false);
                        })
                    },
                    "取消": function () {
                        $("#dialog-freightType-form").dialog("close");
                    }
                }
            });
        });

        //搜索
        $(".freight-type-search-btn").click(function (e) {
            e.preventDefault();
            e.stopPropagation();
            var keyword = $("#freight-type-search").val();
            if(existNotBlank(keyword)){
                return;
            }
            $("#freightTypePage .pageNo").val(1)
            search();
        });

        //加载 搜索
        function search() {
            addAndUpdateLoadMethod = false;
            var pageSize = $("#pageSize").val();
            var pageNo = $("#freightTypePage .pageNo").val() || 1;

            var keyword = $("#freight-type-search").val();
            var url = "/ft/search.json?keyword=" + keyword;
            loadInit(url, search,pageSize, pageNo);
        }

        //更新栏目信息
        function updateFreightType(isCreate, successCallback, failCallback) {
            if (validFreightType()){
                return;
            }
            $.ajax({
                url: isCreate ? "/sys/ft/save.json" : "/sys/ft/update.json",
                data: $("#freightTypeForm").serializeArray(),
                type: 'POST',
                success: function (result) {
                    if (result.status == 200) {
                        if (successCallback) {
                            successCallback(result);
                        }
                        refresh(addAndUpdateLoadMethod, load, search);
                    } else {
                        if (failCallback) {
                            failCallback(result);
                        }
                    }
                }
            });
        }

        //绑定展示条数
        $(".input-sm").change(function () {
            $("#freightTypePage .pageNo").val(1);
            refresh(addAndUpdateLoadMethod, load, search);
        });

    });
</script>
<script src="/js/defined/manager.js"></script>
</body>
</html>

