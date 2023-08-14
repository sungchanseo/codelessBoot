package com.sungchan.codeless.notice;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Integer> {
    //제목으로 검색
    Page<Notice> findByTitleContaining(String keyword, Pageable pageable);

    //내용으로 검색
    Page<Notice> findByContentContaining(String keyword, Pageable pageable);
}
