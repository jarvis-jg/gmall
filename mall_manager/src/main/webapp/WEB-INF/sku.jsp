<%--
  Created by IntelliJ IDEA.
  User: jarvis
  Date: 2019-11-30
  Time: 20:12
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
    <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript">
        $(function(){
            //加载js数据
            $.getJSON("js/json/class_1.js",function (data) {
                $("#sku_class_1_select option:not(:first)").remove();
                $(data).each(function (i, json) {
                    $("#sku_class_1_select").append($("<option></option>").val(json.id).text(json.flmch1));
                })
            })

        });

        function get_class_2(class_1_id){
            $("#sku_class_2_select option:not(:first)").remove();
            $.getJSON("js/json/class_2_" + class_1_id + ".js", function (data) {
                $(data).each(function (i, json) {
                    $("#sku_class_2_select").append($("<option></option>").val(json.id).text(json.flmch2));
                })
            });
        }


        function goto_sku_add() {
            var class_1_id = $("#sku_class_1_select").val();
            var class_2_id = $("#sku_class_2_select").val();
            window.location.href = "goto_sku_add.do?flbh1=" + class_1_id + "&flbh2=" + class_2_id;
        }
    </script>
</head>
<body>
    sku商品信息管理
    <hr>
    一级分类：<select id="sku_class_1_select" onchange="get_class_2(this.value)"><option value="" selected="selected">---请选择---</option></select>&nbsp;&nbsp;
    二级分类：<select id="sku_class_2_select"><option value="" selected="selected">---请选择---</option></select>&nbsp;&nbsp;
    <hr>
    查询<br>
    <%-- 这里不能加target="_blank",加了进入不了goto_spu_add() --%>
    <a href="javascript:goto_sku_add();">添加</a><br>
    编辑<br>
    删除<br>
</body>
</html>

