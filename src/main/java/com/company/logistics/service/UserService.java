package com.company.logistics.service;

import com.company.logistics.mapper.UserMapper;
import com.company.logistics.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public List<User> findAllUsers() {
        return userMapper.findAllUsers();
    }
}
