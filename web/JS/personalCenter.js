$(document).ready(function () {
    $("#span1").click(function () {
        $("#bobyer_div_01").show();
        $("#bobyer_div_03").hide();
    });

    $("#span2").click(function () {
        $("#bobyer_div_03").show();
        $("#bobyer_div_01").hide();
    });

    function updateStatu(orders_id) {       //修改订单状态，并刷新页面
        $.ajax({
            type: "post",
            url: "personalCenter",
            data: {
                "orders_id": orders_id,
                "mark": "1"
            },
            success: function (res) {
                window.location.assign("personalCenter.jsp");
            },
            error: function (a, b, c) {
                alert(a.readyState + " " + a.status);
            }
        })
    }

    function updatePingjia(orders_id, prod_id) {
        $.ajax({
            type: "post",
            url: "personalCenter",
            data: {
                "orders_id": orders_id,
                "prod_id": prod_id,
                "mark": "4",
            },
            success: function (res) {
                window.location.assign("personalCenter.jsp");
            },
            error: function (a, b, c) {
                alert(a.readyState + " " + a.status);
            }
        })
    }

    $(".bobyer_class_24").click(function () {       //评价商品，确认收货
        var orders_id = $(this).parent().children(".bobyer_class_21").text();
        var prod_id = $(this).parent().children(".bobyer_class_23").text();
        var prod_pingjia = $(this).parent().children(".bobyer_class_26").text();

        if (prod_pingjia == 2) {
            var msg = prompt("评价商品：", "");
            if (msg != "" && msg != null) {
                updatePingjia(orders_id, prod_id);
                $.ajax({
                    type: "post",
                    url: "personalCenter",
                    data: {
                        "mark": "2",
                        "msg": msg,
                        "prod_id": prod_id,
                        "orders_id": orders_id
                    },
                    success: function (res) {

                    },
                    error: function (a, b, c) {
                        alert(a.readyState + " " + a.status);
                    }
                })
            }
        } else if (prod_pingjia == 1) {
            if (confirm("你确认收货吗？") == true) {
                updatePingjia(orders_id, prod_id);
            }
        }

    })

    $(".bobyer_class_18").click(function () {
        var orders_id = $(this).parent().children(".bobyer_class_21").text();
        var orders_statu = $(this).parent().children(".bobyer_class_22").text();
        var prod_id = $(this).parent().children(".bobyer_class_23").text();
        var prod_pingjia = $(this).parent().children(".bobyer_class_26").text();
        if (orders_statu == 1) {
            var msg = "你确认付款吗？";
            if (confirm(msg) == true) {
                updateStatu(orders_id);
            }
        }
    })

    $("#queding").click(function () {       //修改个人信息
        var user_name = $("#user_name").val();
        var password = md5($("#password").val());
        var phone = $("#phone").val();
        var address = $("#address").val();
        if (user_name != "" && $("#password").val() != "" && phone != "" && address != "" && user_name != null && $("#password").val() != null && phone != null && address != null) {
            $.ajax({
                type: "post",
                url: "personalCenter",
                data: {
                    "user_name": user_name,
                    "password": password,
                    "phone": phone,
                    "address": address,
                    "mark": "3"
                },
                success: function (res) {
                    alert("修改成功！");
                    window.location.assign("personalCenter.jsp");
                },
                error: function (a, b, c) {
                    alert(a.readyState + " " + b.status);
                }
            })
        }
    });
});