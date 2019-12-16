package com.xiaobo.xiaomaolv.web.app;

import com.xiaobo.xiaomaolv.Service.SysUserService;
import com.xiaobo.xiaomaolv.dto.UserAccessToken;
import com.xiaobo.xiaomaolv.dto.WechatUser;
import com.xiaobo.xiaomaolv.entity.AppResponse;
import com.xiaobo.xiaomaolv.entity.SysUser;
import com.xiaobo.xiaomaolv.util.IdUtils;
import com.xiaobo.xiaomaolv.util.Redis.JedisUtil;
import com.xiaobo.xiaomaolv.util.WeChat.WechatUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/wechatlogin")
public class UserLogin {

    Logger log = LoggerFactory.getLogger(UserLogin.class);

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private JedisUtil jedisUtil;
    /**
     *
     * @param request
     * @param response
     * 获取关注公众号之后的微信用户信息的接口，如果在微信浏览器里访问
     * https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxa71ab380527ceb2a&redirect_uri=http://xiaobo.vaiwan.com/wechatlogin/app/userLogin&response_type=code&scope=snsapi_userinfo&state=1#wechat_redirect
     * 则这里将会获取到code,之后再可以通过code获取到access_token 进而获取到用户信息
     * @return
     */
    @RequestMapping(value = "/app/userLogin",method = RequestMethod.GET)
    @ResponseBody
    public AppResponse weChatUserLogin(HttpServletRequest request, HttpServletResponse response) {
        AppResponse appResponse = new AppResponse();
        log.debug("weixin login get...");
        // 获取微信公众号传输过来的code,通过code可获取access_token,进而获取用户信息
        String code = request.getHeader("code");
        System.out.println("code"+code);
        log.debug("weixin login code:" + code);
        WechatUser user = null;
        String openId = null;
        SysUser sysUser = null;
        if (null != code) {
            UserAccessToken token;
            try {
                // 通过code获取access_token
                token = WechatUtil.getUserAccessToken(code);
                log.debug("weixin login token:" + token.toString());
                // 通过token获取accessToken
                String accessToken = token.getAccessToken();
                // 通过token获取openId
                openId = token.getOpenId();
                // 通过access_token和openId获取用户昵称等信息
                user = WechatUtil.getUserInfo(accessToken, openId);
                System.out.println(user.toString());
                log.debug("weixin login user:" + user.toString());
                request.getSession().setAttribute("openId", openId);
                SysUser userOpenId = new SysUser();
                userOpenId.setWechatId(openId);
                System.out.println("开始查询");
                sysUser = sysUserService.findByUser(userOpenId);
                System.out.println("查询结束");
//                System.out.println(sysUser.toString());
                Map<String,Object> map = new HashMap<String,Object>();
                if(sysUser!=null){
                    System.out.println("用户为空");
                    //系统中已存在此用户
                    map.put("user",sysUser);
                }else{
                    sysUser = new SysUser();
                    System.out.println("开始生成id");
                    //系统中无此用户 给此微信号在系统中注册账号
                    long id = jedisUtil.generateId();
                    System.out.println(id);
                    sysUser.setId(id);
                    sysUser.setUuid(IdUtils.getUUid());
                    sysUser.setWechatId(openId);
                    sysUser.setCode(user.getNickName());
                    sysUser.setName(user.getNickName());
                    sysUser.setAvater(user.getHeadimgurl());
                    sysUser.setCity(user.getCity());
                    sysUser.setProvince(user.getProvince());
                    sysUser.setPrivilege(user.getPrivilege().toString());
                    System.out.println("添加用户");
                    System.out.println(sysUser.toString());
                    int status = sysUserService.addUser(sysUser);
                    if(status<=0){
                        map.put("user",null);
                        appResponse.setStatusCode(0);
                        appResponse.setMessage("验证失败");
                    }else{
                        map.put("user",sysUser);
                        appResponse.setStatusCode(1);
                        appResponse.setMessage("验证成功");
                    }
                }
                appResponse.setAppData(map);
            } catch (IOException e) {
                log.error("error in getUserAccessToken or getUserInfo or findByOpenId: " + e.toString());
                e.printStackTrace();
            }
        }
        return appResponse;
    }

}
