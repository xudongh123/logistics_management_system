package com.company.logistics.service;

import com.company.logistics.mapper.AccountMapper;
import com.company.logistics.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    private final AccountMapper accountMapper;

    @Autowired
    public AccountService(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }

    public Account findByUsernameAndPassword(String username, String password) {
        Account account = accountMapper.findByUsernameAndPassword(username, password);

        // 打印出Account对象的信息
        if(account != null) {
            System.out.println("Account [token=" + account.getToken() + ", username=" + account.getUsername()
                    + ", password=" + account.getPassword() + ", permissionLevel=" + account.getPermissionLevel() + "]");
        } else {
            System.out.println("No account found with the provided username and password.");
        }

        return account;
    }
}
