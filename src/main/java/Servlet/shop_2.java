package Servlet;

import Util.classifica;
import model.JDBC;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/shop_2")
public class shop_2 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");

        try {
            List<classifica> list_caa = selectA(0);
            request.getSession().setAttribute("list_caa", list_caa);
        } catch (
                SQLException e) {
            e.printStackTrace();
        }

        String classification_name = request.getParameter("classification_name");
        String sql = "insert into classification set classification_name=?, classification_parent_id=?";
        new JDBC().execOther(sql, new Object[]{classification_name, 0});
        response.getWriter().write("1");
    }

    public List<classifica> selectA(int id) throws SQLException {
        List<classifica> list_c = new ArrayList<>();
        String sql = "select * from classification where classification_parent_id=?";
        ResultSet rs = new JDBC().execQuery(sql, new Object[]{id});
        while (rs.next()) {
            classifica cla = new classifica(rs.getInt("classification_id"), rs.getString("classification_name"), rs.getInt("classification_parent_id"), new start().selectA(rs.getInt("classification_id")));
            list_c.add(cla);
        }
        return list_c;
    }
}
