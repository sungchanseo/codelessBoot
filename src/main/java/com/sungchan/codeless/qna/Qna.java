package com.sungchan.codeless.qna;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Getter @Setter @ToString
@Entity
public class Qna {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "qna_id")
    private Integer qnaId;
    @Column(name = "user_id")
    private Integer userID;
    @Column(name = "product_id")
    private Integer productId;
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
