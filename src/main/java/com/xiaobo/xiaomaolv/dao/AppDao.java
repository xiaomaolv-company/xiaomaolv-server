package com.xiaobo.xiaomaolv.dao;

import com.xiaobo.xiaomaolv.entity.CostConfig;
import com.xiaobo.xiaomaolv.entity.CostRecorder;
import com.xiaobo.xiaomaolv.entity.SysUser;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public interface AppDao {

    List queryAllTabBar();

    List<HashMap<String, Object>> queryAllFunc();

    List<CostConfig> queryAllConfig();

    SysUser queryUserData(Map<String, Object> map);
}
