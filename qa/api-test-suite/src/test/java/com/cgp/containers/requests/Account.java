package com.cgp.containers.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
public class Account {
//    @JsonProperty("login_id")
//    @NonNull
//    private Integer loginId;
    @JsonProperty("account_name")
    @NonNull
    private String account_name;
    @JsonProperty("account_type")
    @NonNull
    private String account_type;
    @JsonProperty("currency_code")
    @NonNull
    private String currency_code;
    @JsonProperty("program_code")
    @NonNull
    private String program_code;
    @JsonProperty("entity_code")
    @NonNull
    private String entity_code;
    @JsonProperty("account_holder_code")
    private String account_holder_code;

}
