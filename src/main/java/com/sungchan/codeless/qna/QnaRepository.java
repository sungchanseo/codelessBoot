package com.sungchan.codeless.qna;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QnaRepository extends CrudRepository<Qna, Integer> {
}
