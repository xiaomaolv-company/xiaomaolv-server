package com.xiaobo.smartmonkey.Service;

import java.util.HashMap;
import java.util.List;

public interface AppService {
    public List<HashMap<String,Object>> queryAllTabBar();

    List<HashMap<String, Object>> queryAllFunc();
}
