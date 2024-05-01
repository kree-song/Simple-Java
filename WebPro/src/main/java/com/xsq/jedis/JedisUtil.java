package com.xsq.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisUtil {
    public static Jedis getJedis() {
        //Jedis连接池配置
        JedisPoolConfig jpc = new JedisPoolConfig();
        jpc.setMaxIdle(10);
        jpc.setMaxTotal(50);

        String host = "192.168.23.129";
        int port = 6379;
        //Jedis连接池对象
        JedisPool jp = new JedisPool(jpc, host, port);
        return jp.getResource();
    }

}
