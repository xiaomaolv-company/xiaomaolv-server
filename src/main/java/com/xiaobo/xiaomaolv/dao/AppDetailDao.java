package com.xiaobo.xiaomaolv.dao;

import com.xiaobo.xiaomaolv.entity.CostRecorder;
import org.springframework.stereotype.Repository;

@Repository
public interface AppDetailDao {
    int addCostRecorder(CostRecorder costRecorder);
}
