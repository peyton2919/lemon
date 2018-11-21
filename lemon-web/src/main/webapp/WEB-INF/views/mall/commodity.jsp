<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>商品管理</title>
    <jsp:include page="/common/common.jsp"/>
    <jsp:include page="/common/page.jsp"/>
</head>
<body class="no-skin init-iframe-box" youdao="bind" style="background: white">

<input id="gritter-light" checked="" type="checkbox" class="ace ace-switch ace-switch-5"/>

<div class="iframe-child">
    <div class="page-header">
        <h1>
            商品管理
            <small>
                <i class="ace-icon fa fa-angle-double-right"></i>
                维护商品
            </small>
        </h1>
    </div>

    <div class="ud-search-container">
        <label for="commodity-search">名称</label>
        <input type="text" name="name" id="commodity-search" placeholder="请输入关键字" class="text ui-widget-content ui-corner-all">
        <button class="btn btn-primary ud-radius commodity-search-btn">
            <i class="fa fa-search">&nbsp;&nbsp;</i>搜索
        </button>
    </div>

    <div class="main-content-inner">
        <div class="col-xs-12">
            <div class="table-header">
                商品列表&nbsp;&nbsp;
                <a class="green" href="#">
                    <i class="ace-icon fa fa-plus-circle orange bigger-130 commodity-add"></i>
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
                            图片
                        </th>
                        <th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
                            名称
                        </th>
                        <th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
                            型号
                        </th>
                        <th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
                            成本价
                        </th>
                        <th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
                            零售价
                        </th>
                        <th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
                            批发价
                        </th>
                        <th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
                            创建时间
                        </th>
                        <th class="sorting_disabled" rowspan="1" colspan="1" aria-label=""></th>
                    </tr>
                    </thead>
                    <tbody id="commodityList"></tbody>
                </table>

                <div class="row" id="commodityPage">
                </div>
            </div>

        </div>
    </div>

</div>

<script id="commodityListTemplate" type="x-tmpl-mustache">
{{#commodityList}}
<tr role="row" class="commodity-name odd" data-id="{{id}}"><!--even -->
    <td><a href="#" class="commodity-edit" data-id="{{id}}"><img src="{{mainImg}}" width="80" height="80"></a></td>
    <td>{{name}}</td>
    <td>{{model}}</td>
    <td><i class="ud-red">{{price}}</i></td>
    <td><i class="ud-red">{{retail}}</i></td>
    <td><i class="ud-red">{{wholesale}}</i></td>
    <td>{{created}}</td><!-- 此处套用函数对status做特殊处理 -->
    <td>
        <div class="hidden-sm hidden-xs action-buttons">
            <a class="green commodity-edit" href="#" data-id="{{id}}">
                <i class="ace-icon fa fa-pencil bigger-100" title="编辑"></i>
            </a>&nbsp;
            <a class="blue commodity-detail" href="#" data-id="{{id}}">
                <i class="ace-icon glyphicon glyphicon-list-alt bigger-100" title="详细"></i>
            </a>&nbsp;
            <a class="orange commodity-storage" href="#" data-name="{{name}}" data-id="{{id}}">
                <i class="ace-icon fa fa-database bigger-100" title="商品入库"></i>
            </a>&nbsp;
            <a class="red commodity-delete" href="#" data-id="{{id}}"  data-name="{{name}}" title="删除">
                <i class="glyphicon glyphicon-trash bigger-100"></i></a> &nbsp;
        </div>
    </td>
</tr>
{{/commodityList}}
</script>

<script type="application/javascript">
    $(function () {

        //表示 加载初始化的列表, false表示 加载 搜索的列表
        var addAndUpdateLoadMethod = true;

        //类目列表模板
        var commodityListTemplate = $('#commodityListTemplate').html();
        Mustache.parse(commodityListTemplate); //用 Mustache 解析

        //加载类目树
        load();

        function load() {
            addAndUpdateLoadMethod = true;
            var url = "/sys/comm/list.json";
            var pageSize = $("#pageSize").val();
            var pageNo = $("#commodityPage .pageNo").val() || 1;

            loadInit(url, load, pageSize, pageNo);
        }

        //搜索
        $(".commodity-search-btn").click(function (e) {
            e.preventDefault();
            e.stopPropagation();
            var keyword = $("#commodity-search").val();
            if(existNotBlank(keyword)){
                return;
            }
            $("#commodityPage .pageNo").val(1)
            search();
        });

        function search() {
            addAndUpdateLoadMethod = false;
            var pageSize = $("#pageSize").val();
            var pageNo = $("#commodityPage .pageNo").val() || 1;

            var keyword = $("#commodity-search").val();
            var url = "/sys/comm/search.json?keyword=" + keyword;
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
                        var commodityList = result.data.data;

                        var rendered = Mustache.render(commodityListTemplate,
                            {commodityList: commodityList });
                        $("#commodityList").html(rendered);
                        bindCommodityClick();
                        //渲染分页
                        renderPage(url, result.data.total, pageNo, pageSize,result.data.total > 0 ?
                            commodityList.length : 0, "commodityPage", callback);

                    } else {
                        showMessage("加载商品列表", result.msg, false);
                    }
                }
            });
        }

        // 绑定部门点击事件
        function bindCommodityClick() {

            $(".commodity-delete").click(function (e) {
                e.preventDefault();
                e.stopPropagation();
                var commodityId = $(this).attr("data-id");
                var commodityName = $(this).attr("data-name");
                if (confirm("确定要删除商品[" + commodityName + "]吗?")) {
                    $.ajax({
                        url: "/sys/comm/delete.json",
                        data: {
                            id: commodityId
                        },
                        success: function (result) {
                            if (result.status == 200) {
                                showMessage("删除商品[" + commodityName + "]", "操作成功", true);
                                refresh(addAndUpdateLoadMethod, load, search);
                            } else {
                                showMessage("删除商品[" + commodityName + "]", result.msg, false);
                            }
                        }
                    });
                }
            });

            $(".commodity-edit").click(function (e) {
                e.preventDefault();
                e.stopPropagation();
                var id = $(this).attr("data-id");
                window.location.href = '/sys/comm/change.page?id=' + id;
            });

            $(".commodity-detail").click(function(e){
                e.preventDefault();
                e.stopPropagation();
                var id = $(this).attr("data-id");
                window.location.href = '/sys/comm/detail.page?id=' + id;
            });

            $(".commodity-storage").click(function(e){
                e.preventDefault();
                e.stopPropagation();
                var id = $(this).attr("data-id");
                window.location.href = '/sys/stor/change.page?commodityId=' + id;
            });
        }

        //添加点击 事件
        $(".commodity-add").click(function (e) {
            e.preventDefault();
            e.stopPropagation();
            window.location.href = '/sys/comm/change.page';
        });

        $(".input-sm").change(function () {
            $("#commodityPage .pageNo").val(1);
            refresh(addAndUpdateLoadMethod, load, search);
        });
    });
</script>

<script src="/js/defined/manager.js"></script>

</body>
</html>
