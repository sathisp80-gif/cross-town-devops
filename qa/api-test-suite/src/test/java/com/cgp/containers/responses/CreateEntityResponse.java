package com.cgp.containers.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.stereotype.Component;

@Data
@Builder
@Component
@AllArgsConstructor
@NoArgsConstructor
public class CreateEntityResponse {
    @JsonProperty(value = "response_code")
    @NonNull
    private int responseCode;
    @JsonProperty(value = "response_message")
    private String responseMessage;
    @JsonProperty(value = "entity_code")
    private String entityCode;
    @JsonProperty(value ="subentity_code")
    private String subEntityCode;

}
