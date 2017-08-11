require 'page-object'
require 'watir-webdriver'
require 'faker'

def go_to_play_sudoku
  visit_page HomePage
  on_page HomePage do |page|
    page.play
  end
end

def go_to_create_sudoku
  visit_page HomePage
  on_page HomePage do |page|
    page.create
  end
end

def go_to_solver
  visit_page HomePage
  on_page HomePage do |page|
    page.solver
  end
end

def create_puzzle (puzzle, title, author)
  go_to_create_sudoku
  on_page CreateSudokuPage do |page|
    page.title_element.set (title)
    page.author_element.set(author)
    page.enter_puzzle(puzzle)
    page.create
  end
end

def get_puzzle_info
  on_page PlaySudokuPage do |page|
    puzzle_info = page.author
    puzzle_info += page.title
    return puzzle_info
  end
end

def get_puzzle
  on_page PlaySudokuPage do |page|
    puzzle = Array.new(9) { Array.new(9) }
    for row in 0..8
      for col in 0..8
        puzzle[row][col] = page.sudoku_grid_element[row][col].text_field.value
      end
    end
    return puzzle
  end
end

def select_last_puzzle (difficulty)
  on_page PuzzleListPage do |page|
    page.difficulty_element.select_value(difficulty)
    page.puzzle_list_element.trs[-1].tds[0].link.click
  end
end

def get_puzzle_difficulty
  on_page PlaySudokuPage do |page|
    return page.difficulty
  end
end

def solve_puzzle (solution)
  on_page PlaySudokuPage do |page|
    page.solve(solution)
    page.submit
  end
end

def get_congratulations
  on_page CongratulationsPage do |page|
    return page.grats
  end
end

def get_score_from_grats
  on_page CongratulationsPage do |page|
    return page.score
  end
end

def get_error_message
  on_page CreateSudokuPage do |page|
    return page.error
  end
end

def get_puzzle_highscore (title, author, difficulty)
  on_page PuzzleListPage do |page|
    page.difficulty_element.select_value(difficulty)
    page.puzzle_list_element.tbody.trs.each do |row|
      if row.tds[1].text == author && row.tds[0].text == title
        return row.tds[3].text
      end
    end
  end
  return "Couldn't find puzzle"
end

def submit_puzzle_to_solver (puzzle)
  on_page SolverPage do |page|
    page.enter_puzzle(puzzle)
    page.solve
  end
end

def get_solution
  on_page SolverPage do |page|
    solution = Array.new(9) { Array.new(9) }
    for row in 0..8
      for col in 0..8
        solution[row][col] = page.sudoku_grid_element[row][col].text_field.value
      end
    end
    return solution
  end
end