$(document).ready(function () {
    $("#bobyer_div_03").click(function () {         //点击结算按钮
        if ($("#bobyer_span_06").text() > 0) {
            var arr = $("li.bobyer_class_11").siblings();
            var arr_name = [];
            for (var i = 0; i < arr.length; i++) {
                var checkboxs = $(arr[i]).children(".bobyer_class_01").children(".bobyer_class_12");
                if ($(checkboxs).prop("checked")) {
                    var p = $(arr[i]).children(".bobyer_class_01").children(".class_3").children(".class_4").text();
                    arr_name.push(p);
                }
            }
            $.ajax({
                type: "post",
                url: "shoppingCart",
                data: {
                    "arr_name": "" + arr_name,
                    "mark": "4",
                },
                dataType: "json",
                success: function (res) {
                    console.log(res);
                    window.location.assign("orders.jsp?index=2")
                },
                error: function (a, b, c) {
                    alert(a.readyState + " " + a.status);
                }
            })
        } else {
            alert("亲，您还有有选择要购买的商品");
        }
    });

    $("#bobyer_botton_01").click(function () {      //删除所有选中的标签li
        var arr = $("li.bobyer_class_11").siblings();
        var cnt = 0;
        for (var i = 0; i < arr.length; i++) {
            var checkboxs = $(arr[i]).children(".bobyer_class_01").children(".bobyer_class_12");
            if ($(checkboxs).prop("checked")) {
                $(arr[i]).remove();
                cnt++;
            }
            var prod_name = $(arr[i]).children(".bobyer_class_01").children(".class_3").children(".class_4").text();
            deleteShoppingCart(prod_name);
        }
        alert("删除成功");
        if (cnt == arr.length) {     //如果全部删掉了，就把全选取消选中
            $("#checkbox").prop("checked", false);
        }
        calculatedAmount();
        calculatedQuantity();
    });

    function deleteShoppingCart(prod_name) {        //删除购物车中的商品
        $.ajax({
            type: "post",
            url: "shoppingCart",
            data: {
                "prod_name": prod_name,
                "mark": "2"
            },
            dataType: "json",
            success: function (res) {
                console.log(res);
            },
            error: function (a, b, c) {
                alert(a.readyState + " " + a.status);
            }
        });
    }

    $(document).on("click", ".bobyer_class_08", function () {       //删除当前标签li
        var prod_name = $(this).parent().children(".class_3").children(".class_4").text();
        deleteShoppingCart(prod_name);
        alert("删除成功");
        $($(this).parent().parent()).remove();
        judgeSelectAll();
        calculatedAmount();
        calculatedQuantity();
    });

    $("#checkbox").click(function () {      //点击全选按钮
        var arr = $("li.bobyer_class_11").siblings();
        for (var i = 0; i < arr.length; i++) {
            var checkboxs = $(arr[i]).children(".bobyer_class_01").children(".bobyer_class_12");
            if ($(this).prop("checked")) {
                $(checkboxs).prop("checked", true);
            } else {
                $(checkboxs).prop("checked", false);
            }
        }
        calculatedAmount();
        calculatedQuantity();
    });

    function judgeSelectAll() {     //判断是全选
        var arr = $("li.bobyer_class_11").siblings();
        var i;
        for (i = 0; i < arr.length; i++) {
            var checkboxs = $(arr[i]).children(".bobyer_class_01").children(".bobyer_class_12");
            if (!$(checkboxs).prop("checked")) {
                break;
            }
        }
        if (i == arr.length && arr.length > 0) {
            $("#checkbox").prop("checked", true);
        } else {
            $("#checkbox").prop("checked", false);
        }
    }

    $(document).on("click", ".bobyer_class_12", function () {   //选中/取消此项
        if ($(this).prop("checked")) {
            $(this).prop("checked", true);
            judgeSelectAll();
        } else {
            $(this).prop("checked", false);
            if ($(checkbox).prop("checked")) {
                $(checkbox).prop("checked", false);
            }
        }
        calculatedAmount();
        calculatedQuantity();
    });

    function updateProdNum(prod_count, prod_name) {     //修改动态增减的数量
        $.ajax({
            type: "post",
            url: "shoppingCart",
            data: {
                "prod_count": prod_count,
                "prod_name": prod_name,
                "mark": "3",
            },
            dataType: "json",
            success: function (res) {

            },
            error: function (a, b, c) {
                alert(a.readyState + " " + a.status);
            }
        })
    }

    function modiifedAmount(tt) {     //判断是否过界,以及修改总金额
        var num = $(tt).parent().children(".bobyer_class_03").children(".num");
        var unitPrice = $(tt).parent().children(".bobyer_class_04").children(".bobyer_class_05").text();
        var totalPrice = $(tt).parent().children(".bobyer_class_06").children(".bobyer_class_07");
        var prod_name = $(tt).parent().children(".class_3").children(".class_4").text();
        var cnt;
        $.ajax({
            type: "post",
            url: "shoppingCart",
            data: {
                "pord_name": prod_name,
                "mark": "1",
            },
            dataType: "json",
            success: function (res) {
                console.log(res);
                var prod_num = parseInt(res);

                if (num.val() <= 0) {
                    num.val("1");
                    totalPrice.html(unitPrice);
                    cnt = 1;
                } else if (num.val() > prod_num) {
                    num.val(prod_num);
                    totalPrice.html(parseFloat(prod_num) * parseFloat(unitPrice));
                    cnt = prod_num;
                    alert("最大库存为：" + prod_num);
                } else {
                    totalPrice.html(parseFloat(num.val()) * parseFloat(unitPrice));
                    cnt = num.val();
                }
                updateProdNum(cnt, prod_name);
                calculatedAmount();
            },
            error: function (a, b, c) {
                alert(a.readyState + " " + a.status);
            }
        })
    }

    function calculatedAmount() {       //计算总金额
        var arr = $("li.bobyer_class_11").siblings();
        var sum = 0;
        for (var i = 0; i < arr.length; i++) {
            var unitPrice = $(arr[i]).children(".bobyer_class_01").children(".bobyer_class_04").children(".bobyer_class_05").text();
            var num = $(arr[i]).children(".bobyer_class_01").children(".bobyer_class_03").children(".num");
            var checkboxs = $(arr[i]).children(".bobyer_class_01").children(".bobyer_class_12");
            if ($(checkboxs).prop("checked")) {
                sum = parseFloat(sum) + parseFloat(num.val()) * parseFloat(unitPrice);
            }
        }
        $("#bobyer_span_08").html(parseFloat(sum));
    }

    function calculatedQuantity() {     //计算要购买的数量
        var arr = $("li.bobyer_class_11").siblings();
        var count = 0;
        for (var i = 0; i < arr.length; i++) {
            var checkboxs = $(arr[i]).children(".bobyer_class_01").children(".bobyer_class_12");
            if ($(checkboxs).prop("checked")) {
                count = parseInt(count) + 1;
            }
        }
        $("#bobyer_span_06").html(count);
    }

    $(document).on("blur", ".num", function () {     //当手动修改数量时，改变总价格
        modiifedAmount($(this).parent());
    });

    $(document).on("click", ".plus", function () {   //加按钮
        var num = $(this).parent().children(".bobyer_class_03").children(".num");
        num.val(parseInt(num.val()) + 1);
        modiifedAmount(this);
    });

    $(document).on("click", ".less", function () {   //减按钮
        var num = $(this).parent().children(".bobyer_class_03").children(".num");
        num.val(parseInt(num.val()) - 1);
        modiifedAmount(this);
    });

    function statisticalAmount() {      //初始化加载总金额
        var arr = $("li.bobyer_class_11").siblings();
        var sum = 0;
        for (var i = 0; i < arr.length; i++) {
            var checkboxs = $(arr[i]).children(".bobyer_class_01").children(".bobyer_class_12");
            if ($(checkboxs).prop("checked")) {
                var totalPrice = $(arr[i]).children(".bobyer_class_01").children(".bobyer_class_06").children(".bobyer_class_07").text();
                sum = parseFloat(sum) + parseFloat(totalPrice);
            }
        }
        $("#bobyer_span_08").html(sum);
    }

    $(function () {     //初始化
        var jsonArray;
        $.ajax({
            type: "post",
            url: "shoppingCart",
            data: {
                "mark": "0",
            },
            dataType: "json",
            success: function (res) {
                jsonArray = eval(res);
                console.log(jsonArray);
                for (var i = 0; i < jsonArray.length; i++) {
                    var id = parseInt(i) + 1;
                    var innerHtml = "";
                    innerHtml += "<li class=\"bobyer_class_10\">";
                    innerHtml += "<div class=\"bobyer_class_01\">";
                    innerHtml += "<input id=\"bobyer_checkbox_1\" type=\"checkbox\" class=\"bobyer_class_12 class_1\">";
                    innerHtml += "<img id=\"bobyer_img_" + id + "\" class=\"bobyer_class_02 class_2\" src=\"\" >";
                    innerHtml += "<div id=\"bobyer_div01_1\" class=\"class_3\">";
                    innerHtml += "<span id=\"bobyer_span_" + id + "\" class=\"class_4\">";
                    innerHtml += "</span>";
                    innerHtml += "</div>";
                    innerHtml += "<span id=\"bobyer_span01_1\" class=\"bobyer_class_04 class_5\">￥<span id=\"bobyer_span001_" + id + "\" class=\"bobyer_class_05\"></span></span>";
                    innerHtml += "<input id=\"bobyer_botton01_1\" class=\"less class_6\" type=\"button\" value=\"-\">";
                    innerHtml += "<div id=\"bobyer_div02_1\" class=\"bobyer_class_03 class_7\">";
                    innerHtml += "<input id=\"bobyer_num_" + id + "\" class=\"num\" type=\"text\" value=\"1\">";
                    innerHtml += "</div>";
                    innerHtml += "<input id=\"bobyer_botton02_1\" class=\"plus class_9\" type=\"button\" value=\"+\">";
                    innerHtml += "<span id=\"bobyer_span02_1\" class=\"bobyer_class_06 class_10\" >￥<span id=\"bobyer_span002_" + id + "\" class=\"bobyer_class_07\"></span></span>";
                    innerHtml += "<input id=\"bobyer_botton03_1\" class=\"bobyer_class_08 class_11\" type=\"button\" value=\"删除\">";
                    innerHtml += "</div>";
                    innerHtml += "</li>";

                    $("#bobyer_ul").append(innerHtml);
                    var name = "#bobyer_img_" + id;
                    $(name).attr("src", jsonArray[i].prod_img);
                    name = "#bobyer_span_" + id;
                    $(name).html(jsonArray[i].prod_name);
                    name = "#bobyer_span001_" + id;
                    $(name).html(jsonArray[i].prod_price);
                    name = "#bobyer_num_" + id;
                    $(name).val(jsonArray[i].prod_count);
                    name = "#bobyer_span002_" + id;
                    $(name).html(parseFloat(jsonArray[i].prod_count) * parseFloat(jsonArray[i].prod_price));
                }
            },
            error: function (a, b, c) {
                alert(a.readyState + " " + a.status);
            }
        })
        statisticalAmount();
        calculatedQuantity();
    })
});