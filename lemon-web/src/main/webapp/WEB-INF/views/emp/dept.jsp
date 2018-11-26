<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>部门管理</title>
    <jsp:include page="/common/common.jsp"/>
    <jsp:include page="/common/page.jsp"/>
</head>

<body class="no-skin init-iframe-box" youdao="bind" style="background: white">

<input id="gritter-light" checked="" type="checkbox" class="ace ace-switch ace-switch-5"/>

<div class="iframe-child">

    <div class="page-header">
        <h1>
            用户管理
            <small>
                <i class="ace-icon fa fa-angle-double-right"></i>
                维护部门与用户关系
            </small>
        </h1>
    </div>

    <div class="main-content-inner">
        <div class="col-sm-3">
            <div class="table-header">
                部门列表&nbsp;&nbsp;
                <a class="green" href="#">
                    <i class="ace-icon fa fa-plus-circle orange bigger-130 btn-dept-add"></i>
                </a>
            </div>
            <div id="deptList">
                <%-- js add --%>
            </div>
        </div>

        <div class="col-sm-9">
            <div class="col-xs-12 mb20">
                <div class="table-header">
                    职务列表&nbsp;&nbsp;
                    <a class="green" href="#">
                        <i class="ace-icon fa fa-plus-circle orange bigger-130 btn-post-add"></i>
                    </a>
                </div>
                <div class="row" id="postList">
                    <%-- js add --%>
                </div>
            </div>
            <%--  员工详情 --%>

            <div class="col-xs-12">
                <div class="table-header">
                    员工列表&nbsp;&nbsp;
                    <a class="green" href="#">
                        <i class="ace-icon fa fa-plus-circle orange bigger-130 btn-employee-add"></i>
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
                                    邮箱
                                </th>
                                <th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
                                    部门
                                </th>
                                <th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
                                    职务
                                </th>
                                <th class="sorting_disabled" rowspan="1" colspan="1" aria-label=""></th>
                            </tr>
                            </thead>
                            <tbody id="employeeList"></tbody>
                        </table>

                        <div class="row" id="employeePage">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<%--   --%>
<div id="dialog-dept-form" style="display: none;">
    <form id="deptForm">
        <table class="table table-bordered dataTable no-footer" role="grid">
            <tr>
                <td style="width: 80px;"><label for="parentId">上级部门</label></td>
                <td>
                    <select id="parentId" name="parentId" data-placeholder="选择部门" class="form-control"></select>
                    <input type="hidden" name="id" id="deptId"/>
                </td>
            </tr>
            <tr>
                <td><label for="deptName">名称</label></td>
                <td><input type="text" name="name" id="deptName" value=""
                           class="text form-control" placeholder="名称不能为空"></td>
            </tr>
            <tr>
                <td><label for="deptSeq">顺序</label></td>
                <td><input type="text" name="seq" id="deptSeq" value=""
                           class="text form-control" placeholder="排序不能为空"></td>
            </tr>
            <tr>
                <td><label for="deptRemark">备注</label></td>
                <td>
                    <textarea name="remark" id="deptRemark" class="text form-control"
                              rows="3" cols="25"  placeholder="备注可以为空"></textarea>
                </td>
            </tr>
        </table>
    </form>
</div>

<div id="dialog-post-form" style="display: none;">
    <form id="postForm">
        <table class="table table-bordered dataTable no-footer" role="grid">
            <tr>
                <td><label for="postName">名称</label></td>
                <input type="hidden" name="id" id="postId"/>
                <td><input type="text" name="name" id="postName" value=""
                           class="text form-control" placeholder="名称不能为空"></td>
            </tr>

            <tr>
                <td><label for="postExplain">说明</label></td>
                <td><textarea name="explain" id="postExplain" rows="3" cols="25"
                              class="text form-control" placeholder="说明可以为空"></textarea></td>
            </tr>
        </table>
    </form>
</div>

<div id="dialog-employee-form" style="display: none;">
    <form id="employeeForm">
        <table class="table table-bordered dataTable no-footer" role="grid">

            <tr>
                <td><label for="empname">名称</label></td>
                <input type="hidden" name="id" id="empid"/>
                <td><input type="text" name="name" id="empname" value=""
                           class="text form-control" placeholder="名称不能为空"></td>

                <td><label for="emploginname">登录名称</label></td>
                <td><input type="text" name="loginName" id="emploginname" value=""
                           class="text form-control" placeholder="登录名称不能为空"></td>
            </tr>
            <tr>
                <td><label for="emptel">电话</label></td>
                <td><input type="text" name="tel" id="emptel" value=""
                           class="text form-control" placeholder="电话可以为空,输入必须格式正确"></td>

                <td><label for="empphone">手机</label></td>
                <td><input type="text" name="phone" id="empphone" value=""
                           class="text form-control" placeholder="手机可以为空,输入必须格式正确"></td>
            </tr>
            <tr>
                <td><label for="empemail">邮箱</label></td>
                <td><input type="text" name="email" id="empemail" value=""
                           class="text form-control" placeholder="邮箱可以为空,输入必须格式正确"></td>

                <td><label for="empqq">QQ</label></td>
                <td><input type="text" name="qq" id="empqq" value=""
                           class="text form-control" placeholder="QQ可以为空,输入必须格式正确"></td>
            </tr>
            <tr>
                <td><label for="empfax">传真</label></td>
                <td><input type="text" name="fax" id="empfax" value=""
                           class="text form-control" placeholder="传真可以为空,输入必须格式正确"></td>

                <td><label for="empadd">地址</label></td>
                <td><input type="text" name="add" id="empadd" value=""
                           class="text form-control" placeholder="地址可以为空"></td>
            </tr>
            <tr>
                <td><label for="empbirth">出生日期</label></td>
                <td><input type="text" name="birth" id="empbirth" value=""
                           class="text form-control datepicker" readonly  placeholder="出生日期可以为空,输入必须格式正确"></td>

                <td><label for="empidentity">身份证</label></td>
                <td><input type="text" name="identity" id="empidentity" value=""
                           class="text form-control" placeholder="身份证可以为空,输入必须格式正确"></td>
            </tr>
            <tr>
                <td><label for="deptSelectId">所在部门</label></td>
                <td>
                    <select id="deptSelectId" name="deptId" data-placeholder="选择部门" class="text form-control"></select>
                </td>

                <td><label for="postSelectId">职务</label></td>
                <td>
                    <select id="postSelectId" name="postId" data-placeholder="选择职务" class="text form-control"></select>
                </td>
            </tr>
            <tr>
                <td><label for="empexplain">说明</label></td>
                <td colspan="3"><textarea name="explain" id="empexplain" rows="3" cols="75"
                                          class="text form-control" placeholder="说明可以为空"></textarea></td>
            </tr>
        </table>
    </form>
</div>

<div id="dialog-employee-detail" style="display: none;">
    <table id="detail-table" class="table table-bordered dataTable no-footer" role="grid"
           aria-describedby="dynamic-table_info" style="font-size:14px">
        <tbody id="employeeDetail"></tbody>
    </table>
</div>

<script id="employeeDetailTemplate" type="x-tmpl-mustache">
    <tr role="row" class="emp-detail-name odd" data-id="{{id}}">
        <td>名称</td><td>{{employee.name}}</td>
        <td>登录名</td><td>{{employee.loginName}}</td>
    </tr>
    <tr>
        <td>电话</td><td>{{employee.tel}}</td>
        <td>手机</td><td>{{employee.phone}}</td>
    </tr>
    <tr>
        <td>邮箱</td><td>{{employee.email}}</td>
        <td>QQ</td><td>{{employee.qq}}</td>
    </tr>
    <tr>
        <td>传真</td><td>{{employee.fax}}</td>
        <td>地址</td><td>{{employee.add}}</td>
    </tr>
    <tr>
        <td>出生日期</td><td>{{employee.birth}}</td>
        <td>身份证</td><td>{{employee.identity}}</td>
    </tr>
    <tr>
        <td>部门</td><td>{{showDeptName}}</td>
        <td>职务</td><td>{{showPostName}}</td>
    </tr>
    <tr>
        <td>登录次数</td><td>{{employee.loc}}</td>
        <td>最后IP</td><td>{{employee.lastIp}}</td>
    </tr>
    <tr>
        <td>创建时间</td><td>{{employee.created}}</td>
        <td>更新时间</td><td>{{employee.updated}}</td>
    </tr>
    <tr>
        <td>说明</td><td colspan="3">{{employee.explain}}</td>
    </tr>
</script>

<script id="deptListTemplate" type="x-tmpl-mustache">
<ol class="dd-list">
    {{#deptList}}
        <li class="dd-item dd2-item dept-name" id="dept_{{id}}" href="javascript:void(0)" data-id="{{id}}">
            <div class="dd2-content" style="cursor:pointer;">
            {{name}}
            <span style="float:right;">
                <a class="green dept-edit" href="#" data-id="{{id}}" >
                    <i class="ace-icon fa fa-pencil bigger-100"></i>
                </a>
                &nbsp;
                <a class="red dept-delete" href="#" data-id="{{id}}" data-name="{{name}}">
                    <i class="ace-icon fa fa-trash-o bigger-100"></i>
                </a>
            </span>
            </div>
        </li>
    {{/deptList}}
</ol>
</script>

<script id="postListTemplate" type="x-tmpl-mustache">
{{#postList}}
<div class="col-xs-2 ud-emp-center">
<div class="text-center">
    <a href="#" onclick="message()" class="post-select" data-id="{{id}}" title="查询">{{name}}</a> &nbsp;
    <a class="green post-edit" href="#" data-id="{{id}}" title="编辑">
        <i class="ace-icon fa fa-pencil bigger-100"></i></a> &nbsp;
    <a class="red post-delete" href="#" data-id="{{id}}"  data-name="{{name}}" title="删除">
        <i class="glyphicon glyphicon-trash bigger-100"></i></a> &nbsp;
</div>
</div>
{{/postList}}
</script>

<script id="employeeListTemplate" type="x-tmpl-mustache">
{{#employeeList}}
<tr role="row" class="emp-name odd" data-id="{{id}}"><!--even -->
    <td><a href="#" class="emp-edit" data-id="{{id}}">{{name}}</a></td>
    <td>{{loginName}}</td>
    <td>{{tel}}</td>
    <td>{{phone}}</td>
    <td>{{email}}</td>
    <td>{{showDeptName}}</td>
    <td>{{showPostName}}</td> <!-- 此处套用函数对status做特殊处理 -->
    <td>
        <div class="hidden-sm hidden-xs action-buttons">
            <a class="green emp-edit" href="#" data-id="{{id}}">
                <i class="ace-icon fa fa-pencil bigger-100" title="编辑"></i>
            </a>
            <a class="red emp-detail" href="#" data-id="{{id}}">
                <i class="ace-icon glyphicon glyphicon-list-alt bigger-100" title="详细"></i>
            </a>
            <a class="red emp-delete" href="#" data-id="{{id}}"  data-name="{{name}}" title="删除">
                <i class="glyphicon glyphicon-trash bigger-100"></i></a> &nbsp;
            <a class="red emp-acl" href="#" data-id="{{id}}">
                <i class="ace-icon fa fa-flag bigger-100" title="权限"></i>
            </a>
        </div>
    </td>
</tr>
{{/employeeList}}
</script>

<script type="application/javascript">
    $(function() {
        //数据初始化
        var deptList; // 存储树形部门列表
        var postList; // 存储职务列表
        var deptMap = {}; // 存储map格式的部门信息
        var empMap = {}; // 存储map格式的用户信息
        var postMap = {}; // 存储map格式的职务信息

        var optionStr = "";
        var optionPostStr = "";
        var lastClickDeptId = -1;

        //部门列表模板
        var deptListTemplate = $('#deptListTemplate').html();
        Mustache.parse(deptListTemplate); //用 Mustache 解析
        //员工列表模板
        var employeeListTemplate = $('#employeeListTemplate').html();
        Mustache.parse(employeeListTemplate);//用 Mustache 解析

        //职务列表模板
        var postListTemplate = $('#postListTemplate').html();
        Mustache.parse(postListTemplate);

        //员工详细模板
        var employeeDetailTemplate = $('#employeeDetailTemplate').html();
        Mustache.parse(employeeDetailTemplate);

        //加载部门树
        loadDeptTree();

        //初始化时间控件
        $("#empbirth").datetime();


        /**
         * 加载部门树
         */
        function loadDeptTree() {
            $(".dropdown-menu").css("z-index", 9999);
            $.ajax({
                url: "/sys/dept/tree.json",
                success : function (result) {
                    if (result.status == 200) {
                        deptList = result.data;
                        var rendered = Mustache.render(deptListTemplate, {deptList: deptList});
                        $("#deptList").html(rendered);
                        recursiveRenderDept(deptList);
                        bindDeptClick();
                    } else {
                        showMessage("加载部门列表", result.msg, false);
                    }
                }
            });
            //加载职务列表
            loadPostList();
        }

        // 递归渲染部门树
        function recursiveRenderDept(deptList) {
            if(deptList && deptList.length > 0) {
                $(deptList).each(function (i, dept) {
                     deptMap[dept.id] = dept;
                     if (dept.deptList.length > 0) {
                         var rendered = Mustache.render(deptListTemplate, {deptList: dept.deptList});
                         $("#dept_" + dept.id).append(rendered);
                         recursiveRenderDept(dept.deptList);
                     }
                })
            }
        }

        // 绑定部门点击事件
        function bindDeptClick() {

            $(".dept-name").click(function(e) {
                e.preventDefault();
                e.stopPropagation();
                var deptId = $(this).attr("data-id");
                handleDepSelected(deptId);
            });

            $(".dept-delete").click(function (e) {
                e.preventDefault();
                e.stopPropagation();
                var deptId = $(this).attr("data-id");
                var deptName = $(this).attr("data-name");
                if (confirm("确定要删除部门[" + deptName + "]吗?")) {
                    $.ajax({
                        url: "/sys/dept/delete.json",
                        data: {
                            id: deptId
                        },
                        success: function (result) {
                            if (result.status == 200) {
                                showMessage("删除部门[" + deptName + "]", "操作成功", true);
                                loadDeptTree();
                            } else {
                                showMessage("删除部门[" + deptName + "]", result.msg, false);
                            }
                        }
                    });
                }
            });

            $(".dept-edit").click(function(e) {
                e.preventDefault();
                e.stopPropagation();
                var deptId = $(this).attr("data-id");
                $("#dialog-dept-form").dialog({
                    model: true,
                    width : 380,
                    title: "编辑部门",
                    resizable:false,
                    position: { using:function(pos){
                        var topOffset = $(this).css(pos).offset().top;
                        if (topOffset == 0||topOffset>0) {
                            $(this).css('top', 20);
                        }
                    }},
                    open: function(event, ui) {
                        $(".ui-dialog-titlebar-close", $(this).parent()).hide();
                        optionStr = "<option value=\"0\">-</option>";
                        recursiveRenderDeptSelect(deptList, 1);
                        $("#deptForm")[0].reset();
                        $("#parentId").html(optionStr);
                        $("#deptId").val(deptId);
                        var targetDept = deptMap[deptId];
                        if (targetDept) {
                            $("#parentId").val(targetDept.parentId);
                            $("#deptName").val(targetDept.name);
                            $("#deptSeq").val(targetDept.seq);
                            $("#deptRemark").val(targetDept.remark);
                        }
                    },
                    buttons : {
                        "更新": function(e) {
                            e.preventDefault();
                            updateDept(false, function (data) {
                                clearData("deptForm");
                                $("#dialog-dept-form").dialog("close");
                            }, function (data) {
                                showMessage("更新部门", data.msg, false);
                            })
                        },
                        "取消": function () {
                            clearData("deptForm");
                            $("#dialog-dept-form").dialog("close");
                        }
                    }
                });
            });

        }

        //添加部门点击 事件
        $(".btn-dept-add").click(function() {
            $("#dialog-dept-form").dialog({
                model: true,
                width :380,
                title: "新增部门",
                resizable:false,
                position: { using:function(pos){
                    var topOffset = $(this).css(pos).offset().top;
                    if (topOffset == 0||topOffset>0) {
                        $(this).css('top', 20);
                    }
                }},
                open: function(event, ui) {
                    $(".ui-dialog-titlebar-close", $(this).parent()).hide();
                    optionStr = "<option value=\"0\">-</option>";
                    recursiveRenderDeptSelect(deptList, 1);
                    $("#deptForm")[0].reset();
                    $("#parentId").html(optionStr);
                },
                buttons : {
                    "添加": function(e) {
                        e.preventDefault();
                        $(".ui-dialog-buttonset").attr("disabled","disabled");
                        updateDept(true, function (data) {
                            $("#dialog-dept-form").dialog("close");
                        }, function (data) {
                            showMessage("新增部门", data.msg, false);
                        },function (evt,data) {
                            $(".ui-dialog-buttonset").removeAttr("disabled");
                        })
                    },
                    "取消": function () {
                        $("#dialog-dept-form").dialog("close");
                    }
                }
            });
        });

        //部门选中操作
        function handleDepSelected(deptId) {
            if (lastClickDeptId != -1) {
                var lastDept = $("#dept_" + lastClickDeptId + " .dd2-content:first");
                lastDept.removeClass("btn-yellow");
                lastDept.removeClass("no-hover");
            }
            var currentDept = $("#dept_" + deptId + " .dd2-content:first");
            currentDept.addClass("btn-yellow");
            currentDept.addClass("no-hover");
            lastClickDeptId = deptId;

            loadEmployeeList(deptId);
        }

        //加载用户列表
        function loadEmployeeList(deptId) {
            var pageSize = $("#pageSize").val();
            var url = "/sys/emp/list.json";
            var pageNo = $("#employeePage .pageNo").val() || 1;
            $.ajax({
                url : url,
                type: 'POST',
                data: {
                    deptId:deptId,
                    pageSize: pageSize,
                    pageNo: pageNo
                },
                success: function (result) {
                    renderEmployeeListAndPage(result, url);
                }
            })
        }

        //渲染员工列表和分页
        function renderEmployeeListAndPage(result, url) {
            if (result.status == 200) {
                if (result.data.total > 0){
                    var rendered = Mustache.render(employeeListTemplate, {
                        employeeList: result.data.data,
                        "showDeptName": function() {
                            return deptMap[this.deptId].name;
                        },
                        "showPostName": function() {
                            return postMap[this.postId].name;
                        },
                    });

                    $("#employeeList").html(rendered);
                    bindEmpClick();//绑定用户点击 方法
                    $.each(result.data.data, function(i, user) {
                        empMap[user.id] = user;
                    })
                } else {
                    $("#employeeList").html('');
                }
                var pageSize = $("#pageSize").val();
                var pageNo = $("#employeePage .pageNo").val() || 1;
                renderPage(url, result.data.total, pageNo, pageSize, result.data.total > 0 ? result.data.data.length : 0, "employeePage", renderEmployeeListAndPage);
            } else {
                showMessage("获取部门下用户列表", result.msg, false);
            }
        }

        //添加用户点击 事件
        $(".btn-employee-add").click(function() {
            $("#dialog-employee-form").dialog({
                autoOpen:true,
                width:"700",
                model: true,
                title: "新增员工",
                resizable:false,
                position: { using:function(pos){
                    var topOffset = $(this).css(pos).offset().top;
                    if (topOffset == 0||topOffset>0) {
                        $(this).css('top', 20);
                    }
                }},
                open: function(event, ui) {
                    $(".ui-dialog-titlebar-close", $(this).parent()).hide();
                    $(".ui-dialog").css("z-index", 1001);
                    optionStr = "";
                    optionPostStr = "";
                    recursiveRenderDeptSelect(deptList, 1);
                    renderPostSelect(postList);
                    $("#employeeForm")[0].reset();
                    $("#deptSelectId").html(optionStr);
                    $("#postSelectId").html(optionPostStr);
                },
                buttons : {
                    "添加": function(e) {
                        e.preventDefault();
                        updateEmployee(true, function (data) {
                            $("#dialog-employee-form").dialog("close");
                            loadEmployeeList(lastClickDeptId);
                        }, function (data) {
                            showMessage("新增员工", data.msg, false);
                        })
                    },
                    "取消": function () {
                        $("#dialog-employee-form").dialog("close");
                    }
                }
            });
        });

        //绑定展示条数
        $(".input-sm").change(function () {
            loadEmployeeList(lastClickDeptId);
        });

        /**
         * 绑定用户点击
         */
        function bindEmpClick() {
            //详细信息
            $(".emp-detail").click(function (e) {
                e.preventDefault();
                e.stopPropagation();
                var employeeId = $(this).attr("data-id");
                $.ajax({
                    url:'/sys/emp/detail.json',
                    type:'POST',
                    data:{employeeId:employeeId},
                    success:function (result) {
                        if (result.status == 200){
                            $("#dialog-employee-detail").dialog({
                                width:"700",
                                model: true,
                                title: "员工详细信息",
                                resizable:false,
                                position: { using:function(pos){
                                    var topOffset = $(this).css(pos).offset().top;
                                    if (topOffset == 0||topOffset>0) {
                                        $(this).css('top', 20);
                                    }
                                }},
                                open: function(event, ui) {
                                    $(".ui-dialog-titlebar-close", $(this).parent()).hide();
                                    var employee = result.data;

                                    var rendered = Mustache.render(employeeDetailTemplate, {
                                        employee: employee,
                                        "showDeptName": function() {
                                            return deptMap[employee.deptId].name;
                                        },
                                        "showPostName": function() {
                                            return postMap[employee.postId].name;
                                        }
                                    });
                                    $("#employeeDetail").html(rendered);
                                },
                                buttons : {
                                    "取消": function () {
                                        $("#dialog-employee-detail").dialog("close");
                                    }
                                }
                            });
                        }
                    }
                });
            });

            //编辑信息
            $(".emp-edit").click(function(e) {
                e.preventDefault();
                e.stopPropagation();
                var employeeId = $(this).attr("data-id");

                $.ajax({
                    url:'/sys/emp/detail.json',
                    type:'POST',
                    data:{employeeId:employeeId},
                    success:function (result) {
                        if (result.status == 200) {
                            $("#dialog-employee-form").dialog({
                                width:"700",
                                model: true,
                                title: "编辑员工",
                                resizable:false,
                                position: { using:function(pos){
                                    var topOffset = $(this).css(pos).offset().top;
                                    if (topOffset == 0||topOffset>0) {
                                        $(this).css('top', 20);
                                    }
                                }},
                                open: function(event, ui) {
                                    $(".ui-dialog-titlebar-close", $(this).parent()).hide();
                                    optionStr = "";
                                    optionPostStr = "";
                                    recursiveRenderDeptSelect(deptList, 1);
                                    renderPostSelect(postList);
                                    $("#employeeForm")[0].reset();
                                    $("#deptSelectId").html(optionStr);
                                    $("#postSelectId").html(optionPostStr);

                                    var targetEmployee = result.data;
                                    if (targetEmployee) {
                                        $("#deptSelectId").val(targetEmployee.deptId);
                                        $("#postSelectId").val(targetEmployee.postId);
                                        $("#empname").val(targetEmployee.name);
                                        $("#emploginname").val(targetEmployee.loginName);
                                        $("#emptel").val(targetEmployee.tel);
                                        $("#empphone").val(targetEmployee.phone);
                                        $("#empemail").val(targetEmployee.email);
                                        $("#empqq").val(targetEmployee.qq);
                                        $("#empfax").val(targetEmployee.fax);
                                        $("#empadd").val(targetEmployee.add);
                                        $("#empbirth").val(targetEmployee.birth);
                                        $("#empidentity").val(targetEmployee.identity);
                                        $("#empexplain").val(targetEmployee.explain);
                                        $("#empid").val(targetEmployee.id);
                                    }
                                },
                                buttons : {
                                    "更新": function(e) {
                                        e.preventDefault();
                                        updateEmployee(false, function (data) {
                                            clearData("employeeForm");
                                            $("#dialog-employee-form").dialog("close");
                                            loadEmployeeList(lastClickDeptId);
                                        }, function (data) {
                                            showMessage("更新员工", data.msg, false);
                                        })
                                    },
                                    "取消": function () {
                                        clearData("employeeForm");
                                        $("#dialog-employee-form").dialog("close");
                                    }
                                }
                            });
                        }
                    }
                })
            });
            $(".emp-delete").click(function (e) {
                e.preventDefault();
                e.stopPropagation();
                var empId = $(this).attr("data-id");
                var empName = $(this).attr("data-name");
                if (confirm("确定要删除员工[" + empName + "]吗?")) {
                    $.ajax({
                        url: "/sys/emp/delete.json",
                        type: "POST",
                        data: {
                            id: empId
                        },
                        success: function (result) {
                            if (result.status == 200) {
                                showMessage("删除员工[" + empName + "]", "操作成功", true);
                                loadEmployeeList(lastClickDeptId);
                            } else {
                                showMessage("删除员工[" + empName + "]", result.msg, false);
                            }
                        }
                    });
                }
            });
        }

        //递归渲染部门选中
        function recursiveRenderDeptSelect(deptList, level) {
            level = level | 0;
            if (deptList && deptList.length > 0) {
                $(deptList).each(function (i, dept) {
                    deptMap[dept.id] = dept;
                    var blank = "";
                    if (level > 1) {
                        for(var j = 3; j <= level; j++) {
                            blank += "..";
                        }
                        blank += "  ∟";
                    }
                    optionStr += Mustache.render("<option value='{{id}}'>{{name}}</option>", {id: dept.id, name: blank + dept.name});
                    if (dept.deptList && dept.deptList.length > 0) {
                        recursiveRenderDeptSelect(dept.deptList, level + 1);
                    }
                });
            }
        }

        //更新用户信息
        function updateEmployee(isCreate, successCallback, failCallback) {
            $.ajax({
                url: isCreate ? "/sys/emp/save.json" : "/sys/emp/update.json",
                data: $("#employeeForm").serializeArray(),
                type: 'POST',
                success: function(result) {
                    if (result.status == 200) {
                        loadDeptTree();
                        if (successCallback) {
                            successCallback(result);
                        }
                    } else {
                        if (failCallback) {
                            failCallback(result);
                        }
                    }
                }
            })
        }

        //更新部门信息
        function updateDept(isCreate, successCallback, failCallback,completeCallback) {
            $.ajax({
                url: isCreate ? "/sys/dept/save.json" : "/sys/dept/update.json",
                data: $("#deptForm").serializeArray(),
                type: 'POST',
                success: function(result) {
                    if (result.status == 200) {
                        loadDeptTree();
                        if (successCallback) {
                            successCallback(result);
                        }
                    } else {
                        if (failCallback) {
                            failCallback(result);
                        }
                    }
                },
                complete : function (evt,data) {
                    if (completeCallback) {
                        completeCallback(evt,data);
                    }
                }
            });
        }

        //添加用户点击 事件
        $(".btn-post-add").click(function() {
            $("#dialog-post-form").dialog({
                model: true,
                width : 380,
                title: "新增职务",
                resizable:false,
                position: { using:function(pos){
                    var topOffset = $(this).css(pos).offset().top;
                    if (topOffset == 0||topOffset>0) {
                        $(this).css('top', 20);
                    }
                }},
                open: function(event, ui) {
                    $(".ui-dialog-titlebar-close", $(this).parent()).hide();
                    $("#postForm")[0].reset();
                },
                buttons : {
                    "添加": function(e) {
                        e.preventDefault();
                        updatePost(true, function (data) {
                            $("#dialog-post-form").dialog("close");
                            loadPostList();
                        }, function (data) {
                            showMessage("新增职务", data.msg, false);
                        })
                    },
                    "取消": function () {
                        $("#dialog-post-form").dialog("close");
                    }
                }
            });
        });

        function updatePost(isCreate, successCallback, failCallback) {
            $.ajax({
                url: isCreate ? "/sys/post/save.json" : "/sys/post/update.json",
                data: $("#postForm").serializeArray(),
                type: 'POST',
                success: function(result) {
                    if (result.status == 200) {
                        loadDeptTree();
                        if (successCallback) {
                            successCallback(result);
                        }
                    } else {
                        if (failCallback) {
                            failCallback(result);
                        }
                    }
                }
            })
        }

        //加载用户列表
        function loadPostList() {
            var url = "/sys/post/list.json";
            $.ajax({
                url : url,
                success: function (result) {
                    renderPostList(result);
                }
            })
        }

        //渲染职务列表
        function renderPostList(result) {
            if (result.status == 200) {
                if (result.data.total > 0){
                    postList = result.data.data;
                    var rendered = Mustache.render(postListTemplate,{postList: result.data.data});

                    //=================================================== =========
                    $("#postList").html(rendered);
                    bindPostClick();//绑定职务点击 方法
                    $.each(result.data.data, function(i, post) {
                        postMap[post.id] = post;
                    })
                } else {
                    $("#postList").html('');
                }
            } else {
                showMessage("获取部门下职务列表", result.msg, false);
            }
        }

        //渲染职务选中
        function renderPostSelect(postList) {
            if (postList && postList.length > 0) {
                $(postList).each(function (i, post) {
                    postMap[post.id] = post;
                    optionPostStr += Mustache.render("<option value='{{id}}'>{{name}}</option>", {id: post.id, name: post.name});
                });
            }
        }

        function bindPostClick() {
            $(".post-edit").click(function(e) {
                e.preventDefault();
                e.stopPropagation();
                var postId = $(this).attr("data-id");
                $("#dialog-post-form").dialog({
                    model: true,
                    width : 380,
                    title: "编辑职务",
                    resizable:false,
                    position: { using:function(pos){
                        var topOffset = $(this).css(pos).offset().top;
                        if (topOffset == 0||topOffset>0) {
                            $(this).css('top', 20);
                        }
                    }},
                    open: function(event, ui) {
                        $(".ui-dialog-titlebar-close", $(this).parent()).hide();

                        $("#postForm")[0].reset();
                        $("#postId").val(postId);
                        var targetPost = postMap[postId];
                        if (targetPost) {
                            $("#postName").val(targetPost.name);
                            $("#postExplain").val(targetPost.explain);
                        }
                    },
                    buttons : {
                        "更新": function(e) {
                            e.preventDefault();
                            updatePost(false, function (data) {
                                clearData("postForm");
                                $("#dialog-post-form").dialog("close");
                            }, function (data) {
                                showMessage("更新职务", data.msg, false);
                            })
                        },
                        "取消": function () {
                            clearData("Form");
                            $("#dialog-post-form").dialog("close");
                        }
                    }
                });
            });

            $(".post-delete").click(function (e) {
                e.preventDefault();
                e.stopPropagation();
                var postId = $(this).attr("data-id");
                var postName = $(this).attr("data-name");
                if (confirm("确定要删除职务[" + postName + "]吗?")) {
                    $.ajax({
                        url: "/sys/post/delete.json",
                        data: {
                            id: postId
                        },
                        success: function (result) {
                            if (result.status == 200) {
                                showMessage("删除职务[" + postName + "]", "操作成功", true);
                                loadPostList();
                            } else {
                                showMessage("删除职务[" + postName + "]", result.msg, false);
                            }
                        }
                    });
                }
            });
        }
    })
</script>

<script src="/js/defined/manager.js"></script>

</body>
</html>