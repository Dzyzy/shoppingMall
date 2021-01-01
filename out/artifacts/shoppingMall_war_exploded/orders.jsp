<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link type="text/css" href="CSS/orders.css" rel="stylesheet">
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <script type="text/javascript" src="JS/orders.js" rel="stylesheet"></script>
    <title>确认订单</title>
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
    <img src="image/icon.jpg">
    <input type="text" id="header_text_01" placeholder="请输入商品的相关信息..."/>
    <input type="button" id="header_button_01" value="搜索"/>
</div>
<div id="bobyer">
    <ul id="bobyer_ul">
        <h4 style="margin-left: 50px; margin-top: 20px;">确认订单信息</h4>
        <li id="bb_9">
            <div class="bobyer_class_01" id="bobyer_div_01">
                <span id="bobyer_span_01">商品信息</span>
                <span id="bobyer_span_02">单价</span>
                <span id="bobyer_span_03">数量</span>
                <span id="bobyer_span_04">小计</span>
            </div>
        </li>
        <!--从数据库中读取数据-->
    </ul>
    <div style="margin-left: 43px; height: 30px; margin-top: 20px;">
        地址：<input id="bobyer_text_01" type="text" style="width: 300px; height: 20px;">
        联系方式：<input id="bobyer_text_02" type="text" style="width: 300px; height: 20px;">
    </div>
    <div class="bobyer_class_13">
        <span class="bobyer_class_11">已选商品<span class="bobyer_class_12">0</span>件</span>
        <span class="bobyer_class_16">合计：<span class="bobyer_class_14">￥</span><span class="bobyer_class_15">0.00</span></span>
    </div>
    <div id="bobyer_div_02">
        <span id="bobyer_span_05">提交订单</span>
    </div>
    <div id="tailer">
        <p>
            <span>QQ：962355097&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
            <span>电话：17742532106</span>
        </p>
        <p>
            <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;地址：吉首大学张家界校区十栋</span>
        </p>
    </div>
</div>
</body>
</html>