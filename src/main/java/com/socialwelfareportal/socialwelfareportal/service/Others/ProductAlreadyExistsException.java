package com.socialwelfareportal.socialwelfareportal.service.Others;

public class ProductAlreadyExistsException extends RuntimeException{
    public ProductAlreadyExistsException(String message) {
        super(message);
    }
}
