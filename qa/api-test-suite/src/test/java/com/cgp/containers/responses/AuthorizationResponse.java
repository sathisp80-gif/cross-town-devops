package com.cgp.containers.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.stereotype.Component;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Component
public class AuthorizationResponse {

    @JsonProperty("auth_response")
    @NonNull
    private String auth_response;
    @JsonProperty("sub_entity_code")
    @NonNull
    private String sub_entity_code;
    @JsonProperty("response_code")
    @NonNull
    private Integer response_code;
    @JsonProperty("response_message")
    private String response_message;
}
