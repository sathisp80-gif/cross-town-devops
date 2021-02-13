package com.citizens.application.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.stereotype.Component;

@Data
@Builder
@Component
@AllArgsConstructor
@NoArgsConstructor
public class GenericResponse {
    @JsonProperty(value = "error_code")
    @NonNull
    private int responseCode;
    @JsonProperty(value = "error_message")
    private String responseMessage;
}
