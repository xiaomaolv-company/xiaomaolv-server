package com.xiaobo.xiaomaolv.entity;

import lombok.Data;

@Data
public class ChartData {
    private String year;
    private String month;
    private String day;
    private long userId;
    private String type;
    private String week;
}
