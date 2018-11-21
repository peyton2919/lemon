<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <jsp:include page="/common/common.jsp"/>
    <link rel="stylesheet" type="text/css" href="/css/manager-cus.css">
    <style type="text/css">
        ul,li,li ul {
            margin: 0;
            padding: 0;
        }
    </style>
</head>

<body class="no-skin" style="background-color: white;">

    <header class="ud-header">
        <div class="ud-entered">
            <div class="ud-header-content ud-flex">
                <div class="ud-column">
                    <a href="/" class="ud-column-logo">
                        <img src="/img/sys/logo_01.png" title="" about="" alt="">
                    </a>
                </div>
                <div class="ud-column">
                    <div class="ud-column-user">
                        <div class="ud-user-photo">
                            <a href="javascript:;">
                                <img src="/img/sys/headline.ico" title="" about="" alt="">
                            </a>
                        </div>
                        <div class="ud-user-info">
                            <div class="ud-user-info-name">
                                <a href="javascript:;">万姿百袋</a>
                            </div>
                            <div class="ud-user-info-func ud-flex">
                                <span class="ud-tag">账号审核中</span>
                                <span><i class="fa fa-envelope"></i><em>12</em></span> &nbsp;|&nbsp;
                                <a href="javascript:;">退出</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </header>

    <div id="main-container" class="container ud-body">

        <div class="col-sm-3 center">
            <div class="ud-menu">
                <ul>
                    <li class="ud-menu-item">
                        <a href="/" class="active">
                            <i class="fa fa-home"></i>首页</a>
                    </li>

                    <li class="ud-menu-item">
                        <a href="release.html"><i class="ud-icon ud-icon-find fl"></i>发布</a>
                    </li>

                    <li class="ud-menu-item" style="margin: 0; padding: 0; border: 0;">
                        <span class="ud-menu-sub-title">
                            <i class="fa fa-wrench"></i>管理
                        </span>
                        <ul>
                            <li>
                                <a href="content.html">内容管理</a>
                            </li>
                            <li>
                                <a href="related.html">内容同步</a>
                            </li>
                            <li>
                                <a href="asset.html">素材中心</a>
                            </li>
                        </ul>
                    </li>

                    <li class="ud-menu-item">
                        <span class="ud-menu-sub-title">
                            <i class="fa fa-wrench"></i>数据
                        </span>
                        <ul>
                            <li>
                                <a href="subscribe.html">订阅数据</a>
                            </li>
                            <li>
                                <a href="content-data.html">内容数据</a>
                            </li>
                            <li>
                                <a href="index-starLevel.html">指数星级</a>
                            </li>
                        </ul>
                    </li>

                    <li class="ud-menu-item">
                        <span class="ud-menu-sub-title">
                            <i class="fa fa-wrench"></i>设置
                        </span>
                        <ul>
                            <li>
                                <a href="info.html">账号信息</a>
                            </li>
                            <li>
                                <a href="account.html">账号状态</a>
                            </li>
                        </ul>
                    </li>

                    <li class="ud-menu-item">
                        <span class="ud-menu-sub-title">
                            <i class="fa fa-wrench"></i>客服
                        </span>
                        <ul>
                            <li>
                                <a href="#">在线咨询</a>
                            </li>
                        </ul>
                    </li>

                </ul>
            </div>
        </div>

        <div  class="col-sm-9" style="border: red 1px solid; height: auto;min-height: 1300px;">

            <div id="myCarousel" class="carousel slide mb10 h122">
                <!-- 轮播（Carousel）指标 -->
                <%--<ol class="carousel-indicators">--%>
                <%--<li data-target="#myCarousel" data-slide-to="0" class="active"></li>--%>
                <%--<li data-target="#myCarousel" data-slide-to="1"></li>--%>
                <%--<li data-target="#myCarousel" data-slide-to="2"></li>--%>
                <%--</ol>--%>
                <!-- 轮播（Carousel）项目 -->
                <div class="carousel-inner">
                    <div class="item active">
                        <img src="/img/ad/ad1.jpg" alt="First slide">
                        <div class="carousel-caption">标题 1</div>
                    </div>
                    <div class="item">
                        <img src="/img/ad/ad2.jpg" alt="Second slide">
                        <div class="carousel-caption">标题 2</div>
                    </div>
                    <div class="item">
                        <img src="/img/ad/ad3.jpg" alt="Third slide">
                        <div class="carousel-caption">标题 3</div>
                    </div>
                </div>
                <!-- 轮播（Carousel）导航 -->
                <%--<a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">--%>
                <%--<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>--%>
                <%--<span class="sr-only">Previous</span>--%>
                <%--</a>--%>
                <%--<a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">--%>
                <%--<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>--%>
                <%--<span class="sr-only">Next</span>--%>
                <%--</a>--%>
            </div>

            <div class="ud-right-head">

                <div class="ud-right-head-info">
                    <dl>
                        <a href="#">
                            <dt>总订阅</dt>
                            <dd>14</dd>
                        </a>
                    </dl>
                    <dl>
                        <a href="#">
                            <dt>总阅读</dt>
                            <dd>224</dd>
                        </a>
                    </dl>
                    <dl>
                        <a href="#">
                            <dt>昨日阅读</dt>
                            <dd>14</dd>
                        </a>
                    </dl>
                    <dl>
                        <a href="#">
                            <dt>总数据指数</dt>
                            <dd>158</dd>
                        </a>
                    </dl>
                </div>

            </div>

            <%-- iframe 框架 --%>
            <iframe id="innerFrame" name="innerFrame" src="/reg-cus.page" width="100%" frameborder="0" height="1290px"></iframe>
            </div>
        <%-- 底部版权设置 --%>
        <div class="col-sm-12">
            <jsp:include page="/pub/index-footer.jsp"/>

            <a href="javascript:void(0);" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse display">
                <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
            </a>
        </div>

    </div>
    <!-- /.main-container -->


<script id="categoriesTemplate" type="x-tmpl-mustache">
    <li class="active">
        <a href="/sys/dept/dept.page" target="innerFrame">
            <i class="menu-icon fa fa-tachometer"></i>
            <span class="menu-text"> 首页 </span>
        </a>
        <b class="arrow"></b>
    </li>
    {{#categories}}
        <li class="">
            <a href="{{url}}" class="dropdown-toggle">
                <i class="{{beforeStyle}}"></i>
                <span class="menu-text"> {{name}} </span>
                <b class="{{afterStyle}}"></b>
            </a>

            <b class="arrow"></b>

            <ul class="submenu">
                {{#children}}
                <li class="">
                    <a href="{{url}}" target="innerFrame">
                        <i class="{{beforeStyle}}"></i>
                        {{name}}
                    </a>
                    <b class="arrow"></b>
                </li>
                {{/children}}
            </ul>
        </li>
    {{/categories}}
</script>


<!-- page specific plugin scripts -->
<!--[if lte IE 8]>
<script src="/assets/js/excanvas.min.js"></script>
<![endif]-->
<script src="/assets/js/jquery-ui.custom.min.js"></script>
<script src="/assets/js/jquery.ui.touch-punch.min.js"></script>
<script src="/assets/js/jquery.easypiechart.min.js"></script>

<script src="/assets/js/jquery.sparkline.index.min.js"></script>
<script src="/assets/js/jquery.flot.min.js"></script>
<script src="/assets/js/jquery.flot.pie.min.js"></script>
<script src="/assets/js/jquery.flot.resize.min.js"></script>

<!-- ace scripts -->
<script src="/assets/js/ace-elements.min.js"></script>
<script src="/assets/js/ace.min.js"></script>

<script type="text/javascript">

    $("#myCarousel").carousel({
        interval:5000
    });
</script>
</body>
</html>

