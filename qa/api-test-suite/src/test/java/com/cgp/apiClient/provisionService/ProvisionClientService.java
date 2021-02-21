package com.cgp.apiClient.provisionService;

import com.cgp.containers.requests.AccountCreateRequest;
import com.cgp.containers.requests.AccountHolder;
import com.cgp.containers.requests.CardOrderRequest;
import com.cgp.containers.responses.AccountOrderResponse;
import com.cgp.containers.responses.CardOrderResponse;
import com.cgp.containers.responses.CreateAccountHolderResponse;
import com.cgp.interfaces.getRequest.GetHttpRequestProcessor;
import com.cgp.interfaces.postRequest.PostHttpRequestProcessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ProvisionClientService {
    PostHttpRequestProcessor postHttpRequestProcessor;
    GetHttpRequestProcessor getHttpRequestProcessor;
    ObjectMapper objectMapper;


    String accountServiceUrl = System.getProperty("provision.service.url");


    public AccountOrderResponse createAccount(AccountCreateRequest request, String userName) throws IOException {
        postHttpRequestProcessor = new PostHttpRequestProcessor();
        String url = accountServiceUrl+"/order/account";
        Map<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("login_id", System.getProperty(userName));
        HttpResponse response = postHttpRequestProcessor.postRequestWithRequestBody(url, headerMap, request);
        objectMapper = new ObjectMapper();
        return objectMapper.readValue( response.getEntity().getContent(), AccountOrderResponse.class);
    }

    public CardOrderResponse orderCard(CardOrderRequest request, String userName) throws IOException {
        postHttpRequestProcessor = new PostHttpRequestProcessor();
        String url = accountServiceUrl+"/order/card";
        Map<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("login_id", System.getProperty(userName));
        HttpResponse response = postHttpRequestProcessor.postRequestWithRequestBody(url, headerMap, request);
        objectMapper = new ObjectMapper();
        return objectMapper.readValue( response.getEntity().getContent(), CardOrderResponse.class);
    }
}
