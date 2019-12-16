package com.xiaobo.xiaomaolv.entity;

import lombok.Data;

@Data
public class SysOperation {
    private long id;
    private String uuid;
    private long userId;
    private String optDatetime;
    private String optDecription;
    private String remark;
    private int type;

}
