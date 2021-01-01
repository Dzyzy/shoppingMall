$(document).ready(function () {

    $("#button10").click(function () {       //修改二级分类
        var classification_name = $("#select101").val();
        var msg = $("#text40").val();
        if (classification_name != "--请选择--" && msg != null && msg != "") {
            $.ajax({
                type: "post",
                url: "shop_10",
                data: {
                    "classification_name": classification_name,
                    "msg": msg
                },
                success: function (res) {
                    $("#text40").val("");
                    alert("修改成功!");
                },
                error: function (a, b, c) {
                    alert(a.readyState + " " + a.status);
                }
            })
        }
    });

    $("#button20").click(function () {       //修改二级分类
        var classification_name = $("#select121").val();
        var msg = $("#text50").val();
        if (classification_name != "--请选择--" && msg != null && msg != "") {
            $.ajax({
                type: "post",
                url: "shop_10",
                data: {
                    "classification_name": classification_name,
                    "msg": msg
                },
                success: function (res) {
                    $("#text50").val("");
                    alert("修改成功!");
                },
                error: function (a, b, c) {
                    alert(a.readyState + " " + a.status);
                }
            })
        }
    });

    $("#button30").click(function () {       //修改三级分类
        var classification_name = $("#select1511").val();
        var msg = $("#text30").val();
        if (classification_name != "--请选择--" && msg != null && msg != "") {
            $.ajax({
                type: "post",
                url: "shop_10",
                data: {
                    "classification_name": classification_name,
                    "msg": msg
                },
                success: function (res) {
                    $("#text30").val("");
                    alert("修改成功!");
                },
                error: function (a, b, c) {
                    alert(a.readyState + " " + a.status);
                }
            })
        }
    });

    $("#select1411").change(function () {      //二级联动三级
        var classification_name = $("#select1411").val();
        $("#select1511").empty();
        $("#select1511").append("<option>--请选择--</option>");
        if (classification_name != "--请选择--") {
            $.ajax({
                type: "post",
                url: "shop_4",
                data: {
                    "classification_name": classification_name
                },
                success: function (res) {
                    var jsonArray = eval(res);
                    console.log(jsonArray);
                    for (var i = 0; i < jsonArray.length; i++) {
                        var innerHtml = "";
                        innerHtml += "<option>" + jsonArray[i].classification_name + "</option>";
                        $("#select1511").append(innerHtml);
                    }
                },
                error: function (a, b, c) {
                    alert(a.readyState + " " + a.status);
                }
            })
        }
    });

    $("#select1311").change(function () {      //一级联动二级
        var classification_name = $("#select1311").val();
        $("#select1411").empty();
        $("#select1411").append("<option>--请选择--</option>");
        if (classification_name != "--请选择--") {
            $.ajax({
                type: "post",
                url: "shop_4",
                data: {
                    "classification_name": classification_name
                },
                success: function (res) {
                    var jsonArray = eval(res);
                    console.log(jsonArray);
                    for (var i = 0; i < jsonArray.length; i++) {
                        var innerHtml = "";
                        innerHtml += "<option>" + jsonArray[i].classification_name + "</option>";
                        $("#select1411").append(innerHtml);
                    }
                },
                error: function (a, b, c) {
                    alert(a.readyState + " " + a.status);
                }
            })
        }
    });


    $("#select111").change(function () {      //一级联动二级
        var classification_name = $("#select111").val();
        $("#select121").empty();
        $("#select121").append("<option>--请选择--</option>");
        if (classification_name != "--请选择--") {
            $.ajax({
                type: "post",
                url: "shop_4",
                data: {
                    "classification_name": classification_name
                },
                success: function (res) {
                    var jsonArray = eval(res);
                    console.log(jsonArray);
                    for (var i = 0; i < jsonArray.length; i++) {
                        var innerHtml = "";
                        innerHtml += "<option>" + jsonArray[i].classification_name + "</option>";
                        $("#select121").append(innerHtml);
                    }
                },
                error: function (a, b, c) {
                    alert(a.readyState + " " + a.status);
                }
            })
        }
    });

    $(".bobyer_class_35").click(function () {
        if (confirm("确认删除该商品吗？") == true) {
            var prod_id = $(this).parent().children(".s1").text();
            $.ajax({
                type: "post",
                url: "shop_9",
                data: {
                    "prod_id": prod_id,
                },
                success: function (res) {
                    alert("删除成功！");
                },
                error: function (a, b, c) {
                    alert(a.readyState + " " + a.status);
                }
            });
        }
    });

    $(".bobyer_class_34").click(function () {
        var prod_id = $(this).parent().children(".s1").text();
        alert(prod_id);
        $("#bobyer_div_01").hide();
        $("#bobyer_div_03").hide();
        $("#bobyer_div_04").hide();
        $("#bobyer_div_05").hide();
        $("#bobyer_div_30").show();
        $.ajax({
            type: "post",
            url: "shop_8",
            data: {
                "prod_id": prod_id,
            },
            success: function (res) {
                console.log(res);
            },
            error: function (a, b, c) {
                alert(a.readyState + " " + a.status);
            }
        })
    });

    $("#xiugai1231").click(function () {
        var img = $("#prod_img1").val();
        var pos = img.lastIndexOf("\\");
        var prod_img = "image/" + img.substring(pos + 1);
        var prod_name = $("#prod_name1").val();
        var prod_desc = $("#prod_desc1").val();
        var prod_price = $("#prod_price1").val();
        var prod_num = $("#prod_num1").val();
        var prod_three_level = $("#select19").val();
        if ($("#prod_img1").val() != "" && prod_name != "" && prod_desc != "" && prod_price != "" && prod_num != "" && prod_three_level != "--请选择--" && $("#prod_img1").val() != null && prod_name != null && prod_desc != null && prod_price != null && prod_num != null && prod_three_level != null) {
            $.ajax({
                type: "post",
                url: "shop_7",
                data: {
                    "prod_img": prod_img,
                    "prod_name": prod_name,
                    "prod_desc": prod_desc,
                    "prod_price": prod_price,
                    "prod_num": prod_num,
                    "prod_three_level": prod_three_level,
                },
                success: function (res) {
                    alert("修改成功！");
                },
                error: function (a, b, c) {
                    alert(a.readyState + " " + a.status);
                }
            })
        }
    });

    $("#select18").change(function () {      //二级联动三级
        var classification_name = $("#select18").val();
        $("#select19").empty();
        $("#select19").append("<option>--请选择--</option>");
        if (classification_name != "--请选择--") {
            $.ajax({
                type: "post",
                url: "shop_4",
                data: {
                    "classification_name": classification_name
                },
                success: function (res) {
                    var jsonArray = eval(res);
                    console.log(jsonArray);
                    for (var i = 0; i < jsonArray.length; i++) {
                        var innerHtml = "";
                        innerHtml += "<option>" + jsonArray[i].classification_name + "</option>";
                        $("#select19").append(innerHtml);
                    }
                },
                error: function (a, b, c) {
                    alert(a.readyState + " " + a.status);
                }
            })
        }
    });

    $("#select17").change(function () {      //一级联动二级
        var classification_name = $("#select17").val();
        $("#select18").empty();
        $("#select18").append("<option>--请选择--</option>");
        if (classification_name != "--请选择--") {
            $.ajax({
                type: "post",
                url: "shop_4",
                data: {
                    "classification_name": classification_name
                },
                success: function (res) {
                    var jsonArray = eval(res);
                    console.log(jsonArray);
                    for (var i = 0; i < jsonArray.length; i++) {
                        var innerHtml = "";
                        innerHtml += "<option>" + jsonArray[i].classification_name + "</option>";
                        $("#select18").append(innerHtml);
                    }
                },
                error: function (a, b, c) {
                    alert(a.readyState + " " + a.status);
                }
            })
        }
    });

    $("#queding").click(function () {
        var img = $("#prod_img").val();
        var pos = img.lastIndexOf("\\");
        var prod_img = "image/" + img.substring(pos + 1);
        var prod_name = $("#prod_name").val();
        var prod_desc = $("#prod_desc").val();
        var prod_price = $("#prod_price").val();
        var prod_num = $("#prod_num").val();
        var prod_three_level = $("#select6").val();
        if ($("#prod_img").val() != "" && prod_name != "" && prod_desc != "" && prod_price != "" && prod_num != "" && prod_three_level != "--请选择--" && $("#prod_img").val() != null && prod_name != null && prod_desc != null && prod_price != null && prod_num != null && prod_three_level != null) {
            $.ajax({
                type: "post",
                url: "shop_6",
                data: {
                    "prod_img": prod_img,
                    "prod_name": prod_name,
                    "prod_desc": prod_desc,
                    "prod_price": prod_price,
                    "prod_num": prod_num,
                    "prod_three_level": prod_three_level,
                },
                success: function (res) {
                    alert("成功上架！");
                },
                error: function (a, b, c) {
                    alert(a.readyState + " " + a.status);
                }
            })
        }
    });

    $("#select5").change(function () {      //二级联动三级
        var classification_name = $("#select5").val();
        $("#select6").empty();
        $("#select6").append("<option>--请选择--</option>");
        if (classification_name != "--请选择--") {
            $.ajax({
                type: "post",
                url: "shop_4",
                data: {
                    "classification_name": classification_name
                },
                success: function (res) {
                    var jsonArray = eval(res);
                    console.log(jsonArray);
                    for (var i = 0; i < jsonArray.length; i++) {
                        var innerHtml = "";
                        innerHtml += "<option>" + jsonArray[i].classification_name + "</option>";
                        $("#select6").append(innerHtml);
                    }
                },
                error: function (a, b, c) {
                    alert(a.readyState + " " + a.status);
                }
            })
        }
    });

    $("#select4").change(function () {      //一级联动二级
        var classification_name = $("#select4").val();
        $("#select5").empty();
        $("#select5").append("<option>--请选择--</option>");
        if (classification_name != "--请选择--") {
            $.ajax({
                type: "post",
                url: "shop_4",
                data: {
                    "classification_name": classification_name
                },
                success: function (res) {
                    var jsonArray = eval(res);
                    console.log(jsonArray);
                    for (var i = 0; i < jsonArray.length; i++) {
                        var innerHtml = "";
                        innerHtml += "<option>" + jsonArray[i].classification_name + "</option>";
                        $("#select5").append(innerHtml);
                    }
                },
                error: function (a, b, c) {
                    alert(a.readyState + " " + a.status);
                }
            })
        }
    });

    $("#button3").click(function () {       //添加三级分类
        var classification_name2 = $("#select3").val();
        var classification_name3 = $("#text3").val();
        if (classification_name2 != "--请选择--" && classification_name3 != "" && classification_name3 != null) {
            $.ajax({
                type: "post",
                url: "shop_5",
                data: {
                    "classification_name2": classification_name2,
                    "classification_name3": classification_name3
                },
                success: function (res) {
                    $("#text3").val("");
                    alert("添加成功!");
                },
                error: function (a, b, c) {
                    alert(a.readyState + " " + a.status);
                }
            })
        }
    });

    $("#select2").change(function () {      //一级联动二级
        var classification_name = $("#select2").val();
        $("#select3").empty();
        $("#select3").append("<option>--请选择--</option>");
        if (classification_name != "--请选择--") {
            $.ajax({
                type: "post",
                url: "shop_4",
                data: {
                    "classification_name": classification_name
                },
                success: function (res) {
                    var jsonArray = eval(res);
                    console.log(jsonArray);
                    for (var i = 0; i < jsonArray.length; i++) {
                        var innerHtml = "";
                        innerHtml += "<option>" + jsonArray[i].classification_name + "</option>";
                        $("#select3").append(innerHtml);
                    }
                },
                error: function (a, b, c) {
                    alert(a.readyState + " " + a.status);
                }
            })
        }

    });

    $("#button2").click(function () {       //添加二级分类
        var classification_name1 = $("#select1").val();
        var classification_name2 = $("#text2").val();
        if (classification_name1 != "--请选择--" && classification_name2 != "" && classification_name2 != null) {
            $.ajax({
                type: "post",
                url: "shop_3",
                data: {
                    "classification_name1": classification_name1,
                    "classification_name2": classification_name2
                },
                success: function (res) {
                    $("#text2").val("");
                    alert("添加成功!");
                    console.log(res);
                },
                error: function (a, b, c) {
                    alert(a.readyState + " " + a.status);
                }
            })
        }
    });

    $("#button1").click(function () {       //添加一级分类
        var classification_name = $("#text1").val();
        if (classification_name != "" && classification_name != null) {
            $.ajax({
                type: "post",
                url: "shop_2",
                data: {
                    "classification_name": classification_name,
                },
                success: function (res) {
                    $("#text1").val("");
                    alert("添加成功!");
                    console.log(res);
                },
                error: function (a, b, c) {
                    alert(a.readyState + " " + a.status);
                }
            })
        }
    });

    $("#span1").click(function () {     //四个大标签的显示和隐藏
        $("#bobyer_div_01").show();
        $("#bobyer_div_03").hide();
        $("#bobyer_div_04").hide();
        $("#bobyer_div_05").hide();
        $("#bobyer_div_30").hide();
    });
    $("#span2").click(function () {
        $("#bobyer_div_01").hide();
        $("#bobyer_div_03").show();
        $("#bobyer_div_04").hide();
        $("#bobyer_div_05").hide();
        $("#bobyer_div_30").hide();
    });
    $("#span3").click(function () {
        $("#bobyer_div_01").hide();
        $("#bobyer_div_03").hide();
        $("#bobyer_div_04").show();
        $("#bobyer_div_05").hide();
        $("#bobyer_div_30").hide();
    });
    $("#span4").click(function () {
        $("#bobyer_div_01").hide();
        $("#bobyer_div_03").hide();
        $("#bobyer_div_04").hide();
        $("#bobyer_div_05").show();
        $("#bobyer_div_30").hide();
    });

    $(".bobyer_class_24").click(function () {       //发货
        if (confirm("是否发货？") == true) {
            var prod_id = $(this).parent().children(".bobyer_class_51").text();
            var orders_id = $(this).parent().children(".bobyer_class_50").text();
            $.ajax({
                type: "post",
                url: "shop_1",
                data: {
                    "prod_id": prod_id,
                    "orders_id": orders_id,
                },
                success: function (res) {
                    window.location.href = "shop";
                    console.log(res);
                },
                error: function (a, b, c) {
                    alert(a.readyState + " " + a.status);
                }
            })
        }
    });
});