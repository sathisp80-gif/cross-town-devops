package com.citizens.domain.serviceImpl;

import com.citizens.application.response.GenericResponse;
import com.citizens.infrastructure.entity.Transaction;
import com.citizens.domain.repository.TransactionRepository;
import com.citizens.domain.service.BillPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;
@Service
public class BillPayServiceImpl implements BillPayService {
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    Transaction transaction;

    @Override
    public GenericResponse doAFundTransfer(String accountNumber, String description, BigDecimal amount) {

        transaction = Transaction.builder()
                .transactionAmount(amount.multiply(new BigDecimal(100000)).longValue())
                .transactionCode(String.valueOf(UUID.randomUUID()))
                .transactionDesc(description)
                .transactionTo(accountNumber)
                .transactionFrom("SU1234567")
                .transactionStatus("SUCCESS")
                .build();

        transactionRepository.save(transaction);

        return GenericResponse.builder()
                .responseCode(0)
                .responseMessage("PAYMENT_SUCCESS")
                .build();
    }
}
