package com.its.member.controller;
import com.its.member.dto.MemberDTO;
import com.its.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MemberController {
    @Autowired
    MemberService memberService;

    @GetMapping("/save-form")
    public String saveForm() {
        return "save";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute MemberDTO memberDTO) {
        boolean result = memberService.save(memberDTO);
        if(result) {
            return "login";
        }else {
            return "save";
        }
    }


    @GetMapping("/login-form")
    public String loginForm() {
        return "login";
    }
    @PostMapping("/login")
    public String login(@ModelAttribute MemberDTO memberDTO, Model model, HttpSession session) {
        MemberDTO member = memberService.login(memberDTO);
        // 세션(session)
        if(member == null) {
            return "login";
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
    public String delete(@RequestParam("id") Long id) {
        boolean result = memberService.delete(id);
        if(result) {
            //redirect: 컨트롤러의 메서드에서 다른 메서드의 주소를 호출
            // redirect를 이용하여 findAll 주소 요청
            return "redirect:/findAll";
        }else {
            return "delete-fail";
        }
    }
    @GetMapping("/update-form")
    public String updateForm(HttpSession session, Model model) {
        // 로그인을 한 상태기 때문에 세션에 id, memberId가 들어있고
        // 여기서 세션에 있는 id를 가져온다
        Long updateId = (Long) session.getAttribute("id");
        System.out.println("updateId = " + updateId);
        // DB에서 해당 회원의 정보를 가져와서 그 정보를 가지고 update.jsp로 이동
        MemberDTO memberDTO = memberService.findById(updateId);
        model.addAttribute("updateMember", memberDTO);
        return "update";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute MemberDTO memberDTO) {
        System.out.println("memberDTO = " + memberDTO);
        boolean result = memberService.update(memberDTO);
        if(result) {
            // 해당 회원이 상세정보
            return "redirect:/detail?id=" + memberDTO.getId();
        }else {
            return "update-fail";
        }
    }
    @PostMapping("/duplicate-check")
    public @ResponseBody String duplicateCheck(@RequestParam("id2") String id2) {
        System.out.println("id2 = " + id2);
        String check = memberService.duplicateCheck(id2);
        // id2를 DB에서 중복값이 있는지 없는지 체크하고
        // 없으면 ok, 있으면 no 라는 String 값을 리턴 받으세요
        // return check; 그냥 리턴을 하면 ok.jsp 또는 no.jsp 를 찾음. @ResponseBody를 사용하고 리턴을 해야함
        return check;
    }
    @GetMapping("/detail-ajax")
    public @ResponseBody MemberDTO findByIdAjax(@RequestParam("id") Long id) {
        System.out.println("id = " + id);
        MemberDTO memberDTO = memberService.findById(id);
        return memberDTO;
    }
    @GetMapping("response-test")
    public @ResponseBody String responseTest() {
        return "main";
    }
    @GetMapping("response-test2")
    public @ResponseBody List<MemberDTO> responseTest2() {
        return memberService.findAll();
    }
    @GetMapping("/logout")
    public  String logout(HttpSession session) {
        session.invalidate();
        System.out.println("session = " + session);
        return "index";
    }
    @PostMapping("/idCheck")
    public @ResponseBody String idCheck(@RequestParam String id2) {
        String result = memberService.idCheck(id2);
       return result;
    }
}
