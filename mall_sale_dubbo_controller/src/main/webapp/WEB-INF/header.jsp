<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jarvis
  Date: 2019-12-04
  Time: 23:24
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
    <script type="text/javascript" src='js/jquery-1.7.2.min.js'></script>
    <script type="text/javascript">
        $(function () {
            var yh_mch = get_cookie("yh_mch");
            $("#show_name").text(yh_mch);
        });

        function get_cookie(key) {
            var cookies = document.cookie;
            //这里为什么没有把yh_mch前面的cookie去掉
            cookies = cookies.replace(/\s/, "");
            var array = cookies.split(";");

            for (var i = 0; i < array.length; i++){
                var cookie = array[i].split("=");
                if (cookie[0].trim()==key) {
                    return cookie[1];
                }
            }
        }
    </script>
</head>
<body>
    <div class="top">
        <div class="top_text">
            <c:if test="${empty user}">
                <a href="to_login.do">用户登录:<span style="color: red" id="show_name"></span></a>
                <a href="">用户注册</a>
            </c:if>

            <c:if test="${not empty user}">
                <a href="">订单</a>
                <a href="">用户:${user.yh_nch}</a>
                <a href="goto_logout.do">退出登录</a>
            </c:if>

        </div>
    </div>
</body>
</html>

