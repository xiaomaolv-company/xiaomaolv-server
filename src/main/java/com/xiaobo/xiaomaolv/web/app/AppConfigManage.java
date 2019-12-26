package com.xiaobo.xiaomaolv.web.app;

import com.xiaobo.xiaomaolv.Service.AppService;
import com.xiaobo.xiaomaolv.constdata.Const;
import com.xiaobo.xiaomaolv.entity.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    public AppResponse queryAllTabBar(){
        AppResponse appResponse = new AppResponse();
        List<HashMap<String,Object>> appData = appService.queryAllTabBar();
        appResponse.setAppData(appData);
        appResponse.setMessage(Const.ERROR_MSG_QUERY_SUCCESS);
        appResponse.setStatusCode(Const.SUCCESS_CODE_CALLBACK);
        return appResponse;
    }


}
