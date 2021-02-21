package com.cgp.service;

import com.cgp.interfaces.LoginServiceClientInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.xml.ws.Response;

@Service
public class ApiCallService {
    @Autowired
    private LoginServiceClientInterface loginServiceClientInterface;

    public ResponseEntity<String> validateLogin(Integer loginId){
        return loginServiceClientInterface.validateLogin(loginId);
    }
}
