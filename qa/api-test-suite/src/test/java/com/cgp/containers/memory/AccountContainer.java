package com.cgp.containers.memory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountContainer {
    private String accountHolderName;
    private String accountName;
    private String accountCode;
    private String currencyCode;
}
