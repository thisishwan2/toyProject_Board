package com.example.boardV1.user.api;

import com.example.boardV1.user.service.UserDeleteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserDeleteApi {

    private final UserDeleteService userDeleteService;

    @DeleteMapping("/delete/{userId}")
    public void deleteUserById(@PathVariable Long userId){
        userDeleteService.deleteUserById(userId);
    }
}
