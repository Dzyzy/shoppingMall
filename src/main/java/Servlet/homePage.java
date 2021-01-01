package Servlet;

import Util.Orders_item;
import Util.classifica;
import Util.orders;
import model.JDBC;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/homePage")
public class homePage extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");

        Object user_id = request.getSession().getAttribute("user_id");
        String mark = request.getParameter("mark");
        JSONArray jsonArray = new JSONArray();

        //加上商品项
        List<Util.orders> list_1 = new ArrayList<>();
        List<Orders_item> list_2 = new ArrayList<>();
        String sql = "select * from orders where user_id=?";
        JDBC jdbc = new JDBC();
        ResultSet rs = jdbc.execQuery(sql, new Object[]{user_id});
        while (true) {
            try {
                if (!rs.next()) break;
                int orders_id = rs.getInt("orders_id");
                int orders_total_amount = rs.getInt("orders_total_amount");
                int orders_statu = rs.getInt("orders_statu");
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
                    int prod_pingjia = rs.getInt("prod_pingjia");
                    int prod_id = rs.getInt("prod_id");
                    int prod_count = rs.getInt("prod_count");
                    String sqll = "select * from prod where prod_id=?";
                    ResultSet rss = new JDBC().execQuery(sqll, new Object[]{prod_id});
                    if (rss.next()) {
                        String prod_name = rss.getString("prod_name");
                        String prod_img = rss.getString("prod_img");
                        BigDecimal prod_price = rss.getBigDecimal("prod_price");
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

        try {
            List<classifica> list_caa = new shop_2().selectA(0);
            request.getSession().setAttribute("list_caa", list_caa);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        sql = "select * from prod";
        jdbc = new JDBC();
        rs = jdbc.execQuery(sql, new Object[]{});
        while (true) {
            try {
                if (!rs.next()) break;
                String prod_name = rs.getString("prod_name");
                String prod_price = rs.getString("prod_price");
                String prod_img = rs.getString("prod_img");
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("prod_name", prod_name);
                jsonObject.put("prod_price", prod_price);
                jsonObject.put("prod_img", prod_img);
                jsonArray.add(jsonObject);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        if (mark.equals("1")) {
            request.getSession().setAttribute("user_isshop", 1);
            sql = "update user set user_isshop=? where user_id=?";
            new JDBC().execOther(sql, new Object[]{"1", user_id});
            String shop_name = request.getParameter("shop_name");
            sql = "insert into shop set shop_name=?, user_id=?";
            new JDBC().execOther(sql, new Object[]{shop_name, user_id});
        } else if(mark.equals("2")) {

        }

        response.getWriter().write(jsonArray.toString());
    }

}
