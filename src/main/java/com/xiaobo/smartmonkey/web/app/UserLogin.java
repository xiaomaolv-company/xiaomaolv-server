package com.xiaobo.smartmonkey.web.app;

import com.xiaobo.smartmonkey.entity.AppResponse;
import com.xiaobo.smartmonkey.entity.SysUser;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class UserLogin {
    /**
     * 用户登录方法
     * @param sysUser
     * @param servletRequest
     * @return
     */
    @RequestMapping(value = "/app/userLogin",method = RequestMethod.POST)
    public AppResponse userLogin(SysUser sysUser, HttpServletRequest servletRequest){

        AppResponse appResponse = new AppResponse();
        HttpSession session = servletRequest.getSession();

        return appResponse;
    }

}
