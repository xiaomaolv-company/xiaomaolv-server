package com.xiaobo.xiaomaolv.dto;

import com.xiaobo.xiaomaolv.constdata.Const;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *用ThreadLocal保存session信息
 */
@SuppressWarnings("unchecked")
public class UserSession{

    private static Logger logger = LoggerFactory.getLogger(UserSession.class);
    private static ThreadLocal<Map> userThreadLocal = new ThreadLocal<>();

    public UserSession(){

    }

    public static Map getData(){
        logger.info("当前线程"+Thread.currentThread().getName());
        Map map = userThreadLocal.get();
        if(map == null){
            map = new ConcurrentHashMap();
            userThreadLocal.set(map);
        }
        return map;
    }

    public static Object getProperty(String key){
        Map map = getData();
        return map.get(key);
    }

    public static void setProperty(String key,Object value){
        Map map = getData();
        if(value!=null){
            map.put(key,value);
        }
    }

    public static long getUserId(){
        Map map = getData();
        return (long) map.get(Const.USER_ID);
    }

    public static void removeSession(){
        userThreadLocal.remove();
    }

}
