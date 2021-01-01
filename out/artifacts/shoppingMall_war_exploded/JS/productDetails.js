$(document).ready(function () {
    $(".bobyer_class_img").mouseenter(function () {      //鼠标移入小相册，大相册就更换路径
        var img = document.getElementById("bobyer_img_01");
        img.src = this.alt;
        var list = $(".bobyer_class_img");
        for (var i = 0; i < list.length; i++) {
            $(list[i]).css("border-color", "white");
        }
        this.style.borderColor = "#ff4400";
    });

    $(".class_span_03").click(function () {     //实现规格的选中，以及边框变色
        var list = $(".class_span_03");
        for (var i = 0; i < list.length; i++) {
            if ("rgb(255, 68, 0)" == $(list[i]).css("border-color") && list[i] == this) {    //判断是否是同一对象，并且颜色相同
                $(this).css("border-color", "#e3e4e5");
                return;
            }
            $(list[i]).css("border-color", "#e3e4e5");
        }
        $(this).css("border-color", "#ff4400");
    });

    $("#less").click(function () {      //减按钮
        var num = document.getElementById("num");
        num.value = num.value - 1;
        if (num.value <= 0) {
            num.value = 1;
        }
    });

    $("#plus").click(function () {      //加按钮
        var num = document.getElementById("num");
        num.value = parseInt(num.value) + 1;        //必须转换成整型，不然是按字符串来计算
        var loc = location.href;
        var len1 = loc.length;
        var len2 = loc.indexOf("=");
        var val = decodeURI(loc.substr(len2 + 1, len1 - len2));     //第一个参数是从哪个位置开始，第二个参数是取多长
        console.log(val);
        $.ajax({
            type: "post",
            url: "prodectDetails",
            data: {
                "prod_name": val,
                "mark": "0",
            },
            dataType: "json",
            success: function (res) {
                console.log(res);
                var jsonObject = eval(res);
                var prod_num = jsonObject.prod_num;
                if (num.value > prod_num) {
                    num.value = prod_num;
                    alert("最大库存为：" + prod_num);
                }
            },
            error: function (a, b, c) {
                console.log(a.readyState + a.status);
            }
        });
    });

    $("#num").blur(function () {        //手动修改数量
        var num = $("#num").val();
        var loc = location.href;
        var len1 = loc.length;
        var len2 = loc.indexOf("=");
        var val = decodeURI(loc.substr(len2 + 1, len1 - len2));     //第一个参数是从哪个位置开始，第二个参数是取多长
        console.log(val);
        $.ajax({
            type: "post",
            url: "prodectDetails",
            data: {
                "prod_name": val,
                "mark": "0",
            },
            dataType: "json",
            success: function (res) {
                console.log(res);
                var jsonObject = eval(res);
                var prod_num = jsonObject.prod_num;
                if (num > prod_num) {
                    alert("最大库存为：" + prod_num);
                    $("#num").val(prod_num);
                } else if (num <= 0) {
                    $("#num").val("1");
                }
            },
            error: function (a, b, c) {
                console.log(a.readyState + a.status);
            }
        });
    });

    $("#buy").click(function () {           //立即购买
        var loc = location.href;
        var len1 = loc.length;
        var len2 = loc.indexOf("=");
        var val = decodeURI(loc.substr(len2 + 1, len1 - len2));     //第一个参数是从哪个位置开始，第二个参数是取多长
        console.log(val);
        $.ajax({
            type: "post",
            url: "prodectDetails",
            data: {
                "prod_name": val,
                "prod_count": $("#num").val(),
                "mark": "3",
            },
            dataType: "json",
            success: function (res) {
                console.log(res);
                window.location.assign("orders.jsp?index=1")
            },
            error: function (a, b, c) {
                console.log(a.readyState + a.status);
            }
        });
    });

    $("#join").click(function () {      //添加购物车
        var loc = location.href;
        var len1 = loc.length;
        var len2 = loc.indexOf("=");
        var val = decodeURI(loc.substr(len2 + 1, len1 - len2));     //第一个参数是从哪个位置开始，第二个参数是取多长
        console.log(val);
        alert("添加成功");
        var prod_count = $("#num").val();
        $.ajax({
            type: "post",
            url: "prodectDetails",
            data: {
                "prod_name": val,
                "prod_count": prod_count,
                "mark": "2",
            },
            dataType: "json",
            success: function (res) {
                console.log(res);
            },
            error: function (a, b, c) {
                alert(a.readyState + " " + a.status);
            }
        })
    });

    $(function () {         //初始化
        var loc = location.href;
        var len1 = loc.length;
        var len2 = loc.indexOf("=");
        var val = decodeURI(loc.substr(len2 + 1, len1 - len2));     //第一个参数是从哪个位置开始，第二个参数是取多长
        console.log(val);

        $.ajax({
            type: "post",
            url: "prodectDetails",
            data: {
                "prod_name": val,
                "mark": "4",
            },
            dataType: "json",
            success: function (res) {
                var jsonArray = eval(res);
                console.log(jsonArray);
                var innerHtml = "";
                for (var i = 0; i < jsonArray.length; i++) {
                    var id = parseInt(i) + 1;
                    var innerHtml = "";
                    innerHtml += "<tr><td><span id=\"td" + id + "\"></span></td></tr>";
                    $("#tabler").append(innerHtml);
                    $("#td" + id).html(jsonArray[i].msg);
                }
            },
            error: function (a, b, c) {
                alert(a.readyState + a.status);
            }
        })

        $.ajax({
            type: "post",
            url: "prodectDetails",
            data: {
                "prod_name": val,
                "mark": "1",
            },
            dataType: "json",
            success: function (res) {
                console.log(res);
                var jsonObject = eval(res);
                $("#name").html(jsonObject.prod_name);
                $("#price").html("￥" + jsonObject.prod_price);
                $("#shop").html(jsonObject.shop_name);
                $("#bobyer_img_01").attr("src", jsonObject.prod_img);
                $("#address").html(jsonObject.user_address);
                $("#desc").html(jsonObject.prod_desc);
            },
            error: function (a, b, c) {
                alert(a.readyState + a.status);
            }
        });

    });
});