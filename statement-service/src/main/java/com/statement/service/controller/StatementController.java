package com.statement.service.controller;

import com.statement.service.model.StatementResponse;
import com.statement.service.module.StatementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/statementservice")
public class StatementController {

    @Autowired
    private StatementService statementService;

    @RequestMapping(value = {"/statement"}, produces = {"application/json"},
            method = {RequestMethod.GET})
    public StatementResponse getAccountTransactions(@RequestParam String id ) throws Exception {
        try{

           return statementService.getLastStatement(id);
        }catch (Exception e){
            throw  new Exception("Service not available");
        }
    }
}
