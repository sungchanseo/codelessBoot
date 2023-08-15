package com.sungchan.codeless.controller;

import com.sungchan.codeless.user.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {

    @GetMapping("/insertForm")
    public String insertMember() {
        return "/member/insertForm";
    }

    @GetMapping("/loginForm")
    public String loginForm() {
        return "/member/loginForm";
    }

    @PostMapping("/lgoinForm")
    public String loginForm(User user) {

        return "redirect:/";
    }
}
