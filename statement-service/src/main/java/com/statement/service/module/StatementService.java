package com.statement.service.module;


import com.statement.service.model.StatementResponse;

public interface StatementService {




    StatementResponse getLastStatement(String id);
}
