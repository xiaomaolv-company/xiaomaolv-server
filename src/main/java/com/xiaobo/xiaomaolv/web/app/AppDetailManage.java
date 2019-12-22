package com.xiaobo.xiaomaolv.web.app;

import com.xiaobo.xiaomaolv.Service.AppDetailService;
import com.xiaobo.xiaomaolv.Service.AppService;
import com.xiaobo.xiaomaolv.dao.AppDetailDao;
import com.xiaobo.xiaomaolv.entity.AppResponse;
import com.xiaobo.xiaomaolv.entity.CostRecorder;
import com.xiaobo.xiaomaolv.util.IdUtils;
import com.xiaobo.xiaomaolv.util.Redis.JedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class AppDetailManage {
    @Autowired
    private AppDetailService appDetailService;
    @Autowired
    private JedisUtil jedisUtil;

//    private static HttpServletRequest request;

    @RequestMapping(value = "/addCostDetail",method = RequestMethod.POST)
    public AppResponse addCost(CostRecorder costRecorder,HttpServletRequest request){
        AppResponse appResponse = new AppResponse();
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

}
