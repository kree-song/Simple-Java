package com.xsq.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * 这个程序开启一个事务，这个事务专门进行查询，并且使用行级锁/悲观锁，锁住相关记录
 * */
public class jdbcTest3 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = jdbcUtil.getConnection();
            //！开启事务
            conn.setAutoCommit(false);

            //获取预编译的数据库操作对象
            String sql = "select loginName,loginPwd from t_user where id=? for update";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, 3);
            //执行sql语句
            rs = ps.executeQuery();
            //处理查询结果集
            while (rs.next()) {
                System.out.println(rs.getString("loginName") + "," + rs.getString("loginPwd"));
            }

            //！提交事务（事务结束）
            conn.commit();   //此处加一个断点，不让事务结束。运行下一个程序完成演示
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    //！回滚事务（事务结束）
                    conn.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            jdbcUtil.close(conn, ps, rs);
        }
    }
}
