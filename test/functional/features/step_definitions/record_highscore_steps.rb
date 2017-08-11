require "watir-webdriver"

Given /^there is a puzzle to play$/ do
  @title = Faker::Name.title
  @author = Faker::Name.first_name
  @difficulty = 'Easy'
  @puzzle = [
      ['0','0','0','1','0','0','0','4','0'],
      ['1','9','5','0','0','8','0','0','0'],
      ['3','4','0','0','2','0','1','0','9'],
      ['0','0','0','9','1','0','5','0','0'],
      ['6','0','9','8','0','2','4','0','7'],
      ['0','0','1','0','3','4','0','0','0'],
      ['2','0','8','0','4','0','0','7','1'],
      ['0','0','0','7','0','0','8','3','2'],
      ['0','1','0','0','0','9','0','0','0']
  ]
  @solution = [
      ['8','2','6','1','9','3','7','4','5'],
      ['1','9','5','4','7','8','3','2','6'],
      ['3','4','7','5','2','6','1','8','9'],
      ['4','8','2','9','1','7','5','6','3'],
      ['6','3','9','8','5','2','4','1','7'],
      ['5','7','1','6','3','4','2','9','8'],
      ['2','6','8','3','4','5','9','7','1'],
      ['9','5','4','7','6','1','8','3','2'],
      ['7','1','3','2','8','9','6','5','4']
  ]
  create_puzzle(@puzzle, @title, @author)
end

When /^I complete the puzzle faster than anyone else$/ do
  go_to_play_sudoku
  select_last_puzzle('Easy')
  solve_puzzle(@solution)
  @score = get_score_from_grats
end

Then /^my highscore is recorded$/ do
  go_to_play_sudoku
  expect(get_puzzle_highscore(@title, @author, @difficulty)).to eq (@score)
end