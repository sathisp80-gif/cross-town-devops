@001-billpay-001
Feature: Feature file to test the billpay-service

  Scenario: I do a test transfer to Jon's account
    When I initiate the transfer with following details
      | payee      | description                   | amount | transaction |
      | BL12542312 | Test transaction for 1 dollar | 1      | trx_1       |
    Then I validate the following details
      | error_code | error_response  | transaction |
      | 0          | PAYMENT_SUCCESS | trx_1       |
    Then I check the database if the transaction created with following details
      | payee      | description                   | amount | transaction |
      | BL12542312 | Test transaction for 1 dollar | 1      | trx_1       |
    Then I validate the statement if the transactions created with the following details
      | payee      | description                   | amount | transaction | error_code | error_response |
      | BL12542312 | Test transaction for 1 dollar | 1      | trx_1       | 0          | OK             |