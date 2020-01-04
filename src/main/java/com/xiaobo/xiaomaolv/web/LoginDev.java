package com.xiaobo.xiaomaolv.web;

import com.xiaobo.xiaomaolv.constdata.Const;
import com.xiaobo.xiaomaolv.dto.UserSession;
import com.xiaobo.xiaomaolv.entity.AppResponse;
import com.xiaobo.xiaomaolv.entity.SysUser;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    @Autowired
    private WebSocketServer webSocketServer;
    @RequestMapping("loginDev")
    public AppResponse loginDev(HttpServletRequest request,SysUser sysUser){
        AppResponse appResponse = new AppResponse();
        //登陆时候创建session
        HttpSession session =  request.getSession();
        session.setAttribute(Const.USER_ID,sysUser.getId());
        UserSession.setProperty(Const.USER_ID,sysUser.getId());
        log.info("登陆用户id"+sysUser.getId());
        log.info(session.getId()+":sessionID");
        appResponse.setAppData(sysUser);
        appResponse.setMessage(Const.ERROR_MSG_USER_LOGIN_SUCCESS);
        appResponse.setStatusCode(200);
        return appResponse;
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(User user) throws Exception{
        log.info(user.getUsername()+"进入聊天室!");
        webSocketServer.sendInfo(user.getUsername()+"进入聊天室!");
        return user.getUsername();
    }


    @Data
    public static class User{
        private String username;
        private String password;
    }
}

