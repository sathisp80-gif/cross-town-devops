package com.cgp.apiClient.cardService;

import com.cgp.containers.responses.CreateProfileResponse;
import com.cgp.interfaces.postRequest.PostHttpRequestProcessor;
import com.cgp.interfaces.putRequest.PutHttpRequestProcessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import gherkin.deps.com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CardWriteClientService {
    PostHttpRequestProcessor postHttpRequestProcessor;

    String cardServiceUrl = System.getProperty("cardwrite.service.url");

    public int writeCard(String cardClientCode, String vendorAccountCode, String userName ) throws IOException{
        postHttpRequestProcessor = new PostHttpRequestProcessor();
        String url = cardServiceUrl+"/writecard?card_client_code="+cardClientCode+"&vendor_account_code="+vendorAccountCode;
        Map<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("login_id", System.getProperty(userName));
        HttpResponse response = postHttpRequestProcessor.postRequestWithParam(url, headerMap);
        return response.getStatusLine().getStatusCode();

    }
}
