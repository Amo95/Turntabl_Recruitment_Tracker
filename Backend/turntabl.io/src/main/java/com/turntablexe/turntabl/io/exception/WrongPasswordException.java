package com.turntablexe.turntabl.io.exception;

public class WrongPasswordException extends RuntimeException{
    public WrongPasswordException(){
        super();
    }
    public WrongPasswordException(final String message){
        super(message);
    }

}
