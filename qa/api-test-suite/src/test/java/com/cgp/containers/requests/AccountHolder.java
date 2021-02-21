package com.cgp.containers.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountHolder {
//    @JsonProperty("login_id")
//    @NonNull
//    private Integer loginId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("address")
    private Address address;
    @JsonProperty("account_holder_code")
    private String accountHolderCode;
}
