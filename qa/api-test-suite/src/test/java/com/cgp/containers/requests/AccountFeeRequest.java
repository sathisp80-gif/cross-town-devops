package com.cgp.containers.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
public class AccountFeeRequest {
    @JsonProperty("account_code")
    @NonNull
    private String account_code;
    @JsonProperty("sub_entity_code")
    @NonNull
    private String sub_entity_code;
    @JsonProperty("amount")
    @NonNull
    private Double amount;
    @JsonProperty("description")
    @NonNull
    private String description;
}
