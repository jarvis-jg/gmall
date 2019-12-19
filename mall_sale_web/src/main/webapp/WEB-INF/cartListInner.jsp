<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jarvis
  Date: 2019-12-15
  Time: 20:40
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
<div class="Cbox">
    <table class="table table-striped table-bordered table-hover">
        <thead>
        <tr>
            <th>商品图片</th>
            <th>商品名称</th>
            <th>商品属性</th>
            <th>商品价格</th>
            <th>商品数量</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list_cart}" var="cart">
            <tr>
                <td>
                    <input type="checkbox" onclick="change_shfxz(this.checked,'${cart.sku_id}')" name="shfxz" value="${cart.shfxz}" ${cart.shfxz=="1"?"checked":""}>${cart.shfxz}
                    <img src="upload/${cart.shp_tp}" alt="" width="80px;">
                </td>
                <td>商品名称</td>
                <td>
                    颜色：<span style='color:#ccc'>白色</span><br>
                    尺码：<span style='color:#ccc'>L</span>
                </td>
                <td>${cart.sku_jg}</td>
                <td><input type="text" name="min" value="${cart.tjshl}" style="width:50px;text-align:center"></td>
                <td>删除</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<div class="Cprice">
    <div class="price">总价：${sum}</div>
    <div class="jiesuan">结算</div>
</div>
</body>
</html>

