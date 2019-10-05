//package com.amyliascarlet.javademo.redis;
//
//import redis.clients.jedis.JedisPoolConfig;
//
//public class JedisPoolConfigUtil extends JedisPoolConfig {
//
//    private static String maxActive;
//    private static String ip;
//    private static String port;
//    private static String maxWait;
//    private static String maxIdle;
//    private static String testOnBorrow;
//    private static String testOnReturn;
//    private static String password;
//
//
//    public void setIp(String sip) {
//        ip = sip;
//    }
//
//    public static String getIp() {
//        return ip;
//    }
//
//    public void setPort(String port) {
//        JedisPoolConfigUtil.port = port;
//    }
//
//    public static int getPort() {
//        return Integer.parseInt(port);
//    }
//
//    public void setMaxActive(String maxActive) {
//        JedisPoolConfigUtil.maxActive = maxActive;
//    }
//
//    public static String getMaxActive() {
//        return maxActive;
//    }
//
//    public void setMaxWait(String maxWait) {
//        JedisPoolConfigUtil.maxWait = maxWait;
//    }
//
//    public static String getMaxWait() {
//        return maxWait;
//    }
//
//    public void setMaxIdle(String maxIdle) {
//        JedisPoolConfigUtil.maxIdle = maxIdle;
//    }
//
//    public static String getMaxIdle() {
//        return maxIdle;
//    }
//
//    public void setTestOnBorrow(String testOnBorrow) {
//        JedisPoolConfigUtil.testOnBorrow = testOnBorrow;
//    }
//
//    public static String getTestOnBorrow() {
//        return testOnBorrow;
//    }
//
//    public void setTestOnReturn(String testOnReturn) {
//        JedisPoolConfigUtil.testOnReturn = testOnReturn;
//    }
//
//    public static String getTestOnReturn() {
//        return testOnReturn;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public static String getPassword() {
//        return password;
//    }
//}
