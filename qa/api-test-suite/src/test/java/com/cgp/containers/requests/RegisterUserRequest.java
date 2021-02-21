package com.cgp.containers.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.Email;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterUserRequest {
    @JsonProperty("email")
    @Email
    public String email;
    @JsonProperty("password")
    @NonNull
    public String password;
    @JsonProperty("first_name")
    @NonNull
    public String first_name;
    @JsonProperty("last_name")
    public String last_name;
    @JsonProperty("date_of_birth")
    public String date_of_birth;
    @JsonProperty("mobile")
    public String mobile;
    @JsonProperty("address_1")
    public String address_1;
    @JsonProperty("address_2")
    public String address_2;
    @JsonProperty("city")
    public String city;
    @JsonProperty("country")
    public String country;
    @JsonProperty("contact_type")
    public String contact_type;
}
