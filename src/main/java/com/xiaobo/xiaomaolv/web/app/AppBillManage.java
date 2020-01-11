package com.xiaobo.xiaomaolv.web.app;

import com.xiaobo.xiaomaolv.Service.BillService;
import com.xiaobo.xiaomaolv.Service.Impl.BillServiceImpl;
import com.xiaobo.xiaomaolv.entity.AppResponse;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/app")
public class AppBillManage {
    @Autowired
    private BillService billService;
    @RequestMapping(value = "/queryBillList",method = RequestMethod.POST)
    public AppResponse queryBillList(@RequestBody BillParamer billParamer){
        return billService.queryBillByMonth(billParamer);
    }

    @Data
    public static class BillParamer{
        private long userId;
        private String year;
    }
}
