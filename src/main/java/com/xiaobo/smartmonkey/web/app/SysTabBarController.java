package com.xiaobo.smartmonkey.web.app;

import com.xiaobo.smartmonkey.Service.AppService;
import com.xiaobo.smartmonkey.entity.AppResponse;
import com.xiaobo.smartmonkey.util.WeChat.SignUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

@RestController
public class SysTabBarController {
    @Autowired
    private AppService appService;

    /**
     * 获取底部bar菜单
     * @return
     */
    @RequestMapping(value = "/app/SysTabBarController/queryAllTabBar")
    public AppResponse queryAllTabBar(){
        AppResponse appResponse = new AppResponse();
        System.out.println("进入放啊");
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
        appResponse.setMessage("成功返回功能菜单信息");
        appResponse.setStatusCode(200);
        return appResponse;
    }
}
