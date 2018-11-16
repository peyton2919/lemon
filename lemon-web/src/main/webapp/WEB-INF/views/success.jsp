<%--
  Created by IntelliJ IDEA.
  User: peytonYu
  Date: 2018/11/13
  Time: 9:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${titleMessage}</title>
</head>
<body>

<%--out.print("<script type=\"text/javascript\">");--%>
            <%--out.print("window.onload=function(){");--%>
            <%--out.print("setTimeout(go, 3000);");--%>
            <%--out.print("};");--%>
            <%--out.print("function go(){");--%>
            <%--out.print("location.href=\"/sign-in-cus.page?type=1\";");--%>
            <%--out.print("}");--%>
            <%--out.print("</script>");--%>
<script type="text/javascript">
    window.onload = function (ev) {
        setTimeout(go,3000);
    }
    function go() {
        window.location.href = "${requestPath}";
    }
</script>
</body>
</html>
