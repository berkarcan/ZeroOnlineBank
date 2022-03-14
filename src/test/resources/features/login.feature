Feature: Online Banking Login Feature

  Scenario: Authorized users should be able to login to the application
    Given User logins with username "username" and "password"
    Then the "Zero - Account Summary" title page should be displayed
