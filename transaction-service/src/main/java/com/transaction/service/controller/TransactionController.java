package com.transaction.service.controller;

import com.transaction.service.model.TransactionResponse;
import com.transaction.service.module.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/transactionservice")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @RequestMapping(value = {"/transaction"}, produces = {"application/json"},
            method = {RequestMethod.GET})
    public TransactionResponse getAccountTransactions(@RequestParam String id) throws Exception {
        try{
           return transactionService.getAccountTransactions(id);
        }catch (Exception e){
            throw  new Exception("Service not avaliable");
        }
    }
}
