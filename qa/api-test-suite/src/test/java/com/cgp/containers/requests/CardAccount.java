package com.cgp.containers.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardAccount {
//    @JsonProperty("login_id")
//    @NonNull
//    private Integer loginId;
    @JsonProperty("account_reference")
    @NonNull
    private String account_reference;
    @JsonProperty("card_reference")
    @NonNull
    private String card_reference;
}
