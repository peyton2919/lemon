<%--suppress JSUnresolvedVariable --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>品牌管理</title>
    <jsp:include page="/common/common.jsp"/>
    <jsp:include page="/common/page.jsp"/>
</head>
<body class="no-skin init-iframe-box" youdao="bind" style="background-color: white;">

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
        <label for="brand-search">名称</label>
        <input type="text" name="name" id="brand-search" placeholder="请输入关键字" class="text ui-widget-content ui-corner-all">
        <button class="btn btn-primary ud-radius brand-search-btn" formtarget="innerFrame">
            <i class="fa fa-search">&nbsp;&nbsp;</i>搜索
        </button>
    </div>

    <div class="main-content-inner">

        <div class="col-xs-9">
            <div class="table-header">
                品牌列表&nbsp;&nbsp;
                <a class="green" href="#">
                    <i class="ace-icon fa fa-plus-circle orange bigger-130 brand-add"></i>
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
                            品牌LOGO
                        </th>
                        <th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
                            名称
                        </th>
                        <th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
                            排序
                        </th>
                        <th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
                            所属地区/国家
                        </th>
                        <th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
                            供应商
                        </th>
                        <th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
                            说明
                        </th>
                        <th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
                            状态
                        </th>
                        <th class="sorting_disabled" rowspan="1" colspan="1" aria-label=""></th>
                    </tr>
                    </thead>
                    <tbody id="brandList"></tbody>
                </table>

                <div class="row" id="brandPage">
                </div>
            </div>

        </div>

        <div class="col-xs-3">
        </div>
    </div>
</div>

<div id="dialog-brand-form" style="display: none;">
    <form id="brandForm" name="brandForm">
        <table class="table table-bordered dataTable no-footer" role="grid">
            <tr>
                <td style="min-width: 80px;"><label for="brand-name">名称</label></td>
                <input type="hidden" name="id" id="hidden-brand-id"/>
                <td><input type="text" name="name" id="brand-name" placeholder="名称不能为空" class="text form-control"></td>
            </tr>
            <tr>
                <td>logo图片</td>
                <td>
                    <div class="control-group">
                        <div class="col-md-12">
                            <div class="input-group" id="requirement">
                                <input id="upload-single-img-name" name="imgName" placeholder="图片不能为空" class="form-control" readonly type="text">
                                <label class="input-group-btn">
                                    <input id="upload-single-img-file" type="file" name="imgFile" style="left: -9999px; position: absolute; display: none;">
                                    <span class="btn btn-default" id="btn-upload-single-img">Browse</span>
                                </label>
                            </div>
                        </div>
                    </div>
                    <%--//图片显示--%>
                    <div class="control-group" id="upload-single-img-div" style="display:none">
                        <div class="col-md-12">
                            <img id="upload-single-img-display" src="" width="120px" height="60px" >
                        </div>
                    </div>
                </td>
            </tr>
            <tr>
                <td><label for="brand-seq">排序</label></td>
                <td><input type="text" name="seq" id="brand-seq" placeholder="排序不能为空,从小到大排序" class="text form-control"></td>
            </tr>
            <tr>
                <td><label for="brand-area">所属区域</label></td>
                <td><input type="text" name="area" id="brand-area" placeholder="区哉可以为空" class="text form-control"></td>
            </tr>
            <tr>
                <td><label for="brand-explain">说明</label></td>
                <td><input type="text" name="explain" id="brand-explain" placeholder="说明可以为空" class="text form-control"></td>
            </tr>
            <tr>
                <td><label for="brand-supplier-id">供应商</label></td>
                <td>
                    <select id="brand-supplier-id" name="supId" data-placeholder="选择供应商" class="text form-control"></select>
                </td>
            </tr>
        </table>
    </form>
</div>

<script id="brandListTemplate" type="x-tmpl-mustache">
{{#brandList}}
<tr role="row" class="brand-name odd" data-id="{{id}}"><!--even -->
    <td><img id="brand_logo_{{id}}" src="{{logo}}" width="120px" height="60px" onerror="notFindImg('brand_logo_{{id}}');"></img></td>
    <td><a href="#" class="brand-edit" data-id="{{id}}">{{name}}</a></td>
    <td>{{seq}}</td>
    <td>{{area}}</td>
    <td>{{displaySupplierName}}</td>
    <td>{{explain}}</td>
    <td>{{#displayStatus}}{{showStatus}}{{/displayStatus}}</td><!-- 此处套用函数对status做特殊处理 -->
    <td>
        <div class="hidden-sm hidden-xs action-buttons">
            <a class="green brand-edit" href="#" data-id="{{id}}">
                <i class="ace-icon fa fa-pencil bigger-100" title="编辑"></i>
            </a>
            <a class="red brand-delete" href="#" data-id="{{id}}"  data-name="{{name}}" title="删除">
                <i class="glyphicon glyphicon-trash bigger-100"></i></a> &nbsp;
            {{#displayStopBtn}}{{/displayStopBtn}}
        </div>
    </td>
</tr>
{{/brandList}}
</script>

<script src="/js/defined/tools.js"></script>
<script src="/js/defined/image.js"></script>
<script src="/js/defined/upload-single.js"></script>

<script type="application/javascript">

    function notFindImg(idElement) {
        var def = "/img/default/default-550-280.jpg";
        $("#" + idElement).attr("src", def);
        $("#" + idElement).onerror = null;
    };

    $(function () {
        $(".page-title").html("品牌");
        var supplierMap ={};
        var optionStr = "";
        //表示 加载初始化的列表, false表示 加载 搜索的列表
        var addAndUpdateLoadMethod = true;

        //上传图片选项
        var options = {
            displayDivId : 'upload-single-img-div', //标记 显示图片div层的id
            imgId : 'upload-single-img-display', //标记要显示img的id
            displayNameId : 'upload-single-img-name', //标记 显示 文件名称 id
            fileId : 'upload-single-img-file',  //标记 input type= 'file' 的id
        };

        //品牌列表模板
        var brandListTemplate = $('#brandListTemplate').html();
        Mustache.parse(brandListTemplate); //用 Mustache 解析

        //Browse 浏览 点击 事件
        $("#btn-upload-single-img").loadUpload(options);

        //加载
        load();

        /** 加载  */
        function load() {
            addAndUpdateLoadMethod = true;
            var url = "/brand/list.json";
            var pageSize = $("#pageSize").val();
            var pageNo = $("#brandPage .pageNo").val() || 1;
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
                        var brandList = _obj.brands.data;
                        $(_obj.suppliers).each(function (i,supplier) {
                            supplierMap[supplier.id] = supplier;
                        });

                        var rendered = Mustache.render(brandListTemplate,{brandList: brandList,
                            "displaySupplierName" : function () {
                                return supplierMap[this.supId].name;
                            },
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
                                        return ' <a class="purple brand-stop" href="#" data-id="' + this.id +
                                            '" data-name="' + this.name + '" title="暂停使用">' +
                                            '<i class="glyphicon glyphicon-stop bigger-100"></i></a> &nbsp;';
                                    }else if (this.status == 0) {
                                        return ' <a class="orange brand-play" href="#" data-id="' + this.id +
                                            '" data-name="' + this.name + '" title="启动使用">' +
                                            '<i class="glyphicon glyphicon-play bigger-100"></i></a> &nbsp;';
                                    }
                                }
                            }
                        });
                        $("#brandList").html(rendered);
                        bindBrandClick();
                        //渲染分页
                        renderPage(url, _obj.brands.total, pageNo, pageSize, _obj.brands.total > 0 ? brandList.length : 0, "brandPage", callback);
                    } else {
                        showMessage("加载品牌列表", result.msg, false);
                    }
                }
            });
        }

        //绑定事件
        function bindBrandClick() {

            $(".brand-delete").click(function (e) {
                e.preventDefault();
                e.stopPropagation();
                var id = $(this).attr("data-id");
                var name = $(this).attr("data-name");
                if (confirm("确定要删除颜色[" + name + "]吗?")) {
                    $.ajax({
                        url: "/sys/brand/delete.json",
                        data: {
                            id: id
                        },
                        success: function (result) {
                            if (result.status == 200) {
                                showMessage("删除品牌[" + name + "]", "操作成功", true);
                                refresh(addAndUpdateLoadMethod,load,search);
                            } else {
                                showMessage("删除品牌[" + name + "]", result.msg, false);
                            }
                        }
                    });
                }
            });

            $(".brand-edit").click(function (e) {
                e.preventDefault();
                e.stopPropagation();
                var id = $(this).attr("data-id");
                $.ajax({
                    url: '/brand/detail.json',
                    data: {id: id},
                    type: 'POST',
                    success: function (result) {
                        if (result.status == 200) {
                            $("#dialog-brand-form").dialog({
                                model: true,
                                width: 580,
                                title: "编辑品牌",
                                resizable:false,
                                position: { using:function(pos){
                                    var topOffset = $(this).css(pos).offset().top;
                                    if (topOffset == 0||topOffset>0) {
                                        $(this).css('top', 20);
                                    }
                                }},
                                open: function (event, ui) {
                                    $(".ui-dialog-titlebar-close", $(this).parent()).hide();
                                    $("#brandForm")[0].reset();
                                    $("#hidden-brand-id").val(id);
                                    var target = result.data.brand;
                                    optionStr = "";
                                    renderSupplierSelect(result.data.suppliers);
                                    $("#brand-supplier-id").html(optionStr);
                                    if (target) {
                                        $("#brand-name").val(target.name);
                                        $("#brand-explain").val(target.explain);
                                        $("#brand-area").val(target.area);
                                        $("#brand-seq").val(target.seq);
                                        $("#brand-supplier-id").val(target.supId);

                                        $("#upload-single-img-display").imgLoad(target.logo,"upload-single-img-div","upload-single-img-name");
                                    }
                                },
                                buttons: {
                                    "更新": function (e) {
                                        e.preventDefault();
                                        updateBrand(false, function (data) {
                                            clearData("brandForm");
                                            imgReset(options);
                                            $("#dialog-brand-form").dialog("close");
                                        }, function (data) {
                                            showMessage("更新品牌", data.msg, false);
                                        })
                                    },
                                    "取消": function () {
                                        clearData("brandForm");
                                        imgReset(options);
                                        $("#dialog-brand-form").dialog("close");
                                    }
                                }
                            });
                        }
                    }
                });
            });

            //暂停使用
            $(".brand-stop").click(function (e) {
                e.preventDefault();
                e.stopPropagation();
                var id = $(this).attr("data-id");
                var name = $(this).attr("data-name");
                if (confirm("确定要停止使用品牌[" + name + "]吗?")) {
                    $.ajax({
                        url : '/sys/brand/stop.json',
                        data:{id : id},
                        type : 'POST',
                        success :function (res) {
                            if (res.status == 200) {
                                showMessage("提示", "暂停品牌成功", true);
                                refresh(addAndUpdateLoadMethod,load,search);
                            }else {
                                showMessage("提示", "暂停品牌失败", false);
                            }
                        }
                    });
                }

            });

            //启用
            $(".brand-play").click(function (e) {
                e.preventDefault();
                e.stopPropagation();
                var id = $(this).attr("data-id");
                var name = $(this).attr("data-name");
                if (confirm("确定要启用品牌[" + name + "]吗?")) {
                    $.ajax({
                        url : '/sys/brand/play.json',
                        data : { id : id },
                        type : 'POST',
                        success :function (res) {
                            if (res.status == 200) {
                                showMessage("提示", "启动品牌成功", true);
                                refresh(addAndUpdateLoadMethod,load,search);
                            }else {
                                showMessage("提示", "启动品牌失败", false);
                            }
                        }
                    });
                }

            });

        }

        $(".brand-add").click(function (e) {
            e.preventDefault();
            e.stopPropagation();
            $.ajax({
                url: '/brand/detail.json',
                type: 'POST',
                success: function (result) {
                    if (result.status == 200) {
                        $("#dialog-brand-form").dialog({
                            model: true,
                            width: 580,
                            title: "添加品牌",
                            resizable:false,
                            position: { using:function(pos){
                                var topOffset = $(this).css(pos).offset().top;
                                if (topOffset == 0||topOffset>0) {
                                    $(this).css('top', 20);
                                }
                            }},
                            open: function (event, ui) {
                                $(".ui-dialog-titlebar-close", $(this).parent()).hide();
                                $("#brandForm")[0].reset();

                                optionStr = "";
                                renderSupplierSelect(result.data.suppliers);
                                $("#brand-supplier-id").html(optionStr);
                            },
                            buttons: {
                                "添加": function (e) {
                                    e.preventDefault();
                                    updateBrand(true, function (data) {
                                        clearData("brandForm");
                                        //默认控件名称与加载图片要一致
                                        imgReset(options);
                                        $("#dialog-brand-form").dialog("close");
                                    }, function (data) {
                                        showMessage("添加品牌", data.msg, false);
                                    })
                                },
                                "取消": function () {
                                    clearData("brandForm");
                                    imgReset(options);
                                    $("#dialog-brand-form").dialog("close");
                                }
                            }
                        });
                    }
                }
            });
        });

        //渲染职务选中
        function renderSupplierSelect(supplierList) {
            if (supplierList && supplierList.length > 0) {
                $(supplierList).each(function (i, supplier) {
                    supplierMap[supplier.id] = supplier;
                    optionStr += Mustache.render("<option value='{{id}}'>{{name}}</option>", {id: supplier.id, name: supplier.name});
                });
            }
        }

        //搜索
        $(".brand-search-btn").click(function (e) {
            e.preventDefault();
            e.stopPropagation();
            var keyword = $("#brand-search").val();
            if(validNotBlank(keyword)){
                return;
            }
            $("#brandPage .pageNo").val(1);
            search();
        });

        //加载 搜索
        function search() {
            addAndUpdateLoadMethod = false;
            var pageSize = $("#pageSize").val();
            var pageNo = $("#brandPage .pageNo").val() || 1;

            var keyword = $("#brand-search").val();
            var url = "/brand/search.json?keyword=" + keyword;
            loadInit(url, search,pageSize, pageNo);
        }

        //更新栏目信息
        function updateBrand(isCreate, successCallback, failCallback) {
            if (validBrand()){
                return;
            }
            var formData = new FormData($("#brandForm")[0]);
            $.ajax({
                url: isCreate ? "/sys/brand/save.json" : "/sys/brand/update.json",
                data: formData,
                type: 'POST',
                async: false,
                cache: false,
                contentType: false,
                processData: false,
                success: function (result) {
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

        //绑定展示条数
        $(".input-sm").change(function () {
            $("#brandPage .pageNo").val(1);
            refresh(addAndUpdateLoadMethod,load,search);
        });

    });

</script>


<script src="/js/valid/base-valid.js"></script>
<script src="/js/valid/brand-valid.js"></script>
<script src="/js/defined/manager.js"></script>

</body>
</html>

