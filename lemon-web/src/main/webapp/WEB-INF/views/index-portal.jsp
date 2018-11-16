<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>首页</title>
    <jsp:include page="/common/common.jsp"/>


</head>

<body id="main-body" style="background-color: white;">

<jsp:include page="/pub/index-stick.jsp"/>


<%--<div class="w center">--%>
    <%--<iframe id="indexFrame" name="indexFrame" src="/coca/commoditycategory.page" width="100%" frameborder="0" scrolling="yes"></iframe>--%>
<%--</div>--%>
<div id="project-content" class="w center">
    <jsp:include page="/pub/index-nav.jsp"/>
</div>

<jsp:include page="/pub/index-footer.jsp"/>

<script type="application/javascript">



</script>
<script src="/js/defined/register-window.js"></script>
</body>
</html>
