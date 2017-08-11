require "watir-webdriver"

When /^I enter my unsolved sudoku puzzle$/ do
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
  @title = Faker::Name.title
  @author = Faker::Name.first_name
  create_puzzle(@puzzle, @title, @author)
end

Then /^I can see my puzzle has been added to the list of puzzles$/ do
  select_last_puzzle('Easy')
  expect(get_puzzle_info).to include(@title,@author)
  expect(get_puzzle).to eq(@puzzle)
end