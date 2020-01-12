<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jarvis
  Date: 2019-12-08
  Time: 10:44
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

    <c:forEach items="${sku_list}" var="sku">
        <div style="float: left; margin-left: 10px; border: 1px red solid; width: 300px; height: 300px;">
            <img src="upload/${sku.product.shp_tp}" width="300px" height="250px">
            ${sku.jg}<br>
            <a href="goto_sku_detail.do?sku_id=${sku.id}&spu_id=${sku.product.id}" target="_blank">${sku.sku_mch}</a>
        </div>
    </c:forEach>
</body>
</html>

