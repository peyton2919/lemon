<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>商品详细</title>
    <jsp:include page="/common/common.jsp"/>
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

        <div class="col-sm-9">
            <div class="table-header"><label class="commodity-title"></label> </div>
            <form class="form form-horizontal row-20" id="commodityForm" name="commodityForm">
                <input type="hidden" id="commodity-category-id" name="cocaId">
                <input type="hidden" name="id" id="commodity-id">
                <table class="ud-table">
                    <tr>
                        <td>商品标题：</td>
                        <td colspan="5"><label id="commodity-name"></label> </td>
                    </tr>

                    <tr>
                        <td>关键词：</td>
                        <td colspan="5"><label id="commodity-keyword"></label></td>
                    </tr>

                    <tr>
                        <td class="td1">商品型号：</td>
                        <td class="td3"><label id="commodity-model"></label></td>
                        <td class="td2">条&nbsp;形&nbsp;码：</td>
                        <td class="td3"><label id="commodity-bar-code"></label></td>
                        <td class="td2"></td>
                        <td class="td3"></td>
                    </tr>
                    <tr>
                        <td class="td1">商品规格：</td>
                        <td class="td3"><label id="commodity-format"></label></td>
                        <td class="td2">商品包装：</td>
                        <td class="td3"><label id="commodity-pack"></label></td>
                        <td class="td2">商品单位：</td>
                        <td class="td3"><label id="commodity-unit"></label></td>
                    </tr>

                    <tr>
                        <td>成本价：</td>
                        <td><label id="commodity-price"></label></td>
                        <td class="td2">零售价：</td>
                        <td><label id="commodity-retail"></label></td>
                        <td class="td2">批发价：</td>
                        <td><label id="commodity-wholesale"></label></td>
                    </tr>

                    <tr>
                        <td>商品分类：</td>
                        <td><label id="coso-select-id"></label></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>

                    <tr>
                        <td>产地：</td>
                        <td><label id="ori-select-id"></label></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>

                    <tr>
                        <td class="td6">主图：</td>
                        <td colspan="3">
                            <div></div>
                            <img id="commodity-main-img" src="">
                        </td>
                        <td class="td4">
                        </td>
                        <td>
                        </td>
                    </tr>

                    <tr>
                        <td class="td6">图片集合：</td>
                        <td colspan="5">
                            <div id="commodity-images">
                                <%-- 多图片 --%>
                            </div>
                        </td>
                    </tr>

                    <tr>
                        <td class="td6">详细内容：</td>
                        <td colspan="5">
                            <label id="commodity-detail"></label>
                        </td>
                    </tr>

                    <tr>
                        <td>允许评论：</td>
                        <td class="td4">
                            <input type="checkbox" class="ud-checked" disabled id="commodity-comment" name="comment"><label for="commodity-comment">允许</label>
                        </td>
                        <td colspan="4">
                        </td>
                    </tr>

                    <tr>
                        <td colspan="6">
                            <div class="ud-div">
                                <button id="commodity-cancel" class="btn btn-default radius ud-btn-width-120" type="button">取消</button>
                            </div>
                        </td>
                    </tr>
                </table>
            </form>
        </div>

        <div class="col-sm-3">

        </div>
    </div>
</div>

<script id="imageListTemplate" type="x-tmpl-mustache">
{{#imageList}}
    <div>
        <img class="ud-img-margin" src="{{name}}">
    </div>
{{/imageList}}
</script>

<script src="/js/defined/image.js"></script>

<script type="text/javascript">

    $(function () {
        //模板
        var imageListTemplate = $('#imageListTemplate').html();
        Mustache.parse(imageListTemplate); //用 Mustache 解析

        load();

        function  load() {
            var id = $("#commodityId").val();
            $(".commodity-title").html("商品详情");
            $.ajax({
                url: '/sys/comm/detail.json',
                data : {id : id},
                success: function (res) {
                    if (res.status == 200) {

                        var commodity = res.data;
                        if(commodity){
                            $("#commodity-name").html(commodity.name);
                            $("#commodity-keyword").html(commodity.keyword);
                            $("#commodity-model").html(commodity.model);
                            $("#commodity-bar-code").html(commodity.barCode);
                            $("#commodity-format").html(commodity.format);
                            $("#commodity-pack").html(commodity.pack);
                            $("#commodity-unit").html(commodity.unit);
                            $("#commodity-price").html(commodity.price);
                            $("#commodity-retail").html(commodity.retail);
                            $("#commodity-wholesale").html(commodity.wholesale);
                            $("#commodity-detail").html(commodity.detail);
                            $("#commodity-comment").attr("checked",commodity.comment);

                            $("#commodity-main-img").imgLoad(commodity.mainImg);
                            var rendered = Mustache.render(imageListTemplate,
                                {imageList: commodity.images ,
                                    "name" : function() {
                                        return this;
                                    }
                                });
                            $("#commodity-images").html(rendered);
                        }
                    }
                }
            });
        }

        $("#commodity-cancel").click(function (e) {
            e.preventDefault();
            window.location.href = '/sys/comm/commodity.page';
        });
    });

</script>

</body>
</html>
