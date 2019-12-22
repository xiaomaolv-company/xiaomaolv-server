package com.xiaobo.xiaomaolv.Service.Impl;

import com.xiaobo.xiaomaolv.Service.AppDetailService;
import com.xiaobo.xiaomaolv.dao.AppDao;
import com.xiaobo.xiaomaolv.dao.AppDetailDao;
import com.xiaobo.xiaomaolv.entity.CostRecorder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppDetailServiceImpl implements AppDetailService {
    @Autowired
    private AppDetailDao appDetailDao;
    @Override
    public int addCostRecorder(CostRecorder costRecorder) {
        return appDetailDao.addCostRecorder(costRecorder);
    }
}
