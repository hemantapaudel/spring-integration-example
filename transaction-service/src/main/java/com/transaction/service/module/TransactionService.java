package com.transaction.service.module;

import com.transaction.service.model.TransactionResponse;

public interface TransactionService {

    TransactionResponse getAccountTransactions(String accountNumber);


}
