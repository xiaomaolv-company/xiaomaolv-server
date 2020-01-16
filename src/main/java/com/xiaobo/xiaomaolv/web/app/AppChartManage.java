package com.xiaobo.xiaomaolv.web.app;

import com.xiaobo.xiaomaolv.Service.AppChartService;
import com.xiaobo.xiaomaolv.entity.AppResponse;
import com.xiaobo.xiaomaolv.entity.ChartData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.applet.AppletResourceLoader;

@RestController
@RequestMapping("/app")
public class AppChartManage {
    @Autowired
    private AppChartService appChartService;
    @RequestMapping(value = "/getChartData",method = RequestMethod.POST)
    public AppResponse getChartData(@RequestBody ChartData chartData){
        return appChartService.getChartData(chartData);
    }

}
