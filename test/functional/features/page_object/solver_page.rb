require 'page-object'

class SolverPage
  include PageObject

  table(:sudoku_grid, :id => 'puzzleGrid')
  button(:solve, :name => 'solve')


  def enter_puzzle (puzzle)
    for row in 0..8
      for cell in 0..8
        sudoku_grid_element[row][cell].text_field.set (puzzle[row][cell])
      end
    end
  end

end