<%--
  Created by IntelliJ IDEA.
  User: jarvis
  Date: 2019-12-26
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basepath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<% String ran = System.currentTimeMillis()+""; %>
<html>
<head>
    <base href="<%=basepath %>"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>支付</title>
    <script type="text/javascript" src='js/jquery-1.7.2.min.js'></script>
    <script type="text/javascript">
        $(function () {
            $("#a").submit();
        })
    </script>
</head>
<body>
    <form id="a" action="http://localhost:28080/mall_pay_service_war_exploded/payment"  method="POST" target="_blank">
        <input type="hidden" name="WIDout_trade_no" id="out_trade_no" value="<%=ran%>">
        <input type="hidden" name="WIDtotal_amount" value="${sum}">
        <input type="hidden" name="busi_return_url" value="http://localhost:8090/mall_sale_web_war_exploded/real_pay_success.do">
        <input type="hidden" name="busi_notify_url" value="http://localhost:8090/mall_sale_web_war_exploded/pay_success.do">
        <input type="hidden" name="WIDsubject" value="尚硅谷支付测试专用">
        <input type="hidden" name="WIDbody" value="即时到账测试">
    </form>
</body>
</html>

