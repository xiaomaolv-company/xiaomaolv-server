package com.xiaobo.xiaomaolv.dao;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface BillDao {
    List<Map<String,Object>> queryBillByMonth(Map map);
}
