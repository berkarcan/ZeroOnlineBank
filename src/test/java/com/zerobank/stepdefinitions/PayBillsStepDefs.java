package com.zerobank.stepdefinitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;

public class PayBillsStepDefs {
  PayBillsPage payBillsPage=new PayBillsPage();
  @Then("The user inserts the following info")
  public void the_user_inserts_the_following_info(Map<String,String> userInputs) {
    new Select(payBillsPage.Payee_dropdown).selectByVisibleText(userInputs.get("Payee"));
    new Select(payBillsPage.Account_dropdown).selectByVisibleText(userInputs.get("Account"));

    payBillsPage.AmmountBox.sendKeys(userInputs.get("Amount"));
    // Retrieve typed value
    String typedValue =  payBillsPage.AmmountBox.getAttribute("value");
    // Get the length of typed value
    int size = typedValue.length();
    if (size == 0) {
      System.out.println("Only numbers are allowed.");
    }

    payBillsPage.DateBox.sendKeys(userInputs.get("Date"));
    payBillsPage.DescriptionBox.sendKeys(userInputs.get("Description"));

  }
  @When("The user clicks Pay button")
  public void theUserClicksPayButton() {
    payBillsPage.PayButton.click();
  }

  @Then("{string} message is displayed")
  public void message_is_displayed(String expectedMessage) {
    BrowserUtils.waitForVisibility(payBillsPage.paymentMessage,5);
    String actualMessage = payBillsPage.paymentMessage.getText();
    Assert.assertEquals(expectedMessage,actualMessage);
  }


}
