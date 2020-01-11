package com.xiaobo.xiaomaolv.Service.Impl;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xiaobo.xiaomaolv.Service.AppService;
import com.xiaobo.xiaomaolv.constdata.Const;
import com.xiaobo.xiaomaolv.dao.AppDao;
import com.xiaobo.xiaomaolv.dto.UserSession;
import com.xiaobo.xiaomaolv.entity.AppResponse;
import com.xiaobo.xiaomaolv.entity.CostConfig;
import com.xiaobo.xiaomaolv.entity.SysTabBar;
import com.xiaobo.xiaomaolv.entity.SysUser;
import com.xiaobo.xiaomaolv.util.Redis.JedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AppServiceImpl implements AppService {

    Logger logger = LoggerFactory.getLogger(AppServiceImpl.class);
    @Autowired
    private AppDao appDao;
    @Autowired
    private JedisUtil jedisUtil;

    @Override
    public List<HashMap<String, Object>> queryAllTabBar() {
        List<HashMap<String, Object>> tabList = new ArrayList<>();
        //底部菜单信息在redis中的键
        String key = SYSTABBAR;
        ObjectMapper objectMapper = new ObjectMapper();
        //先判断redis是否存在底部菜单信息
        if (jedisUtil.isExistKey(key)) {
            //如果redis中存在底部菜单信息则直接从redis中读取
            String jsonTabbar = null;
            jsonTabbar = jedisUtil.get(key);
            JavaType javaType = objectMapper.getTypeFactory().constructParametricType(ArrayList.class,SysTabBar.class);
            try {
                tabList = objectMapper.readValue(jsonTabbar, javaType);
            } catch (JsonParseException e) {
                e.printStackTrace();
                logger.info(e.getMessage());
            } catch (JsonMappingException e) {
                e.printStackTrace();
                logger.info(e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            //如果redis不存在则查询数据库
            tabList = appDao.queryAllTabBar();
            //将查询到的数据写入redis
            String jsonString = null;
            try {
                jsonString = objectMapper.writeValueAsString(tabList);
                jedisUtil.set(key, jsonString);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return tabList;
    }


    @Override
    public List<CostConfig> queryAllConfig() {
        String key = COSTCONFIG;
        List<CostConfig> list = new ArrayList<>();
        if(jedisUtil.isExistKey(key)){
            //如果redis中存在直接从redis中读取
            ObjectMapper mapper = new ObjectMapper();
            String jsonString = null;
            jsonString = jedisUtil.get(key);
            JavaType javaType = mapper.getTypeFactory().constructParametricType(ArrayList.class,CostConfig.class);
            try {
                list = mapper.readValue(jsonString,javaType);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            //如果redis不存在直接从数据库读取
            list = appDao.queryAllConfig();
            //将数据写入redis
            ObjectMapper mapper = new ObjectMapper();
            String jsonString = null;
            try {
                jsonString = mapper.writeValueAsString(list);
                System.out.println("消费类型信息:"+jsonString);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    @Override
    public AppResponse queryUserData() {
        AppResponse appResponse = new AppResponse();
        Map<String,Object> map = new HashMap<>();
        long userId = UserSession.getUserId();
        map.put("userId",userId);
        SysUser sysUser = appDao.queryUserData(map);
        if(sysUser!=null){
            appResponse.setStatusCode(Const.SUCCESS_CODE_CALLBACK);
            appResponse.setAppData(sysUser);
            appResponse.setMessage(Const.ERROR_MSG_QUERY_SUCCESS);
        }
        return appResponse;
    }


}
