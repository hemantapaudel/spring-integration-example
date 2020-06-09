package com.statement.service.module;

import com.statement.service.model.Statement;
import com.statement.service.model.StatementResponse;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StatementServiceImpl implements StatementService {

    @Override
    public StatementResponse getLastStatement(String accountNumber) {
        StatementResponse response = new StatementResponse();
        List<Statement> transactions = new ArrayList<>();
        response.setTransactions(transactions);

        DateTime now = new DateTime(DateTimeZone.UTC);

        Statement statement = null;
        for (int i = 1; i <= 30; i++) {
            statement = new Statement();
            statement.setAccountNumber(accountNumber);
            statement.setDescription("transfer - " + i);
            statement.setStatus("success");
            statement.setTransferDate(now.minusDays(i).toString());
            statement.setTransferAmount(i * 10 + "");
            statement.setCurrency("RS");
            transactions.add(statement);
        }
        return response;

    }
}
