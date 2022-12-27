package com.example.board;

import com.example.board.entity.Board;
import com.example.board.entity.File;
import com.example.board.entity.Member;
import com.example.board.repository.BoardRepository;
import com.example.board.repository.FileRepository;
import com.example.board.repository.MemberRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class MemberTest {
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    BoardRepository boardRepository;
    @Autowired
    FileRepository fileRepository;

    @Test
    public void saveMember() {
        // 멤버 생성
        Member m1 = Member.builder()
                .memberId("abc1231")
                .password("qwer1212")
                .name("kim")
                .build();

        Member m2 = Member.builder()
                .memberId("a1231")
                .password("q1212")
                .name("kim do")
                .build();

        memberRepository.save(m1);
        memberRepository.save(m2);

        //글 작성 저장
        Board board1 = Board.builder()
                .title("오늘의 메뉴")
                .content("돼지고기")
                .member(m1)
                .build();

        Board board2 = Board.builder()
                .title("오늘 일기")
                .content("잤다")
                .member(m1)
                .build();

        Board board3 = Board.builder()
                .title("오늘 할것")
                .content("쉬자")
                .member(m2)
                .build();
        boardRepository.save(board1);
        boardRepository.save(board2);
        boardRepository.save(board3);

        //파일 생성
        File files1 = File.builder()
                .fileName("식단표")
                .board(board1)
                .build();

        File files2 = File.builder()
                .fileName("일기장")
                .board(board2)
                .build();

        fileRepository.save(files1);
        fileRepository.save(files2);

    }
}
