package com.cgp.containers.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
public class PaymentGateWay {
    @JsonProperty("description")
    @NonNull
    private String description;
    @JsonProperty("reference_code")
    @NonNull
    private String reference_code;
}
