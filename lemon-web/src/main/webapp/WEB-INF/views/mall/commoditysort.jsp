<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>商品分类管理</title>
    <jsp:include page="/common/common.jsp"/>
    <jsp:include page="/common/page.jsp"/>
</head>
<body class="no-skin init-iframe-box" youdao="bind" style="background: white">

<input id="gritter-light" checked="" type="checkbox" class="ace ace-switch ace-switch-5"/>

<div class="iframe-child">
    <div class="page-header">
        <h1>
            商品分类管理
            <small>
                <i class="ace-icon fa fa-angle-double-right"></i>
                维护商品分类
            </small>
        </h1>
    </div>

    <div class="ud-search-container">
        <label for="coso-search">名称</label>
        <input type="text" name="name" id="coso-search" placeholder="请输入关键字" class="text ui-widget-content ui-corner-all">
        <button class="btn btn-primary ud-radius coso-search-btn" formtarget="innerFrame">
            <i class="fa fa-search">&nbsp;&nbsp;</i>搜索
        </button>
    </div>

    <div class="main-content-inner">

        <div class="col-xs-9">
            <div class="table-header">
                商品分类列表&nbsp;&nbsp;
                <a class="green" href="#">
                    <i class="ace-icon fa fa-plus-circle orange bigger-130 commodity-sort-add"></i>
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
                    <tbody id="commoditySortList"></tbody>
                </table>

                <div class="row" id="commoditySortPage">
                </div>
            </div>

        </div>

        <div class="col-xs-3">
        </div>
    </div>
</div>

<div id="dialog-commodity-sort-form" style="display: none;">
    <form id="commoditySortForm">
        <table class="table table-striped table-bordered table-hover dataTable no-footer" role="grid">
            <tr>
                <td style="min-width: 80px;"><label for="coso-name">名称</label></td>
                <input type="hidden" name="id" id="hidden-coso-id"/>
                <td><input type="text" name="name" id="coso-name" value="" class="text form-control"></td>
            </tr>
            <tr>
                <td><label for="coso-explain">说明</label></td>
                <td><input type="text" name="explain" id="coso-explain" value="" class="text form-control"></td>
            </tr>
        </table>
    </form>
</div>


<script id="commoditySortListTemplate" type="x-tmpl-mustache">
{{#commoditySortList}}
<tr role="row" class="coso-name odd" data-id="{{id}}"><!--even -->
    <td><a href="#" class="coso-edit" data-id="{{id}}">{{name}}</a></td>
    <td>{{explain}}</td> <!-- 此处套用函数对status做特殊处理 -->
    <td>
        <div class="hidden-sm hidden-xs action-buttons">
            <a class="green coso-edit" href="#" data-id="{{id}}">
                <i class="ace-icon fa fa-pencil bigger-100" title="编辑"></i>
            </a>
            <a class="red coso-delete" href="#" data-id="{{id}}"  data-name="{{name}}" title="删除">
                <i class="glyphicon glyphicon-trash bigger-100"></i></a> &nbsp;
        </div>
    </td>
</tr>
{{/commoditySortList}}
</script>


<script src="/js/valid/base-valid.js"></script>
<script src="/js/valid/commodity-sort-valid.js"></script>

<script type="application/javascript">
    $(function () {

        //表示 加载初始化的列表, false表示 加载 搜索的列表
        var addAndUpdateLoadMethod = true;

        //列表模板
        var commoditySortListTemplate = $('#commoditySortListTemplate').html();
        Mustache.parse(commoditySortListTemplate); //用 Mustache 解析

        //加载
        load();

        // 加载
        function load() {
            addAndUpdateLoadMethod = true;
            var url = "/coso/list.json";
            var pageSize = $("#pageSize").val();
            var pageNo = $("#commoditySortPage .pageNo").val() || 1;
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

                        var commoditySortList = _obj.data;
                        var rendered = Mustache.render(commoditySortListTemplate,{commoditySortList: commoditySortList});
                        $("#commoditySortList").html(rendered);
                        bindCommoditySortClick();
                        //渲染分页
                        renderPage(url, _obj.total, pageNo, pageSize, _obj.total > 0 ? commoditySortList.length : 0,
                                "commoditySortPage", callback);
                    } else {
                        showMessage("加载商品分类列表", result.msg, false);
                    }
                }
            });
        }

        //绑定事件
        function bindCommoditySortClick() {
            $(".coso-delete").click(function (e) {
                e.preventDefault();
                e.stopPropagation();
                var id = $(this).attr("data-id");
                var name = $(this).attr("data-name");
                if (confirm("确定要删除商品分类[" + name + "]吗?")) {
                    $.ajax({
                        url: "/sys/coso/delete.json",
                        data: {
                            id: id
                        },
                        success: function (result) {
                            if (result.status == 200) {
                                showMessage("删除商品分类[" + name + "]", "操作成功", true);
                                refresh(addAndUpdateLoadMethod, load, search);
                            } else {
                                showMessage("删除商品分类[" + name + "]", result.msg, false);
                            }
                        }
                    });
                }
            });

            $(".coso-edit").click(function (e) {
                e.preventDefault();
                e.stopPropagation();
                var id = $(this).attr("data-id");
                $.ajax({
                    url: '/coso/detail.json',
                    data: {id: id},
                    type: 'POST',
                    success: function (result) {
                        if (result.status == 200) {

                            $("#dialog-commodity-sort-form").dialog({
                                model: true,
                                width: 480,
                                title: "编辑商品分类",
                                open: function (event, ui) {
                                    $(".ui-dialog-titlebar-close", $(this).parent()).hide();
                                    $("#commoditySortForm")[0].reset();
                                    $("#hidden-coso-id").val(id);
                                    var target = result.data;
                                    if (target) {
                                        $("#coso-name").val(target.name);
                                        $("#coso-explain").val(target.explain);
                                    }
                                },
                                buttons: {
                                    "更新": function (e) {
                                        e.preventDefault();
                                        updateCommoditySort(false, function (data) {
                                            clearData("commoditySortForm");
                                            $("#dialog-commodity-sort-form").dialog("close");
                                        }, function (data) {
                                            showMessage("更新商品分类", data.msg, false);
                                        })
                                    },
                                    "取消": function () {
                                        clearData("commoditySortForm");
                                        $("#dialog-commodity-sort-form").dialog("close");
                                    }
                                }
                            });
                        }
                    }
                });
            });
        }

        //添加
        $(".commodity-sort-add").click(function (e) {
            e.preventDefault();
            e.stopPropagation();

            $("#dialog-commodity-sort-form").dialog({
                model: true,
                width: 480,
                title: "添加商品分类",
                open: function (event, ui) {
                    $(".ui-dialog-titlebar-close", $(this).parent()).hide();
                    $("#commoditySortForm")[0].reset();
                },
                buttons: {
                    "添加": function (e) {
                        e.preventDefault();
                        updateCommoditySort(true, function (data) {
                            $("#dialog-commodity-sort-form").dialog("close");
                        }, function (data) {
                            showMessage("新增商品分类", data.msg, false);
                        })
                    },
                    "取消": function () {
                        $("#dialog-commodity-sort-form").dialog("close");
                    }
                }
            });
        });

        //搜索
        $(".coso-search-btn").click(function (e) {
            e.preventDefault();
            e.stopPropagation();
            var keyword = $("#coso-search").val();
            if(existNotBlank(keyword)){
                return;
            }
            $("#commoditySortPage .pageNo").val(1)
            search();
        });

        //加载 搜索
        function search() {
            addAndUpdateLoadMethod = false;
            var pageSize = $("#pageSize").val();
            var pageNo = $("#commoditySortPage .pageNo").val() || 1;

            var keyword = $("#coso-search").val();
            var url = "/coso/search.json?keyword=" + keyword;
            loadInit(url, search,pageSize, pageNo);
        }

        //更新栏目信息
        function updateCommoditySort(isCreate, successCallback, failCallback) {
            if (validCommoditySort()){
                return;
            }
            $.ajax({
                url: isCreate ? "/sys/coso/save.json" : "/sys/coso/update.json",
                data: $("#commoditySortForm").serializeArray(),
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
            $("#commoditySortPage .pageNo").val(1);
            refresh(addAndUpdateLoadMethod, load, search);
        });

    });
</script>
<script src="/js/defined/manager.js"></script>
</body>
</html>

