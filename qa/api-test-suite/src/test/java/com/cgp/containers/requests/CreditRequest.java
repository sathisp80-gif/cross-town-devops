package com.cgp.containers.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
public class CreditRequest {

    @JsonProperty("account_code")
    @NonNull
    private String account_code;
    @JsonProperty("account_holder_code")
    @NonNull
    private String account_holder_code;
    @JsonProperty("sub_entity_code")
    @NonNull
    private String sub_entity_code;
    @JsonProperty("currency_code")
    private String currency_code;
    @JsonProperty("amount")
    private BigDecimal amount;
    @JsonProperty("description")
    private String description;
    @JsonProperty("payment_gateway")
    private PaymentGateWay payment_gateway;

}
