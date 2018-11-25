<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="p" uri="/WEB-INF/peyton.tld" %>
<!DOCTYPE html>
<html>
<head>
    <title>员工/管理员登陆</title>
    <jsp:include page="/common/common.jsp"/>
    <link type="text/css" rel="stylesheet" href="/css/signin.css">
</head>

<body class="no-skin" youdao="bind" style="background: white">
<input id="gritter-light" checked="" type="checkbox" class="ace ace-switch ace-switch-5"/>
<div class="sign-in-content">

    <jsp:include page="/pub/index-stick.jsp"/>

    <div class="sign-in-emp-login">

        <h2>登录</h2>
        <div class="sign-in-login-content">
            <form action="" id="employee-login-form" method="post" class="form-inline">

                <div class="clearfix">
                    <label for="username_1" class="fl-label">邮箱/登陆名</label>
                    <input type="text" class="text fr-input" id="username_1"
                           placeholder="邮箱/登录名" name="username" required autofocus value="${username}">
                </div>

                <div class="clearfix">
                    <label for="password_2" class="fl-label">密  码</label>
                    <input type="password" class="text fr-input" value="12345678" id="password_2"
                           placeholder="Password" name="password" required>
                </div>

                <div class="clearfix">
                    <p:select name="type" value="${type}" map="${userTypeMap}" label="类  型" labelClass="fl-label"
                              identify="select_type_3" cssClass="text fr-input"/>
                </div>

                <div class="clearfix">
                    <i>为了您的账号安全，请勿在公共电脑登录</i>
                </div>

                <div class="clearfix">
                    <button type="button" class="sign-in-btn">登&nbsp;&nbsp;录</button>
                </div>

                <div class="clearfix">
                    <div class="fl">
                        <input type="checkbox" class="ud-checked" name="remember" value="1" >
                        <label>十天内免登录</label>

                        <input type="checkbox" name="remember" value="2">
                    </div>
                </div>

                <div class="clearfix">
                    <a href="javascript:;" target="_blank">立即注册</a>
                    <span>|</span>
                    <a href="javascript:;" target="_blank">忘记密码</a>
                    <span>|</span>
                    <a href="javascript:;" target="_blank">常见问题</a>

                </div>
            </form>
        </div>

    </div>

    <div style="position: fixed; bottom: 0px; width: 100%;">
        <jsp:include page="/pub/index-footer.jsp"/>
    </div>
</div>
<script src="/js/defined/login.js"></script>
<script type="application/javascript">

    $(".sign-in-btn").click(function (e) {
        e.preventDefault();
        e.stopPropagation();
        var url = "/login-emp.json";
        login(
            url,
            "employee-login-form",
            function (data) {
                window.location.href = "/admin/index.page";
            },
            function (data) {
                showMessage("员工登录", data.msg , false);
            }
        );
    });


</script>
</body>
</html>
