Feature: HomePage
  Scenario: Launch dubdub
    Given I launch dubdub
    When I look at the screen
    Then there should be a createeeeee button
    And there should be a watch button
    And tabbar has 49 buttons
    And home button is highlighted


