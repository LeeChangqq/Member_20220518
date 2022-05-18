package com.its.member.controller;

import com.its.member.dto.MemberDTO;
import com.its.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MemberController {
    @Autowired
    MemberService memberService;
    @GetMapping("/")
    public String index() {
        return "index";
    }
    @GetMapping("/save-form")
    public String saveForm() {
        return "save-form";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute MemberDTO memberDTO) {
        boolean result = memberService.save(memberDTO);
        if(result) {
            return "index";
        }else {
            return "save-form";
        }
    }


    @GetMapping("/login-form")
    public String loginForm() {
        return "login-form";
    }
    @PostMapping("/login")
    public String login(@ModelAttribute MemberDTO memberDTO) {
        MemberDTO member = memberService.login(memberDTO);
        if(member == null) {
            return "login-form";
        }else {
            return "main";
        }

    }


    @GetMapping("/findAll")
    public String findAll(Model model) {
        List<MemberDTO> memberList = memberService.findAll();
        model.addAttribute("memberList", memberList);
        return "list";
    }
}
