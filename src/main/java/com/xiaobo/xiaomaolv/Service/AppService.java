package com.xiaobo.xiaomaolv.Service;

import java.util.HashMap;
import java.util.List;

public interface AppService {
    List<HashMap<String,Object>> queryAllTabBar();

    List<HashMap<String, Object>> queryAllFunc();
}
