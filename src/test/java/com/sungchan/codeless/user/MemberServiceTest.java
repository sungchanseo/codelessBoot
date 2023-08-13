package com.sungchan.codeless.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberServiceTest {

    @Autowired
    public UserService memberService;

    @Test
    public void getListTest(){
        List<User> list = memberService.getList();
        System.out.println("list = " + list);
    }

    @Test
    public void joinMemberTest(){
        User member = new User();

        member.setUser_id(131);
        member.setId("new id");
        member.setPassword("1234");
        member.setEmail("newEmail@naver.com");

        memberService.joinUser(member);
        assertTrue(memberService.getUser(131) != null);
    }

    @Test
    public void getMemberTest() {
        memberService.getUser(131);
        assertTrue(memberService.getUser(131) != null);
    }

    @Test
    public void modifyMemberTest() {
        User member = memberService.getUser(131);
        member.setId("modify Id");
        memberService.modifyUser(member);

        User member2 = memberService.getUser(131);
        assertEquals(member.getId(), member2.getId());

    }

    @Test
    public void removeMemberTest() {
        memberService.removeUser(131);
        assertTrue(memberService.getUser(131) == null);
    }
}