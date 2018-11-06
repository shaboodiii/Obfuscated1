Feature: Create a new Travel Card
  			A customer wants to purchase a travel card and provides a userID number.
  			The userID number is evaluated if it exists in the system.

  Background: 
   
    Given a customer at a registration kiosk at station "Copenhagen Airport St"
   
    And his credit card "378282246310005" was successfully verified by the registration kiosk

  Scenario: Successfully create a Travel Card 
   
    Given a userID number "123456-7890" is not registered in the system
   
    And his credit card accepts to charge the amount of 100
   
    When issue a travel card
   
    Then a travel card user is registered
   
    And the registration kiosk displays a message that a travel card is issued
   
    And the registration kiosk posts that message on the system log 

  Scenario: Unsuccessfully create a Travel Card - credit card does not have enough balance

    Given a userID number "123456-7890" is not registered in the system

    But his credit card declines to charge the amount of 100

    When issue a travel card

    Then the registration kiosk displays a message that a travel card not issued because credit card was declined

  Scenario: Unsuccessfully create a Travel Card - user already registered in the system

    Given a userID number "123456-7890" is registered in the system

    When issue a travel card

    Then the registration kiosk displays a message that a travel card not issued because user already registered in the system
