<%--
  Created by IntelliJ IDEA.
  User: jarvis
  Date: 2019-11-27
  Time: 21:02
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
        function add_value(index) {
            var td_index = $("#tbl_" + index + " tr").length - 1;

            $("#tbl_" + index).append(generate_tr(index, td_index));

        }

        function generate_tr(index,td_index) {
            var td_1 = $("<td></td>").append("属性值：").append($("<input/>").attr({
                name: "attr_list[" + index + "].value_list[" + td_index + "].shxzh",
                type: "text"
            }));

            var td_2 = $("<td></td>").append("单元：").append($("<input/>").attr({
                name: "attr_list[" + index + "].value_list[" + td_index + "].shxzh_mch",
                type: "text"
            }));

            var btn = $("<button></button>").text("删除").attr({id: "del_" + index + "_" + td_index, type: "button"});
            $(document).on("click", "#del_" + index + "_" + td_index, {index: index}, function (event) {
                delete_attr_value(this,event.data.index);
            });
            var td_3 = $("<td></td>").append(btn);

            var tr = $("<tr></tr>").append(td_1).append(td_2).append(td_3);
            return tr;
        }

        function delete_attr_value(currentObj,index) {
            $(currentObj).parents("tr").remove();

            // 重新排序
            sort(index);
        }

        function sort(index) {
            $("#tbl_" + index + " tr:gt(0)").each(function (i) {
                $(this).find("td").each(function (j) {
                    if (j == 0){
                        $(this).children("input").attr("name", "attr_list[" + index + "].value_list[" + i + "].shxzh");
                    }else if (j == 1){
                        $(this).children("input").attr("name", "attr_list[" + index + "].value_list[" + i + "].shxzh_mch");
                    }else{
                        $(this).children("button").attr("id", "del_" + index + "_" + i);
                    }
                });
            });
        }
        // 如果此时的id也叫add_attr就会出错
        function add_attr() {
            var size = $("table").length;

            var table = $('<table border="1px black solid" width="800px"></table>').attr("id", "tbl_" + size);

            table.append(generate_first_tr(size));
            for (var i = 0; i < 2; i++){
                table.append(generate_tr(size, i));
            }

            $("#add_attr_btn").before(table);
        }

        function generate_first_tr(index) {
            var td_1 = $("<td></td>").append("属性名：").append($("<input/>").attr({
                name: "attr_list[" + index + "].shxm_mch",
                type: "text"
            }));

            var td_2 = $("<td></td>");

            var btn = $("<button></button>").text("添加属性值").attr({id: "btn_" + index, type: "button"});
            $(document).on("click", "#btn_" + index,{index: index}, function (event) {
                add_value(event.data.index);
            });
            var td_3 = $("<td></td>").append(btn);
            var first_tr = $("<tr></tr>").append(td_1).append(td_2).append(td_3);
            return first_tr;
        }

    </script>
</head>
<body>
    Attr信息添加
    <hr>
    <form action="attr_add.do">
        <input name="flbh2" type="text" value="${flbh2}">
        <table id="tbl_0" border="1px black solid" width="800px">
            <tr><td>属性名：<input name="attr_list[0].shxm_mch" type="text"/></td><td></td><td><button id="btn_0" onclick="add_value(0);" type="button">添加属性值</button></td></tr>
            <tr><td>属性值：<input name="attr_list[0].value_list[0].shxzh" type="text"/></td><td>单位：<input name="attr_list[0].value_list[0].shxzh_mch" type="text"/></td><td><button id="del_0_0" type="button" onclick="delete_attr_value(this,0);">删除</button></td></tr>
            <tr><td>属性值：<input name="attr_list[0].value_list[1].shxzh" type="text"/></td><td>单位：<input name="attr_list[0].value_list[1].shxzh_mch" type="text"/></td><td><button id="del_0_1" type="button" onclick="delete_attr_value(this,0);">删除</button></td></tr>
        </table>

        <table id="tbl_1" border="1px black solid" width="800px">
            <tr><td>属性名：<input name="attr_list[1].shxm_mch" type="text"/></td><td></td><td><button id="btn_1" onclick="add_value(1);" type="button">添加属性值</button></td></tr>
            <tr><td>属性值：<input name="attr_list[1].value_list[0].shxzh" type="text"/></td><td>单位：<input name="attr_list[1].value_list[0].shxzh_mch" type="text"/></td><td><button id="del_1_0" type="button" onclick="delete_attr_value(this,1);">删除</button></td></tr>
            <tr><td>属性值：<input name="attr_list[1].value_list[1].shxzh" type="text"/></td><td>单位：<input name="attr_list[1].value_list[1].shxzh_mch" type="text"/></td><td><button id="del_1_1" type="button" onclick="delete_attr_value(this,1);">删除</button></td></tr>
        </table>

        <button id="add_attr_btn" type="button" onclick="add_attr();">添加属性</button>

        <input type="submit" value="提交"/>
    </form>
</body>
</html>

