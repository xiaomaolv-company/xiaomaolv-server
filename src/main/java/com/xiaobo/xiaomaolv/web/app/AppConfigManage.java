package com.xiaobo.xiaomaolv.web.app;

import com.xiaobo.xiaomaolv.Service.AppService;
import com.xiaobo.xiaomaolv.entity.AppResponse;
import com.xiaobo.xiaomaolv.entity.SysUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/app")
public class AppConfigManage{

    Logger log = LoggerFactory.getLogger(AppConfigManage.class);

    @Autowired
    private AppService appService;

    /**
     * 获取底部bar菜单
     * @return
     */
    @RequestMapping(value = "/queryAllTabBar",method = {RequestMethod.GET})
    public AppResponse queryAllTabBar(SysUser sysUser, HttpServletRequest request){
        AppResponse appResponse = new AppResponse();
        List<HashMap<String,Object>> appData = appService.queryAllTabBar();
        appResponse.setAppData(appData);
        appResponse.setMessage("成功返回底部菜单信息");
        appResponse.setStatusCode(200);
        return appResponse;
    }


}
