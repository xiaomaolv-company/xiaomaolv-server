package com.xiaobo.xiaomaolv.entity;

import lombok.Data;

@Data
public class SysUser {
    private String uuid;
    private long id;
    private String code;
    private String name;
    private String password;
    private int type;
    private String mobile;
    private String email;
    private String remark;
    private String city;
    private String province;
    private String privilege;
    private String country;
    private String wechatId;
    private String registeDatetime;
    private int sex;
    private String address;
    private String avater;
    private int age;
}
