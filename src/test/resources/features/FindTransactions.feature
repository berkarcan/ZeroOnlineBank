@wip
Feature: Find Transactions in Account Activity

  Background:
    Given the user on the login page
    And User logins with username "username" and "password"
    When the user clicks "Account Activity" on the main page
    Then the "Zero - Account Activity" title page should be displayed
    Given the user accesses the "Find Transactions" tab

  Scenario: Search date range
    When the user enters date range from "2012-09-01" to "2012-09-06"
    And clicks Find
    Then results table should only show transactions dates between "2012-09-01" to  "2012-09-06"
    And the results should be sorted by most recent date
    When the user enters date range from "2012-09-02" to "2012-09-06"
    And clicks Find
    Then results table should only show transactions dates between "2012-09-02" to  "2012-09-06"
    And the results table should only not contain transactions dated "2012-09-01"


  Scenario: Search description
    When the user enters description "ONLINE"
    And clicks Find
    Then results table should only show descriptions containing "ONLINE"
    When the user enters description "OFFICE"
    And clicks Find
    Then results table should only show descriptions containing "OFFICE"
    But results table should not show descriptions containing "ONLINE"


  Scenario: Search description case insensitive
    When the user enters description "ONLINE"
    And clicks Find
    Then results table should only show descriptions containing "ONLINE"
    When the user enters description "online"
    And clicks Find
    Then results table should only show descriptions containing "ONLINE"

  Scenario Outline: Type
    When user selects type "<Type>"
    And clicks Find
    Then results table should show at least one result under "<Type>"
    But results table should show no result under "<OtherType>"
    Examples:
      | Type       | OtherType  |
      | Deposit    | Withdrawal |
      | Withdrawal | Deposit    |



