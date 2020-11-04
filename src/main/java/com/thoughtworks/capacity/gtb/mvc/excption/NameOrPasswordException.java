package com.thoughtworks.capacity.gtb.mvc.excption;

import com.thoughtworks.capacity.gtb.mvc.dto.ErrorResult;

public class NameOrPasswordException extends Exception {
    public NameOrPasswordException(String message){
        super(message);
    }
}
