package Servlet;

import model.JDBC;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/orders")
public class orders extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");

        Object mark = request.getParameter("mark");
        if (mark.equals("2")) {
            List<String> list = (List<String>) request.getSession().getAttribute("list");
            JDBC jdbc = new JDBC();
            String sql;
            JSONArray jsonArray = new JSONArray();
            Object user_id = request.getSession().getAttribute("user_id");
            for (int i = 0; i < list.size(); i++) {
                String prod_name = list.get(i);
                sql = "select * from prod where prod_name=?";
                ResultSet rs = jdbc.execQuery(sql, new Object[]{prod_name});
                JSONObject jsonObject = new JSONObject();
                int prod_id = 0;
                while (true) {
                    try {
                        if (!rs.next()) break;
                        jsonObject.put("prod_name", rs.getString("prod_name"));
                        jsonObject.put("prod_price", rs.getBigDecimal("prod_price"));
                        jsonObject.put("prod_img", rs.getString("prod_img"));
                        prod_id = rs.getInt("prod_id");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                sql = "select * from shopping_cart where (user_id=? AND prod_id=?)";
                rs = jdbc.execQuery(sql, new Object[]{user_id, prod_id});
                while (true) {
                    try {
                        if (!rs.next()) break;
                        jsonObject.put("prod_count", rs.getInt("prod_count"));
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                jsonArray.add(jsonObject);
            }
            response.getWriter().write(jsonArray.toString());
        } else if (mark.equals("1")) {
            Object jsonObject = request.getSession().getAttribute("jon");
            response.getWriter().write(jsonObject.toString());
        } else if (mark.equals("3")) {
            Object user_id = request.getSession().getAttribute("user_id");
            int totalAmount = Integer.parseInt(request.getParameter("totalAmount"));
            int orders_id = (int) Math.floor(Math.random() * 900000000 + 100000000);

            JDBC jdbc = new JDBC();
            String sql = "INSERT INTO orders(orders_id, orders_total_amount, user_id, orders_statu) values(?, ?, ?, ?)";
            jdbc.execOther(sql, new Object[]{orders_id, totalAmount, user_id, "1"});
            String str_name = request.getParameter("arr_name") + ",";
            String str_count = request.getParameter("arr_count") + ",";
            while (str_name.indexOf(",") > 0) {
                int pos = str_name.indexOf(",") + 1;
                String prodName = str_name.substring(0, pos - 1);
                str_name = str_name.substring(pos);
                pos = str_count.indexOf(",") + 1;
                int prodCount = Integer.parseInt(str_count.substring(0, pos - 1));
                str_count = str_count.substring(pos);

                jdbc = new JDBC();
                JDBC jdbc1 = new JDBC();
                sql = "select * from prod where prod_name=?";
                ResultSet rs = jdbc.execQuery(sql, new Object[]{prodName});

                while (true) {
                    try {
                        if (!rs.next()) break;
                        int prod_id = rs.getInt("prod_id");
                        BigDecimal prod_price = rs.getBigDecimal("prod_price");
                        sql = "insert into Orders_item(orders_id, prod_id, prod_count, prod_pingjia) values(?, ?, ?, ?)";
                        jdbc1.execOther(sql, new Object[]{orders_id, prod_id, prodCount, 0});
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
            response.getWriter().write("1");
        }

    }
}
