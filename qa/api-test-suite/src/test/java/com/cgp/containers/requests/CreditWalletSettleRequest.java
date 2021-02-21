package com.cgp.containers.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreditWalletSettleRequest {
    @JsonProperty("wallet_account_code")
    @NonNull
    private String wallet_account_code;
    @JsonProperty("sub_entity_code")
    @NonNull
    private String sub_entity_code;
    @JsonProperty("currency_code")
    @NonNull
    private String currency_code;
    @JsonProperty("amount")
    @NonNull
    private Double amount;
    @JsonProperty("description")
    @NonNull
    private String description;
}
