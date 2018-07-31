package com.advantech.homework.entity;

/**
 *  所有传输类需要继承，便于返回前台统一的格式
 */
public class ResponseDto {
    /**
     *  状态码
     */
    private String code;
    /**
     *  错误信息
     */
    private String errorMessage;

    private Object  data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ResponseDto() {
    }

    public ResponseDto(String code, String errorMessage, Object data) {
        this.code = code;
        this.errorMessage = errorMessage;
        this.data = data;
    }
}
