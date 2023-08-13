package com.sungchan.codeless.controller;

import com.sungchan.codeless.notice.Notice;
import com.sungchan.codeless.notice.NoticeRepository;
import com.sungchan.codeless.notice.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    NoticeService noticeService;

    //공지리스트 조회
    @GetMapping("/noticeList")
    public String getList(Model model) {
        List<Notice> list = noticeService.getList();
        model.addAttribute("noticeList", list);
        return "/notice/noticeList";
    }

    //공지쓰기
    @GetMapping("/writeNotice")
    public String writeNoticeForm() {
        return "/notice/writeNotice";
    }

    @PostMapping("/writeNotice")
    public String writeNotice(Notice notice) {
        noticeService.insert(notice);
        return "redirect:/notice/noticeList";
    }

    @GetMapping("/readNotice")
    public String readNotice(Integer notice_id, Model model) {
        Notice notice = noticeService.read(notice_id);
        if (notice == null) return "redirect:/notice/noticeList";
        model.addAttribute("content", notice);
        return "/notice/readNotice";
    }

    @GetMapping("/modifyNotice")
    public String modifyNotice(Integer notice_id, Model model) {
        model.addAttribute("content", noticeService.read(notice_id));
        return "/notice/modifyNotice";
    }

    @PostMapping("/modifyNotice")
    public String modifyNotice(Notice newNotice) {
        Notice notice = noticeService.read(newNotice.getNotice_id());
        if(notice == null) return "redirect:/notice/noticeList";
        noticeService.modify(newNotice);
        return "redirect:/notice/noticeList";
    }
}
