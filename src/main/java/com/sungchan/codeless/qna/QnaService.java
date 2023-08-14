package com.sungchan.codeless.qna;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QnaService{

    @Autowired
    private QnaRepository qnaRepository;

    //qna 목록 조회
    public List<Qna> getList(){ return (List<Qna>) qnaRepository.findAll();}

    //qna 글쓰기
    public Qna insertQna(Qna qna) {
        return qnaRepository.save(qna);
    }

    //qna 글읽기
    public Qna readQna(Integer qnaId) {
        return qnaRepository.findById(qnaId).orElse(null);
    }

    // qna 글삭제
    public void removeQna(Integer qnaId) {
        qnaRepository.deleteById(qnaId);
    }

    //qna 글수정
    public Qna updateQna(Qna newQna) {
        Qna qna = qnaRepository.findById(newQna.getQnaId()).orElse(null);
        if (qna == null) return null;
        return qnaRepository.save(newQna);
    }
}
