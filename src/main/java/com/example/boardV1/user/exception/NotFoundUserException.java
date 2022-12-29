package com.example.boardV1.user.exception;

public class NotFoundUserException extends RuntimeException {
    public NotFoundUserException(String msg){
        super(msg);
    }
}
