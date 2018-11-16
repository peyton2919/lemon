<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<html lang="en">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>Dropzone.js - Ace Admin</title>

		<meta name="description" content="Drag &amp; drop file upload with image preview" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

		<!-- bootstrap & fontawesome -->
		<link rel="stylesheet" href="assets/css/bootstrap.min.css" />
		<link rel="stylesheet" href="assets/font-awesome/4.5.0/css/font-awesome.min.css" />

		<!-- page specific plugin styles -->
		<link rel="stylesheet" href="assets/css/dropzone.min.css" />

		<!-- text fonts -->
		<link rel="stylesheet" href="assets/css/fonts.googleapis.com.css" />

		<!-- ace styles -->
		<link rel="stylesheet" href="assets/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style" />

		<!--[if lte IE 9]>
			<link rel="stylesheet" href="assets/css/ace-part2.min.css" class="ace-main-stylesheet" />
		<![endif]-->
		<link rel="stylesheet" href="assets/css/ace-skins.min.css" />
		<link rel="stylesheet" href="assets/css/ace-rtl.min.css" />

		<!--[if lte IE 9]>
		  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
		<![endif]-->

		<!-- inline styles related to this page -->

		<!-- ace settings handler -->
		<script src="assets/js/ace-extra.min.js"></script>

		<!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->

		<!--[if lte IE 8]>
		<script src="assets/js/html5shiv.min.js"></script>
		<script src="assets/js/respond.min.js"></script>
		<![endif]-->
        <style type="text/css">

            .dropz {/*设置拖拽上传文件按钮的格式*/
                min-height:0px;
                min-width: 100px;
                border: 1px solid #58AF0C;
                background: white;
                padding: 15px 20px;
                background-color: #7AC143;
                background-image: -webkit-gradient(linear, left bottom, left top, color-stop(0, #7AC143),
                color-stop(1, #7AC143));
                background-position: center top;
                background-repeat: no-repeat;
                border-radius: 5px;
                min-height:0px;
                min-width: 100px;
                padding: 15px 20px;
                color: #FFF;
                font: bold 12px Arial, Helvetica, sans-serif;
                text-align: center;
                text-shadow: 0 -1px 0 rgba(0, 0, 0, 0.25);
            }
            .dropz.dz-clickable {
                cursor: pointer;
                line-height: 0px;/*按钮中的文字垂直居中*/
            }
        </style>
	</head>

	<body class="no-skin">

		<div class="main-container ace-save-state" id="main-container">

			<div class="main-content">
				<div class="main-content-inner">
					<div class="breadcrumbs ace-save-state" id="breadcrumbs">
						<ul class="breadcrumb">
							<li>
								<i class="ace-icon fa fa-home home-icon"></i>
								<a href="#">Home</a>
							</li>

							<li>
								<a href="#">Forms</a>
							</li>
							<li class="active">Dropzone File Upload</li>
						</ul><!-- /.breadcrumb -->

					</div>

					<div class="page-content">
						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
								<div class="alert alert-info">
									<i class="ace-icon fa fa-hand-o-right"></i>

									Please note that demo server is not configured to save uploaded files, therefore you may get an error message.
									<button class="close" data-dismiss="alert">
										<i class="ace-icon fa fa-times"></i>
									</button>
								</div>

                                <%--<form class="dropzone well" id="dropz" method="post" enctype="multipart/form-data" >--%>
                                    <%--<div class="fallback">--%>
                                        <%--<input name="file" type="file" multiple="" />--%>
                                    <%--</div>--%>
                                    <%--<button type="button" id="qr">上传</button>--%>
                                <%--</form>--%>


                                <div class="form-group">
                                    <label class="title">真人照(最多只能传一张)</label>
                                    <div id="dropz1" class="dropzone"></div>//这段代码是展示dropzone.js的精髓
                                </div>
                                <input type="hidden" name="file_id" ng-model="file_id" id="file_id"/>

                              <!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
						</div><!-- /.row -->
					</div><!-- /.page-content -->
				</div>
			</div><!-- /.main-content -->

			<div class="footer">
				<div class="footer-inner">
					<div class="footer-content">
						<span class="bigger-120">
							<span class="blue bolder">Ace</span>
							Application &copy; 2013-2014
						</span>

						&nbsp; &nbsp;
						<span class="action-buttons">
							<a href="#">
								<i class="ace-icon fa fa-twitter-square light-blue bigger-150"></i>
							</a>

							<a href="#">
								<i class="ace-icon fa fa-facebook-square text-primary bigger-150"></i>
							</a>

							<a href="#">
								<i class="ace-icon fa fa-rss-square orange bigger-150"></i>
							</a>
						</span>
					</div>
				</div>
			</div>

			<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
				<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
			</a>
		</div><!-- /.main-container -->

		<!-- basic scripts -->

		<!--[if !IE]> -->
		<script src="assets/js/jquery-2.1.4.min.js"></script>

		<!-- <![endif]-->

		<!--[if IE]>
<script src="assets/js/jquery-1.11.3.min.js"></script>
<![endif]-->
		<script type="text/javascript">
			if('ontouchstart' in document.documentElement) document.write("<script src='assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
		<script src="assets/js/bootstrap.min.js"></script>

		<!-- page specific plugin scripts -->
		<script src="assets/js/dropzone.min.js"></script>

		<!-- ace scripts -->
		<script src="assets/js/ace-elements.min.js"></script>
		<script src="assets/js/ace.min.js"></script>

		<!-- inline scripts related to this page -->
		<script type="text/javascript">
            var appElement = document.querySelector('div .inmodal');
            var myDropzone = new Dropzone("#dropz1", {
                url: "/upload",//文件提交地址
            });

        </script>
	</body>
</html>
