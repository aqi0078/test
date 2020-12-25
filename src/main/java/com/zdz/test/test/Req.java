package com.zdz.test.test;

/**
 * @Description:
 * @Date: 2020/12/23
 */
public class Req {
    private boolean code;
    private String message;
    private Object data;
    public Req(boolean code, String message, Object data){
        this.data = data;
        this.message = message;
        this.code = code;
    }
    public static Req success(Object data){
        return new Req(true, "成功", data);
    }
    public static Req error(String message,Object data){
        return new Req(false, message, data);
    }
}
