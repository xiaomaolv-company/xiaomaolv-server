package com.xiaobo.smartmonkey.entity;

import lombok.Data;

@Data
public class AppResponse {
    private Object appData;
    private int statusCode;
    private String message;
}
