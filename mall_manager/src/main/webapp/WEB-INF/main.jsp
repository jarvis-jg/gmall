<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<html>
<head>
    <base href="<%=basepath %>" />
    <meta/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>硅谷商城</title>
    <link rel="stylesheet" type="text/css" href="js/easy-ui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="js/easy-ui/themes/icon.css">
    <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="js/easy-ui/jquery.easyui.min.js"></script>
    <script type="text/javascript">
        // tabs_json初始化
        var tabs = "";

        $(function () {


            var tabs_str = "${tabs_json}";

            if (tabs_str != ""){
                var tabs_json = eval('(' + tabs_str + ')');
                $.each(tabs_json, function (i, json) {
                    add_tab(json.url, json.title);
                });
            }
        });

        function add_tab(url,title) {
            //此时不加载head元素，需要把js代码移到body中

            if ($('#tt').tabs('exists',title)) {
                $('#tt').tabs('select', title);
            }else{
                // add a new tab panel
                $('#tt').tabs('add',{
                    title:title,
                    href:url,
                    closable:true
                });

                tabs = add_tabs_json(url,title,tabs);

                //为add_tabs添加tabs_json
                $(document).off("click", "input[type='submit']");
                $(document).on("click", "input[type='submit']", {tabs: tabs}, function (event) {
                    tabs_json = event.data.tabs;
                    var form = $(this).parents("form");
                    var tabs_json_input = form.find("input[name='tabs_json']");
                    if (tabs_json_input != null){
                        form.append($("<input/>").attr({
                            name: 'tabs_json',
                            type: 'hidden'
                        }).val(tabs_json));
                    }else{
                        tabs_json_input.val(tabs_json);
                    }
                    return true;
                });
            }
        }

        function add_tabs_json(url,title,tabs) {
            if (tabs.length == 0){
                tabs = tabs + "[{'url':'" + url + "','title':'" + title + "'}]";
            }else{
                tabs = tabs.substring(0, tabs.length - 1) + ",{'url':'" + url + "','title':'" + title + "'}]";
            }
            return tabs;
        }



        function add_tab2(url,title) {
            //以ajax异步的方式，可以加载到页面的head元素
            //但是此时有个问题，其他页面的jquery会覆盖当前页面的jquery。导致先加载的easy-ui的js，后加载的jquery。
            // 此时会easy-ui的函数会失效，因为easy-ui对jquey有依赖，需先加载jquery
            $.post(url, function (data) {
                $('#tt').tabs('add', {
                    title: title,
                    content: data,
                    closable: true
                });
            });
            tabs = tabs + '{url: ' + url + ',title:' + title + '},';
        }
    </script>
</head>
<body class="easyui-layout">
<%--    后台管理页面--%>
<%--    <br>--%>
<%--    <a href="goto_spu.do" target="_blank">商品信息管理</a><br>--%>
<%--    <a href="goto_attr.do" target="_blank">商品属性管理</a><br>--%>
<%--    <a href="goto_sku.do" target="_blank">商品库存单元管理</a><br>--%>
<%--    商品缓存管理<br>--%>
    <div data-options="region:'north',border:false" style="height:60px;background:#B3DFDA;padding:10px">
        <h2>后台管理页面</h2>
    </div>
    <div data-options="region:'west',split:true,title:'West'" style="width:250px;padding:10px;">
        <div class="easyui-accordion" data-options="multiple:true" style="width:200px;height1:300px;">
            <div title="商品管理" data-options="iconCls:'icon-ok'" style="overflow:auto;padding:10px;">
                <ul class="easyui-tree">
                    <li>
                        <span>商品管理</span>
                        <ul>
                            <li>
                                <a href="javascript:add_tab('goto_spu.do','商品信息管理');">商品信息管理</a>
                            </li>
                            <li>
                                <a href="javascript:add_tab('goto_attr.do','商品属性管理');">商品属性管理</a>
                            </li>
                            <li>
                                <a href="javascript:add_tab('goto_sku.do','商品库存单元管理');">商品库存单元管理</a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
            <div title="缓存管理" style="padding:10px;">
                商品缓存管理
            </div>
        </div>
    </div>
    <div data-options="region:'east',split:true,collapsed:true,title:'East'" style="width:100px;padding:10px;">east region</div>
    <div data-options="region:'south',border:false" style="height:50px;background:#A9FACD;padding:10px;">south region</div>
    <div data-options="region:'center',title:'Center'">
        <div id="tt" class="easyui-tabs" style="height:800px;">

        </div>
    </div>
</body>
</html>
