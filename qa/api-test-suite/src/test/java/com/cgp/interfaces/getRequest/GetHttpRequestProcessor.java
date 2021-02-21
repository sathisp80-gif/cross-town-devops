package com.cgp.interfaces.getRequest;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.util.Map;

public class GetHttpRequestProcessor {

    public HttpResponse executeGetRequests(String requestUrl) throws IOException {
        HttpClient client = HttpClients.custom().build();
        HttpUriRequest request = RequestBuilder.get(requestUrl).build();
        HttpResponse response =  client.execute(request);
        return response;
    }

    public HttpResponse executeGetRequests(String requestUrl, Map<String, String> headerMap ) throws IOException {
        HttpClient client = HttpClients.custom().build();
        HttpUriRequest request = RequestBuilder.get(requestUrl)
                .setHeader("login_id",headerMap.get("login_id"))
                .build();

        HttpResponse response =  client.execute(request);
        return response;
    }
}
