package com.example.boardV1.user.api;

import com.example.boardV1.user.api.request.UserUpdateRequest;
import com.example.boardV1.user.service.UserUpdateService;
import com.example.boardV1.util.ApiResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserUpdateApi {

    private final UserUpdateService userUpdateService;

    @PutMapping("/update")
    public ApiResult<Long> updateUserInfo(@PathVariable Long userId,
                                          @RequestBody UserUpdateRequest userUpdateRequest){
        try {
            return ApiResult.succeed(userUpdateService.update(userId,userUpdateRequest));
        }catch (Exception e){
            log.error(e.getMessage());
            return ApiResult.failed(e.getMessage());
        }
    }
}
