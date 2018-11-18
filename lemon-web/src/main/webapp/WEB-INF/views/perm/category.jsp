<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>栏目管理</title>
    <jsp:include page="/common/common.jsp"/>
    <jsp:include page="/common/page.jsp"/>
</head>
<body class="no-skin init-iframe-box" youdao="bind" style="background: white">
<input id="gritter-light" checked="" type="checkbox" class="ace ace-switch ace-switch-5"/>

<div class="iframe-child">

    <div class="page-header">
        <h1>
            栏目管理
            <small>
                <i class="ace-icon fa fa-angle-double-right"></i>
                维护栏目
            </small>
        </h1>
    </div>

    <div class="ud-search-container">
        <label for="category-search">名称</label>
        <select id="search-category-type" name="type" data-placeholder="选择类型" style="width: 200px;">
            <option value="-1"> 选择类型</option>
            <option value="0">顾客</option>
            <option value="1">供应商</option>
            <option value="2">员工</option>
            <option value="3">管理员</option>
        </select>
        <input type="text" name="cateName" id="category-search" placeholder="请输入要查询的名称"
               class="text ui-widget-content ui-corner-all">
        <button class="btn btn-primary ud-radius cate-search-btn popstyle">
            <i class="fa fa-search">&nbsp;&nbsp;</i>搜索
        </button>
    </div>

    <div class="main-content-inner">
        <div class="col-xs-12">
            <div class="table-header">
                栏目列表&nbsp;&nbsp;
                <a class="green" href="#">
                    <i class="ace-icon fa fa-plus-circle orange bigger-130 btn-category-add"></i>
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
                                上级名称
                            </th>
                            <th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
                                排序
                            </th>
                            <th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
                                前面样式
                            </th>
                            <th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
                                后面样式
                            </th>
                            <th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
                                链接地址
                            </th>
                            <th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
                                状态
                            </th>
                            <th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
                                类型
                            </th>
                            <th class="sorting_disabled" rowspan="1" colspan="1" aria-label=""></th>
                        </tr>
                        </thead>
                        <tbody id="categoryList"></tbody>
                    </table>

                    <div class="row" id="categoryPage">
                    </div>
                </div>

        </div>
    </div>

</div>

<%-- --%>
<div id="dialog-category-form" style="display: none;">
    <form id="categoryForm">
        <table class="table table-bordered dataTable no-footer" role="grid">
            <tr>
                <td><label for="catename">名称</label></td>
                <input type="hidden" name="id" id="cateId"/>
                <td><input type="text" name="name" id="catename" value=""
                           class="text form-control"></td>
            </tr>
            <tr>
                <td><label for="cateSelectId">栏目</label></td>
                <td>
                    <select id="cateSelectId" name="parentId" data-placeholder="选择栏目" style="width: 168px;"></select>
                </td>
            </tr>
            <tr>
                <td><label for="cateseq">排序</label></td>
                <td><input type="text" name="seq" id="cateseq" value="" class="text form-control"></td>
            </tr>
            <tr>
                <td><label for="catebeforestyle">前面样式</label></td>
                <td><input type="text" name="beforeStyle" id="catebeforestyle" value="" class="text form-control"></td>
            </tr>
            <tr>
                <td><label for="cateafterstyle">后面样式</label></td>
                <td><input type="text" name="afterStyle" id="cateafterstyle" value="" class="text form-control"></td>
            </tr>
            <tr>
                <td><label for="cateurl">链接地址</label></td>
                <td><input type="text" name="url" id="cateurl" value="" class="text form-control"></td>
            </tr>
            <tr>
                <td><label for="catestatus">状态</label></td>
                <td>
                    <select id="catestatus" name="status" data-placeholder="选择状态" style="width: 200px;">
                        <option value="1">可用</option>
                        <option value="0">不可用</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td><label for="catetype">类型</label></td>
                <td>
                    <select id="catetype" name="type" data-placeholder="选择类型" style="width: 200px;">
                        <option value="0">顾客</option>
                        <option value="1">供应商</option>
                        <option value="2">员工</option>
                        <option value="3">管理员</option>
                    </select>
                </td>
            </tr>
        </table>
    </form>
</div>

<script id="categoryListTemplate" type="x-tmpl-mustache">
{{#categoryList}}
<tr role="row" class="cate-name odd" data-id="{{id}}"><!--even -->
    <td><a href="#" class="cate-edit" data-id="{{id}}">{{name}}</a></td>
    <td>{{#showParent}}{{showParentId}}{{/showParent}}</td>
    <td>{{seq}}</td>
    <td>{{beforeStyle}}</td>
    <td>{{afterStyle}}</td>
    <td>{{url}}</td>
    <td>{{#status1}}{{showStatus}}{{/status1}}</td>
    <td>{{#type1}}{{showType}}{{/type1}}</td> <!-- 此处套用函数对status做特殊处理 -->
    <td>
        <div class="hidden-sm hidden-xs action-buttons">
            <a class="green cate-edit" href="#" data-id="{{id}}">
                <i class="ace-icon fa fa-pencil bigger-100" title="编辑"></i>
            </a>
            <a class="red cate-delete" href="#" data-id="{{id}}"  data-name="{{name}}" title="删除">
                <i class="glyphicon glyphicon-trash bigger-100"></i></a> &nbsp;
        </div>
    </td>
</tr>
{{/categoryList}}
</script>

<script type="application/javascript">
    $(function () {
        //存储
        var selectMap = {};

        var optionStr = '';
        //表示 加载初始化的列表, false表示 加载 搜索的列表
        var addAndUpdateLoadMethod = true;

        //部门列表模板
        var categoryListTemplate = $('#categoryListTemplate').html();
        Mustache.parse(categoryListTemplate); //用 Mustache 解析

        //加载栏目
        load();

        /**
         * 加载
         */
        function load() {
            addAndUpdateLoadMethod = true;
            var url = "/sys/cate/list.json";
            var pageSize = $("#pageSize").val();
            var pageNo = $("#categoryPage .pageNo").val() || 1;
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
                        selectMap=  result.data.select;
                        var _obj = result.data.page;
                        var categoryList = _obj.data;
                        var rendered = Mustache.render(categoryListTemplate,
                            {categoryList: categoryList,
                                "showParentId":function () {
                                    return this.parentId;
                                },
                                "showParent":function () {
                                    return function (text,render) {
                                        var _pi = render(text);
                                        if (_pi == 0){
                                            return "<span class='label label-lg label-purple'>最高栏目</span>";
                                        }
                                        return selectMap[_pi].name;
                                    }
                                },
                                "showStatus":function () {
                                    return this.status;
                                },
                                "status1":function () {
                                    return function (text,render) {
                                        var _status = render(text);
                                        if (_status == 1) {
                                            return "<span class='label label-lg label-success'>可用</span>";
                                        } else {
                                            return "<span class='label label-lg label-warning'>不可用</span>";
                                        }
                                    }
                                },
                                "showType":function () {
                                    return this.type;
                                },
                                "type1":function () {
                                    return function (text, render) {
                                        var type = render(text);
                                        if (type == 0){
                                            return "<span class='label label-lg label-info'>顾客</span>";
                                        }else if (type == 1){
                                            return "<span class='label label-lg label-success'>供应商</span>";
                                        }else if (type == 2){
                                            return "<span class='label label-lg label-warning'>员工</span>";
                                        }else if (type == 3){
                                            return "<span class='label label-lg label-danger'>管理员</span>";
                                        }else {
                                            return '';
                                        }
                                    };
                                }
                            });

                        $("#categoryList").html(rendered);
                        bindCategoryClick();
                        //渲染分页
                        renderPage(url, _obj.total, pageNo, pageSize, _obj.total > 0 ? categoryList.length : 0, "categoryPage", callback);
                    } else {
                        showMessage("加载栏目列表", result.msg, false);
                    }
                }
            });
        }

        //绑定事件
        function bindCategoryClick() {
            $(".cate-delete").click(function (e) {
                e.preventDefault();
                e.stopPropagation();
                var cateId = $(this).attr("data-id");
                var cateName = $(this).attr("data-name");
                if (confirm("确定要删除栏目[" + cateName + "]吗?")) {
                    $.ajax({
                        url: "/sys/cate/delete.json",
                        data: {
                            id: cateId
                        },
                        success: function (result) {
                            if (result.status == 200) {
                                showMessage("删除栏目[" + cateName + "]", "操作成功", true);
                                refresh(addAndUpdateLoadMethod, load, search);
                            } else {
                                showMessage("删除栏目[" + cateName + "]", result.msg, false);
                            }
                        }
                    });
                }
            });

            $(".cate-edit").click(function (e) {
                e.preventDefault();
                e.stopPropagation();
                var cateId = $(this).attr("data-id");
                $.ajax({
                    url: '/sys/cate/detail.json',
                    data: {id: cateId},
                    type: 'POST',
                    success: function (result) {
                        if (result.status == 200) {

                            $("#dialog-category-form").dialog({
                                model: true,
                                width: 480,
                                title: "编辑栏目",
                                open: function (event, ui) {
                                    $(".ui-dialog-titlebar-close", $(this).parent()).hide();
                                    selectMap = result.data.select;
                                    optionStr = "<option value='0'>最高栏目</option>";
                                    renderCategorySelect(selectMap);
                                    $("#categoryForm")[0].reset();
                                    $("#cateSelectId").html(optionStr);
                                    $("#cateId").val(cateId);
                                    var targetCategory = result.data.category;
                                    if (targetCategory) {
                                        $("#cateSelectId").val(targetCategory.parentId);
                                        $("#catename").val(targetCategory.name);
                                        $("#cateseq").val(targetCategory.seq);
                                        $("#catebeforestyle").val(targetCategory.beforeStyle);
                                        $("#cateafterstyle").val(targetCategory.afterStyle);
                                        $("#cateurl").val(targetCategory.url);
                                        $("#catestatus").val(targetCategory.status);
                                        $("#catetype").val(targetCategory.type);
                                    }
                                },
                                buttons: {
                                    "更新": function (e) {
                                        e.preventDefault();
                                        updateCategory(false, function (data) {
                                            clearData("categoryForm");
                                            $("#dialog-category-form").dialog("close");
                                        }, function (data) {
                                            showMessage("更新栏目", data.msg, false);
                                        })
                                    },
                                    "取消": function () {
                                        clearData("categoryForm");
                                        $("#dialog-category-form").dialog("close");
                                    }
                                }
                            });

                        }
                    }
                });
            });
        }

        //渲染下拉框
        function renderCategorySelect(selectMap) {
            if (selectMap) {
                $.map(selectMap, function (item) {
                    if (item.parentId == 0) {
                        optionStr += Mustache.render("<option value='{{id}}'>&nbsp;&nbsp;∟{{name}}</option>",
                            {id: item.id, name: item.name});
                    }
                });
            }
        }

        //添加栏目
        $(".btn-category-add").click(function (e) {
            e.preventDefault();
            e.stopPropagation();

            $.ajax({
                url: '/sys/cate/select.json',
                type: 'POST',
                data: {parentId: -1, isSelect: true},
                success: function (result) {
                    if (result.status == 200) {
                        selectMap = result.data;
                        optionStr = "<option value='0'>最高栏目</option>";
                        renderCategorySelect(selectMap);
                        $("#categoryForm")[0].reset();
                        $("#cateSelectId").html(optionStr);

                        $("#dialog-category-form").dialog({
                            model: true,
                            width: 480,
                            title: "添加栏目",
                            open: function (event, ui) {
                                $(".ui-dialog-titlebar-close", $(this).parent()).hide();
                                $("#categoryForm")[0].reset();
                            },
                            buttons: {
                                "添加": function (e) {
                                    e.preventDefault();
                                    updateCategory(true, function (data) {
                                        $("#dialog-category-form").dialog("close");
                                    }, function (data) {
                                        showMessage("新增栏目", data.msg, false);
                                    })
                                },
                                "取消": function () {
                                    $("#dialog-category-form").dialog("close");
                                }
                            }
                        });
                    }
                }
            });

        });

        //搜索
        $(".cate-search-btn").click(function (e) {
            e.preventDefault();
            e.stopPropagation();
            var keyword = $("#category-search").val();
            var type = $("#search-category-type").val();
            if((existNotBlank(keyword)) && type < 0){
                return;
            }
            $("#categoryPage .pageNo").val(1)
            search();
        });

        //加载 搜索
        function search() {
            addAndUpdateLoadMethod = false;
            var pageSize = $("#pageSize").val();
            var pageNo = $("#categoryPage .pageNo").val() || 1;

            var name = $("#category-search").val();
            var type = $("#search-category-type").val();
            var url = "/sys/cate/search.json?name=" + name + "&type=" + type;
            loadInit(url, search,pageSize, pageNo);
        }

        //更新栏目信息
        function updateCategory(isCreate, successCallback, failCallback) {
            $.ajax({
                url: isCreate ? "/sys/cate/save.json" : "/sys/cate/update.json",
                data: $("#categoryForm").serializeArray(),
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
            $("#categoryPage .pageNo").val(1);
            refresh(addAndUpdateLoadMethod, load, search);
        });

    });
</script>

<script src="/js/defined/manager.js"></script>

</body>
</html>
