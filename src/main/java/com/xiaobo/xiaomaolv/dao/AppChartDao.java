package com.xiaobo.xiaomaolv.dao;

import com.xiaobo.xiaomaolv.entity.ChartData;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface AppChartDao {
    List<Map<String, Object>> getChartData(ChartData chartData);
}
