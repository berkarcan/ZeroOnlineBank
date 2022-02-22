package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AccountSummaryDefs {

  @And("page should have the following {string}")
  public void pageShouldHaveTheFollowing(String account_types, List<String> expectedAccounts) {

    List<String> actualAccounts= BrowserUtils.getElementsText(new AccountSummaryPage().accounts);
    System.out.println("expectedAccounts = " + expectedAccounts);
    System.out.println("actualAccounts = " + actualAccounts);
    Assert.assertEquals("Actual is different",expectedAccounts,actualAccounts);

  }


  @And("{string} should have the column names")
  public void shouldHaveTheColumnNames(String Table_name, List<String> expectedColumns) {

    String locator="(//h2[.='"+Table_name+"']/following-sibling ::*//tr)[1]/th";

    List<WebElement> Columns = Driver.get().findElements(By.xpath(locator));

    List<String> actualColumns= BrowserUtils.getElementsText(Columns);
    System.out.println("expectedColumns = " + expectedColumns);
    System.out.println("actualColumns = " + actualColumns);
    Assert.assertEquals("Actual column name is different",expectedColumns,actualColumns);

  }

}
