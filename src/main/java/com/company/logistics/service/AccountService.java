package com.company.logistics.service;

import com.company.logistics.controller.dto.driver.SetDriverRequest;
import com.company.logistics.controller.dto.profit.UpdatePayRequest;
import com.company.logistics.controller.dto.user.AddUserRequest;
import com.company.logistics.controller.dto.user.UpdatePasswordRequest;
import com.company.logistics.controller.dto.user.UpdateUserRequest;
import com.company.logistics.mapper.AccountMapper;
import com.company.logistics.model.Account;
import com.company.logistics.model.Driver;
import com.company.logistics.model.Profit;
import com.company.logistics.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

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
            throw new RuntimeException("No account found with the provided username and password.");
        }

        return account;
    }

    public List<Account> findAllUsers(int offset, int pageSize) {
        return accountMapper.getUsers(offset, pageSize);
    }

    public int addUser(AddUserRequest addUserRequest) {
        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();

        Account account = new Account();
        account.setNickname(addUserRequest.getNickname());
        account.setSex(addUserRequest.getSex());
        account.setPassword(addUserRequest.getPassword());
        account.setUsername(addUserRequest.getUsername());
        account.setPermissionLevel(addUserRequest.getPermissionLevel());
        account.setToken(randomUUIDString);

        // 获取当前日期和时间
        Date now = new Date();
        account.setTime(now);
        return accountMapper.addAccount(account);
    }

    public void deleteAccount(String token) {
        accountMapper.deleteAccount(token);
    }

    public Account findUser(String token) {
        return accountMapper.findUser(token);
    }

    public int updateUser(UpdateUserRequest updateUserRequest) {
        Account account = new Account();
        account.setNickname(updateUserRequest.getNickname());
        account.setSex(updateUserRequest.getSex());
        account.setToken(updateUserRequest.getToken());
        return accountMapper.updateAccount(account);
    }

    public int updatePassword(UpdatePasswordRequest updatePasswordRequest) {
        Account account = new Account();
        account.setPassword(updatePasswordRequest.getNewPassword());
        account.setToken(updatePasswordRequest.getToken());

        return accountMapper.updatePassword(account);
    }
}
