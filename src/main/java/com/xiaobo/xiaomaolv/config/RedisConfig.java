package com.xiaobo.xiaomaolv.config;

import com.xiaobo.xiaomaolv.util.Redis.JedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisConfig extends CachingConfigurerSupport {

    Logger logger = LoggerFactory.getLogger(RedisConfig.class);

    @Value("${redis.host}")
    private String hostName;

    @Value("${redis.port}")
    private int port;

    @Value("${redis.jedis.pool.max-active}")
    private int maxTotal;

    @Value("${redis.jedis.pool.max-idle}")
    private int maxIdle;

    @Value("${redis.jedis.pool.max-wait}")
    private long maxWaitMillis;

    @Value("${redis.pool.testOnBorrow}")
    private boolean testOnBorrow;

    @Value("${redis.password}")
    private String password;
    @Value("${redis.timeout}")
    private int timeOut;

    @Autowired
    private JedisPoolConfig jedisPoolConfig;

    @Autowired
    private JedisPool jedisPool;


    /**
     * 创建redis连接池的设置
     * @return
     */
    @Bean
    public JedisPoolConfig jedisPoolConfig(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(maxTotal);
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
        jedisPoolConfig.setTestOnBorrow(testOnBorrow);
        return jedisPoolConfig;
    }

    /**
     *创建redis连接池
     * @return
     */
    @Bean
    public JedisPool redisPoolFactory(){
        JedisPool jedisPool = new JedisPool(jedisPoolConfig,hostName,port,timeOut,password);
        logger.info("JedisPool注入成功");
        logger.info("redis地址:"+hostName+",端口:"+port);
        return jedisPool;
    }

    /**
     *创建redis的工具类  封装redis的连接以进行相关操作
     * @return
     */
    @Bean
    public JedisUtil jedisUtil(){
        JedisUtil jedisUtil = new JedisUtil();
        jedisUtil.setJedisPool(jedisPool);
        return jedisUtil;
    }

}
