package com.advantech.homework.excption;

import org.springframework.http.HttpStatus;

public abstract class ControllerException extends Exception  {
    private ControllerErrorCode errorCode;

    protected HttpStatus httpStatus;

    public ControllerException(ControllerErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public ControllerErrorCode getErrorCode() {
        return errorCode;
    }

    public abstract HttpStatus getHttpStatus();
}
