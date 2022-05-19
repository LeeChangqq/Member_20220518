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

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MemberController {
    @Autowired
    MemberService memberService;

    @GetMapping("/save-form")
    public String saveForm() {
        return "save-form";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute MemberDTO memberDTO) {
        boolean result = memberService.save(memberDTO);
        if(result) {
            return "login-form";
        }else {
            return "save-form";
        }
    }


    @GetMapping("/login-form")
    public String loginForm() {
        return "login-form";
    }
    @PostMapping("/login")
    public String login(@ModelAttribute MemberDTO memberDTO, Model model, HttpSession session) {
        MemberDTO member = memberService.login(memberDTO);
        // 세션(session)
        if(member == null) {
            return "login-form";
        }else {
            session.setAttribute("id", member.getId());
            session.setAttribute("loginId", member.getId2());
            model.addAttribute("member", member);
            return "main";
        }
    }


    @GetMapping("/findAll")
    public String findAll(Model model) {
        List<MemberDTO> memberList = memberService.findAll();
        model.addAttribute("memberList", memberList);
        return "list";
    }
    @GetMapping("/detail")
    public String findById(@RequestParam("id") Long id, Model model) {
        MemberDTO memberDTO = memberService.findById(id);
        model.addAttribute("member", memberDTO);
        return "detail";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id, Model model) {
        MemberDTO memberDTO = memberService.delete(id);
        model.addAttribute("member", memberDTO);
        return "index";
    }
    @GetMapping("/update-form")
    public String updateForm() {
        return "update-form";
    }


    @PostMapping("/update")
    public String update(@ModelAttribute MemberDTO memberDTO, HttpSession session) {
        MemberDTO member = memberService.update(memberDTO);
        session.setAttribute("member", member);
        return "index";
    }
}
