package com.xiaobo.xiaomaolv.web.webRequestRpc;

import com.xiaobo.xiaomaolv.entity.AppResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class WebRequestRpcController {

    @RequestMapping(value = "/app",method = RequestMethod.POST)
    public AppResponse invokeRpc(@PathVariable String serviceName,
                                 @PathVariable String methodName,
                                 @PathVariable String payLoad,
                                 HttpServletRequest req, HttpServletResponse httpResponse) {
        AppResponse appResponse = new AppResponse();

        return appResponse;
    }
}
