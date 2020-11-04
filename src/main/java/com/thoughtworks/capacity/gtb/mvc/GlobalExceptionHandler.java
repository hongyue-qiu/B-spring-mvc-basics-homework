package com.thoughtworks.capacity.gtb.mvc;


import com.thoughtworks.capacity.gtb.mvc.dto.ErrorResult;
import com.thoughtworks.capacity.gtb.mvc.excption.NameNotUniqueException;
import com.thoughtworks.capacity.gtb.mvc.excption.NameOrPasswordException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NameNotUniqueException.class)
    public ResponseEntity<ErrorResult> handle(NameNotUniqueException ex){
        ErrorResult errorResult = new ErrorResult(ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResult);
    }

    @ExceptionHandler(NameOrPasswordException.class)
    public ResponseEntity<ErrorResult> handle(NameOrPasswordException ex){
        ErrorResult errorResult = new ErrorResult(ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResult);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResult> handle(MethodArgumentNotValidException ex){
        String message = ex.getBindingResult().getFieldError().getDefaultMessage();
        ErrorResult errorResult = new ErrorResult(message);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResult);
    }

}
