package com.zerobank.stepdefinitions;

import com.zerobank.pages.PayBillsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.Map;

public class newPayeeStepDefs {
  PayBillsPage payBillsPage=new PayBillsPage();
  @Given("The user clicks {string} tab under Pay Bills tab")
  public void the_user_clicks_tab_under_Pay_Bills_tab(String tabName) {
    switch(tabName){
      case "Add New Payee":
        payBillsPage.addNewPayeeTab.click();
        break;
      case "Purchase Foreign Currency":
        payBillsPage.currencyTab.click();
        break;
    }
  }

  @Given("creates new payee using following information")
  public void creates_new_payee_using_following_information(Map<String,String> info) {
    payBillsPage.payeeNameBox.sendKeys(info.get("Payee Name"));
    payBillsPage.payeeAddressBox.sendKeys(info.get("Payee Address"));
    payBillsPage.payeeAccountBox.sendKeys(info.get("Account"));
    payBillsPage.payeeDetailsBox.sendKeys(info.get("Payee details"));
    payBillsPage.addButton.click();

  }
  @Then("message {string} should be displayed")
  public void message_should_be_displayed(String expectedMessage) {
    Assert.assertEquals(expectedMessage,payBillsPage.actualMessage.getText());
  }

}
