<%--
  Created by IntelliJ IDEA.
  User: wzbd01
  Date: 2018/10/7
  Time: 13:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="/common/common.jsp"/>
    <link href="/css/picture.css" rel="stylesheet">
    <link rel="stylesheet" href="/css/upload-mult.css">
    <link rel="stylesheet" type="text/css" href="/assets/select/css/bootstrap-select.min.css">

    <link rel="stylesheet" href="/kindeditor/themes/default/default.css"/>
    <link rel="stylesheet" href="/kindeditor/plugins/code/prettify.css"/>
    <script charset="utf-8" src="/kindeditor/kindeditor-all-min.js"></script>
    <script charset="utf-8" src="/kindeditor/lang/zh-CN.js"></script>
    <script charset="utf-8" src="/kindeditor/plugins/code/prettify.js"></script>
</head>
<body>


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
                    <i class="ace-icon fa fa-plus-circle orange bigger-130 dept-add"></i>
                </a>
            </div>
            <div id="deptList">
                <%-- js add --%>
            </div>
        </div>

        <div class="col-sm-9">
            <div class="ud-title">添加商品</div>
            <form class="form form-horizontal row-20" id="commodityForm" name="commodityForm">
                <table class="ud-table" style="overflow: auto;">
                    <tr>
                        <td>商品标题：</td>
                        <td colspan="5"><input type="text" class="form-control" placeholder="商品标题不能为空" name="name"></td>
                    </tr>

                    <tr>
                        <td>关键词：</td>
                        <td colspan="5"><input type="text" class="form-control" placeholder="关键词不能为空,用来快速查找" name="keyword">
                        </td>
                    </tr>

                    <tr>
                        <td class="td1">商品型号：</td>
                        <td class="td3"><input type="text" class="form-control" placeholder="商品型号不能为空" name="model"></td>
                        <td class="td2">条&nbsp;形&nbsp;码：</td>
                        <td class="td3"><input type="text" class="form-control" placeholder="" name="barCode"></td>
                        <td class="td2"></td>
                        <td class="td3"></td>
                    </tr>
                    <tr>
                        <td class="td1">商品规格：</td>
                        <td class="td3"><input type="text" class="form-control" placeholder="" name="format"></td>
                        <td class="td2">商品包装：</td>
                        <td class="td3"><input type="text" class="form-control" placeholder="" name="pack"></td>
                        <td class="td2">商品单位：</td>
                        <td class="td3"><input type="text" class="form-control" placeholder="" name="unit" value="个"></td>
                    </tr>

                    <tr>
                        <td>成本价：</td>
                        <td><input type="text" class="form-control" placeholder="" name="price"></td>
                        <td class="td2">零售价：</td>
                        <td><input type="text" class="form-control" placeholder="" name="retail"></td>
                        <td class="td2">批发价：</td>
                        <td><input type="text" class="form-control" placeholder="" name="wholesale"></td>
                    </tr>

                    <tr>
                        <td>商品分类：</td>
                        <td><select name="cosoId" id="cosoSelectId"
                                    class="selectpicker bla bla bli form-control" multiple
                                    data-live-search="false"></select>
                        </td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>

                    <tr>
                        <td>产地：</td>
                        <td>
                            <select class="form-control" id="oriSelectId" name="oriId">
                            </select></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>

                    <tr>
                        <td class="td5">主图：</td>
                        <td colspan="3">
                            <input id="upload-single-img-name" name="imgName" placeholder="图片不能为空" class="form-control"
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
                        <td colspan="5"><textarea name="detail" id="detail" rows="20" class="form-control"></textarea></td>
                    </tr>

                    <tr>
                        <td>允许评论：</td>
                        <td class="td4">
                            <input type="checkbox" class="ud-checked"><label>允许</label>
                        </td>
                        <td colspan="4">
                        </td>
                    </tr>

                    <tr>
                        <td colspan="6">
                            <div class="ud-div">
                                <button id="comm-save" class="btn btn-primary radius" type="button"><i
                                        class="icon-save "></i>保存
                                </button>
                                <button onClick="layer_close();" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
                            </div>
                        </td>
                    </tr>
                </table>


            </form>
        </div>
    </div>
</div>

</body>
</html>
