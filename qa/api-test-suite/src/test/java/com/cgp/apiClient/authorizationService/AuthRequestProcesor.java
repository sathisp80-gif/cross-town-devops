package com.cgp.apiClient.authorizationService;

import com.cgp.containers.requests.OriginalAuthorizationRequest;
import com.cgp.containers.requests.ParseEncryptRequest;
import com.cgp.containers.requests.ParserResponse;

import com.cgp.containers.responses.OriginalAuthorizationResponse;
import com.cgp.interfaces.getRequest.GetHttpRequestProcessor;
import com.cgp.interfaces.postRequest.PostHttpRequestProcessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.apache.http.HttpResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AuthRequestProcesor {
    PostHttpRequestProcessor postHttpRequestProcessor;
    GetHttpRequestProcessor getHttpRequestProcessor;
    ObjectMapper objectMapper;


    String authServiceUrl = System.getProperty("auth.service.url");


    public ParserResponse generateEncryptString(OriginalAuthorizationRequest originalAuthorizationRequest, String userName) throws IOException {
        postHttpRequestProcessor = new PostHttpRequestProcessor();
        String url = authServiceUrl+"/authorization/encrypt";
        Map<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("login_id", System.getProperty(userName));
        HttpResponse response = postHttpRequestProcessor.postRequestWithRequestBody(url, headerMap, originalAuthorizationRequest);
        objectMapper = new ObjectMapper();
        return objectMapper.readValue( response.getEntity().getContent(), ParserResponse.class);
    }

    public ParserResponse generateDecryptString(ParseEncryptRequest encryptRequest, String userName) throws IOException {
        postHttpRequestProcessor = new PostHttpRequestProcessor();
        String url = authServiceUrl+"/authorization/decrypt";
        Map<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("login_id", System.getProperty(userName));
        HttpResponse response = postHttpRequestProcessor.postRequestWithRequestBody(url, headerMap, encryptRequest);
        objectMapper = new ObjectMapper();
        return objectMapper.readValue( response.getEntity().getContent(), ParserResponse.class);
    }

    public OriginalAuthorizationResponse responseToObject(String response){
        response = response.replace("OriginalAuthorizationResponse(", "{\"");
        response = response.replace(")","\"}");
        response = response.replace("=","\":\"");
        response = response.replace(", ","\",\"");
        return new Gson().fromJson( response, OriginalAuthorizationResponse.class);
    }


}
