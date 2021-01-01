package Servlet;

import model.JDBC;

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

@WebServlet("/findChildren")
public class findChildren extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");

        int classification_id = Integer.parseInt(request.getParameter("classification_id"));
        List<String> list_name = new ArrayList<>();
        String sql = "select * from classification where classification_parent_id=?";
        ResultSet rs = new JDBC().execQuery(sql, new Object[]{classification_id});
        while (true) {
            try {
                if (!rs.next()) break;
                list_name.add(rs.getString("classification_name"));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        request.getSession().setAttribute("list_name", list_name);
        response.getWriter().write("1");
    }
}
