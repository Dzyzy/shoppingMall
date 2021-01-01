package Servlet;

import Util.Orders_item;
import jdk.nashorn.internal.runtime.ListAdapter;
import model.JDBC;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@WebServlet("/prodectDetails")
public class prodectDetails extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");

        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        String prod_name = request.getParameter("prod_name");
        String sql = "select * from prod where prod_name=?";
        JDBC jdbc = new JDBC();
        ResultSet rs = jdbc.execQuery(sql, new Object[]{prod_name});
        int shop_id = 0;
        int prod_id = 0;
        String mark = request.getParameter("mark");

        while (true) {
            try {
                if (!rs.next()) break;
                String prodName = rs.getString("prod_name");
                if (prod_name.equals(prodName)) {
                    jsonObject.put("prod_name", rs.getString("prod_name"));
                    jsonObject.put("prod_price", rs.getString("prod_price"));
                    jsonObject.put("prod_img", rs.getString("prod_img"));
                    jsonObject.put("prod_num", rs.getInt("prod_num"));
                    jsonObject.put("prod_id", rs.getInt("prod_id"));
                    jsonObject.put("prod_desc", rs.getString("prod_desc"));
                    prod_id = rs.getInt("prod_id");
                    shop_id = rs.getInt("shop_id");
                    break;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (mark.equals("1")) {
            sql = "select * from shop where shop_id=?";
            JDBC jdbc1 = new JDBC();
            rs = jdbc1.execQuery(sql, new Object[]{shop_id});
            while (true) {
                try {
                    if (!rs.next()) break;
                    int shopId = rs.getInt("shop_id");
                    if (shop_id == shopId) {
                        jsonObject.put("shop_name", rs.getString("shop_name"));
                        break;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            Object user_id = request.getSession().getAttribute("user_id");
            sql = "select * from user where user_id=?";
            JDBC jdbc2 = new JDBC();
            rs = jdbc2.execQuery(sql, new Object[]{user_id});
            while (true) {
                try {
                    if (!rs.next()) break;
                    int userId = rs.getInt("user_id");
                    if ((int) user_id == userId) {
                        jsonObject.put("user_address", rs.getString("user_address"));
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else if (mark.equals("2")) {
            sql = "select * from shopping_cart where prod_id=?";
            int prod_count = Integer.parseInt(request.getParameter("prod_count"));
            JDBC jdbc3 = new JDBC();
            ResultSet rss = jdbc3.execQuery(sql, new Object[]{prod_id});
            try {
                if (rss.next()) {
                    int num = rss.getInt("prod_count") + prod_count;
                    sql = "select * from prod where prod_id=?";
                    ResultSet rsss = new JDBC().execQuery(sql, new Object[]{prod_id});
                    if (rsss.next()) {
                        num = Math.min(num, rs.getInt("prod_num"));
                    }
                    sql = "update shopping_cart set prod_count=? where prod_id=?";
                    JDBC jdbc4 = new JDBC();
                    jdbc4.execOther(sql, new Object[]{num, prod_id});
                } else {
                    Object user_id = request.getSession().getAttribute("user_id");

                    sql = "INSERT INTO shopping_cart(user_id, prod_id, prod_count) VALUE(?, ?, ?)";
                    JDBC jdbc5 = new JDBC();
                    jdbc5.execOther(sql, new Object[]{user_id, prod_id, prod_count});
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (mark.equals("3")) {
            jsonObject.put("prod_count", request.getParameter("prod_count"));
            request.getSession().setAttribute("jon", jsonObject);
        } else if (mark.equals("4")) {
            List<String> list_str = new ArrayList<>();
            sql = "select * from evaluate where prod_id=?";
            rs = new JDBC().execQuery(sql, new Object[]{prod_id});
            while (true) {
                try {
                    if (!rs.next()) break;
                    list_str.add(rs.getString("evaluate_time") + " " + rs.getString("user_name") + ":" + rs.getString("evaluate_content"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            Collections.reverse(list_str);
            for (int i = 0; i < list_str.size(); i++) {
                String str = list_str.get(i);
                JSONObject jsonObject1 = new JSONObject();
                jsonObject1.put("msg", str);
                jsonArray.add(jsonObject1);
            }

        }
        if (mark.equals("4")) {
            response.getWriter().write(jsonArray.toString());
        } else {
            response.getWriter().write(jsonObject.toString());
        }
    }
}
