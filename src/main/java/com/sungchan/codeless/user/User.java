package com.sungchan.codeless.user;

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
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_id;
    private String id;
    private String password;
    private String name;
    private String nickname;
    private String phone_number;
    private String address;
    private String user_image;
    private Date regdate;
    private String birth_date;
    private Boolean blocked;
    private Integer post_number;
    private String address2;
    private String email;
    private Boolean withdrawal;
}
