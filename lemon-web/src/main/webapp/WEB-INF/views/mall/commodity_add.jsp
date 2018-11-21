<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>添加商品</title>
    <jsp:include page="/common/common.jsp"/>
    <link rel="stylesheet" href="/css/upload-mult.css">
    <link rel="stylesheet" type="text/css" href="/assets/select/css/bootstrap-select.min.css">
    <link rel="stylesheet" type="text/css" href="/ztree/zTreeStyle.css">

    <link rel="stylesheet" href="/kindeditor/themes/default/default.css"/>
    <link rel="stylesheet" href="/kindeditor/plugins/code/prettify.css"/>

</head>
<body class="no-skin init-iframe-box" youdao="bind" style="background: white;overflow-scrolling: auto;">

<input id="gritter-light" checked="" type="checkbox" class="ace ace-switch ace-switch-5"/>
<input type="hidden" name="commodityId" id="commodityId" value="${commodityId}">
<div class="iframe-child">

    <div class="page-header">
        <h1>
            商品管理
            <small>
                <i class="ace-icon fa fa-angle-double-right"></i>
                <label class="commodity-title"></label>
            </small>
        </h1>
    </div>

    <div class="main-content-inner">
        <div class="col-sm-3">
            <div class="table-header">
                商品类目列表&nbsp;&nbsp;
                <a class="green" href="#">
                    <i class="ace-icon glyphicon glyphicon-option-vertical white bigger-130 commodity-category-list" title="列表"></i>
                </a>
            </div>
            <div  id="treeDemo" class="ztree"></div>
        </div>

        <div class="col-sm-9">
            <div class="table-header"><label class="commodity-title"></label> </div>
            <form id="commodityForm" name="commodityForm">
                <input type="hidden" id="commodity-category-id" name="cocaId">
                <input type="hidden" name="id" id="commodity-id">
                <table class="ud-table" style="min-width: 500px;">

                    <tr>
                        <td class="td1">商品标题：</td>
                        <td colspan="3">
                            <input type="text" id="commodity-name" class="text form-control"
                                   value="" placeholder="商品标题不能为空" name="name">
                        </td>
                    </tr>

                    <tr>
                        <td>关键词：</td>
                        <td colspan="3"><input type="text" id="commodity-keyword" class="text form-control"
                                               placeholder="关键词不能为空,用来快速查找" name="keyword">
                        </td>
                    </tr>

                    <tr>
                        <td class="td1">商品型号：</td>
                        <td class="td3"><input type="text" id="commodity-model" class="text form-control"
                                               placeholder="商品型号不能为空" name="model"></td>
                        <td class="td2">条&nbsp;形&nbsp;码：</td>
                        <td class="td3"><input type="text" id="commodity-bar-code" class="text form-control"
                                               placeholder="商品条形码" name="barCode"></td>

                    </tr>

                    <tr>
                        <td class="td1">商品规格：</td>
                        <td class="td3"><input type="text" id="commodity-format" class="text form-control"
                                               placeholder="宽x高x厚" name="format"></td>
                        <td class="td2">商品包装：</td>
                        <td class="td3"><input type="text" id="commodity-pack" class="text form-control"
                                               placeholder="平装" name="pack" value="平装"></td>
                        <td class="td2">商品单位：</td>
                        <td class="td3"><input type="text" id="commodity-unit" class="text form-control"
                                               placeholder="个" name="unit" value="个"></td>
                    </tr>

                    <tr>
                        <td>成本价：</td>
                        <td><input type="text" id="commodity-price" class="text form-control"
                                   placeholder="0.00" name="price"></td>
                        <td class="td2">零售价：</td>
                        <td><input type="text" id="commodity-retail" class="text form-control"
                                   placeholder="0.00" name="retail"></td>
                        <td class="td2">批发价：</td>
                        <td><input type="text" id="commodity-wholesale" class="text form-control"
                                   placeholder="0.00" name="wholesale" ></td>
                    </tr>

                    <tr>
                        <td>商品分类：</td>
                        <td><select name="cosoId" id="cosoSelectId"
                                    class="selectpicker bla bla bli text form-control" multiple
                                    data-live-search="true"></select>
                        </td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>

                    <tr>
                        <td>产地：</td>
                        <td>
                            <select class="text form-control" id="oriSelectId" name="oriId">
                            </select></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>

                    <tr>
                        <td class="td5">主图：</td>
                        <td colspan="3">
                            <input id="upload-single-img-name" name="imgName" placeholder="图片不能为空" class="text form-control"
                                   readonly type="text">
                        </td>
                        <td class="td4">
                            <label class="input-group-btn">
                                <input id="upload-single-img-file" type="file" name="imgFile"
                                       style="left: -9999px; position: absolute; display: none;">
                                <i class="ud-btn-36" id="btn-upload-single-img">Browse</i>
                            </label>
                        </td>
                        <td>
                            <div id="upload-single-img-div" style="display:none;float: left;">
                                <img id="upload-single-img-display" src="" width="100px" height="100px">
                            </div>
                        </td>
                    </tr>

                    <tr>
                        <td>图片集合：</td>
                        <td colspan="5">
                            <div id="upload">
                                <%-- 多图片 --%>
                            </div>
                        </td>
                    </tr>

                    <tr>
                        <td>详细内容：</td>
                        <td colspan="5"><textarea name="detail"  id="commodity-detail" rows="20" class="text form-control"></textarea></td>
                    </tr>

                    <tr>
                        <td>允许评论：</td>
                        <td class="td4">
                            <input type="checkbox" class="ud-checked"  id="commodity-comment" name="comment"><label>允许</label>
                        </td>
                        <td colspan="4">
                        </td>
                    </tr>

                    <tr>
                        <td colspan="6">
                            <div class="ud-div">
                                <button id="commodity-save" class="btn btn-primary radius ud-btn-width-120" type="button"></button>
                                <button id="commodity-cancel" class="btn btn-default radius ud-btn-width-120" type="button">取消</button>
                            </div>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>

<script src="/assets/select/js/bootstrap-select.min.js"></script>
<script src="/ztree/jquery.ztree.all.min.js"></script>

<script charset="utf-8" src="/kindeditor/kindeditor-min.js"></script>
<script charset="utf-8" src="/kindeditor/lang/zh-CN.js"></script>
<script charset="utf-8" src="/kindeditor/plugins/code/prettify.js"></script>

<script src="/js/defined/image.js"></script>
<script src="/js/defined/upload-single.js"></script>
<script src="/js/defined/upload-mult.js"></script>

<script type="text/javascript">

    $(function () {

        // 关闭过滤模式，保留所有标签
        KindEditor.options.filterMode = false;
        //最后点击的商品类目编号
        var lastClickCocaId = -1;
        var optionOriginStr = "";
        var optionCommoditySortStr = "";
        var treeObj = $("#treeDemo");

        //商品分类 多选事件
        $('#cosoSelectId').selectpicker({
            // 'selectedText': 'cat',
            noneSelectedText : '可选择多个',//默认显示内容
            'style': 'btn-white'//设置按钮样式
        });

        // ==============================  tree 的基础配置 开始  ============================== //
        /**
         * <h4>加载选中的商品类目</h4>
         * @param cocaId 商品类目编号
         */
        function loadSelectNode(cocaId){
            var node = treeObj.getNodeByParam("id",cocaId);
            //为什么设置了checked=true，可是等树显示的时候节点仍然没有选中
            node.checked=true;
            treeObj.selectNode(node);
        }

        // tree 在...之前 点击 事件
        function onBeforeClick(treeId, treeNode) {
            var zTree = $.fn.zTree.getZTreeObj("treeDemo");
            if (treeNode.isParent) {
                zTree.expandNode(treeNode);
                return false;
            } else {
                lastClickCocaId = treeNode.id;
                $("#commodity-category-id").val(lastClickCocaId);
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

        //多图片上传 参数 回调事件
        var options = {
            formId : '#commodityForm',
            onSuccess: function (res) {
                console.log(res);
                var result = eval('(' + res + ')');
                if (result.status == 400) {
                    showMessage("错误提示", result.msg, false);
                }else if (result.status == 200) {
                    window.location.href = "/sys/comm/commodity.page";
                }
            },
            onFailure: function (res) {
                console.log(res);
                showMessage("", res.msg, false);
            },
            onMessage: function (res) {
                alert(res);
            }
        };

        // 单图片上传 加载 事件
        $("#btn-upload-single-img").loadUpload();

        //商品详细 编辑 器
        var detailEdit = KindEditor.create('textarea[name="detail"]', {
            resizeType: 1,
            allowImageUpload: false, //上传图片框本地上传的功能，false为隐藏，默认为true
            allowImageRemote : true, //上传图片框网络图片的功能，false为隐藏，默认为true
            allowFileManager : false, //浏览图片空间
            filterMode : false, //HTML特殊代码过滤
            afterCreate: function () {
                this.sync();
            },
            //下面这行代码就是关键的所在，当失去焦点时执行 this.sync();
            afterBlur: function () {
                this.sync();
            }
        });

        loadPage();

        function loadPage() {
            var commodityId = $("#commodityId").val();
            if (existNotBlank(commodityId)){
                options.url = '/sys/comm/save.json';
                $("#commodity-save").html("添加");
                $(".commodity-title").html("添加商品");

                addCommodity();
            }else {
                options.url = '/sys/comm/update.json';
                $("#commodity-save").html("更新");
                $(".commodity-title").html("更新商品")
                updateCommodity(commodityId);
            }
        }

        function  addCommodity() {

            $.ajax({
                url: '/sys/comm/data.json',
                cache : false ,
                async : false ,
                success: function (res) {
                    if (res.status == 200) {
                        var originList = res.data.originList;
                        var commoditySortList = res.data.commoditySortList;
                        var commodityCategoryList = res.data.commodityCategoryList;
                        optionOriginStr = "";
                        optionCommoditySortStr = "";
                        renderOriginSelect(originList);
                        renderCommoditySortSelect(commoditySortList);
                        $("#commodityForm")[0].reset();
                        $("#oriSelectId").html(optionOriginStr);
                        $("#cosoSelectId").html(optionCommoditySortStr);
                        //左侧树 加载
                        treeObj = $.fn.zTree.init(treeObj, setting, commodityCategoryList);
                        //刷新 selectpicker 控件
                        $('#cosoSelectId').selectpicker('refresh');
                        //同步 kindEdit 控件
                        detailEdit.sync();
                    }
                }
            });
        }

        function updateCommodity(commodityId) {
            $.ajax({
                url: '/sys/comm/data.json',
                data : {id : commodityId},
                cache : false ,
                async : false ,
                success: function (res) {
                    if (res.status == 200) {
                        var commodity = res.data.commodity;
                        var originList = res.data.originList;
                        var commoditySortList = res.data.commoditySortList;
                        var commodityCategoryList = res.data.commodityCategoryList;
                        optionOriginStr = "";
                        optionCommoditySortStr = "";
                        renderOriginSelect(originList);
                        renderCommoditySortSelect(commoditySortList);
                        $("#commodityForm")[0].reset();
                        $("#oriSelectId").html(optionOriginStr);
                        $("#cosoSelectId").html(optionCommoditySortStr);
                        treeObj = $.fn.zTree.init(treeObj, setting, commodityCategoryList);
                        if (commodity) {
                            $("#commodity-name").val(commodity.name);
                            $("#commodity-keyword").val(commodity.keyword);
                            $("#commodity-model").val(commodity.model);
                            $("#commodity-bar-code").val(commodity.barCode);
                            $("#commodity-format").val(commodity.format);
                            $("#commodity-pack").val(commodity.pack);
                            $("#commodity-unit").val(commodity.unit);
                            $("#commodity-price").val(commodity.price);
                            $("#commodity-retail").val(commodity.retail);
                            $("#commodity-wholesale").val(commodity.wholesale);
                            $("#commodity-comment").attr("checked",commodity.comment);
                            $('#cosoSelectId').selectpicker('val', commodity.cosoId);
                            $("#oriSelectId").val(commodity.oriId);

                            $("#commodity-id").val(commodity.id);

                            detailEdit.html(commodity.detail);
                            //主图片加载
                            $("#upload-single-img-display").imgLoad(commodity.mainImg,
                                "upload-single-img-div","upload-single-img-name");
                            options.images = commodity.images;

                            $("#commodity-category-id").val(commodity.cocaId);
                            loadSelectNode(commodity.cocaId);
                            lastClickCocaId = commodity.cocaId;
                        }
                        $('#cosoSelectId').selectpicker('refresh');
                        detailEdit.sync();
                    }
                }
            });
        }

        var upload = uploadMultipart("#upload", options);

        $("#commodity-save").click(function (e) {
            e.preventDefault();
            e.stopPropagation();
            var name = $("#commodity-name").val();
            if (validNotBlank(name)){
                showMessage("验证提示", "名称不能为空", false);
                return;
            }
            if (validLength(name,100)) {
                showMessage("验证提示", "名称长度超出", false);
                return;
            }

            var keyword = $("#commodity-keyword").val();
            if (validNotBlank(keyword)){
                showMessage("验证提示", "关键字不能为空", false);
                return;
            }
            if (validLength(keyword,100)) {
                showMessage("验证提示", "关键字长度超出", false);
                return;
            }

            var model = $("#commodity-model").val();
            if (validNotBlank(model)){
                showMessage("验证提示", "型号不能为空", false);
                return;
            }
            if (validLength(model,100)) {
                showMessage("验证提示", "型号长度超出", false);
                return;
            }

            var format = $("#commodity-format").val();
            if (!validNotBlank(format) && validLength(format,50)) {
                showMessage("验证提示", "规格长度超出", false);
                return;
            }

            var pack = $("#commodity-pack").val();
            if (!validNotBlank(pack) && validLength(pack,50)) {
                showMessage("验证提示", "包装长度超出", false);
                return;
            }
            var unit = $("#commodity-unit").val();
            if (!validNotBlank(unit) && validLength(unit,10)) {
                showMessage("验证提示", "单位长度超出", false);
                return;
            }

            var price = $("#commodity-price").val();
            if (validNotBlank(price)){
                showMessage("验证提示", "成本价不能为空", false);
                return;
            }
            if (regexp(price,REGEX_DECIMAL)) {
                showMessage("验证提示", "成本价格式不正确", false);
                return;
            }

            var retail = $("#commodity-retail").val();
            if (validNotBlank(retail)){
                showMessage("验证提示", "零售价不能为空", false);
                return;
            }
            if (regexp(retail,REGEX_DECIMAL)) {
                showMessage("验证提示", "零售价价格式不正确", false);
                return;
            }

            var wholesale = $("#commodity-wholesale").val();
            if (validNotBlank(wholesale)){
                showMessage("验证提示", "零售价不能为空", false);
                return;
            }
            if (regexp(wholesale,REGEX_DECIMAL)) {
                showMessage("验证提示", "零售价价格式不正确", false);
                return;
            }

            var commoditySort = $("#cosoSelectId").selectpicker("val");

            if (validNotBlank(commoditySort)){
                showMessage("验证提示", "请选择商品分类", false);
                return;
            }

            var imgName = $("#upload-single-img-name").val();
            if (validNotBlank(imgName)){
                showMessage("验证提示", "主图片不能为空", false);
                return;
            }
            if (validLength(imgName,150)) {
                showMessage("验证提示", "主图片长度超出", false);
                return;
            }

            if(lastClickCocaId < 0){
                showMessage("验证提示", "请选择左边的商品类目", false);
                return;
            }

            var imgs = $(".old-pictures");
            var length = imgs.length;
            var images = new Array();
            for(var i = 0 ; i < length ; i++) {
                images[i]= imgs[i].src;
            }
            options.oldPictureName = 'images';
            options.oldPictureList = images;

            upload();
        });

        $("#commodity-cancel").click(function (e) {
            e.preventDefault();
            window.location.href = '/sys/comm/commodity.page';

        });

        $(".commodity-category-list").click(function(e){
            e.preventDefault();
            window.location.href = '/sys/coca/commoditycategory.page';
        });

        //产地 下拉框
        function renderOriginSelect(originList) {
            if (originList && originList.length > 0) {
                $(originList).each(function (i, origin) {
                    optionOriginStr += Mustache.render("<option value='{{id}}'>{{name}}</option>",
                        {id: origin.id, name: origin.name});
                });
            }
        }

        //商品分类 下拉框
        function renderCommoditySortSelect(commoditySortList) {
            if (commoditySortList && commoditySortList.length > 0) {
                $(commoditySortList).each(function (i, commoditySort) {
                    optionCommoditySortStr += Mustache.render("<option value='{{id}}'>{{name}}</option>",
                        {id: commoditySort.id, name: commoditySort.name});
                });
            }
        }
    });

</script>

<script src="/js/valid/base-valid.js"></script>
<script src="/js/valid/commodity-valid.js"></script>
<script src="/js/defined/manager.js"></script>

</body>
</html>
