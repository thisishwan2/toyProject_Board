package com.example.boardV1.user.api;

import com.example.boardV1.user.model.User;
import com.example.boardV1.user.service.UserFindService;
import com.example.boardV1.util.ApiResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserFindApi {

    private final UserFindService userFindService;

    @GetMapping("/{userId}")
    public ApiResult<User> findById(@PathVariable Long userId){
        try{
            return ApiResult.succeed(userFindService.findById(userId));
        }catch (Exception e){
            log.error(e.getMessage());
            return ApiResult.failed(e.getMessage());
        }
    }

    @GetMapping()
    public ApiResult<List<User>> findUsers(){
        try{
            return ApiResult.succeed(userFindService.findAll());
        }catch (Exception e){
            log.error(e.getMessage());
            return ApiResult.failed(e.getMessage());
        }
    }
}
