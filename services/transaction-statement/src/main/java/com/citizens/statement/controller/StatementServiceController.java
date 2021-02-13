package com.citizens.statement.controller;

import com.citizens.statement.response.StatementResponse;
import com.citizens.statement.service.StatementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatementServiceController {
    @Autowired
    StatementService statementService;
    @GetMapping("statement")
    public StatementResponse getStatementByPayee(@RequestParam("payee") String payee){
        return statementService.getStatementResponse(payee);
    }
}
