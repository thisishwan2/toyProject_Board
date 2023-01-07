package com.example.boardV1.user.api.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserLogInRequest {
    private String email;
    private String password;
    private String deviceToken;
}
