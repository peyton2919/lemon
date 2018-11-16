<%@ page import="java.util.Map" %>
<%@ page import="java.util.LinkedHashMap" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="p" uri="/WEB-INF/peyton.tld" %>
<!DOCTYPE html>
<html lang="zh-CN">
<%
    Map<String, String> map = new LinkedHashMap<>();
    map.put("0", "员工");
    map.put("1", "管理员");
%>

<head>
    <title>员工/管理员登陆</title>
    <jsp:include page="/common/common.jsp"/>
    <link type="text/css" rel="stylesheet" href="/css/signin.css">
</head>

<body class="no-skin" youdao="bind" style="background: white">

<div class="sign-in-content">

    <jsp:include page="/pub/index-stick.jsp"/>

    <div class="sign-in-emp-login">

        <h2>登录</h2>
        <div class="sign-in-login-content">
            <form action="/login-emp.page" method="post" class="form-inline">

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
                    <p:select name="type" value="${type}" map="<%=map%>" label="类  型" labelClass="fl-label"
                              identify="select_type_3" cssClass="text fr-input"/>
                </div>

                <div class="clearfix">
                    <div style="color: red;">${error}</div>
                </div>

                <div class="clearfix">
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
</body>
</html>
