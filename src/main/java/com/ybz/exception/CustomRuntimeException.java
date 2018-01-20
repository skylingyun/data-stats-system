package com.ybz.exception;

public class CustomRuntimeException extends RuntimeException{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    //异常信息
    private String message;
    private String code;

    public CustomRuntimeException(String message){
        super(message);
        this.message = message;
        this.code = "-100";

    }

    public CustomRuntimeException(String code , String message){
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
