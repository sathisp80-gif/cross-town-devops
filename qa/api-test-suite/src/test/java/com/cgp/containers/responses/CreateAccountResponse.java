package com.cgp.containers.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.stereotype.Component;

@Data
@Builder
@Component
@AllArgsConstructor
@NoArgsConstructor
public class CreateAccountResponse {
    @JsonProperty(value = "response_code")
    @NonNull
    private int responseCode;
    @JsonProperty(value = "response_message")
    private String responseMessage;
    @JsonProperty(value = "account_code")
    private String accountCode;
    @JsonProperty(value = "account_holder_code")
    private String accountHolderCode;
    @JsonProperty(value="currency_code")
    private String currencyCode;
}
