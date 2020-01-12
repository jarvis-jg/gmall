<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jarvis
  Date: 2019-12-12
  Time: 20:46
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
        function cart_submit() {
            $("#cart_form").submit();
        }
    </script>
</head>
<body>

    <jsp:include page="header.jsp"></jsp:include>
    <!--<div class="top_img">
        <img src="./images/top_img.jpg" alt="">
    </div>-->

    <div class="Dbox">
        <div class="box">
            <div class="left">
                <div class="timg"><img src="upload/${detail.spu.shp_tp}" alt=""></div>
                <div class="timg2">
<%--                    <div class="lf"><img src="upload/${detail.spu.shp_tp}" alt=""></div>--%>
<%--                    <div class="center">--%>
<%--                        <c:forEach items="${detail.list_image}" var="img">--%>
<%--                            <span><img src="upload/${img.url}" alt=""></span>--%>
<%--                        </c:forEach>--%>
<%--                    </div>--%>
<%--                    <div class="rg">--%>
<%--                        <c:forEach items="${detail.list_image}" var="img">--%>
<%--                            <img src="upload/${img.url}" alt="">--%>
<%--                        </c:forEach>--%>
<%--                        <img src="images/rg.jpg" alt="">--%>
<%--                    </div>--%>
                </div>
                <div class="goods"><img src="images/img_6.jpg" alt=""></div>
            </div>
            <div class="cent">
                <div class="title">${detail.sku_mch}</div>
                <div class="bg">
                    <p>市场价：<strong>￥${detail.jg}</strong></p>
                    <p>促销价：<strong>￥${detail.jg}</strong></p>
                </div>
                <div class="clear">
                    <div class="min_t">选择版本：</div>
                    <c:forEach items="${sku_list}" var="sku">
                        <div class="min_mx"><a href="goto_sku_detail.do?sku_id=${sku.id}&spu_id=${sku.shp_id}">${sku.sku_mch}</a></div>
                    </c:forEach>
<%--                    <div class="min_mx" onclick=func($(this),'0')>55英寸活动中1</div>--%>
<%--                    <div class="min_mx" onclick=func($(this),'0')>55英寸活动中2</div>--%>
<%--                    <div class="min_mx" onclick=func($(this),'0')>55英寸活动中3</div>--%>
<%--                    <div class="min_mx" onclick=func($(this),'0')>55英寸活动中4</div>--%>
<%--                    <div class="min_mx" onclick=func($(this),'0')>55英寸活动中5</div>--%>
<%--                    <div class="min_mx" onclick=func($(this),'0')>55英寸活动中6</div>--%>
                </div>
                <div class="clear">
                    <div class="min_t" onclick=func($(this),'1')>服务：</div>
                    <div class="min_mx" onclick=func($(this),'1')>服务1号1</div>
                    <div class="min_mx" onclick=func($(this),'1')>服务二号1112</div>
                    <div class="min_mx" onclick=func($(this),'1')>55英服务二号1111寸活动中3</div>
                    <div class="min_mx" onclick=func($(this),'1')>4</div>
                    <div class="min_mx" onclick=func($(this),'1')>呃呃呃5</div>
                    <div class="min_mx" onclick=func($(this),'1')>55英寸活动中6</div>
                </div>
                <div class="clear" style="margin-top:20px;">
                    <div class="min_t" style="line-height:36px">数量：</div>
                    <div class="num_box">
                        <input type="text" name="num" value="${detail.kc}" style="width:40px;height:32px;text-align:center;float:left">
                        <div class="rg">
                            <img src="images/jia.jpg" id='jia' alt="">
                            <img src="images/jian.jpg" id='jian' alt="">
                        </div>
                    </div>
                </div>
                <div class="clear" style="margin-top:20px;">
                    <form id="cart_form" action="add_cart.do" method="post">
                        <input type="hidden" name="sku_mch" value="${detail.sku_mch}">
                        <input type="hidden" name="sku_jg" value="${detail.jg}">
                        <input type="hidden" name="tjshl" value="1">
                        <input type="hidden" name="hj" value="${detail.jg}">
                        <input type="hidden" name="shp_id" value="${detail.shp_id}">
                        <input type="hidden" name="sku_id" value="${detail.id}">
                        <input type="hidden" name="shp_tp" value="${detail.spu.shp_tp}">
                        <input type="hidden" name="shfxz" value="1">
                        <input type="hidden" name="kcdz" value="${detail.kcdz}">
                        <c:if test="${not empty user}">
                            <input type="hidden" name="yh_id" value="${user.id}">
                        </c:if>

                        添加购物车：<img src="images/logo.jpg" onclick="cart_submit()" alt="" style="cursor:pointer;">
                    </form>
                </div>
            </div>
        </div>
    </div>
    <div class="Dbox1">
        <div class="boxbottom">
            <div class="top">
                <span>商品详情</span>
                <span>评价</span>
            </div>
            <div class="btm">
                ${detail.sku_mch}<br>
                <c:forEach items="${detail.list_image}" var="img">
                    <span><img src="upload/${img.url}" alt=""></span>
                </c:forEach>
                <br>
                <c:forEach items="${detail.object_av_list}" var="av">
                    ${av.shxm_mch}:${av.shxzh_mch}
                </c:forEach>
            </div>
        </div>
    </div>
    <div class="footer">
        <div class="top"></div>
        <div class="bottom"><img src="images/foot.jpg" alt=""></div>
    </div>
</body>
</html>

