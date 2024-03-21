package com.company.logistics.controller;

import com.company.logistics.controller.dto.user.*;
import com.company.logistics.model.User;
import com.company.logistics.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private final UserService userService; // 用户服务

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 用户登录
     *
     * @param loginRequest 登录请求对象
     * @return 用户信息
     */
    @PostMapping("/login")
    public User login(@RequestBody LoginRequest loginRequest) {
        return userService.findByUsernameAndPassword(loginRequest.getUsername(), loginRequest.getPassword());
    }

    /**
     * 获取所有用户列表
     *
     * @param offset 数据偏移量
     * @param pageSize 每页数据数量
     * @return 包含用户列表的响应对象
     */
    @GetMapping("/user/list")
    public GetUserResponse findAllUsers(@RequestParam("offset") int offset, @RequestParam("pageSize") int pageSize) {
        return userService.findAllUsers(offset, pageSize);
    }

    /**
     * 添加用户
     *
     * @param addUserRequest 添加用户请求对象
     * @return 添加用户的结果
     */
    @PostMapping("/user/add")
    public int addUser(@RequestBody AddUserRequest addUserRequest) {
        return userService.addUser(addUserRequest);
    }

    /**
     * 删除用户
     *
     * @param token 用户令牌
     * @return 删除用户的响应
     */
    @DeleteMapping("/user/delete/{token}")
    public ResponseEntity<Void> deleteUser(@PathVariable("token") String token) {
        userService.deleteUser(token);
        return ResponseEntity.noContent().build();
    }

    /**
     * 查找用户信息
     *
     * @param token 用户令牌
     * @return 用户信息
     */
    @GetMapping("/user/info")
    public User findUsersInfo(@RequestParam("token") String token) {
        return userService.findUser(token);
    }

    /**
     * 更新用户信息
     *
     * @param updateUserRequest 更新用户请求对象
     * @return 更新用户信息的结果
     */
    @PostMapping("/user/info")
    public int updateUser(@RequestBody UpdateUserRequest updateUserRequest) {
        return userService.updateUser(updateUserRequest);
    }

    /**
     * 更新用户密码
     *
     * @param updatePasswordRequest 更新密码请求对象
     * @return 更新密码的结果
     */
    @PostMapping("/user/password")
    public int updatePassword(@RequestBody UpdatePasswordRequest updatePasswordRequest) {
        return userService.updatePassword(updatePasswordRequest);
    }
}
