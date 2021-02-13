package com.citizens.statement.service;

import com.citizens.statement.response.StatementResponse;

public interface StatementService {

    StatementResponse getStatementResponse(String payee);
}
