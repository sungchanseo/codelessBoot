package com.sungchan.codeless.notice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeService{

    @Autowired
    private NoticeRepository noticeRepository;

    //공지 리스트 조회
    public List<Notice> getList() {
        return (List<Notice>) noticeRepository.findAll();
    }

    //공지사항 등록
    public Notice insert(Notice notice) {
        return noticeRepository.save(notice);
    }

    //공지사항 조회
    public Notice read(Integer notice_id) {
        return noticeRepository.findById(notice_id).orElse(null);
    }

    //공지사항 수정
    public Notice modify(Notice newNotice) {
        Notice notice = noticeRepository.findById(newNotice.getNotice_id()).orElse(null);
        if(notice == null) return null;
        return noticeRepository.save(newNotice);
    }

    //공지사항 삭제
    public void remove(Integer notice_id) {
        noticeRepository.deleteById(notice_id);
    }
}
