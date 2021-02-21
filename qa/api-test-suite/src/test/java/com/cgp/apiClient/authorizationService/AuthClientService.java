package com.cgp.apiClient.authorizationService;

import com.cgp.containers.requests.AccountHolder;
import com.cgp.containers.requests.AuthorizationRequest;
import com.cgp.containers.responses.AuthorizationResponse;
import com.cgp.containers.responses.CreateAccountHolderResponse;
import com.cgp.interfaces.getRequest.GetHttpRequestProcessor;
import com.cgp.interfaces.postRequest.PostHttpRequestProcessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AuthClientService {

    PostHttpRequestProcessor postHttpRequestProcessor;
    GetHttpRequestProcessor getHttpRequestProcessor;
    ObjectMapper objectMapper;

    String accountServiceUrl = System.getProperty("auth.service.url");

    public AuthorizationResponse authorization(AuthorizationRequest authRequest, String userName) throws IOException {
        postHttpRequestProcessor = new PostHttpRequestProcessor();
        String url = accountServiceUrl+"/authorization";
        Map<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("login_id", System.getProperty(userName));
        HttpResponse response = postHttpRequestProcessor.postRequestWithRequestBody(url, headerMap, authRequest);
        objectMapper = new ObjectMapper();
        return objectMapper.readValue( response.getEntity().getContent(), AuthorizationResponse.class);
    }
}
