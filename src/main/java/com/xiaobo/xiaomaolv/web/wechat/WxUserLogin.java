package com.xiaobo.smartmonkey.web.wechat;

import com.xiaobo.smartmonkey.util.WeChat.SignUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 注册微信服务器配置
 */
@RestController
public class WxUserLogin {
    @RequestMapping(value = "/wechat")
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("开始进入doGet方法");
        // 微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
        String signature = request.getParameter("signature");
        // 时间戳
        String timestamp = request.getParameter("timestamp");
        // 随机数
        String nonce = request.getParameter("nonce");
        // 随机字符串
        String echostr = request.getParameter("echostr");

        // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
        PrintWriter out = null;
        try {
            out = response.getWriter();
            System.out.println("开始检验");
            if (SignUtil.checkSignature(signature, timestamp, nonce)) {
                System.out.println("校验成功");
                out.print(echostr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null)
                out.close();
        }
    }
}
