package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

  @FindBy(id = "signin_button")
  public WebElement signInButton;

  @FindBy(id = "user_login")
  public WebElement loginBox;

  @FindBy(id = "user_password")
  public WebElement passwordBox;

  @FindBy(xpath = "//input[@name='submit']")
  public WebElement submit_button;

  public void login(){

  }

}
