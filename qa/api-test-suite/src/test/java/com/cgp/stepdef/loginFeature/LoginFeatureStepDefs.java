package com.cgp.stepdef.loginFeature;

import com.cgp.apiClient.loginService.LoginClientService;

import com.cgp.containers.memory.LoginContainer;
import com.cgp.containers.requests.RegisterUserRequest;
import com.cgp.containers.responses.LoginResponse;
import com.cgp.containers.responses.RegisterUserResponse;
import com.cgp.dao.LoginDatabaseOperations;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoginFeatureStepDefs {

    LoginClientService loginClientService;
    LoginDatabaseOperations loginDatabaseOperations;
    private Map<String, LoginContainer> loginContainerMap = new HashMap<String, LoginContainer>();


    @When("^I register a new admin user with the following details$")
    public void iRegisterANewAdminUserWithTheFollowingDetails(List<Map<String, String>> data) throws IOException {
        final List<Map<String, String>> mapList = data;
        loginClientService = new LoginClientService();
        LoginContainer loginContainer = new LoginContainer();
        for (Map<String, String> map : mapList) {
            RegisterUserRequest request = RegisterUserRequest.builder()
                    .first_name(map.get("first_name"))
                    .last_name(map.get("last_name"))
                    .address_1(map.get("address_1"))
                    .address_2(map.get("address_2"))
                    .city(map.get("city"))
                    .country(map.get("country"))
                    .date_of_birth(map.get("date_of_birth"))
                    .contact_type(map.get("contact_type"))
                    .email(map.get("email"))
                    .password(map.get("password"))
                    .mobile(map.get("mobile"))
                    .build();
            RegisterUserResponse response = loginClientService
                    .registerLogin(request, map.get("adminLogin"), map.get("adminPass"));
            Assert.assertEquals(0, response.getResponseCode());
            loginContainer = LoginContainer.builder()
                    .loginId(response.getLoginId())
                    .loginEmail(map.get("email"))
                    .loginPass(map.get("password"))
                    .designation(map.get("contact_type"))
                    .firstName(map.get("first_name"))
                    .lastName(map.get("last_name"))
                    .build();
            loginContainerMap.put(map.get("login"), loginContainer);
        }
    }


    @Then("^I delete the users$")
    public void iDeleteTheUsers(List<Map<String, String>> data) throws SQLException, ClassNotFoundException {
        loginDatabaseOperations = new LoginDatabaseOperations();
        final List<Map<String, String>> mapList = data;
        for (Map<String, String> map : mapList) {
            Assert.assertTrue(loginDatabaseOperations.deleteUser(loginContainerMap.get(map.get("login")).getLoginId()));
        }

    }

    @Then("^I check if the login exists$")
    public void iCheckIfTheLoginExists(List<Map<String, String>> data) throws IOException {
        loginClientService = new LoginClientService();
        final List<Map<String, String>> mapList = data;
        for (Map<String, String> map : mapList) {
            Assert.assertEquals("200", loginClientService.validateLogin(loginContainerMap.get(map.get("login")).getLoginId()).toString());
        }

    }

    @Then("^I check if able to login$")
    public void iCheckIfAbleToLogin(List<Map<String, String>> data) throws IOException {
        loginClientService = new LoginClientService();
        final List<Map<String, String>> mapList = data;
        for (Map<String, String> map : mapList) {
            LoginResponse response = loginClientService.loginUser(loginContainerMap.get(map.get("login")).getLoginEmail(),
                    loginContainerMap.get(map.get("login")).getLoginPass());
            Assert.assertEquals(loginContainerMap.get(map.get("login")).getFirstName(), response.getFirstName());
            Assert.assertEquals(loginContainerMap.get(map.get("login")).getLastName(), response.getLastName());
            Assert.assertEquals(loginContainerMap.get(map.get("login")).getDesignation(), response.getDesignation());
            Assert.assertEquals(loginContainerMap.get(map.get("login")).getLoginId().toString(), String.valueOf(response.getLoginId()));
        }

    }
}
