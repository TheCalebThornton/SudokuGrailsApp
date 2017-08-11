require 'page-object'

class CongratulationsPage
  include PageObject

  h1('grats', :id => 'grats')
  h1('score', :id => 'score')

end