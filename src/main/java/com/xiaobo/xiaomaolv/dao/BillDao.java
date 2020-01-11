package com.xiaobo.xiaomaolv.dao;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface BillDao {
    List<Map<String,String>> queryBillByMonth(Map map);

    List<Map<String, String>> queryBillByYear(Map<String, Object> map);
}
