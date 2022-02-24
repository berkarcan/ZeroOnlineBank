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

  @FindBy (linkText="Add New Payee")
  public WebElement addNewPayeeTab;
  @FindBy (id="np_new_payee_name")
  public WebElement payeeNameBox;
  @FindBy (id="np_new_payee_address")
  public WebElement payeeAddressBox;
  @FindBy(id="np_new_payee_account")
  public WebElement payeeAccountBox;
  @FindBy(id="np_new_payee_details")
  public  WebElement payeeDetailsBox;
  @FindBy(id="add_new_payee")
  public WebElement addButton;

  @FindBy (linkText = "Purchase Foreign Currency")
  public  WebElement currencyTab;
  @FindBy(id="pc_currency")
  public WebElement currencyDropdown;
  @FindBy(id="pc_amount")
  public WebElement amountBox;
  @FindBy(id="pc_inDollars_true")
  public WebElement DollarsTrueCheckbox;
  @FindBy(id="pc_inDollars_false")
  public WebElement DollarsFalseCheckbox;
  @FindBy (id="pc_calculate_costs")
  public WebElement CalculateCostsButton;
  @FindBy(id="purchase_cash")
  public WebElement PurchaseCashButton;

  @FindBy(id="alert_content")
  public WebElement actualMessage;

}
