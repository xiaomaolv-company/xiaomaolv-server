package com.xiaobo.xiaomaolv.dao;

import com.xiaobo.xiaomaolv.entity.CostRecorder;
import com.xiaobo.xiaomaolv.web.app.AppBillManage;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public interface AppDetailDao {
    int addCostRecorder(CostRecorder costRecorder);

    List<HashMap<String,Object>> queryDetail(Map map);
}
