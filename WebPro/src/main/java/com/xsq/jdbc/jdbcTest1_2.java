package com.xsq.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 * PreparedStatement完成insert delete update
 * */
public class jdbcTest1_2 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            //1.注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.获取连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=UTC", "root", "1122");
            //3.获取预编译的数据库操作对象
            /*String sql="insert into t_user(id,loginName,loginPwd) values(?,?,?)";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,3);
            ps.setString(2,"lisi");
            ps.setString(3,"456");*/

            /*String sql="update t_user set loginName=?,loginPwd=? where id=?";
            ps=conn.prepareStatement(sql);
            ps.setString(1,"lisan");
            ps.setString(2,"789");
            ps.setInt(3,3);*/

            String sql = "delete from t_user where id=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, 3);
            //4.执行sql语句
            int count = ps.executeUpdate();
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
