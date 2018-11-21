<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>商品类目管理</title>
    <jsp:include page="/common/common.jsp"/>
    <jsp:include page="/common/page.jsp"/>
</head>
<body class="no-skin init-iframe-box" youdao="bind" style="background: white">

<input id="gritter-light" checked="" type="checkbox" class="ace ace-switch ace-switch-5"/>

<div class="iframe-child">
    <div class="page-header">
        <h1>
            商品类目管理
            <small>
                <i class="ace-icon fa fa-angle-double-right"></i>
                维护商品类目
            </small>
        </h1>
    </div>

    <div class="ud-search-container">
        <label for="coca-search">名称</label>
        <input type="text" name="name" id="coca-search" placeholder="请输入关键字" class="text ui-widget-content ui-corner-all">
        <button class="btn btn-primary ud-radius coca-search-btn">
            <i class="fa fa-search">&nbsp;&nbsp;</i>搜索
        </button>
    </div>

    <div class="main-content-inner">
    <div class="col-xs-12">
        <div class="table-header">
            商品类目列表&nbsp;&nbsp;
            <a class="green" href="#">
                <i class="ace-icon fa fa-plus-circle orange bigger-130 co-ca-add"></i>
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
                        说明
                    </th>
                    <th class="sorting_disabled" rowspan="1" colspan="1" aria-label=""></th>
                </tr>
                </thead>
                <tbody id="commodityCategoryList"></tbody>
            </table>

            <div class="row" id="commodityCategoryPage">
            </div>
        </div>

    </div>
</div>
</div>

<div id="dialog-commodity-category-form" style="display: none;">
    <form id="commodityCategoryForm">
        <table class="table table-striped table-bordered table-hover dataTable no-footer" role="grid">
            <tr>
                <td style="width: 80px;"><label for="coca-parent-id">上级类目</label></td>
                <td>
                    <select id="coca-parent-id" name="parentId" data-placeholder="选择类目" style="width: 200px;"></select>
                    <input type="hidden" name="id" id="hidden-coca-id"/>
                </td>
            </tr>
            <tr>
                <td><label for="coca-name">名称</label></td>
                <td><input type="text" name="name" id="coca-name" value="" class="text ui-widget-content ui-corner-all"></td>
            </tr>
            <tr>
                <td><label for="coca-seq">顺序</label></td>
                <td><input type="text" name="seq" id="coca-seq" value="1" class="text ui-widget-content ui-corner-all"></td>
            </tr>
            <tr>
                <td><label for="coca-explain">说明</label></td>
                <td><textarea name="explain" id="coca-explain" class="text ui-widget-content ui-corner-all" rows="3" cols="25"></textarea></td>
            </tr>
        </table>
    </form>
</div>

<script id="commodityCategoryListTemplate" type="x-tmpl-mustache">
{{#commodityCategoryList}}
<tr role="row" class="coca-name odd" data-id="{{id}}"><!--even -->
    <td><a href="#" class="co-ca-edit" data-id="{{id}}">{{name}}</a></td>
    <td>{{parentName}}</td>
    <td>{{seq}}</td>
    <td>{{explain}}</td> <!-- 此处套用函数对status做特殊处理 -->
    <td>
        <div class="hidden-sm hidden-xs action-buttons">
            <a class="green co-ca-edit" href="#" data-id="{{id}}">
                <i class="ace-icon fa fa-pencil bigger-100" title="编辑"></i>
            </a>
            <a class="red co-ca-delete" href="#" data-id="{{id}}"  data-name="{{name}}" title="删除">
                <i class="glyphicon glyphicon-trash bigger-100"></i></a> &nbsp;
        </div>
    </td>
</tr>
{{/commodityCategoryList}}
</script>

<script id="commodityCategoryListTemplate1" type="x-tmpl-mustache">
<ol class="dd-list ">
    {{#commodityCategoryList}}
        <li class="dd2-item coca-name {{displayClass}}" id="coca_{{id}}" href="javascript:void(0)" data-id="{{id}}">
            <div class="dd2-content" style="cursor:pointer;">
            {{name}}
            &nbsp;
            <a class="green {{#showDownAngle}}{{/showDownAngle}}" href="#" data-id="{{id}}" >
                <i class="ace-icon fa fa-angle-double-down bigger-120 sub-coca"
                        id="sub_coca_{{id}}" data-id="{{id}}" data-parentId="{{parentId}}" title="列表"></i>
            </a>
            <span style="float:right;">
                <a class="green commodity-category-edit" href="#" data-id="{{id}}" >
                    <i class="ace-icon fa fa-pencil bigger-100"></i>
                </a>
                &nbsp;
                <a class="red commodity-category-delete" href="#" data-id="{{id}}" data-name="{{name}}">
                    <i class="ace-icon fa fa-trash-o bigger-100"></i>
                </a>
            </span>
            </div>
        </li>
    {{/commodityCategoryList}}
</ol>
</script>

<script src="/js/valid/base-valid.js"></script>
<script src="/js/valid/commodity-category-valid.js"></script>

<script type="application/javascript">
    $(function () {
        // 存储map格式的类目信息
        var commodityCategoryMap = {};

        //表示 加载初始化的列表, false表示 加载 搜索的列表
        var addAndUpdateLoadMethod = true;

        var optionStr = "";
        var lastClickCocaId = -1;

        //类目列表模板
        var commodityCategoryListTemplate = $('#commodityCategoryListTemplate').html();
        Mustache.parse(commodityCategoryListTemplate); //用 Mustache 解析

        //加载类目树
        load();

        /**
         * 加载部门树
         */
        function loadCommodityCategoryTree() {
            $.ajax({
                url: "/coca/tree.json",
                success: function (result) {
                    if (result.status == 200) {
                        var commodityCategoryList = result.data;

                        var rendered = Mustache.render(commodityCategoryListTemplate, {
                            commodityCategoryList: commodityCategoryList,
                            "showDownAngle": function () {
                                return function (text, render) {
                                    return (this.commodityCategoryList && this.commodityCategoryList.length > 0) ? "" : "hidden";
                                }
                            },
                            "displayClass": function () {
                                return "";
                            }
                        });
                        $("#commodityCategoryList").html(rendered);
                        recursiveRenderCommodityCategory(commodityCategoryList);
                        bindCommodityCategoryClick();
                    } else {
                        showMessage("加载类目列表", result.msg, false);
                    }
                }
            });
        }

        function load() {
            addAndUpdateLoadMethod = true;
            var url = "/sys/coca/list.json";
            var pageSize = $("#pageSize").val();
            var pageNo = $("#commodityCategoryPage .pageNo").val() || 1;

            loadInit(url, load, pageSize, pageNo);
        }

        //搜索
        $(".coca-search-btn").click(function (e) {
            e.preventDefault();
            e.stopPropagation();
            var keyword = $("#coca-search").val();
            if(existNotBlank(keyword)){
                return;
            }
            $("#commodityCategoryPage .pageNo").val(1)
            search();
        });
        
        function search() {
            addAndUpdateLoadMethod = false;
            var pageSize = $("#pageSize").val();
            var pageNo = $("#commodityCategoryPage .pageNo").val() || 1;

            var keyword = $("#coca-search").val();
            var url = "/sys/coca/search.json?keyword=" + keyword;
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
                        var commodityCategoryList = _obj.commodityCategories.data;

                        convertList2Map(_obj.commodityCategorySelect);
                        var rendered = Mustache.render(commodityCategoryListTemplate,
                            {
                                commodityCategoryList: commodityCategoryList,
                                "parentName": function () {

                                    return (this.parentId == 0) ? " - - - " : commodityCategoryMap[this.parentId].name;
                                }
                            });
                        $("#commodityCategoryList").html(rendered);
                        bindCommodityCategoryClick();
                        //渲染分页
                        renderPage(url, _obj.commodityCategories.total, pageNo, pageSize, _obj.commodityCategories.total > 0 ?
                            commodityCategoryList.length : 0, "commodityCategoryPage", callback);

                    } else {
                        showMessage("加载栏目列表", result.msg, false);
                    }
                }
            });
        }

        // 递归渲染类目树
        function recursiveRenderCommodityCategory(commodityCategoryList) {
            if (commodityCategoryList && commodityCategoryList.length > 0) {
                $(commodityCategoryList).each(function (i, commodityCategory) {
                    commodityCategoryMap[commodityCategory.id] = commodityCategory;
                    if (commodityCategory.commodityCategoryList && commodityCategory.commodityCategoryList.length > 0) {
                        var rendered = Mustache.render(commodityCategoryListTemplate,
                            {
                                commodityCategoryList: commodityCategory.commodityCategoryList,
                                "showDownAngle": function () {
                                    return function (text, render) {
                                        return (this.commodityCategoryList && this.commodityCategoryList.length > 0) ? "" : "hidden";
                                        ;
                                    }
                                },
                                "displayClass": function () {
                                    return "hidden";
                                }
                            });
                        $("#coca_" + commodityCategory.id).append(rendered);
                        recursiveRenderCommodityCategory(commodityCategory.commodityCategoryList);
                    }
                })
            }
        };

        // 绑定部门点击事件
        function bindCommodityCategoryClick() {
            //点击 商品类目名称 事件
            $(".coca-name").click(function (e) {
                e.preventDefault();
                e.stopPropagation();
                var cocaId = $(this).attr("data-id");
                // handleCommodityCategorySelected(cocaId);
            });
            //向下箭头点击 事件
            $(".sub-coca").click(function (e) {
                e.preventDefault();
                e.stopPropagation();
                $(this).parent().parent().parent().children().children(".coca-name").toggleClass("hidden");

                var pId = $(this).attr("data-parentId");
                var curId = $(this).attr("data-id");
                if (pId == 0) {

                    if ($(this).is(".fa-angle-double-down")) {//向下转向上
                        if (lastClickCocaId > -1) {
                            $("#sub_coca_" + curId).removeClass("fa-angle-double-down").addClass("fa-angle-double-up");
                            $("#coca_" + curId).children("ol").show();
                            $("#coca_" + curId).children("ol").find('.coca-name').show();
                            $(this).parent().parent().parent().children().children(".coca-name").attr("class", "dd2-item coca-name");
                            $("#sub_coca_" + lastClickCocaId).removeClass("fa-angle-double-up").addClass("fa-angle-double-down");
                            $("#coca_" + lastClickCocaId).children("ol").hide();
                        }
                    } else {//向上转向下
                        $(this).removeClass("fa-angle-double-up").addClass("fa-angle-double-down");
                        $("#coca_" + curId).children("ol").show();
                    }
                    lastClickCocaId = curId;
                } else {
                    if ($(this).is(".fa-angle-double-down")) {//向下转向上
                        $(this).removeClass("fa-angle-double-down").addClass("fa-angle-double-up");
                    } else {//向上转向下
                        $(this).removeClass("fa-angle-double-up").addClass("fa-angle-double-down");
                    }
                }
            });
            //删除 商品类目 事件
            $(".co-ca-delete").click(function (e) {
                e.preventDefault();
                e.stopPropagation();
                var cocaId = $(this).attr("data-id");
                var cocaName = $(this).attr("data-name");
                if (confirm("确定要删除类目[" + cocaName + "]吗?")) {
                    $.ajax({
                        url: "/sys/coca/delete.json",
                        data: {
                            id: cocaId
                        },
                        success: function (result) {
                            if (result.status == 200) {
                                showMessage("删除类目[" + cocaName + "]", "操作成功", true);
                                refresh(addAndUpdateLoadMethod, load, search);
                            } else {
                                showMessage("删除类目[" + cocaName + "]", result.msg, false);
                            }
                        }
                    });
                }
            });
            //编辑商品类目 事件
            $(".co-ca-edit").click(function (e) {
                e.preventDefault();
                e.stopPropagation();
                var cocaId = $(this).attr("data-id");
                var record;
                $.ajax({
                    url : '/coca/detail.json',
                    data : {id : cocaId},
                    success : function (result) {
                        if (result.status == 200) {
                            record = result.data;
                            $.ajax({
                                url : '/coca/tree.json',
                                success : function (res) {
                                    if (res.status == 200) {
                                        var ccList = res.data;
                                        $("#dialog-commodity-category-form").dialog({
                                            model: true,
                                            title: "编辑类目",
                                            open: function (event, ui) {
                                                $(".ui-dialog-titlebar-close", $(this).parent()).hide();
                                                optionStr = "<option value=\"0\">-</option>";
                                                recursiveRenderCommodityCategorySelect(ccList, 1);
                                                $("#commodityCategoryForm")[0].reset();
                                                $("#coca-parent-id").html(optionStr);
                                                $("#hidden-coca-id").val(cocaId);
                                                if (record) {
                                                    $("#coca-parent-id").val(record.parentId);
                                                    $("#coca-name").val(record.name);
                                                    $("#coca-seq").val(record.seq);
                                                    $("#coca-explain").val(record.explain);
                                                }
                                            },
                                            buttons: {
                                                "更新": function (e) {
                                                    e.preventDefault();
                                                    updateCommodityCategory(false, function (data) {
                                                        clearData("commodityCategoryForm");
                                                        $("#dialog-commodity-category-form").dialog("close");
                                                    }, function (data) {
                                                        showMessage("更新类目", data.msg, false);
                                                    })
                                                },
                                                "取消": function () {
                                                    clearData("commodityCategoryForm");
                                                    $("#dialog-commodity-category-form").dialog("close");
                                                }
                                            }
                                        });
                                    }
                                }
                            });
                        }
                    }
                });
            });
        }

        //添加商品类目点击 事件
        $(".co-ca-add").click(function () {
            $.ajax({
                url : '/coca/tree.json',
                success : function (result) {
                    if (result.status == 200) {
                        var ccList = result.data;
                        $("#dialog-commodity-category-form").dialog({
                            model: true,
                            title: "新增栏目",
                            open: function (event, ui) {
                                $(".ui-dialog-titlebar-close", $(this).parent()).hide();
                                optionStr = "<option value=\"0\">-</option>";
                                recursiveRenderCommodityCategorySelect(ccList, 1);
                                $("#commodityCategoryForm")[0].reset();
                                $("#coca-parent-id").html(optionStr);
                            },
                            buttons: {
                                "添加": function (e) {
                                    e.preventDefault();
                                    updateCommodityCategory(true, function (data) {
                                        $("#dialog-commodity-category-form").dialog("close");
                                    }, function (data) {
                                        showMessage("新增栏目", data.msg, false);
                                    })
                                },
                                "取消": function () {
                                    $("#dialog-commodity-category-form").dialog("close");
                                }
                            }
                        });
                    }
                }
            });
        });

        //绑定展示条数
        $(".input-sm").change(function () {
            $("#commodityCategoryPage .pageNo").val(1);
            refresh(addAndUpdateLoadMethod, load, search);
        });

        //转换数据
        function convertList2Map(lists) {
            if (lists && lists.length > 0) {
                $(lists).each(function (i, item) {
                    commodityCategoryMap[item.id] = item;
                });
            }
        }

        //栏目选中操作
        function handleDepSelected(cocaId) {
            // if (lastClickCocaId != -1) {
            //     var lastDept = $("#dept_" + lastClickCocaId + " .dd2-content:first");
            //     lastDept.removeClass("btn-yellow");
            //     lastDept.removeClass("no-hover");
            // }
            // var currentDept = $("#dept_" + deptId + " .dd2-content:first");
            // currentDept.addClass("btn-yellow");
            // currentDept.addClass("no-hover");
            // lastClickCocaId = deptId;
            //
            // loadEmployeeList(deptId);
        }

        //递归渲染栏目选中
        function recursiveRenderCommodityCategorySelect(commodityCategoryList, level) {
            level = level | 0;
            if (commodityCategoryList && commodityCategoryList.length > 0) {
                $(commodityCategoryList).each(function (i, commodityCategory) {
                    commodityCategoryMap[commodityCategory.id] = commodityCategory;
                    var blank = "";
                    if (level > 1) {
                        for (var j = 3; j <= level; j++) {
                            blank += "..";
                        }
                        blank += "  ∟";
                    }
                    optionStr += Mustache.render("<option value='{{id}}'>{{name}}</option>", {
                        id: commodityCategory.id,
                        name: blank + commodityCategory.name
                    });
                    if (commodityCategory.commodityCategoryList && commodityCategory.commodityCategoryList.length > 0) {
                        recursiveRenderCommodityCategorySelect(commodityCategory.commodityCategoryList, level + 1);
                    }
                });
            }
        }

        //更新栏目信息
        function updateCommodityCategory(isCreate, successCallback, failCallback) {
            if (validCommodityCategory()) {
                return;
            }
            $.ajax({
                url: isCreate ? "/sys/coca/save.json" : "/sys/coca/update.json",
                data: $("#commodityCategoryForm").serializeArray(),
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
    });
</script>

<script src="/js/defined/manager.js"></script>
</body>
</html>