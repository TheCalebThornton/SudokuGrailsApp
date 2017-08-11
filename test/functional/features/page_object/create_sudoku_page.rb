require 'page-object'

class CreateSudokuPage
  include PageObject

  text_field(:title, :name => 'title')
  table(:sudoku_grid, :id => 'puzzleGrid')
  text_field(:author, :name => 'author')
  h3(:error, :id => 'error')
  button(:create, :id => 'create')


  def enter_puzzle (puzzle)
      for row in 0..8
        for cell in 0..8
          sudoku_grid_element[row][cell].text_field.set (puzzle[row][cell])
        end
      end
  end

end