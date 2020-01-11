package com.xiaobo.xiaomaolv.web.app;

import com.xiaobo.xiaomaolv.Service.AppService;
import com.xiaobo.xiaomaolv.entity.AppResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class AppUserManage {
    @Autowired
    private AppService appService;

    @RequestMapping(value = "/queryUserData",method = RequestMethod.GET)
    public AppResponse queryUserData(){
        return appService.queryUserData();
    }
}
