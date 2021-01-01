package Servlet;

import Util.Prod;
import model.JDBC;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/findprod")
public class findprod extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");

        String classification_name = request.getParameter("msg");
        request.getSession().setAttribute("text", classification_name);
        String sql = "select * from prod where prod_three_level=?";
        ResultSet rs = new JDBC().execQuery(sql, new Object[]{classification_name});
        JSONArray jsonArray = new JSONArray();
        while (true) {
            try {
                if (!rs.next()) break;
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("prod_id", rs.getInt("prod_id"));
                jsonObject.put("prod_name", rs.getString("prod_name"));
                jsonObject.put("prod_img", (rs.getString("prod_img")));
                jsonObject.put("prod_desc", rs.getString("prod_desc"));
                jsonObject.put("prod_three_level", rs.getString("prod_three_level"));
                jsonObject.put("prod_num", rs.getInt("prod_num"));
                jsonObject.put("prod_price", rs.getBigDecimal("prod_price"));
                jsonObject.put("shop_id", rs.getInt("shop_id"));
                jsonArray.add(jsonObject);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        response.getWriter().write(jsonArray.toString());
    }
}
