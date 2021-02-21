package com.cgp.apiClient.entityService;

import com.cgp.containers.requests.Entity;
import com.cgp.containers.requests.ProgramRequest;
import com.cgp.containers.responses.CreateEntityResponse;
import com.cgp.containers.responses.CreateProgramResponse;
import com.cgp.interfaces.postRequest.PostHttpRequestProcessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class EntityClientService {

    PostHttpRequestProcessor postHttpRequestProcessor;
    ObjectMapper objectMapper;


    String entityServiceUrl = System.getProperty("entity.service.url");

    //createProgram
    public CreateProgramResponse createProgram(ProgramRequest request, String userName) throws IOException {
        postHttpRequestProcessor = new PostHttpRequestProcessor();
        String url = entityServiceUrl+"/program";
        Map<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("login_id", System.getProperty(userName));
        HttpResponse response = postHttpRequestProcessor.postRequestWithRequestBody(url, headerMap, request);
        objectMapper = new ObjectMapper();
        return objectMapper.readValue( response.getEntity().getContent(), CreateProgramResponse.class);
    }

    public CreateEntityResponse createEntity(Entity entity, String userName) throws IOException {
        postHttpRequestProcessor = new PostHttpRequestProcessor();
        String url = entityServiceUrl+"/entity";
        Map<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("login_id", System.getProperty(userName));
        HttpResponse response = postHttpRequestProcessor.postRequestWithRequestBody(url, headerMap, entity);
        objectMapper = new ObjectMapper();
        return objectMapper.readValue( response.getEntity().getContent(), CreateEntityResponse.class);
    }
}
