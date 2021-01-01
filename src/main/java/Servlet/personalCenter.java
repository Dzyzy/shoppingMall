package Servlet;

import Util.Orders_item;
import Util.orders;
import model.JDBC;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet("/personalCenter")
public class personalCenter extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");

        String mark = request.getParameter("mark");
        if (mark.equals("1")) {
            int orders_id = Integer.parseInt(request.getParameter("orders_id"));
            String sql = "select * from orders where orders_id=?";
            ResultSet rs = new JDBC().execQuery(sql, new Object[]{orders_id});
            int orders_statu = 1;
            while (true) {
                try {
                    if (!rs.next()) break;
                    orders_statu += Integer.parseInt(rs.getString("orders_statu"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            sql = "update orders set orders_statu=? where orders_id=?";
            new JDBC().execOther(sql, new Object[]{orders_statu, orders_id});
        } else if (mark.equals("2")) {
            int prod_id = Integer.parseInt(request.getParameter("prod_id"));
            String msg = request.getParameter("msg");
            int orders_id = Integer.parseInt(request.getParameter("orders_id"));
            String sql = "select * from orders_item where (orders_id=? and prod_id=?)";
            ResultSet rs = new JDBC().execQuery(sql, new Object[]{prod_id, orders_id});
            int prod_pingjia = 1;
            sql = "select * from orders_item where (orders_id=? AND prod_id=?)";
            rs = new JDBC().execQuery(sql, new Object[]{orders_id, prod_id});
            try {
                if (rs.next()) {
                    prod_pingjia += rs.getInt("prod_pingjia");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            sql = "update orders_item set prod_pingjia=? where (orders_id=? and prod_id=?)";
            new JDBC().execOther(sql, new Object[]{prod_pingjia, orders_id, prod_id});

            //存入评论表
            Object user_id = request.getSession().getAttribute("user_id");
            sql = "select * from user where user_id=?";
            String user_name = null;
            rs = new JDBC().execQuery(sql, new Object[]{user_id});
            try {
                if (rs.next()) {
                    user_name = rs.getString("user_name");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            String time = df.format(new Date());    // new Date()为获取当前系统时间
            sql = "insert into evaluate set prod_id=?, evaluate_content=?, evaluate_time=?, user_name=?";
            new JDBC().execOther(sql, new Object[]{prod_id, msg, time, user_name});
        } else if (mark.equals("3")) {
            String user_name = request.getParameter("user_name");
            String password = request.getParameter("password");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");
            int user_id = (int) request.getSession().getAttribute("user_id");
            String sql = "update user set user_name=?, user_password=?, user_phone=?, user_address=? where user_id=?";
            new JDBC().execOther(sql, new Object[]{user_name, password, phone, address, user_id});
            request.getSession().setAttribute("user_name", user_name);
        } else if (mark.equals("4")) {
            Object orders_id = request.getParameter("orders_id");
            Object prod_id = request.getParameter("prod_id");
            int prod_pingjia = 1;
            String sql = "select * from orders_item where (orders_id=? AND prod_id=?)";
            ResultSet rs = new JDBC().execQuery(sql, new Object[]{orders_id, prod_id});
            try {
                if (rs.next()) {
                    prod_pingjia += rs.getInt("prod_pingjia");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            sql = "update orders_item set prod_pingjia=? where (orders_id=? AND prod_id=?)";
            new JDBC().execOther(sql, new Object[]{prod_pingjia, orders_id, prod_id});
        }

        HttpSession session = request.getSession();
        Object user_id = session.getAttribute("user_id");

        List<Util.orders> list_1 = new ArrayList<>();
        List<Orders_item> list_2 = new ArrayList<>();
        JDBC jdbc = new JDBC();
        String sql = "select * from orders where user_id=?";
        ResultSet rs = jdbc.execQuery(sql, new Object[]{user_id});
        while (true) {
            try {
                if (!rs.next()) break;
                int orders_id = rs.getInt("orders_id");
                int orders_statu = rs.getInt("orders_statu");
                int orders_total_amount = rs.getInt("orders_total_amount");
                Util.orders oo = new Util.orders(orders_id, orders_total_amount, (Integer) user_id, orders_statu);
                list_1.add(oo);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < list_1.size(); i++) {
            orders oo = list_1.get(i);
            int orders_id = oo.getOrders_id();
            sql = "select * from orders_item where orders_id=?";

            rs = jdbc.execQuery(sql, new Object[]{orders_id});
            while (true) {
                try {
                    if (!rs.next()) break;
                    int prod_id = rs.getInt("prod_id");
                    int prod_count = rs.getInt("prod_count");
                    int prod_pingjia = rs.getInt("prod_pingjia");
                    String sqll = "select * from prod where prod_id=?";
                    ResultSet rss = new JDBC().execQuery(sqll, new Object[]{prod_id});
                    if (rss.next()) {
                        String prod_name = rss.getString("prod_name");
                        BigDecimal prod_price = rss.getBigDecimal("prod_price");
                        String prod_img = rss.getString("prod_img");
                        Orders_item orderss = new Orders_item(orders_id, prod_id, prod_count, prod_name, prod_img, prod_price, prod_pingjia);
                        list_2.add(orderss);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        request.getSession().setAttribute("list_1", list_1);
        request.getSession().setAttribute("list_2", list_2);
        response.getWriter().write("1");
    }
}
