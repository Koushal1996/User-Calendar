package com.kp.New.controller;

import com.kp.New.entity.User;
import com.kp.New.service.UserService;
import com.kp.New.view.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity<User> saveUser(@RequestBody UserRequest userRequest){
        return ResponseEntity.ok(userService.save(userRequest));
    }

    @GetMapping("/users")
    public List<User> findAll(){
        return userService.fetchAllUsers();
    }
}
