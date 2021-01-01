<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link type="text/css" href="CSS/login.css" rel="stylesheet">
    <script src="http://cdn.bootcss.com/blueimp-md5/1.1.0/js/md5.js"></script>  <!--MD5加密-->
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <script type="text/javascript" src="JS/login.js" rel="stylesheet"></script>
    <title>登录</title>
</head>
<body>
<div id="header">
    <img src="image/icon.jpg" id="header_img_01">
    <img src="image/avatar.png" id="header_img_02">
    <span id="header_span_01">您好！欢迎来到无忧商城<br>如未注册账号，请先<a href="register.jsp">注册</a></span>
</div>
<div id="bobyer">
    <img id="bobyer_img_01" src="http://www.51mkf.com/data/upload/shop/login/1.jpg">
    <div id="bobyer_div_01">
        <p>登录</p>
        <hr/>
        <from id="bobyer_from_01" method="get" action="">
            <dl>
                <dt>账&nbsp;&nbsp;&nbsp;号:</dt>
                <dd><input type="text" name="user_name" id="user_name" placeholder="可使用已注册的用户名和手机号登录"></dd>
            </dl>
            <dl>
                <dt>密&nbsp;&nbsp;&nbsp;码:</dt>
                <dd><input type="password" name="password" id="password" placeholder="6-20个大小写英文字母、符号或数字"></dd>
            </dl>
            <a href="register.jsp" style="position: relative; top: 55px; left: 55px; font-size: 12px; color: #0094e7;">注册账号</a>
            <a href="" style="position: relative; top: 55px; left: 310px; font-size: 12px; color: #0094e7;">忘记密码？</a>
            <input id="submit" type="submit" value="登&nbsp;&nbsp;&nbsp;&nbsp;录">
        </from>
    </div>
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