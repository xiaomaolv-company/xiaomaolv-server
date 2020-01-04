package com.xiaobo.xiaomaolv.Service;

import com.xiaobo.xiaomaolv.entity.AppResponse;
import com.xiaobo.xiaomaolv.entity.CostRecorder;

public interface AppDetailService {
    /**
     * 添加消费记录
     * @param costRecorder
     * @return
     */
    AppResponse addCostRecorder(CostRecorder costRecorder);

    AppResponse queryCostDetail();
}
