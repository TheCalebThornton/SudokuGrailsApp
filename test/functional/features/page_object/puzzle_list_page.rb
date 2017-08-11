require 'page-object'

class PuzzleListPage
  include PageObject

  link(:search, :name => 'search')
  select_list(:difficulty, :name => 'difficulty')
  table(:puzzle_list, :name => 'puzzleList')

end