package com.company.logistics.mapper;

import com.company.logistics.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
    List<User> getUsers(int offset, int pageSize);
    int countUsers();
    int addUser(User user);
    void deleteUser(String token);
    User findUser(String token);
    int updateUser(User user);
    int updatePassword(User user);
}

