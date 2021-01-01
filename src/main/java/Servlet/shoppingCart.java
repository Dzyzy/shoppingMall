package Servlet;

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

@WebServlet("/shoppingCart")
public class shoppingCart extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");

        String mark = request.getParameter("mark");
        if (mark.equals("1")) {
            String prod_name = request.getParameter("pord_name") + "";
            String sql = "select * from prod where prod_name=?";
            JDBC jdbc = new JDBC();
            ResultSet rs = jdbc.execQuery(sql, new Object[]{prod_name});
            int prod_num = 0;
            while (true) {
                try {
                    if (!rs.next()) break;
                    prod_num = rs.getInt("prod_num");
                    response.getWriter().write(prod_num + "");
                    //返回商品的数量，要在js中获取
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else if (mark.equals("0")) {
            JSONArray jsonArray = new JSONArray();
            JSONObject jsonObject = new JSONObject();
            Object user_id = request.getSession().getAttribute("user_id");
            String sql = "select * from shopping_cart where user_id=?";
            String sqll = "select * from prod where prod_id=?";
            JDBC jdbc1 = new JDBC();
            ResultSet rs = jdbc1.execQuery(sql, new Object[]{user_id});
            while (true) {
                try {
                    if (!rs.next()) break;
                    int prod_id = rs.getInt("prod_id");
                    int prod_count = rs.getInt("prod_count");
                    jsonObject.put("prod_count", prod_count);
                    JDBC jdbc2 = new JDBC();
                    ResultSet rss = jdbc2.execQuery(sqll, new Object[]{prod_id});
                    while (rss.next()) {
                        String prod_name = rss.getString("prod_name");
                        BigDecimal prod_price = rss.getBigDecimal("prod_price");
                        String prod_img = rss.getString("prod_img");
                        jsonObject.put("prod_name", prod_name);
                        jsonObject.put("prod_price", prod_price);
                        jsonObject.put("prod_img", prod_img);
                    }
                    jsonArray.add(jsonObject);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            response.getWriter().write(jsonArray.toString());
        } else if (mark.equals("2")) {
            String prod_name = request.getParameter("prod_name");
            String sql = "select * from prod where prod_name=?";
            JDBC jdbc3 = new JDBC();
            JDBC jdbc4 = new JDBC();
            ResultSet rs = jdbc3.execQuery(sql, new Object[]{prod_name});
            while (true) {
                try {
                    if (!rs.next()) break;
                    int prod_id = rs.getInt("prod_id");
                    String sqll = "delete from shopping_cart where prod_id=?";
                    jdbc4.execOther(sqll, new Object[]{prod_id});
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            response.getWriter().write("1");
        } else if (mark.equals("3")) {
            String prod_name = request.getParameter("prod_name");
            int prod_count = Integer.parseInt(request.getParameter("prod_count"));
            String sql = "select * from prod where prod_name=?";
            JDBC jdbc5 = new JDBC();
            ResultSet rs = jdbc5.execQuery(sql, new Object[]{prod_name});
            JDBC jdbc6 = new JDBC();
            int prod_id;
            while (true) {
                try {
                    if (!rs.next()) break;
                    prod_id = rs.getInt("prod_id");
                    String sqll = "update shopping_cart set prod_count=? where prod_id=?";
                    jdbc6.execOther(sqll, new Object[]{prod_count, prod_id});
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            response.getWriter().write("1");
        } else if (mark.equals("4")) {
            List<String> list = new ArrayList<>();
            String strings = request.getParameter("arr_name") + ", ";
            while (strings.indexOf(",") > 0) {
                int pos = strings.indexOf(",") + 1;
                String str = strings.substring(0, pos - 1);
                strings = strings.substring(pos);
                list.add(str);
            }
            request.getSession().setAttribute("list", list);
            response.getWriter().write("1");
        }
    }
}