package com.xiaobo.xiaomaolv.web.app;

import com.xiaobo.xiaomaolv.Service.AppService;
import com.xiaobo.xiaomaolv.constdata.Const;
import com.xiaobo.xiaomaolv.entity.AppResponse;
import com.xiaobo.xiaomaolv.entity.CostConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 记账
 */
@RestController
@RequestMapping(value = "/app")
public class AppAccountManage {

    @Autowired
    private AppService appService;



    /**
     * 查询费用类型信息
     * @return
     */
    @RequestMapping(value = "/queryCostType",method = {RequestMethod.GET})
    public AppResponse queryCostTypeConfig(HttpServletResponse response){
        List<CostConfig> costConfigs = appService.queryAllConfig();
        AppResponse appResponse = new AppResponse(costConfigs, 200,Const.ERROR_MSG_QUERY_SUCCESS);
        return appResponse;
    }
}
