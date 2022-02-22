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


}
