package com.xiaobo.xiaomaolv.redis;

import com.xiaobo.xiaomaolv.util.Redis.JedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.servlet.ServletContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

//    @Autowired
//    private JedisPool jedisPool;
    @Autowired
    private JedisUtil jedisUtil;

//    @Test
//    public void testJedisDemo01(){
//        Jedis jedis = jedisPool.getResource();
//        String value = jedis.get("id");
//        assert (value!=null);
//    }

    @Test
    public void tetsJedisDemo02(){
        WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
        ApplicationContext ctx = wac;
        JedisPool jedisPool = ctx.getBean(JedisPool.class);
        String id = jedisUtil.get("id");
        assert id!=null;
    }

    @Test
    public void testJedisDemo03(){
        long value = jedisUtil.generateId();
        assert value>0;
    }
}
