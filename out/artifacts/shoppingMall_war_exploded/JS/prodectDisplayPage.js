$(document).ready(function () {
    $("#a2").change(function () {
        var num = $("#a2").val();
        tt(num);
    });

    function tt(num) {
        $.ajax({
            type: "post",
            url: "fengye",
            data: {
                "num": num,
            },
            dataType: "json",
            success: function (res) {
                var jsonArray = eval(res);
                $("#bobyer").children(".class_div_01").remove();
                for (var i = 0; i < jsonArray.length; i++) {
                    var innerHtml = "";
                    innerHtml += "<div class=\"class_div_01\">";
                    innerHtml += "<img class=\"class_img_01\" src=" + jsonArray[i].prod_img + " >";
                    innerHtml += "<p class=\"class_p_02\">" + jsonArray[i].prod_name + "</p>"
                    innerHtml += "<span class=\"class_span_01\">" + "￥" + jsonArray[i].prod_price + "</span>"
                    innerHtml += "</div>";

                    $("#bobyer").append(innerHtml);
                }
            },
            error: function (a, b, c) {
                alert(a.readyState + " " + a.status);
            }
        })
    }

    $(function () {
        tt(1);
    })


    $("#a1").click(function () {
        var num = parseInt($("#a2").val()) - 1;
        if (num <= 0) {
            num = 1;
        }
        $("#a2").val(num);
        tt(num);
    });

    $("#a3").click(function () {
        var num = parseInt($("#a2").val()) + 1;
        $("#a2").val(num);
        tt(num);
    });

    $(document).on("mouseover", ".class_div_01",      //通过鼠标移入改变其边框颜色
        function () {
            $(this).css('border-color', 'red');
        }
    );

    $(document).on("mouseout", ".class_div_01",                       //通过鼠标移出还原颜色
        function () {
            $(this).css('border-color', '#f5f5f5');
        }
    );

    $(document).on("click", ".class_img_01", function () {      //单价热卖商品跳转到信息页面
        var val = "";
        val += $(this).parent().children(".class_p_02").text();
        var url = location.href = "productDetails.jsp?" + "index=" + encodeURI(val);
        window.location.assign(url);
    });

    $(".uio").click(function () {
        var msg = $(this).text();
        $.ajax({
            type: "post",
            url: "findprod",
            data: {
                "msg": msg,
            },
            dataType: "json",
            success: function (res) {
                var jsonArray = eval(res);
                $("#bobyer").children(".class_div_01").remove();
                for (var i = 0; i < jsonArray.length; i++) {
                    var innerHtml = "";
                    innerHtml += "<div class=\"class_div_01\">";
                    innerHtml += "<img class=\"class_img_01\" src=" + jsonArray[i].prod_img + " >";
                    innerHtml += "<p class=\"class_p_02\">" + jsonArray[i].prod_name + "</p>"
                    innerHtml += "<span class=\"class_span_01\">" + jsonArray[i].prod_price + "</span>"
                    innerHtml += "</div>";

                    $("#bobyer").append(innerHtml);
                }
            },
            error: function (a, b, c) {
                alert(a.readyState + " " + a.status);
            }
        })
    });
});