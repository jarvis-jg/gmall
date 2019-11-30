<%--
  Created by IntelliJ IDEA.
  User: jarvis
  Date: 2019-11-27
  Time: 20:53
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
                $("#class_1_select option:not(:first)").remove();
                $(data).each(function (i, json) {
                    $("#class_1_select").append($("<option></option>").val(json.id).text(json.flmch1));
                })
            })

        });

        function get_class_2(class_1_id){
            $("#class_2_select option:not(:first)").remove();
            $.getJSON("js/json/class_2_" + class_1_id + ".js", function (data) {
                $(data).each(function (i, json) {
                    $("#class_2_select").append($("<option></option>").val(json.id).text(json.flmch2));
                })
            });

        }


        function goto_attr_add() {
            var class_2_id = $("#class_2_select").val();
            window.location.href = "goto_attr_add.do?flbh2=" + class_2_id;
        }

        function get_attr_list(flbh2) {

            $.post("get_attr_list.do",{flbh2: flbh2}, function (data) {
                $("#attrListInner").html(data);
            });
        }
    </script>
</head>
<body>
<hr>
    商品属性信息管理
    <hr>
    一级分类：<select id="class_1_select" onchange="get_class_2(this.value)"><option value="" selected="selected">---请选择---</option></select>&nbsp;&nbsp;
    二级分类：<select id="class_2_select" onchange="get_attr_list(this.value)"><option value="" selected="selected">---请选择---</option></select>&nbsp;&nbsp;
<%--    品牌：<select id="tm_class_select"><option value="" selected="selected">---请选择---</option></select>&nbsp;&nbsp;--%>
    <hr>
    查询<br>
    <%-- 这里不能加target="_blank",加了进入不了goto_spu_add() --%>
    <a href="javascript:goto_attr_add();">添加</a><br>
    编辑<br>
    删除<br>
    <hr>
    <div id="attrListInner"></div>
</body>
</html>

