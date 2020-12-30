package com.turntablexe.turntabl.io.exception;

public final class UserAlreadyExistException extends RuntimeException {

    public UserAlreadyExistException() {
        super();
    }

    public UserAlreadyExistException(final String message) {
        super(message);
    }


}
