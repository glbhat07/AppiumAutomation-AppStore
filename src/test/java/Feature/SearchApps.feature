Feature: Search apps in the app store

  Scenario Outline: validate Search Apps in appStore
    Given User is in the home page of app store
    And Navigated to search app section
    When User enters app <appName> in the search box
    Then User should see the app <appName> in the search results
    When User selects the first app from the search list
    Then User should see the app description
    And User should see the app rating
    And User should see the app screenshots
    And User should see app install button
    And User should see the app version
    And User should see the app size
    And User should see the app share button
    When user clicks on the share button
    Then User should see the share options


    Examples:
      | appName   |
      | Instagram |
      | WhatsApp  |
      | Twitter   |
      | LinkedIn  |
      | Snapchat  |
