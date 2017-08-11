Feature: In order to cheat at Sudoku
    As a User
    I want the computer to solve my unfinished puzzle

  Scenario: Solve an easy puzzle
    When I input an easy unfinished puzzle
    Then the solver returns the solution

  Scenario: Solve a medium puzzle
    When I input a medium unfinished puzzle
    Then the solver returns the solution

  Scenario: Solve a hard puzzle
    When I input a hard unfinished puzzle
    Then the solver returns the solution

  Scenario: Solve an extreme puzzle
    When I input an extreme unfinished puzzle
    Then the solver returns the solution