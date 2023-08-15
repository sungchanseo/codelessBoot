package com.sungchan.codeless.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Getter @Setter @ToString
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;
    private String id;
    private String password;
    private String name;
    private String nickname;
    @Column(name = "phone_number")
    private String phoneNumber;
    private String address;
    @Column(name = "user_image")
    private String userImage;
    private Date regdate;
    @Column(name = "birth_date")
    private String birthDate;
    private Boolean blocked;
    @Column(name = "post_number")
    private Integer postNumber;
    private String address2;
    private String email;
    private Boolean withdrawal;
}
