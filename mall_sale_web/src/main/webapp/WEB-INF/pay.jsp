<%--
  Created by IntelliJ IDEA.
  User: jarvis
  Date: 2019-12-25
  Time: 19:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basepath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basepath %>"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>伪支付</title>
</head>
<body>
    收银台
    <hr>
    <form action="pay_success.do" method="post">
        <input type="submit" value="支付"/>
    </form>
</body>
</html>

