package com.cgp.containers.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @JsonProperty("phone")
    @NonNull
    private Phone phone;
    @JsonProperty("address_1")
    @NonNull
    private String address_1;
    @JsonProperty("address_2")
    private String address_2;
    @JsonProperty("address_3")
    private String address_3;
    @JsonProperty("city")
    @NonNull
    private String city;
    @JsonProperty("state")
    private String state;
    @JsonProperty("country")
    @NonNull
    private String country;
    @JsonProperty("zip")
    @NonNull
    private String zip;




}
