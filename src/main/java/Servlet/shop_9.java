package Servlet;

import model.JDBC;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/shop_9")
public class shop_9 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");

        int prod_id = Integer.parseInt(request.getParameter("prod_id"));
        String sql = "delete from prod where prod_id=?";
        new JDBC().execOther(sql, new Object[]{prod_id});
        response.getWriter().write("1");
    }
}
