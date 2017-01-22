Feature: DubSuite
  Scenario: Mixing with Video
    Given I import a video to a track
    When I press and hold to mix a segment
    Then the video segment gets committed to the mix

  Scenario: Mixing with Image
    Given I import an image to a track
    When I press and hold to mix a segment
    Then the image segment gets committed to the mix

  Scenario: Mixing with Text
    Given I Import text to a track
    When I press and hold to mix a segment
    Then the text segment gets committed to the mix

   Scenario: Mixing with dubsound
     Given I import dubsound to a track
     When I press and hold to mix a segment
     Then the dubsound segment gets committed to the mix

  Scenario: Mixing Video and Dubsound
    Given I import a video to a track
    And I import dubsound to the second track
    When I press and hold to mix a segment
    Then it will mix for 5 seconds sucessfully

  Scenario: Mixing Video and Text
    Given I import a video to a track
    And I import text to the second track
    When I press and hold to mix a segment
    Then it will mix for 5 seconds sucessfully

  Scenario: Mixing Video and Image
    Given I import a video to a track
    And I import an image to the second track
    When I press and hold to mix a segment
    Then it will mix for 5 seconds sucessfully

   Scenario: Mixing with Two Videos
     Given I import a video to a track
     And I import a video to the second track
     When I press and hold to mix a segment
     And I press and hold to mix a second segment
     Then it will mix for 10 seconds sucessfully
