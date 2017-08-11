package com.sudoku

class Puzzle {

    String givenValues
    String title
    String author
    String difficulty
    float highScore = 10.00

    static constraints = {
        author(nullable: true)
    }
}
