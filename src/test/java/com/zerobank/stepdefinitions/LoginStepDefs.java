package com.zerobank.stepdefinitions;


import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class LoginStepDefs {
  LoginPage loginPage=new LoginPage();

  @Given("User logins with username {string} and {string}")
  public void user_logins_with_username_and(String userName, String password) {
    loginPage.login(userName,password);
    Driver.get().navigate().to("http://zero.webappsecurity.com/bank/account-summary.html");
    BrowserUtils.waitFor(1);

  }
  @Then("the {string} title page should be displayed")
  public void theTitlePageShouldBeDisplayed(String expectedTitle) {

    Assert.assertEquals("Title is different",expectedTitle,Driver.get().getTitle());

  }



}
