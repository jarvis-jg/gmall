<%--
  Created by IntelliJ IDEA.
  User: jarvis
  Date: 2019-12-04
  Time: 23:20
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
    <meta charset="UTF-8">
    <title>首页</title>
    <link rel="stylesheet" type="text/css" href="css/css.css">

    <script type="text/javascript" src='js/jquery-1.7.2.min.js'></script>
    <script type="text/javascript">
        $(function(){
            $('.nav_mini ul li').hover(function(){
                $(this).find('.two_nav').show(100);
            },function(){
                $(this).find('.two_nav').hide(100);
            })
        })
    </script>
</head>
<body>
    <jsp:include page="header.jsp"></jsp:include>
    <div class="top_img">
        <img src="images/top_img.jpg" alt="">
    </div>

    <jsp:include page="searchArea.jsp"></jsp:include>

    <jsp:include page="classList.jsp"></jsp:include>

    <div class="banner">
        <div class="ban">
            <img src="images/banner.jpg" width="980" height="380" alt="">
        </div>
    </div>

</body>
<body>

</body>
</html>

