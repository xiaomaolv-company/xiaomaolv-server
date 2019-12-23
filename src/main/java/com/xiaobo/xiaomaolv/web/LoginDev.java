package com.xiaobo.xiaomaolv.web;

import com.xiaobo.xiaomaolv.entity.AppResponse;
import com.xiaobo.xiaomaolv.entity.SysUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 开发测试登陆
 */
@RestController
public class LoginDev {
    Logger log = LoggerFactory.getLogger(LoginDev.class);

    @RequestMapping("loginDev")
    public AppResponse loginDev(HttpServletRequest request, HttpServletResponse response, SysUser sysUser) throws Exception{
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("connection", "keep-alive");
//        response.addHeader("Access-Control-Allow-Method", "*");
//        response.addHeader("Access-Control-Allow-Headers","Content-Type");
//        response.addHeader("Access-Control-Max-Age", "3600");
        AppResponse appResponse = new AppResponse();
        log.info("登陆用户id"+sysUser.getId());
        HttpSession session = request.getSession();
        log.info(session.getId()+"sessionID");
        session.setAttribute("userId",sysUser.getId());
        appResponse.setAppData(sysUser);
        appResponse.setMessage("登陆成功");
        return appResponse;
    }
}
