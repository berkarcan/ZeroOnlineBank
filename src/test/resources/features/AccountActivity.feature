
Feature: Navigating to specific accounts in Accounts Activity

  Background:
    Given the user on the login page
    And User logins with username "username" and "password"
    When the user clicks "Account Activity" on the main page
    Then the "Zero - Account Activity" title page should be displayed

  Scenario:Transactions column names
    And Transactions table should have column names
      | Date        |
      | Description |
      | Deposit     |
      | Withdrawal  |

  Scenario Outline: "<Accounts>" account redirect
    When the user clicks on "<Accounts>" dropdown link on the Account Activity page
    Then Account dropdown should have "<Accounts>"  selected
    Examples:
      | Accounts    |
      | Savings     |
      | Brokerage   |
      | Checking    |
      | Credit Card |
      | Loan        |


