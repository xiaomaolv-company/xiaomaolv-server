package com.xiaobo.xiaomaolv.Service.Impl;

import com.xiaobo.xiaomaolv.Service.VisitLogService;
import com.xiaobo.xiaomaolv.dao.VisitLogDao;
import com.xiaobo.xiaomaolv.entity.VisitLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisitLogServiceImpl implements VisitLogService {

    @Autowired
    private VisitLogDao visitLogDao;

    @Override
    public int addVisitLog(VisitLog visitLog) {
        return visitLogDao.addVisitLog(visitLog);
    }
}
