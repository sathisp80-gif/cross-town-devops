package com.cgp.stepdef.configuation;

import com.cgp.apiClient.accountService.AccountClientService;
import com.cgp.apiClient.loginService.LoginClientService;
import com.cgp.containers.memory.EntityContainer;
import com.cgp.containers.memory.Program;
import com.cgp.containers.requests.Address;
import com.cgp.containers.requests.Entity;
import com.cgp.containers.requests.Phone;
import com.cgp.containers.responses.CreateEntityResponse;
import com.cgp.containers.responses.CreateProgramResponse;
import com.cgp.dao.AccountDatabaseOperations;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.junit.Assert;
import org.omg.CORBA.Environment;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ConfigurationStepDef {


}
