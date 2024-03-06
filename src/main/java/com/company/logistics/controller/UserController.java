package com.company.logistics.controller;

import com.company.logistics.model.User;
import com.company.logistics.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> findAllUsers() {
        return userService.findAllUsers();
    }

//    @GetMapping("/v1/user/customer/ex/info")
//    public User findUsersInfo() {
//        return userService.findUser();
//    }
}
