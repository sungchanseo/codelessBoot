package com.sungchan.codeless.controller;

import com.sungchan.codeless.faq.Faq;
import com.sungchan.codeless.faq.FaqService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping("/faq")
public class FaqController {
    @Autowired
    private FaqService faqService;

    @GetMapping("/faqList")
    public String getList(Model model) {
        List<Faq> list = faqService.getList();
        model.addAttribute("faqList", list);
        return "/faq/faqList";
    }

    @GetMapping("/writeFaq")
    public String writeFaqGet() {
        return "/faq/writeFaq";
    }

    @PostMapping("/writeFaq")
    public String writeFaqPost(Faq faq) {
        faqService.insert(faq);
        return "redirect:/faq/faqList";
    }

    @GetMapping("readFaq")
    public String readFaq(Integer faq_id, Model model) {
        model.addAttribute("content", faqService.read(faq_id));
        return "/faq/readFaq";
    }

    @GetMapping("modifyFaq")
    public String modifyFaq(Integer faq_id, Model model) {
        Faq faq = faqService.read(faq_id);
        model.addAttribute("content", faq);
        return "/faq/modifyFaq";
    }

    @PostMapping("/modifyFaq")
    public String modifyFaq(Faq newFaq) {
        faqService.modify(newFaq);
        return "redirect:/faq/faqList";
    }

    @PostMapping("/deleteFaq")
    public String deleteFaq(Integer faq_id) {
        System.out.println("faq_id = " + faq_id);

        faqService.remove(faq_id);
        return "redirect:/faq/faqList";
    }
}
