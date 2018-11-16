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

								<div>
									<form action="/load.json" class="dropzone well" id="dropzone" method="post" enctype="multipart/form-data" >
										<div class="fallback">
											<input name="file" type="file" multiple="" />
										</div>
									</form>
								</div>

                                <div id="preview-template" class="hide">
                                    <div class="dz-preview dz-file-preview">
                                        <div class="dz-image">
                                            <img data-dz-thumbnail="" />
                                        </div>

                                        <div class="dz-details">
                                            <div class="dz-size">
                                                <span data-dz-size=""></span>
                                            </div>

                                            <div class="dz-filename">
                                                <span data-dz-name=""></span>
                                            </div>
                                        </div>

                                        <div class="dz-progress">
                                            <span class="dz-upload" data-dz-uploadprogress=""></span>
                                        </div>

                                        <div class="dz-error-message">
                                            <span data-dz-errormessage=""></span>
                                        </div>

                                        <div class="dz-success-mark">
											<span class="fa-stack fa-lg bigger-150">
												<i class="fa fa-circle fa-stack-2x white"></i>

												<i class="fa fa-check fa-stack-1x fa-inverse green"></i>
											</span>
                                        </div>

                                        <%--<div class="dz-error-mark">--%>
                                        <%--<span class="fa-stack fa-lg bigger-150">--%>
                                        <%--<i class="fa fa-circle fa-stack-2x white"></i>--%>

                                        <%--<i class="fa fa-remove fa-stack-1x fa-inverse red"></i>--%>
                                        <%--</span>--%>
                                        <%--</div>--%>
                                    </div>
                                </div><!-- PAGE CONTENT ENDS -->
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
			jQuery(function($){
                var myDropzone;//上传文件对象
                var signFileName = [];//上次，文件名称
                Dropzone.auto = false;

                $("#dropzone").dropzone({
                    url: "/upload.json",
                    method : "post",
                    paramName : "myFiles", // 默认为file
                    parallelUploads: 3, //最大并行处理量
                    maxFiles : 1,// 一次性上传的文件数量上限
                    uploadMultiple : false,//多文件上传
                    autoProcessQueue : true,// 自动上传 默认为 true
                    maxFilesize : 18, // MB
                    addRemoveLinks:true, //添加删除按钮
                    acceptedFiles : ".pdf,.ppt,.pptx,.xls,.xlsx,.doc,.docx,.jpg,.png", // 上传的类型
                    dictMaxFilesExceeded : "您最多只能上传{{maxFiles}}个文件！",
                    dictResponseError : '文件上传失败!',
                    dictInvalidFileType : "你不能上传该类型文件,文件类型只能是*.pdf,*.ppt,*.pptx,*.xls,*.xlsx,*.doc,*.docx。",
                    dictFallbackMessage : "浏览器不受支持",
                    dictFileTooBig:"文件过大({{filesize}}MB). 上传文件最大支持: {{maxFilesize}}MB.",
                    dictRemoveFile: "删除",
                    dictDefaultMessage:"",
                    init : function() {
                        myDropzone = this;
                        this.on("addedfile", function(file) {
                            // 上传文件时触发的事件
                            //console.log("添加文件"+file.name);
                            var fileName = file.name;
                            if(signFileName != null && signFileName.length > 0){
                                signFileName.push(fileName);
                            }else{
                                // 上传文件存在，就删除
                                if(signFileName.join(",").indexOf(fileName) != -1){
                                    this.removeFile(file);
                                }else{
                                    signFileName.push(fileName);
                                }
                            }
                        });
                        this.on("queuecomplete", function(file) {
                            // 上传完成后触发的方法
                            //console.log("上传完成");
                        });
                        this.on("removedfile", function(file) {
                            // 删除文件时触发的方法
                            //console.log("删除文件"+file.name);
                            var fileName = file.name;
                            signFileName = $.grep(signFileName, function(value) {
                                return value != fileName;
                            });
                        });
                        this.on("error", function(file,msg,xhr){
                            //console.log($(file.previewTemplate));
                            //console.log($(file.previewTemplate).children('.dz-error-message'));
                        });
                        this.on("maxfilesexceeded", function(file){
                            //当文件数量超过限制时发生
                            //删除超过限制的文件
                            //this.removeFile(file);
                            //console.log(file.name);
                        });
                        this.on("success", function(file, result){
                            // 成功
                            dialogCollection.dialogTips({
                                text:"公告发布成功",
                                hideCancel:true
                            });
                            replaceCurrent({
                                url: CONTEXT_PATH + '/bulletinInfo/goBulletinInfo.do',
                                name: '通知公告管理'
                            });
                        });
                    }
                });
			});
		</script>
	</body>
</html>
