package com.xiaobo.xiaomaolv.dao;

import com.xiaobo.xiaomaolv.dto.WechatUser;
import com.xiaobo.xiaomaolv.entity.SysUser;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserDao {
    SysUser findByUser(SysUser sysUser);

    int addUser(SysUser user);
}
