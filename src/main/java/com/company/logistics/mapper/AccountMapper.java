package com.company.logistics.mapper;

import com.company.logistics.model.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AccountMapper {
    Account findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}

