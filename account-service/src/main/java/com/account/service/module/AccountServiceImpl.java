package com.account.service.module;

import com.account.service.client.StatementClient;
import com.account.service.client.TransactionClient;
import com.account.service.model.Account;
import com.account.service.model.AccountResponse;
import com.account.service.model.StatementResponse;
import com.account.service.model.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class AccountServiceImpl implements AccountService {

    private Logger LOGGER = LoggerFactory.getLogger(TransactionClient.class);

    @Autowired
    private StatementClient statementClient;


    @Autowired
    private TransactionClient transactionClient;


    @Override
    public AccountResponse getAccountDetails(String id) {

        LOGGER.info("get account details");
        Account account = new Account();
        account.setAccountNumber(id);
        account.setAccountType("saving");
        account.setAvailableBalance("RS 323434");

        AccountResponse response = new AccountResponse();
        response.setAccount(account);
        try {
            LOGGER.info("calling statement service");
            Mono<StatementResponse> statementResponseMono = statementClient.getStatement(id);

            LOGGER.info("calling transactions service");
            List<Transaction> transactionList = transactionClient.getTransaction(id);

            response.setStatements(statementResponseMono.block().getTransactions());
            response.setTransactions(transactionList);
        } catch (Exception e) {
            LOGGER.error("Error while fetching statement and transaction , error {}", e.getMessage());
        }
        return response;
    }


}
