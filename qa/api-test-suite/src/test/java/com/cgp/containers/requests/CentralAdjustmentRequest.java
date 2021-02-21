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

public class CentralAdjustmentRequest {
    @JsonProperty("src_central_account_code")
    @NonNull
    private String src_central_account_code;
    @JsonProperty("dest_central_account_code")
    @NonNull
    private String dest_central_account_code;
    @JsonProperty("sub_entity_code")
    @NonNull
    private String sub_entity_code;
    @JsonProperty("amount")
    private BigDecimal amount;
    @JsonProperty("description")
    @NonNull
    private String description;
}
