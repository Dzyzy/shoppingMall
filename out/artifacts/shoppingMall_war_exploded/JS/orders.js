$(document).ready(function () {
    $(function () {
        var loc = location.href;
        var len1 = loc.length;
        var len2 = loc.indexOf("=");
        var val = decodeURI(loc.substr(len2 + 1, len1 - len2));     //第一个参数是从哪个位置开始，第二个参数是取多长
        console.log(val);
        if (val == 2) {       //购物车传过来
            $.ajax({
                type: "post",
                url: "orders",
                data: {
                    "mark": 2,
                },
                dataType: "json",
                success: function (res) {
                    var jsonArray = eval(res);
                    var sum = 0;
                    for (var i = 0; i < jsonArray.length; i++) {
                        var innerHtml = "";
                        var id = parseInt(i) + 1;
                        innerHtml += "<li class=\"bobyer_class_17\">";
                        innerHtml += "<div class=\"bobyer_class_02\">";
                        innerHtml += "<img id=\"bobyer_img_" + id + "\" class=\"bobyer_class_03\" src=\"\">";
                        innerHtml += "<div class=\"bobyer_class_04\">";
                        innerHtml += "<span id=\"bobyer_span01_" + id + "\" class=\"bobyer_class_05\"></span>";
                        innerHtml += "</div>";
                        innerHtml += "<span class=\"bobyer_class_06\">￥<span id=\"bobyer_span02_" + id + "\" class=\"bobyer_class_07\"></span></span>";
                        innerHtml += "<span id=\"bobyer_span03_" + id + "\" class=\"bobyer_class_08\"></span>";
                        innerHtml += "<span  class=\"bobyer_class_09\">￥<span id=\"bobyer_span04_" + id + "\" class=\"bobyer_class_10\"></span></span>";
                        innerHtml += "</div>";
                        innerHtml += "</li>";

                        $("#bobyer_ul").append(innerHtml);
                        var name = "#bobyer_img_" + id;
                        $(name).attr("src", jsonArray[i].prod_img);
                        name = "#bobyer_span01_" + id;
                        $(name).html(jsonArray[i].prod_name);
                        name = "#bobyer_span02_" + id;
                        $(name).html(jsonArray[i].prod_price);
                        name = "#bobyer_span03_" + id;
                        $(name).html(jsonArray[i].prod_count);
                        name = "#bobyer_span04_" + id;
                        $(name).html(parseFloat(jsonArray[i].prod_count) * parseFloat(jsonArray[i].prod_price));

                        sum += parseFloat(jsonArray[i].prod_count) * parseFloat(jsonArray[i].prod_price);
                    }

                    $(".bobyer_class_12").html(jsonArray.length);
                    $(".bobyer_class_15").html(sum);
                },
                error: function (a, b, c) {
                    alert(a.readyState + " " + a.status);
                }
            })
        } else {
            $.ajax({
                type: "post",
                url: "orders",
                data: {
                    "mark": 1,
                },
                dataType: "json",
                success: function (res) {
                    var jsonObject = eval(res);
                    console.log(jsonObject);
                    var innerHtml = "";
                    var id = 1;
                    innerHtml += "<li class=\"bobyer_class_17\">";
                    innerHtml += "<div class=\"bobyer_class_02\">";
                    innerHtml += "<img id=\"bobyer_img_" + id + "\" class=\"bobyer_class_03\" src=\"\">";
                    innerHtml += "<div class=\"bobyer_class_04\">";
                    innerHtml += "<span id=\"bobyer_span01_" + id + "\" class=\"bobyer_class_05\"></span>";
                    innerHtml += "</div>";
                    innerHtml += "<span class=\"bobyer_class_06\">￥<span id=\"bobyer_span02_" + id + "\" class=\"bobyer_class_07\"></span></span>";
                    innerHtml += "<span id=\"bobyer_span03_" + id + "\" class=\"bobyer_class_08\"></span>";
                    innerHtml += "<span  class=\"bobyer_class_09\">￥<span id=\"bobyer_span04_" + id + "\" class=\"bobyer_class_10\"></span></span>";
                    innerHtml += "</div>";
                    innerHtml += "</li>";

                    console.log(jsonObject);

                    $("#bobyer_ul").append(innerHtml);
                    var name = "#bobyer_img_" + id;
                    $(name).attr("src", jsonObject.prod_img);
                    name = "#bobyer_span01_" + id;
                    $(name).html(jsonObject.prod_name);
                    name = "#bobyer_span02_" + id;
                    $(name).html(jsonObject.prod_price);
                    name = "#bobyer_span03_" + id;
                    $(name).html(jsonObject.prod_count);
                    name = "#bobyer_span04_" + id;
                    $(name).html(parseFloat(jsonObject.prod_count) * parseFloat(jsonObject.prod_price));

                    $(".bobyer_class_12").html(1);
                    $(".bobyer_class_15").html(parseFloat(jsonObject.prod_count) * parseFloat(jsonObject.prod_price));
                },
                error: function (a, b, c) {
                    alert(a.readyState + " " + a.status);
                }
            })
        }

    });

    $("#bobyer_div_02").click(function () {
        if ($("#bobyer_text_01").val() == "" || $("#bobyer_text_01").val() == null || $("#bobyer_text_02").val() == "" || $("#bobyer_text_02").val() == null) {
            alert("地址或者联系方式不能为空...");
        } else {
            var arr = $("#bb_9").siblings();
            var arr_name = [];
            var arr_count = [];
            for (var i = 1; i < arr.length; i++) {
                var prod_name = $(arr[i]).children(".bobyer_class_02").children(".bobyer_class_04").children(".bobyer_class_05").text();
                var prod_count = $(arr[i]).children(".bobyer_class_02").children(".bobyer_class_08").text();
                arr_name.push(prod_name);
                arr_count.push(prod_count);
            }
            console.log(arr_name);
            console.log(arr_count);

            $.ajax({
                type: "post",
                url: "orders",
                data: {
                    "arr_name": "" + arr_name,
                    "arr_count": "" + arr_count,
                    "totalAmount": $(".bobyer_class_15").text(),
                    "mark": "3",
                },
                dataType: "json",
                success: function (res) {
                    alert("提交成功");
                },
                error: function (a, b, c) {
                    alert(a.readyState + " " + a.status);
                }
            })
        }
    });
});