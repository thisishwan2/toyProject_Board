package com.example.boardV1.util;

import lombok.Getter;

@Getter
public class ApiResult<T> {
    private final T data;
    private final String message;

    public ApiResult(T data, String message) {
        this.data = data;
        this.message = message;
    }

    //제네릭을 왜 저렇게 짜지?
    //답변: static 메소드의 경우 class 에서 선언한 제너릭 타입을 선언할 수 없음.
    //그렇기 때문에 static 붙은 메소드에서 제네릭을 쓰기 위해선 static과 return 사이에 제니릭 타입을 선언해주어야함.
    //
    public static <T> ApiResult<T> succeed(T data){
        return new ApiResult<>(data, null);
    }

    public static <T> ApiResult<T> failed(Throwable throwable){
        return new ApiResult<>(null, throwable.getLocalizedMessage());
    }
    public static <T> ApiResult<T> failed(String message){
        return new ApiResult<>(null, message);
    }
}
