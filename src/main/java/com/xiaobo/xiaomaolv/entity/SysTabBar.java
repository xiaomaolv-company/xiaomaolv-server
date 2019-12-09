package com.xiaobo.smartmonkey.entity;

import lombok.Data;

@Data
public class SysTabBar {
    private long id;
    private String uuid;
    private String code;
    private String name;
    private int level;
    private long parentId;
    private String fullName;
    private String registDatetime;
}
