package com.sungchan.codeless.faq;

import com.sungchan.codeless.faq.Faq;
import com.sungchan.codeless.faq.FaqService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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
    public String getList(Model model, @PageableDefault(value = 5, sort = "faqId", direction = Sort.Direction.DESC)Pageable pageable) {


        Page<Faq> list = faqService.getListPaging(pageable);

        int nowPage = list.getPageable().getPageNumber() + 1; //현재 페이지
        int startPage = Math.max(nowPage - 4, 1);
        int endPage = Math.min(nowPage + 5, list.getTotalPages());

        model.addAttribute("faqList", list);
        model.addAttribute("nowPage", nowPage);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);

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
    public String readFaq(Integer faqId, Model model) {
        model.addAttribute("content", faqService.read(faqId));
        return "/faq/readFaq";
    }

    @GetMapping("modifyFaq")
    public String modifyFaq(Integer faqId, Model model) {
        Faq faq = faqService.read(faqId);
        model.addAttribute("content", faq);
        return "/faq/modifyFaq";
    }

    @PostMapping("/modifyFaq")
    public String modifyFaq(Faq newFaq) {
        faqService.modify(newFaq);
        return "redirect:/faq/faqList";
    }

    @PostMapping("/deleteFaq")
    public String deleteFaq(Integer faqId) {
        System.out.println("faqId = " + faqId);

        faqService.remove(faqId);
        return "redirect:/faq/faqList";
    }
}
