package Servlet;


import Util.Prod;
import Util.classification;
import model.JDBC;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/shop")
public class shop extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");

        Object user_id = request.getSession().getAttribute("user_id");
        int shop_id = 0;
        String sql = "select * from shop where user_id=?";
        ResultSet rs = new JDBC().execQuery(sql, new Object[]{user_id});
        try {
            if (rs.next()) {
                shop_id = rs.getInt("shop_id");
                request.getSession().setAttribute("shop_id", shop_id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        List<Prod> list_prod_1 = new ArrayList<>();
        sql = "select * from prod where shop_id=?";
        rs = new JDBC().execQuery(sql, new Object[]{shop_id});
        while (true) {
            try {
                if (!rs.next()) break;
                Prod prods = new Prod();
                prods.setProd_id(rs.getInt("prod_id"));
                prods.setProd_num(rs.getInt("prod_num"));
                prods.setShop_id(shop_id);
                prods.setProd_three_level(rs.getString("prod_three_level"));
                prods.setProd_img(rs.getString("prod_img"));
                prods.setProd_price(rs.getBigDecimal("prod_price"));
                prods.setProd_name(rs.getString("prod_name"));
                prods.setProd_desc(rs.getString("prod_desc"));
                prods.setProd_statu(rs.getString("prod_statu"));
                list_prod_1.add(prods);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < list_prod_1.size(); i++) {
            int cnt = 0;
            Prod prods = list_prod_1.get(i);
            sql = "select * from orders_item where prod_id=?";
            rs = new JDBC().execQuery(sql, new Object[]{prods.getProd_id()});
            while (true) {
                try {
                    if (!rs.next()) break;
                    cnt++;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            list_prod_1.get(i).setProd_sale_num(cnt);
            list_prod_1.get(i).setProd_sale_amount(cnt * list_prod_1.get(i).getProd_price().doubleValue());
        }


        List<Prod> list_o_2 = new ArrayList<>();
        List<Integer> lis = new ArrayList<>();
        sql = "select * from orders_item where prod_id=?";
        for (int i = 0; i < list_prod_1.size(); i++) {
            Prod prods = list_prod_1.get(i);
            int prod_id = prods.getProd_id();
            rs = new JDBC().execQuery(sql, new Object[]{prod_id});
            while (true) {
                try {
                    if (!rs.next()) break;
                    int orders_id = rs.getInt("orders_id");
                    String sqll = "select * from orders where orders_id=?";
                    ResultSet rss = new JDBC().execQuery(sqll, new Object[]{orders_id});
                    if (rss.next()) {
                        int orders_statu = Integer.parseInt(rss.getString("orders_statu"));
                        if (orders_statu > 1) {
                            lis.add(orders_id);
                            Prod p = new Prod(prods.getProd_id(), prods.getProd_name(), prods.getProd_price(), orders_statu, prods.getProd_img(), rs.getInt("prod_pingjia"), orders_id, rs.getInt("prod_count"), rs.getInt("prod_count") * prods.getProd_price().doubleValue());
                            list_o_2.add(p);
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        for (int i = 0; i < lis.size() - 1; i++) {
            for (int j = lis.size() - 1; j > i; j--) {
                if (lis.get(j).equals(lis.get(i))) {
                    lis.remove(j);
                }
            }
        }


        List<classification> list_class1 = new ArrayList<>();
        sql = "select * from classification where classification_parent_id=?";
        rs = new JDBC().execQuery(sql, new Object[]{0});
        while (true) {
            try {
                if (!rs.next()) break;
                classification cla = new classification(rs.getInt("classification_id"), rs.getString("classification_name"), rs.getInt("classification_parent_id"));
                // System.out.println(rs.getInt("classification_id")+ " " + rs.getString("classification_name")+ " " + rs.getInt("classification_parent_id"));
                list_class1.add(cla);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        request.getSession().setAttribute("list_class1", list_class1);

        request.getSession().setAttribute("lis", lis);
        request.getSession().setAttribute("list_o_2", list_o_2);

        request.getSession().setAttribute("list_prod_1", list_prod_1);

        response.sendRedirect("shop.jsp");
    }
}