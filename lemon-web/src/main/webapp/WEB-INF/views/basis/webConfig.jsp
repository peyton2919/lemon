<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>角色</title>
    <jsp:include page="/common/common.jsp"/>

    <link rel="stylesheet" href="/kindeditor/themes/default/default.css" />
    <link rel="stylesheet" href="/kindeditor/plugins/code/prettify.css" />
    <script charset="utf-8" src="/kindeditor/kindeditor-all-min.js"></script>
    <script charset="utf-8" src="/kindeditor/lang/zh-CN.js"></script>
    <script charset="utf-8" src="/kindeditor/plugins/code/prettify.js"></script>
    <!-- page specific plugin styles -->

</head>
<body class="no-skin init-iframe-box" youdao="bind" style="background: white">

<input id="gritter-light" checked="" type="checkbox" class="ace ace-switch ace-switch-5"/>

<div class="iframe-child">
    <div class="page-header">
        <h1>
            全局配置管理
            <small>
                <i class="ace-icon fa fa-angle-double-right"></i>
                维护全局配置
            </small>
        </h1>
    </div>

    <div class="main-content-inner">
    <div class="col-sm-12">

        <div id="tabs" class="col-sm-12">
            <ul>
                <li>
                    <a href="#tabs-base-setting" id="tabs-base-click">基础配置</a>&nbsp;
                </li>

                <li>
                    <a href="#tabs-ext-setting" id="tabs-ext-click">扩展配置</a>&nbsp;
                </li>

                <li>
                    <a href="#tabs-copyright-setting" id="tabs-copyright-click">版权配置</a>&nbsp;
                </li>
                <li>
                    <a href="#tabs-close-setting" id="tabs-close-click">关闭配置</a>&nbsp;
                </li>
            </ul>

            <div id="tabs-base-setting" class="col-sm-12">
                <input type="hidden" id="web-id">
                <table id="tabs-base-table" class="table table-striped table-bordered table-hover dataTable no-footer" role="grid"
                       aria-describedby="dynamic-table_info" style="font-size:14px">
                    <tbody id="tabsBaseTable">
                    <tr>
                        <td>网站名称</td><td><label id="detail-web-name"></label></td>
                        <td>网站标题</td><td><label id="detail-web-title"></label></td>
                    </tr>
                    <tr>
                        <td>电话</td><td><label id="detail-web-tel"></label></td>
                        <td>邮箱</td><td><label id="detail-web-email"></label></td>
                    </tr>
                    <tr>
                        <td>手机</td><td><label id="detail-web-phone"></label></td>
                        <td>链接地址</td><td><label id="detail-web-link"></label></td>
                    </tr>
                    <tr>
                        <td>传真</td><td><label id="detail-web-fax"></label></td>
                        <td>地址</td><td><label id="detail-web-add"></label></td>
                    </tr>
                    <tr>
                        <td>创建时间</td><td><label id="detail-web-created"></label></td>
                        <td>更新时间</td><td><label id="detail-web-updated"></label></td>
                    </tr>
                    <tr>
                        <td>logo图片</td><td colspan="3"><img id="detail-web-logo-image" src="" width="100" height="100"></td>
                    </tr>
                    </tbody>
                </table>
                <div class="col-sm-12 ud-div-center">
                    <button id="btn-base-edit" class="btn btn-info ud-btn-blue">修改</button>
                </div>

            </div>

            <div id="tabs-ext-setting" class="col-sm-12">
                <table id="tabs-ext-table" class="table table-striped table-bordered table-hover dataTable no-footer" role="grid"
                       aria-describedby="dynamic-table_info" style="font-size:14px">
                    <tbody id="tabsExtTable">
                    <tr>
                        <td>上传目录</td><td><label id="detail-web-upload-path"></label></td>
                    </tr>
                    <tr>
                        <td>网站皮肤</td><td><label id="detail-web-skin"></label></td>
                    </tr>
                    <tr>
                        <td>关键词</td><td><label id="detail-web-keyword"></label></td>
                    </tr>
                    <tr>
                        <td>统计代码</td><td><div id="detail-web-census-code"></div>
                    </td>
                    </tr>
                    </tbody>
                </table>
                <div class="col-sm-12 ud-div-center">
                    <button id="btn-ext-edit" class="btn btn-info ud-btn-blue">修改</button>
                </div>
            </div>

            <div id="tabs-copyright-setting" class="col-sm-12">
                <table id="tabs-copyright-table" class="table table-striped table-bordered table-hover dataTable no-footer" role="grid"
                       aria-describedby="dynamic-table_info" style="font-size:14px">
                    <tbody id="tabsCopyrightTable">
                    <tr>
                        <td>版权</td><td><div id="detail-web-copy-right"></div></td>
                    </tr>
                    <tr>
                        <td>标题图标</td>
                        <td>
                            <img id="detail-web-link-icon" src="" width="100" height="100" >
                        </td>
                    </tr>
                    <tr>
                        <td>ICP备案</td><td><div id="detail-web-icp"></div></td>
                    </tr>
                    <tr>
                        <td>网站描述</td><td><div id="detail-web-desc"></div></td>
                    </tr>
                    <tr>
                        <td>网站说明</td><td><div id="detail-web-explain"></div></td>
                    </tr>

                    </tbody>
                </table>
                <div class="col-sm-12 ud-div-center">
                    <button id="btn-copyright-edit" class="btn btn-info ud-btn-blue">修改</button>
                </div>
            </div>

            <div id="tabs-close-setting" class="col-sm-12">
                <table id="tabs-close-table" class="table table-striped table-bordered table-hover dataTable no-footer" role="grid"
                       aria-describedby="dynamic-table_info" style="font-size:14px">
                    <tbody id="tabsCloseTable">
                    <tr>
                        <td>是否关闭</td><td><label id="detail-web-status" class="label label-lg label-warning"></label></td>
                    </tr>
                    <tr>
                        <td colspan="2"><div id="detail-web-close-tip"></div></td>
                    </tr>
                    </tbody>
                </table>
                <div class="col-sm-12 ud-div-center">
                    <button id="btn-close-edit" class="btn btn-info ud-btn-blue">修改</button>
                </div>
            </div>
        </div>
    </div>
</div>
</div>

<div id="dialog-base-form" style="display: none;">

    <form id="baseForm">
        <table class="table table-striped table-bordered table-hover dataTable no-footer" role="grid"
               aria-describedby="dynamic-table_info" style="font-size:14px">
            <tbody>
            <tr>
                <td><label for="web-name">网站名称</label></td>
                <td>
                    <input type="hidden" name="id" id="base-id">
                    <input type="text" name="webName" id="web-name" placeholder="网站名称不能为空" class="text ui-widget-content ui-corner-all">
                </td>
                <td><label for="web-title">网站标题</label></td>
                <td>
                    <input type="text" name="webTitle" id="web-title" placeholder="网站标题不能为空" class="text ui-widget-content ui-corner-all">
                </td>
            </tr>
            <tr>
                <td><label for="web-tel">电话</label></td>
                <td>
                    <input type="text" name="webTel" id="web-tel" placeholder="电话不能为空" class="text ui-widget-content ui-corner-all">
                </td>
                <td><label for="web-email">邮箱</label></td>
                <td>
                    <input type="text" name="webEmail" id="web-email" placeholder="邮箱不能为空" class="text ui-widget-content ui-corner-all">
                </td>
            </tr>
            <tr>
                <td><label for="web-phone">手机</label></td>
                <td>
                    <input type="text" name="webPhone" id="web-phone" placeholder="手机不能为空" class="text ui-widget-content ui-corner-all">
                </td>
                <td><label for="web-link">链接地址</label></td>
                <td>
                    <input type="text" name="webLink" id="web-link" placeholder="链接地址不能为空" class="text ui-widget-content ui-corner-all">
                </td>
            </tr>
            <tr>
                <td><label for="web-fax">传真</label></td>
                <td>
                    <input type="text" name="webFax" id="web-fax" placeholder="传真不能为空" class="text ui-widget-content ui-corner-all">
                </td>
                <td><label for="web-add">地址</label></td>
                <td>
                    <input type="text" name="webAdd" id="web-add" placeholder="地址不能为空" class="text ui-widget-content ui-corner-all">
                </td>
            </tr>
            <tr>
                <td>logo图片</td>
                <td colspan="3">
                    <div class="control-group">
                        <div class="col-md-12">
                            <div class="input-group" id="requirement">
                                <input id="web-logo-image-name" name="imgName" placeholder="图片不能为空" class="form-control" readonly type="text">
                                <label class="input-group-btn">
                                    <input id="web-logo-image-file" type="file" name="logoImgFile" style="left: -9999px; position: absolute; display: none;">
                                    <span class="btn btn-default" id="btn-web-logo-image">Browse</span>
                                </label>
                            </div>
                        </div>
                    </div>
                    <%--//图片显示--%>
                    <div class="control-group" id="web-logo-image-div" style="display:none">
                        <div class="col-md-12">
                            <img id="web-logo-image-display" src="" width="100px" height="100px" >
                            <%--<i class="glyphicon glyphicon-remove red remove-img"--%>
                               <%--style=" position: absolute; top:8px;left: 90px; color: #be0000"></i>--%>
                        </div>
                    </div>
                </td>
            </tr>
            </tbody>
        </table>
    </form>

</div>

<div id="dialog-ext-form" style="display: none;">
    <form id="extForm">
        <table class="table table-striped table-bordered table-hover dataTable no-footer" role="grid"
               aria-describedby="dynamic-table_info" style="font-size:14px">
            <tbody>
            <tr>
                <td><label for="web-upload-path">文件目录</label></td>
                <td>
                    <input type="hidden" name="id" id="ext-id">
                    <input type="text" name="webUploadPath" id="web-upload-path" placeholder="" class="form-control">
                </td>

            </tr>
            <tr>
                <td><label for="web-skin">网站皮肤</label></td>
                <td>
                    <input type="text" name="webSkin" id="web-skin" placeholder="" class="form-control">
                </td>
            </tr>
            <tr>
                <td><label for="web-keyword">关键词</label></td>
                <td>
                    <input type="text" name="webKeyword" id="web-keyword" placeholder="" class="form-control">
                </td>
            </tr>
            <tr>
                <td><label for="web-census-code">统计代码</label></td>
                <td>
                    <textarea name="webCensusCode" id="web-census-code" cols="45" rows="15"
                              style="width:560px;height:360px;"></textarea>
                </td>
            </tr>
            </tbody>
        </table>
    </form>
</div>

<div id="dialog-copyright-form" style="display: none;">
    <form id="copyrightForm">
        <table class="table table-striped table-bordered table-hover dataTable no-footer" role="grid"
               aria-describedby="dynamic-table_info" style="font-size:14px">
            <tbody>
            <tr>
                <td><label for="web-copy-right">版权</label></td>
                <td>
                    <input type="hidden" name="id" id="copyright-id">
                    <textarea name="webCopyRight" id="web-copy-right" cols="45" rows="12"
                              style="width:560px;height:200px;"></textarea>
                </td>

            </tr>
            <tr>
                <td><label>浏览器上图标</label></td>
                <td>
                    <div class="control-group">
                        <div class="col-md-12">
                            <div class="input-group">
                                <input id="web-link-icon-name" name="imgName" placeholder="图片不能为空" class="form-control" readonly type="text">
                                <label class="input-group-btn">
                                    <input id="web-link-icon-file" type="file" name="linkIconFile" style="left: -9999px; position: absolute; display: none;">
                                    <span class="btn btn-default" id="btn-web-link-icon">Browse</span>
                                </label>
                            </div>
                        </div>
                    </div>
                    <%--//图片显示--%>
                    <div class="control-group" id="web-link-icon-div" style="display:none">
                        <div class="col-md-12">
                            <img id="web-link-icon-display" src="" width="100px" height="100px" >
                        </div>
                    </div>
                </td>
            </tr>

            <tr>
                <td><label for="web-icp">ICP备案</label></td>
                <td>
                    <textarea name="webIcp" id="web-icp" cols="45" rows="12"
                              style="width:560px;height:200px;"></textarea>
                </td>
            </tr>
            <tr>
                <td><label for="web-desc">站点描述</label></td>
                <td>
                    <textarea name="webDesc" id="web-desc" cols="45" rows="12"
                              style="width:560px;height:200px;"></textarea>
                </td>
            </tr>
            <tr>
                <td><label for="web-explain">站点说明</label></td>
                <td>
                    <textarea name="webExplain" id="web-explain" cols="45" rows="12"
                              style="width:560px;height:200px;"></textarea>
                </td>
            </tr>
            </tbody>
        </table>
    </form>
</div>

<div id="dialog-close-form" style="display: none;">
    <form id="closeForm">
        <table class="table table-striped table-bordered table-hover dataTable no-footer" role="grid"
               aria-describedby="dynamic-table_info" style="font-size:14px">
            <tbody>
            <tr>
                <td><label for="web-status">状态</label></td>
                <td>
                    <input type="hidden" name="id" id="close-id">
                    <select name="webStatus" id="web-status" class="form-control">
                        <option value="0">关闭</option>
                        <option value="1">开启</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td><label for="web-close-tip">关闭提示</label></td>
                <td>
                    <textarea name="webCloseTip" id="web-close-tip" cols="45" rows="12"
                              style="width:560px;height:400px;"></textarea>
                </td>
            </tr>
            </tbody>
        </table>
    </form>
</div>

<script src="/js/defined/tools.js"></script>
<script src="/js/defined/image.js"></script>
<script src="/js/defined/upload-single.js"></script>

<script type="text/javascript">

    $(function () {
        $( "#tabs" ).tabs();

        //Browse 浏览 点击 事件
        $("#btn-web-logo-image").loadUpload({
            displayDivId:'web-logo-image-div', //标记 显示图片div层的id
            imgId:'web-logo-image-display', //标记要显示img的id
            displayNameId:'web-logo-image-name', //标记 显示 文件名称 id
            fileId:'web-logo-image-file'  //标记 input type= 'file' 的id
        });

        //Browse 浏览 点击 事件
        $("#btn-web-link-icon").loadUpload({
            displayDivId:'web-link-icon-div', //标记 显示图片div层的id
            imgId:'web-link-icon-display', //标记要显示img的id
            displayNameId:'web-link-icon-name', //标记 显示 文件名称 id
            fileId:'web-link-icon-file'  //标记 input type= 'file' 的id
        });

        loadWebConfigBase();

        $("#tabs-base-click").click(function () {
            loadWebConfigBase();
        });

        $("#btn-base-edit").click(function (e) {
            e.preventDefault();
            e.stopPropagation();
            var webId = $("#web-id").val();
            $.ajax({
                url:'/wc/detail_base.json',
                id : webId,
                success : function (result) {
                    if (result.status == 200) {
                        var webConfig = result.data;
                        imgReset({
                            displayDivId:'web-logo-image-div', //标记 显示图片div层的id
                            imgId:'web-logo-image-display', //标记要显示img的id
                            displayNameId:'web-logo-image-name', //标记 显示 文件名称 id
                            fileId:'web-logo-image-file'  //标记 input type= 'file' 的id
                        });
                        $("#dialog-base-form").dialog({
                            model: true,
                            width: 580,
                            title: "编辑基础配置",
                            open: function(event, ui) {
                                $(".ui-dialog-titlebar-close", $(this).parent()).hide();
                                $("#base-id").val(webConfig.id);
                                $("#web-name").val(webConfig.webName);
                                $("#web-title").val(webConfig.webTitle);
                                $("#web-tel").val(webConfig.webTel);
                                $("#web-email").val(webConfig.webEmail);
                                $("#web-phone").val(webConfig.webPhone);
                                $("#web-link").val(webConfig.webLink);
                                $("#web-fax").val(webConfig.webFax);
                                $("#web-add").val(webConfig.webAdd);

                                $("#web-logo-image-display").imgLoad(webConfig.webLogoImage,"web-logo-image-div","web-logo-image-name");
                            },
                            buttons : {
                                "保存": function (e) {
                                    e.preventDefault();
                                    updateWebConfig("/sys/wc/update_base.json","baseForm","base",
                                        function (data) {
                                            clearData("baseForm");
                                            $("#dialog-base-form").dialog("close");

                                        }, function (data) {
                                            showMessage("更新基础配置", data.msg, false);
                                        })
                                },
                                "取消": function () {
                                    clearData("baseForm");
                                    $("#dialog-base-form").dialog("close");
                                }
                            }
                        });
                    }
                }
            });

        });

        function loadWebConfigBase() {
            $.ajax({
                url:'/wc/detail_base.json',
                success:function (result) {
                    if (result.status == 200) {
                        var webConfig = result.data;
                        $("#web-id").val(webConfig.id);
                        $("#detail-web-name").html(webConfig.webName);
                        $("#detail-web-title").html(webConfig.webTitle);
                        $("#detail-web-tel").html(webConfig.webTel);
                        $("#detail-web-email").html(webConfig.webEmail);
                        $("#detail-web-phone").html(webConfig.webPhone);
                        $("#detail-web-link").html(webConfig.webLink);
                        $("#detail-web-fax").html(webConfig.webFax);
                        $("#detail-web-add").html(webConfig.webAdd);
                        $("#detail-web-created").html(webConfig.webCreated);
                        $("#detail-web-updated").html(webConfig.webUpdated);
                        //加载图片
                        $("#detail-web-logo-image").imgSimpleLoad(webConfig.webLogoImage);
                    }
                }
            });
        };

        $("#tabs-ext-click").click(function (e) {
            loadWebConfigExt();
        });

        $("#btn-ext-edit").click(function (e) {
            e.preventDefault();
            e.stopPropagation();
            var webId = $("#web-id").val();
            $.ajax({
                url : '/wc/detail_ext.json',
                id : webId,
                success : function (result) {
                    if (result.status == 200){
                        var webConfig = result.data;
                        $("#dialog-ext-form").dialog({
                            model: true,
                            width: 780,
                            title: "编辑扩展配置",
                            open: function(event, ui) {
                                //$("body > div[role=dialog]").appendTo("form#form");
                                var ccEdit = KindEditor.create('textarea[name="webCensusCode"]', {
                                    resizeType : 1,
                                    afterCreate: function(){this.sync();},
                                    //下面这行代码就是关键的所在，当失去焦点时执行 this.sync();
                                    afterBlur: function(){this.sync();}
                                });

                                $(".ui-dialog-titlebar-close", $(this).parent()).hide();
                                $("#ext-id").val(webConfig.id);
                                $("#web-upload-path").val(webConfig.webUploadPath);
                                $("#web-skin").val(webConfig.webSkin);
                                $("#web-keyword").val(webConfig.webKeyword);

                                ccEdit.html(webConfig.webCensusCode);
                                ccEdit.sync();
                            },
                            beforeClose : function(event, ui) {
                                // $("form > div[role=dialog]").remove();
                                // 关闭Dialog前移除编辑器
                                KindEditor.remove('textarea[name="webCensusCode"]');
                            },
                            buttons : {
                                "保存": function (e) {
                                    e.preventDefault();
                                    updateWebConfig("/sys/wc/update_ext.json","extForm","ext",
                                        function (data) {
                                            clearData("extForm");
                                            $("#dialog-ext-form").dialog("close");

                                        }, function (data) {
                                            showMessage("更新扩展配置", data.msg, false);
                                        })
                                },
                                "取消": function () {
                                    clearData("extForm");
                                    $("#dialog-ext-form").dialog("close");
                                }
                            }
                        });
                    }
                }
            });

        });

        function loadWebConfigExt() {
            $.ajax({
                url:'/wc/detail_ext.json',
                success:function (result) {
                    if (result.status == 200) {
                        var webConfig = result.data;
                        $("#web-id").val(webConfig.id);
                        $("#detail-web-upload-path").html(webConfig.webUploadPath);
                        $("#detail-web-skin").html(webConfig.webSkin);
                        $("#detail-web-keyword").html(webConfig.webKeyword);
                        $("#detail-web-census-code").html(webConfig.webCensusCode);
                    }
                }
            });
        };

        $("#tabs-copyright-click").click(function (e) {
            loadWebConfigCopyright();
        });

        $("#btn-copyright-edit").click(function (e) {
            e.preventDefault();
            e.stopPropagation();
            var webId = $("#web-id").val();
            $.ajax({
                url : '/wc/detail_copyright.json',
                id : webId,
                success : function (result) {
                    if (result.status == 200){
                        var webConfig = result.data;
                        imgReset({
                            displayDivId:'web-link-icon-div', //标记 显示图片div层的id
                            imgId:'web-link-icon-display', //标记要显示img的id
                            displayNameId:'web-link-icon-name', //标记 显示 文件名称 id
                            fileId:'web-link-icon-file'  //标记 input type= 'file' 的id
                        });
                        $("#dialog-copyright-form").dialog({
                            model: true,
                            width: 780,
                            title: "编辑扩展配置",
                            open: function(event, ui) {
                                $(".ui-dialog-titlebar-close", $(this).parent()).hide();
                                //$("body > div[role=dialog]").appendTo("form#form");
                                var crEdit = KindEditor.create('textarea[name="webCopyRight"]', {
                                    resizeType : 1,
                                    afterCreate: function(){this.sync();},
                                    //下面这行代码就是关键的所在，当失去焦点时执行 this.sync();
                                    afterBlur: function(){this.sync();}
                                });
                                var icEdit = KindEditor.create('textarea[name="webIcp"]', {
                                    resizeType : 2,
                                    afterCreate: function(){this.sync();},
                                    //下面这行代码就是关键的所在，当失去焦点时执行 this.sync();
                                    afterBlur: function(){this.sync();}
                                });
                                var deEdit = KindEditor.create('textarea[name="webDesc"]', {
                                    resizeType : 3,
                                    afterCreate: function(){this.sync();},
                                    //下面这行代码就是关键的所在，当失去焦点时执行 this.sync();
                                    afterBlur: function(){this.sync();}
                                });
                                var exEdit = KindEditor.create('textarea[name="webExplain"]', {
                                    resizeType : 4,
                                    afterCreate: function(){this.sync();},
                                    //下面这行代码就是关键的所在，当失去焦点时执行 this.sync();
                                    afterBlur: function(){this.sync();}
                                });

                                $("#copyright-id").val(webConfig.id);

                                // KindEditor.html('#web-copy-right',webConfig.webCopyRight);
                                crEdit.html(webConfig.webCopyRight);
                                icEdit.html(webConfig.webIcp);
                                deEdit.html(webConfig.webDesc);
                                exEdit.html(webConfig.webExplain);
                                $("#web-link-icon-display").imgLoad(webConfig.webLinkIcon,"web-link-icon-div","web-link-icon-name");

                                crEdit.sync();
                                icEdit.sync();
                                deEdit.sync();
                                exEdit.sync();
                            },
                            beforeClose : function(event, ui) {
                                // $("form > div[role=dialog]").remove();
                                // 关闭Dialog前移除编辑器
                                KindEditor.remove('textarea[name="webCopyRight"]');
                                KindEditor.remove('textarea[name="webIcp"]');
                                KindEditor.remove('textarea[name="webDesc"]');
                                KindEditor.remove('textarea[name="webExplain"]');
                            },
                            buttons : {
                                "保存": function (e) {
                                    e.preventDefault();
                                    updateWebConfig("/sys/wc/update_copyright.json","copyrightForm","copyright",
                                        function (data) {
                                            clearData("copyrightForm");
                                            $("#dialog-copyright-form").dialog("close");

                                        }, function (data) {
                                            showMessage("更新扩展配置", data.msg, false);
                                        })
                                },
                                "取消": function () {
                                    clearData("copyrightForm");
                                    $("#dialog-copyright-form").dialog("close");
                                }
                            }
                        });
                    }
                }
            });
        });

        function loadWebConfigCopyright() {
            $.ajax({
                url:'/wc/detail_copyright.json',
                success:function (result) {
                    if (result.status == 200) {
                        var webConfig = result.data;
                        $("#web-id").val(webConfig.id);
                        $("#detail-web-copy-right").html(webConfig.webCopyRight);
                        $("#detail-web-icp").html(webConfig.webIcp);
                        $("#detail-web-desc").html(webConfig.webDesc);
                        $("#detail-web-explain").html(webConfig.webExplain);

                        //加载图片
                        $("#detail-web-link-icon").imgSimpleLoad(webConfig.webLinkIcon);
                    }
                }
            });
        };

        $("#tabs-close-click").click(function (e) {
            loadWebConfigClose();
        });

        $("#btn-close-edit").click(function (e) {
            e.preventDefault();
            e.stopPropagation();
            var webId = $("#web-id").val();
            $.ajax({
                url : '/wc/detail_close.json',
                id : webId,
                success : function (result){
                    if (result.status == 200) {
                        var webConfig = result.data;
                        $("#dialog-close-form").dialog({
                            model: true,
                            width: 780,
                            title: "编辑版权配置",
                            open: function(event, ui) {
                                $(".ui-dialog-titlebar-close", $(this).parent()).hide();

                                $("#close-id").val(webConfig.id);
                                $("#web-status").val(webConfig.webStatus);
                                var ctEdit = KindEditor.create('textarea[name="webCloseTip"]', {
                                    resizeType : 1,
                                    afterCreate: function(){this.sync();},
                                    //下面这行代码就是关键的所在，当失去焦点时执行 this.sync();
                                    afterBlur: function(){this.sync();}
                                });
                                ctEdit.html(webConfig.webCloseTip);
                                ctEdit.sync();
                            },
                            beforeClose : function(event, ui) {
                                // $("form > div[role=dialog]").remove();
                                // 关闭Dialog前移除编辑器
                                KindEditor.remove('textarea[name="webCloseTip"]');
                            },
                            buttons : {
                                "保存": function (e) {
                                    e.preventDefault();
                                    updateWebConfig("/sys/wc/update_close.json","closeForm",'close',
                                        function (data) {
                                            clearData("closeForm");
                                            $("#dialog-close-form").dialog("close");

                                        }, function (data) {
                                            showMessage("更新关闭配置", data.msg, false);
                                        })
                                },
                                "取消": function () {
                                    clearData("closeForm");
                                    $("#dialog-close-form").dialog("close");
                                }
                            }
                        });
                    }
                }
            });

        });

        function loadWebConfigClose() {
            $.ajax({
                url:'/wc/detail_close.json',
                success:function (result) {
                    if (result.status == 200) {
                        webConfig = result.data;
                        $("#web-id").val(webConfig.id);
                        $("#detail-web-status").html(webConfig.webStatus == 0 ? '关闭': '开启');
                        $("#detail-web-close-tip").html(webConfig.webCloseTip);
                    }
                }
            });
        }

        //todo
        function updateWebConfig(url,formElementId,loadName,successCallback, failCallback) {
            // var formData = new FormData($("#baseForm")[0]);
            if (loadName == 'base') {
                if (validBase()) {
                    return;
                }
            }else if (loadName == 'ext') {
                if (validExt()) {
                    return;
                }
            }else if (loadName == 'copyright') {
                if (validCopyRight()) {
                    return;
                }
            }else if (loadName == 'close'){
                if (validClose()){
                    return;
                }
            }
            var formData = new FormData($("#" + formElementId)[0]);

            $.ajax({
                url: url,
                data: formData,
                type: 'POST',
                async: false,
                cache: false,
                contentType: false,
                processData: false,
                success: function(result) {
                    if (result.status == 200) {
                        //todo loadDeptTree();
                        if (loadName == 'base') {
                            loadWebConfigBase();
                        }else if(loadName == 'ext'){
                            loadWebConfigExt();
                        }else if(loadName == 'copyright'){
                            loadWebConfigCopyright();
                        }else if(loadName == 'close'){
                            loadWebConfigClose();
                        }

                        if (successCallback) {
                            successCallback(result);
                        }
                    } else {
                        if (failCallback) {
                            failCallback(result);
                        }
                    }
                }
            });
        }

        $("#detail-web-logo-image").imgError();
    });

</script>

<script src="/js/valid/base-valid.js"></script>
<script src="/js/valid/webconfig-valid.js"></script>
<script src="/js/defined/manager.js"></script>
</body>
</html>
