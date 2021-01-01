<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html >
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link type="text/css" href="CSS/register.css" rel="stylesheet">
    <script src="http://cdn.bootcss.com/blueimp-md5/1.1.0/js/md5.js"></script>  <!--MD5加密-->
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <script type="text/javascript" src="JS/register.js" rel="stylesheet"></script>
    <title>注册</title>
</head>
<body>
<div id="header">
    <img src="image/icon.jpg" id="header_img_01">
    <span id="header_span_01">已有账号？<a href="login.jsp">请登录&gt;&gt;&gt;</a></span>
</div>
<div id="bobyer">
    <div id="bobyer_div_01">
        <span>用户注册</span>
    </div>
    <div id="bobyer_div_02">
        <from id="bobyer_from_01" method="get" action="">
            <dl>
                <dt>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;昵称:</dt>
                <dd><input type="text" name="name" id="name" placeholder="请输入昵称"></dd>
            </dl>
            <dl>
                <dt>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;邮箱:</dt>
                <dd><input type="text" name="email" id="email" placeholder="请输入QQ邮箱"></dd>
            </dl>
            <dl>
                <dt>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;密码:</dt>
                <dd><input type="password" name="password" id="password" placeholder="请输入密码"></dd>
            </dl>
            <dl>
                <dt>确认密码:</dt>
                <dd><input type="password" name="isPassword" id="isPassword" placeholder="请再次输入密码"></dd>
            </dl>
            <dl>
                <dt>&nbsp;&nbsp;&nbsp;验证码:</dt>
                <dd style="width: 270px;"><input type="text" style="width: 150px;" name="code" id="code"
                                                 placeholder="输入验证码"></dd>
                <span id="code_span_change"></span>
            </dl>
            <input id="checkbox" type="checkbox"><span id="bobyer_span_01">是否同意本网站协议</span>
            <input id="submit" type="submit" disabled="false" value="注&nbsp;&nbsp;&nbsp;&nbsp;册">
            <span id="name_span"></span>
            <span id="email_span"></span>
            <span id="password_span"></span>
            <span id="isPassword_span"></span>
            <span id="code_span"></span>
        </from>
    </div>
    <div id="bobyer_div_03">
        <p>1、系统将发送校验码到您填写的这个手机号码<br/>2、港澳台及海外客户请直接联系我司工作人员注册<br/>3、注册成功帐号，您的这个手机号码将可作为手机帐号登录</p>
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