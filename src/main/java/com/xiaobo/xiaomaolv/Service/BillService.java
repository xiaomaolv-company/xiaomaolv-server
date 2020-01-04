package com.xiaobo.xiaomaolv.Service;

import com.xiaobo.xiaomaolv.entity.AppResponse;
import com.xiaobo.xiaomaolv.web.app.AppBillManage;

public interface BillService {
    AppResponse queryBillByMonth(AppBillManage.BillParamer billParamer);
}
