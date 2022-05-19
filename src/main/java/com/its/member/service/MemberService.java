package com.its.member.service;

import com.its.member.dto.MemberDTO;
import com.its.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    @Autowired
    MemberRepository memberRepository;

    public boolean save(MemberDTO memberDTO) {
        int result = memberRepository.save(memberDTO);
        if(result > 0) {
            return true;
        }else {
            return false;
        }
    }

    public List<MemberDTO> findAll() {
        List<MemberDTO> memberList = memberRepository.findAll();
        return memberList;
    }

    public MemberDTO login(MemberDTO memberDTO) {
        MemberDTO member = memberRepository.login(memberDTO);
        return member;
    }
    public MemberDTO findById(Long id) {
        return memberRepository.findById(id);
    }

    public MemberDTO delete(Long id) {
        return memberRepository.delete(id);
    }

    public MemberDTO update(MemberDTO memberDTO) {
        return memberRepository.update(memberDTO);
    }
}
