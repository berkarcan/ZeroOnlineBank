package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.BasePage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class AccountActivityStepDefs extends BasePage {
  AccountActivityPage accountActivityPage=new AccountActivityPage();
  @When("the user clicks {string} on the main page")
  public void the_user_clicks_on_the_main_page(String page) {
    Driver.get().findElement(By.linkText(page)).click();
  }
  public static String actualAccountOption;
  @When("the user clicks on {string} dropdown link on the Account Activity page")
  public void the_user_clicks_on_dropdown_link_on_the_Account_Activity_page(String account) {
    Select Dropdown=new Select(accountActivityPage.dropdownElement);
    Dropdown.selectByVisibleText(account);
    actualAccountOption=Dropdown.getFirstSelectedOption().getText();
  }
  @Then("Account dropdown should have {string}  selected")
  public void account_dropdown_should_have_selected(String expectedAccountOption) {
    System.out.println("expectedAccountOption = " + expectedAccountOption);
    System.out.println("actualAccountOption = " + actualAccountOption);
    Assert.assertEquals("Actual option is different than expected",expectedAccountOption,actualAccountOption);
  }

  @Then("Transactions table should have column names")
  public void transactions_table_should_have_column_names(List<String> expectedColumns) {
    System.out.println("expectedColumuns = " + expectedColumns);
    BrowserUtils.waitFor(2);
    List<String> actualColumns= BrowserUtils.getElementsText(accountActivityPage.columnNames);
    System.out.println("actualColumns = " + actualColumns);
    Assert.assertEquals("Actual columns are different that expected",expectedColumns,actualColumns);

  }



}
