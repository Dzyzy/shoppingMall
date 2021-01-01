package Servlet;

import model.JDBC;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/shop_10")
public class shop_10 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");

        String classification_name = request.getParameter("classification_name");
        String msg = request.getParameter("msg");

        String sql = "update prod set prod_three_level=? where prod_three_level=?";
        new JDBC().execOther(sql, new Object[]{msg, classification_name});

        sql = "update classification set classification_name=? where classification_name=?";
        new JDBC().execOther(sql, new Object[]{msg, classification_name});
        response.getWriter().write("1");
    }
}
