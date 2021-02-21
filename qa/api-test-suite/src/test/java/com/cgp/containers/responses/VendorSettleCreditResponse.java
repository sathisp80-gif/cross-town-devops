package com.cgp.containers.responses;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
public class VendorSettleCreditResponse {
    @JsonProperty("operation_id")
    @NonNull
    private Long operationId;
    @JsonProperty("response_message")
    private String responseMessage;
    @JsonProperty("response_code")
    @NonNull
    private Long responseCode;

}

