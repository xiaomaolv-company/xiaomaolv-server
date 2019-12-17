package com.xiaobo.xiaomaolv.dao;

import com.xiaobo.xiaomaolv.entity.VisitLog;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitLogDao {
    int addVisitLog(VisitLog visitLog);
}
