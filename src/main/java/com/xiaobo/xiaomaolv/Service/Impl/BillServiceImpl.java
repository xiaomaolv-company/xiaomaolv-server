package com.xiaobo.xiaomaolv.Service.Impl;

import com.xiaobo.xiaomaolv.Service.BillService;
import com.xiaobo.xiaomaolv.constdata.Const;
import com.xiaobo.xiaomaolv.dao.BillDao;
import com.xiaobo.xiaomaolv.dto.UserSession;
import com.xiaobo.xiaomaolv.entity.AppResponse;
import com.xiaobo.xiaomaolv.web.app.AppBillManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BillServiceImpl implements BillService {

    @Autowired
    private BillDao billDao;

    @Override
    public AppResponse queryBillByMonth(AppBillManage.BillParamer billParamer) {
        Map<String,Object> map = new HashMap<>();
        map.put("userId", UserSession.getUserId());
        map.put("year",billParamer.getYear());
        List<Map<String,Object>> billList = billDao.queryBillByMonth(map);
        AppResponse appResponse = new AppResponse(billList,200, Const.ERROR_MSG_QUERY_SUCCESS);
        return appResponse;
    }
}
