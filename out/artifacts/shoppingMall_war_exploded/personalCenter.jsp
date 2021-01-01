<%@ page import="Util.orders" %>
<%@ page import="java.util.List" %>
<%@ page import="Util.Orders_item" %>
<%@ page import="com.sun.org.apache.xpath.internal.operations.Or" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link type="text/css" href="CSS/personalCenter.css" rel="stylesheet">
    <script src="http://cdn.bootcss.com/blueimp-md5/1.1.0/js/md5.js"></script>  <!--MD5加密-->
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <script type="text/javascript" src="JS/personalCenter.js" rel="stylesheet"></script>
    <title>个人中心</title>
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
    <span id="shortcut_span_02" class="shortcut_class_01"><a href="login.jsp" class="shortcut_class_01">请登录</a></span>
    <% } %>
    <a href="register.jsp" class="shortcut_class_01">免费注册</a>
    <a href="" class="shortcut_class_01">我的足迹</a>
    <a href="" class="shortcut_class_01">消息</a>
    <a href="shoppingCart.jsp" class="shortcut_class_01">购物车</a>
    <a href="" class="shortcut_class_01">收藏夹</a>
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
            <span id="span1" style="cursor: pointer">个人资料</span>
            <div id="bobyer_div_01">
                <div id="bobyer_div_02">
                    <span id="bobyer_span_01" class="bobyer_class_02">个人资料</span>
                    <ul>
                        <li><span id="bobyer_span_02" class="bobyer_class_02">当前头像：</span><img id="bobyer_img_01"
                                                                                               src="image/avatar.png">
                        </li>
                        <li><span class="bobyer_class_02">用户昵称：</span><input id="user_name" class="bobyer_class_03"
                                                                             type="text"></li>
                        <li><span class="bobyer_class_02">修改密码：</span><input id="password" class="bobyer_class_03"
                                                                             type="password"></li>
                        <li><span class="bobyer_class_02">电话号码：</span><input id="phone" class="bobyer_class_03"
                                                                             type="text"></li>
                        <li><span class="bobyer_class_02">用户地址：</span><input id="address" class="bobyer_class_03"
                                                                             type="text"></li>
                    </ul>
                    <input id="queding" type="button" value="确定">
                </div>
            </div>
        </li>
        <li class="bobyer_class_01">
            <span id="span2" style="cursor: pointer">我的订单</span>
            <div id="bobyer_div_03">
                <span id="bobyer_span_03">订单管理</span>
                <ul id="bobyer_ul">
                    <li>
                        <span id="bobyer_span_10">商品信息</span>
                        <span id="bobyer_span_11">单价</span>
                        <span id="bobyer_span_12">数量</span>
                        <span id="bobyer_span_13">总价</span>
                        <span id="bobyer_span_14">交易状态</span>
                        <span id="bobyer_span_15">交易操作</span>
                    </li>
                    <%
                        List<orders> list_1 = (List<orders>) request.getSession().getAttribute("list_1");
                        List<Orders_item> list_2 = (List<Orders_item>) request.getSession().getAttribute("list_2");
                    %>
                    <% for (int i = 0; i < list_1.size(); i++) {
                        orders ord = list_1.get(i);
                        Boolean mark = true;
                    %>
                    <li class="bobyer_class_07">
                        <p class="bobyer_class_04">
                            订单号：<span class="bobyer_class_20"><%=ord.getOrders_id()%></span>
                        </p>
                    </li>
                    <% for (int j = 0; j < list_2.size(); j++) {
                        Orders_item or = list_2.get(j);
                        if (or.getOrders_id() != ord.getOrders_id()) {
                            continue;
                        }
                    %>
                    <li class="bobyer_class_06">
                        <div class="bobyer_class_12">
                            <img class="bobyer_class_05" src="<%=or.getProd_img()%>">
                            <div class="bobyer_class_08">
                                <span class="bobyer_class_09"><%=or.getProd_name()%></span>
                            </div>
                            <span class="bobyer_class_10">￥<%=or.getProd_price()%></span>
                            <span class="bobyer_class_11"><%=or.getProd_count()%></span>
                        </div>
                        <div class="bobyer_class_14">
                                <span class="bobyer_class_13">
                                    <% if (mark) {%>
                                    ￥<%=ord.getOrders_total_amount()%>
                                    <%}%>
                                </span>
                        </div>
                        <div class="bobyer_class_15">
                                <span class="bobyer_class_16">
                                    <%
                                        if (mark) {
                                            if (ord.getOrders_statu() == 1) {
                                    %>
                                    未支付
                                    <%}%>
                                    <% } %>
                                </span>
                            <span class="bobyer_class_25">
                                    <%if (ord.getOrders_statu() == 2 && or.getProd_pingjia() == 0) {%>
                                    待发货
                                    <%} else if (or.getProd_pingjia() == 1) { %>
                                    已完成
                                    <%} else if (or.getProd_pingjia() == 2) { %>
                                    待评价
                                    <%} else if (or.getProd_pingjia() >= 3) { %>
                                    已评价
                                    <% } %>
                                </span>
                        </div>
                        <div class="bobyer_class_17">
                            <span class="bobyer_class_21" style="display: none"><%=ord.getOrders_id()%></span>
                            <span class="bobyer_class_22" style="display: none"><%=ord.getOrders_statu()%></span>
                            <span class="bobyer_class_23" style="display: none"><%=or.getProd_id()%></span>
                            <span class="bobyer_class_26" style="display: none"><%=or.getProd_pingjia()%></span>
                            <span class="bobyer_class_18" style="cursor: pointer">
                                    <%
                                        if (mark) {
                                            mark = false;
                                            if (ord.getOrders_statu() == 1) {
                                    %>
                                        付款
                                        <%}%>
                                    <%}%>
                                </span>
                            <span class="bobyer_class_24"
                                  style="position: relative; top: 19px; cursor: pointer; color: black; font-size: 16px;">
                                    <%if (or.getProd_pingjia() == 2) {%>
                                    评价
                                    <%} else if (or.getProd_pingjia() == 1) {%>
                                    确认收货
                                    <% } %>
                                </span>
                        </div>
                    </li>
                    <%}%>
                    <%}%>
                </ul>
            </div>
        </li>
        <li class="bobyer_class_01" style="cursor: pointer">
            <span id="span3">我的店铺</span>
        </li>
        <li class="bobyer_class_01" style="cursor: pointer">
            <span id="span4">商店评价</span>
        </li>
    </ul>
</div>
</body>
</html>