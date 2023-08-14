package com.sungchan.codeless.faq;

import com.sungchan.codeless.notice.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FaqService {

    @Autowired
    private FaqRepository faqRepository;

    //자주묻는질문 리스트 불러오기
    public List<Faq> getList(){
        return (List<Faq>) faqRepository.findAll();
    }

    //faq 읽기
    public Faq read(Integer faqId){
        return faqRepository.findById(faqId).orElse(null);
    }

    //faq 작성하기
    public Faq insert(Faq faq) {
        return faqRepository.save(faq);
    }

    //faq 수정하기
    public Faq modify(Faq neqFaq) {
        Faq faq = faqRepository.findById(neqFaq.getFaqId()).orElse(null);

        if(faq == null) return null;
        return faqRepository.save(neqFaq);
    }

    //faq 삭제하기
    public void remove(Integer faqId) {
        faqRepository.deleteById(faqId);
    }

    //페이징처리만
    @Transactional(readOnly = true)
    public Page<Faq> getListPaging(Pageable pageable) {
        return faqRepository.findAll(pageable);
    }
}
