package com.xiaobo.xiaomaolv.web.app;

import com.xiaobo.xiaomaolv.Service.AppDetailService;
import com.xiaobo.xiaomaolv.entity.AppResponse;
import com.xiaobo.xiaomaolv.entity.CostRecorder;
import com.xiaobo.xiaomaolv.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/app")
public class AppDetailManage {
    @Autowired
    private AppDetailService appDetailService;

    @RequestMapping(value = "/addCostDetail",method = RequestMethod.POST)
    public AppResponse addCost(@RequestBody CostRecorder costRecorder, HttpServletRequest request, HttpServletResponse response){
        AppResponse appResponse = new AppResponse();
        response.setHeader("connection", "keep-alive");
        long userId = (Long) request.getSession().getAttribute("userId");
        costRecorder.setUserId(userId);
        int result = appDetailService.addCostRecorder(costRecorder);
        if(result==1){
            appResponse.setMessage("添加成功");
            appResponse.setAppData(costRecorder);
            appResponse.setStatusCode(200);
        }else{
            appResponse.setStatusCode(-1);
            appResponse.setMessage("添加失败");
            appResponse.setAppData(costRecorder);
        }
        return appResponse;
    }

    @RequestMapping(value = "/queryCostList",method = RequestMethod.POST)
    public AppResponse queryCostListByUserId(CostRecorder costRecorder){
        return appDetailService.queryCostDetail(costRecorder);
    }

}
