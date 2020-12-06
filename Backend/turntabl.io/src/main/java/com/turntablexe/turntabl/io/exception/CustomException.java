package com.turntablexe.turntabl.io.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus()
public class CustomException extends Exception{
    public CustomException(String message){
        super(message);
    }
}
