Feature: To prevent unsolvable puzzles from being added
    As a User creating a puzzle
    The system should tell me if my puzzle is not solvable

  Scenario: Reject the attempt to create an unsolvable puzzle
    When an unsolvable puzzle is entered
    Then an error message is displayed