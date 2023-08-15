package com.sungchan.codeless.notice;

import com.sungchan.codeless.notice.Notice;
import com.sungchan.codeless.notice.NoticeRepository;
import com.sungchan.codeless.notice.NoticeService;
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

@Controller
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    NoticeService noticeService;

    //공지리스트 조회
    @GetMapping("/noticeList")
    public String getList(String category, String keyword, Model model, @PageableDefault(value = 8, sort = "noticeId", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<Notice> list = null;

        if (keyword == null) {
            list = noticeService.getListPaging(pageable);
        } else {
            if (category.equals("title")) {
                list = noticeService.getListSearchPagingByTitle(keyword, pageable);
            } else list = noticeService.getListSearchPagingByContent(keyword, pageable);
        }

        int nowPage = list.getPageable().getPageNumber() + 1; //현재 페이지
        int startPage = Math.max(nowPage - 4, 1);
        int endPage = Math.min(nowPage + 5, list.getTotalPages());

        model.addAttribute("noticeList", list);
        model.addAttribute("nowPage", nowPage);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);

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
    public String readNotice(Integer noticeId, Model model) {
        Notice notice = noticeService.read(noticeId);
        if (notice == null) return "redirect:/notice/noticeList";
        model.addAttribute("content", notice);
        return "/notice/readNotice";
    }

    @GetMapping("/modifyNotice")
    public String modifyNotice(Integer noticeId, Model model) {
        model.addAttribute("content", noticeService.read(noticeId));
        return "/notice/modifyNotice";
    }

    @PostMapping("/modifyNotice")
    public String modifyNotice(Notice newNotice) {
        Notice notice = noticeService.read(newNotice.getNoticeId());
        if (notice == null) return "redirect:/notice/noticeList";
        noticeService.modify(newNotice);
        return "redirect:/notice/noticeList";
    }

    @GetMapping("/companyInfo")
    public void companyInfoGet(){

    }
    @GetMapping("/privacyPolicy")
    public void privacyPolicyGet(){

    }
}
