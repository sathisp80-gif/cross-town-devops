package com.cgp.containers.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Builder
@Component
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {
    private long loginId;
    private String firstName;
    private String lastName;
    private String designation;


}
