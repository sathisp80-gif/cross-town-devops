package com.cgp.containers.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
public class AccountOrderResponse {

    @JsonProperty("ch_client_code")
    @NonNull
    private String chClientCode;
    @JsonProperty("entity_code")
    @NonNull
    private String entityCode;
    @JsonProperty("account_code")
    @NonNull
    private String accountCode;
    @JsonProperty("response_code")
    @NonNull
    private Integer responseCode;
    @JsonProperty("response_message")
    private String responseMessage;
}
