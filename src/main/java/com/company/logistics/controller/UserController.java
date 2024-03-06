package com.company.logistics.controller;

import com.company.logistics.controller.dto.user.*;
import com.company.logistics.model.User;
import com.company.logistics.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public User login(@RequestBody LoginRequest loginRequest) {
        return userService.findByUsernameAndPassword(loginRequest.getUsername(), loginRequest.getPassword());
    }

    @GetMapping("/user/list")
    public GetUserResponse findAllUsers(@RequestParam("offset") int offset, @RequestParam("pageSize") int pageSize) {
        return userService.findAllUsers(offset, pageSize);
    }

    @PostMapping("/user/add")
    public int addUser(@RequestBody AddUserRequest addUserRequest) {
        return userService.addUser(addUserRequest);
    }

    @DeleteMapping("/user/delete/{token}")
    public ResponseEntity<Void> deleteUser(@PathVariable("token") String token) {
        userService.deleteUser(token);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/user/info")
    public User findUsersInfo(@RequestParam("token") String token) {
        return userService.findUser(token);
    }

    @PostMapping("/user/info")
    public int updateUser(@RequestBody UpdateUserRequest updateUserRequest) {
        return userService.updateUser(updateUserRequest);
    }

    @PostMapping("/user/password")
    public int updatePassword(@RequestBody UpdatePasswordRequest updatePasswordRequest) {
        return userService.updatePassword(updatePasswordRequest);
    }
}
