package com.xiaobo.xiaomaolv.Service.Impl;

import com.xiaobo.xiaomaolv.Service.AppChartService;
import com.xiaobo.xiaomaolv.constdata.Const;
import com.xiaobo.xiaomaolv.dao.AppChartDao;
import com.xiaobo.xiaomaolv.dto.UserSession;
import com.xiaobo.xiaomaolv.entity.AppResponse;
import com.xiaobo.xiaomaolv.entity.ChartData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AppChartServiceImpl implements AppChartService {
    @Autowired
    private AppChartDao appChartDao;
    @Override
    public AppResponse getChartData(ChartData chartData) {
        long userId = UserSession.getUserId();
        String year = chartData.getYear();
        String month = chartData.getMonth();
        String day = chartData.getDay();
        chartData.setUserId(userId);
        List<Map<String,Object>> chartDataList = appChartDao.getChartData(chartData);
        AppResponse appResponse = new AppResponse(chartDataList,Const.SUCCESS_CODE_CALLBACK, Const.ERROR_MSG_QUERY_SUCCESS);
        return appResponse;
    }
}
