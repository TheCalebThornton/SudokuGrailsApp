Feature: In order show how good at Sudoku I am
    As a user
    I want the system to store my highscore (time it takes to complete)

  Scenario: Record a highscore for a puzzle
    Given there is a puzzle to play
    When I complete the puzzle faster than anyone else
    Then my highscore is recorded