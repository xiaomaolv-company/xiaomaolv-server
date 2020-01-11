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
        return appDetailService.addCostRecorder(costRecorder);
    }

    @RequestMapping(value = "/queryCostList",method = {RequestMethod.POST,RequestMethod.GET })
    public AppResponse queryCostListByUserId(@RequestBody AppBillManage.BillParamer paramer){
        return appDetailService.queryCostDetail(paramer);
    }

}
