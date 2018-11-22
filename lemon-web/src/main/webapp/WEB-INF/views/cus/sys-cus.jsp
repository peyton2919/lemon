<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>客户管理</title>
    <jsp:include page="/common/common.jsp"/>
    <jsp:include page="/common/page.jsp"/>
    <link rel="stylesheet" type="text/css" href="/ztree/zTreeStyle.css">

</head>
<body class="no-skin init-iframe-box" youdao="bind" style="background: white">

<input id="gritter-light" checked="" type="checkbox" class="ace ace-switch ace-switch-5"/>

<div class="iframe-child">

    <div class="page-header">
        <h1>
            客户管理
            <small>
                <i class="ace-icon fa fa-angle-double-right"></i>
                维护客户
            </small>
        </h1>
    </div>

    <div class="ud-search-container">
        <label for="customer-search">名称</label>
        <input type="text" name="name" id="customer-search" placeholder="请输入关键字" class="text ui-widget-content ui-corner-all">
        <button class="btn btn-primary ud-radius customer-search-btn">
            <i class="fa fa-search">&nbsp;&nbsp;</i>搜索
        </button>
    </div>

    <div class="main-content-inner">
        <div class="col-ms-12">
            <div class="table-header">
                客户列表&nbsp;&nbsp;
                <a class="green" href="#">
                    <i class="ace-icon fa fa-plus-circle orange bigger-130 customer-add"></i>
                </a>
            </div>

            <div>
                <div id="dynamic-table_wrapper" class="dataTables_wrapper form-inline no-footer">
                    <div class="row">
                        <div class="col-ms-6">
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
                        <tbody id="customerList"></tbody>
                    </table>

                    <div class="row" id="customerPage">
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div id="dialog-customer-form" style="display: none;">
    <form id="customerForm">
        <div class="col-sm-3">
            <div  id="treeRegion" class="ztree"></div>
        </div>
        <input type="hidden" id="hidden-region-id" name="regiId">
        <div class="col-sm-9">
            <table class="table table-bordered dataTable no-footer" role="grid">
                <tr>
                    <td><label for="customer-name">名称</label></td>
                    <input type="hidden" name="id" id="hidden-customer-id"/>
                    <td><input type="text" name="name" id="customer-name"
                               placeholder="名称不能为空" class="text form-control"></td>

                    <td><label for="customer-login-name">登录名称</label></td>
                    <td><input type="text" name="loginName" id="customer-login-name"
                               placeholder="登录名称不能为空" class="text form-control"></td>
                </tr>

                <tr>
                    <td><label for="customer-tel">电话</label></td>
                    <td><input type="text" name="tel" id="customer-tel"
                               placeholder="电话可以为空" class="text form-control"></td>

                    <td><label for="customer-phone">手机</label></td>
                    <td><input type="text" name="phone" id="customer-phone"
                               placeholder="手机可以为空" class="text form-control"></td>
                </tr>

                <tr>
                    <td><label for="customer-email">邮箱</label></td>
                    <td><input type="text" name="email" id="customer-email"
                               placeholder="邮箱可以为空" class="text form-control"></td>

                    <td><label for="customer-qq">QQ</label></td>
                    <td><input type="text" name="qq" id="customer-qq"
                               placeholder="QQ可以为空" class="text form-control"></td>
                </tr>

                <tr>
                    <td><label for="customer-birth">出生日期</label></td>
                    <td><input type="text" name="birth" id="customer-birth" readonly
                               placeholder="出生日期可以为空" class="text form-control"></td>

                    <td><label for="customer-fax">传真</label></td>
                    <td><input type="text" name="fax" id="customer-fax"
                               placeholder="传真可以为空" class="text form-control"></td>
                </tr>

                <tr>
                    <td><label for="customer-identity">身份证</label></td>
                    <td><input type="text" name="identity" id="customer-identity"
                               placeholder="身份证可以为空" class="text form-control"></td>

                    <td><label for="customer-type">客户类型</label></td>
                    <td>
                        <select id="customer-type" name="type" class="text form-control">
                            <option value="1">零售客户</option>
                            <option value="0">批发客户</option>
                        </select>
                    </td>
                </tr>

                <tr>
                    <td><label for="customer-grade-id">客户等级</label></td>
                    <td colspan="3">
                        <select id="customer-grade-id" name="cugrId" data-placeholder="选择等级"
                                class="text form-control"></select>
                    </td>
                </tr>

                <tr>
                    <td><label for="customer-add">地址</label></td>
                    <td colspan="3"><textarea name="add" id="customer-add" class="form-control"
                                              placeholder="地址可以为空" rows="3"></textarea></td>
                </tr>

                <tr>
                    <td><label for="customer-explain">说明</label></td>
                    <td colspan="3"><textarea name="explain" id="customer-explain" class="form-control"
                                              placeholder="说明可以为空" rows="3"></textarea></td>
                </tr>
            </table>
        </div>
    </form>
</div>

<div id="dialog-customer-detail" style="display: none;">
    <table id="detail-table" class="table table-bordered dataTable no-footer" role="grid"
           aria-describedby="dynamic-table_info" style="font-size:14px">
        <tbody id="customerDetail"></tbody>
    </table>
</div>

<script id="customerDetailTemplate" type="x-tmpl-mustache">
    <tr role="row" class="customer-detail-name odd" data-id="{{id}}">
        <td>名称</td><td>{{customer.name}}</td>
        <td>登录名</td><td>{{customer.loginName}}</td>
    </tr>
    <tr>
        <td>电话</td><td>{{customer.tel}}</td>
        <td>手机</td><td>{{customer.phone}}</td>
    </tr>
    <tr>
        <td>邮箱</td><td>{{customer.email}}</td>
        <td>QQ</td><td>{{customer.qq}}</td>
    </tr>
    <tr>
        <td>传真</td><td>{{customer.fax}}</td>
        <td>登录次数</td><td>{{customer.loc}}</td>
    </tr>
    <tr>
        <td>出生日期</td><td>{{customer.birth}}</td>
        <td>身份证</td><td>{{customer.identity}}</td>
    </tr>
    <tr>
        <td>地区</td><td>{{#showRegionId}}{{customer.regiId}}{{/showRegionId}}</td>
        <td>客户等级</td><td>{{#showCustomerGradeId}}{{customer.cugrId}}{{/showCustomerGradeId}}</td>
    </tr>
    <tr>
        <td>创建时间</td><td>{{customer.created}}</td>
        <td>更新时间</td><td>{{customer.updated}}</td>
    </tr>
    <tr>
        <td>最后IP</td><td>{{customer.lastIp}}</td>
        <td>客户类型</td><td>{{#showType}}{{customer.type}}{{/showType}}</td>
    </tr>
    <tr>
        <td>地址</td><td colspan="3">{{customer.add}}</td>
    </tr>
    <tr>
        <td>说明</td><td colspan="3">{{customer.explain}}</td>
    </tr>
</script>

<script id="customerListTemplate" type="x-tmpl-mustache">
{{#customerList}}
<tr role="row" class="customer-name1 odd" data-id="{{id}}"><!--even -->
    <td><a href="#" class="customer-edit" data-id="{{id}}">{{name}}</a></td>
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
            <a class="green customer-edit" href="#" data-id="{{id}}">
                <i class="ace-icon fa fa-pencil bigger-100" title="编辑"></i>
            </a>&nbsp;
            <a class="blue customer-detail" href="#" data-id="{{id}}">
                <i class="ace-icon glyphicon glyphicon-list-alt bigger-100" title="详细"></i>
            </a>&nbsp;
            <a class="red customer-delete" href="#" data-id="{{id}}"  data-name="{{loginName}}" title="删除">
                <i class="glyphicon glyphicon-trash bigger-100"></i></a> &nbsp;
            {{#displayStopBtn}}{{/displayStopBtn}}
        </div>
    </td>
</tr>
{{/customerList}}
</script>

<script type="application/javascript">

    $(function() {

        //表示 加载初始化的列表, false表示 加载 搜索的列表
        var addAndUpdateLoadMethod = true;
        var optionCustomerGradeStr = "";
        var treeObj;
        var lastClickRegionId = -1;
        var customerGradeMap = {};
        var regionMap = {};

        //部门列表模板
        var customerListTemplate = $('#customerListTemplate').html();
        Mustache.parse(customerListTemplate); //用 Mustache 解析

        //客户详细模板
        var customerDetailTemplate = $('#customerDetailTemplate').html();
        Mustache.parse(customerDetailTemplate);

        // ==============================  tree 的基础配置 开始  ============================== //
        /**
         * <h4>加载选中的商品类目</h4>
         * @param regionId 商品类目编号
         */
        function loadSelectNode(regionId){
            var node = treeObj.getNodeByParam("id",regionId);
            //为什么设置了checked=true，可是等树显示的时候节点仍然没有选中
            node.checked=true;
            treeObj.selectNode(node);
        }

        // tree 在...之前 点击 事件
        function onBeforeClick(treeId, treeNode) {
            var zTree = $.fn.zTree.getZTreeObj("treeRegion");
            if (treeNode.isParent) {
                zTree.expandNode(treeNode);
                return false;
            } else {
                lastClickRegionId = treeNode.id;
                $("#hidden-region-id").val(lastClickRegionId);
                return true;
            }
        }

        //树 基础设置
        var setting = {
            view: {
                dblClickExpand: false,
                showLine: true,
                selectedMulti: false
            },
            data: {
                simpleData: {
                    enable:true,
                    idKey: "id",
                    pIdKey: "parentId",
                    rootPId: ""
                }
            },
            callback: {
                beforeClick: onBeforeClick,
            }
        };

        // ==============================  tree 的基础配置 结束  ============================== //

        //加载部门树
        load();

        // 加载
        function load() {
            addAndUpdateLoadMethod = true;
            var url = "/sys/cus/sys-list.json";
            var pageSize = $("#pageSize").val();
            var pageNo = $("#customerPage .pageNo").val() || 1;
            loadInit(url, load, pageSize, pageNo);
        }

        // 搜索
        function search() {
            addAndUpdateLoadMethod = false;
            var pageSize = $("#pageSize").val();
            var pageNo = $("#customerPage .pageNo").val() || 1;

            var keyword = $("#customer-search").val();
            var url = "/sys/cus/sys-search.json?keyword=" + keyword;
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
                        var customerList = _obj.data;
                        var rendered = Mustache.render(customerListTemplate,
                            {
                            customerList: customerList,
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
                                        return ' <a class="purple customer-stop" href="#" data-id="' + this.id +
                                            '" data-name="' + this.loginName + '" title="暂停使用">' +
                                            '<i class="glyphicon glyphicon-stop bigger-100"></i></a> &nbsp;';
                                    }else if (this.status == 0) {
                                        return ' <a class="orange customer-play" href="#" data-id="' + this.id +
                                            '" data-name="' + this.loginName + '" title="启动使用">' +
                                            '<i class="glyphicon glyphicon-play bigger-100"></i></a> &nbsp;';
                                    }
                                }
                            }
                        });
                        $("#customerList").html(rendered);
                        bindCustomerClick();
                        renderPage(url, _obj.total, pageNo, pageSize, _obj.total > 0 ? customerList.length : 0, "customerPage", callback);

                    } else {
                        showMessage("加载客户列表", result.msg, false);
                    }
                }
            });
        }

        // 绑定部门点击事件
        function bindCustomerClick() {

            //点击客户名称 事件
            $(".customer-name1").click(function(e) {
                e.preventDefault();
                e.stopPropagation();
                var id = $(this).attr("data-id");
            });

            //删除 客户 事件
            $(".customer-delete").click(function (e) {
                e.preventDefault();
                e.stopPropagation();
                var customerId = $(this).attr("data-id");
                var name = $(this).attr("data-name");
                if (confirm("确定要删除客户[" + name + "]吗?")) {
                    $.ajax({
                        url: "/sys/cus/delete.json",
                        data: {
                            customerId: customerId
                        },
                        success: function (result) {
                            if (result.status == 200) {
                                showMessage("删除客户[" + name + "]", "操作成功", true);
                                refresh(addAndUpdateLoadMethod, load, search);
                            } else {
                                showMessage("删除客户[" + name + "]", result.msg, false);
                            }
                        }
                    });
                }
            });

            //编辑 客户 事件
            $(".customer-edit").click(function(e) {
                e.preventDefault();
                e.stopPropagation();
                var customerId = $(this).attr("data-id");

                $.ajax({
                    url : '/sys/cus/sys-editor.json',
                    data : {customerId:customerId},
                    type : 'POST',
                    success : function (response) {
                        if (response.status == 200) {
                            var regionList = response.data.regionList;
                            var customerGradeList = response.data.customerGradeList;
                            var target = response.data.customer;
                            $("#dialog-customer-form").dialog({
                                model: true,
                                title: "编辑",
                                width: 880,
                                resizable:false,
                                position: { using:function(pos){
                                    var topOffset = $(this).css(pos).offset().top;
                                    if (topOffset == 0||topOffset>0) {
                                        $(this).css('top', 20);
                                    }
                                }},
                                open: function(event, ui) {
                                    $(".ui-dialog-titlebar-close", $(this).parent()).hide();
                                    $("#customer-birth").datetime();
                                    $("#customerForm")[0].reset();
                                    $("#hidden-customer-id").val(customerId);
                                    optionCustomerGradeStr = "";
                                    renderCustomerGradeSelect(customerGradeList);
                                    $("#customer-grade-id").html(optionCustomerGradeStr);
                                    treeObj = $.fn.zTree.init($("#treeRegion"),setting,regionList);

                                    if (target) {
                                        $("#customer-name").val(target.name);
                                        $("#customer-login-name").val(target.loginName);
                                        $("#customer-tel").val(target.tel);
                                        $("#customer-phone").val(target.phone);
                                        $("#customer-qq").val(target.qq);
                                        $("#customer-email").val(target.email);
                                        $("#customer-fax").val(target.fax);
                                        $("#customer-add").val(target.add);
                                        $("#customer-explain").val(target.explain);
                                        $("#customer-birth").val(target.birth);
                                        $("#customer-identity").val(target.identity);
                                        $("#customer-grade-id").val(target.cugrId);
                                        $("#customer-type").val(target.type);
                                        // 选中 tree
                                        $("#hidden-region-id").val(target.regiId);
                                        loadSelectNode(target.regiId);
                                        lastClickRegionId = target.regiId;
                                    }
                                },
                                position: { using:function(pos){
                                        var topOffset = $(this).css(pos).offset().top;
                                        if (topOffset == 0||topOffset>0) {
                                            $(this).css('top', 20);
                                        }
                                    }
                                },
                                buttons : {
                                    "更新": function(e) {
                                        e.preventDefault();
                                        updateCustomer(false, function (data) {
                                            clearData("customerForm");
                                            $("#dialog-customer-form").dialog("close");
                                            showMessage("更新客户", "更新成功", true);
                                        }, function (data) {
                                            showMessage("更新客户", data.msg, false);
                                        })
                                    },
                                    "取消": function () {
                                        clearData("customerForm");
                                        $("#dialog-customer-form").dialog("close");
                                    }
                                }
                            });
                        }
                    }
                });
            });

            //详细信息
            $(".customer-detail").click(function (e) {
                e.preventDefault();
                e.stopPropagation();
                var customerId = $(this).attr("data-id");
                $.ajax({
                    url:'/sys/cus/sys-detail.json',
                    type:'POST',
                    data:{customerId:customerId},
                    success:function (result) {
                        if (result.status == 200){
                            var customer;
                            var regionList = result.data.regionList;
                            var customerGradeList = result.data.customerGradeList;
                            conventCustomerGradeList2Map(customerGradeList);
                            conventRegionList2Map(regionList);
                            $("#dialog-customer-detail").dialog({
                                width:"680",
                                model: true, //开启遮罩层
                                title: "客户详细信息",
                                resizable:false,
                                position: { using:function(pos){
                                        var topOffset = $(this).css(pos).offset().top;
                                        if (topOffset == 0||topOffset>0) {
                                            $(this).css('top', 20);
                                        }
                                    }
                                },
                                open: function(event, ui) {
                                    $(".ui-dialog-titlebar-close", $(this).parent()).hide();
                                    customer = result.data.customer;

                                    var rendered = Mustache.render(customerDetailTemplate,
                                        {customer: customer,
                                            "showType":function () {
                                                return function (text,render) {
                                                    return ((customer.type == 0) ? "批发客户" : "零售客户");
                                                }
                                            },
                                            "showRegionId":function () {
                                                return function (text,render) {
                                                    return regionMap[customer.regiId].name;
                                                }
                                            },
                                            "showCustomerGradeId" : function () {
                                                return function (text,render) {
                                                    return customerGradeMap[customer.cugrId].name;
                                                }
                                            }
                                        });
                                    $("#customerDetail").html(rendered);
                                },
                                buttons : {
                                    "取消": function () {
                                        customer = null;
                                        $("#dialog-customer-detail").dialog("close");
                                    }
                                }
                            });
                        }
                    }
                });
            });

            //暂停使用
            $(".customer-stop").click(function (e) {
                e.preventDefault();
                e.stopPropagation();
                var customerId = $(this).attr("data-id");
                var name = $(this).attr("data-name");
                if (confirm("确定要停止使用客户[" + name + "]吗?")) {
                    $.ajax({
                        url : '/sys/cus/sys-stop.json',
                        data:{customerId:customerId},
                        type : 'POST',
                        success :function (res) {
                            if (res.status == 200) {
                                showMessage("提示", "暂停客户成功", true);
                                refresh(addAndUpdateLoadMethod, load, search);
                            }else {
                                showMessage("提示", "暂停客户失败", false);
                            }
                        }
                    });
                }

            });

            //启用
            $(".customer-play").click(function (e) {
                e.preventDefault();
                e.stopPropagation();
                var customerId = $(this).attr("data-id");
                var name = $(this).attr("data-name");
                if (confirm("确定要启用客户[" + name + "]吗?")) {
                    $.ajax({
                        url : '/sys/cus/sys-play.json',
                        data : { customerId:customerId },
                        type : 'POST',
                        success :function (res) {
                            if (res.status == 200) {
                                showMessage("提示", "启动客户成功", true);
                                refresh(addAndUpdateLoadMethod, load, search);
                            }else {
                                showMessage("提示", "启动客户失败", false);
                            }
                        }
                    });
                }

            });
        }

        //添加客户点击 事件
        $(".customer-add").click(function() {

            $.ajax({
                url : '/sys/cus/sys-editor.json',
                type : 'POST',
                cache : false,
                async : false,
                success : function (response) {
                    if (response.status == 200) {
                        var regionList = response.data.regionList;
                        var customerGradeList = response.data.customerGradeList;

                        $("#dialog-customer-form").dialog({
                            model: true,
                            title: "新增客户",
                            width: 880,
                            resizable:false,
                            position: { using:function(pos){
                                var topOffset = $(this).css(pos).offset().top;
                                if (topOffset == 0||topOffset>0) {
                                    $(this).css('top', 20);
                                }
                            }},
                            open: function(event, ui) {
                                $(".ui-dialog-titlebar-close", $(this).parent()).hide();
                                $("#customerForm")[0].reset();
                                optionCustomerGradeStr = "";
                                renderCustomerGradeSelect(customerGradeList);
                                $("#customer-grade-id").html(optionCustomerGradeStr);
                                $("#customer-birth").datetime();
                                treeObj = $.fn.zTree.init($("#treeRegion"),setting,regionList);

                            },
                            position: { using:function(pos){
                                    var topOffset = $(this).css(pos).offset().top;
                                    if (topOffset == 0||topOffset>0) {
                                        $(this).css('top', 20);
                                    }
                                }
                            },
                            buttons : {
                                "添加": function(e) {
                                    e.preventDefault();
                                    updateCustomer(true, function (data) {
                                        clearData("customerForm");
                                        $("#dialog-customer-form").dialog("close");
                                    }, function (data) {
                                        showMessage("新增客户", data.msg, false);
                                    })
                                },
                                "取消": function () {
                                    clearData("customerForm");
                                    $("#dialog-customer-form").dialog("close");
                                }
                            }
                        });
                    }else {
                        showMessage("提示", "数据加载出错了...", false);
                    }
                }
            });

        });

        //搜索
        $(".customer-search-btn").click(function (e) {
            e.preventDefault();
            e.stopPropagation();
            var keyword = $("#customer-search").val();
            if(existNotBlank(keyword)){
                return;
            }
            search();
        });

        //绑定展示条数
        $(".input-sm").change(function () {
            $("#customerPage .pageNo").val(1);
            refresh(addAndUpdateLoadMethod, load, search);
        });

        //更新客户信息
        function updateCustomer(isCreate, successCallback, failCallback) {
            if (validCustomer(false)){
                return;
            }

            $.ajax({
                url: isCreate ? "/sys/cus/sys-save.json" : "/sys/cus/sys-update.json",
                data: $("#customerForm").serializeArray(),
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

        function renderCustomerGradeSelect(customerGradeList) {
            if(customerGradeList && customerGradeList.length > 0) {
                $(customerGradeList).each(function (i ,customerGrade) {
                    optionCustomerGradeStr += Mustache.render("<option value='{{id}}'>{{name}}</option>",
                        {id: customerGrade.id, name: customerGrade.name});
                });
            }
        }

        function conventCustomerGradeList2Map(customerGradeList) {
            customerGradeMap = {};
            $(customerGradeList).each(function (i,customerGrade) {
                customerGradeMap[customerGrade.id] = customerGrade;
            });
        }

        function conventRegionList2Map(regionList) {
            regionMap = {};
            $(regionList).each(function (i,region) {
                regionMap[region.id] = region;
            });
        }
    });

</script>

<script src="/js/defined/manager.js"></script>
<script src="/js/valid/base-valid.js"></script>
<script src="/js/valid/customer-valid.js"></script>
<script src="/ztree/jquery.ztree.all.min.js"></script>
</body>
</html>