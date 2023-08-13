package com.sungchan.codeless.faq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Faq read(Integer faq_id){
        return faqRepository.findById(faq_id).orElse(null);
    }

    //faq 작성하기
    public Faq insert(Faq faq) {
        return faqRepository.save(faq);
    }

    //faq 수정하기
    public Faq modify(Faq neqFaq) {
        Faq faq = faqRepository.findById(neqFaq.getFaq_id()).orElse(null);

        if(faq == null) return null;
        return faqRepository.save(neqFaq);
    }

    //faq 삭제하기
    public void remove(Integer faq_id) {
        faqRepository.deleteById(faq_id);
    }
}
