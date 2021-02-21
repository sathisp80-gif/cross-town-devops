package com.cgp.containers.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.stereotype.Component;

@Data
@Builder
@Component
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {
    @JsonProperty(value = "response_code")
    @NonNull
    private int responseCode;
    @JsonProperty(value = "response_message")
    private String responseMessage;
    @JsonProperty("auth_response")
    @NonNull
    private String authResponse;
}
