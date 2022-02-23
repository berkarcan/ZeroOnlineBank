package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccountActivityPage extends BasePage{

  @FindBy(id="aa_accountId")
  public WebElement dropdownElement;

  @FindBy(linkText = "Find Transactions")
  public WebElement findTransactionsTab;

  @FindBy(xpath = "//*[@id='all_transactions_for_account']//th")
  public List<WebElement> columnNames;


}
