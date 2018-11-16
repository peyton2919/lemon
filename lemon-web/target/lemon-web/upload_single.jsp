<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="/common/common.jsp"/>
</head>
<body style="overflow: scroll; overflow-y: hidden; overflow-x: hidden">
    <div style="height: 20px"></div>
    <div class="container">
        <div class="row">

            <div class="col-md-6 col-md-offset-3">
                <form class="form-horizontal" enctype="multipart/form-data" role="form" id="testform">

                    <input type="hidden" value="1" id="id" name="id" />
                    <div class="control-group">
                        <label for="uname" class="col-md-3 control-label span3">姓 名:</label>
                        <div class="col-md-9">
                            <input type="text" class="form-control span3" value="" id="uname" name="uname"
                                placeholder="请输入姓名">
                        </div>
                    </div>

                    <div class="control-group">
                        <label for="pwd" class="col-md-3 control-label span3">密码:</label>
                        <div class="col-md-9">
                            <input type="password" class="form-control span3" value="" id="pwd" name="pwd"
                                placeholder="请输入密码">
                        </div>
                    </div>

					<!--  文件上传开始     -->
                    <div id="upload">
<%-- style="display:none"--%>
                        <div class="control-group" id="displayImg"  style="display:none">
                            <label class="col-md-3 control-label span3"></label>
                            <div class="col-md-9">
                                <img id="img-display" src="" width="100px" height="100px" >
                                <i class="glyphicon glyphicon-remove red remove-img"
                                   style=" position: absolute; top:8px;left: 90px; color: #be0000"></i>
                            </div>
                        </div>

                        <div class="control-group">
                            <label for="requirement" class="col-md-3 control-label span3">图片上传</label>
                            <div class="col-md-9">
                                <div class="input-group" id="requirement">
                                    <input id="photoCover" class="form-control" readonly type="text">
                                    <label class="input-group-btn">
                                        <input id="file" type="file" name="file" style="left: -9999px; position: absolute; display: none;">
                                        <span class="btn btn-default" id="btn-browse">Browse</span>
                                    </label>
                                </div>
                            </div>
                        </div>

                        <div class="control-group">
                            <label class="col-md-2 control-label span2"></label>
                            <div class="col-md-10">
                            <a class="btn btn-small btn-primary" onclick="saveUser()">方式一</a>
                                <a class="btn btn-small btn-danger" onclick="saveUser2()">方式二</a>
                            </div>
                        </div>

                    </div>
					<!-- 文件上传结束  -->
                </form>
                

            </div>
        </div>
    </div>

    <jsp:include page="/example/upload_single.jsp"/>

    <script src="/js/defined/tools.js"></script>
    <script src="/js/defined/image.js"></script>
    <script src="/js/defined/upload-single.js"></script>
    <script>

        //html5实现图片预览功能
        $(function () {
            $("#btn-browse").loadUpload();

            // $("img").imgError({defaultImgPath:"/img/sys/logo_top.png"});
            // $("#img-display").imgLoad("/img/sys/lo1go.png");
            $("#img-display1").imgError();

            // $("img").imgError({defaultImgPath:"/img/sys/logo_top.png"});
        });

    </script>

</body>
</html>