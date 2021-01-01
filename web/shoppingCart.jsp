<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link type="text/css" href="CSS/shoppingCart.css" rel="stylesheet">
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <script type="text/javascript" src="JS/shoppingCart.js"></script>
    <title>购物车</title>
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
    <a href="" class="shortcut_class_01">收藏夹</a>
    <a href="homePage.jsp" class="shortcut_class_01">返回首页</a>
</div>
<div id="header">
    <img src="image/icon.jpg" id="img_01"/>
    <span>购物车</span>
    <input type="text" id="header_text_01" placeholder="请输入商品的相关信息..."/>
    <input type="button" id="header_button_01" value="搜索"/>
</div>
<div id="bobyer">
    <ul id="bobyer_ul">
        <li class="bobyer_class_11">
            <div class="bobyer_class_01" id="bobyer_div_01">
                <input type="checkbox" id="checkbox"><span id="bobyer_span_00">全选</span>
                <span id="bobyer_span_01">商品信息</span>
                <span id="bobyer_span_02">单价</span>
                <span id="bobyer_span_03">数量</span>
                <span id="bobyer_span_04">金额</span>
                <span id="bobyer_span_05">操作</span>
            </div>
        </li>
        <!--从数据库中读取数据-->
    </ul>
    <div id="bobyer_div_02">
        <input id="bobyer_botton_01" type="button" value="删除">
        <span id="bobyer_span_09" class="bobyer_class_09">已选商品<span id="bobyer_span_06">0</span>件</span>
        <span id="bobyer_span_10" class="bobyer_class_09">合计：<span id="bobyer_span_07">￥</span><span
                id="bobyer_span_08">0.00</span></span>
    </div>
    <div id="bobyer_div_03">
        <span id="bobyer_span_11">结&nbsp;&nbsp;算</span>
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