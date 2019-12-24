<%--
  Created by IntelliJ IDEA.
  User: jarvis
  Date: 2019-12-23
  Time: 19:38
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
    <link rel="shortcut icon" type="image/icon" href="images/jd.ico">
    <link rel="stylesheet" type="text/css" href="css/login.css">
    <script type="text/javascript" src='js/jquery-1.7.2.min.js'></script>
    <script type="text/javascript">
        function to_submit() {
            $("#login_form").submit();
        }
    </script>
</head>
<body>
    <div class="up">
        <img src="images/logo.jpg" height="45px;" class="hy_img"/>
        <div class="hy">
            欢迎登录
        </div>
    </div>
    <div class="middle">
        <div class="login">
            <div class="l1 ">
                <div class="l1_font_01">硅谷会员</div>
                <a class="l1_font_02" href="to_regist.do">用户注册</a>
            </div>
            <div class="blank_01"></div>
            <div class="ts">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${err}
            </div>
            <div class="blank_01"></div>
            <form action="login.do" id="login_form" method="post">
                <input name="redirect_url" value="goto_cart_list.do" type="hidden">
                <div class="input1">
                    用户名：<input type="text" class="input1_01" name="yh_mch"/>
                </div>
                <div class="blank_01"></div>
                <div class="blank_01"></div>
                <div class="input2">
                    密码：<input type="text" class="input1_01" name="yh_mm"/>
                </div>

                <div class="blank_01"></div>
                <div class="blank_01"></div>
                <div class="box_01">
                    <div class="box_01_both">
                        <div class="box_01_both_1"><input type="radio" name="datasource_type" value="1" />数据源1</div>
                        <div class="box_01_both_1"><input type="radio" name="datasource_type" value="2" />数据源2</div>
                    </div>
                </div>
            </form>
            <div class="blank_01"></div>
            <%-- 同时出现2个请求，请求发往了超链接的地址，吞掉了我们控制器返回的页面
                此时用javascript:;,不会发送请求！！！
            --%>
            <a href="javascript:;" class="aline">
                <div class="red_button" onclick="to_submit()">
                    登&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;录
                </div>
            </a>
            <div class="blank_01"></div>
            <div class="blank_01"></div>
            <div class="box_down">
                <div class="box_down_1">使用合作网站账号登录京东：</div>
                <div class="box_down_1">京东钱包&nbsp;&nbsp;|&nbsp;&nbsp;QQ
                    &nbsp;&nbsp;|&nbsp;&nbsp;微信
                </div>
            </div>
        </div>
    </div>

    <div class="down">
        <br />
        Copyright©2004-2015  xu.jb.com 版权所有
    </div>
</body>
</html>

