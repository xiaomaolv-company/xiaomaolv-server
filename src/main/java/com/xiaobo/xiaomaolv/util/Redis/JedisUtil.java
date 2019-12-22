package com.xiaobo.xiaomaolv.util.Redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.util.SafeEncoder;

import java.util.List;

/**
 * Jedis工具类
 * @author yanxiaobo
 */

public class JedisUtil {

    private JedisPool jedisPool;

    public void setJedisPool(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    public Jedis getResource(){
        return jedisPool.getResource();
    }

    /**
     * 领用redis  incr属性实现自增id
     * @return   返回自增后id的值
     */
    public long generateId(){
        Jedis jedis = getResource();
        long value = jedis.incr("id");
        jedis.close();
        return value;
    }



    /**
     * 根据key获取记录
     * @param key
     * @return
     */
    public String get(String key){
        Jedis jedis = getResource();
        String value = jedis.get(key);
        jedis.close();
        return value;
    }

    /*********************key操作*********************/

    /**
     * 添加记录,如果记录已存在将覆盖原有的value
     * @param key
     * @param value
     * @return
     */
    public String set(String key,String value){
        return set(SafeEncoder.encode(key),SafeEncoder.encode(value));
    }

    /**
     *添加记录,如果记录已存在将覆盖原有的value
     * @param key
     * @param value
     * @return
     */
    public String set(byte[] key, byte[] value) {
        Jedis jedis = getResource();
        String status = jedis.set(key,value);
        jedis.close();
        return status;
    }


    /******list操作**********/
    public long rpush(String key,String value){
        Jedis jedis = getResource();
        long count =  jedis.rpush(key,value);
        jedis.close();
        return count;
    }
    public long rpush(byte[] key,byte[] value){
        Jedis jedis = getResource();
        long count = jedis.rpush(key,value);
        return count;
    }

    public long lpush(String key,String value){
        Jedis jedis = getResource();
        long count = jedis.rpush(key,value);
        jedis.close();
        return count;
    }

    public long lpush(byte[] key,byte[] value){
        Jedis jedis = getResource();
        long count = jedis.lpush(key,value);
        jedis.close();
        return count;
    }


}
