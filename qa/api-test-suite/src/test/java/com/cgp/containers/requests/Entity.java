package com.cgp.containers.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Entity {
//    @JsonProperty("login_id")
//    @NonNull
//    private Integer loginId;
    @JsonProperty("address")
    private Address address;
    @JsonProperty("company_name")
    @NonNull
    private String company_name;
    @JsonProperty("entity_code")
    private String entity_code;
    @JsonProperty("program_code")
    @NonNull
    private String program_code;
    @JsonProperty("currency_code")
    @NonNull
    private String currency_code;
}
