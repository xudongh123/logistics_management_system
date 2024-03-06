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
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public User findByUsernameAndPassword(String username, String password) {
        User user = userMapper.findByUsernameAndPassword(username, password);

        if(user == null) {
            System.out.println("No account found with the provided username and password.");
            throw new RuntimeException("No account found with the provided username and password.");
        }

        return user;
    }

    public GetUserResponse findAllUsers(int offset, int pageSize) {
        List<User> users = userMapper.getUsers(offset, pageSize);
        GetUserResponse response = new GetUserResponse();

        int count = userMapper.countUsers();
        response.setItem(users);
        response.setTotal(count);
        return response;
    }

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

    public void deleteUser(String token) {
        userMapper.deleteUser(token);
    }

    public User findUser(String token) {
        return userMapper.findUser(token);
    }

    public int updateUser(UpdateUserRequest updateUserRequest) {
        User user = new User();
        user.setNickname(updateUserRequest.getNickname());
        user.setSex(updateUserRequest.getSex());
        user.setToken(updateUserRequest.getToken());
        return userMapper.updateUser(user);
    }

    public int updatePassword(UpdatePasswordRequest updatePasswordRequest) {
        User user = new User();
        user.setPassword(updatePasswordRequest.getNewPassword());
        user.setToken(updatePasswordRequest.getToken());

        return userMapper.updatePassword(user);
    }
}
