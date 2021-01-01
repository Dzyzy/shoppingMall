<%@ page import="Util.Prod" %>
<%@ page import="java.util.List" %>
<%@ page import="Util.classification" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link type="text/css" href="CSS/shop.css" rel="stylesheet">
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <script type="text/javascript" src="JS/shop.js" rel="stylesheet"></script>
    <title>我的店铺</title>
</head>
<body>
<div id="shortcut">
    <%
        Object user_id = session.getAttribute("user_id");
        Object user_name = session.getAttribute("user_name");
    %>
    <span id="shortcut_span_01">您好，欢迎来到无忧商城！</span>
    <% if (user_id != null) { %>
    <span id="shortcut_span_02" class="shortcut_class_01"><a href="" class="shortcut_class_01"><%=user_name%></a></span>
    <% } else { %>
    <span id="shortcut_span_02" class="shortcut_class_01"><a href="" class="shortcut_class_01">请登录</a></span>
    <% } %>
    <a href="register.jsp" class="shortcut_class_01">免费注册</a>
    <a href="personalCenter.jsp" class="shortcut_class_01">个人中心</a>
    <a href="" class="shortcut_class_01">消息</a>
    <a href="shoppingCart.jsp" class="shortcut_class_01">购物车</a>
    <a href="homePage.jsp" class="shortcut_class_01">返回首页</a>
</div>
<div id="header">
    <img src="image/icon.jpg" id="img_01"/>
    <input type="text" id="header_text_01" placeholder="请输入商品的相关信息..."/>
    <input type="button" id="header_button_01" value="搜索"/>
</div>
<div id="bobyer">
    <ul>
        <li class="bobyer_class_01">
            <span id="span1" style="cursor: pointer">上架商品</span>
            <div id="bobyer_div_01" style="display: none;">
                <div id="bobyer_div_02">
                    <span id="bobyer_span_01" class="bobyer_class_02">上架商品</span>
                    <ul>
                        <li><span id="bobyer_span_02" class="bobyer_class_02">上传图片：</span><input id="prod_img"
                                                                                                 type="file"
                                                                                                 style="color: black;">
                        </li>
                        <li><span class="bobyer_class_02">商品名称：</span><input id="prod_name" class="bobyer_class_03"
                                                                             type="text"></li>
                        <li><span class="bobyer_class_02">商品简介：</span><input id="prod_desc" class="bobyer_class_03"
                                                                             type="text"></li>
                        <li><span class="bobyer_class_02">商品分类：</span>
                            <select id="select4" class="bobyer_class_44">
                                <option>--请选择--</option>
                                <%
                                    List<classification> list_class1 = (List<classification>) request.getSession().getAttribute("list_class1");
                                    for (int i = 0; i < list_class1.size(); i++) {
                                        classification cla = list_class1.get(i);
                                %>
                                <option><%=cla.getClassification_name()%>
                                </option>
                                <% } %>
                            </select>
                            <select id="select5" class="bobyer_class_44">
                                <option>--请选择--</option>
                            </select>
                            <select id="select6" class="bobyer_class_44">
                                <option>--请选择--</option>
                            </select>
                        </li>
                        <li><span class="bobyer_class_02">商品价格：</span><input id="prod_price" class="bobyer_class_03"
                                                                             type="text"></li>
                        <li><span class="bobyer_class_02">商品数量：</span><input id="prod_num" class="bobyer_class_03"
                                                                             type="text"></li>
                    </ul>
                    <input id="queding" type="button" value="确定">
                </div>
            </div>

            <div id="bobyer_div_30" style="display: none;">
                <div id="bobyer_div_31">
                    <span id="bobyer_span_31">修改商品</span>
                    <ul>
                        <li><span id="bobyer_span_302" class="bobyer_class_02">上传图片：</span><input id="prod_img1"
                                                                                                  type="file"
                                                                                                  style="color: black;">
                        </li>
                        <li><span class="bobyer_class_02">商品名称：</span><input id="prod_name1" class="bobyer_class_03"
                                                                             type="text"></li>
                        <li><span class="bobyer_class_02">商品简介：</span><input id="prod_desc1" class="bobyer_class_03"
                                                                             type="text"></li>
                        <li><span class="bobyer_class_02">商品分类：</span>
                            <select id="select17" class="bobyer_class_44">
                                <option>--请选择--</option>
                                <%
                                    for (int i = 0; i < list_class1.size(); i++) {
                                        classification cla = list_class1.get(i);
                                %>
                                <option><%=cla.getClassification_name()%>
                                </option>
                                <% } %>
                            </select>
                            <select id="select18" class="bobyer_class_44">
                                <option>--请选择--</option>
                            </select>
                            <select id="select19" class="bobyer_class_44">
                                <option>--请选择--</option>
                            </select>
                        </li>
                        <li><span class="bobyer_class_02">商品价格：</span><input id="prod_price1" class="bobyer_class_03"
                                                                             type="text"></li>
                        <li><span class="bobyer_class_02">商品数量：</span><input id="prod_num1" class="bobyer_class_03"
                                                                             type="text"></li>
                    </ul>
                    <input id="xiugai1231" type="button" value="修改">
                </div>
            </div>
        </li>
        <li class="bobyer_class_01">
            <span id="span2" style="cursor: pointer">已上架商品</span>
            <div id="bobyer_div_03" style="display: none;">
                <span id="bobyer_span_03">已上架商品</span>
                <ul id="bobyer_ul">
                    <li>
                        <span id="bobyer_span_10">商品信息</span>
                        <span id="bobyer_span_11">单价</span>
                        <span id="bobyer_span_12">销售数量</span>
                        <span id="bobyer_span_13">销售总价</span>
                        <span id="bobyer_span_14">商品状态</span>
                        <span id="bobyer_span_15">操作</span>
                    </li>
                    <%
                        List<Prod> list_prod_1 = (List<Prod>) request.getSession().getAttribute("list_prod_1");
                        for (int i = 0; i < list_prod_1.size(); i++) {
                            Prod prods = list_prod_1.get(i);
                    %>
                    <li class="bobyer_class_06">
                        <div class="bobyer_class_12">
                            <img class="bobyer_class_05" src="<%=prods.getProd_img()%>">
                            <div class="bobyer_class_08"><span class="bobyer_class_09"><%=prods.getProd_name()%></span>
                            </div>
                            <span class="bobyer_class_10">￥<%=prods.getProd_price()%></span>
                            <span class="bobyer_class_11"><%=prods.getProd_sale_num()%></span>
                        </div>
                        <div class="bobyer_class_14">
                            <span class="bobyer_class_13">￥<%=prods.getProd_sale_amount()%></span>
                        </div>
                        <div class="bobyer_class_15">
                            <span class="bobyer_class_16">已上架</span>
                        </div>
                        <div class="bobyer_class_17">
                            <span class="s1" style="display: none;"><%=prods.getProd_id()%></span>
                            <a class="bobyer_class_34"
                               style="position: relative; top: 19px; cursor: pointer; color: black; font-size: 16px;">
                                修改
                            </a>
                            <span class="bobyer_class_341"
                                  style="position: relative; top: 19px; color: black; font-size: 16px;">
                                /
                            </span>
                            <a class="bobyer_class_35"
                               style="position: relative; top: 19px; cursor: pointer; color: black; font-size: 16px;">
                                删除
                            </a>
                        </div>
                    </li>
                    <% } %>
                </ul>
            </div>
        </li>
        <li class="bobyer_class_01">
            <span id="span3" style="cursor: pointer;">已卖出商品</span>
            <div id="bobyer_div_04">
                <span id="bobyer_span_04">已卖出商品</span>
                <ul id="boby_ul">
                    <li>
                        <span id="boby_span_10">商品信息</span>
                        <span id="boby_span_11">单价</span>
                        <span id="boby_span_12">数量</span>
                        <span id="boby_span_13">总价</span>
                        <span id="boby_span_14">交易状态</span>
                        <span id="boby_span_15">交易操作</span>
                    </li>
                    <%
                        List<Integer> lis = (List<Integer>) request.getSession().getAttribute("lis");
                        List<Prod> list_o_2 = (List<Prod>) request.getSession().getAttribute("list_o_2");

                        for (int i = 0; i < lis.size(); i++) {
                            int orders_id = lis.get(i);%>
                    <li class="bobyer_class_07">
                        <p class="bobyer_class_40">
                            订单号：<span class="bobyer_class_20"><%=orders_id%></span>
                        </p>
                    </li>
                    <%
                        for (int j = 0; j < list_o_2.size(); j++) {
                            Prod prods = list_o_2.get(j);
                            if (prods.getOrders_id() == orders_id) {
                    %>
                    <li class="bobyer_class_06">
                        <div class="bobyer_class_12">
                            <img class="bobyer_class_05" src="<%=prods.getProd_img()%>">
                            <div class="bobyer_class_08"><span class="bobyer_class_09"><%=prods.getProd_name()%></span>
                            </div>
                            <span class="bobyer_class_10">￥<%=prods.getProd_price()%></span>
                            <span class="bobyer_class_11"><%=prods.getProd_count()%></span>
                        </div>
                        <div class="bobyer_class_14">
                            <span class="bobyer_class_13">￥<%=prods.getProd_sale_amount()%></span>
                        </div>
                        <div class="bobyer_class_15">
                            <% if (prods.getProd_pingjia() == 0) { %>
                            <span class="bobyer_class_16">未发货</span>
                            <% } else if (prods.getProd_pingjia() == 1) {%>
                            <span class="bobyer_class_16">已发货</span>
                            <% } else if (prods.getProd_pingjia() >= 2) {%>
                            <span class="bobyer_class_16">已收货</span>
                            <%}%>
                        </div>
                        <div class="bobyer_class_17">
                            <span class="bobyer_class_50" style="display: none"><%=orders_id%></span>
                            <span class="bobyer_class_51" style="display: none"><%=prods.getProd_id()%></span>
                            <% if (prods.getProd_pingjia() == 0) {%>
                            <span class="bobyer_class_24"
                                  style="position: relative; top: 19px; cursor: pointer; color: black; font-size: 16px;">发货</span>
                            <%}%>
                        </div>
                        <% } %>
                        <% } %>
                        <% } %>
                    </li>
                </ul>
            </div>
        <li class="bobyer_class_01">
            <span id="span4" style="cursor: pointer;">添加分类</span>
            <div id="bobyer_div_05" style="display: none;">
                <span id="bobyer_span_05" class="bobyer_class_02">添加分类</span>
                <ul>
                    <li class="bobyer_class_70">
                        <span class="bobyer_class_02">一级：</span>
                        <input type="text" id="text1">
                        <input type="button" value="添加" id="button1">
                    </li>
                    <li class="bobyer_class_70">
                        <span class="bobyer_class_02">二级：</span>
                        <select id="select1" class="bobyer_class_44">
                            <option>--请选择--</option>
                            <%
                                for (int i = 0; i < list_class1.size(); i++) {
                                    classification cla = list_class1.get(i);
                            %>
                            <option><%=cla.getClassification_name()%>
                            </option>
                            <% } %>
                        </select>
                        <input type="text" id="text2">
                        <input type="button" value="添加" id="button2">
                    </li>
                    <li class="bobyer_class_70">
                        <span class="bobyer_class_02">三级：</span>
                        <select id="select2" class="bobyer_class_44">
                            <option>--请选择--</option>
                            <%
                                for (int i = 0; i < list_class1.size(); i++) {
                                    classification cla = list_class1.get(i);
                            %>
                            <option><%=cla.getClassification_name()%>
                            </option>
                            <% } %>
                        </select>
                        <select id="select3" class="bobyer_class_44">
                            <option>--请选择--</option>
                        </select>
                        <input type="text" id="text3">
                        <input type="button" value="添加" id="button3">
                    </li>
                </ul>


                <span id="bobyer_span_105" class="bobyer_class_02">修改分类</span>
                <ul>
                    <li class="bobyer_class_70">
                        <span class="bobyer_class_02">一级：</span>
                        <select id="select101" class="bobyer_class_44">
                            <option>--请选择--</option>
                            <%
                                for (int i = 0; i < list_class1.size(); i++) {
                                    classification cla = list_class1.get(i);
                            %>
                            <option><%=cla.getClassification_name()%>
                            </option>
                            <% } %>
                        </select>
                        <input type="text" id="text40">
                        <input type="button" value="修改" id="button10">
                    </li>
                    <li class="bobyer_class_70">
                        <span class="bobyer_class_02">二级：</span>
                        <select id="select111" class="bobyer_class_44">
                            <option>--请选择--</option>
                            <%
                                for (int i = 0; i < list_class1.size(); i++) {
                                    classification cla = list_class1.get(i);
                            %>
                            <option><%=cla.getClassification_name()%>
                            </option>
                            <% } %>
                        </select>
                        <select id="select121" class="bobyer_class_44">
                            <option>--请选择--</option>
                        </select>
                        <input type="text" id="text50">
                        <input type="button" value="修改" id="button20">
                    </li>
                    <li class="bobyer_class_70">
                        <span class="bobyer_class_02">三级：</span>
                        <select id="select1311" class="bobyer_class_44">
                            <option>--请选择--</option>
                            <%
                                for (int i = 0; i < list_class1.size(); i++) {
                                    classification cla = list_class1.get(i);
                            %>
                            <option><%=cla.getClassification_name()%>
                            </option>
                            <% } %>
                        </select>
                        <select id="select1411" class="bobyer_class_44">
                            <option>--请选择--</option>
                        </select>
                        <select id="select1511" class="bobyer_class_44">
                            <option>--请选择--</option>
                        </select>
                        <input type="text" id="text30">
                        <input type="button" value="修改" id="button30">
                    </li>
                </ul>
            </div>
        </li>
    </ul>
</div>
</body>
</html>