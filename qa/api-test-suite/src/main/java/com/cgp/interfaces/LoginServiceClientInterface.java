package com.cgp.interfaces;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="login-service", url = "http://127.0.0.1:50602/")
//@FeignClient(name="user-service")
public interface LoginServiceClientInterface {
    @RequestMapping(method = RequestMethod.HEAD, value = "/login")
    ResponseEntity<String> validateLogin(@RequestParam(name = "login_id") Integer loginId);
}
