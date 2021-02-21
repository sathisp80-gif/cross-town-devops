package com.cgp.apiClient.accountService;

import com.cgp.containers.requests.*;
import com.cgp.containers.responses.*;
import com.cgp.interfaces.getRequest.GetHttpRequestProcessor;
import com.cgp.interfaces.postRequest.PostHttpRequestProcessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AccountClientService {
    PostHttpRequestProcessor postHttpRequestProcessor;
    GetHttpRequestProcessor getHttpRequestProcessor;
    ObjectMapper objectMapper;


    String accountServiceUrl = System.getProperty("account.service.url");


    public CreateAccountHolderResponse createAccountHolder(AccountHolder accountHolder, String userName) throws IOException {
        postHttpRequestProcessor = new PostHttpRequestProcessor();
        String url = accountServiceUrl+"/accountholder";
        Map<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("login_id", System.getProperty(userName));
        HttpResponse response = postHttpRequestProcessor.postRequestWithRequestBody(url, headerMap, accountHolder);
        objectMapper = new ObjectMapper();
        return objectMapper.readValue( response.getEntity().getContent(), CreateAccountHolderResponse.class);
    }

    public CreateAccountResponse createAccount(Account account, String userName) throws IOException {
        postHttpRequestProcessor = new PostHttpRequestProcessor();
        String url = accountServiceUrl+"/account";
        Map<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("login_id", System.getProperty(userName));
        HttpResponse response = postHttpRequestProcessor.postRequestWithRequestBody(url, headerMap, account);
        objectMapper = new ObjectMapper();
        return objectMapper.readValue( response.getEntity().getContent(), CreateAccountResponse.class);
    }

    public GenericResponse linkCardAccount(CardAccount request, String userName) throws IOException {
        postHttpRequestProcessor = new PostHttpRequestProcessor();
        String url = accountServiceUrl+"/cardaccount";
        Map<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("login_id", System.getProperty(userName));
        HttpResponse response = postHttpRequestProcessor.postRequestWithRequestBody(url, headerMap, request);
        objectMapper = new ObjectMapper();
        return objectMapper.readValue( response.getEntity().getContent(), GenericResponse.class);
    }

    public AccountResponse getAccountBuAccountCode(String accountCode) throws IOException {
        getHttpRequestProcessor = new GetHttpRequestProcessor();
        String url = accountServiceUrl+"/account/account/"+accountCode;
        HttpResponse response = getHttpRequestProcessor.executeGetRequests(url);
        objectMapper = new ObjectMapper();
        return objectMapper.readValue( response.getEntity().getContent(), AccountResponse.class);
    }
    public GetAccountBySubEntityIdResponse getCentralAccountCode(String subEntityCode, boolean isInternal)
            throws IOException {
        String url = null;
        getHttpRequestProcessor = new GetHttpRequestProcessor();
        if(isInternal) {
            url = accountServiceUrl + "/account/subentity/internal/" + subEntityCode;
        } else{
            url = accountServiceUrl + "/account/subentity/" + subEntityCode;
        }
        HttpResponse response = getHttpRequestProcessor.executeGetRequests(url);
        objectMapper = new ObjectMapper();
        return objectMapper.readValue( response.getEntity().getContent(),GetAccountBySubEntityIdResponse.class);
    }

    public CreateWalletSettleAccountResponse createSettleAccount(SettleAccountRequest settleAccountRequest, String login)
            throws IOException {
        postHttpRequestProcessor = new PostHttpRequestProcessor();
        String url = accountServiceUrl+"/account/settle";
        Map<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("login_id", System.getProperty(login));
        HttpResponse response = postHttpRequestProcessor.postRequestWithRequestBody(url, headerMap, settleAccountRequest);
        objectMapper = new ObjectMapper();
        return objectMapper.readValue( response.getEntity().getContent(), CreateWalletSettleAccountResponse.class);
    }
}
