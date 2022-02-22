package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.BasePage;
import com.zerobank.pages.FindTransactionsPAge;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_old.Ac;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static com.zerobank.utilities.BrowserUtils.waitFor;
import static com.zerobank.utilities.BrowserUtils.waitForVisibility;

public class AccountActivityStepDefs extends BasePage {

  @When("the user clicks {string} on the main page")
  public void the_user_clicks_on_the_main_page(String page) {
    Driver.get().findElement(By.linkText(page)).click();
  }
  public static String actualAccountOption;
  @When("the user clicks on {string} dropdown link on the Account Activity page")
  public void the_user_clicks_on_dropdown_link_on_the_Account_Activity_page(String account) {
    Select Dropdown=new Select(new AccountActivityPage().dropdownElement);
    Dropdown.selectByVisibleText(account);
    actualAccountOption=Dropdown.getFirstSelectedOption().getText();
  }
  @Then("Account dropdown should have {string}  selected")
  public void account_dropdown_should_have_selected(String expectedAccountOption) {
    System.out.println("expectedAccountOption = " + expectedAccountOption);
    System.out.println("actualAccountOption = " + actualAccountOption);
    Assert.assertEquals("Actual option is different than expected",expectedAccountOption,actualAccountOption);
  }




}
