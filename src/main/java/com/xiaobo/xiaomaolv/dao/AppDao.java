package com.xiaobo.xiaomaolv.dao;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
@Repository
public interface AppDao {

    List queryAllTabBar();

    List<HashMap<String, Object>> queryAllFunc();
}
