Feature: Checking out with travel card
  		A travel card user can check-out at any checkout automaton

  Background: 
   
    Given a travel card with a balance of 100

  Scenario: Successful check-out
   
    Given a travel card with check-in status is true
   
    And a check-in automaton at "Norreport St"
   
    And a check-out automaton at "Sydhavn St"
   
    When a travel card check-out
   
    Then the travel card after check-out has a new balance 75
   
    And the check-out automaton displays a message that "the travel card is successfully checked-out"
   
    And the check-out automaton posts a successful message on the system log 
  
  Scenario: Unsuccesful check-out: Not checked-in
   
    Given a travel card with check-in status is false
   
    And a check-out automaton at "Sydhavn St"
   
    When a travel card check-out
   
    Then the check-out automaton displays a message that "the travel card is not checked-in"
   
    And the travel card after check-out has a new balance 100
