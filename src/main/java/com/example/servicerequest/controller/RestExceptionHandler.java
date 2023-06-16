package com.example.servicerequest.controller;

import com.example.servicerequest.model.generated.Error;
import com.example.servicerequest.model.generated.ErrorRes;
import com.example.servicerequest.model.generated.ResponseInfo;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value= { IllegalArgumentException.class, IllegalStateException.class })
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErrorRes eRes = new ErrorRes();
        Error err = new Error().code(String.valueOf(status.value())).message(status.getReasonPhrase());
        err.setMessage(ex.getMessage());
        eRes.setResponseInfo(new ResponseInfo());
        eRes.addErrorsItem(err);
        return new ResponseEntity(eRes, headers, status);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErrorRes eRes = new ErrorRes();
        Error err = new Error().code(String.valueOf(status.value())).message(status.getReasonPhrase());
        err.setMessage(ex.getMessage());
        eRes.setResponseInfo(new ResponseInfo());
        eRes.addErrorsItem(err);
        return super.handleExceptionInternal(ex, eRes, headers, status, request);
    }

    private ResponseEntity<Object> buildResponseEntity(ErrorRes errorRes) {
        return new ResponseEntity<>(errorRes, HttpStatus.BAD_REQUEST);
    }



}
