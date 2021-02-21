package com.cgp.containers.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SettleAccountRequest {
    @JsonProperty("sub_entity_code")
    @NonNull
    private String sub_entity_code;
    @JsonProperty("wallet_account_code")
    @NonNull
    private String wallet_account_code;
}
