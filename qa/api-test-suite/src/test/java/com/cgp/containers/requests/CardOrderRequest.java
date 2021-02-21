package com.cgp.containers.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
public class CardOrderRequest {
//    @JsonProperty("login_id")
//    @NonNull
//    private Integer loginId;
    @JsonProperty("card_name")
    @NonNull
    private String card_name;
    @JsonProperty("currency_code")
    @NonNull
    private String currency_code;
    @JsonProperty("program_code")
    @NonNull
    private String program_code;
    @JsonProperty("profile_code")
    @NonNull
    private String profile_code;
    @JsonProperty("sub_entity_code")
    @NonNull
    private String sub_entity_code;
    @JsonProperty("ch_client_code")
    private String ch_client_code;
    @JsonProperty("account_code")
    private String account_code;
    @JsonProperty("address")
    private Address address;
    @JsonProperty("card_type")
    private String card_type;

}
