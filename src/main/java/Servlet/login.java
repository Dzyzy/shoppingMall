package Servlet;

import model.JDBC;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/login")
public class login extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");

        String account = request.getParameter("user_name");
        String password = request.getParameter("user_password");
        int user_id = Integer.parseInt(account);

        String sql = "select * from user where user_id = ?";
        JDBC jdbc = new JDBC();
        ResultSet rs = jdbc.execQuery(sql, new Object[]{account});
        while (true) {
            try {
                if (!rs.next()) break;
                String pwd = rs.getString("user_password");
                if (pwd.equals(password)) {
                    HttpSession session = request.getSession();
                    session.setAttribute("user_id", user_id);   //将用户名存入session
                    String user_name = rs.getString("user_name");
                    session.setAttribute("user_name", user_name);   //将昵称存入session
                    String user_isshop = rs.getString("user_isshop");
                    session.setAttribute("user_isshop", user_isshop);
                    response.getWriter().write("1");
                    return;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        response.getWriter().write("0");
    }
}
