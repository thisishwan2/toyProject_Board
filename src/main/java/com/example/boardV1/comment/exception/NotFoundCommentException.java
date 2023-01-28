package com.example.boardV1.comment.exception;

public class NotFoundCommentException extends RuntimeException {
    public NotFoundCommentException(String msg) {
        super(msg);
    }
}
