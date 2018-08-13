package com.zxl.vo;

/**
 * @Description 统一返回类
 * @Author ZXL
 * @Date 2018/8/13
 **/
public class ResultVo {

    private int code;
    private String msg;
    private boolean success = true;
    private Object results;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getResults() {
        return results;
    }

    public void setResults(Object results) {
        this.results = results;
    }
}
