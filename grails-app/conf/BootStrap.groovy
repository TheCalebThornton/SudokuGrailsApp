import com.sudoku.Puzzle
import com.github.javafaker.Faker

class BootStrap {

    def init = { servletContext ->
        def easy = new Puzzle(
                title: 'ThisEasyPuzzle',
                author: 'Mario',
                difficulty: 'Easy',
                givenValues: 'A4:1,A8:4,' +
                            'B1:1,B2:9,B3:5,B6:8,' +
                            'C1:3,C2:4,C5:2,C7:1,C9:9,' +
                            'D4:9,D5:1,D7:5,' +
                            'E1:6,E3:9,E4:8,E6:2,E7:4,E9:7,' +
                            'F3:1,F5:3,F6:4,' +
                            'G1:2,G3:8,G5:4,G8:7,G9:1,' +
                            'H4:7,H7:8,H8:3,H9:2,' +
                            'I2:1,I6:9'
        ).save(failOnError: true)
        def medium = new Puzzle(
                title: 'ThisMediumPuzzle',
                author: 'Luigi',
                difficulty: 'Medium',
                givenValues: 'A1:3,A8:7,A9:8,' +
                             'B6:8,B7:3,B8:4,' +
                            'C1:8,C4:2,C6:4,C7:5,'+
                            'D2:3,D5:8,D7:4,D8:2,' +
                            'E1:2,E5:6,E9:1,"' +
                            'F2:4,F3:8,F5:1,F8:3,' +
                            'G3:3,G4:8,G6:5,G9:2,' +
                            'H2:5,H3:9,H4:7,' +
                            'I1:1,I2:8,I9:4'
        ).save(failOnError: true)
        def hard = new Puzzle(
                title: 'ThisHardPuzzle',
                author: 'Wario',
                difficulty: 'Hard',
                givenValues: "A3:9,A7:7,A8:3,A9:1," +
                        "B2:3,B6:7," +
                        "C4:3,C5:4,C7:8," +
                        "D1:7,D8:5," +
                        "E1:8,E2:9,E4:5,E6:6,E8:4,E9:7," +
                        "F2:5,F9:6," +
                        "G3:6,G5:5,G6:9,"+
                        "H4:2,H8:1,"+
                        "I1:5,I2:8,I3:2,I7:3"
        ).save(failOnError: true)
        def extreme = new Puzzle(
                title: 'ThisExtremePuzzle',
                author: 'Waluigi',
                difficulty: 'Extreme',
                givenValues: "A1:8,A3:5,A8:3," +
                        "B2:3,B4:9," +
                        "C1:4,C3:6,C5:3," +
                        "D1:6,D5:1,D7:9," +
                        "E2:5,E4:3,E6:8,E8:7," +
                        "F3:9,F5:4,F9:1," +
                        "G5:2,G7:3,G9:8,"+
                        "H6:9,H8:2,"+
                        "I2:7,I7:5,I9:4,"
        ).save(failOnError: true)
    }
    def destroy = {
    }
}
