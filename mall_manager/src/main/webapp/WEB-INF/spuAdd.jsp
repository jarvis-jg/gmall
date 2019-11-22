<%--
  Created by IntelliJ IDEA.
  User: jarvis
  Date: 2019-11-22
  Time: 20:20
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
    <title>硅谷商城</title>
</head>
<body>
    spu信息添加

    <form action="spu_add.do" method="post">
        商品名称：<input name="shp_mch" type="text" /><br>
        商品描述：<textarea name="shp_msh" rows="10" cols="50"></textarea><br>
        商品图片：<br>
        <input name="shp_tp" type="file"><br>
        <input name="shp_tp" type="file"><br>
        <input name="shp_tp" type="file"><br>

        <input name="flbh1" type="hidden" value="${spu.flbh1}"/>
        <input name="flbh2" type="hidden" value="${spu.flbh2}"/>
        <input name="pp_id" type="hidden" value="${spu.pp_id}"/>
        <input type="submit" value="提交">
    </form>
</body>
</html>

