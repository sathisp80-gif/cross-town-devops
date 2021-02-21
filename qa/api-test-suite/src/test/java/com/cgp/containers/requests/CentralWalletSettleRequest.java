package com.cgp.containers.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
public class CentralWalletSettleRequest {
    @JsonProperty("wallet_account_code")
    @NonNull
    private String wallet_account_code;
    @JsonProperty("sub_entity_code")
    @NonNull
    private String sub_entity_code;
    @JsonProperty("description")
    @NonNull
    private String description;
}
