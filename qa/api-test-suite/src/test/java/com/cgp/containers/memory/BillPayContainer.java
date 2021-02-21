package com.cgp.containers.memory;

import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class BillPayContainer {
    private String payee;
    private String description;
    private BigDecimal amount;
    private String errorMessage;
    private Integer errorCode;
    private String transaction;
}
