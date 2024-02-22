package com.company.logistics.controller;

import com.company.logistics.controller.dto.LoginRequest;
import com.company.logistics.model.Account;
import com.company.logistics.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
