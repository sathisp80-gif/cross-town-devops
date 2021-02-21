package com.cgp.apiClient.cardService;

import com.cgp.containers.requests.CreateCardRequest;
import com.cgp.containers.requests.ProfileRequest;
import com.cgp.containers.responses.*;
import com.cgp.interfaces.postRequest.PostHttpRequestProcessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import gherkin.deps.com.google.gson.Gson;
import org.apache.http.HttpResponse;
import com.cgp.interfaces.putRequest.PutHttpRequestProcessor;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CardClientService {
    PostHttpRequestProcessor postHttpRequestProcessor;
    PutHttpRequestProcessor putHttpRequestProcessor;

    ObjectMapper objectMapper;
    Gson gson;


    String cardServiceUrl = System.getProperty("card.service.url");

    //createProgram
    public CreateProfileResponse createProfile(ProfileRequest request, String userName) throws IOException {
        postHttpRequestProcessor = new PostHttpRequestProcessor();
        String url = cardServiceUrl+"/profile";
        Map<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("login_id", System.getProperty(userName));
        HttpResponse response = postHttpRequestProcessor.postRequestWithRequestBody(url, headerMap, request);
        objectMapper = new ObjectMapper();
        return objectMapper.readValue( response.getEntity().getContent(), CreateProfileResponse.class);
    }

    public CreateCardResponse createCard(CreateCardRequest request, String userName) throws IOException {
        postHttpRequestProcessor = new PostHttpRequestProcessor();
        String url = cardServiceUrl+"/card";
        Map<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("login_id", System.getProperty(userName));
        HttpResponse response = postHttpRequestProcessor.postRequestWithRequestBody(url, headerMap, request);
        objectMapper = new ObjectMapper();
        return objectMapper.readValue( response.getEntity().getContent(), CreateCardResponse.class);
    }

    public GenericResponse updateCardStatus(String cardClientCode, String cardStatus, String userName) throws IOException{
        putHttpRequestProcessor = new PutHttpRequestProcessor();
        String url = cardServiceUrl+"/card?card_client_code="+cardClientCode +"&card_status="+cardStatus;
        Map<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("login_id", System.getProperty(userName));
        HttpResponse response = putHttpRequestProcessor.putRequestWithParam(url,headerMap);
        objectMapper = new ObjectMapper();
        return objectMapper.readValue( response.getEntity().getContent(), GenericResponse.class);
    }
}
