package com.cgp.containers.responses;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.stereotype.Component;

@Data
@Builder
@Component
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserResponse {
    @JsonProperty(value = "loginId")
    private long loginId;
    @JsonProperty(value = "responseCode")
    @NonNull
    private int responseCode;
    @JsonProperty(value = "responseMessage")
    private String responseMessage;
    @JsonIgnore
    private Integer httpStatusCode;
}
