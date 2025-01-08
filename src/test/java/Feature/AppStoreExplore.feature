Feature: Explore the home page of appstore

  Background:
    Given User is in the home page of app store

  Scenario Outline: Explore the apps listed in the home page of the app store
    And User can able to see the games and apps tab
    And User can able to see the navigation bar at the bottom of the page
    And User can able to see the different app sections <section>
    Then User can able to see the apps listed
    Examples:
      | section        |
      | Top Games      |
      | Trending       |

  Scenario: Validate the user navigation to games and apps section from home page
    When User clicks on the games
    Then User should navigate to the games section
    And User should see the games listed
    When User clicks on the apps
    Then User should navigate to the apps section
    And User should see the apps listed
    When User deselects the apps
    Then User should navigate back to the home page

  Scenario Outline: Validate the user navigation to trending game section from home page
    And User can able to see the different app sections <section>
    When User clicks on more on trending
    Then User should able to see trending apps and games section
    When User clicks on trending games section
    Then User should able to see the list of top trending games
    And User should able to see the list of <gameSections> in trending games
    When User selects board game section
    Then User should able to see the list of board games <boardGames>
    Examples:
      | section | gameSections                 | boardGames |
      | Trending | Board,Educational,Word | Ludo,Tic Tac Toe |

  Scenario Outline: Validate the user navigation to trending apps section from home page
    And User can able to see the different app sections <section>
    When User clicks on more on trending
    Then User should able to see trending apps and games section
    When User clicks on trending apps section
    Then User should able to see the list of top trending apps
    And User should able to see the list of <appSections> in trending apps
    When User selects medical app section
    Then User should able to see the list of fitness related apps <fitnessApps>
    Examples:
      | section  | appSections                           | fitnessApps                       |
      | Trending | Photography,Maps & Navigation,Medical | HelloBetter,Skin Scanner,Vet Alfa |
