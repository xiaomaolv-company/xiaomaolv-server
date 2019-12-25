package com.xiaobo.xiaomaolv.web.app;

import com.xiaobo.xiaomaolv.Service.AppDetailService;
import com.xiaobo.xiaomaolv.constdata.Const;
import com.xiaobo.xiaomaolv.entity.AppResponse;
import com.xiaobo.xiaomaolv.entity.CostRecorder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/app")
public class AppDetailManage {

    @Autowired
    private AppDetailService appDetailService;

    @RequestMapping(value = "/addCostDetail",method = RequestMethod.POST)
    public AppResponse addCost(@RequestBody CostRecorder costRecorder){
        AppResponse appResponse = new AppResponse();
        int result = appDetailService.addCostRecorder(costRecorder);
        if(result==1){
            appResponse.setMessage(Const.ERROR_MSG_INSERT_SUCCESS);
            appResponse.setAppData(costRecorder);
            appResponse.setStatusCode(200);
        }else{
            appResponse.setStatusCode(Const.ERROR_CODE_INSERT_FAIL);
            appResponse.setMessage(Const.ERROR_MSG_INSERT_SUCCESS);
            appResponse.setAppData(costRecorder);
        }
        return appResponse;
    }

    @RequestMapping(value = "/queryCostList",method = RequestMethod.POST)
    public AppResponse queryCostListByUserId(){
        return appDetailService.queryCostDetail();
    }

}
