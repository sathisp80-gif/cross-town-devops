package com.cgp.containers.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfileRequest {
    @JsonProperty("profile_name")
    @NonNull
    private String profile_name;
    @JsonProperty("entity_code")
    private String entity_code;
}
