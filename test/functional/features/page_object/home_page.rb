require 'page-object'

class HomePage
  include PageObject

  link(:play, :name => 'play')
  link(:create, :name => 'create')
  link(:solver, :name => 'solver')

  page_url "http://localhost:8080/SudokuGrailsApp"

end