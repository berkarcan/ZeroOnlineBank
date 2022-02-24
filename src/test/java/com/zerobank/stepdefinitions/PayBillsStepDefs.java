package com.zerobank.stepdefinitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;

public class PayBillsStepDefs {
  PayBillsPage payBillsPage = new PayBillsPage();

  @Then("The user inserts the following info")
  public void the_user_inserts_the_following_info(Map<String, String> userInputs) {

    try {
      new Select(payBillsPage.Payee_dropdown).selectByVisibleText(userInputs.get("Payee"));
      new Select(payBillsPage.Account_dropdown).selectByVisibleText(userInputs.get("Account"));

      payBillsPage.AmmountBox.sendKeys(userInputs.get("Amount"));
      payBillsPage.DateBox.sendKeys(userInputs.get("Date"));
    }catch(Exception e){
      System.out.println("Please fill out Amount as +number and date as non-alphabetical");
    }
    payBillsPage.DescriptionBox.sendKeys(userInputs.get("Description"));
  }

  @When("The user clicks Pay button")
  public void theUserClicksPayButton() {
    payBillsPage.PayButton.click();
  }

  @Then("{string} message is displayed")
  public void message_is_displayed(String expectedMessage) {

    if (expectedMessage.equals("The payment was successfully submitted.")) {
      BrowserUtils.waitForVisibility(payBillsPage.paymentMessage, 5);
      String actualMessage = payBillsPage.paymentMessage.getText();
      Assert.assertEquals(expectedMessage, actualMessage);
    } else if (expectedMessage.equals("Please fill out this field message!")) {
      String actualMessage = payBillsPage.DateBox.getAttribute("validationMessage");
      Assert.assertEquals(expectedMessage, actualMessage);
    }
  }


  @Then("{string} message should not displayed")
  public void messageShouldNotDisplayed(String unExpectedMessage) {
    Assert.assertNotEquals(unExpectedMessage, payBillsPage.paymentMessage.getText());
  }

  @Then("Date cannot be inserted as alphabetic")
  public void dateCannotBeInsertedAsNonAlphabetic() {
    if(payBillsPage.DateBox.getAttribute("Value")!=null){
      Assert.fail("Date cannot be inserted as alphabetic");
    }

  }


}
