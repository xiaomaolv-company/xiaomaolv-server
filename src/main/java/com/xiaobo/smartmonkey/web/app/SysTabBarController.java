package com.xiaobo.smartmonkey.web.app;

import com.xiaobo.smartmonkey.Service.AppService;
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
    public List<HashMap<String,Object>> queryAllTabBar(){
        System.out.println("进入放啊");
        return appService.queryAllTabBar();
    }

    /**
     * 获取功能区菜单
     * @return   nc -z -w 1 172.81.203.18:8080
     */
    @RequestMapping(value = "/app/SysTabBarController/queryAllFuncList")
    public List<HashMap<String,Object>> queryAllFuncList(){
        return appService.queryAllFunc();
    }
}
