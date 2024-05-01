package com.xsq.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 * 这个程序负责修改被锁定的记录
 * */
public class jdbcTest3_1 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = jdbcUtil.getConnection();
            conn.setAutoCommit(false);

            String sql = "update t_user set loginPwd=222 where id=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, 3);
            int count = ps.executeUpdate();
            System.out.println(count);

            conn.commit();
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        } finally {
            jdbcUtil.close(conn, ps, null);
        }
    }
}
