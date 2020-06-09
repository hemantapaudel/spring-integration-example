package com.account.service.controller;


import com.account.service.model.AccountResponse;
import com.account.service.module.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accountservice")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = {"/account"}, produces = {"application/json"},
            method = {RequestMethod.GET})
    public AccountResponse getAccountDetails(@RequestParam String id) throws Exception {
        try {
            return accountService.getAccountDetails(id);
        } catch (Exception e) {
            throw new Exception("Service not avaliable");
        }
    }
}

