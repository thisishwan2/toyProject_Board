package com.example.board.service;

import com.example.board.entity.Member;
import com.example.board.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    public void 회원가입() throws Exception{
        //given
        Member member = new Member("kim2", "1212a", "qwe123");

        //when
        Long id = memberService.join(member);

        //then
        assertEquals(member, memberService.findOne(id));

    }

    @Test
    public void 중복_회원_예제1() {
        //given
        // 이름이 같은경우
        Member member1 = new Member("kim2", "1212a", "qwe123");
        Member member2 = new Member("kim2", "1212a", "qqqq12");

        //when
        memberService.join(member1);
        memberService.join(member2);

        fail("예외발생");
    }
    @Test
    public void 중복_회원_예제2(){
        //아이디가 같은 경우
        Member member3 = new Member("kim21", "1212a", "qwe123");
        Member member4 = new Member("kim2", "1212a", "qwe123");

        memberService.join(member3);
        memberService.join(member4);

        fail("예외발생");

    }
}