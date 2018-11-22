<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>客户等级管理</title>
    <jsp:include page="/common/common.jsp"/>
    <jsp:include page="/common/page.jsp"/>
</head>
<body class="no-skin init-iframe-box" youdao="bind" style="background: white">

<input id="gritter-light" checked="" type="checkbox" class="ace ace-switch ace-switch-5"/>

<div class="iframe-child">
    <div class="page-header">
        <h1>
            客户等级管理
            <small>
                <i class="ace-icon fa fa-angle-double-right"></i>
                维护客户等级
            </small>
        </h1>
    </div>

    <div class="ud-search-container">
        <label for="customer-grade-search">名称</label>
        <input type="text" name="name" id="customer-grade-search" placeholder="请输入关键字" class="text ui-widget-content ui-corner-all">
        <button class="btn btn-primary ud-radius customer-grade-search-btn" formtarget="innerFrame">
            <i class="fa fa-search">&nbsp;&nbsp;</i>搜索
        </button>
    </div>

    <div class="main-content-inner">

    <div class="col-xs-9">
        <div class="table-header">
            客户等级列表&nbsp;&nbsp;
            <a class="green" href="#">
                <i class="ace-icon fa fa-plus-circle orange bigger-130 customer-grade-add"></i>
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
                        折扣率
                    </th>
                    <th class="sorting_disabled" rowspan="1" colspan="1" aria-label=""></th>
                </tr>
                </thead>
                <tbody id="customerGradeList"></tbody>
            </table>

            <div class="row" id="customerGradePage">
            </div>
        </div>

    </div>
    <div class="col-xs-3">
    </div>
</div>
</div>

<div id="dialog-customer-grade-form" style="display: none;">
    <form id="customerGradeForm">
        <table class="table table-bordered dataTable no-footer" role="grid">
            <tr>
                <td style="min-width: 80px;"><label for="customer-grade-name">名称</label></td>
                <input type="hidden" name="id" id="hidden-customer-grade-id"/>
                <td><input type="text" name="name" id="customer-grade-name" value="" class="text form-control"></td>
            </tr>
            <tr>
                <td><label for="customer-grade-dr">折扣率</label></td>
                <td><input type="text" name="dr" id="customer-grade-dr" value="" class="text form-control"></td>
            </tr>
        </table>
    </form>
</div>

<script id="customerGradeListTemplate" type="x-tmpl-mustache">
{{#customerGradeList}}
<tr role="row" class="customer-grade-name odd" data-id="{{id}}"><!--even -->
    <td><a href="#" class="customer-grade-edit" data-id="{{id}}">{{name}}</a></td>
    <td>{{dr}}</td> <!-- 此处套用函数对status做特殊处理 -->
    <td>
        <div class="hidden-sm hidden-xs action-buttons">
            <a class="green customer-grade-edit" href="#" data-id="{{id}}">
                <i class="ace-icon fa fa-pencil bigger-100" title="编辑"></i>
            </a>
            <a class="red customer-grade-delete" href="#" data-id="{{id}}"  data-name="{{name}}" title="删除">
                <i class="glyphicon glyphicon-trash bigger-100"></i></a> &nbsp;
        </div>
    </td>
</tr>
{{/customerGradeList}}
</script>

<script type="application/javascript">
    $(function () {
        //表示 加载初始化的列表, false表示 加载 搜索的列表
        var addAndUpdateLoadMethod = true;

        //列表模板
        var customerGradeListTemplate = $('#customerGradeListTemplate').html();
        Mustache.parse(customerGradeListTemplate); //用 Mustache 解析

        //页面加载
        load();

        //加载
        function load() {
            addAndUpdateLoadMethod = true;
            var url = "/sys/cugr/list.json";
            var pageSize = $("#pageSize").val();
            var pageNo = $("#customerGradePage .pageNo").val() || 1;
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
                        var customerGradeList = _obj.data;
                        var rendered = Mustache.render(customerGradeListTemplate,{customerGradeList: customerGradeList});
                        $("#customerGradeList").html(rendered);
                        bindCustomerGradeClick();
                        //渲染分页
                        renderPage(url, _obj.total, pageNo, pageSize,
                            _obj.total > 0 ? customerGradeList.length : 0, "customerGradePage", callback);
                    } else {
                        showMessage("加载客户等级列表", result.msg, false);
                    }
                }
            });
        }

        //绑定事件
        function bindCustomerGradeClick() {
            $(".customer-grade-delete").click(function (e) {
                e.preventDefault();
                e.stopPropagation();
                var customerGradeId = $(this).attr("data-id");
                var name = $(this).attr("data-name");
                if (confirm("确定要删除客户等级[" + name + "]吗?")) {
                    $.ajax({
                        url: "/sys/cugr/delete.json",
                        data: {
                            customerGradeId: customerGradeId
                        },
                        success: function (result) {
                            if (result.status == 200) {
                                showMessage("删除客户等级[" + name + "]", "操作成功", true);
                                refresh(addAndUpdateLoadMethod, load, search);
                            } else {
                                showMessage("删除客户等级[" + name + "]", result.msg, false);
                            }
                        }
                    });
                }
            });

            $(".customer-grade-edit").click(function (e) {
                e.preventDefault();
                e.stopPropagation();
                var customerGradeId = $(this).attr("data-id");
                $.ajax({
                    url: '/sys/cugr/change.json',
                    data: {customerGradeId: customerGradeId},
                    type: 'POST',
                    success: function (result) {
                        if (result.status == 200) {

                            $("#dialog-customer-grade-form").dialog({
                                model: true,
                                width: 480,
                                title: "编辑客户等级",
                                resizable:false,
                                position: { using:function(pos){
                                    var topOffset = $(this).css(pos).offset().top;
                                    if (topOffset == 0||topOffset>0) {
                                        $(this).css('top', 20);
                                    }
                                }},
                                open: function (event, ui) {
                                    $(".ui-dialog-titlebar-close", $(this).parent()).hide();
                                    $("#customerGradeForm")[0].reset();
                                    $("#hidden-customer-grade-id").val(customerGradeId);
                                    var target = result.data;
                                    if (target) {
                                        $("#customer-grade-name").val(target.name);
                                        $("#customer-grade-dr").val(target.dr);
                                    }
                                },
                                buttons: {
                                    "更新": function (e) {
                                        e.preventDefault();
                                        updateCustomerGrade(false, function (data) {
                                            clearData("customerGradeForm");
                                            $("#dialog-customer-grade-form").dialog("close");
                                        }, function (data) {
                                            showMessage("更新客户等级", data.msg, false);
                                        })
                                    },
                                    "取消": function () {
                                        clearData("customerGradeForm");
                                        $("#dialog-customer-grade-form").dialog("close");
                                    }
                                }
                            });
                        }
                    }
                });
            });
        }

        //添加
        $(".customer-grade-add").click(function (e) {
            e.preventDefault();
            e.stopPropagation();
            $("#dialog-customer-grade-form").dialog({
                model: true,
                width: 480,
                title: "添加客户等级",
                resizable:false,
                position: { using:function(pos){
                    var topOffset = $(this).css(pos).offset().top;
                    if (topOffset == 0||topOffset>0) {
                        $(this).css('top', 20);
                    }
                }},
                open: function (event, ui) {
                    $(".ui-dialog-titlebar-close", $(this).parent()).hide();
                    $("#customerGradeForm")[0].reset();
                },
                buttons: {
                    "添加": function (e) {
                        e.preventDefault();
                        updateCustomerGrade(true, function (data) {
                            $("#dialog-customer-grade-form").dialog("close");
                        }, function (data) {
                            showMessage("新增客户等级", data.msg, false);
                        })
                    },
                    "取消": function () {
                        $("#dialog-customer-grade-form").dialog("close");
                    }
                }
            });
        });

        //搜索
        $(".customer-grade-search-btn").click(function (e) {
            e.preventDefault();
            e.stopPropagation();
            var keyword = $("#customer-grade-search").val();
            if(existNotBlank(keyword)){
                return;
            }
            $("#customerGradePage .pageNo").val(1)
            search();
        });

        //加载 搜索
        function search() {
            addAndUpdateLoadMethod = false;
            var pageSize = $("#pageSize").val();
            var pageNo = $("#customerGradePage .pageNo").val() || 1;

            var keyword = $("#customer-grade-search").val();
            var url = "/sys/cugr/search.json?keyword=" + keyword;
            loadInit(url, search,pageSize, pageNo);
        }

        //更新栏目信息
        function updateCustomerGrade(isCreate, successCallback, failCallback) {
            if (validCustomerGrade()){
                return;
            }
            $.ajax({
                url: isCreate ? "/sys/cugr/save.json" : "/sys/cugr/update.json",
                data: $("#customerGradeForm").serializeArray(),
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
            $("#customerGradePage .pageNo").val(1);
            refresh(addAndUpdateLoadMethod, load, search);
        });

    });
</script>

<script src="/js/valid/base-valid.js"></script>
<script src="/js/valid/customer-grade-valid.js"></script>
<script src="/js/defined/manager.js"></script>
</body>
</html>

