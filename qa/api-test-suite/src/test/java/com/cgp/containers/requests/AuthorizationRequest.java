package com.cgp.containers.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.stereotype.Component;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Component
public class AuthorizationRequest {
    @JsonProperty("auth_request")
    @NonNull
    private String auth_request;
    @JsonProperty("sub_entity_code")
    @NonNull
    private String sub_entity_code;
}
