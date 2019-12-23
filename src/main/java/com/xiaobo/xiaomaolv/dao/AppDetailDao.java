package com.xiaobo.xiaomaolv.dao;

import com.xiaobo.xiaomaolv.entity.CostRecorder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppDetailDao {
    int addCostRecorder(CostRecorder costRecorder);

    List<CostRecorder> queryDetail(CostRecorder costRecorder);
}