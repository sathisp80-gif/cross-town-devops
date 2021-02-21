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
public class CreditVendorRequest {
    @JsonProperty("account_code")
    @NonNull
    private String account_code;
    @JsonProperty("vendor_account_code")
    @NonNull
    private String vendor_account_code;
    @JsonProperty("sub_entity_code")
    @NonNull
    private String sub_entity_code;
    @JsonProperty("currency_code")
    @NonNull
    private String currency_code;
    @JsonProperty("amount")
    @NonNull
    private BigDecimal amount;
    @JsonProperty("description")
    @NonNull
    private String description;
}
