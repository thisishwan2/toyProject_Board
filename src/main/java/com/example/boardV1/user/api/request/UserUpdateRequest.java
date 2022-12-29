package com.example.boardV1.user.api.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserUpdateRequest {
    private String name;
    private String password;
}
