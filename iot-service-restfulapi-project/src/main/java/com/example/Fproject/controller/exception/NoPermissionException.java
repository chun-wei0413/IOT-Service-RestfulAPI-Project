package com.example.Fproject.controller.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class NoPermissionException extends RuntimeException{

    public String getErrorMessage(){
        return String.format("Request user:%s,your are:%s");
    }
}
