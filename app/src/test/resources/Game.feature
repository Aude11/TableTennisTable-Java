Feature: Game

  Scenario: Empty League
    Given the league has no players
    When I print the league
    Then I should see "No players yet"

  Scenario: On Going League
    Given the league has 3 players
    When I record win "Bob Alice"
    Then I should see "Bob" winner
