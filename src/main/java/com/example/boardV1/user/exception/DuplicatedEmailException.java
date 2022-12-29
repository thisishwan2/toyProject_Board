package com.example.boardV1.user.exception;

public class DuplicatedEmailException extends RuntimeException {
    public DuplicatedEmailException(String msg) {
        super(msg);
    }
}
