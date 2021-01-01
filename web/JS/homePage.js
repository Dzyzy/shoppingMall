$(document).ready(function () {

    $(".asdfg").click(function () {
        var classification_id = $(this).parent().children(".asdf").text();
        var msg = $(this).text();
        $.ajax({
            type: "post",
            url: "findChildren",
            data: {
                "classification_id": classification_id,
            },
            success: function (res) {
                $.ajax({
                    type: "post",
                    url: "findprod",
                    data: {
                        "msg": msg,
                    },
                    dataType: "json",
                    success: function (res) {
                        window.location.assign("prodectDisplayPage.jsp");
                    },
                    error: function (a, b, c) {
                        alert(a.readyState + " " + a.status);
                    }
                })
            },
            error: function (a, b, c) {
                alert(a.readyState + " " + a.status);
            }
        })
    });

    $("#shop_1").click(function () {        //开店
        if (confirm("是否开店？") == true) {
            var msg = prompt("请输入店名：", "");
            if (msg != null && msg != "") {
                $.ajax({
                    type: "post",
                    url: "homePage",
                    data: {
                        "shop_name": msg,
                        "mark": "1",
                    },
                    success: function (res) {
                        alert(res);
                    },
                    error: function (a, b, c) {
                        alert(a.readyState + " " + a.status);
                    }
                })
            }
        }
    });

    $("#header_button_01").click(function () {      //搜索按钮
        var val = $("#header_text_01").val();
        if (val != null && val != "") {
            $.ajax({
                type: "post",
                url: "prodectDisplayPage",
                data: {
                    "msg": val,
                    "mark": "0",
                },
                dataType: "json",
                success: function (res) {
                    window.location.assign("prodectDisplayPage.jsp");
                },
                error: function (a, b, c) {
                    alert(a.readyState + " " + a.status);
                }
            })
        }
    });

    $(".bobyer_class_01").hover(    //进入li标签显示/隐藏得多级分类
        function () {
            $(this).children('div.bobyer_class_li_div_01').css('display', 'block');     //通过css显示多级分类
            $(this).css('background-color', 'white').css('color', '#0fa0ec');       //背景颜色改变为白色，字体为蓝色
            $(this).children('span').children('a').css('color', '#0fa0ec');         //设置超链接里面的字体颜色为蓝色
            $("#bobyer_li_01").css('background', '#0fa0ec');                        //最上面的那行样式不改变颜色
        },
        function () {
            $(this).children('div.bobyer_class_li_div_01').css('display', 'none');      //通过css隐藏多级分类
            $(this).css('background-color', '#0fa0ec').css('color', 'white');           //背景颜色还原成蓝色，字体还原成白色
            $(this).children('span').children('a').css('color', 'white');               //超链接字体还原成白色
        }
    );

    $(".class_div_01").mouseover(       //通过鼠标移入改变其边框颜色
        function () {
            $(this).css('border-color', 'red');
        }
    ).mouseout(                      //通过鼠标移出还原颜色
        function () {
            $(this).css('border-color', '#f5f5f5');
        }
    );

    $(".class_img_01").click(function () {      //单价热卖商品跳转到信息页面
        var val = "";
        val += $(this).parent().children(".class_p_02").text();
        var url = location.href = "productDetails.jsp?" + "index=" + encodeURI(val);
        window.location.assign(url);
    });

    $(function () {             //初始化
        $.ajax({
            type: "post",
            url: "homePage",
            data: {
                "mark": "2",
            },
            dataType: "json",
            success: function (res) {
                console.log(res);
                var jsonArray = eval(res);  //将json字符串转换成json对象数组
                for (var i = 0; i < jsonArray.length; i++) {
                    var id = "#prod_p_" + (i + 1);
                    $(id).text(jsonArray[i].prod_name);
                    id = "#prod_span01_" + (i + 1);
                    $(id).text("￥" + jsonArray[i].prod_price);
                    id = "#prod_img_" + (i + 1);
                    $(id).attr("src", jsonArray[i].prod_img);
                }
            },
            error: function (a, b, c) {
                alert(a.readyState + " " + a.status);
            }
        });
    });
});