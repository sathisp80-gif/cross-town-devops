package com.cgp.containers.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Phone {
    @JsonProperty("phone_1")
    @NonNull
    private String phone_1;
    @JsonProperty("phone_2")
    private String phone_2;
}
