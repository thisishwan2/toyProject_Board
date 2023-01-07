package com.example.boardV1.user.api.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor //test 용도
public class UserSignUpRequest {
    private String email;
    private String password;
    private String name;
}
