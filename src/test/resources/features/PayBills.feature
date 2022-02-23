
Feature: Pay Bills menu

  Background:
    Given the user on the login page
    And User logins with username "username" and "password"
    When the user clicks "Pay Bills" on the main page
    Then the "Zero - Pay Bills" title page should be displayed
  @wip
  Scenario: Payment was successfully submitted
    And The user inserts the following info
      | Payee       | Bank of America |
      | Account     | Credit Card     |
      | Amount      | 123             |
      | Date        | 2022-02-21      |
      | Description | Debt Jan 2022   |
    When The user clicks Pay button
    Then "The payment was successfully submitted." message is displayed
