package com.example.boardV1.user.service;

import com.example.boardV1.user.api.UserDeleteApi;
import com.example.boardV1.user.api.UserFindApi;
import com.example.boardV1.user.api.UserSignApi;
import com.example.boardV1.user.api.UserUpdateApi;
import com.example.boardV1.user.api.request.UserLogInRequest;
import com.example.boardV1.user.api.request.UserSignUpRequest;
import com.example.boardV1.user.api.request.UserUpdateRequest;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
public class UserIntergratedTest {

    @Autowired
    UserSignApi userSignApi;
    @Autowired
    UserUpdateApi userUpdateApi;
    @Autowired
    UserFindApi userFindApi;
    @Autowired
    UserDeleteApi userDeleteApi;

    @Test
    public void a_회원가입(){
        //user1, user2 회원가입
        UserSignUpRequest user1 = new UserSignUpRequest("abc@naver.com", "1234", "kim");
        userSignApi.signUp(user1);

        UserSignUpRequest user2 = new UserSignUpRequest("abc123@naver.com", "1212", "lee");
        userSignApi.signUp(user2);
    }

    @Test
    public void b_중복회원(){
        //user1과 동일한 이메일로 가입
        UserSignUpRequest user3 = new UserSignUpRequest("abc@naver.com", "abcd", "park");
        userSignApi.signUp(user3);
    }

    @Test
    public void c_로그인(){
        UserLogInRequest user1 = new UserLogInRequest("abc123@naver.com", "1212", "mobile");
        userSignApi.login(user1);
    }

    @Test
    public void d_로그인실패(){
        UserLogInRequest user1 = new UserLogInRequest("abc123@naver.com", "12", "mobile");
        userSignApi.login(user1);
    }

    @Test
    public void e_회원정보수정(){
        //user_id 가 1번인 회원의 정보 변경
        UserUpdateRequest user1 = new UserUpdateRequest("choi", "qwer");
        userUpdateApi.updateUserInfo(1L, user1);
    }
    @Test
    public void f_회원조회(){
        userFindApi.findById(1l);
        userFindApi.findUsers();
    }
    @Test
    public void g_회원삭제(){
        //1번유저 삭제
        userDeleteApi.deleteUserById(1l);
    }
}