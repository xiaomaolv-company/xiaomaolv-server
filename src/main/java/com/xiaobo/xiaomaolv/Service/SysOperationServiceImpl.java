package com.xiaobo.xiaomaolv.Service;

import com.xiaobo.xiaomaolv.dao.SysOperationDao;
import com.xiaobo.xiaomaolv.entity.SysOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 往数据库中写入用户操作 记录
 * @author yanxiaobo
 */
@Service
public class SysOperationServiceImpl implements SysOperationService {
    @Autowired
    private SysOperationDao sysOperationDao;
    @Override
    public int addOperation(SysOperation sysOperation) {
        return sysOperationDao.addOperation(sysOperation);
    }
}
