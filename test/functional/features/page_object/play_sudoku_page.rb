require 'page-object'

class PlaySudokuPage
  include PageObject

  table(:sudoku_grid, :id => 'puzzleGrid')
  button(:submit, :id => 'submit')
  span(:author, :id => 'author')
  span(:title, :id => 'title')
  span(:difficulty, :id => 'difficulty')


  def solve (solution)
    for row in 0..8
      for col in 0..8
        cell = sudoku_grid_element[row][col].text_field
          if(cell.enabled?)
              cell.value = (solution[row][col])
          end
      end
    end
  end

end