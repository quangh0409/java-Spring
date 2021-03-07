package com.example.Java_Spring.controller;


import com.example.Java_Spring.dto.login.LoginRequestDto;
import com.example.Java_Spring.dto.login.LoginResponseDto;
import com.example.Java_Spring.entity.Account;
import com.example.Java_Spring.exception.ApiException;
import com.example.Java_Spring.service.AccountService;
import com.example.Java_Spring.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/auth")
public class AuthController {
    //login

    @Autowired
    AccountService accountService;
    @Autowired
    SessionService sessionService;

    @PostMapping("/login")
    public LoginResponseDto login(@RequestBody LoginRequestDto loginRequestDto) throws ApiException {
        // kieerm tra xem co nguoi dung co email va password do ko => neu co, query lay ra id thang day

        System.out.println("ok");
        Account account = accountService.getAccountByEmailAndPassword(loginRequestDto.getEmail(), loginRequestDto.getPassword());
        if (account == null) {
            throw new ApiException("sai tai khoan hoac mat khau");
        }
        String accountId = account.getAccountID();
        String token = UUID.randomUUID().toString();
        Boolean createSessionResult = sessionService.createSession(accountId, token);
        if (createSessionResult) {
            return new LoginResponseDto(token);
        } else {
            throw new ApiException("dang nhap that bai, vui long thu lai sau");
        }
    }


}
