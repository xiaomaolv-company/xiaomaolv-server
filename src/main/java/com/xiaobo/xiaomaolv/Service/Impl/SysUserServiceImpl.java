package com.xiaobo.xiaomaolv.Service.Impl;

import com.xiaobo.xiaomaolv.Service.SysUserService;
import com.xiaobo.xiaomaolv.constdata.Const;
import com.xiaobo.xiaomaolv.dao.SysUserDao;
import com.xiaobo.xiaomaolv.dto.UserSession;
import com.xiaobo.xiaomaolv.dto.WechatUser;
import com.xiaobo.xiaomaolv.entity.AppResponse;
import com.xiaobo.xiaomaolv.entity.SysUser;
import com.xiaobo.xiaomaolv.entity.VisitLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserDao sysUserDao;

    @Override
    public SysUser findByUser(SysUser sysUser) {
        return sysUserDao.findByUser(sysUser);
    }

    @Override
    public int addUser(SysUser user) {
        return sysUserDao.addUser(user);
    }

    @Override
    public AppResponse queryUserInfo() {
        long userId = UserSession.getUserId();
        Map map = new HashMap();
        map.put("userId",userId);
        Map<String,Object> mineAccountInfo = sysUserDao.queryMineAccountInfo(map);
        return new AppResponse(mineAccountInfo, Const.SUCCESS_CODE_CALLBACK,Const.ERROR_MSG_QUERY_SUCCESS);
    }


}
