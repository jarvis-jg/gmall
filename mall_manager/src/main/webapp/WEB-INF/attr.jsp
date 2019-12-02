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

</head>
<body>

<%--<hr>--%>
<%--    商品属性信息管理--%>
<%--    <hr>--%>
<%--    一级分类：<select data-options="width:'150'" id="attr_class_1_select" class="easyui-combobox" onchange="attr_get_class_2(this.value)"><option value="" selected="selected">---请选择---</option></select>&nbsp;&nbsp;--%>
<%--    二级分类：<select data-options="width:'150'" id="attr_class_2_select" class="easyui-combobox" onchange="attr_get_attr_list(this.value)"><option value="" selected="selected">---请选择---</option></select>&nbsp;&nbsp;--%>
<%--&lt;%&ndash;    品牌：<select id="tm_class_select"><option value="" selected="selected">---请选择---</option></select>&nbsp;&nbsp;&ndash;%&gt;--%>
<%--    <hr>--%>
<%--    查询<br>--%>
<%--    &lt;%&ndash; 这里不能加target="_blank",加了进入不了goto_spu_add() &ndash;%&gt;--%>
<%--    <a href="javascript:goto_attr_add();">添加</a><br>--%>
<%--    编辑<br>--%>
<%--    删除<br>--%>
<%--    <hr>--%>
<%--    <div id="attrListInner"></div>--%>
    <div class="easyui-layout" data-options="fit:true">
        <div data-options="region:'north',split:true" style="height:100px">
            <h3>商品属性信息管理</h3>
            一级分类：<select data-options="width:'150'" id="attr_class_1_select" class="easyui-combobox" onchange="attr_get_class_2(this.value)"><option value="" selected="selected">---请选择---</option></select>&nbsp;&nbsp;
            二级分类：<select data-options="width:'150'" id="attr_class_2_select" class="easyui-combobox" onchange="attr_get_attr_list(this.value)"><option value="" selected="selected">---请选择---</option></select>&nbsp;&nbsp;
            <%--    品牌：<select id="tm_class_select"><option value="" selected="selected">---请选择---</option></select>&nbsp;&nbsp;--%>
            <a href="javascript:goto_attr_add();">添加</a>

        </div>
        <div data-options="region:'west',split:true" style="width:100px">
            查询<br>
            编辑<br>
            删除<br>
        </div>
        <div data-options="region:'center'">
            <div id="attrListInner" width="100%"></div>
        </div>
    </div>


    <script type="text/javascript">
        $(function(){
            //加载js数据
            // $.getJSON("js/json/class_1.js",function (data) {
            //     $("#attr_class_1_select option:not(:first)").remove();
            //     $(data).each(function (i, json) {
            //         $("#attr_class_1_select").append($("<option></option>").val(json.id).text(json.flmch1));
            //     })
            // })
            $('#attr_class_1_select').combobox({
                url:'js/json/class_1.js',
                valueField:'id',
                textField:'flmch1',
                onChange: function () {
                    var flbh1 = $('#attr_class_1_select').combobox('getValue');
                    attr_get_class_2(flbh1);
                }
            });

        });

        function attr_get_class_2(class_1_id){
            // $("#attr_class_2_select option:not(:first)").remove();
            // $.getJSON("js/json/class_2_" + class_1_id + ".js", function (data) {
            //     $(data).each(function (i, json) {
            //         $("#attr_class_2_select").append($("<option></option>").val(json.id).text(json.flmch2));
            //     })
            // });

            $('#attr_class_2_select').combobox({
                url:'js/json/class_2_' + class_1_id + '.js',
                valueField:'id',
                textField:'flmch2',
                onChange: function () {
                    var flbh2 = $('#attr_class_2_select').combobox('getValue');
                    attr_get_attr_list(flbh2);
                }
            });


        }


        function goto_attr_add() {
            // var class_2_id = $("#attr_class_2_select").val();
            // window.location.href = "goto_attr_add.do?flbh2=" + class_2_id;


            var class_2_id = $('#attr_class_2_select').combobox('getValue');
            add_tab('goto_attr_add.do?flbh2=' + class_2_id, '添加属性');
        }

        function attr_get_attr_list(flbh2) {

            // $.post("get_attr_list.do",{flbh2: flbh2}, function (data) {
            //     $("#attrListInner").html(data);
            // });
            $('#attrListInner').datagrid({
                url:'get_attr_list_json.do',
                queryParams:{flbh2: flbh2},
                columns:[[
                    {field:'id',title:'id',width: 200},
                    {field:'shxm_mch',title:'属性名',width: 300},
                    {field:'value_list',title:'属性值',width: 400,
                        formatter: function(value,row,index){
                            var str = "";
                            $(value).each(function (i, json) {
                                str = str + json.shxzh + json.shxzh_mch + " ";
                            });
                            return str;
                        }},
                    {field:'chjshj',title:'创建时间',width:300,
                        formatter: function(value,row,index){
                            var d = new Date(value);
                            return d.toLocaleString();
                        }}
                ]]
            });

        }
    </script>
</body>
</html>

