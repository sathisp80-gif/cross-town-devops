package com.cgp.containers.responses;

import com.cgp.containers.requests.AccountHolder;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Data
@Builder
@Component
@AllArgsConstructor
@NoArgsConstructor
public class AccountResponse {
    @JsonProperty(value = "account_name")
    private String accountName;
    @JsonProperty(value = "account_code")
    private String accountCode;
    @JsonProperty(value = "balance_amount")
    private BigDecimal balanceAmount;
    @JsonProperty(value = "account_status")
    private String accountStatus;
    @JsonProperty(value = "account_type")
    private String accountType;
    @JsonProperty(value = "program_name")
    private String programName;
    @JsonProperty(value = "program_code")
    private String programCode;
    @JsonProperty(value = "currency_code")
    private String currencyCode;
    @JsonProperty(value = "account_holder")
    private AccountHolder accountHolder;
    @JsonProperty(value = "response_code")
    private int responseCode;
    @JsonProperty(value = "response_message")
    private String responseMessage;

}
