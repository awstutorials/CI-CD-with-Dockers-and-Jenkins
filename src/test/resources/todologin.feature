Feature: ToDoApplication Login Feature

  Scenario Outline: Login
    Given A username name <name> and password <password>
    When tries to login to todo web application
    Then It should login <output>

    Examples:
      |	name	|	password	|	output		|
      |	in28minutes	|	dummy	    |	in28Minutes	|
      |	in28minutes	|	wrong	    |	failure	|