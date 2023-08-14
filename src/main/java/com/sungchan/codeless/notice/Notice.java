package com.sungchan.codeless.notice;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Getter @Setter @ToString
@Entity
@Table(name = "notice")
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = true, name = "notice_id")
    private Integer noticeId;
    private String title;
    private Date date;
    private Integer count;
    @Column(name = "notice_image")
    private String noticeImage;
    private String content;
}
