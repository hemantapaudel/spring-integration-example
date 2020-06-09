package com.transaction.service.module;

import com.transaction.service.model.Transaction;
import com.transaction.service.model.TransactionResponse;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TransactionServiceImpl implements TransactionService {

    @Override
    public TransactionResponse getAccountTransactions(String accountNumber) {
        TransactionResponse response = new TransactionResponse();
        List<Transaction> transactions = new ArrayList<>();
        response.setTransactions(transactions);

        Transaction transaction = null;
        for (int i = 1; i <= 30; i++) {
            transaction = new Transaction();
            transaction.setAccountNumber(accountNumber);
            transaction.setDescription("transfer - " + i);
            transaction.setStatus("success");
            transaction.setTransferDate(new DateTime(DateTimeZone.UTC).minusDays(i).toString());
            transaction.setTransferAmount(i * 10 + "");
            transaction.setCurrency("RS");
            transactions.add(transaction);
        }
        return response;

    }
}
