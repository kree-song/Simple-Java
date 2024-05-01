package com.xsq.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class jdbcTest1 {
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
        Statement stmt = null;
        ResultSet rs = null;
        //1.注册驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.获取连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=UTC", "root", "1122");
            //3.获取数据库操作对象
            stmt = conn.createStatement();
            //4.执行SQL语句                               SQL注入： 用户名：abc                   密码：abc'or'1'='1
            String sql = "select * from t_user where loginName='" + loginName + "' and loginPwd='" + loginPwd + "'";
            rs = stmt.executeQuery(sql);
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
