Feature: In order to pass the time
    As a User
    I want to play Sudoku with premade puzzles at varying difficulties

  #lookup criteria for puzzle difficulties
  Scenario: Play an easy puzzle
    Given There is an easy puzzle
    When I select an easy puzzle
    Then I am presented with an easy puzzle
    And I can solve it

  Scenario: Play a medium puzzle
    Given There is a medium puzzle
    When I select a medium puzzle
    Then I am presented with a medium puzzle
    And I can solve it

  Scenario: Play a hard puzzle
    Given There is a hard puzzle
    When I select a hard puzzle
    Then I am presented with a hard puzzle
    And I can solve it

  Scenario: Play an extreme puzzle
    Given There is an extreme puzzle
    When I select an extreme puzzle
    Then I am presented with an extreme puzzle
    And I can solve it
