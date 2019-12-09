package com.xiaobo.smartmonkey.Service.Impl;

import com.xiaobo.smartmonkey.Service.AppService;
import com.xiaobo.smartmonkey.dao.AppDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class AppServiceImpl implements AppService {
    @Autowired(required = false)
    private AppDao appDao;
    @Override
    public List<HashMap<String, Object>> queryAllTabBar() {
        return appDao.queryAllTabBar();
    }

    @Override
    public List<HashMap<String, Object>> queryAllFunc() {
        return appDao.queryAllFunc();
    }


}
