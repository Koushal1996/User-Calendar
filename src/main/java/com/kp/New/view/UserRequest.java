package com.kp.New.view;

import com.kp.New.entity.User;

import java.time.LocalDateTime;

public class UserRequest {

    private String name;

    public String getName() {
        return name;
    }

    public User toEntity(){
        User user=new User();
        user.setName(this.name);
        user.setCreatedAt(LocalDateTime.now());
        return user;
    }
}
