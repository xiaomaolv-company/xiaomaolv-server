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
    public AppResponse queryCostDetail(CostRecorder costRecorder) {
        long userId = UserSession.getUserId();
        costRecorder.setUserId(userId);
        int page = costRecorder.getPage();
        int rows = costRecorder.getRows();
        costRecorder.setPage((page-1)*rows);
        List<HashMap<String,Object>> recorderList = appDetailDao.queryDetail(costRecorder);
        Map<String, Object> recorderMap = new HashMap<>();
        recorderMap.put("recorderList", recorderList);
        AppResponse appResponse = new AppResponse(recorderMap, Const.SUCCESS_CODE_CALLBACK, "消费记录信息");
        return appResponse;
    }


}
