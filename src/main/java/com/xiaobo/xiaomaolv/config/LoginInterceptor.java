package com.xiaobo.xiaomaolv.config;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.xiaobo.xiaomaolv.constdata.Const;
import com.xiaobo.xiaomaolv.dto.UserSession;
import com.xiaobo.xiaomaolv.entity.AppResponse;
import com.xiaobo.xiaomaolv.entity.SysUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.OutputStream;

/**
 * 拦截请求  如果没有session返回登陆页面
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    /**
     * 处理请求
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(handler instanceof HandlerMethod){
            String methodName = ((HandlerMethod) handler).getMethod().getName();
            if("loginDev".equals(methodName) || "weChatUserLogin".equals(methodName)){
                return true;
            }
            logger.info("请求方法名:"+methodName);
            //如果请求时登陆请求就通过
            //获取请求session  参数false 如果有session通过  没有就不新建session
            HttpSession session = request.getSession(false);
            if(session==null){
                LoginInterceptor.errMesage(response,Const.ERROR_MSG_USER_NOT_LOGIN);
                return false;
            }
            SysUser sysUser = new SysUser();
            sysUser.setId((Long) request.getSession().getAttribute(Const.USER_ID));
            UserSession.setProperty(Const.USER_ID,session.getAttribute(Const.USER_ID));
            UserSession.setProperty(Const.USER_NAME,session.getAttribute(Const.USER_NAME));
            return true;
        }

        return false;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        UserSession.removeSession();
        logger.info("请求方法之后处理");
    }

    private static void errMesage(HttpServletResponse response, String codeMsg)throws Exception{
        response.setContentType("application/json;charset=UTF-8");
        OutputStream outputStream = response.getOutputStream();
        AppResponse appResponse = new AppResponse(null,Const.ERROR_CODE_USER_NOT_LOGIN,codeMsg);
        ObjectMapper objectMapper = new ObjectMapper();
        String str = objectMapper.writeValueAsString(appResponse);
        outputStream.write(str.getBytes("UTF-8"));
        outputStream.flush();
        outputStream.close();
    }
}
