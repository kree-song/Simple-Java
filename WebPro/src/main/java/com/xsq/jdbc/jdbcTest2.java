package com.xsq.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 * JDBC事务机制：
 *   1.JDBC中的事务是自动提交的，只要执行任意一条DML语句，则自动提交一次。
 * 这是JDBC默认的事务行为，但是在实际的业务当中，通常都是N条DML语句共同联合
 * 才能完成的，必须保证他们这些DML语句在同一个事务中同时成功或同时失败
 *   2.以下程序验证JDBC的事务是自动提交机制(账户转账功能)
 * */
public class jdbcTest2 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            //1.注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.获取连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=UTC", "root", "1122");
            //3.获取预编译的数据库操作对象
            String sql = "update t_user set loginName=? where id=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, "zhang5");
            ps.setInt(2, 3);
            int count = ps.executeUpdate();//4.执行sql语句
            System.out.println(count);

            //重新给占位符传值
            ps.setString(1, "zhang6");
            ps.setInt(2, 4);
            count = ps.executeUpdate();//4.执行sql语句
            System.out.println(count);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //6.释放资源
            if (ps != null) {
                try {
                    ps.close();
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
