<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link href="/css/mall.css" rel="stylesheet">

<header id="project-nav">
    <div class="top center">
        <div class="left fl">
            <ul>
                <li><a href="javascript:void(0);" id="index-aclick" target="_blank">首页</a></li>
                <li>|</li>
                <li><a href="javascript:void(0);" id="sup-reg-aclick">供应商注册</a></li>
                <li>|</li>
                <li><a href="javascript:void(0);" id="sup-login-aclick">供应商登录</a></li>
                <li>|</li>
                <li><a href="javascript:void(0);" id="cus-reg-aclick">会员注册</a></li>
                <li>|</li>
                <li><a href="javascript:void(0);" id="cus-login-aclick">会员登录</a></li>
                <li>|</li>
                <li><a href="javascript:void(0);" id="emp-login-aclick">员工/管理员登录</a></li>
                <li>|</li>
                <li><a href="javascript:void(0);" id="test-cus-manager">测试会员后台</a></li>
                <li>|</li>
                <li><a href="javascript:void(0);">问题反馈</a></li>
                <li>|</li>
                <li><a href="javascript:void(0);">Select Region</a></li>
                <div class="clear"></div>
            </ul>
        </div>
    </div>
</header>

<script type="application/javascript">

    $("#index-aclick").click(function (e) {
        window.location.replace("/");
    });
    $("#sup-reg-aclick").click(function (e) {
        window.location.replace("/reg-sup.page");
    });
    $("#sup-login-aclick").click(function (e) {
        window.location.replace("/sign-in-sup.page?type=2");
    });
    $("#cus-reg-aclick").click(function (e) {
        window.location.replace("/reg-cus.page");
    });
    $("#cus-login-aclick").click(function (e) {
        window.location.replace("/sign-in-cus.page?type=1");
    });

    $("#emp-login-aclick").click(function (e) {
        window.location.replace("/sign-in-emp.page");
    });

    //测试数据

    $("#test-cus-manager").click(function (e) {
        window.location.replace("/test-cus-manager.page");
    });

</script>



