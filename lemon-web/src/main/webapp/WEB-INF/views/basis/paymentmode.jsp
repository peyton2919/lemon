<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>付款方式管理</title>
    <jsp:include page="/common/common.jsp"/>
    <jsp:include page="/common/page.jsp"/>
</head>
<body class="no-skin init-iframe-box" youdao="bind" style="background: white">

<input id="gritter-light" checked="" type="checkbox" class="ace ace-switch ace-switch-5"/>

<div class="iframe-child">
    <div class="page-header">
        <h1>
            付款方式管理
            <small>
                <i class="ace-icon fa fa-angle-double-right"></i>
                维护付款方式
            </small>
        </h1>
    </div>

    <div class="ud-search-container">
        <label for="payment-mode-search">名称</label>
        <input type="text" name="name" id="payment-mode-search" placeholder="请输入关键字" class="text ui-widget-content ui-corner-all">
        <button class="btn btn-primary ud-radius payment-mode-search-btn" formtarget="innerFrame">
            <i class="fa fa-search">&nbsp;&nbsp;</i>搜索
        </button>
    </div>

    <div class="main-content-inner">

    <div class="col-xs-9">
        <div class="table-header">
            付款方式列表&nbsp;&nbsp;
            <a class="green" href="#">
                <i class="ace-icon fa fa-plus-circle orange bigger-130 payment-mode-add"></i>
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
                        说明
                    </th>
                    <th class="sorting_disabled" rowspan="1" colspan="1" aria-label=""></th>
                </tr>
                </thead>
                <tbody id="paymentModeList"></tbody>
            </table>

            <div class="row" id="paymentModePage">
            </div>
        </div>

    </div>
    <div class="col-xs-3">
    </div>
</div>
</div>

<div id="dialog-payment-mode-form" style="display: none;">
    <form id="paymentModeForm">
        <table class="table table-bordered dataTable no-footer" role="grid">
            <tr>
                <td style="min-width: 80px;"><label for="payment-mode-name">名称</label></td>
                <input type="hidden" name="id" id="hidden-payment-mode-id"/>
                <td><input type="text" name="name" id="payment-mode-name" class="text form-control"></td>
            </tr>
            <tr>
                <td><label for="payment-mode-explain">说明</label></td>
                <td><input type="text" name="explain" id="payment-mode-explain" class="text form-control"></td>
            </tr>
        </table>
    </form>
</div>

<script id="paymentModeListTemplate" type="x-tmpl-mustache">
{{#paymentModeList}}
<tr role="row" class="payment-mode-name odd" data-id="{{id}}"><!--even -->
    <td><a href="#" class="payment-mode-edit" data-id="{{id}}">{{name}}</a></td>
    <td>{{explain}}</td> <!-- 此处套用函数对status做特殊处理 -->
    <td>
        <div class="hidden-sm hidden-xs action-buttons">
            <a class="green payment-mode-edit" href="#" data-id="{{id}}">
                <i class="ace-icon fa fa-pencil bigger-100" title="编辑"></i>
            </a>
            <a class="red payment-mode-delete" href="#" data-id="{{id}}"  data-name="{{name}}" title="删除">
                <i class="glyphicon glyphicon-trash bigger-100"></i></a> &nbsp;
        </div>
    </td>
</tr>
{{/paymentModeList}}
</script>

<script type="application/javascript">
    $(function () {
        //表示 加载初始化的列表, false表示 加载 搜索的列表
        var addAndUpdateLoadMethod = true;

        //列表模板
        var paymentModeListTemplate = $('#paymentModeListTemplate').html();
        Mustache.parse(paymentModeListTemplate); //用 Mustache 解析

        //页面加载
        load();

        //加载
        function load() {
            addAndUpdateLoadMethod = true;
            var url = "/sys/pamo/list.json";
            var pageSize = $("#pageSize").val();
            var pageNo = $("#paymentModePage .pageNo").val() || 1;
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

                        var paymentModeList = _obj.data;
                        var rendered = Mustache.render(paymentModeListTemplate,{paymentModeList: paymentModeList});
                        $("#paymentModeList").html(rendered);
                        bindPaymentModeClick();
                        //渲染分页
                        renderPage(url, _obj.total, pageNo, pageSize,
                            _obj.total > 0 ? paymentModeList.length : 0, "paymentModePage", callback);
                    } else {
                        showMessage("加载客户等级列表", result.msg, false);
                    }
                }
            });
        }

        //绑定事件
        function bindPaymentModeClick() {
            $(".payment-mode-delete").click(function (e) {
                e.preventDefault();
                e.stopPropagation();
                var paymentModeId = $(this).attr("data-id");
                var name = $(this).attr("data-name");
                if (confirm("确定要删除客户等级[" + name + "]吗?")) {
                    $.ajax({
                        url: "/sys/pamo/delete.json",
                        data: {
                            paymentModeId: paymentModeId
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

            $(".payment-mode-edit").click(function (e) {
                e.preventDefault();
                e.stopPropagation();
                var paymentModeId = $(this).attr("data-id");
                $.ajax({
                    url: '/sys/pamo/change.json',
                    data: {paymentModeId: paymentModeId},
                    type: 'POST',
                    success: function (result) {
                        if (result.status == 200) {

                            $("#dialog-payment-mode-form").dialog({
                                model: true,
                                width: 480,
                                title: "编辑付款方式",
                                resizable:false,
                                position: { using:function(pos){
                                    var topOffset = $(this).css(pos).offset().top;
                                    if (topOffset == 0||topOffset>0) {
                                        $(this).css('top', 20);
                                    }
                                }},
                                open: function (event, ui) {
                                    $(".ui-dialog-titlebar-close", $(this).parent()).hide();
                                    $("#paymentModeForm")[0].reset();
                                    $("#hidden-payment-mode-id").val(paymentModeId);
                                    var target = result.data;
                                    if (target) {
                                        $("#payment-mode-name").val(target.name);
                                        $("#payment-mode-explain").val(target.explain);
                                    }
                                },
                                buttons: {
                                    "更新": function (e) {
                                        e.preventDefault();
                                        updatePaymentMode(false, function (data) {
                                            clearData("paymentModeForm");
                                            $("#dialog-payment-mode-form").dialog("close");
                                        }, function (data) {
                                            showMessage("更新付款方式", data.msg, false);
                                        })
                                    },
                                    "取消": function () {
                                        clearData("paymentModeForm");
                                        $("#dialog-payment-mode-form").dialog("close");
                                    }
                                }
                            });
                        }
                    }
                });
            });
        }

        //添加
        $(".payment-mode-add").click(function (e) {
            e.preventDefault();
            e.stopPropagation();
            $("#dialog-payment-mode-form").dialog({
                model: true,
                width: 480,
                title: "添加付款方式",
                resizable:false,
                position: { using:function(pos){
                    var topOffset = $(this).css(pos).offset().top;
                    if (topOffset == 0||topOffset>0) {
                        $(this).css('top', 20);
                    }
                }},
                open: function (event, ui) {
                    $(".ui-dialog-titlebar-close", $(this).parent()).hide();
                    $("#paymentModeForm")[0].reset();
                },
                buttons: {
                    "添加": function (e) {
                        e.preventDefault();
                        updatePaymentMode(true, function (data) {
                            $("#dialog-payment-mode-form").dialog("close");
                        }, function (data) {
                            showMessage("新增付款方式", data.msg, false);
                        })
                    },
                    "取消": function () {
                        $("#dialog-payment-mode-form").dialog("close");
                    }
                }
            });
        });

        //搜索
        $(".payment-mode-search-btn").click(function (e) {
            e.preventDefault();
            e.stopPropagation();
            var keyword = $("#payment-mode-search").val();
            if(existNotBlank(keyword)){
                return;
            }
            $("#paymentModePage .pageNo").val(1);
            search();
        });

        //加载 搜索
        function search() {
            addAndUpdateLoadMethod = false;
            var pageSize = $("#pageSize").val();
            var pageNo = $("#paymentModePage .pageNo").val() || 1;

            var keyword = $("#payment-mode-search").val();
            var url = "/sys/pamo/search.json?keyword=" + keyword;
            loadInit(url, search,pageSize, pageNo);
        }

        //更新栏目信息
        function updatePaymentMode(isCreate, successCallback, failCallback) {
            if (validPaymentMode()){
                return;
            }
            $.ajax({
                url: isCreate ? "/sys/pamo/save.json" : "/sys/pamo/update.json",
                data: $("#paymentModeForm").serializeArray(),
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
            $("#paymentModePage .pageNo").val(1);
            refresh(addAndUpdateLoadMethod, load, search);
        });

    });
</script>

<script src="/js/valid/base-valid.js"></script>
<script src="/js/valid/payment-mode-valid.js"></script>
<script src="/js/defined/manager.js"></script>
</body>
</html>

