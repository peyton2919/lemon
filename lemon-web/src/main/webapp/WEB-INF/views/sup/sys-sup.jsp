<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>供应商管理</title>
    <jsp:include page="/common/common.jsp"/>
    <jsp:include page="/common/page.jsp"/>
</head>
<body class="no-skin init-iframe-box" youdao="bind" style="background: white">

<input id="gritter-light" checked="" type="checkbox" class="ace ace-switch ace-switch-5"/>

<div class="iframe-child">

    <div class="page-header">
        <h1>
            供应商管理
            <small>
                <i class="ace-icon fa fa-angle-double-right"></i>
                维护供应商
            </small>
        </h1>
    </div>

    <div class="ud-search-container">
        <label for="supplier-search">名称</label>
        <input type="text" name="name" id="supplier-search" placeholder="请输入关键字" class="text ui-widget-content ui-corner-all">
        <button class="btn btn-primary ud-radius supplier-search-btn">
            <i class="fa fa-search">&nbsp;&nbsp;</i>搜索
        </button>
    </div>

    <div class="main-content-inner">
        <div class="col-xs-12">
            <div class="table-header">
                供应商列表&nbsp;&nbsp;
                <a class="green" href="#">
                    <i class="ace-icon fa fa-plus-circle orange bigger-130 supplier-add"></i>
                </a>
            </div>

            <div>
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
                                姓名
                            </th>
                            <th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
                                登录名
                            </th>
                            <th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
                                电话
                            </th>
                            <th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
                                手机
                            </th>
                            <th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
                                登录次数
                            </th>
                            <th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
                                注册时间
                            </th>
                            <th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
                                登录IP
                            </th><th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
                                状态
                            </th>
                            <th class="sorting_disabled" rowspan="1" colspan="1" aria-label=""></th>
                        </tr>
                        </thead>
                        <tbody id="supplierList"></tbody>
                    </table>

                    <div class="row" id="supplierPage">
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div id="dialog-supplier-form" style="display: none;">
    <form id="supplierForm">
        <table class="table table-striped table-bordered table-hover dataTable no-footer" role="grid">
            <tr>
                <td><label for="supplier-name">名称</label></td>
                <input type="hidden" name="id" id="supplier-id"/>
                <td><input type="text" name="name" id="supplier-name" value=""
                           placeholder="名称不能为空" class="text form-control"></td>

                <td><label for="supplier-login-name">登录名称</label></td>
                <td><input type="text" name="loginName" id="supplier-login-name" value=""
                           placeholder="登录名称不能为空" class="text form-control"></td>
            </tr>
            <tr>
                <td><label for="supplier-tel">电话</label></td>
                <td><input type="text" name="tel" id="supplier-tel" value=""
                           placeholder="电话可以为空" class="text form-control"></td>

                <td><label for="supplier-phone">手机</label></td>
                <td><input type="text" name="phone" id="supplier-phone" value=""
                           placeholder="手机可以为空" class="text form-control"></td>
            </tr>
            <tr>
                <td><label for="supplier-email">邮箱</label></td>
                <td><input type="text" name="email" id="supplier-email" value=""
                           placeholder="邮箱可以为空" class="text form-control"></td>

                <td><label for="supplier-qq">QQ</label></td>
                <td><input type="text" name="qq" id="supplier-qq" value=""
                           placeholder="邮箱可以为空" class="text form-control"></td>
            </tr>
            <tr>
                <td><label for="supplier-fax">传真</label></td>
                <td colspan="3"><input type="text" name="fax" id="supplier-fax" value=""
                                       placeholder="传真可以为空" class="text form-control"></td>
            </tr>
            <tr>
                <td><label for="supplier-add">地址</label></td>
                <td colspan="3"><textarea name="add" id="supplier-add" class="form-control"
                                          placeholder="地址可以为空" rows="3"></textarea></td>
            </tr>
            <tr>
                <td><label for="supplier-explain">说明</label></td>
                <td colspan="3"><textarea name="explain" id="supplier-explain" class="form-control"
                                          placeholder="说明可以为空" rows="3"></textarea></td>
            </tr>
        </table>
    </form>
</div>

<div id="dialog-supplier-detail" style="display: none;">
    <table id="detail-table" class="table table-bordered dataTable no-footer" role="grid"
           aria-describedby="dynamic-table_info" style="font-size:14px">
        <tbody id="supplierDetail"></tbody>
    </table>
</div>

<script id="supplierDetailTemplate" type="x-tmpl-mustache">
    <tr role="row" class="supplier-detail-name odd" data-id="{{id}}">
        <td>名称</td><td>{{supplier.name}}</td>
        <td>登录名</td><td>{{supplier.loginName}}</td>
    </tr>
    <tr>
        <td>电话</td><td>{{supplier.tel}}</td>
        <td>手机</td><td>{{supplier.phone}}</td>
    </tr>
    <tr>
        <td>邮箱</td><td>{{supplier.email}}</td>
        <td>QQ</td><td>{{supplier.qq}}</td>
    </tr>
    <tr>
        <td>传真</td><td>{{supplier.fax}}</td>
        <td>登录次数</td><td>{{supplier.loc}}</td>
    </tr>
    <tr>
        <td>创建时间</td><td>{{supplier.created}}</td>
        <td>更新时间</td><td>{{supplier.updated}}</td>
    </tr>
    <tr>
        <td>最后IP</td><td>{{supplier.lastIp}}</td>
        <td></td>
    </tr>
    <tr>
        <td>地址</td><td colspan="3">{{supplier.add}}</td>
    </tr>
    <tr>
        <td>说明</td><td colspan="3">{{supplier.explain}}</td>
    </tr>
</script>

<script id="supplierListTemplate" type="x-tmpl-mustache">
{{#supplierList}}
<tr role="row" class="supplier-name odd" data-id="{{id}}"><!--even -->
    <td><a href="#" class="supplier-edit" data-id="{{id}}">{{name}}</a></td>
    <td>{{loginName}}</td>
    <td>{{tel}}</td>
    <td>{{phone}}</td>
    <td>{{loc}}</td>
    <td>{{created}}</td>
    <td>{{lastIp}}</td>
    <td>{{#displayStatus}}{{showStatus}}{{/displayStatus}}</td> <!-- 此处套用函数对status做特殊处理 -->
    <td>
        <div class="hidden-sm hidden-xs action-buttons">
            &nbsp;
            <a class="green supplier-edit" href="#" data-id="{{id}}">
                <i class="ace-icon fa fa-pencil bigger-100" title="编辑"></i>
            </a>&nbsp;
            <a class="blue supplier-detail" href="#" data-id="{{id}}">
                <i class="ace-icon glyphicon glyphicon-list-alt bigger-100" title="详细"></i>
            </a>&nbsp;
            <a class="red supplier-delete" href="#" data-id="{{id}}"  data-name="{{loginName}}" title="删除">
                <i class="glyphicon glyphicon-trash bigger-100"></i></a> &nbsp;
            {{#displayStopBtn}}{{/displayStopBtn}}
        </div>
    </td>
</tr>
{{/supplierList}}
</script>

<script type="application/javascript">

    $(function() {

        //表示 加载初始化的列表, false表示 加载 搜索的列表
        var addAndUpdateLoadMethod = true;

        //部门列表模板
        var supplierListTemplate = $('#supplierListTemplate').html();
        Mustache.parse(supplierListTemplate); //用 Mustache 解析

        //供应商详细模板
        var supplierDetailTemplate = $('#supplierDetailTemplate').html();
        Mustache.parse(supplierDetailTemplate);

        //加载部门树
        load();

        /**
         * 加载部门树
         */
        function load() {
            addAndUpdateLoadMethod = true;
            var url = "/sys/sup/sys-list.json";
            var pageSize = $("#pageSize").val();
            var pageNo = $("#supplierPage .pageNo").val() || 1;
            loadInit(url, load, pageSize, pageNo);
        }
        
        function search() {
            addAndUpdateLoadMethod = false;
            var pageSize = $("#pageSize").val();
            var pageNo = $("#supplierPage .pageNo").val() || 1;

            var keyword = $("#supplier-search").val();
            var url = "/sys/sup/sys-search.json?keyword=" + keyword;
            loadInit(url, search,pageSize, pageNo);
        }

        //初始化列表
        function loadInit(url, callback, pageSize, pageNo) {
            $.ajax({
                url: url,
                data: {
                    pageSize: pageSize,
                    pageNo: pageNo
                },
                success: function (result) {
                    if (result.status == 200) {
                        var _obj = result.data;
                        var supplierList = _obj.data;

                        var rendered = Mustache.render(supplierListTemplate,
                            {
                            supplierList: supplierList,
                            "showStatus":function () {
                                return this.status;
                            },
                            "displayStatus":function () {
                                return function (text,render) {
                                    var _status = render(text);
                                    if (_status == 1) {
                                        return "<span class='label label-lg label-success'>正常使用</span>";
                                    } else {
                                        return "<span class='label label-lg label-warning'>暂停使用</span>";
                                    }
                                }
                            },
                            "displayStopBtn" : function () {
                                return function (text,render) {
                                    if (this.status == 1) {
                                        return ' <a class="purple supplier-stop" href="#" data-id="' + this.id +
                                            '" data-name="' + this.loginName + '" title="暂停使用">' +
                                            '<i class="glyphicon glyphicon-stop bigger-100"></i></a> &nbsp;';
                                    }else if (this.status == 0) {
                                        return ' <a class="orange supplier-play" href="#" data-id="' + this.id +
                                            '" data-name="' + this.loginName + '" title="启动使用">' +
                                            '<i class="glyphicon glyphicon-play bigger-100"></i></a> &nbsp;';
                                    }
                                }
                            }
                        });
                        $("#supplierList").html(rendered);
                        bindSupplierClick();
                        var pageSize = $("#pageSize").val();
                        var pageNo = $("#supplierPage .pageNo").val() || 1;
                        renderPage(url, _obj.total, pageNo, pageSize, _obj.total > 0 ? supplierList.length : 0, "supplierPage", callback);

                    } else {
                        showMessage("加载供应商列表", result.msg, false);
                    }
                }
            });
        }

        // 绑定部门点击事件
        function bindSupplierClick() {

            //点击供应商名称 事件
            $(".supplier-name").click(function(e) {
                e.preventDefault();
                e.stopPropagation();
                var id = $(this).attr("data-id");
            });

            //删除 供应商 事件
            $(".supplier-delete").click(function (e) {
                e.preventDefault();
                e.stopPropagation();
                var id = $(this).attr("data-id");
                var name = $(this).attr("data-name");
                if (confirm("确定要删除供应商[" + name + "]吗?")) {
                    $.ajax({
                        url: "/sys/sup/delete.json",
                        data: {
                            id: id
                        },
                        success: function (result) {
                            if (result.status == 200) {
                                showMessage("删除供应商[" + name + "]", "操作成功", true);
                                refresh(addAndUpdateLoadMethod, load, search);
                            } else {
                                showMessage("删除供应商[" + name + "]", result.msg, false);
                            }
                        }
                    });
                }
            });

            //编辑 供应商 事件
            $(".supplier-edit").click(function(e) {
                e.preventDefault();
                e.stopPropagation();
                var id = $(this).attr("data-id");
                $.ajax({
                    url : '/sup/detail.json',
                    data : {id:id},
                    success : function (res) {
                        if (res.status == 200) {
                            $("#dialog-supplier-form").dialog({
                                model: true,
                                title: "编辑",
                                width: 680,
                                open: function(event, ui) {
                                    $(".ui-dialog-titlebar-close", $(this).parent()).hide();

                                    $("#supplierForm")[0].reset();
                                    $("#supplier-id").val(id);
                                    var target = res.data;
                                    if (target) {
                                        $("#supplier-name").val(target.name);
                                        $("#supplier-login-name").val(target.loginName);
                                        $("#supplier-tel").val(target.tel);
                                        $("#supplier-phone").val(target.phone);
                                        $("#supplier-qq").val(target.qq);
                                        $("#supplier-email").val(target.email);
                                        $("#supplier-fax").val(target.fax);
                                        $("#supplier-add").val(target.add);
                                        $("#supplier-explain").val(target.explain);
                                    }
                                },
                                buttons : {
                                    "更新": function(e) {
                                        e.preventDefault();
                                        updateSupplier(false, function (data) {
                                            clearData("supplierForm");
                                            $("#dialog-supplier-form").dialog("close");
                                            showMessage("更新供应商", "更新成功", true);
                                        }, function (data) {
                                            showMessage("更新供应商", data.msg, false);
                                        })
                                    },
                                    "取消": function () {
                                        clearData("supplierForm");
                                        $("#dialog-supplier-form").dialog("close");
                                    }
                                }
                            });
                        }
                    }
                });
            });

            //详细信息
            $(".supplier-detail").click(function (e) {
                e.preventDefault();
                e.stopPropagation();
                var id = $(this).attr("data-id");
                $.ajax({
                    url:'/sup/detail.json',
                    type:'POST',
                    data:{id:id},
                    success:function (result) {
                        if (result.status == 200){
                            var supplier;
                            $("#dialog-supplier-detail").dialog({
                                width:"680",
                                model: true,
                                title: "供应商详细信息",
                                resizable:false,
                                position: { using:function(pos){
                                        var topOffset = $(this).css(pos).offset().top;
                                        if (topOffset == 0||topOffset>0) {
                                            $(this).css('top', 20);
                                        }
                                    }},
                                open: function(event, ui) {
                                    $(".ui-dialog-titlebar-close", $(this).parent()).hide();
                                    supplier = result.data;

                                    var rendered = Mustache.render(supplierDetailTemplate, {supplier: supplier});
                                    $("#supplierDetail").html(rendered);
                                },
                                buttons : {
                                    "取消": function () {
                                        // clearData("supplierForm");
                                        supplier = null;
                                        $("#dialog-supplier-detail").dialog("close");
                                    }
                                }
                            });
                        }
                    }
                });
            });

            //暂停使用
            $(".supplier-stop").click(function (e) {
                e.preventDefault();
                e.stopPropagation();
                var id = $(this).attr("data-id");
                var name = $(this).attr("data-name");
                if (confirm("确定要停止使用供应商[" + name + "]吗?")) {
                    $.ajax({
                        url : '/sys/sup/sys-stop.json',
                        data:{id:id},
                        type : 'POST',
                        success :function (res) {
                            if (res.status == 200) {
                                showMessage("提示", "暂停供应商成功", true);
                                refresh(addAndUpdateLoadMethod, load, search);
                            }else {
                                showMessage("提示", "暂停供应商失败", false);
                            }
                        }
                    });
                }

            });

            //启用
            $(".supplier-play").click(function (e) {
                e.preventDefault();
                e.stopPropagation();
                var id = $(this).attr("data-id");
                var name = $(this).attr("data-name");
                if (confirm("确定要启用供应商[" + name + "]吗?")) {
                    $.ajax({
                        url : '/sys/sup/sys-play.json',
                        data : { id:id },
                        type : 'POST',
                        success :function (res) {
                            if (res.status == 200) {
                                showMessage("提示", "启动供应商成功", true);
                                refresh(addAndUpdateLoadMethod, load, search);
                            }else {
                                showMessage("提示", "启动供应商失败", false);
                            }
                        }
                    });
                }

            });
        }

        //添加供应商点击 事件
        $(".supplier-add").click(function() {
            $("#dialog-supplier-form").dialog({
                model: true,
                title: "新增供应商",
                width: 680,
                open: function(event, ui) {
                    $(".ui-dialog-titlebar-close", $(this).parent()).hide();
                },
                buttons : {
                    "添加": function(e) {
                        e.preventDefault();
                        updateSupplier(true, function (data) {
                            clearData("supplierForm");
                            $("#dialog-supplier-form").dialog("close");
                        }, function (data) {
                            showMessage("新增供应商", data.msg, false);
                        })
                    },
                    "取消": function () {
                        clearData("supplierForm");
                        $("#dialog-supplier-form").dialog("close");
                    }
                }
            });
        });

        //搜索
        $(".supplier-search-btn").click(function (e) {
            e.preventDefault();
            e.stopPropagation();
            var keyword = $("#supplier-search").val();
            if(existNotBlank(keyword)){
                return;
            }
            search();
        });

        //绑定展示条数
        $(".input-sm").change(function () {
            refresh(addAndUpdateLoadMethod, load, search);
        });

        //更新供应商信息
        function updateSupplier(isCreate, successCallback, failCallback) {
            if (validSupplier(false)){
                return;
            }
            $.ajax({
                url: isCreate ? "/sys/sup/sys-save.json" : "/sys/sup/sys-update.json",
                data: $("#supplierForm").serializeArray(),
                type: 'POST',
                success: function(result) {
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
    });
</script>

<script src="/js/defined/manager.js"></script>
<script src="/js/valid/base-valid.js"></script>
<script src="/js/valid/supplier-valid.js"></script>

</body>
</html>