package com.example.boardV1.user.api;

import com.example.boardV1.user.api.request.UserLogInRequest;
import com.example.boardV1.user.api.request.UserSignUpRequest;
import com.example.boardV1.user.service.UserSignService;
import com.example.boardV1.util.ApiResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserSignApi {

    private final UserSignService userSignService;

    @PostMapping("/signup")
    public ApiResult<Long> signUp(@RequestBody UserSignUpRequest userSignUpRequest) {
        try {
            Long userId = userSignService.signUp(userSignUpRequest);
            return ApiResult.succeed(userId);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ApiResult.failed(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ApiResult<Long> login(@RequestBody UserLogInRequest userLogInRequest) {
        try {
            Long userId = userSignService.logIn(userLogInRequest);
            return ApiResult.succeed(userId);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ApiResult.failed(e.getMessage());
        }
    }
}
