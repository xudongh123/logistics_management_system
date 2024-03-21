package com.company.logistics.service;

import com.company.logistics.controller.dto.user.AddUserRequest;
import com.company.logistics.controller.dto.user.GetUserResponse;
import com.company.logistics.controller.dto.user.UpdatePasswordRequest;
import com.company.logistics.controller.dto.user.UpdateUserRequest;
import com.company.logistics.mapper.UserMapper;
import com.company.logistics.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private final UserMapper userMapper; // 用户映射器

    @Autowired
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    // 根据用户名和密码查找用户
    public User findByUsernameAndPassword(String username, String password) {
        User user = userMapper.findByUsernameAndPassword(username, password);

        if(user == null) {
            System.out.println("未找到提供的用户名和密码对应的帐户。");
            throw new RuntimeException("未找到提供的用户名和密码对应的帐户。");
        }

        return user;
    }

    // 查找所有用户
    public GetUserResponse findAllUsers(int offset, int pageSize) {
        List<User> users = userMapper.getUsers(offset, pageSize);
        GetUserResponse response = new GetUserResponse();

        int count = userMapper.countUsers();
        response.setItem(users);
        response.setTotal(count);
        return response;
    }

    // 添加用户
    public int addUser(AddUserRequest addUserRequest) {
        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();

        User user = new User();
        user.setNickname(addUserRequest.getNickname());
        user.setSex(addUserRequest.getSex());
        user.setPassword(addUserRequest.getPassword());
        user.setUsername(addUserRequest.getUsername());
        user.setPermissionLevel(addUserRequest.getPermissionLevel());
        user.setToken(randomUUIDString);

        // 获取当前日期和时间
        Date now = new Date();
        user.setTime(now);
        return userMapper.addUser(user);
    }

    // 删除用户
    public void deleteUser(String token) {
        userMapper.deleteUser(token);
    }

    // 根据token查找用户
    public User findUser(String token) {
        return userMapper.findUser(token);
    }

    // 更新用户信息
    public int updateUser(UpdateUserRequest updateUserRequest) {
        User user = new User();
        user.setNickname(updateUserRequest.getNickname());
        user.setSex(updateUserRequest.getSex());
        user.setToken(updateUserRequest.getToken());
        return userMapper.updateUser(user);
    }

    // 更新用户密码
    public int updatePassword(UpdatePasswordRequest updatePasswordRequest) {
        User user = new User();
        user.setPassword(updatePasswordRequest.getNewPassword());
        user.setToken(updatePasswordRequest.getToken());

        return userMapper.updatePassword(user);
    }
}
