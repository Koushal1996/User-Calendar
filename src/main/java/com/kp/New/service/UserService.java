package com.kp.New.service;

import com.kp.New.entity.User;
import com.kp.New.view.UserRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    public User save(UserRequest userRequest);

    public List<User> fetchAllUsers();
}
