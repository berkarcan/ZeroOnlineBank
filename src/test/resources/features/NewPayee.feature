Feature: Add new payee under pay bills

  Background:
    Given User logins with username "username" and "password"
    When the user clicks "Pay Bills" on the main page
    Given The user clicks "Add New Payee" tab under Pay Bills tab


  Scenario: Add a new payee
    Given The user clicks "Add New Payee" tab under Pay Bills tab
    And creates new payee using following information
      | Payee Name    | The Law Offices of Hyde, Price & Scharks |
      | Payee Address | 100 Same st, Anytown, USA, 10001         |
      | Account       | Checking                                 |
      | Payee details | XYZ account                              |
    Then message "The new payee The Law Offices of Hyde, Price & Scharks was successfully created." should be displayed