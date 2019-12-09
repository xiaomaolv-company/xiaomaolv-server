package com.xiaobo.xiaomaolv.entity;

import lombok.Data;

@Data
public class SysUser {
    private String uuid;
    private long id;
    private String code;
    private String name;
    private String password;
    private int typeId;
    private String mobile;
    private String email;
    private String remark;
}
