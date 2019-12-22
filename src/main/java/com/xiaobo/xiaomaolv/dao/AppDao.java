package com.xiaobo.xiaomaolv.dao;

import com.xiaobo.xiaomaolv.entity.CostConfig;
import com.xiaobo.xiaomaolv.entity.CostRecorder;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
@Repository
public interface AppDao {

    List queryAllTabBar();

    List<HashMap<String, Object>> queryAllFunc();

    List<CostConfig> queryAllConfig();

}
