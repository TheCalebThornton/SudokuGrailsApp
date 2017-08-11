package com.sudoku

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import com.github.javafaker.Faker
import org.joda.time.DateTime
import spock.lang.Specification

import java.time.LocalTime

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(PuzzleController)
@Mock(Puzzle)
class PuzzleControllerSpec extends Specification {

    def setup() {

    }

    def cleanup() {
    }

    //Converting string to a map
    void "test converting string param of an easy puzzle to a map"() {
        def stringGivensEasy = "A4:1,A8:4," +
                "B1:1,B2:9,B3:5,B6:8," +
                "C1:3,C2:4,C5:2,C7:1,C9:9," +
                "D4:9,D5:1,D7:5," +
                "E1:6,E3:9,E4:8,E6:2,E7:4,E9:7," +
                "F3:1,F5:3,F6:4," +
                "G1:2,G3:8,G5:4,G8:7,G9:1,"+
                "H4:7,H7:8,H8:3,H9:2,"+
                "I2:1,I6:9"
        def mapGivensEasy = ['A4':1,'A8':4,'B1':1,'B2':9,'B3':5,'B6':8, 'C1':3,'C2':4,'C5':2,'C7':1,'C9':9,
                         'D4':9,'D5':1,'D7':5, 'E1':6,'E3':9,'E4':8,'E6':2,'E7':4,'E9':7,
                         'F3':1,'F5':3,'F6':4, 'G1':2,'G3':8,'G5':4,'G8':7,'G9':1,
                         'H4':7,'H7':8,'H8':3,'H9':2,'I2':1,'I6':9 ]
        when: "I receive a string of given values as a parameter"
            def convertedMap = controller.convertGivensToMap(stringGivensEasy)
        then: "the string is accurately translated into a map object"
            convertedMap.toString().equals(mapGivensEasy.toString())
    }
    void "test converting string param of a medium puzzle to a map"() {
        def stringGivensMedium = "A1:3,A8:7,A9:8," +
                "B6:8,B7:3,B8:4," +
                "C1:8,C4:2,C6:4,C7:5," +
                "D2:3,D5:8,D7:4,D8:2," +
                "E1:2,E5:6,E9:1," +
                "F2:4,F3:8,F5:1,F8:3," +
                "G3:3,G4:8,G6:5,G9:2,"+
                "H2:5,H3:9,H4:7,"+
                "I1:1,I2:8,I9:4"
        def mapGivensMedium = ['A1':3,'A8':7,'A9':8,'B6':8,'B7':3,'B8':4, 'C1':8,'C4':2,'C6':4,'C7':5,
                               'D2':3,'D5':8,'D7':4, 'D8':2,'E1':2,'E5':6,'E9':1,'F2':4,'F3':8,'F5':1,
                               'F8':3,'G3':3,'G4':8,'G6':5,'G9':2,'H2':5,'H3':9,'H4':7,'I1':1,'I2':8,'I9':4 ]
        when: "I receive a string of given values as a parameter"
            def convertedMap = controller.convertGivensToMap(stringGivensMedium)
        then: "the string is accurately translated into a map object"
            convertedMap.toString().equals(mapGivensMedium.toString())
    }
    void "test converting string param of a hard puzzle to a map"() {
        def stringGivensHard = "A3:9,A7:7,A8:3,A9:1," +
                "B2:3,B6:7," +
                "C4:3,C5:4,C7:8," +
                "D1:7,D8:5," +
                "E1:8,E2:9,E4:5,E6:6,E8:4,E9:7," +
                "F2:5,F9:6," +
                "G3:6,G5:5,G6:9,"+
                "H4:2,H8:1,"+
                "I1:5,I2:8,I3:2,I7:3"
        def mapGivensHard = ['A3':9,'A7':7,'A8':3,'A9':1,'B2':3,'B6':7,'C4':3,'C5':4,'C7':8,
                         'D1':7,'D8':5,'E1':8,'E2':9,'E4':5,'E6':6,'E8':4,'E9':7,'F2':5,'F9':6,
                         'G3':6,'G5':5,'G6':9,'H4':2,'H8':1,'I1':5,'I2':8,'I3':2,'I7':3]
        when: "I receive a string of given values as a parameter"
            def convertedMap = controller.convertGivensToMap(stringGivensHard)
        then: "the string is accurately translated into a map object"
            convertedMap.toString().equals(mapGivensHard.toString())
    }
    void "test converting string param of an extreme puzzle to a map"() {
        def stringGivensExtreme = "A1:8,A3:5,A8:3," +
                "B2:3,B4:9," +
                "C1:4,C3:6,C5:3," +
                "D1:6,D5:1,D7:9," +
                "E2:5,E4:3,E6:8,E8:7," +
                "F3:9,F5:4,F9:1," +
                "G5:2,G7:3,G9:8,"+
                "H6:9,H8:2,"+
                "I2:7,I7:5,I9:4,"
        def mapGivensExtreme = ['A1':8,'A3':5,'A8':3,'B2':3,'B4':9,'C1':4,'C3':6,'C5':3,
                            'D1':6,'D5':1,'D7':9,'E2':5,'E4':3,'E6':8,'E8':7,'F3':9,'F5':4,'F9':1,
                            'G5':2,'G7':3,'G9':8,'H6':9,'H8':2,'I2':7,'I7':5,'I9':4]
        when: "I receive a string of given values as a parameter"
            def convertedMap = controller.convertGivensToMap(stringGivensExtreme)
        then: "the string is accurately translated into a map object"
            convertedMap.toString().equals(mapGivensExtreme.toString())
    }

    //Calculate lowest given count
    void "test calculating lowest given occurrences of a singular number"() {
        def mapGivensEasy = ['A4':1,'A8':4,'B1':1,'B2':9,'B3':5,'B6':8, 'C1':3,'C2':4,'C5':2,'C7':1,'C9':9,
                             'D4':9,'D5':1,'D7':5, 'E1':6,'E3':9,'E4':8,'E6':2,'E7':4,'E9':7,
                             'F3':1,'F5':3,'F6':4, 'G1':2,'G3':8,'G5':4,'G8':7,'G9':1,
                             'H4':7,'H7':8,'H8':3,'H9':2,'I2':1,'I6':9 ]
        def lowestGivenCountEasy = 1
        when: "I calculate the lowest given count of an easy puzzle map"
            def lowestGivenCount = controller.countLowestGivens(mapGivensEasy)
        then: "the correct lowest given count is returned"
            lowestGivenCount == lowestGivenCountEasy
    }
    void "test calculating lowest given occurrences of a singular number with multiple lowest occurrences"() {
        def mapGivensMedium = ['A1':3,'A8':7,'A9':8,'B6':8,'B7':3,'B8':4, 'C1':8,'C4':2,'C6':4,'C7':5,
                           'D2':3,'D5':8,'D7':4, 'D8':2,'E1':2,'E5':6,'E9':1,'F2':4,'F3':8,'F5':1,
                           'F8':3,'G3':3,'G4':8,'G6':5,'G9':2,'H2':5,'H3':9,'H4':7,'I1':1,'I2':8,'I9':4 ]
        def lowestGivenCountMedium = 2
        when: "I calculate the lowest given count of a medium puzzle map"
            def lowestGivenCount = controller.countLowestGivens(mapGivensMedium)
        then: "the correct lowest given count is returned"
            lowestGivenCount == lowestGivenCountMedium
    }
    //TODO
    //Hard and extreme occurrences (Look up details)

    //Calculate Distribution
    void "test calculating distribution of givens per box with easy puzzle"(){
        def mapGivensEasy = ['A4':1,'A8':4,'B1':1,'B2':9,'B3':5,'B6':8, 'C1':3,'C2':4,'C5':2,'C7':1,'C9':9,
                             'D4':9,'D5':1,'D7':5, 'E1':6,'E3':9,'E4':8,'E6':2,'E7':4,'E9':7,
                             'F3':1,'F5':3,'F6':4, 'G1':2,'G3':8,'G5':4,'G8':7,'G9':1,
                             'H4':7,'H7':8,'H8':3,'H9':2,'I2':1,'I6':9 ]
        def lowestDistributionFactorEasy = 8
        when: "I calculate the distribution of givens per box on an easy puzzle map"
            def calculatedDistributionFactor = controller.calcDistributionFactor(mapGivensEasy)
        then: "the correct number of givens per box is returned"
            calculatedDistributionFactor == lowestDistributionFactorEasy
    }
    void "test calculating distribution of givens per box with medium puzzle"(){
        def mapGivensMedium = ['A1':3,'A8':7,'A9':8,'B6':8,'B7':3,'B8':4, 'C1':8,'C4':2,'C6':4,'C7':5,
                               'D2':3,'D5':8,'D7':4, 'D8':2,'E1':2,'E5':6,'E9':1,'F2':4,'F3':8,'F5':1,
                               'F8':3,'G3':3,'G4':8,'G6':5,'G9':2,'H2':5,'H3':9,'H4':7,'I1':1,'I2':8,'I9':4 ]
        def lowestDistributionFactorMedium = 3
        when: "I calculate the distribution of givens per box on an easy puzzle map"
            def calculatedDistributionFactor = controller.calcDistributionFactor(mapGivensMedium)
        then: "the correct number of givens per box is returned"
            calculatedDistributionFactor == lowestDistributionFactorMedium
    }
    void "test calculating distribution of givens per box with hard puzzle"(){
        def mapGivensHard = ['A3':9,'A7':7,'A8':3,'A9':1,'B2':3,'B6':7,'C4':3,'C5':4,'C7':8,
                             'D1':7,'D8':5,'E1':8,'E2':9,'E4':5,'E6':6,'E8':4,'E9':7,'F2':5,'F9':6,
                             'G3':6,'G5':5,'G6':9,'H4':2,'H8':1,'I1':5,'I2':8,'I3':2,'I7':3]
        def lowestDistributionFactorHard = 4
        when: "I calculate the distribution of givens per box on an easy puzzle map"
            def calculatedDistributionFactor = controller.calcDistributionFactor(mapGivensHard)
        then: "the correct number of givens per box is returned"
            calculatedDistributionFactor == lowestDistributionFactorHard
    }
    void "test calculating distribution of givens per box with extreme puzzle"(){
        def mapGivensExtreme = ['A1':8,'A3':5,'A8':3,'B2':3,'B4':9,'C1':4,'C3':6,'C5':3,
                                'D1':6,'D5':1,'D7':9,'E2':5,'E4':3,'E6':8,'E8':7,'F3':9,'F5':4,'F9':1,
                                'G5':2,'G7':3,'G9':8,'H6':9,'H8':2,'I2':7,'I7':5,'I9':4]
        def lowestDistributionFactorExtreme = 2
        when: "I calculate the distribution of givens per box on an easy puzzle map"
            def calculatedDistributionFactor = controller.calcDistributionFactor(mapGivensExtreme)
        then: "the correct number of givens per box is returned"
            calculatedDistributionFactor == lowestDistributionFactorExtreme
    }

    //Determine Difficulty
    void "test determining the difficulty of an easy puzzle"() {
        def stringGivensEasy = "A4:1,A8:4," +
                "B1:1,B2:9,B3:5,B6:8," +
                "C1:3,C2:4,C5:2,C7:1,C9:9," +
                "D4:9,D5:1,D7:5," +
                "E1:6,E3:9,E4:8,E6:2,E7:4,E9:7," +
                "F3:1,F5:3,F6:4," +
                "G1:2,G3:8,G5:4,G8:7,G9:1,"+
                "H4:7,H7:8,H8:3,H9:2,"+
                "I2:1,I6:9"
        when: "I receive the translated puzzle and determine the difficulty"
            def puzzleDifficulty = controller.determineDifficulty(stringGivensEasy)
        then: "the puzzle is translated to a string (format: Cell:Value,Cell:Value, etc.)"
            puzzleDifficulty == 'Easy'
    }
    void "test determining the difficulty of a medium puzzle"() {
        def stringGivensMedium = "A1:3,A8:7,A9:8," +
                "B6:8,B7:3,B8:4," +
                "C1:8,C4:2,C6:4,C7:5," +
                "D2:3,D5:8,D7:4,D8:2," +
                "E1:2,E5:6,E9:1," +
                "F2:4,F3:8,F5:1,F8:3," +
                "G3:3,G4:8,G6:5,G9:2,"+
                "H2:5,H3:9,H4:7,"+
                "I1:1,I2:8,I9:4"
        when: "I receive the translated puzzle and determine the difficulty"
            def puzzleDifficulty = controller.determineDifficulty(stringGivensMedium)
        then: "the puzzle is translated to a string (format: Cell:Value,Cell:Value, etc.)"
            puzzleDifficulty == 'Medium'
    }
    void "test determining the difficulty of a hard puzzle"() {
        def stringGivensHard = "A3:9,A7:7,A8:3,A9:1," +
                "B2:3,B6:7," +
                "C4:3,C5:4,C7:8," +
                "D1:7,D8:5," +
                "E1:8,E2:9,E4:5,E6:6,E8:4,E9:7," +
                "F2:5,F9:6," +
                "G3:6,G5:5,G6:9,"+
                "H4:2,H8:1,"+
                "I1:5,I2:8,I3:2,I7:3"
        when: "I receive the translated puzzle and determine the difficulty"
            def puzzleDifficulty = controller.determineDifficulty(stringGivensHard)
        then: "the puzzle is translated to a string (format: Cell:Value,Cell:Value, etc.)"
            puzzleDifficulty == 'Hard'
    }
    void "test determining the difficulty of an extreme puzzle"() {
        def stringGivensExtreme = "A1:8,A3:5,A8:3," +
                "B2:3,B4:9," +
                "C1:4,C3:6,C5:3," +
                "D1:6,D5:1,D7:9," +
                "E2:5,E4:3,E6:8,E8:7," +
                "F3:9,F5:4,F9:1," +
                "G5:2,G7:3,G9:8,"+
                "H6:9,H8:2,"+
                "I2:7,I7:5,I9:4,"
        when: "I receive the translated puzzle and determine the difficulty"
            def puzzleDifficulty = controller.determineDifficulty(stringGivensExtreme)
        then: "the puzzle is translated to a string (format: Cell:Value,Cell:Value, etc.)"
            puzzleDifficulty == 'Extreme'
    }

    //Display puzzles based on difficulty selected
    void "test listing puzzles by difficulty when param value is easy"(){
        given: "there are easy puzzles in the database"
            def stringGivensEasy = "A4:1,A8:4," +
                "B1:1,B2:9,B3:5,B6:8," +
                "C1:3,C2:4,C5:2,C7:1,C9:9," +
                "D4:9,D5:1,D7:5," +
                "E1:6,E3:9,E4:8,E6:2,E7:4,E9:7," +
                "F3:1,F5:3,F6:4," +
                "G1:2,G3:8,G5:4,G8:7,G9:1,"+
                "H4:7,H7:8,H8:3,H9:2,"+
                "I2:1,I6:9"
            def puzzleObjEasy1 = new Puzzle (
                givenValues: stringGivensEasy,
                difficulty: 'Easy'
            ).save(validate: false)
            def listOfEasyPuzzles = [puzzleObjEasy1]
        when: "the user selects easy"
            PuzzleDifficultyCommand ipcDifficulty = new PuzzleDifficultyCommand()
            ipcDifficulty.difficulty = 'easy'
            controller.listPuzzles(ipcDifficulty)
        then: "a list of easy puzzles is returned"
            model.puzzleList == listOfEasyPuzzles
    }
    void "test listing puzzles by difficulty when param value is UPPERCASE EASY"(){
        given: "there are easy puzzles in the database"
            def stringGivensEasy = "A4:1,A8:4," +
                "B1:1,B2:9,B3:5,B6:8," +
                "C1:3,C2:4,C5:2,C7:1,C9:9," +
                "D4:9,D5:1,D7:5," +
                "E1:6,E3:9,E4:8,E6:2,E7:4,E9:7," +
                "F3:1,F5:3,F6:4," +
                "G1:2,G3:8,G5:4,G8:7,G9:1,"+
                "H4:7,H7:8,H8:3,H9:2,"+
                "I2:1,I6:9"
            def puzzleObjEasy1 = new Puzzle (
                    givenValues: stringGivensEasy,
                    difficulty: 'Easy'
            ).save(validate: false)
            def listOfEasyPuzzles = [puzzleObjEasy1]
        when: "the user selects easy"
            PuzzleDifficultyCommand ipcDifficulty = new PuzzleDifficultyCommand()
            ipcDifficulty.difficulty = 'EASY'
            controller.listPuzzles(ipcDifficulty)
        then: "a list of easy puzzles is returned"
            model.puzzleList == listOfEasyPuzzles
    }
    void "test listing puzzles by difficulty when param value is Mixed case EaSy"(){
        given: "there are easy puzzles in the database"
            def stringGivensEasy = "A4:1,A8:4," +
                "B1:1,B2:9,B3:5,B6:8," +
                "C1:3,C2:4,C5:2,C7:1,C9:9," +
                "D4:9,D5:1,D7:5," +
                "E1:6,E3:9,E4:8,E6:2,E7:4,E9:7," +
                "F3:1,F5:3,F6:4," +
                "G1:2,G3:8,G5:4,G8:7,G9:1,"+
                "H4:7,H7:8,H8:3,H9:2,"+
                "I2:1,I6:9"
            def puzzleObjEasy1 = new Puzzle (
                givenValues: stringGivensEasy,
                difficulty: 'Easy'
            ).save(validate: false)
            def listOfEasyPuzzles = [puzzleObjEasy1]
        when: "the user selects easy"
            PuzzleDifficultyCommand ipcDifficulty = new PuzzleDifficultyCommand()
            ipcDifficulty.difficulty = 'EaSy'
            controller.listPuzzles(ipcDifficulty)
        then: "a list of easy puzzles is returned"
            model.puzzleList == listOfEasyPuzzles
    }
    void "test listing puzzles by difficulty when param value is medium"(){
        given: "there are medium puzzles in the database"
            def stringGivensMedium = "A1:3,A8:7,A9:8," +
                "B6:8,B7:3,B8:4," +
                "C1:8,C4:2,C6:4,C7:5," +
                "D2:3,D5:8,D7:4,D8:2," +
                "E1:2,E5:6,E9:1," +
                "F2:4,F3:8,F5:1,F8:3," +
                "G3:3,G4:8,G6:5,G9:2,"+
                "H2:5,H3:9,H4:7,"+
                "I1:1,I2:8,I9:4"
            def puzzleObjMedium1 = new Puzzle (
                givenValues: stringGivensMedium,
                difficulty: 'Medium'
            ).save(validate: false)
            def listOfMediumPuzzles = [puzzleObjMedium1]
        when: "the user selects medium"
            PuzzleDifficultyCommand ipcDifficulty = new PuzzleDifficultyCommand()
            ipcDifficulty.difficulty = 'medium'
            controller.listPuzzles(ipcDifficulty)
        then: "a list of medium puzzles is returned"
            model.puzzleList == listOfMediumPuzzles
    }
    void "test listing puzzles by difficulty when param value is UPPERCASE MEDIUM"() {
        given: "there are medium puzzles in the database"
            def stringGivensMedium = "A1:3,A8:7,A9:8," +
                "B6:8,B7:3,B8:4," +
                "C1:8,C4:2,C6:4,C7:5," +
                "D2:3,D5:8,D7:4,D8:2," +
                "E1:2,E5:6,E9:1," +
                "F2:4,F3:8,F5:1,F8:3," +
                "G3:3,G4:8,G6:5,G9:2,"+
                "H2:5,H3:9,H4:7,"+
                "I1:1,I2:8,I9:4"
            def puzzleObjMedium1 = new Puzzle(
                givenValues: stringGivensMedium,
                difficulty: 'Medium'
            ).save(validate: false)
            def listOfMediumPuzzles = [puzzleObjMedium1]
        when: "the user selects medium"
            PuzzleDifficultyCommand ipcDifficulty = new PuzzleDifficultyCommand()
            ipcDifficulty.difficulty = 'MEDIUM'
            controller.listPuzzles(ipcDifficulty)
        then: "a list of medium puzzles is returned"
            model.puzzleList == listOfMediumPuzzles
    }
    void "test listing puzzles by difficulty when param value is Mixed case MeDiUm"(){
        given: "there are medium puzzles in the database"
            def stringGivensMedium = "A1:3,A8:7,A9:8," +
                "B6:8,B7:3,B8:4," +
                "C1:8,C4:2,C6:4,C7:5," +
                "D2:3,D5:8,D7:4,D8:2," +
                "E1:2,E5:6,E9:1," +
                "F2:4,F3:8,F5:1,F8:3," +
                "G3:3,G4:8,G6:5,G9:2,"+
                "H2:5,H3:9,H4:7,"+
                "I1:1,I2:8,I9:4"
            def puzzleObjMedium1 = new Puzzle (
                    givenValues: stringGivensMedium,
                    difficulty: 'Medium'
            ).save(validate: false)
            def listOfMediumPuzzles = [puzzleObjMedium1]
        when: "the user selects medium"
            PuzzleDifficultyCommand ipcDifficulty = new PuzzleDifficultyCommand()
            ipcDifficulty.difficulty = 'MeDiUm'
            controller.listPuzzles(ipcDifficulty)
        then: "a list of medium puzzles is returned"
            model.puzzleList == listOfMediumPuzzles
    }
    void "test listing puzzles by difficulty when param value is hard"(){
        given: "there are hard puzzles in the database"
            def stringGivensHard = "A3:9,A7:7,A8:3,A9:1," +
                "B2:3,B6:7," +
                "C4:3,C5:4,C7:8," +
                "D1:7,D8:5," +
                "E1:8,E2:9,E4:5,E6:6,E8:4,E9:7," +
                "F2:5,F9:6," +
                "G3:6,G5:5,G6:9,"+
                "H4:2,H8:1,"+
                "I1:5,I2:8,I3:2,I7:3"
            def puzzleObjHard1 = new Puzzle (
                givenValues: stringGivensHard,
                difficulty: 'Hard'
            ).save(validate: false)
            def listOfHardPuzzles = [puzzleObjHard1]
        when: "the user selects hard"
            PuzzleDifficultyCommand ipcDifficulty = new PuzzleDifficultyCommand()
            ipcDifficulty.difficulty = 'hard'
            controller.listPuzzles(ipcDifficulty)
        then: "a list of hard puzzles is returned"
            model.puzzleList == listOfHardPuzzles
    }
    void "test listing puzzles by difficulty when param value is UPPERCASE HARD"() {
        given: "there are hard puzzles in the database"
            def stringGivensHard = "A3:9,A7:7,A8:3,A9:1," +
                "B2:3,B6:7," +
                "C4:3,C5:4,C7:8," +
                "D1:7,D8:5," +
                "E1:8,E2:9,E4:5,E6:6,E8:4,E9:7," +
                "F2:5,F9:6," +
                "G3:6,G5:5,G6:9,"+
                "H4:2,H8:1,"+
                "I1:5,I2:8,I3:2,I7:3"
            def puzzleObjHard1 = new Puzzle(
                givenValues: stringGivensHard,
                difficulty: 'Hard'
            ).save(validate: false)
            def listOfHardPuzzles = [puzzleObjHard1]
        when: "the user selects hard"
            PuzzleDifficultyCommand ipcDifficulty = new PuzzleDifficultyCommand()
            ipcDifficulty.difficulty = 'HARD'
            controller.listPuzzles(ipcDifficulty)
        then: "a list of hard puzzles is returned"
            model.puzzleList == listOfHardPuzzles
    }
    void "test listing puzzles by difficulty when param value is Mixed case HaRd"(){
        given: "there are hard puzzles in the database"
        def stringGivensHard = "A3:9,A7:7,A8:3,A9:1," +
                "B2:3,B6:7," +
                "C4:3,C5:4,C7:8," +
                "D1:7,D8:5," +
                "E1:8,E2:9,E4:5,E6:6,E8:4,E9:7," +
                "F2:5,F9:6," +
                "G3:6,G5:5,G6:9,"+
                "H4:2,H8:1,"+
                "I1:5,I2:8,I3:2,I7:3"
            def puzzleObjHard1 = new Puzzle (
                givenValues: stringGivensHard,
                difficulty: 'Hard'
            ).save(validate: false)
            def listOfHardPuzzles = [puzzleObjHard1]
        when: "the user selects hard"
            PuzzleDifficultyCommand ipcDifficulty = new PuzzleDifficultyCommand()
            ipcDifficulty.difficulty = 'HaRd'
            controller.listPuzzles(ipcDifficulty)
        then: "a list of hard puzzles is returned"
            model.puzzleList == listOfHardPuzzles
    }
    void "test listing puzzles by difficulty when param value is extreme"(){
        given: "there are extreme puzzles in the database"
            def stringGivensExtreme = "A1:8,A3:5,A8:3," +
                "B2:3,B4:9," +
                "C1:4,C3:6,C5:3," +
                "D1:6,D5:1,D7:9," +
                "E2:5,E4:3,E6:8,E8:7," +
                "F3:9,F5:4,F9:1," +
                "G5:2,G7:3,G9:8,"+
                "H6:9,H8:2,"+
                "I2:7,I7:5,I9:4,"

            def puzzleObjExtreme1 = new Puzzle (
                givenValues: stringGivensExtreme,
                difficulty: 'Extreme'
            ).save(validate: false)
            def listOfExtremePuzzles = [puzzleObjExtreme1]
        when: "the user selects extreme"
            PuzzleDifficultyCommand ipcDifficulty = new PuzzleDifficultyCommand()
            ipcDifficulty.difficulty = 'extreme'
            controller.listPuzzles(ipcDifficulty)
        then: "a list of extreme puzzles is returned"
            model.puzzleList == listOfExtremePuzzles
    }
    void "test listing puzzles by difficulty when param value is UPPERCASE Extreme"() {
        given: "there are extreme puzzles in the database"
            def stringGivensExtreme = "A1:8,A3:5,A8:3," +
                "B2:3,B4:9," +
                "C1:4,C3:6,C5:3," +
                "D1:6,D5:1,D7:9," +
                "E2:5,E4:3,E6:8,E8:7," +
                "F3:9,F5:4,F9:1," +
                "G5:2,G7:3,G9:8,"+
                "H6:9,H8:2,"+
                "I2:7,I7:5,I9:4,"
            def puzzleObjExtreme1 = new Puzzle(
                givenValues: stringGivensExtreme,
                difficulty: 'Extreme'
            ).save(validate: false)
            def listOfExtremePuzzles = [puzzleObjExtreme1]
        when: "the user selects extreme"
            PuzzleDifficultyCommand ipcDifficulty = new PuzzleDifficultyCommand()
            ipcDifficulty.difficulty = 'EXTREME'
            controller.listPuzzles(ipcDifficulty)
        then: "a list of extreme puzzles is returned"
            model.puzzleList == listOfExtremePuzzles
    }
    void "test listing puzzles by difficulty when param value is Mixed case ExTrEmE"(){
        given: "there are extreme puzzles in the database"
            def stringGivensExtreme = "A1:8,A3:5,A8:3," +
                "B2:3,B4:9," +
                "C1:4,C3:6,C5:3," +
                "D1:6,D5:1,D7:9," +
                "E2:5,E4:3,E6:8,E8:7," +
                "F3:9,F5:4,F9:1," +
                "G5:2,G7:3,G9:8,"+
                "H6:9,H8:2,"+
                "I2:7,I7:5,I9:4,"
            def puzzleObjExtreme1 = new Puzzle (
                givenValues: stringGivensExtreme,
                difficulty: 'Extreme'
            ).save(validate: false)
            def listOfExtremePuzzles = [puzzleObjExtreme1]
        when: "the user selects extreme"
            PuzzleDifficultyCommand ipcDifficulty = new PuzzleDifficultyCommand()
            ipcDifficulty.difficulty = 'ExTrEmE'
            controller.listPuzzles(ipcDifficulty)
        then: "a list of extreme puzzles is returned"
            model.puzzleList == listOfExtremePuzzles
    }

    //List puzzles by difficulty
    void "test listing puzzles by difficulty when the param value is null"(){
        given: "there are easy puzzles in the database"
        def stringGivensEasy = "A4:1,A8:4," +
                "B1:1,B2:9,B3:5,B6:8," +
                "C1:3,C2:4,C5:2,C7:1,C9:9," +
                "D4:9,D5:1,D7:5," +
                "E1:6,E3:9,E4:8,E6:2,E7:4,E9:7," +
                "F3:1,F5:3,F6:4," +
                "G1:2,G3:8,G5:4,G8:7,G9:1,"+
                "H4:7,H7:8,H8:3,H9:2,"+
                "I2:1,I6:9"
            def puzzleObjEasy1 = new Puzzle (
                givenValues: stringGivensEasy,
                difficulty: 'Easy'
            ).save(validate: false)
            def listOfEasyPuzzles = [puzzleObjEasy1]
        when: "the list of puzzles is displayed"
            PuzzleDifficultyCommand ipcDifficulty = new PuzzleDifficultyCommand()
            ipcDifficulty.difficulty = null
            controller.listPuzzles(ipcDifficulty)
        then: "I am shown a list of puzzles with that difficulty"
            model.puzzleList == listOfEasyPuzzles
    }
    void "test listing puzzles by difficulty when the param value is empty"(){
        given: "there are easy puzzles in the database"
        def stringGivensEasy = "A4:1,A8:4," +
                "B1:1,B2:9,B3:5,B6:8," +
                "C1:3,C2:4,C5:2,C7:1,C9:9," +
                "D4:9,D5:1,D7:5," +
                "E1:6,E3:9,E4:8,E6:2,E7:4,E9:7," +
                "F3:1,F5:3,F6:4," +
                "G1:2,G3:8,G5:4,G8:7,G9:1,"+
                "H4:7,H7:8,H8:3,H9:2,"+
                "I2:1,I6:9"
            def puzzleObjEasy1 = new Puzzle (
                givenValues: stringGivensEasy,
                difficulty: 'Easy'
            ).save(validate: false)
            def listOfEasyPuzzles = [puzzleObjEasy1]
        when: "the list of puzzles is displayed"
            PuzzleDifficultyCommand ipcDifficulty = new PuzzleDifficultyCommand()
            ipcDifficulty.difficulty = ''
            controller.listPuzzles(ipcDifficulty)
        then: "I am shown a list of puzzles with that difficulty"
            model.puzzleList == listOfEasyPuzzles
    }

    //Add tests to show method

    //testing custom show method
    void "test show puzzles method passes given values to model when puzzle with given values is clicked"(){
        given: "there are easy puzzles in the database"
        def stringGivensEasy = "A4:1,A8:4," +
                "B1:1,B2:9,B3:5,B6:8," +
                "C1:3,C2:4,C5:2,C7:1,C9:9," +
                "D4:9,D5:1,D7:5," +
                "E1:6,E3:9,E4:8,E6:2,E7:4,E9:7," +
                "F3:1,F5:3,F6:4," +
                "G1:2,G3:8,G5:4,G8:7,G9:1,"+
                "H4:7,H7:8,H8:3,H9:2,"+
                "I2:1,I6:9"
            def puzzleObjEasy1 = new Puzzle (
                givenValues: stringGivensEasy,
                difficulty: 'Easy'
            ).save(validate: false)
        when: "I click on an easy puzzle in the list of puzzles"
            controller.params.id = puzzleObjEasy1.id
            controller.show()
        then: "the given puzzle values are passed to the model"
            model.puzzleInstance.givenValues == stringGivensEasy
    }
    //test scoreConverter
    void "test string score to float converter with a valid time string"(){
        when: "a well formatted string is passed to the converter"
            String strTimer = "12:32"
            float expectedResult = 12.32
            def result = controller.convertStringScoreToFloat(strTimer)
        then: "the string is returned as a properly formatted float"
            result == expectedResult
    }
    void "test string score to float converter with a string that doesn't have a colon"(){
        when: "a poorly formatted string is passed to the converter"
            String strTimer = "12,32"
            def result = controller.convertStringScoreToFloat(strTimer)
        then: "an error is raised and the result is 10.00"
            result == 10.00
    }

    //test submit solution method

    void "test submit solution accurately overwrites default highscore with the new puzzle highscore"(){
        given: "there is a solution with a default highscore value"
            def puzzleObjScore = new Puzzle(
                title: 'test',
                difficulty: 'hard',
                givenValues: 'A1:2'
            ).save()
        when: "a solution is submitted from the view with a high score"
            PuzzleScoreCommand psc = new PuzzleScoreCommand()
            String newHighScoreString = '5:34'
            float newHighScoreFloat = 5.34
            psc.score = newHighScoreString
            controller.params.id = puzzleObjScore.id
            controller.submitSolution(psc)
        then: "the puzzle now contains the highscore"
            puzzleObjScore.highScore == newHighScoreFloat
    }
    void "test submit solution does not overwrite a current score with a lower score"(){
        given: "there is a puzzle with a highscore in the database"
            float previousHighScore = 2.57
            def puzzleObjScore = new Puzzle(
                title: 'test',
                difficulty: 'hard',
                givenValues: 'A1:2',
                highScore: previousHighScore
            ).save()
        when: "a solution is submitted from the view with new high score"
            PuzzleScoreCommand psc = new PuzzleScoreCommand()
            String newHighScoreString = '3:67'
            psc.score = newHighScoreString
            controller.params.id = puzzleObjScore.id
            controller.submitSolution(psc)
        then: "the puzzle still contains the previous highscore"
            puzzleObjScore.highScore == previousHighScore
    }
    void "test submit solution overwrites a lower score with a higher score"(){
        given: "there is a puzzle with a highscore in the database"
            def puzzleObjScore = new Puzzle(
                    title: 'test',
                    difficulty: 'hard',
                    givenValues: 'A1:2',
                    highScore: 1.77
            ).save()
        when: "a solution is submitted from the view with a new high score"
            PuzzleScoreCommand psc = new PuzzleScoreCommand()
            String newHighScoreString = '1:67'
            float newHighScore = 1.67
            psc.score = newHighScoreString
            controller.params.id = puzzleObjScore.id
            controller.submitSolution(psc)
        then: "the puzzle now contains the new highscore"
            puzzleObjScore.highScore == newHighScore
    }
    void "test submit solution keeps the current highscore when the new highscore is the same as the current score"(){
        given: "there is a puzzle with a highscore in the database"
            def puzzleObjScore = new Puzzle(
                    title: 'test',
                    difficulty: 'hard',
                    givenValues: 'A1:2',
                    highScore: 2.45
            ).save()
        when: "a solution is submitted from the view with a new high score"
        PuzzleScoreCommand psc = new PuzzleScoreCommand()
        String newHighScoreString = '2:45'
        float newHighScore = 2.45
        psc.score = newHighScoreString
        controller.params.id = puzzleObjScore.id
        controller.submitSolution(psc)
        then: "the puzzle still contains the previous highscore when the two scores are the same"
        puzzleObjScore.highScore == newHighScore

    }

}
