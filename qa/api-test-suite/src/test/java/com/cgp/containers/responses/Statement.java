package com.cgp.containers.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class Statement {
    @JsonProperty(value = "transaction_description")
    private String description;
    @JsonProperty(value = "transaction_reference")
    private String reference;
    @JsonProperty(value = "transaction_date")
    private String transactionDate;
    @JsonProperty(value = "transaction_status")
    private String transactionStatus;
    @JsonProperty(value = "transaction_to")
    private String transactionTo;
    @JsonProperty(value = "amount")
    private BigDecimal amount;
}
