Feature: Checking In with travel card
  A travel card user can check in at check-in automaton and use any kind of transportation (bus,train)


  Background: 
    
    Given a travel card with a balance of 100
    
    And a check-in automaton at "Norreport St"

  Scenario: Successfull check-in
   
    Given a travel card with check-in status is false
    
    When Check-in
    
    Then the check-in automaton displays a message that "the travel card is checked-in"
   
    And the check-in automaton posts that message in the system log
    
  Scenario: Unsuccessfull check-in : the travel card is already checked-in
   
    Given a travel card with check-in status is true
    
    When Check-in
    
    Then the check-in automaton displays a message that "the travel card is already checked-in"

  Scenario: Unsuccessfull check-in : the travel card has not enough balance
    
    Given a travel card with check-in status is false
    
    And a travel card with a balance of 15
    
    When Check-in
    
    Then the check-in automaton displays a message that "the travel card balance is too low"
