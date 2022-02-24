Feature: Purchase Foreign Currency

  Background:
    Given the user on the login page
    And User logins with username "username" and "password"
    When the user clicks "Pay Bills" on the main page
    Given The user clicks "Purchase Foreign Currency" tab under Pay Bills tab


  Scenario: Available currencies
    Then following currencies should be available
      | Australia (dollar)    |
      | Canada (dollar)       |
      | Switzerland (franc)   |
      | China (yuan)          |
      | Denmark (krone)       |
      | Eurozone (euro)       |
      | Great Britain (pound) |
      | Hong Kong (dollar)    |
      | Japan (yen)           |
      | Mexico (peso)         |
      | Norway (krone)        |
      | New Zealand (dollar)  |
      | Sweden (krona)        |
      | Singapore (dollar)    |
      | Thailand (baht)       |
  @wip
  Scenario: Error message for not selecting currency
    When user tries to calculate cost without selecting a currency
    Then error message "Please, ensure that you have filled all the required fields with valid values." should be displayed
  @wip
  Scenario: Error message for not entering value
    When user tries to calculate cost without entering a value
    Then error message "Please, ensure that you have filled all the required fields with valid values." should be displayed