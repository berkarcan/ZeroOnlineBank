package com.zerobank.stepdefinitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CurrencyStepDEfs {
  PayBillsPage payBillsPage=new PayBillsPage();
  @Then("following currencies should be available")
  public void following_currencies_should_be_available(List<String> expectedCurrencies) {
   Select currencySelect=new Select(payBillsPage.currencyDropdown);
   
    List<String> actualCurrencies=BrowserUtils.getElementsText(currencySelect.getOptions());
    System.out.println("actualCurrencies = " + actualCurrencies);
    Assert.assertTrue(actualCurrencies.containsAll(expectedCurrencies));
  }

   @When("user tries to calculate cost without selecting a currency")
  public void user_tries_to_calculate_cost_without_selecting_a_currency() {
    payBillsPage.amountBox.sendKeys("25");
    payBillsPage.CalculateCostsButton.click();

  }

  @When("user tries to calculate cost without entering a value and selecting {string} currency")
  public void user_tries_to_calculate_cost_without_entering_a_value_and_selecting_currency(String currency) {
    if (currency=="U.S. dollar (USD)"){
      payBillsPage.DollarsTrueCheckbox.click();
    }else{
      new Select(payBillsPage.currencyDropdown).selectByVisibleText(currency);
      payBillsPage.DollarsFalseCheckbox.click();
    }
    payBillsPage.CalculateCostsButton.click();
  }
  @Then("error message {string} should be displayed")
  public void error_message_should_be_displayed(String expectedMessage) {
    Alert alert= Driver.get().switchTo().alert();
    new WebDriverWait(Driver.get(),10).until(ExpectedConditions.alertIsPresent());
    String actualMessage = alert.getText();
    System.out.println("actualMessage = " + actualMessage);
    System.out.println("expectedMessage = " + expectedMessage);
    Assert.assertEquals(expectedMessage,actualMessage);
  }
}
