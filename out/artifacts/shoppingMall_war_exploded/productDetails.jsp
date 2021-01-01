<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link type="text/css" href="CSS/productDetails.css" rel="stylesheet">
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <script type="text/javascript" src="JS/productDetails.js" rel="stylesheet"></script>
    <title>商品详细</title>
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
    <a href="personalCenter.jsp" class="shortcut_class_01">个人中心</a>
    <a href="" class="shortcut_class_01">消息</a>
    <a href="shoppingCart.jsp" class="shortcut_class_01">购物车</a>
    <a href="" class="shortcut_class_01">收藏夹</a>
    <a href="homePage.jsp" class="shortcut_class_01">返回首页</a>
</div>
<div id="header">
    <img src="image/icon.jpg">
    <input type="text" id="header_text_01" placeholder="请输入商品的相关信息..."/>
    <input type="button" id="header_button_01" value="搜索"/>
</div>
<div id="bobyer">
    <hr style="background-color: #0094e7; height: 2px; border: 0px;">
    <div id="bobyer_div_03">
        <img id="bobyer_img_01"
             src="https://gd1.alicdn.com/imgextra/i2/1098039223/TB2ADqVa6ihSKJjy0FfXXbGzFXa_!!1098039223.jpg"/>
        <img class="bobyer_class_img"
             src="https://gd1.alicdn.com/imgextra/i2/1098039223/TB2ADqVa6ihSKJjy0FfXXbGzFXa_!!1098039223.jpg_50x50.jpg_.webp"
             alt="https://gd1.alicdn.com/imgextra/i2/1098039223/TB2ADqVa6ihSKJjy0FfXXbGzFXa_!!1098039223.jpg">
        <img class="bobyer_class_img"
             src="https://gd3.alicdn.com/imgextra/i3/1098039223/TB2cGy3aV9gSKJjSspbXXbeNXXa_!!1098039223.jpg_50x50.jpg_.webp"
             alt="https://gd3.alicdn.com/imgextra/i3/1098039223/TB2cGy3aV9gSKJjSspbXXbeNXXa_!!1098039223.jpg">
        <img class="bobyer_class_img"
             src="https://gd3.alicdn.com/imgextra/i3/1098039223/TB2zK7xe3oQMeJjy0FoXXcShVXa_!!1098039223.jpg_50x50.jpg_.webp"
             alt="https://gd3.alicdn.com/imgextra/i3/1098039223/TB2zK7xe3oQMeJjy0FoXXcShVXa_!!1098039223.jpg">
        <img class="bobyer_class_img"
             src="https://gd4.alicdn.com/imgextra/i4/1098039223/TB2_611a6uhSKJjSspmXXcQDpXa_!!1098039223.jpg_50x50.jpg_.webp"
             alt="https://gd4.alicdn.com/imgextra/i4/1098039223/TB2_611a6uhSKJjSspmXXcQDpXa_!!1098039223.jpg">
        <img class="bobyer_class_img"
             src="https://gd3.alicdn.com/imgextra/i3/1098039223/TB2lwceafNNTKJjSspcXXb4KVXa_!!1098039223.jpg_50x50.jpg_.webp"
             alt="https://gd3.alicdn.com/imgextra/i3/1098039223/TB2lwceafNNTKJjSspcXXb4KVXa_!!1098039223.jpg">
    </div>
    <div id="bobyer_div_04">
        <div id="bobyer_div_05">
            <h3><span id="name"></span></h3>
            <h5 style="margin-top: 15px;">店铺：<span id="shop"></span></h5>
        </div>
        <div id="bobyer_div_06">
            <span id="bobyer_span_02">价格</span>
            <span id="price"></span>
            <div id="bobyer_div_07">
                <p style="font-size: 18px;">26</p>
                <p style="font-size: 12px;">累计评价</p>
            </div>
            <div id="bobyer_div_08">
                <p style="font-size: 18px;">25</p>
                <p style="font-size: 12px;">交易成功</p>
            </div>
        </div>
        <div id="bobyer_div_09">
            <span style="color: #AAAAAA; margin-left: 25px;" class="bobyer_class_span_02">配送</span>
            <span class="bobyer_class_span_02">&nbsp;&nbsp;至&nbsp;&nbsp;</span>
            <span id="address" class="bobyer_class_span_02"></span>
        </div>
        <div id="bobyer_div_10">
            <div id="bobyer_div_11">
                <span style="font-weight: bold;">商品介绍：</span><span id="desc"></span>
                <!--                    <span class="bobyer_class_span_02" style="color: #AAAAAA;">规格</span>-->
                <!--                    <span class="class_span_03" style="margin-left: 40px;" >34</span>-->
                <!--                    <span class="class_span_03">35</span>-->
                <!--                    <span class="class_span_03">36</span>-->
                <!--                    <span class="class_span_03">37</span>-->
                <!--                    <span class="class_span_03">38</span>-->
                <!--                    <span class="class_span_03">39</span>-->
                <!--                    <span class="class_span_03">40</span>-->
            </div>
            <div id="bobyer_div_12">
                <span class="bobyer_class_span_02" style="color: #AAAAAA;">数量</span>
                <input id="less" type="button" value="-" style="height: 25px; width: 25px;">
                <div id="bobyer_div_13"><input id="num" type="text" value="1"></div>
                <input id="plus" type="button" value="+" style="height: 25px; width: 25px;">
            </div>
            <div id="bobyer_div_14">
                <% if (user_id != null) { %>
                <span id="buy">立即购买</span>
                <span id="join">加入购物车</span>
                <% } else { %>
                <span id="buy_not">立即购买</span>
                <span id="join_not">加入购物车</span>
                <% } %>
            </div>
        </div>
    </div>
</div>
<p style="margin-left: 270px; font-size: 20px; font-weight: bold;">评论：</p>
<div style="width: 1000px; margin-left: 270px; border: 1px solid #e3e4e5;">
    <table id="tabler">

    </table>
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
</body>
</html>