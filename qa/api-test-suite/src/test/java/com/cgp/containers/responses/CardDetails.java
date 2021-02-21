package com.cgp.containers.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardDetails {
    @JsonProperty("card_client_code")
    @NonNull
    private String cardClientCode;
    @JsonProperty("vendor_account_code")
    @NonNull
    private String vendorAccountCode;
}
