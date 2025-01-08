Feature: Explore the navigation in appstore

  Scenario: Validate the system installed app section in appstore
    Given User is in the home page of app store
    When User click on the system installed app section
    Then User should see the system installed app section page
    And User should able to see the appName and version of the installed apps

  Scenario: Validate the system editorial section in appstore
    Given User is in the home page of app store
    When User click on the editorial section
    Then User should see the editorial app section page

  Scenario Outline: Validate the Store section in appstore
    Given User is in the home page of app store
    When User click on the Store section
    Then User should see the Store section page
    And User should see the login option
    When User clicks on login option
    Then User should see the login page and different login options <loginOptions>
    And User should see the Terms and conditions and privacy policy
    When User clicks on connect with email option
    Then user should see the error message for not accepting the tnC
    When User accepts the tnC
    And User clicks on connect with email option
    Then User should see the email login page
    Examples:
      | loginOptions |
      | Google        |
      | Facebook      |
      | Email         |