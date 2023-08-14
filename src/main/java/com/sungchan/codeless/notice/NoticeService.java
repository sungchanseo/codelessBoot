package com.sungchan.codeless.notice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public Notice read(Integer noticeId) {
        return noticeRepository.findById(noticeId).orElse(null);
    }

    //공지사항 수정
    public Notice modify(Notice newNotice) {
        Notice notice = noticeRepository.findById(newNotice.getNoticeId()).orElse(null);
        if(notice == null) return null;
        return noticeRepository.save(newNotice);
    }

    //공지사항 삭제
    public void remove(Integer noticeId) {
        noticeRepository.deleteById(noticeId);
    }

    //검색+페이징처리
    @Transactional(readOnly = true) //읽기만 가능한 트랜젝션
    public Page<Notice> getListSearchPagingByTitle(String keyword, Pageable pageable) {
        return noticeRepository.findByTitleContaining(keyword, pageable);
    }
    @Transactional(readOnly = true) //읽기만 가능한 트랜젝션
    public Page<Notice> getListSearchPagingByContent(String keyword, Pageable pageable) {
        return noticeRepository.findByContentContaining(keyword, pageable);
    }

    //페이징처리
    @Transactional(readOnly = true) //읽기만 가능한 트랜젝션
    public Page<Notice> getListPaging(Pageable pageable) {
        return noticeRepository.findAll(pageable);
    }
}
