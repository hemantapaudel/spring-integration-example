package com.statement.service.model;

import java.util.List;

public class StatementResponse {


    List<Statement> transactions;

    public List<Statement> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Statement> transactions) {
        this.transactions = transactions;
    }
}
