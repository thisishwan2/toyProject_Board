package com.example.boardV1.user.service;

import com.example.boardV1.user.api.request.UserLogInRequest;
import com.example.boardV1.user.api.request.UserSingUpRequest;
import com.example.boardV1.user.exception.DuplicatedEmailException;
import com.example.boardV1.user.exception.UnMatchedPasswordException;
import com.example.boardV1.user.model.User;
import com.example.boardV1.user.model.UserRole;
import com.example.boardV1.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserSignService {
    private final UserRepository userRepository;
    private final UserFindService userFindService;

    @Transactional
    public Long singUp(UserSingUpRequest userSingUpRequest){
        checkDuplicatedEmail(userSingUpRequest.getEmail());
        User user = User.builder()
                .email(userSingUpRequest.getEmail())
                .name(userSingUpRequest.getName())
                .password(userSingUpRequest.getPassword())
                .userRole(UserRole.NORMAL)
                .build();
        User savedUser = userRepository.save(user);
        return savedUser.getUser_id();
    }

    @Transactional
    public Long logIn(UserLogInRequest userLogInRequest){
        User user = userFindService.findByEmail(userLogInRequest.getEmail());
        checkMatchedPassword(userLogInRequest.getPassword(), user.getPassword());
        user.modifyDeviceToken(userLogInRequest.getDeviceToken());
        return user.getUser_id();
    }

    private void checkDuplicatedEmail(String email) {
        if(userRepository.findByEmail(email).isPresent()){
            throw new DuplicatedEmailException(String.format("[ %s ]"+"는 이미 존재합니다", email));
        }
    }

    private void checkMatchedPassword(String loginPassword, String userPassword) {
        if(!loginPassword.equals(userPassword)){
            throw new UnMatchedPasswordException(String.format("패스워드가 맞지 않습니다."));
        }
    }
}
