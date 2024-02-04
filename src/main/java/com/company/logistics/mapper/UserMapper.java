package com.company.logistics.mapper;

import com.company.logistics.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> findAllUsers();
}
