package com.cgp.apiClient.billPayService;

import com.cgp.containers.responses.GenericResponse;
import com.cgp.containers.responses.StatementResponse;
import com.cgp.interfaces.getRequest.GetHttpRequestProcessor;
import com.cgp.interfaces.postRequest.PostHttpRequestProcessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;

import java.io.IOException;
import java.math.BigDecimal;

public class BillPayService {
    GetHttpRequestProcessor getHttpRequestProcessor;
    PostHttpRequestProcessor postHttpRequestProcessor;
    ObjectMapper objectMapper;

    String billPayServiceUrl = System.getProperty("billpay.service.url");
    String statmentServiceUrl = System.getProperty("statement.service.url");

    public GenericResponse doBillPay(String payee, BigDecimal amount, String description ) throws IOException {

        postHttpRequestProcessor = new PostHttpRequestProcessor();
        String url = billPayServiceUrl+"/fundtransfer?to_account="+payee+"&description="+description+"&amount="+amount ;

        //HttpResponse response = getHttpRequestProcessor.executeGetRequests(url);
        HttpResponse response = postHttpRequestProcessor.executeGetRequests(url);
        objectMapper = new ObjectMapper();
        return objectMapper.readValue( response.getEntity().getContent(), GenericResponse.class);
    }

    public StatementResponse getStatement(String payee) throws IOException{
        getHttpRequestProcessor = new GetHttpRequestProcessor();
        String url = statmentServiceUrl + "/statement?payee="+payee;
        HttpResponse response = getHttpRequestProcessor.executeGetRequests(url);
        objectMapper = new ObjectMapper();
        return objectMapper.readValue( response.getEntity().getContent(), StatementResponse.class);
    }

}

