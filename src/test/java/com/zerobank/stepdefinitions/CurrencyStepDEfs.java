package com.zerobank.stepdefinitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CurrencyStepDEfs {
  PayBillsPage payBillsPage=new PayBillsPage();
  @Then("following currencies should be available")
  public void following_currencies_should_be_available(List<String> expectedCurrencies) {
   Select currencySelect=new Select(payBillsPage.currencyDropdown);
   
    List<String> actualCurrencies=BrowserUtils.getElementsText(currencySelect.getOptions());
    actualCurrencies.remove(0);
    System.out.println("actualCurrencies = " + actualCurrencies);
    Assert.assertEquals(expectedCurrencies,actualCurrencies);
  }
  @When("user tries to calculate cost without selecting a currency")
  public void user_tries_to_calculate_cost_without_selecting_a_currency() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
  }

  @When("user tries to calculate cost without entering a value")
  public void user_tries_to_calculate_cost_without_entering_a_value() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
  }
  @Then("error message {string} should be displayed")
  public void error_message_should_be_displayed(String string) {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
  }
}
