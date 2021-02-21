package com.cgp.containers.memory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginContainer {

    private Long loginId;
    private String loginEmail;
    private String loginPass;
    private String firstName;
    private String lastName;
    private String designation;
}
