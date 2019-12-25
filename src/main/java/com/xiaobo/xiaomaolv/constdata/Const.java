package com.xiaobo.xiaomaolv.constdata;

public class Const {


    /****当前线程变量****/
    public static String USER = "user";
    public static final String USER_ID = "user_id";
    public static final String USER_NAME = "user_name";
    public static final String USER_UUID = "user_uuid";
    public static final String SESSION_ID = "session_id";


    //***********errorCode********
    public final static int ERROR_CODE_USER_NOT_LOGIN = 99;
    public final static int ERROR_CODE_USER_NOT_EXIT = 100;
    public final static int ERROR_CODE_USER_NAME_PASSORD_NO_MATCH = 101;
    public final static int ERROR_CODE_DELETE_FAIL = 102;
    public final static int ERROR_CODE_INSERT_FAIL = 103;
    public final static int ERROR_CODE_UPDATE_FAIL = 104;
    public final static int ERROR_CODE_DELETE_SUCCESS = 105;
    public final static int ERROR_CODE_INSERT_SUCCESS = 106;
    public final static int ERROR_CODE_UPDATE_SUCCESS = 107;
    public final static int ERROR_CODE_QUERY_SUCCESS = 108;
    public final static int ERROR_CODE_QUERY_FAIL = 109;
    public final static int ERROR_CODE_USER__LOGIN_SUCCESS = 110;
    public final static int ERROR_CODE_USER__LOGIN_FAIL = 111;

    //********errorMessage
    public final static String  ERROR_MSG_USER_NOT_LOGIN = "请先登陆";
    public final static String ERROR_MSG_USER_NOT_EXIT = "no this user";
    public final static String ERROR_MSG_USER_NAME_PASSWOR_NOT_MATCH = "use name and password  not match";
    public final static String ERROR_MSG_DELETE_FAIL = "system delete fail";
    public final static String ERROR_MSG_INSERT_FAIL = "system insert fail";
    public final static String ERROR_MSG_UPDATE_FAIL = "system update fail";
    public final static String ERROR_MSG_DELETE_success = "system delete success";
    public final static String ERROR_MSG_UPDATE_SUCCESS = "system update success";
    public final static String ERROR_MSG_INSERT_SUCCESS = "system insert success";
    public final static String ERROR_MSG_QUERY_SUCCESS = "system query success";
    public final static String ERROR_MSG_QUERY_FAIL = "system query fail";
    public final static String ERROR_MSG_USER_LOGIN_SUCCESS = "user login success";
    public final static String ERROR_MSG_USER_LOGIN_FAIL = "user login fail";
}
