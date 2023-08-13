package com.sungchan.codeless.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //멤버 리스트 조회
    public List<User> getList() {
        return (List<User>) userRepository.findAll();
    }

    //회원가입
    public User joinUser(User user){
        return userRepository.save(user);
    }

    //회원정보 조회
    public User getUser(Integer user_id) {
        return userRepository.findById(user_id).orElse(null);
    }

    //회원정보 수정
    public User modifyUser(User newUser) {
        User user = userRepository.findById(newUser.getUser_id()).orElse(null);

        if(user == null) return null;
        return userRepository.save(newUser);
    }

    //회원정보 삭제
    public void removeUser(Integer user_id) {
        User user = userRepository.findById(user_id).orElse(null);
        if(user != null) userRepository.deleteById(user_id);
    }



}
