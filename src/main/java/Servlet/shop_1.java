package Servlet;

import model.JDBC;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/shop_1")
public class shop_1 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");

        int orders_id = Integer.parseInt(request.getParameter("orders_id"));
        int prod_id = Integer.parseInt(request.getParameter("prod_id"));
        int prod_pingjia = 1;

        String sql = "select * from orders_item where (orders_id=? and prod_id=?)";
        ResultSet rs = new JDBC().execQuery(sql, new Object[]{orders_id, prod_id});
        try {
            if (rs.next()) {
                prod_pingjia += rs.getInt("prod_pingjia");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        sql = "update orders_item set prod_pingjia=? where (orders_id=? and prod_id=?)";
        new JDBC().execOther(sql, new Object[]{prod_pingjia, orders_id, prod_id});
    }
}
