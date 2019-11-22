<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<html>
<head>
    <base href="<%=basepath %>" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" isELIgnored="false" />
    <title>硅谷商城</title>
</head>
<body>
    后台管理页面
    <br>
    <a href="goto_spu.do" target="_blank">商品信息管理</a><br>
    商品属性管理<br>
    商品库存单元管理<br>
    商品缓存管理<br>
</body>
</html>
