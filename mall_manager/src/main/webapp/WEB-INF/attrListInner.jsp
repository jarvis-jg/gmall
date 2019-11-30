<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jarvis
  Date: 2019-11-29
  Time: 20:28
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
    <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript">
        function show_attr_value() {

        }
    </script>
</head>
<body>
    attr内嵌页面
    <hr>

    <div>
        <c:forEach items="${attr_list}" var="attr">
            ${attr.shxm_mch}:
            <c:forEach items="${attr.value_list}" var="value">
                ${value.shxzh}${value.shxzh_mch}
            </c:forEach>
            <br>
        </c:forEach>

    </div>
</body>
</html>

