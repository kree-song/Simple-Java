package com.xsq.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcTest {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            //1.注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");//DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            //2.获取连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/1djc?serverTimezone=UTC", "root", "1122");
            //3.获取数据库操作对象
            stmt = conn.createStatement();
            //4.执行sql语句
            String sql = "insert into user123(userid,username,password) values(null,123,12345)";
            int count = stmt.executeUpdate(sql);
            System.out.println(count);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally { //6.释放资源
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
