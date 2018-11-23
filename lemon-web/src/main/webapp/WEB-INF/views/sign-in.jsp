<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="/common/common.jsp"/>
    <link type="text/css" rel="stylesheet" href="/css/signin.css">
    <title>登录</title>
</head>

<body class="no-skin" youdao="bind" style="background: white">

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
                <form action="/login.page" method="post"  class="form-inline">
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

                    <div class="clearfix">
                        <div style="color: red;">${error}</div>
                    </div>

                    <div class="input-group">
                        <i>为了您的账号安全，请勿在公共电脑登录</i>
                    </div>

                    <div class="clearfix">
                        <button type="submit" class="sign-in-btn">登&nbsp;&nbsp;录</button>
                    </div>

                    <div class="clearfix">
                        <div class="fl">
                            <input type="checkbox" class="ud-checked" >
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
<script type="text/javascript">

    $(function () {

        
    });
    
</script>

</body>
</html>
