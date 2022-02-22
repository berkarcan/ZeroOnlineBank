package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FindTransactionsPAge extends BasePage{

  @FindBy(xpath = "//*[@id='ui-tabs-2']/h2")
  public WebElement findTransactionsTitle;

  @FindBy (id="aa_description")
  public WebElement description_box;

  @FindBy(id="aa_fromDate")
  public WebElement fromDate_box;

  @FindBy(id="aa_toDate")
  public WebElement toDate_box;

  @FindBy(id="aa_fromAmount")
  public WebElement fromAmount_box;

  @FindBy(id="aa_toAmount")
  public WebElement aa_toAmount_box;

  @FindBy(id="aa_type")
  public WebElement type_dropdown;

  @FindBy(xpath = "//*[@type='submit']")
  public WebElement Find_button;

  @FindBy(xpath = "(//*[@id='filtered_transactions_for_account']//tbody/tr)/td[1]")
  public List<WebElement> DateColumns;
  @FindBy(xpath = "(//*[@id='filtered_transactions_for_account']//tbody/tr)/td[2]")
  public List<WebElement> DescriptionColumns;
  @FindBy(xpath = "(//*[@id='filtered_transactions_for_account']//tbody/tr)/td[3]")
  public List<WebElement> DepositColumns;
  @FindBy(xpath = "(//*[@id='filtered_transactions_for_account']//tbody/tr)/td[4]")
  public List<WebElement> WithdrawalColumns;
}
