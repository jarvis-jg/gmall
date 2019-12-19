<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jarvis
  Date: 2019-12-15
  Time: 17:15
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
    <h6>最新加入的商品</h6>
    <c:forEach items="${list_cart}" var="cart">
        <div class="one">
            <img src="upload/${cart.shp_tp}" width="80px"/>
            <span class="one_name">
                ${cart.sku_mch}
            </span>
            <span class="one_prece">
                <b>￥${cart.sku_jg}</b><br />
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;删除
            </span>
        </div>
    </c:forEach>



    <div class="gobottom">
        共<span>2</span>件商品&nbsp;&nbsp;&nbsp;&nbsp;
        共计￥<span>${sum}</span>
        <button class="goprice">去购物车</button>
    </div>
</body>
</html>

