package com.zdz.test.test;

/**
 * @Description:
 * @Date: 2020/12/23
 */
public class Req {
    private Integer code;
    private String message;
    private Object data;
    public Req(Integer code, String message, Object data){
        this.data = data;
        this.message = message;
        this.code = code;
    }
    public static Req success(Object data){
        return new Req(0, "成功", data);
    }
    public static Req error(Integer code,String message,Object data){
        return new Req(code, message, data);
    }
}
