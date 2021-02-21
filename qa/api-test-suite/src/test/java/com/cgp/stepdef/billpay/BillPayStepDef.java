package com.cgp.stepdef.billpay;

import com.cgp.apiClient.billPayService.BillPayService;
import com.cgp.containers.memory.BillPayContainer;
import com.cgp.containers.memory.SubEntityContainer;
import com.cgp.containers.responses.GenericResponse;
import com.cgp.containers.responses.TransactionDao;
import com.cgp.dao.TransactionDBOperations;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BillPayStepDef {

    private Map<String, BillPayContainer> billPayContainerMap = new HashMap<String, BillPayContainer>();
    private Map<String, TransactionDao> transactionDBContainerMap = new HashMap<String, TransactionDao>();

    @When("^I initiate the transfer with following details$")
    public void iInitiateTheTransferWithFollowingDetails(List<Map<String, String>> data) throws IOException {
        BillPayService billPayService = new BillPayService();

        final List<Map<String, String>> mapList = data;
        for (Map<String, String> map : mapList) {
            BillPayContainer billPayContainer = new BillPayContainer();
            GenericResponse response = billPayService.doBillPay(
                    map.get("payee").toString(),
                    new BigDecimal(map.get("amount").toString()),
                    map.get("description").replaceAll(" ", "%20")
            );

            billPayContainer.setAmount(new BigDecimal(map.get("amount").toString()));
            billPayContainer.setDescription(map.get("description"));
            billPayContainer.setErrorCode(response.getError_code());
            billPayContainer.setErrorMessage(response.getError_message());
            billPayContainer.setPayee(map.get("payee"));
            billPayContainer.setTransaction(map.get("transaction"));

            billPayContainerMap.put(map.get("transaction").toString(), billPayContainer);
        }
    }

    @Then("^I validate the following details$")
    public void iValidateTheFollowing(List<Map<String, String>> data) throws IOException {
        final List<Map<String, String>> mapList = data;
        for (Map<String, String> map : mapList) {
            Assert.assertEquals(map.get("error_code").toString(), billPayContainerMap
                    .get(map.get("transaction")).getErrorCode().toString());
            Assert.assertEquals(map.get("error_response").toString(), billPayContainerMap
            .get(map.get("transaction")).getErrorMessage());
        }
    }

    @Then("^I check the database if the transaction created with following details$")
    public void iCheckTheDatabaseIfTheTransactionCreatedWithFollowingDetails(List<Map<String, String>> data) throws IOException, SQLException, ClassNotFoundException {
        TransactionDBOperations transactionDBOperations = new TransactionDBOperations();

        final List<Map<String, String>> mapList = data;
        for (Map<String, String> map : mapList) {
            TransactionDao transactionDao = transactionDBOperations.getTransactionDetails(map.get("payee"));
            Assert.assertEquals(map.get("description"), transactionDao.getTransactionDesc());
            Assert.assertEquals(new BigDecimal(map.get("amount")), transactionDao.getTransactionAmount());
            transactionDBContainerMap.put(map.get("transaction"),transactionDao);

        }
    }




}
