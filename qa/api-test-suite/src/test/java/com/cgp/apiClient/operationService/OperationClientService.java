package com.cgp.apiClient.operationService;

import com.cgp.containers.requests.*;
import com.cgp.containers.responses.*;
import com.cgp.interfaces.postRequest.PostHttpRequestProcessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class OperationClientService {
    PostHttpRequestProcessor postHttpRequestProcessor;
    ObjectMapper objectMapper;


    String accountServiceUrl = System.getProperty("operation.service.url");

    public WalletCreditResponse creditWallet(CreditRequest request, String userName) throws IOException {
        postHttpRequestProcessor = new PostHttpRequestProcessor();
        String url = accountServiceUrl+"/wallet/credit";
        Map<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("login_id", System.getProperty(userName));
        HttpResponse response = postHttpRequestProcessor.postRequestWithRequestBody(url, headerMap, request);
        objectMapper = new ObjectMapper();
        return objectMapper.readValue( response.getEntity().getContent(), WalletCreditResponse.class);
    }

    public CreditResponse creditVendor(CreditVendorRequest request, String userName) throws IOException {
        postHttpRequestProcessor = new PostHttpRequestProcessor();
        String url = accountServiceUrl+"/vendor/credit";
        Map<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("login_id", System.getProperty(userName));
        HttpResponse response = postHttpRequestProcessor.postRequestWithRequestBody(url, headerMap, request);
        objectMapper = new ObjectMapper();
        return objectMapper.readValue( response.getEntity().getContent(), CreditResponse.class);
    }

    public VendorSettleResponse vendorSettle(VendorSettleRequest request, String userName) throws IOException {
        postHttpRequestProcessor = new PostHttpRequestProcessor();
        //System.out.println("****vendor settle request url*****\n");
        String url = accountServiceUrl+"/vendor/settle/central";
        Map<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("login_id", System.getProperty(userName));
        HttpResponse response = postHttpRequestProcessor.postRequestWithRequestBody(url, headerMap, request);
        objectMapper = new ObjectMapper();
        return objectMapper.readValue( response.getEntity().getContent(), VendorSettleResponse.class);
    }

    public VendorSettleCreditResponse vendorSettleCredit(VendorSettleCreditRequest request, String userName) throws IOException {
        postHttpRequestProcessor = new PostHttpRequestProcessor();
        System.out.println("****vendor settle  credit request url*****\n");
        String url = accountServiceUrl+"/vendor/settle/credit";
        Map<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("login_id", System.getProperty(userName));
        HttpResponse response = postHttpRequestProcessor.postRequestWithRequestBody(url, headerMap, request);
        objectMapper = new ObjectMapper();
        return objectMapper.readValue( response.getEntity().getContent(), VendorSettleCreditResponse.class);
    }
    public CentralAdjustmentResponse centralAdjustment(CentralAdjustmentRequest request, String userName) throws IOException {
        postHttpRequestProcessor = new PostHttpRequestProcessor();
        System.out.println("****centralAdjustment request url*****\n");
        String url = accountServiceUrl+"/central/adjustement";
        Map<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("login_id", System.getProperty(userName));
        HttpResponse response = postHttpRequestProcessor.postRequestWithRequestBody(url, headerMap, request);
        objectMapper = new ObjectMapper();
        return objectMapper.readValue( response.getEntity().getContent(), CentralAdjustmentResponse.class);
    }
    public OperationResponse vendorDebit(DebitVendorRequest request, String userName) throws IOException{
        postHttpRequestProcessor = new PostHttpRequestProcessor();
        System.out.println("****vendor debit request url*****\n");
        String url = accountServiceUrl+"/vendor/settle/credit";
        Map<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("login_id", System.getProperty(userName));
        HttpResponse response = postHttpRequestProcessor.postRequestWithRequestBody(url, headerMap, request);
        objectMapper = new ObjectMapper();
        return objectMapper.readValue( response.getEntity().getContent(), OperationResponse.class);
    }

    public OperationResponse accountFee(AccountFeeRequest request, String userName) throws IOException{
        postHttpRequestProcessor = new PostHttpRequestProcessor();
        String url = accountServiceUrl+"/fee";
        Map<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("login_id", System.getProperty(userName));
        HttpResponse response = postHttpRequestProcessor.postRequestWithRequestBody(url, headerMap, request);
        objectMapper = new ObjectMapper();
        return objectMapper.readValue( response.getEntity().getContent(), OperationResponse.class);
    }

    public OperationResponse walletSettleCredit(CreditWalletSettleRequest request, String login) throws IOException {
        postHttpRequestProcessor = new PostHttpRequestProcessor();
        String url = accountServiceUrl+"/wallet/settle/credit";
        Map<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("login_id", System.getProperty(login));
        HttpResponse response = postHttpRequestProcessor.postRequestWithRequestBody(url, headerMap, request);
        objectMapper = new ObjectMapper();
        return objectMapper.readValue( response.getEntity().getContent(), OperationResponse.class);
    }

    public OperationResponse centralWalletSettleCredit(CentralWalletSettleRequest request, String login) throws IOException {
        postHttpRequestProcessor = new PostHttpRequestProcessor();
        String url = accountServiceUrl+"/wallet/settle/central";
        Map<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("login_id", System.getProperty(login));
        HttpResponse response = postHttpRequestProcessor.postRequestWithRequestBody(url, headerMap, request);
        objectMapper = new ObjectMapper();
        return objectMapper.readValue( response.getEntity().getContent(), OperationResponse.class);
    }
}
