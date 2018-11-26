<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="/common/common.jsp"/>
    <link type="text/css" rel="stylesheet" href="/css/signin.css">
    <title>登录</title>
</head>

<body class="no-skin" youdao="bind" style="background: white">

<input id="gritter-light" checked="" type="checkbox" class="ace ace-switch ace-switch-5"/>

<div class="sign-in-content">
    <div class="sign-in-bg">
        <jsp:include page="/pub/index-stick.jsp"/>
        <div class="sign-in-logo">
            <a href="/">
                <img src="img/sys/logo_01.png" alt="">
            </a>
        </div>

        <div class="sign-in-login">
            <h2>登录</h2>
            <div class="sign-in-login-content">
                <form  id="customer-login-form" method="post" class="form-inline">
                    <input type="hidden" name="type" id="hidden-type" value="${type}">
                    <div class="input-group">
                        <div class="input-group-addon">
                            <i class="fa fa-user"></i>
                        </div>
                        <input type="text" name="username" data-type="text" value="${username}" placeholder="请输入账号">
                    </div>
                    <div class="input-group">
                        <div class="input-group-addon">
                            <i class="fa fa-lock"></i>
                        </div>
                        <input type="password" name="password" data-type="password" placeholder="请输入密码">
                    </div>

                    <div class="input-group">
                        <i>为了您的账号安全，请勿在公共电脑登录</i>
                    </div>

                    <div class="clearfix">
                        <button type="button" class="sign-in-btn">登&nbsp;&nbsp;录</button>
                    </div>

                    <div class="clearfix">
                        <div class="fl">
                            <input type="checkbox" class="ud-checked" name="remember" value="1">
                            <label>十天内免登录</label>
                        </div>
                    </div>

                    <div class="clearfix">
                        <a href="go-reg.html" target="_blank">立即注册</a>
                        <span>|</span>
                        <a href="#" target="_blank">忘记密码</a>
                        <span>|</span>
                        <a href="customer.html" target="_blank">常见问题</a>

                    </div>
                </form>
            </div>
        </div>

        <div style="position: fixed; bottom: 0px; width: 100%;">
            <jsp:include page="/pub/index-footer.jsp"/>
        </div>

    </div>

</div>
<script src="/js/defined/login.js"></script>

<script type="text/javascript">

    $(function () {
        //设置标题
        $("#message-title").html((type == 1 ? '客户' : '供应商') + '登录');
        var type = $("#hidden-type").val();
        var hintNameMessage = (type == 1 ? '客户登录' : '供应商登录');
        var url = "/login.json";
        var skipUrl = (type == 1 ? '/manage/cus/cus.page': '/manage/sup/sup.page');

        $(".sign-in-btn").click(function (e) {
            e.preventDefault();
            e.stopPropagation();
            $(".sign-in-btn").attr("disabled", "disabled");
            login(
                url,
                "customer-login-form",
                function (data) {
                    window.location.href = skipUrl;
                },
                function (data) {

                    showMessage(hintNameMessage, data.msg , false);
                },
                function (data) {
                    $(".sign-in-btn").removeAttr("disabled");
                }
            );
        });

    });
</script>

</body>
</html>
