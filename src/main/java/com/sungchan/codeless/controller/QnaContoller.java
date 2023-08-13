package com.sungchan.codeless.controller;

import com.sungchan.codeless.qna.Qna;
import com.sungchan.codeless.qna.QnaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/qna")
public class QnaContoller {

    @Autowired
    private QnaService qnaService;

    @GetMapping("/qnaList")
    public String getList(Model model){
        List<Qna> list = qnaService.getList();
        model.addAttribute("qnaList", list);
        return "/qna/qnaList";
    }
}
