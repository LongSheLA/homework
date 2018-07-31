package com.advantech.homework.excption;

import org.springframework.http.HttpStatus;

public class Controller500Exception extends ControllerException  {

    public Controller500Exception(ControllerErrorCode errorCode) {
        super(errorCode);
        this.httpStatus =  HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public Controller500Exception(HttpStatus httpStatus, ControllerErrorCode errorCode) {
        super(errorCode);
        this.httpStatus = httpStatus;
    }

    @Override
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
