<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jarvis
  Date: 2019-11-30
  Time: 20:17
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
        $(function get_tm() {
            //除了---请选择---，全部删除
            //empty()是清空该元素下的所有子元素
            //remove()是删除被选中的元素及其子元素
            var flbh1 = "${flbh1}";
            $("#sku_tm_class_select option:not(:first)").remove();
            $.getJSON("js/json/tm_class_1_" + flbh1 + ".js", function (data) {
                $(data).each(function (i, json) {
                    $("#sku_tm_class_select").append($("<option></option>").val(json.id).text(json.ppmch));
                })
            });
        });

        function get_shp_list(pp_id) {
            $("#shp_select option:not(:first)").remove();
            var flbh2 = "${flbh2}";
            $.post("get_shp_list.do",{pp_id: pp_id,flbh2: flbh2},function (data) {
                // 这里必须2个参数，只留json会取不到值
                $(data).each(function (index, json) {
                    $("#shp_select").append($("<option></option>").val(json.id).html(json.shp_mch));
                })
            });
        }

        function show_attr_value(shxm_id,checked) {
            if (checked){
                $("#val_" + shxm_id).show();
            } else{
                $("#val_" + shxm_id).hide();
            }
        }
    </script>
</head>
<body>
    sku添加页面
    <hr>
        <form action="sku_add.do" method="post">
            <input name="flbh1" value="${flbh1}" type="hidden"/>
            <input name="flbh2" value="${flbh2}" type="hidden"/>
        品牌：<select name="pp_id" id="sku_tm_class_select" onchange="get_shp_list(this.value)"><option value="" selected="selected">---请选择---</option></select>
        商品：<select name="id" id="shp_select"><option value="" selected="selected">---请选择---</option></select>
        <hr>
        <c:forEach var="attr" items="${attr_list}" varStatus="status">
            <input name="list_sku_av[${status.index}].shxm_id" onclick="show_attr_value(this.value,this.checked)" type="checkbox" value="${attr.id}"/>${attr.shxm_mch}
        </c:forEach>
        <br>

        <c:forEach var="attr" items="${attr_list}" varStatus="status">
            <div id="val_${attr.id}" style="display: none">
                <c:forEach items="${attr.value_list}" var="value">
                    <input name="list_sku_av[${status.index}].shxzh_id" type="radio" value="${value.id}"/>${value.shxzh}${value.shxzh_mch}
                </c:forEach>
            </div>
        </c:forEach>

        商品库存名称：<input name="sku_mch" type="text"/><br>
        商品库存价格：<input name="jg" type="text"/><br>
        商品库存数量：<input name="kc" type="text"/><br>
        商品库存地址：<input name="kcdz" type="text"/><br>

        <input type="submit" value="提交"/>
    </form>
</body>
</html>

