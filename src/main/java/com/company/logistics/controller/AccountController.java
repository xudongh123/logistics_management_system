package com.company.logistics.controller;

import com.company.logistics.controller.dto.user.*;
import com.company.logistics.controller.dto.driver.SetDriverRequest;
import com.company.logistics.model.Account;
import com.company.logistics.model.User;
import com.company.logistics.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/v1/user/company/loginex")
    public Account login(@RequestBody LoginRequest loginRequest) {
        return accountService.findByUsernameAndPassword(loginRequest.getUsername(), loginRequest.getPassword());
    }

    @GetMapping("/user/list")
    public GetUserResponse findAllUsers(@RequestParam("offset") int offset, @RequestParam("pageSize") int pageSize) {
        return accountService.findAllUsers(offset, pageSize);
    }

    @PostMapping("/user/add")
    public int addUser(@RequestBody AddUserRequest addUserRequest) {
        return accountService.addUser(addUserRequest);
    }

    @DeleteMapping("/user/delete/{token}")
    public ResponseEntity<Void> deleteUser(@PathVariable("token") String token) {
        accountService.deleteAccount(token);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/v1/user/customer/ex/info")
    public Account findUsersInfo(@RequestParam("token") String token) {
        return accountService.findUser(token);
    }

    @PostMapping("/v1/user/customer/info")
    public int updateUser(@RequestBody UpdateUserRequest updateUserRequest) {
        return accountService.updateUser(updateUserRequest);
    }

    @PostMapping("/v1/user/customer/password")
    public int updatePassword(@RequestBody UpdatePasswordRequest updatePasswordRequest) {
        return accountService.updatePassword(updatePasswordRequest);
    }
}
