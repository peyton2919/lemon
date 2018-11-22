<%--suppress JSUnresolvedVariable --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>地区</title>
    <jsp:include page="/common/common.jsp"/>
    <jsp:include page="/common/page.jsp"/>
</head>

<body class="no-skin init-iframe-box" youdao="bind">

<input id="gritter-light" checked="" type="checkbox" class="ace ace-switch ace-switch-5"/>

<div class="iframe-child">

    <div class="page-header">
        <h1>
            <span class="page-title"></span>管理
            <small>
                <i class="ace-icon fa fa-angle-double-right"></i>
                维护<span class="page-title"></span>
            </small>
        </h1>
    </div>

    <div class="ud-search-container">
        <label for="region-search">名称</label>
        <input type="text" name="name" id="region-search" placeholder="请输入要查询的关键字" class="text ui-widget-content ui-corner-all">
        <button class="btn btn-primary ud-radius region-search-btn">
            <i class="fa fa-search">&nbsp;&nbsp;</i>搜索
        </button>
    </div>

    <div class="main-content-inner">
        <div class="col-xs-9">
            <div class="table-header">
                地区列表&nbsp;&nbsp;
                <a class="green" href="#">
                    <i class="ace-icon fa fa-plus-circle orange bigger-130 region-add"></i>
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
                            区码
                        </th>
                        <th class="sorting_disabled" rowspan="1" colspan="1" aria-label=""></th>
                    </tr>
                    </thead>
                    <tbody id="regionList"></tbody>
                </table>

                <div class="row" id="regionPage"></div>
            </div>
        </div>

        <div class="col-xs-3">
        </div>
    </div>
</div>

<div id="dialog-region-form" style="display: none;">
    <form id="regionForm">
        <table class="table table-bordered dataTable no-footer" role="grid">
            <tr>
                <td style="width: 80px;"><label for="region-parent-id">上级地区</label></td>
                <td>
                    <select id="region-parent-id" name="parentId" data-placeholder="选择地区" style="width: 200px;"></select>
                    <input type="hidden" name="id" id="hidden-region-id"/>
                </td>
            </tr>
            <tr>
                <td><label for="region-name">名称</label></td>
                <td><input type="text" name="name" id="region-name" placeholder="请输入名称,不能为空" class="form-control"></td>
            </tr>
            <tr>
                <td><label for="region-seq">顺序</label></td>
                <td><input type="text" name="seq" id="region-seq" placeholder="请输入排序,不能为空,从小到大排序" class="form-control"></td>
            </tr>
            <tr>
                <td><label for="region-code">区码</label></td>
                <td><input type="text" name="code" id="region-code" placeholder="可以为空" class="form-control"></td>
            </tr>
        </table>
    </form>
</div>

<script id="regionListTemplate" type="x-tmpl-mustache">
{{#regionList}}
<tr role="row" class="region-name odd" data-id="{{id}}"><!--even -->
    <td><a href="#" class="region-edit" data-id="{{id}}">{{name}}</a></td>
    <td>{{#showParent}}{{/showParent}}</td>
    <td>{{seq}}</td>
    <td>{{code}}</td> <!-- 此处套用函数对status做特殊处理 -->
    <td>
        <div class="hidden-sm hidden-xs action-buttons">
            <a class="green region-edit" href="#" data-id="{{id}}">
                <i class="ace-icon fa fa-pencil bigger-100" title="编辑"></i>
            </a>&nbsp;&nbsp;
            <a class="red region-delete" href="#" data-id="{{id}}"  data-name="{{name}}" title="删除">
                <i class="glyphicon glyphicon-trash bigger-100"></i></a> &nbsp;
        </div>
    </td>
</tr>
{{/regionList}}
</script>

<script type="text/javascript">

    $(function () {
        $(".page-title").html("地区");
        //表示 加载初始化的列表, false表示 加载 搜索的列表
        var addAndUpdateLoadMethod = true;
        var optionStr;
        var regionMap = {};
        var regionListTemplate = $('#regionListTemplate').html();
        Mustache.parse(regionListTemplate); //用 Mustache 解析

        load();

        function load() {
            addAndUpdateLoadMethod = true;
            var url = '/sys/regi/list.json';
            var pageSize = $("#pageSize").val();
            var pageNo = $("#regionPage .pageNo").val() || 1;
            loadInit(url,load, pageSize, pageNo);
        }

        //搜索
        $(".region-search-btn").click(function (e) {
            e.preventDefault();
            e.stopPropagation();
            var keyword = $("#region-search").val();
            if(validNotBlank(keyword)){
                return;
            }
            $("#regionPage .pageNo").val(1)
            search();
        });

        //加载 搜索
        function search() {
            addAndUpdateLoadMethod = false;
            var pageSize = $("#pageSize").val();
            var pageNo = $("#regionPage .pageNo").val() || 1;

            var keyword = $("#region-search").val();
            var url = "/sys/regi/search.json?keyword=" + keyword;
            loadInit(url, search,pageSize, pageNo);
        }

        //加载初始 事件
        function loadInit(url,callback,pageSize,pageNo) {
            $.ajax({
                url: url,
                data :{pageSize:pageSize,pageNo:pageNo},
                success : function (response) {
                    if (response.status == 200) {
                        var regionList = response.data.regionList.data;
                        regionMap = response.data.regionMap;
                        var rendered = Mustache.render(regionListTemplate,
                            {regionList: regionList,
                                "showParent":function () {
                                    return function (text,render) {
                                        var _pi = this.parentId;
                                        if (_pi == 0){
                                            return "<span class='label label-lg label-purple'>最高栏目</span>";
                                        }
                                        return regionMap[_pi].name;
                                    }
                                }
                            });
                        $("#regionList").html(rendered);
                        bindRegionClick();
                        //渲染分页
                        renderPage(url, response.data.regionList.total, pageNo, pageSize,
                            response.data.regionList.total > 0 ? regionList.length : 0, "regionPage", callback);
                    } else {
                        showMessage("加载地区列表", response.msg, false);
                    }
                }
            });
        }

        $(".region-add").click(function() {
            $.ajax({
                url:'/sys/regi/change.json',
                success : function (response) {
                    if (response.status == 200){
                        $("#dialog-region-form").dialog({
                            model: true,
                            title: "新增地区",
                            resizable:false,
                            position: { using:function(pos){
                                var topOffset = $(this).css(pos).offset().top;
                                if (topOffset == 0||topOffset>0) {
                                    $(this).css('top', 20);
                                }
                            }},
                            open: function(event, ui) {
                                $(".ui-dialog-titlebar-close", $(this).parent()).hide();
                                var regionList = response.data.regionList;
                                optionStr = "<option value=\"0\">---</option>";
                                recursiveRenderRegionSelect(regionList, 1);
                                $("#regionForm")[0].reset();
                                $("#region-parent-id").html(optionStr);
                            },
                            buttons : {
                                "添加": function(e) {
                                    e.preventDefault();
                                    updateRegion(true, function (data) {
                                        $("#dialog-region-form").dialog("close");
                                    }, function (data) {
                                        showMessage("新增地区", data.msg, false);
                                    })
                                },
                                "取消": function () {
                                    $("#dialog-region-form").dialog("close");
                                }
                            }
                        });
                    }else{
                        showMessage("添加地区提示", response.msg, false);
                    }
                }
            });
        });

        $(".input-sm").change(function (e) {
            $("#regionPage .pageNo").val(1);
            refresh(addAndUpdateLoadMethod,load,search);
        });

        //控件 绑定事件
        function bindRegionClick() {

            $(".region-edit").click(function (e) {
                e.preventDefault();
                e.stopPropagation();
                var regionId = $(this).attr("data-id");
                $.ajax({
                    url:'/sys/regi/change.json',
                    data:{regionId:regionId},
                    success : function (response) {
                        if (response.status == 200){
                            $("#dialog-region-form").dialog({
                                model: true,
                                title: "更新地区",
                                resizable:false,
                                position: { using:function(pos){
                                    var topOffset = $(this).css(pos).offset().top;
                                    if (topOffset == 0||topOffset>0) {
                                        $(this).css('top', 20);
                                    }
                                }},
                                open: function(event, ui) {
                                    $(".ui-dialog-titlebar-close", $(this).parent()).hide();
                                    var regionList = response.data.regionList;
                                    optionStr = "<option value=\"0\">---</option>";
                                    recursiveRenderRegionSelect(regionList, 1);
                                    $("#regionForm")[0].reset();
                                    $("#region-parent-id").html(optionStr);
                                    var region = response.data.region;
                                    if (region){
                                        $("#region-parent-id").val(region.parentId);
                                        $("#region-name").val(region.name);
                                        $("#region-seq").val(region.seq);
                                        $("#region-code").val(region.code);
                                        $("#hidden-region-id").val(region.id);
                                    }
                                },
                                buttons : {
                                    "更新": function(e) {
                                        e.preventDefault();
                                        updateRegion(false, function (data) {
                                            clearData("regionForm");
                                            $("#dialog-region-form").dialog("close");
                                        }, function (data) {
                                            showMessage("新增地区", data.msg, false);
                                        })
                                    },
                                    "取消": function () {
                                        clearData("regionForm");
                                        $("#dialog-region-form").dialog("close");
                                    }
                                }
                            });
                        }else{
                            showMessage("更新地区提示", response.msg, false);
                        }
                    }
                });
            });

            $(".region-delete").click(function (e) {
                e.preventDefault();
                e.stopPropagation();
                var regionId = $(this).attr("data-id");
                var regionName = $(this).attr("data-name");
                if (confirm("确定要删除地区[" + regionName + "]吗?")) {
                    showMessage("删除提示", "做完客户在做这个删除", false);
                    //todo

                    refresh(addAndUpdateLoadMethod,load,search);
                }
            });
        }

        //递归渲染部地区选中
        function recursiveRenderRegionSelect(regionList, level) {
            level = level | 0;
            if (regionList && regionList.length > 0) {
                $(regionList).each(function (i, region) {
                    regionMap[region.id] = region;
                    var blank = "";
                    if (level > 1) {
                        for(var j = 3; j <= level; j++) {
                            blank += "..";
                        }
                        blank += "  ∟";
                    }
                    optionStr += Mustache.render("<option value='{{id}}'>{{name}}</option>", {id: region.id, name: blank + region.name});
                    if (region.regionList && region.regionList.length > 0) {
                        recursiveRenderRegionSelect(region.regionList, level + 1);
                    }
                });
            }
        }

        //添加或更新
        function updateRegion(isCreate, successCallback, failCallback) {
            if (validRegion()){
                return;
            }
            $.ajax({
                url: isCreate ? "/sys/regi/save.json" : "/sys/regi/update.json",
                data: $("#regionForm").serializeArray(),
                type: 'POST',
                success: function(result) {
                    if (result.status == 200) {
                        if (successCallback) {
                            successCallback(result);
                        }
                        refresh(addAndUpdateLoadMethod,load,search);
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

<script src="/js/valid/base-valid.js"></script>
<script src="/js/valid/region-valid.js"></script>
<script src="/js/defined/manager.js"></script>

</body>
</html>
