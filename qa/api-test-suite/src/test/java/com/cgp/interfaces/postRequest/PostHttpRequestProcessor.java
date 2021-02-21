package com.cgp.interfaces.postRequest;

import gherkin.deps.com.google.gson.Gson;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;

import java.io.IOException;
import java.util.Map;


public class PostHttpRequestProcessor {

    public HttpResponse postRequestWithParam(String requestUrl, Map<String, String> headerMap ) throws IOException {
        HttpClient client = HttpClients.custom().build();
        HttpUriRequest request = RequestBuilder.post()
                .setHeader("login_id",headerMap.get("login_id"))
                .setUri(requestUrl)
                .build();
        return client.execute(request);
    }

    public HttpResponse executeGetRequests(String requestUrl) throws IOException {
        HttpClient client = HttpClients.custom().build();
        HttpUriRequest request = RequestBuilder.post(requestUrl).build();
        HttpResponse response =  client.execute(request);
        return response;
    }

    public HttpResponse postRequestWithRequestBody(String requestUrl,
                                                   Map<String, String> headerMap ,
                                                   Object obj) throws IOException {
        HttpClient client = HttpClients.custom().build();
        Gson gson = new Gson();
        System.out.println(gson.toJson(obj));
        StringEntity postingString = new StringEntity(gson.toJson(obj));

        HttpUriRequest request = RequestBuilder.post()
                .setHeader("login_id",headerMap.get("login_id"))
                .setHeader("Content-type", "application/json")
                .setEntity(postingString)
                .setUri(requestUrl)
                .build();
        System.out.println(requestUrl.toString());
        return client.execute(request);
    }

//    public HttpResponse postRequestWithRequestBodyWithoutHeader(String requestUrl,
//                                                   Object obj) throws IOException {
//        HttpClient client = HttpClients.custom().build();
//        Gson gson = new Gson();
//        System.out.println(gson.toJson(obj));
//        StringEntity postingString = new StringEntity(gson.toJson(obj));
//
//        HttpUriRequest request = RequestBuilder.post()
//                .setHeader("Content-type", "application/json")
//                .setEntity(postingString)
//                .setUri(requestUrl)
//                .build();
//        System.out.println(requestUrl.toString());
//        return client.execute(request);
//    }

    public HttpResponse postRequestWithLoginRequestBody(String requestUrl,
                                                   Map<String, String> headerMap ,
                                                   Object obj) throws IOException {
        HttpClient client = HttpClients.custom().build();
        Gson gson = new Gson();
//        HttpEntity entity = new StringEntity(obj.toString(), ContentType.APPLICATION_JSON);
        StringEntity postingString = new StringEntity(gson.toJson(obj));

        HttpUriRequest request = RequestBuilder.post()
                .setHeader("user-name",headerMap.get("user-name"))
                .setHeader("pass-key",headerMap.get("pass-key"))
                .setHeader("Content-type", "application/json")
                .setEntity(postingString)
                .setUri(requestUrl)
                .build();
        System.out.println(requestUrl.toString());
        return client.execute(request);
    }

//    public HttpResponse postRequestWithRequestPqrqm(String requestUrl,
//                                                    Map<String, String> headerMap ,
//                                                    List<> paramLit)

}
