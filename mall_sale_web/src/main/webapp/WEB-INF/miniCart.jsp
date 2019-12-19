<%--
  Created by IntelliJ IDEA.
  User: jarvis
  Date: 2019-12-15
  Time: 17:05
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

    <script type="text/javascript" src='js/jquery-1.7.2.min.js'></script>
    <script type="text/javascript">
        function show_cart() {

            $.post("miniCart.do",function (data) {
                $("#cart_list").html(data);
            });
            $("#cart_list").show();
        }

        function hide_cart() {
            $("#cart_list").hide();
        }
    </script>
</head>
<body>
<div class="card">
    <a href="goto_cart_list.do;" onmouseover="show_cart();" onmouseout="hide_cart();">购物车<div class="num">0</div></a>

    <!--购物车商品-->
    <div id="cart_list" class="cart_pro" style="display: none">
        <jsp:include page="miniCartList.jsp"></jsp:include>
    </div>

</div>
</body>
</html>

