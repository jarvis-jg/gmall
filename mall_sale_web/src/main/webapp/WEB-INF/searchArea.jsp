<%--
  Created by IntelliJ IDEA.
  User: jarvis
  Date: 2019-12-04
  Time: 23:23
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
    <div class="search">
        <div class="logo"><img src="images/logo.jpg" alt=""></div>
        <div class="search_on">
            <div class="se">
                <form action="keywords.do" method="get">
                    <input type="text" name="keywords" class="lf">
                    <input type="submit" class="clik" value="搜索">
                </form>
            </div>
            <div class="se">
                <a href="">取暖神奇</a>
                <a href="">1元秒杀</a>
                <a href="">吹风机</a>
                <a href="">玉兰油</a>
            </div>
        </div>
        <jsp:include page="miniCart.jsp"></jsp:include>


    </div>
</body>
</html>

