package com.xiaobo.xiaomaolv.Service;

import com.xiaobo.xiaomaolv.entity.AppResponse;
import com.xiaobo.xiaomaolv.entity.CostRecorder;
import com.xiaobo.xiaomaolv.web.app.AppBillManage;

public interface AppDetailService {
    /**
     * 添加消费记录
     * @param costRecorder
     * @return
     */
    AppResponse addCostRecorder(CostRecorder costRecorder);

    AppResponse queryCostDetail(AppBillManage.BillParamer paramer);
}
