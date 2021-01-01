package Servlet;

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

@WebServlet("/shop_4")
public class shop_4 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");

        String classification_name = request.getParameter("classification_name");
        String sql = "select * from classification where classification_name=?";
        int id = 0;
        ResultSet rs = new JDBC().execQuery(sql, new Object[]{classification_name});
        try {
            if (rs.next()) {
                id = rs.getInt("classification_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JSONArray jsonArray = new JSONArray();
        sql = "select * from classification where classification_parent_id=?";
        rs = new JDBC().execQuery(sql, new Object[]{id});
        while (true) {
            try {
                if (!rs.next()) break;
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("classification_name", rs.getString("classification_name"));
                jsonArray.add(jsonObject);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        response.getWriter().write(jsonArray.toString());
    }
}
