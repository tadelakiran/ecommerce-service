package com.java.stschool.ecommerceservice.exception;

public class CustomerExistsException extends RuntimeException{
    public CustomerExistsException(String message){
        super(message);
    }
}
