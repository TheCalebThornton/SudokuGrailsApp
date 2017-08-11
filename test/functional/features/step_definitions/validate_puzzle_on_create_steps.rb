require "watir-webdriver"

When /^an unsolvable puzzle is entered$/ do
  @puzzle = [
      ['0','0','0','1','0','0','0','0','0'],
      ['1','0','0','0','0','8','0','0','0'],
      ['0','0','0','0','2','0','0','0','0'],
      ['0','0','0','0','0','0','0','0','0'],
      ['0','0','0','0','0','0','4','0','7'],
      ['0','0','1','0','0','0','0','0','0'],
      ['2','0','0','0','0','0','0','0','0'],
      ['0','0','0','0','0','0','0','0','0'],
      ['0','1','0','0','0','9','0','0','0']
  ]
  @title = Faker::Name.title
  @author = Faker::Name.first_name
  create_puzzle(@puzzle, @title, @author)
end

Then /^an error message is displayed$/ do
  expect(get_error_message).to eq('There should be a minimum of 17 given values for any Sudoku puzzle')
end