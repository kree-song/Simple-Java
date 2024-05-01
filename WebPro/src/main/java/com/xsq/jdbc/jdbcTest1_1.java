package com.xsq.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * 解决SQL注入
 * 只要用户提供的信息不参与SQL语句的编译过程，问题就可解决
 * 使用java.sql.preparedStatement接口（继承java.sql.Statement）
 * PreparedStatement属于预编译的数据库操作对象
 * 原理：预先对SQL语句的框架进行编译，然后再给SQL语句传“值”
 *
 * 对比Statement和PreparedStatement：
 * 1.Statement存在sql注入问题，PreparedStatement解决了sql诸如问题
 * 2.Statement是编译一次执行一次，PreparedStatement是编译一次，可执行N次，PreparedStatement效率较高一些
 * 3.PreparedStatement会在编译阶段做类型的安全检查
 * 使用Statement的情况：凡是业务方面要求是需要进行sql语句拼接（sql注入）的，必须使用Statement
 * */
public class jdbcTest1_1 {
    public static void main(String[] args) {
        //初始化一个界面
        Map<String, String> userLoginInfo = initUI();
        //验证用户名和密码
        boolean loginSuccess = login(userLoginInfo);
        //最后输出结果
        System.out.println(loginSuccess ? "登陆成功" : "登陆失败");
    }

    /*
     * 用户登录
     * @param userLoginInfo 用户登录信息
     * @return false失败，true成功
     * */
    private static boolean login(Map<String, String> userLoginInfo) {
        boolean loginSuccess = false;
        //单独定义变量
        String loginName = userLoginInfo.get("loginName");
        String loginPwd = userLoginInfo.get("loginPwd");
        //JDBC代码
        Connection conn = null;
        PreparedStatement ps = null;//使用PreparedStatement(预编译的数据库操作对象)
        ResultSet rs = null;
        try {
            //1.注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.获取连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=UTC", "root", "1122");
            //3.获取预编译的数据库操作对象
            //SQL语句的框架，一个问号表示一个占位符，一个问号将来接收一个“值”，占位符不能使用单引号括起来
            String sql = "select * from t_user where loginName=? and loginPwd=?";
            //程序执行到此处，会发送SQL语句框架给DBMS，然后DBMS进行SQL语句的预先编译
            ps = conn.prepareStatement(sql);
            //给占位符？传值（第一个问号下标是1，第二个问号下标是2，JDBC中所有下标从1开始）
            ps.setString(1, loginName);
            ps.setString(2, loginPwd);

            //4.执行SQL语句   SQL注入： 用户名：abc 密码：abc'or'1'='1
            rs = ps.executeQuery();
            //5.处理查询结果集
            if (rs.next()) {
                loginSuccess = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //6.释放资源
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
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
        return loginSuccess;
    }

    /*
     * 初始化用户界面
     * @return 用户输入的用户名和密码等登录信息
     * */
    private static Map<String, String> initUI() {
        Scanner s = new Scanner(System.in);
        System.out.println("用户名：");
        String loginName = s.nextLine();
        System.out.println("密码：");
        String loginPwd = s.nextLine();

        Map<String, String> userLoginInfo = new HashMap<>();
        userLoginInfo.put("loginName", loginName);
        userLoginInfo.put("loginPwd", loginPwd);

        return userLoginInfo;
    }


}
