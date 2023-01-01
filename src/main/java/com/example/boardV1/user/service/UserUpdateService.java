package com.example.boardV1.user.service;

import com.example.boardV1.user.api.request.UserUpdateRequest;
import com.example.boardV1.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserUpdateService {

    private final UserFindService userFindService;

    @Transactional
    public Long update(Long userId, UserUpdateRequest userUpdateRequest){
        User findUser = userFindService.findById(userId);
        User updatedUser = findUser.updateUserInfo(
                userUpdateRequest.getName(),
                userUpdateRequest.getPassword()
        );
        return updatedUser.getUser_id();
    }
}
