<%--
  Created by IntelliJ IDEA.
  User: jarvis
  Date: 2019-12-09
  Time: 22:01
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
    <title>Insert title here</title>
    <script type="text/javascript" src='js/jquery-1.7.2.min.js'></script>
    <script type="text/javascript">
        function b() {
            var queryString = $("#loginForm").serialize();
            $.post("login.do", queryString, function (data) {
                alert(data);
            });
        }
    </script>
</head>
<body>
    异步登录表单测试
    <hr>
    <form id="loginForm">
        username:<input name="yh_mch" type="text"><br>
        password:<input name="yh_mm" type="text"><br>
        login:<input type="button" onclick="b();" value="test"><br>
    </form>
</body>
</html>

