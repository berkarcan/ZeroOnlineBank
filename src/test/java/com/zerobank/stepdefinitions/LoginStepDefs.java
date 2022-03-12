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
  @Given("the user on the login page")
  public void the_user_on_the_login_page() {
    loginPage.signInButton.click();
  }


  @Given("User logins with username {string} and {string}")
  public void user_logins_with_username_and(String userName, String password) {
    loginPage.loginBox.sendKeys(userName);
    loginPage.passwordBox.sendKeys(password);
    loginPage.submit_button.click();
    Driver.get().navigate().to("http://zero.webappsecurity.com/bank/account-summary.html");
    BrowserUtils.waitFor(2);
  }
  @Then("the {string} title page should be displayed")
  public void theTitlePageShouldBeDisplayed(String expectedTitle) {

    Assert.assertEquals("Title is different",expectedTitle,Driver.get().getTitle());

  }



}
