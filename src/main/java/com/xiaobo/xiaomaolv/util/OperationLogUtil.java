package com.xiaobo.xiaomaolv.util;

import com.xiaobo.xiaomaolv.Service.SysOperationService;
import com.xiaobo.xiaomaolv.Service.VisitLogService;
import com.xiaobo.xiaomaolv.entity.SysOperation;
import com.xiaobo.xiaomaolv.entity.VisitLog;
import com.xiaobo.xiaomaolv.util.Redis.JedisUtil;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;

public class OperationLogUtil {

    private VisitLogService visitLogService;

    private SysOperationService sysOperationService;

    private JedisUtil jedisUtil;

    public void setVisitLogService(VisitLogService visitLogService) {
        this.visitLogService = visitLogService;
    }

    public void setSysOperationService(SysOperationService sysOperationService) {
        this.sysOperationService = sysOperationService;
    }

    public void setJedisUtil(JedisUtil jedisUtil) {
        this.jedisUtil = jedisUtil;
    }

    /**
     * 记录来访用户
     * @param userName
     * @param userId
     * @return
     */
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

    /**
     * 添加操作记录
     * @param userId
     * @param description
     * @param remark
     * @return
     */
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
