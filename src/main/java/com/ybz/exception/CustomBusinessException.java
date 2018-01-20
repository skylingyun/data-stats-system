package com.ybz.exception;

/**
 * Created by chenshuo on 2017/3/1.
 */
public class CustomBusinessException extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    //异常信息
    private String message;
    private String code;

    public CustomBusinessException(String message){
        super(message);
        this.message = message;
        this.code = "-100";

    }

    public CustomBusinessException(String code , String message){
        super(message);
        this.message = message;
        this.code = code;

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
