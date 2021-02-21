package com.cgp.containers.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProgramRequest {
    @JsonProperty("program_name")
    @NonNull
    private String program_name;
    @JsonProperty("entity_code")
    private String entity_code;
}
