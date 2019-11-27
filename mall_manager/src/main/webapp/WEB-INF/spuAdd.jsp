<%--
  Created by IntelliJ IDEA.
  User: jarvis
  Date: 2019-11-22
  Time: 20:20
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
        function choose_file(index) {
            $("#file_" + index).click();
        }

        function replace_image(index) {
            //获取显示图片的缩略图
            var blob_image = $("#file_" + index)[0].files[0];
            var url = window.URL.createObjectURL(blob_image);
            $("#img_" + index).attr("src", url);

            //添加图片和file对象
            var length = $(":file").length;
            if ((index + 1) == length){
                add_image(index);
            }
            // 第一种实现
            /*
            var radioNode = '<input name="fm_id" type="radio" value="' + index + '"';

            if (index == 0){
                radioNode = radioNode + 'checked = "checked"';
            }
            radioNode = radioNode + '/>';

            $("#div_" + index).append("<br>").append("作为封面：").append(radioNode);
             */
            var radioNode = $("<input/>").attr({name: "fm_id", type: "radio"}).val(index);
            if (index == 0){
                radioNode.attr("checked","checked");
            }
            $("#div_" + index).append("<br>").append("作为封面：").append(radioNode);
        }

        function add_image(index){
            // 第一种实现
            /*
            var div_node = '<div id="div_' +(index + 1) + '" style="float: left; border: 1px red solid; margin-left: 10px;">';
            var file_node = '<input id="file_' + (index + 1) + '" name="files" type="file" style="cursor: pointer; display: none" onchange="replace_image(' + (index + 1) + ')">';

            var img_node = '<img id="img_' + (index + 1) + '" src="image/upload_hover.png" width="100px" height="100px" onclick="choose_file(' + (index + 1) + ')"/>';
            var end = '</div>';
            $("#div_" + index).after(div_node + file_node + img_node + end);
             */
            var div_node = $("<div style='margin-left: 10px;'></div>").attr("id", "div_" + (index + 1)).css({float: "left",border: "1px red solid"});
            var file_node = $("<input/>").attr({id: "file_" + (index + 1), name: "files", type: "file"}).css({
                cursor: "pointer",
                display: "none"
            });
            $(document).on("change", "#file_" + (index + 1), {index: index + 1}, function(event){
                replace_image(event.data.index);
            });
            var img_node = $("<img/>").attr({
                id: "img_" + (index + 1),
                src: "image/upload_hover.png"
            }).css({width: "100px", height: "100px"});
            $(document).on("click", "#img_" + (index + 1), {index: index + 1}, function (event) {
                choose_file(event.data.index);
            });
            div_node.append(file_node).append(img_node);
            $("#div_" + index).after(div_node);
        }
    </script>
</head>
<body>
    spu信息添加

    <form action="spu_add.do" method="post" enctype="multipart/form-data">
        <input name="flbh1" type="hidden" value="${spu.flbh1}"/>
        <input name="flbh2" type="hidden" value="${spu.flbh2}"/>
        <input name="pp_id" type="hidden" value="${spu.pp_id}"/>

        商品名称：<input name="shp_mch" type="text" /><br>
        商品描述：<textarea name="shp_msh" rows="10" cols="50"></textarea><br>
        商品图片：<br>
        <div id="div_0" style="float: left; border: 1px red solid; margin-left: 10px">
            <input id="file_0" name="files" type="file" style="cursor: pointer; display: none" onchange="replace_image(0)">
            <img id="img_0" src="image/upload_hover.png" width="100px" height="100px" onclick="choose_file(0)"/>
        </div>

        <br>
        <input type="submit" value="提交">
    </form>
</body>
</html>

