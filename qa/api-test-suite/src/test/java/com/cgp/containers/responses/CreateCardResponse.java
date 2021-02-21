package com.cgp.containers.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.stereotype.Component;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Component
public class CreateCardResponse {

    @JsonProperty(value = "response_code")
    @NonNull
    private int responseCode;
    @JsonProperty(value = "response_message")
    private String responseMessage;
    @JsonProperty(value = "card_client_code")
    private String cardClientcode;
    @JsonProperty(value = "ch_client_code")
    private String cardHolderClientCode;
}
