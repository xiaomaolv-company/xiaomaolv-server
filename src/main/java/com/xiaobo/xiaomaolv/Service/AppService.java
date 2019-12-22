package com.xiaobo.xiaomaolv.Service;

import com.xiaobo.xiaomaolv.entity.CostConfig;
import com.xiaobo.xiaomaolv.entity.CostRecorder;

import java.util.HashMap;
import java.util.List;

public interface AppService {
    /**
     * 获取底部菜单信息
     * @return
     */
    List<HashMap<String,Object>> queryAllTabBar();

    /**
     * 获取所有消费类型信息
     * @return
     */
    List<CostConfig> queryAllConfig();


}
