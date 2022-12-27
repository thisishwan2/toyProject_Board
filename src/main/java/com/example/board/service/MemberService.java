package com.example.board.service;

import com.example.board.entity.Member;
import com.example.board.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    MemberRepository memberRepository;

    /**
     * 회원가입
     */
    @Transactional
    public Long join(Member member){
        //아이디 중복 검사
        validateDuplicateMemberId(member);
        //이름(닉네임) 중복 검사
        validateDuplicateName(member);
        memberRepository.save(member);
        return member.getId();
    }

    /**
     * id 중복 검증
     */
    private void validateDuplicateMemberId(Member member){
        List<Member> findMembers = memberRepository.findByMemberId(member.getMemberId());
        if(!findMembers.isEmpty()){
            throw new IllegalStateException("이미 존재하는 아이디입니다.");
        }
    }

    /**
     * 이름(닉네임) 중복 검증
     */
    private void validateDuplicateName(Member member){
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if(!findMembers.isEmpty()){
            throw new IllegalStateException("이미 존재하는 이름(닉네임)입니다.");
        }
    }


    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    /**
     * 단일 조회
     */
    public Member findOne(Long id){
        return memberRepository.findById(id).get();
    }
}
