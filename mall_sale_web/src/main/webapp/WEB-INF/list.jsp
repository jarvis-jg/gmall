<%--
  Created by IntelliJ IDEA.
  User: jarvis
  Date: 2019-12-08
  Time: 10:42
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
</head>
<body>
    <jsp:include page="attrList.jsp"></jsp:include>
    <hr>
    <div id="sku_list_area">
        <jsp:include page="skuList.jsp"></jsp:include>
    </div>

</body>
</html>

