package com.sungchan.codeless.qna;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Getter @Setter @ToString
@Entity
public class Qna {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer qna_id;
    private Integer user_iD;
    private Integer product_id;
    private String qnaCategory;
    private String title;
    private Date regdate;
    private String content;
    private String image;
    private Integer re_Ref;
    private Integer re_Lev;
    private Integer re_Seq;
    private Integer bno;
    private String id;
    private String nickname;
    private boolean isAnswered;
}
