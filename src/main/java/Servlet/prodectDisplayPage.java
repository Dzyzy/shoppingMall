package Servlet;

import Util.Prod;
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

@WebServlet("/prodectDisplayPage")
public class prodectDisplayPage extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");

        String msg = request.getParameter("msg");
        request.getSession().setAttribute("text", msg);
        List<Prod> list_user = new ArrayList<>();
        String sql = "select * from prod where prod_name like ? limit 0, 10";
        ResultSet rs = new JDBC().execQuery(sql, new Object[]{"%" + msg + "%"});
        while (true) {
            try {
                if (!rs.next()) break;
                Prod prods = new Prod();
                prods.setProd_id(rs.getInt("prod_id"));
                prods.setProd_name(rs.getString("prod_name"));
                prods.setProd_img((rs.getString("prod_img")));
                prods.setProd_desc(rs.getString("prod_desc"));
                prods.setProd_three_level(rs.getString("prod_three_level"));
                prods.setProd_num(rs.getInt("prod_num"));
                prods.setProd_price(rs.getBigDecimal("prod_price"));
                prods.setShop_id(rs.getInt("shop_id"));
                prods.setProd_num(rs.getInt("prod_num"));
                list_user.add(prods);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        List<String> list_name = new ArrayList<>();
        request.getSession().setAttribute("list_name", list_name);
        request.getSession().setAttribute("list_user", list_user);
        response.getWriter().write("1");
    }
}
