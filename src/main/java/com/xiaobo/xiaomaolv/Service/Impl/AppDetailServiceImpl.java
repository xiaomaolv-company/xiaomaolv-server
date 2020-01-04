package com.xiaobo.xiaomaolv.Service.Impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xiaobo.xiaomaolv.Service.AppDetailService;
import com.xiaobo.xiaomaolv.constdata.Const;
import com.xiaobo.xiaomaolv.dao.AppDetailDao;
import com.xiaobo.xiaomaolv.dto.UserSession;
import com.xiaobo.xiaomaolv.entity.AppResponse;
import com.xiaobo.xiaomaolv.entity.CostRecorder;
import com.xiaobo.xiaomaolv.util.IdUtils;
import com.xiaobo.xiaomaolv.util.Redis.JedisUtil;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AppDetailServiceImpl implements AppDetailService {
    @Autowired
    private AppDetailDao appDetailDao;
    @Autowired
    private JedisUtil jedisUtil;

    @Override
    public AppResponse addCostRecorder(CostRecorder costRecorder) {
        AppResponse appResponse = new AppResponse();
        DateTime dateTime = new DateTime();
        costRecorder.setUserId(UserSession.getUserId());
        costRecorder.setUuid(IdUtils.getUUid());
        costRecorder.setId(jedisUtil.generateId());
        costRecorder.setCreateDatetime(dateTime.toString("yyyy-MM-dd HH:mm:ss"));
        int result = appDetailDao.addCostRecorder(costRecorder);
        //清除redis个人消费信息
        //判断redis中是否有此用户的消费信息键
        String userId = UserSession.getUserId()+"";
        if(jedisUtil.isExistKey(userId)){
            jedisUtil.del(userId);
        }
        if(result==1){
            appResponse.setMessage(Const.ERROR_MSG_INSERT_SUCCESS);
            appResponse.setAppData(costRecorder);
            appResponse.setStatusCode(Const.SUCCESS_CODE_CALLBACK);
        }else{
            appResponse.setStatusCode(Const.ERROR_CODE_INSERT_FAIL);
            appResponse.setMessage(Const.ERROR_MSG_INSERT_SUCCESS);
            appResponse.setAppData(costRecorder);
        }

        return appResponse;
    }

    @Override
    public AppResponse queryCostDetail() {
        long userId = UserSession.getUserId();
        CostRecorder costRecorder = new CostRecorder();
        costRecorder.setUserId(userId);
        String userIdStr = userId+"";
        //先去redis中查询
        String userCostList = jedisUtil.get(userIdStr);
        List<HashMap<String,Object>> recorderList = null;
        if(userCostList==null){
            //如果redis中没有则取数据库中查询
            recorderList = appDetailDao.queryDetail(costRecorder);
            //将数据库中的查询到的数据存入redis中
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonStr = null;
            try {
                jsonStr = objectMapper.writeValueAsString(recorderList);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            jedisUtil.set(userIdStr,jsonStr);
        }else{
            String jsonStr = jedisUtil.get(userIdStr);
            ObjectMapper mapper = new ObjectMapper();
            JavaType javaType = mapper.getTypeFactory().constructParametricType(ArrayList.class,HashMap.class);
            try {
                recorderList = mapper.readValue(jsonStr,javaType);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Map<String, Object> recorderMap = new HashMap<>();
        recorderMap.put("recorderList", recorderList);
        AppResponse appResponse = new AppResponse(recorderMap, Const.SUCCESS_CODE_CALLBACK, "消费记录信息");
        return appResponse;
    }


}
