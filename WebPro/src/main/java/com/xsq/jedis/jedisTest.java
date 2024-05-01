package com.xsq.jedis;

import redis.clients.jedis.Jedis;

public class jedisTest {
    public static void main(String[] args) {
        //1.获取连接对象
        //Jedis jedis=new Jedis("192.168.23.129",6379);
        //Jedis jedis= JedisUtil.getJedis();
        Jedis jedis = JedisUtil02.getJedis();
        //2.执行操作
        /*jedis.set("a","123");
        System.out.println(jedis.get("a"));*/

        /*jedis.lpush("list1","a","b","c");
        List<String> list1 = jedis.lrange("list1",0, -1);
        for(String s:list1){
            System.out.println(s);
        }*/

        jedis.sadd("set1", "abc", "abc", "def", "ghi", "jkl", "mno");
        Long slen = jedis.scard("set1");
        System.out.println(slen);

        //3.关闭连接
        jedis.close();
    }
}
