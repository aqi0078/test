package com.zdz.test.web.tool.test.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class ResponseVo<T> implements Serializable {

  private static final long serialVersionUID = 25440068567594579L;

  private int code = 200;
  private String msg;
  private T data;

  public static <R> ResponseVo<R> success(R data) {
    ResponseVo<R> responseVo = new ResponseVo<>();
    responseVo.setData(data);
    return responseVo;
  }

  public static <R> ResponseVo<R> fail(int code, String msg) {
    ResponseVo<R> responseVo = new ResponseVo<>();
    responseVo.setCode(code);
    responseVo.setMsg(msg);
    return responseVo;
  }


  public boolean checkSuccess() {
    return this.code == 200;
  }
}
