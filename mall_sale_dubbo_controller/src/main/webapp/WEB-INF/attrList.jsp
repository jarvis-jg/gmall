<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jarvis
  Date: 2019-12-08
  Time: 10:44
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
        function save_param(shxm_id,shxzh_id,shxzh) {
            //1、将参数保存到参数区域
            $("#params").append($("<input>").attr({name: "123",type: "text"}).val("{\"shxm_id\":" + shxm_id + ",\"shxzh_id\":" + shxzh_id + "}"));
            $("#params").append(shxzh);

            //2、发送ajax请求
            get_list_by_attr();

        }
        
        function get_list_by_attr() {

            alert("异步提交");
            // var array = {};
            var jsonStr = "flbh2=${flbh2}";
            $("#params input").each(function (i, data) {
                // array[i] = data.value;

                var json = $.parseJSON(data.value);
                // array["list_sku_av[" + i + "].shxm_id"] = json.shxm_id;
                // array["list_sku_av[" + i + "].shxzh_id"] = json.shxzh_id;
                jsonStr = jsonStr + "&list_sku_av[" + i + "].shxm_id=" + json.shxm_id + "&list_sku_av[" + i + "].shxzh_id=" + json.shxzh_id;
            });

            $.post("get_list_by_attr.do",jsonStr,function (data) {
                $("#sku_list_area").html(data);
            })
            
        }
    </script>

</head>
<body>
    属性列表
    <hr>
    <div id="params">

    </div>


    <c:forEach items="${attr_list}" var="attr">
        <div>
            ${attr.shxm_mch}:
            <c:forEach items="${attr.value_list}" var="val">
                <a href="javascript:save_param('${attr.id}','${val.id}','${val.shxzh}');">${val.shxzh }${val.shxzh_mch}</a>
            </c:forEach>
            <br>
        </div>
    </c:forEach>
</body>
</html>

