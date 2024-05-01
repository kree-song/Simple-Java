package com.xsq.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 * 重点的三行代码：
 *    conn.setAutoCommit(false);
 *    conn.commit();
 *    conn.rollback();
 * */
public class jdbcTest2_1 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            //1.注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.获取连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=UTC", "root", "1122");
            //！！！将自动提交机制改为手动提交机制
            conn.setAutoCommit(false);//开启事务

            //3.获取预编译的数据库操作对象
            String sql = "update t_act set balance=? where actno=?";
            ps = conn.prepareStatement(sql);
            //给？传值
            ps.setDouble(1, 10000);
            ps.setInt(2, 111);
            int count = ps.executeUpdate();

            /*String s=null;
            s.toString();*/

            //给？传值
            ps.setDouble(1, 10000);
            ps.setInt(2, 222);
            count += ps.executeUpdate();
            System.out.println(count == 2 ? "转账成功" : "转账失败");

            //程序能够走到这里说明以上程序没有异常，事务结束，手动提交数据
            conn.commit();//提交事务
        } catch (Exception e) {
            //回滚事务
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
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
