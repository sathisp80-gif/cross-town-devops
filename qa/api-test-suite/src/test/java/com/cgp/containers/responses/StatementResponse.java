package com.cgp.containers.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Builder
@Component
@AllArgsConstructor
@NoArgsConstructor
public class StatementResponse {
    @JsonProperty(value = "error_code")
    @NonNull
    private int responseCode;
    @JsonProperty(value = "error_message")
    private String responseMessage;
    @JsonProperty("payee")
    private String payee;
    @JsonProperty(value = "statement")
    private List<Statement> statement;
}
