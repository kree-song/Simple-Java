package com.xsq.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ResourceBundle;

public class JedisUtil02 {
    private static JedisPoolConfig jpc;
    private static JedisPool jp;
    private static int maxIdel;
    private static int maxTotal;
    private static String host;
    private static int port;

    static {
        //从配置文件拿数据
        ResourceBundle bundle = ResourceBundle.getBundle("redis");
        maxIdel = Integer.parseInt(bundle.getString("redis.maxIdel"));
        maxTotal = Integer.parseInt(bundle.getString("redis.maxTotal"));
        host = bundle.getString("redis.host");
        port = Integer.parseInt(bundle.getString("redis.port"));
        //Jedis连接池配置
        jpc = new JedisPoolConfig();
        jpc.setMaxIdle(maxIdel);
        jpc.setMaxTotal(maxTotal);
        jp = new JedisPool(jpc, host, port);
    }

    public static Jedis getJedis() {
        return jp.getResource();
    }
}
