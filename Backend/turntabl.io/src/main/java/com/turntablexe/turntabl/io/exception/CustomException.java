package com.turntablexe.turntabl.io.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class CustomException extends Exception{
    public CustomException(String message){
        super(message);
    }
}
