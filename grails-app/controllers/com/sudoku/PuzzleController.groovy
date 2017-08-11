package com.sudoku

import grails.validation.Validateable

class PuzzleController {
    def scaffold = Puzzle

    def congratulations(){}
    def save(){
        Puzzle puzzle = new Puzzle()
        puzzle.properties = params
        puzzle.difficulty = determineDifficulty(params.givenValues)
        if(puzzle.save()){
            redirect(controller: 'puzzle', action: 'index')
        }
        else{
            render("OOPS something didn't save correctly on Puzzle Object")
        }
    }
    def index(){
        listPuzzles(new PuzzleDifficultyCommand(difficulty: 'easy'))
    }
    def show(){
        Puzzle puzzle = new Puzzle()
        puzzle = Puzzle.findById(params.id)
        if(puzzle){
            render(view: 'show', model: [puzzleInstance: puzzle])
        }
        else{
            render('OOPS error loading that puzzle')
        }
    }

    def convertStringScoreToFloat(String string){
        try {
            return Float.parseFloat(string.replace(':', '.'))
        }
        catch(NumberFormatException e){
            print e.toString() + "A string with a (non-colon) special character was passed through the timer parameter";
            return 10.00
        }
    }
    //Solution is validated on client side with javascript
    def submitSolution(PuzzleScoreCommand psc){
        def score = convertStringScoreToFloat(psc.score)
        def puzzle = Puzzle.findById(params.id)
        puzzle.highScore = (score < puzzle.highScore)? score : puzzle.highScore
        if(puzzle.save(flush:true)){
            render(view: 'congratulations', model:[
                    author: puzzle.author,
                    difficulty: puzzle.difficulty,
                    score: puzzle.highScore
            ])
        }
        else{
            render('OOPS error saving the highscore!')
        }

    }

    def listPuzzles(PuzzleDifficultyCommand pdc){
        def difficulty = (pdc.difficulty != null && pdc.difficulty != '') ? pdc.difficulty : 'Easy'
        def puzzleList = Puzzle.findAllByDifficultyIlike(difficulty)
        render(view: 'index', model: [
                difficulty         : difficulty,
                puzzleList         : puzzleList,
        ])
    }

    def convertGivensToMap(givens){
        def givenMap = [:]
        givens = givens.split(',')
        givens.each {
            it = it.split(':')
            givenMap[it[0]] = it[1]
        }
        return givenMap
    }
    def countLowestGivens(givenMap){
        def countMap = [:]
        givenMap.each{ key, value ->
            countMap[value] = (countMap[value] != null)? countMap[value]+1: 1
        }
        def countArray = countMap.values().toArray()
        countArray = countArray.sort()
        //count total occurrences
        def lowestGivenPerNum = countArray[0]
        for(int i=1; i<countArray.length-1; i++){
            lowestGivenPerNum += (countArray[0] == countArray[i])? 1 : 0
        }
        return lowestGivenPerNum
    }
    def calcDistributionFactor(givenMap){
        def boxDistCount = [:]
        givenMap.each{ key, value ->
            def col = (int)key.charAt(0)-64
            def row = Character.getNumericValue(key.charAt(1))
            //Box 1
            if(col <= 3 && row <= 3){
                boxDistCount['1'] = (boxDistCount['1'] != null)? boxDistCount['1']+1: 1
            }
            //Box 2
            else if(col <= 6 && row <= 3) {
                boxDistCount['2'] = (boxDistCount['2'] != null)? boxDistCount['2']+1: 1
            }
            //Box 3
            else if(col <= 9 && row <= 3){
                boxDistCount['3'] = (boxDistCount['3'] != null)? boxDistCount['3']+1: 1
            }
            //Box 4
            else if(col <= 3 && row <= 6){
                boxDistCount['4'] = (boxDistCount['4'] != null)? boxDistCount['4']+1: 1
            }
            //Box 5
            else if(col <= 6 && row <= 6){
                boxDistCount['5'] = (boxDistCount['5'] != null)? boxDistCount['5']+1: 1
            }
            //Box 6
            else if(col <= 9 && row <= 6){
                boxDistCount['6'] = (boxDistCount['6'] != null)? boxDistCount['6']+1: 1
            }
            //Box 7
            else if(col <= 3 && row <= 9){
                boxDistCount['7'] = (boxDistCount['7'] != null)? boxDistCount['7']+1: 1
            }
            //Box 8
            else if(col <= 6 && row <= 9){
                boxDistCount['8'] = (boxDistCount['8'] != null)? boxDistCount['8']+1: 1
            }
            //Box 9
            else if(col <= 9 && row <= 9){
                boxDistCount['9'] = (boxDistCount['9'] != null)? boxDistCount['9']+1: 1
            }
        }
        def distArray = boxDistCount.values().toArray()
        distArray = distArray.sort()
        //count total occurrences
        def distributionValue = distArray[0]
        for(int i=1; i<distArray.length-1; i++){
            distributionValue += (distArray[0] == distArray[i])? 1 : 0
        }
        return distributionValue
    }
    def determineDifficulty(givenString) {
        def givenMap = convertGivensToMap(givenString)
        //Set the baseline to subtract criteria from and ultimately determine the difficulty mathematically
        def difficultyBaseLine = 100
        //check number of total givens
        difficultyBaseLine -= (givenMap.size()*2) //weigh the number of givens as more important than other factors
        //check distribution of givens per box
        difficultyBaseLine -= calcDistributionFactor(givenMap)
        //check total occurrences of least occurring numbers
        difficultyBaseLine -= countLowestGivens(givenMap)
        //determine difficulty based on remaining value
        if(difficultyBaseLine <= 25){
            return 'Easy'
        }
        else if(difficultyBaseLine <= 35){
            return 'Medium'
        }
        else if(difficultyBaseLine <= 40){
            return 'Hard'
        }
        else{
            return 'Extreme'
        }
    }

}

@Validateable
class PuzzleDifficultyCommand {
    String difficulty
}
@Validateable
class PuzzleScoreCommand {
    String score
}