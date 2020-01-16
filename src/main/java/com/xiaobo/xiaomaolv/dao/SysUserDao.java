package com.xiaobo.xiaomaolv.dao;

import com.xiaobo.xiaomaolv.entity.SysUser;
import com.xiaobo.xiaomaolv.entity.VisitLog;
import org.springframework.stereotype.Repository;
import java.util.LinkedList;
import java.util.Map;

@Repository
public interface SysUserDao {
    SysUser findByUser(SysUser sysUser);

    int addUser(SysUser user);

    Map<String,Object> queryMineAccountInfo(Map map);


}
