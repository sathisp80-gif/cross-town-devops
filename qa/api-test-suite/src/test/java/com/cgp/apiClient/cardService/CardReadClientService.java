package com.cgp.apiClient.cardService;

import com.cgp.containers.responses.AccountResponse;
import com.cgp.containers.responses.CardDetails;
import com.cgp.interfaces.getRequest.GetHttpRequestProcessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import gherkin.deps.com.google.gson.Gson;
import org.apache.http.HttpResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CardReadClientService {
    GetHttpRequestProcessor getHttpRequestProcessor;
    ObjectMapper objectMapper;
    Gson gson;

    String cardServiceUrl = System.getProperty("cardread.service.url");

    public CardDetails getCardDetails(String accountCode, String userName) throws IOException {
        getHttpRequestProcessor = new GetHttpRequestProcessor();
        String url = cardServiceUrl+"/readcard?vendor_account_code="+accountCode;
        Map<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("login_id", System.getProperty(userName));
        HttpResponse response = getHttpRequestProcessor.executeGetRequests(url, headerMap);
        objectMapper = new ObjectMapper();
        return objectMapper.readValue( response.getEntity().getContent(), CardDetails.class);
    }

}
