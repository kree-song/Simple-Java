package com.xsq.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
 * 测试工具类jdbcUtil是否好用
 * */
public class jdbcUtilTest {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //2.获取连接
            conn = jdbcUtil.getConnection();
            //3.获取预编译的数据库操作对象
            String sql = "select loginName from t_user where id=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, 3);
            rs = ps.executeQuery();//4.执行SQL语句
            while (rs.next()) {//5.处理查询结果集
                System.out.println(rs.getString("loginName"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //6.释放资源
            jdbcUtil.close(conn, ps, rs);
        }
    }
}
