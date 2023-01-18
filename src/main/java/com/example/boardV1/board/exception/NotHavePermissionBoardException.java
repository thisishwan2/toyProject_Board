package com.example.boardV1.board.exception;

public class NotHavePermissionBoardException extends RuntimeException {
    public NotHavePermissionBoardException(String msg) {
        super(msg);
    }
}
