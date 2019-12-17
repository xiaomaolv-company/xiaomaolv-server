package com.xiaobo.xiaomaolv.util;

import com.xiaobo.xiaomaolv.Service.SysOperationService;
import com.xiaobo.xiaomaolv.Service.VisitLogService;
import com.xiaobo.xiaomaolv.entity.SysOperation;
import com.xiaobo.xiaomaolv.entity.VisitLog;
import com.xiaobo.xiaomaolv.util.Redis.JedisUtil;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;

public class OperationLogUtil {

    @Autowired
    private VisitLogService visitLogService;
    @Autowired
    private SysOperationService sysOperationService;
    @Autowired
    private JedisUtil jedisUtil;


    public int addVisitUser(String userName, long userId){
        VisitLog visitLog = new VisitLog();
        visitLog.setId(jedisUtil.generateId());
        visitLog.setUuid(IdUtils.getUUid());
        DateTime datetime = new DateTime();
        visitLog.setLoginDatetime(datetime.toString("yyyy-MM-dd HH:mm:ss"));
        visitLog.setUserId(userId);
        visitLog.setLoginUserName(userName);
        return visitLogService.addVisitLog(visitLog);
    }

    public int addOperation(long userId,String description,String remark){
        SysOperation sysOperation = new SysOperation();
        sysOperation.setId(jedisUtil.generateId());
        sysOperation.setUuid(IdUtils.getUUid());
        sysOperation.setUserId(userId);
        DateTime dateTime = new DateTime();
        sysOperation.setOptDatetime(dateTime.toString("yyyy-MM-dd HH:mm:ss"));
        sysOperation.setOptDecription(description);
        sysOperation.setRemark(remark);
        return sysOperationService.addOperation(sysOperation);
    }


}
