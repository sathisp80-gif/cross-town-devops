package com.cgp.containers.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
public class AccountCreateRequest {

    @JsonProperty("program_code")
    @NonNull
    private String program_code;
    @JsonProperty("sub_entity_code")
    @NonNull
    private String sub_entity_code;
    @JsonProperty("address")
    private Address address;
    @JsonProperty("account_name")
    @NonNull
    private String account_name;
    @JsonProperty("currency_code")
    @NonNull
    private String currency_code;
;
}
