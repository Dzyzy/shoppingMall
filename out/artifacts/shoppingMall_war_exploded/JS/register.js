$(document).ready(function () {

    function isName() {     //判断是否输入了昵称
        var val = document.getElementById("name").value;
        var name_span = document.getElementById("name_span");
        if (val == null || val == "") {
            name_span.innerHTML = "*昵称不能为空";
            $("#name_span").show();
            return false;
        } else {
            name_span.innerHTML = "";
            $("#name_span").hide();
            return true;
        }
    }

    function isEmail() {     //判断邮箱的格式是否正确
        var val = document.getElementById("email").value;
        var myreg = /^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/;    //以1为开头,第二位可为3,4,5,7,8,中的任意一位,最后以0-9的9个整数结尾
        var email_span = document.getElementById("email_span");
        if (val == null || val == "") {
            email_span.innerHTML = "*邮箱不能为空";
            $("#email_span").show();
            return false;
        } else if (!myreg.test(val)) {
            email_span.innerHTML = "*您输入的邮箱不存在";
            $("#email_span").show();
            return false;
        } else {
            email_span.innerHTML = "";
            $("#email_span").hide();
            return true;
        }
    }

    function isPassword() {      //判断密码的格式是否正确
        var val = document.getElementById("password").value;
        var passwordPattern = /^[a-zA-Z0-9]{6,22}$/; //密码格式6-22位字母数字
        var password_span = document.getElementById("password_span");
        if (val == null || val == "") {
            password_span.innerHTML = "*密码不能为空";
            $("#password_span").show();
            return false;
        } else if (!passwordPattern.test(val)) {
            password_span.innerHTML = "*密码过长或出现特殊字符";
            $("#password_span").show();
            return false;
        } else {
            password_span.innerHTML = "";
            $("#password_span").hide();
            return true;
        }
    }

    function judgePassword() {       //检测两次输入的密码是否正确
        var pwd = document.getElementById("password").value;
        var val = document.getElementById("isPassword").value;
        var isPassword_span = document.getElementById("isPassword_span");
        if (val == null || val == "") {
            isPassword_span.innerHTML = "*确认密码不能为空";
            $("#isPassword_span").show();
            return false;
        } else if (pwd != val) {
            isPassword_span.innerHTML = "*两次输入的密码不一致";
            $("#isPassword_span").show();
            return false;
        } else {
            isPassword_span.innerHTML = "";
            $("#isPassword_span").hide();
            return true;
        }
    }

    function randomCode() {     //随机验证码
        var code = document.getElementById("code_span_change");
        var num = Math.floor(Math.random() * 9000 + 1000);
        code.innerHTML = num;
    }

    function judgeCode() {      //判断验证码是否正确
        var code = document.getElementById("code_span_change").innerHTML;
        var val = document.getElementById("code").value;
        var code_span = document.getElementById("code_span");
        if (val == null || val == "") {
            code_span.innerHTML = "*验证码不能为空";
            $("#code_span").show();
            return false;
        } else if (code != val) {
            code_span.innerHTML = "*您输入的验证码有误";
            $("#code_span").show();
            return false;
        } else {
            code_span.innerHTML = "";
            $("#code_span").hide();
            return true;
        }
    }

    $("#checkbox").click(function () {      //判断是否同意网站协议
        var sub = document.getElementById("submit");
        sub.disabled = !document.getElementById("checkbox").checked;
        if (sub.disabled == true) {
            $("#submit").css("background-color", "#999999").css("border-color", "#999999");
        } else {
            $("#submit").css("background-color", "#F32613").css("border-color", "#F32613");
        }
    });

    $("#name").blur(function () {
        isName();
    });

    $("#code").blur(function () {
        judgeCode();
    });

    $("#code_span_change").click(function () {
        randomCode();
    });

    $("#email").blur(function () {
        isEmail();
    });

    $("#password").blur(function () {
        isPassword();
    });

    $("#isPassword").blur(function () {
        judgePassword();
    });

    $("#submit").click(function () {
        if (isName() && isEmail() && isPassword() && judgePassword() && judgeCode()) {
            var data = {
                "user_name": $("#name").val(),
                "user_password": md5($("#password").val()),   //使用MD5进行加密
                "user_email": $("#email").val(),
            };
            $.ajax({
                type: "post",
                url: "register",
                data: data,
                dataType: "json",
                success: function (res) {
                    $("#name").val("");
                    $("#email").val("");
                    $("#password").val("");
                    $("#isPassword").val("");
                    $("#code").val("");
                    alert("您注册的账号为：" + res);
                },
                error: function (a, b, c) {
                    alert(a.readyState + " " + a.status);
                }
            })
        }
    });

    $(randomCode());    //初始化载入随机验证码
});