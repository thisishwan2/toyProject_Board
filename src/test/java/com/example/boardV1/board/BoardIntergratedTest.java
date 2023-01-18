package com.example.boardV1.board;

import com.example.boardV1.board.api.BoardDeleteApi;
import com.example.boardV1.board.api.BoardFindApi;
import com.example.boardV1.board.api.BoardUpdateApi;
import com.example.boardV1.board.api.BoardWriteApi;
import com.example.boardV1.board.api.request.BoardUpdateRequest;
import com.example.boardV1.board.api.request.BoardWriteRequest;
import com.example.boardV1.board.model.BoardCategory;
import com.example.boardV1.user.api.UserSignApi;
import com.example.boardV1.user.api.request.UserLogInRequest;
import com.example.boardV1.user.api.request.UserSignUpRequest;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
public class BoardIntergratedTest {

    @Autowired
    UserSignApi userSignApi;
    @Autowired
    BoardWriteApi boardWriteApi;
    @Autowired
    BoardFindApi boardFindApi;
    @Autowired
    BoardUpdateApi boardUpdateApi;
    @Autowired
    BoardDeleteApi boardDeleteApi;


    @Test
    public void a_회원가입_및_로그인(){
        UserSignUpRequest user1 = new UserSignUpRequest("aaa","123","kim");
        userSignApi.signUp(user1);
        UserLogInRequest singedUser1 = new UserLogInRequest(user1.getEmail(), user1.getPassword(), "phone");

        UserSignUpRequest user2 = new UserSignUpRequest("bbb","098","lee");
        userSignApi.signUp(user2);
        UserLogInRequest singedUser2 = new UserLogInRequest(user1.getEmail(), user1.getPassword(), "phone");
    }


    @Test
    public void b_글작성() {
        BoardWriteRequest boardWriteRequest1 = new BoardWriteRequest("title", "content", BoardCategory.FUN);
        boardWriteApi.writeBoard(Long.valueOf(1), boardWriteRequest1);

        BoardWriteRequest boardWriteRequest2 = new BoardWriteRequest("happy", "contenttttt", BoardCategory.FUN);
        boardWriteApi.writeBoard(Long.valueOf(2), boardWriteRequest2);

    }

    @Test
    public void c_글조회(){
        boardFindApi.findAll(); //전체조회
        //게시글 아이디 조회
        boardFindApi.findById(Long.valueOf(1));
        boardFindApi.findById(Long.valueOf(2));
        //유저 아이디로 조회
        boardFindApi.findByUser(Long.valueOf(1));
        boardFindApi.findByUser(Long.valueOf(2));
        //카테고리 조회
        boardFindApi.findByCategory(BoardCategory.FUN);

    }

    @Test
    public void d_글수정(){
        BoardUpdateRequest boardUpdateRequest = new BoardUpdateRequest("kimbab","eat",BoardCategory.NORMAL);
        boardUpdateApi.updateBoard(Long.valueOf(1),Long.valueOf(1), boardUpdateRequest);
    }

    @Test
    public void e_수정글조회() {
        //게시글 아이디 조회
        boardFindApi.findById(Long.valueOf(1));
    }

    @Test
    public void f_글삭제(){
        boardDeleteApi.deleteBoardById(1L, 1L);
    }
    @Test
    public void g_글조회(){
        boardFindApi.findAll();
    }
}
