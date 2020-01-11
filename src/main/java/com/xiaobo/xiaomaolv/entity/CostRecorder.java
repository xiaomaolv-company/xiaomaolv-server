package com.xiaobo.xiaomaolv.entity;

import lombok.Data;

@Data
public class CostRecorder extends PageParam {
    private long id;
    private String uuid;
    private float balance;
    private long  configId;
    private String createDatetime;
    private String remark;
    private long userId;

}
