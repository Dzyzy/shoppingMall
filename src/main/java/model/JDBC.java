package model;

import java.sql.*;

public class JDBC {
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/shoppingmall?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8";
    public static final String USER = "root";
    public static final String PASSWORD = "zyily,";

    private static Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    static {
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //增、删、改语句的方法
    public int execOther(String sql, Object[] arr) {
        //System.out.println("SQL:>" + sql);
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < arr.length; i++) {
                ps.setObject(i + 1, arr[i]);
            }
            int result = ps.executeUpdate();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    //查询语句的方法
    public ResultSet execQuery(String sql, Object[] arr) {
        // System.out.println("SQL:>" + sql);
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < arr.length; i++) {
                ps.setObject(i + 1, arr[i]);
            }
            rs = ps.executeQuery();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
