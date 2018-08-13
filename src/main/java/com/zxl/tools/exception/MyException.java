package com.zxl.tools.exception;

/**
 * @Description 异常类
 * @Author ZXL
 * @Date 2018/8/13
 **/
public class MyException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    private int code;

    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    public MyException(int code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }
    public MyException(String msg) {
        super();
        this.msg = msg;
    }
}
