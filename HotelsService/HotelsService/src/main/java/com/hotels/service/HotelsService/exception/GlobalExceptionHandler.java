package com.hotels.service.HotelsService.exception;

import com.hotels.service.HotelsService.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFound.class) //   so when ever this exception generate anyWhere in this project so this method will hit
    public ResponseEntity<ApiResponse> handlerResponseNotFound(ResourceNotFound ex){
        String message = ex.getMessage();
        ApiResponse response =    ApiResponse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
         return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }
}
