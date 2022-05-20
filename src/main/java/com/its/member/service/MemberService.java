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

    public boolean delete(Long id) {
        int result = memberRepository.delete(id);
        if(result > 0) {
            return true;
        }else {
            return false;
        }
    }

    public boolean update(MemberDTO memberDTO) {
        int result = memberRepository.update(memberDTO);
        if(result > 0) {
            return true;
        }else {
            return false;
        }
    }

    public String duplicateCheck(String id2) {
        String result = memberRepository.duplicateCheck(id2);
        if(result == null){
            return "ok";
        }else {
            return "no";
        }

    }

    public String idCheck(String id2) {
        String result = memberRepository.idCheck(id2);
        if(result == null) {
            return "ok";
        }else {
            return "no";
        }
    }
}
