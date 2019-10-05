package com.amyliascarlet.javademo.redis;

import redis.clients.jedis.Jedis;

public class Redis {

    public Redis(){}

    /**
     * 连接redis服务器
     */
    private static Jedis jedis = new Jedis("localhost");

    /**
     * 连接redis服务器
     */
    public static Jedis getConnection(){
        return jedis;
    }

}
