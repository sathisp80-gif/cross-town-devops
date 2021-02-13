package com.citizens.statement.serviceImpl;

import com.citizens.statement.repository.TransactionRepository;
import com.citizens.statement.response.Statement;
import com.citizens.statement.response.StatementResponse;
import com.citizens.statement.service.StatementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class StatementServiceImpl implements StatementService {
    @Autowired
    TransactionRepository transactionRepository;
    @Override
    public StatementResponse getStatementResponse(String payee) {
        List<Statement> statements = new ArrayList<>();

        List<Map<String, Object>> statementDetails = transactionRepository.findStatementDetailsByPayee(payee);
        statementDetails.forEach(statementDb->{
            statements.add(Statement.builder()
                    .description(statementDb.get("transaction_desc")!=null?statementDb.get("transaction_desc").toString():null)
                    .reference(statementDb.get("transaction_code")!=null?statementDb.get("transaction_code").toString():null)
                    .transactionDate(statementDb.get("transaction_add_dtg")!=null?statementDb.get("transaction_add_dtg").toString():null)
                    .transactionStatus(statementDb.get("transaction_status")!=null?statementDb.get("transaction_status").toString():null)
                    .transactionTo(statementDb.get("transaction_to_account")!=null?statementDb.get("transaction_to_account").toString():null)
                    .amount(statementDb.get("transaction_amount")!=null?new BigDecimal(Long.valueOf(statementDb.get("transaction_amount").toString())/100000) :null)
                    .build());
        });


        return StatementResponse.builder()
                .payee(payee)
                .responseCode(0)
                .responseMessage("OK")
                .statement(statements)
                .build();
    }
}
