package com.hotels.service.HotelsService.exception;

public class ResourceNotFound extends RuntimeException{

    public ResourceNotFound(){
        super("Resource bot Found");
    }

    public ResourceNotFound(String message){
        super(message);
    }
}
