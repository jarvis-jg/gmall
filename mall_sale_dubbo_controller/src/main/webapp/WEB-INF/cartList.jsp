<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jarvis
  Date: 2019-12-15
  Time: 20:22
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
    <link rel="stylesheet" type="text/css" href="css/css.css">
    <link rel="stylesheet" href="css/style.css">
    <script type="text/javascript" src='js/jquery-1.7.2.min.js'></script>
    <script type="text/javascript">
        function change_shfxz(checked,sku_id) {
            //改变选中状态，刷新cart_list。
            var shfxz = "0";
            if (checked) {
                shfxz = "1";
            }
            $.post("change_shfxz.do",{shfxz:shfxz,sku_id:sku_id},function (data) {
                $("#cartListInner").html(data);
            })
        }
    </script>
</head>
<style type="text/css">
    td{vertical-align: middle !important;}
    .form-group{padding: 5px 0;}
</style>
<body>
<div class="search">
    <jsp:include page="header.jsp"></jsp:include>

    <div class="logo"><img src="images/logo.jpg" alt=""></div>
    <div class="search_on">
        <div class="se">
            <input type="text" name="search" class="lf">
            <input type="submit" class="clik" value="搜索" style="height: 32px;">
        </div>
        <div class="se">
            <a href="">取暖神奇</a>
            <a href="">1元秒杀</a>
            <a href="">吹风机</a>
            <a href="">玉兰油</a>
        </div>
    </div>
</div>
<div id="cartListInner">
    <jsp:include page="cartListInner.jsp"></jsp:include>
</div>

<div class="footer">
    <div class="top"></div>
    <div class="bottom"><img src="images/foot.jpg" alt=""></div>
</div>
</body>
</html>

