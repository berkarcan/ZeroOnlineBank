package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.FindTransactionsPAge;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Collections;
import java.util.List;

import static com.zerobank.utilities.BrowserUtils.waitForVisibility;

public class FindTransactionsStepDefs {

  FindTransactionsPAge findTransactionsPAge=new FindTransactionsPAge();

  @Given("the user accesses the {string} tab")
  public void theUserAccessesTheTab(String expectedTitle) {
    new AccountActivityPage().findTransactionsTab.click();
  }

  @When("the user enters date range from {string} to {string}")
  public void the_user_enters_date_range_from_to(String fromDate, String toDate) {
    waitForVisibility(findTransactionsPAge.fromDate_box, 5);
    findTransactionsPAge.fromDate_box.sendKeys(fromDate);
    findTransactionsPAge.toDate_box.sendKeys(toDate);
  }
  @When("clicks Find")
  public void clicks_Find() {
    findTransactionsPAge.Find_button.click();
    BrowserUtils.waitFor(1);
    findTransactionsPAge.fromDate_box.clear();
    findTransactionsPAge.toDate_box.clear();
    findTransactionsPAge.description_box.clear();
  }
  @Then("results table should only show transactions dates between {string} to  {string}")
  public void results_table_should_only_show_transactions_dates_between_to(String fromDate, String toDate) {
    List<String> cells = BrowserUtils.getElementsText(findTransactionsPAge.DateColumns);
    for (String cell : cells) {
      Assert.assertTrue("Date are not in the defined range",cell.compareTo(fromDate)>=0 && cell.compareTo(toDate)<=0);
    }

  }
  @Then("the results should be sorted by most recent date")
  public void the_results_should_be_sorted_by_most_recent_date() {
    List<String> actualCells = BrowserUtils.getElementsText(findTransactionsPAge.DateColumns);

    List<String>  ExpectedSortedByRecent= BrowserUtils.getElementsText(findTransactionsPAge.DateColumns);
    Collections.sort(ExpectedSortedByRecent, Collections.reverseOrder());

    Assert.assertEquals("Actual data sorted by most recent data",ExpectedSortedByRecent,actualCells);
  }


  @Then("the results table should only not contain transactions dated {string}")
  public void the_results_table_should_only_not_contain_transactions_dated(String OutDate) {
    List<String>  Cells = BrowserUtils.getElementsText(findTransactionsPAge.DateColumns);
    for (String cell : Cells) {
      Assert.assertFalse(OutDate+"data is among the transactions",cell.equals(OutDate));
    }

  }


  @When("the user enters description {string}")
  public void theUserEntersDescription(String arg0) {
    BrowserUtils.waitForVisibility(findTransactionsPAge.description_box, 5);
    findTransactionsPAge.description_box.sendKeys(arg0);
  }


  @Then("results table should only show descriptions containing {string}")
  public void resultsTableShouldOnlyShowDescriptionsContaining(String arg0) {
    List<String>  Cells = BrowserUtils.getElementsText(findTransactionsPAge.DescriptionColumns);
    for (String cell : Cells) {
      Assert.assertTrue(cell.contains(arg0));
    }

  }

  @But("results table should not show descriptions containing {string}")
  public void resultsTableShouldNotShowDescriptionsContaining(String arg0) {
    List<String>  Cells = BrowserUtils.getElementsText(findTransactionsPAge.DescriptionColumns);
    for (String cell : Cells) {
      Assert.assertFalse(cell.contains(arg0));
    }
  }
}
