package com.xiaobo.smartmonkey.dao;

import java.util.HashMap;
import java.util.List;

public interface AppDao {
    List queryAllTabBar();

    List<HashMap<String, Object>> queryAllFunc();
}
