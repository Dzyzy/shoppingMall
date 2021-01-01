<%@ page import="java.util.List" %>
<%@ page import="Util.classifica" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link type="text/css" href="CSS/homePage.css" rel="stylesheet">
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <script type="text/javascript" src="JS/homePage.js" rel="stylesheet"></script>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>无忧商城</title>
</head>
<body>
<div id="shortcut">
    <span id="shortcut_span_01">您好，欢迎来到无忧商城！</span>
    <%
        Object user_id = session.getAttribute("user_id");
        Object user_name = session.getAttribute("user_name");
        Object user_isshop = session.getAttribute("user_isshop");
    %>
    <% if (user_id != null) { %>
    <span id="shortcut_span_02" class="shortcut_class_01"><a class="shortcut_class_01">${user_name}</a></span>
    <a href="register.jsp" class="shortcut_class_01">免费注册</a>
    <a href="personalCenter.jsp" class="shortcut_class_01">个人中心</a>
    <a href="" class="shortcut_class_01">消息</a>
    <a href="shoppingCart.jsp" class="shortcut_class_01">购物车</a>
    <a href="" class="shortcut_class_01">收藏夹</a>
    <% if (user_isshop.equals("0")) { %>
    <a href="" id="shop_1" class="shortcut_class_01">免费开店</a>
    <% } else { %>
    <a href="shop" id="shop_2" class="shortcut_class_01">我的店铺</a>
    <% } %>
    <% } else { %>
    <span id="shortcut_span_02" class="shortcut_class_01"><a href="login.jsp" class="shortcut_class_01">请登录</a></span>
    <a href="register.jsp" class="shortcut_class_01">免费注册</a>
    <span class="shortcut_class_01">个人中心</span>
    <span class="shortcut_class_01">消息</span>
    <span class="shortcut_class_01">购物车</span>
    <span class="shortcut_class_01">收藏夹</span>
    <span class="shortcut_class_01">免费开店</span>
    <% } %>
</div>
<div id="header">
    <img src="image/icon.jpg" id="img_01"/>
    <input type="text" id="header_text_01" placeholder="请输入商品的相关信息..."/>
    <input type="button" id="header_button_01" value="搜索"/>
    <img src="image/zcool.gif" id="img_02"/>
    <span id="header_span_01">我是小小哟，快来看看我带来的好商品吧！</span>
</div>
<div id="squat">
    <div id="squat_div_01"><p id="squat_p_01">全部商品分类</p></div>
    <div id="squat_div_02">
        <a href="" class="squat_class_01">首页</a>
        <a href="" class="squat_class_01">商城目录</a>
        <a href="" class="squat_class_01">活动中心</a>
        <a href="" class="squat_class_01">爆款推荐</a>
        <a href="" class="squat_class_01">海外代购</a>
        <a href="" class="squat_class_01">积分商城</a>
        <a href="" class="squat_class_01">免费入驻</a>
        <a href="" class="squat_class_01">BOM配单</a>
    </div>
</div>
<div id="bobyer">
    <hr class="class_hr_01"/>
    <div id="bobyer_div_01">
        <ul>
            <li class="bobyer_class_01" id="bobyer_li_01"></li>
<%--            <%--%>
<%--                List<classifica> list_caa = (List<classifica>) request.getSession().getAttribute("list_caa");--%>
<%--            %>--%>
<%--            <% for (int k = 0; k < list_caa.size(); k++) {--%>
<%--                classifica ca_1 = list_caa.get(k);--%>
<%--            %>--%>
<%--            <li class="bobyer_class_01"><span class="bobyer_class_span_01"><a href=""--%>
<%--                                                                              class="bobyer_class_04"><%=ca_1.getClassification_name()%></a></span>--%>
<%--                <div class="bobyer_class_li_div_01">--%>
<%--                    <ul class="class_ul_01">--%>
<%--                        <% for (int i = 0; i < ca_1.getList_class().size(); i++) {--%>
<%--                            classifica ca_2 = ca_1.getList_class().get(i);--%>
<%--                        %>--%>
<%--                        <li class="class_li_02"><a href="" class="bobyer_class_05"><%=ca_2.getClassification_name()%>--%>
<%--                        </a></li>--%>
<%--                        <li>--%>
<%--                            <% for (int j = 0; j < ca_2.getList_class().size(); j++) {--%>
<%--                                classifica ca_3 = ca_2.getList_class().get(j);--%>
<%--                            %>--%>
<%--                            <a href="javascript:void (0)" class="bobyer_class_05">--%>
<%--                                <span class="asdf" style="display: none"><%=ca_2.getClassification_id()%></span>--%>
<%--                                <span class="asdfg"><%=ca_3.getClassification_name()%></span>--%>
<%--                            </a>--%>
<%--                            <% } %>--%>
<%--                        </li>--%>
<%--                        <% } %>--%>
<%--                    </ul>--%>
<%--                </div>--%>
<%--            </li>--%>
<%--            <% } %>--%>
        </ul>
    </div>
    <div id="bobyer_div_02">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <div class="carousel slide" id="carousel-498628">
                    <ol class="carousel-indicators">
                        <li class="active" data-slide-to="0" data-target="#carousel-498628">
                        </li>
                        <li data-slide-to="1" data-target="#carousel-498628">
                        </li>
                        <li data-slide-to="2" data-target="#carousel-498628">
                        </li>
                    </ol>
                    <div class="carousel-inner">
                        <div class="item active">
                            <img alt="" src="image/a.jpg"/>
                        </div>
                        <div class="item">
                            <img alt="" src="image/b.jpg"/>
                        </div>
                        <div class="item">
                            <img alt="" src="image/c.jpg"/>
                        </div>
                    </div>
                    <a class="left carousel-control" href="#carousel-498628" data-slide="prev"><span
                            class="glyphicon glyphicon-chevron-left"></span></a> <a class="right carousel-control"
                                                                                    href="#carousel-498628"
                                                                                    data-slide="next"><span
                        class="glyphicon glyphicon-chevron-right"></span></a>
                </div>
            </div>
        </div>
    </div>
    <div id="bobyer_div_03">
        <div style="height: 480px; width: 190px; margin-bottom: 15px; border: solid 1px #0fa0ec; background-color: white;">
            <div style="height: 130px; text-align: center; border-bottom: solid 1px #e3e4e5;">
                <img src="image/avatar.png" style="margin-top: 30px;">
                <p style="font-size: 12px;">Hi, 你好!</p>
            </div>
            <div style="height: 200px; padding-top: 30px; border-bottom: solid 1px #e3e4e5;">
                <p><span style="color: red;">[热点]</span>&nbsp;滚筒洗衣机成为家庭首选，它到底有哪些好处？</p>
                <p><span style="color: red;">[热点]</span>&nbsp;荣耀MagicBook Pro，全面屏轻薄本</p>
                <p><span style="color: red;">[热议]</span>&nbsp;极致轻薄续航持久，小米笔记本Air 全新升级体</p>
            </div>
            <div class="class_div_02" style="text-align: center;">
                <div class="class_div_03">
                    <img src="image/card.png">
                    <p>信用卡</p>
                </div>
                <div class="class_div_03">
                    <img src="image/callCharge.png">
                    <p>话费</p>
                </div>
                <div class="class_div_03">
                    <img src="image/financial.png">
                    <p>理财</p>
                </div>
            </div>
            <div class="class_div_02" style="text-align: center;">
                <div class="class_div_03">
                    <img src="image/hydropower.png">
                    <p>水电费</p>
                </div>
                <div class="class_div_03">
                    <img src="image/publicWelfare.png">
                    <p>公益</p>
                </div>
                <div class="class_div_03">
                    <img src="image/staging.png">
                    <p>分期</p>
                </div>
            </div>
        </div>
    </div>
    <div id="bobyer_div_04">
        <img src="//img11.360buyimg.com/babel/s380x300_jfs/t1/53245/14/10413/69778/5d785b5eEf1c12440/4f7ddc6ee55b0c8e.jpg!q95.webp">
        <img src="//img12.360buyimg.com/babel/s380x300_jfs/t1/54081/16/10709/71407/5d81cc98E006d3a88/b79d5ae429f6538b.jpg.webp">
        <img src="//img30.360buyimg.com/babel/s380x300_jfs/t1/57066/33/11416/91435/5d84a000Ef0e287cf/46c2b0569a24a9fb.jpg!q95.webp">
        <img src="//img30.360buyimg.com/babel/s380x300_jfs/t1/53826/13/10578/83273/5d79fb9bE78d3066e/5a9887f43bb5caec.jpg.webp">
        <img src="//img14.360buyimg.com/babel/s380x300_jfs/t1/48838/14/11134/67481/5d82e6a0E40476535/75222da9d77989fb.jpg.webp">
    </div>
</div>
<div id="tailer">
    <div id="tailer_div_01">
        <img src="https://img.alicdn.com/tfs/TB1mOT8goT1gK0jSZFrXXcNCXXa-234-92.png">
        <img src="https://img.alicdn.com/tfs/TB1ynv.geH2gK0jSZJnXXaT1FXa-234-92.png">
        <img src="https://img.alicdn.com/tfs/TB1Dd68goT1gK0jSZFhXXaAtVXa-234-92.png">
        <img src="https://img.alicdn.com/tfs/TB1Ibcagbj1gK0jSZFOXXc7GpXa-234-92.png">
        <img src="https://img.alicdn.com/tfs/TB1dGoXgbH1gK0jSZFwXXc7aXXa-234-92.png">
    </div>
</div>
<div id="secondLast">
    <div id="secondLast_div_01">
        <p class="class_p_01" style="color: red;">热卖单品</p>
        <div>
            <% for (int i = 0; i < 15; i++) { %>
            <%
                String img_id = "prod_img_" + (i + 1);
                String p_id = "prod_p_" + (i + 1);
                String span_01_id = "prod_span01_" + (i + 1);
            %>
            <div class="class_div_01">
                <img class="class_img_01" id=<%=img_id%> src="">
                <p class="class_p_02" id=<%=p_id%>></p>
                <span class="class_span_01" id=<%=span_01_id%>></span>
            </div>
            <%}%>
        </div>
    </div>
</div>
<div id="last">
    <hr class="class_hr_01" id="last_hr_01"/>
    <img src="image/tail.png">
    <p>
        <span>QQ：962355097&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
        <span>电话：17742532106</span>
    </p>
    <p>
        地址：吉首大学张家界校区十栋
    </p>
</div>
</body>
</html>