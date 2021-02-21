package com.cgp.runner;


import cucumber.api.CucumberOptions;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty","html:target/cucumber-pretty","json:target/cucumber/cucumber.json"}, strict = false,
        features = "src/test/resources/billpay",glue = {"com.cgp.stepdef.billpay"},

        tags = {"@001-billpay-001"}

)

public class RunCucumberTest {

}
