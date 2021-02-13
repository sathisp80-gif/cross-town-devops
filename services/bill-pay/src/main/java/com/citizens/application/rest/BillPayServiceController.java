package com.citizens.application.rest;

import com.citizens.application.response.GenericResponse;
import com.citizens.domain.service.BillPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class BillPayServiceController {
    @Autowired
    BillPayService billPayService;

    @PostMapping("/fundtransfer")
    public GenericResponse test(@RequestParam("to_account") String toAccount,
                                @RequestParam("description") String description,
                                @RequestParam("amount")BigDecimal amount){
        return billPayService.doAFundTransfer(toAccount, description, amount);
    }
}
