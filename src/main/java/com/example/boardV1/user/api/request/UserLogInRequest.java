package com.example.boardV1.user.api.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserLogInRequest {
    private String email;
    private String password;
    private String deviceToken;
}
