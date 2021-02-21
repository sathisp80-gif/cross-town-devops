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
public class CreditVendorSettleRequest {
    @JsonProperty("vendor_settle_account_code")
    @NonNull
    private String vendorSettleAccountCode;
    @JsonProperty("vendor_account_code")
    @NonNull
    private String vendorAccountCode;
    @JsonProperty("sub_entity_code")
    @NonNull
    private String subEnityCode;
    @JsonProperty("currency_code")
    @NonNull
    private String currencyCode;
    @JsonProperty("amount")
    @NonNull
    private BigDecimal amount;
    @JsonProperty("description")
    @NonNull
    private String description;
}
