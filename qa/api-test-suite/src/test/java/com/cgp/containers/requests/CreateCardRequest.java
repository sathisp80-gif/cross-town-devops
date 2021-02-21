package com.cgp.containers.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateCardRequest {
    @JsonProperty("card_name")
    @NonNull
    private String card_name;
    @JsonProperty("card_type")
    @NonNull
    private String card_type;
    @JsonProperty("profile_code")
    @NonNull
    private String profile_code;
    @JsonProperty("ch_client_code")
    @NonNull
    private String ch_client_code;
    @JsonProperty("sub_entity_code")
    @NonNull
    private String sub_entity_code;
}
