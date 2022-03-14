package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
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

  @FindBy(css = "button[id='details-button']")
  public WebElement advancedButton;

  @FindBy(css = "a[id='proceed-link']")
  public WebElement proceedLink;

  @FindBy(css = "div.alert.alert-error")
  public WebElement errorMessage;

  public void login(){
    signInButton.click();
    loginBox.sendKeys(ConfigurationReader.get("username"));
    passwordBox.sendKeys(ConfigurationReader.get("password"));
    submit_button.click();
    advancedButton.click();
    proceedLink.click();
    BrowserUtils.waitFor(2);
  }

  public void login(String username,String password){
    signInButton.click();
    loginBox.sendKeys(username);
    passwordBox.sendKeys(password);
    submit_button.click();
    if(username.equals(ConfigurationReader.get("username")) && password.equals(ConfigurationReader.get("password"))){
      advancedButton.click();
      proceedLink.click();
    }
  }

}
