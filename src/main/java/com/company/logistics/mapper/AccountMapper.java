package com.company.logistics.mapper;

import com.company.logistics.model.Account;
import com.company.logistics.model.Driver;
import com.company.logistics.model.Goods;
import com.company.logistics.model.Profit;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AccountMapper {
    Account findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
    List<Account> getUsers(int offset, int pageSize);
    int countUsers();
    int addAccount(Account account);
    void deleteAccount(String token);
    Account findUser(String token);
    int updateAccount(Account account);
    int updatePassword(Account account);
}

