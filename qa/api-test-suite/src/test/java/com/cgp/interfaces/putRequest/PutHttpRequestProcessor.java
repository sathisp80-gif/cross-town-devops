package com.cgp.interfaces.putRequest;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.util.Map;

public class PutHttpRequestProcessor {

    public HttpResponse putRequestWithParam(String requestUrl, Map<String, String> headerMap ) throws IOException {
        HttpClient client = HttpClients.custom().build();
        HttpUriRequest request = RequestBuilder.put()
                .setHeader("login_id",headerMap.get("login_id"))
                .setUri(requestUrl)
                .build();
        return client.execute(request);
    }
}
