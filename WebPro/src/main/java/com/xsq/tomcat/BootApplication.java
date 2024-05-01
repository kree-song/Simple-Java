package com.xsq.tomcat;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import java.io.File;

//内嵌tomcat
public class BootApplication {
    public static void start(Class<?> clazz, String[] args) {
        //环境参数配置
        int port = 8080;
        String contextPath = "/";
        String docBase = "testweb/web";

        //配置tomcat实例
        Tomcat tomcat = new Tomcat();
        //tomcat.setHostname("localhost");
        tomcat.setPort(port);
        tomcat.addWebapp(contextPath, new File(docBase).getAbsolutePath());

        //启动tomcat
        try {
            tomcat.start();
            System.out.println("tomcat启动成功");
            tomcat.getServer().await();

        } catch (LifecycleException e) {

            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        BootApplication.start(BootApplication.class, args);
    }

}
