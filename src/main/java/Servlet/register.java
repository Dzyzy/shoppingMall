package Servlet;

import model.JDBC;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class register extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");

        int user_id = (int) (Math.floor(Math.random() * 900000000 + 100000000));
        String user_name = request.getParameter("user_name");
        String user_password = request.getParameter("user_password");
        String user_email = request.getParameter("user_email");
        String sql = "INSERT INTO user(user_id, user_name, user_password, user_email, user_isshop) VALUE(?, ?, ?, ?, ?)";
        JDBC jdbc = new JDBC();
        jdbc.execOther(sql, new Object[]{user_id, user_name, user_password, user_email, "0"});
        response.getWriter().write("" + user_id);
    }

}
