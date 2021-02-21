package com.cgp.apiClient.loginService;

import com.cgp.containers.requests.RegisterUserRequest;
import com.cgp.containers.responses.CreateEntityResponse;
import com.cgp.containers.responses.LoginResponse;
import com.cgp.containers.responses.RegisterUserResponse;
import com.cgp.interfaces.getRequest.GetHttpRequestProcessor;
import com.cgp.interfaces.headRequest.HeadHttpRequestProcesor;
import com.cgp.interfaces.postRequest.PostHttpRequestProcessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LoginClientService {

    PostHttpRequestProcessor postHttpRequestProcessor;
    GetHttpRequestProcessor getHttpRequestProcessor;
    ObjectMapper objectMapper;


    String loginServiceUrl =  System.getProperty("user.service.url");

    public Integer validateLogin(String user) throws IOException {
        HeadHttpRequestProcesor httpClient = new HeadHttpRequestProcesor();
        String url = loginServiceUrl + "/login?login_id="+System.getProperty(user);
        return httpClient.executeHeadRequests(url).getStatusLine().getStatusCode();
    }

    public Integer validateLogin(Long userId) throws IOException {
        HeadHttpRequestProcesor httpClient = new HeadHttpRequestProcesor();
        String url = loginServiceUrl + "/login?login_id="+userId;
        return httpClient.executeHeadRequests(url).getStatusLine().getStatusCode();
    }

    public LoginResponse loginUser(String loginEmail, String loginPass) throws IOException {
        getHttpRequestProcessor = new GetHttpRequestProcessor();
        String url = loginServiceUrl+"/login?email="+loginEmail+"&password="+loginPass;
        HttpResponse response = getHttpRequestProcessor.executeGetRequests(url);
        objectMapper = new ObjectMapper();
        return objectMapper.readValue( response.getEntity().getContent(), LoginResponse.class);
    }

    public RegisterUserResponse registerLogin(RegisterUserRequest registerUserRequest, String adminLogin, String adminPass) throws IOException {
        postHttpRequestProcessor = new PostHttpRequestProcessor();
        String url = loginServiceUrl+"/login";
        Map<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("user-name", System.getProperty(adminLogin));
        headerMap.put("pass-key", System.getProperty(adminPass));
        HttpResponse response = postHttpRequestProcessor.postRequestWithLoginRequestBody(url, headerMap, registerUserRequest);
        objectMapper = new ObjectMapper();
        return objectMapper.readValue( response.getEntity().getContent(), RegisterUserResponse.class);

    }
}
