package com.xiaobo.xiaomaolv.Service.Impl;

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
    public int addCostRecorder(CostRecorder costRecorder) {
        DateTime dateTime = new DateTime();
        costRecorder.setUserId(UserSession.getUserId());
        costRecorder.setUuid(IdUtils.getUUid());
        costRecorder.setId(jedisUtil.generateId());
        costRecorder.setCreateDatetime(dateTime.toString("yyyy-MM-dd HH:mm:ss"));
        return appDetailDao.addCostRecorder(costRecorder);
    }

    @Override
    public AppResponse queryCostDetail() {
        CostRecorder costRecorder = new CostRecorder();
        costRecorder.setUserId(UserSession.getUserId());
        List<CostRecorder> recorderList = appDetailDao.queryDetail(costRecorder);
        Map<String, Object> recorderMap = new HashMap<>();
        recorderMap.put("recorderList", recorderList);
        AppResponse appResponse = new AppResponse(recorderMap, Const.SUCCESS_CODE_CALLBACK, "消费记录信息");
        return appResponse;
    }


}
