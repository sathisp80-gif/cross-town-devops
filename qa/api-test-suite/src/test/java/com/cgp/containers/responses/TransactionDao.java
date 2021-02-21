package com.cgp.containers.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Data
@Builder
@Component
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDao {

    private String transactionCode;
    private String transactionStatus;
    private String transactionFromAccount;
    private String transactionToAccount;
    private BigDecimal transactionAmount;
    private String transactionDesc;
    private String transactionAddDtg;

}
