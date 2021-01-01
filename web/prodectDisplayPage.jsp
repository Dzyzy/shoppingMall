<%@ page import="java.util.List" %>
<%@ page import="Util.Prod" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link type="text/css" href="CSS/prodectDisplayPage.css" rel="stylesheet">
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <script type="text/javascript" src="JS/prodectDisplayPage.js" rel="stylesheet"></script>
    <title>商品展示页</title>
</head>
<body>
<div id="shortcut">
    <%
        Object user_id = session.getAttribute("user_id");
        Object user_name = session.getAttribute("user_name");
    %>
    <span id="shortcut_span_01">您好，欢迎来到无忧商城！</span>
    <% if (user_id != null) { %>
    <span id="shortcut_span_02" class="shortcut_class_01"><a href="" class="shortcut_class_01"><%=user_name%></a></span>
    <% } else { %>
    <span id="shortcut_span_02" class="shortcut_class_01"><a href="login.jsp" class="shortcut_class_01">请登录</a></span>
    <% } %>
    <a href="register.jsp" class="shortcut_class_01">免费注册</a>
    <a href="personalCenter.jsp" class="shortcut_class_01">个人中心</a>
    <a href="" class="shortcut_class_01">消息</a>
    <a href="shoppingCart.jsp" class="shortcut_class_01">购物车</a>
    <a href="" class="shortcut_class_01">收藏夹</a>
    <a href="homePage.jsp" class="shortcut_class_01">返回首页</a>
</div>
<div id="header">
    <img src="image/icon.jpg" id="img_01"/>
    <input type="text" id="header_text_01" placeholder="请输入商品的相关信息..."/>
    <input type="button" id="header_button_01" value="搜索"/>
</div>
<div id="chin">
    <span style="margin-left: 100px;">同级分类&nbsp;&nbsp;&nbsp;>>>&nbsp;&nbsp;&nbsp; </span>
    <%
        List<String> list_name = (List<String>) request.getSession().getAttribute("list_name");
        for (int i = 0; i < list_name.size(); i++) {
    %>
    &nbsp;&nbsp;&nbsp;<span class="uio" style="cursor: pointer; color: #0fa0ec;"><%=list_name.get(i)%></span>
    <% } %>
</div>
<div id="secondLast">
    <div id="secondLast_div_01">
        <div id="bobyer">
            <%--                <%--%>
            <%--                    List<Prod> list_user = (List<Prod>) request.getSession().getAttribute("list_user");--%>
            <%--                    for(int i = 0; i < list_user.size(); i++) {--%>
            <%--                        Prod prods = list_user.get(i);%>--%>
            <%--                <div class="class_div_01">--%>
            <%--                    <img class="class_img_01" src=<%=prods.getProd_img()%> >--%>
            <%--                    <p class="class_p_02"><%=prods.getProd_name()%></p>--%>
            <%--                    <span class="class_span_01">￥<%=prods.getProd_price()%></span>--%>
            <%--                </div>--%>
            <%--                <%}%>--%>
        </div>
    </div>
</div>
<div style="position: relative;">
    <input id="a1" type="button" value="上一页" style="position: absolute; top: -30px; left: 700px;">
    <input id="a2" type="text" value="1"
           style="position: absolute; top: -30px; left: 755px; width: 50px; height: 18px; text-align: center;">
    <input id="a3" type="button" value="下一页" style="position: absolute; top: -30px; left: 808px;">
</div>
</body>
</html>