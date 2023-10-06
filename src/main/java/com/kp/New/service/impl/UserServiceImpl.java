package com.kp.New.service.impl;

import com.kp.New.dao.UserDao;
import com.kp.New.entity.User;
import com.kp.New.service.UserService;
import com.kp.New.view.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User save(UserRequest userRequest) {
        if(userRequest.getName()==null){
            // throw exception
        }
        User user=userRequest.toEntity();
        userDao.save(user);
        return user;
    }

    @Override
    public List<User> fetchAllUsers() {
        return userDao.findAll();
    }
}
