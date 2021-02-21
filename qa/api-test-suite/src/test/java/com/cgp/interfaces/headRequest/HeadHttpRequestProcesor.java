package com.cgp.interfaces.headRequest;


import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;


public class HeadHttpRequestProcesor {

    public HttpResponse executeHeadRequests(String requestUrl) throws IOException {
        HttpClient client = HttpClients.custom().build();
        HttpUriRequest request = RequestBuilder.head(requestUrl).build();
        HttpResponse response =  client.execute(request);
        System.out.println("Response===="+response.getStatusLine());
        return response;
    }
}
