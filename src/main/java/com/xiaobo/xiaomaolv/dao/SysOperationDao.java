package com.xiaobo.xiaomaolv.dao;

import com.xiaobo.xiaomaolv.entity.SysOperation;
import org.springframework.stereotype.Repository;

@Repository
public interface SysOperationDao {
    int addOperation(SysOperation sysOperation);
}
