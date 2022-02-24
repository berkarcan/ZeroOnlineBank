package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;


public abstract class BasePage {
  public BasePage(){
    PageFactory.initElements(Driver.get(), this);
  }

  public void navigateTo(String tab) {

    String tabLocator = "//a[.='" +tab + "']";
    BrowserUtils.waitForClickability(By.xpath(tabLocator), 5);
    Driver.get().findElement(By.xpath(tabLocator)).click();

  }

  /* not used methods for further use incase of need
  public Boolean IsPositiveNumber(String input){
    String regex = "^(?:[1-9]\\d*|0)?(?:\\.\\d+)?$";
    return input.matches(regex);
  }
  public Boolean IsNonAlphabetic(String input){
    String regex = "[^a-z]|[^A-Z]";
    return !input.matches(regex);
  }
  */

}
