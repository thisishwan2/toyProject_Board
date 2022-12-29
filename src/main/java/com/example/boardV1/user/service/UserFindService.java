package com.example.boardV1.user.service;

import com.example.boardV1.user.exception.NotFoundUserException;
import com.example.boardV1.user.model.User;
import com.example.boardV1.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true) //조회만 하므로 true
public class UserFindService {
    private final UserRepository userRepository;

    public User findById(Long userId){
        return userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundUserException(String.format("아이디가 없습니다 : %s", userId)));
    }

    public User findByEmail(String email){
        return userRepository.findByEmail(email)
                .orElseThrow(()-> new NotFoundUserException(String.format("이메일이 없습니다 : %s, 가입하셔야 합니다.", email)));
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }
}
