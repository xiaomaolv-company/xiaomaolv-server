package com.xiaobo.xiaomaolv.Service.Impl;

import com.xiaobo.xiaomaolv.Service.SysUserService;
import com.xiaobo.xiaomaolv.dao.SysUserDao;
import com.xiaobo.xiaomaolv.dto.WechatUser;
import com.xiaobo.xiaomaolv.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
