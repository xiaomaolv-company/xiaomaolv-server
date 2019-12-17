package com.xiaobo.xiaomaolv.entity;

import lombok.Data;

@Data
public class VisitLog {
    private long id;
    private String uuid;
    private String loginUserName;
    private String loginDatetime;
    private String outDatetime;
    private long userId;
}
