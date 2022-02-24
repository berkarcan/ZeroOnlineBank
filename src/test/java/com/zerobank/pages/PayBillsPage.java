package com.zerobank.pages;

import java.util.regex.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PayBillsPage extends BasePage{

  @FindBy(id="sp_payee")
  public WebElement Payee_dropdown;

  @FindBy(id="sp_account")
  public WebElement Account_dropdown;

  @FindBy(id="sp_amount")
   public WebElement AmmountBox;

  @FindBy(id="sp_date")
  public WebElement DateBox;

  @FindBy(id="sp_description")
  public WebElement DescriptionBox;

  @FindBy(id="alert_content")
  public WebElement paymentMessage;

  @FindBy (xpath="//*[@type='submit']")
  public  WebElement PayButton;

  public Boolean IsPositiveNumber(String input){
    String regex = "^(?:[1-9]\\d*|0)?(?:\\.\\d+)?$";
    return input.matches(regex);
  }

  public Boolean IsNonAlphabetic(String input){
    String regex = "[^a-z]|[^A-Z]";
    return !input.matches(regex);
  }






}
