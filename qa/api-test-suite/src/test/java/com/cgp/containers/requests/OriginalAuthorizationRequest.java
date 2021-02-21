package com.cgp.containers.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.stereotype.Component;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Component
public class OriginalAuthorizationRequest {
    @JsonProperty("account_code")
    @NonNull
    private String account_code;
    @JsonProperty("card_client_code")
    @NonNull
    private String card_client_code;
    @JsonProperty("amount")
    @NonNull
    private Double amount;
    @JsonProperty("description")
    private String description;
    @JsonProperty("transaction_type")
    private String transaction_type;
    @JsonProperty("sub_entity_code")
    @NonNull
    private String sub_entity_code;
    @JsonProperty("currency_code")
    @NonNull
    private String currency_code;
}
