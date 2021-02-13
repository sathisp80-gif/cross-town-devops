package com.citizens.domain.service;

import com.citizens.application.response.GenericResponse;

import java.math.BigDecimal;

public interface BillPayService {
    GenericResponse doAFundTransfer(String accountNumber, String description, BigDecimal amount);

}
