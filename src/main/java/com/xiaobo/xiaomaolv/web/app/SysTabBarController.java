package com.xiaobo.xiaomaolv.web.app;

import com.xiaobo.xiaomaolv.Service.AppService;
import com.xiaobo.xiaomaolv.entity.AppResponse;
import com.xiaobo.xiaomaolv.util.Redis.JedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class SysTabBarController {
    static Logger log = LoggerFactory.getLogger(SysTabBarController.class);

    @Autowired
    private AppService appService;
    @Autowired
    private JedisUtil jedisUtil;

    /**
     * 获取底部bar菜单
     * @return
     */
    @RequestMapping(value = "/app/SysTabBarController/queryAllTabBar")
    public AppResponse queryAllTabBar(){
        AppResponse appResponse = new AppResponse();
        List<HashMap<String,Object>> appData = appService.queryAllTabBar();
        appResponse.setAppData(appData);
        appResponse.setMessage("成功返回底部菜单信息");
        appResponse.setStatusCode(200);
        return appResponse;
    }

    /**
     * 获取功能区菜单
     * @return   nc -z -w 1 172.81.203.18:8080
     */
    @RequestMapping(value = "/app/SysTabBarController/queryAllFuncList")
    public AppResponse queryAllFuncList(){
        AppResponse appResponse = new AppResponse();
        List<HashMap<String,Object>> appData = appService.queryAllFunc();
        appResponse.setAppData(appData);
        appResponse.setMessage("成功返回功能菜单信息");
        appResponse.setStatusCode(200);
        return appResponse;
    }
}
