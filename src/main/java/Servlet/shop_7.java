package Servlet;

import model.JDBC;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/shop_7")
public class shop_7 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");

        int prod_id = (int) request.getSession().getAttribute("prod_id_1");
        String prod_name = request.getParameter("prod_name");
        int shop_id = (int) request.getSession().getAttribute("shop_id");
        Double prod_price = Double.parseDouble(request.getParameter("prod_price"));
        String prod_desc = request.getParameter("prod_desc");
        String prod_img = request.getParameter("prod_img");
        String prod_three_level = request.getParameter("prod_three_level");
        int prod_num = Integer.parseInt(request.getParameter("prod_num"));
//        System.out.println(shop_id + " " + prod_name + " " + prod_price + " " + prod_desc + " " +
//                prod_img + " " + prod_three_level + " " + prod_num + " " + prod_id);
        String sql = "update prod set prod_name=?, prod_price=?, shop_id=?, prod_num=?, prod_desc=?, prod_three_level=?, prod_img=? where prod_id=?";
        new JDBC().execOther(sql, new Object[]{prod_name, prod_price, shop_id, prod_num, prod_desc, prod_three_level, prod_img, prod_id});
        response.getWriter().write("1");
    }
}
