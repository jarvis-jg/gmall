<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jarvis
  Date: 2019-12-23
  Time: 19:32
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
    <title>结算</title>
    <link rel="stylesheet" type="text/css" href="css/css.css">
    <script type="text/javascript" src='js/jquery-1.7.2.min.js'></script>
    <script type="text/javascript">
        function save_order() {
            $("#save_form").submit();
        }

        function change_address(shjr,dz_mch,lxfsh) {
            $(".msg_sub_adds").html("寄送至： " + dz_mch + "    " + shjr + "（收）" + lxfsh);
        }
    </script>
</head>
<body>
    结算页面
    <hr>
    <jsp:include page="header.jsp"></jsp:include>
    <jsp:include page="searchArea.jsp"></jsp:include>


    <div class="message">
        <div class="msg_title">
            收货人信息
        </div>
        <form id="save_form" action="save_order.do" method="post">
            <c:forEach items="${list_address}" var="address">
                <div class="msg_addr">
                    <span class="msg_left">
                        姓名 ${address.shjr}
                    </span>
                    <span class="msg_right">
                        ${address.dz_mch}
                        <input type="radio" name="address_id" value="${address.id}" onclick="change_address('${address.shjr}','${address.dz_mch}','${address.lxfsh}')">
                    </span>
                </div>
            </c:forEach>
        </form>
        <span class="addrs">查看更多地址信息</span>
        <div class="msg_line"></div>

        <div class="msg_title">
            送货清单
        </div>

            <c:forEach items="${order.list_flow}" var="flow">
        <div class="msg_list">
                <c:forEach items="${flow.list_info}" var="info" varStatus="index">

                        <div class="msg_list_left">
                            配送方式
                            <div class="left_title">
                                ${flow.psfsh}
                            </div>
                        </div>
                        <div class="msg_list_right">
                            <div class="msg_img">
                                <img src="upload/${info.shp_tp}" width="80px" height="80px"/>
                            </div>
                            <div class="msg_name">
                                ${info.sku_mch}
                            </div>
                            <div class="msg_price">
                                ${info.sku_jg}
                            </div>
                            <div class="msg_mon">
                                *${info.sku_shl}
                            </div>
                            <div class="msg_state">
                                有货
                            </div>
                        </div>

                    </c:forEach>
        </div>

            </c:forEach>




        <div class="msg_line"></div>

        <div class="msg_sub">
            <div class="msg_sub_tit">
                应付金额：
                <b>￥${hj}</b>
            </div>
            <div class="msg_sub_adds">
                寄送至 ： 北京市 昌平区 北七家镇 尚硅谷IT教育    &nbsp;某某某（收）  185****1222
            </div>
            <button class="msg_btn" onclick="save_order()">提交订单</button>


        </div>

    </div>
</body>
</html>

