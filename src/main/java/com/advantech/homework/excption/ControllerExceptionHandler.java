package com.advantech.homework.excption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.BadRequestException;

/**
 * Created by hailong.dang on 12/7/2017.
 */
@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(value = ControllerException.class)
    public ResponseEntity<?> controllerExceptionHandler(HttpServletRequest request,
                                                        HttpServletResponse response,
                                                        ControllerException ex) {
        ex.printStackTrace();
        ResponseEntity<ExceptionResult> responseEntity = null;
        ExceptionResult exResult = new ExceptionResult();
        exResult.setCode(ex.getErrorCode().getCode());
        exResult.setMessage(ex.getErrorCode().toString(ex.getErrorCode()));
        responseEntity = new ResponseEntity<>(exResult, ex.getHttpStatus());
        return responseEntity;
    }

    @ExceptionHandler(value = BadRequestException.class)
    public ResponseEntity<?> controllerExceptionHandler(HttpServletRequest request,
                                                        HttpServletResponse response,
                                                        BadRequestException ex) {
        ex.printStackTrace();
        ResponseEntity<ExceptionResult> responseEntity = null;
        ExceptionResult exResult = new ExceptionResult();
        exResult.setCode(HttpStatus.BAD_REQUEST.value());
        exResult.setMessage(ex.getMessage());
        responseEntity = new ResponseEntity<>(exResult, HttpStatus.BAD_REQUEST);
        return responseEntity;
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<?> controllerExceptionHandler(HttpServletRequest request,
                                                        HttpServletResponse response,
                                                        Exception ex) {
        ex.printStackTrace();
        ResponseEntity<ExceptionResult> responseEntity = null;
        ExceptionResult exResult = new ExceptionResult();
        exResult.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        exResult.setMessage(ex.getMessage());
        responseEntity = new ResponseEntity<>(exResult, HttpStatus.INTERNAL_SERVER_ERROR);
        return responseEntity;
    }
}

class ExceptionResult {
    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
