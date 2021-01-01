$(document).ready(function () {
    $("#submit").click(function () {    //当点击登录按钮时，再次判断两个条件是否满足
        console.log($("#user_name").val() + " " + $("#password").val());
        var data = {
            "user_name": $("#user_name").val(),
            "user_password": md5($("#password").val())   //使用MD5进行加密
        };
        $.ajax({
            type: "post",
            url: "login",
            data: data,
            dataType: "json",
            success: function (res) {
                if (res == 1) {
                    window.location.assign("homePage.jsp");
                } else {
                    alert("用户名或者密码错误");
                }
            },
            error: function (a, b, c) {
                alert(a.readyState + " " + a.status);
            }
        })
    });
});