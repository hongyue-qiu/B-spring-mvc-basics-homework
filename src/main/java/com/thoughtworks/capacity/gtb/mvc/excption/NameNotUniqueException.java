package com.thoughtworks.capacity.gtb.mvc.excption;

public class NameNotUniqueException extends Exception {
    public NameNotUniqueException(String message){
        super(message);
    }
}
