package com.example.boardV1.user.service;

import com.example.boardV1.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserDeleteService {
    private final UserRepository userRepository;

    @Transactional
    public void deleteUserById(Long userId){
        userRepository.deleteById(userId);
    }
}
