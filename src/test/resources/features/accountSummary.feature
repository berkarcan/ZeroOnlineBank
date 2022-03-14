
Feature: Account summary
  Background:
    Given  User logins with username "username" and "password"
    Then the "Zero - Account Summary" title page should be displayed

  Scenario: Account types and account columns
    And page should have the following "account types"
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |
    And "Credit Accounts" should have the column names
      | Account     |
      | Credit Card |
      | Balance     |