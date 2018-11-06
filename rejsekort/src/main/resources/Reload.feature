Feature: Reload the balance in a travel card
  A travel card user can reload the balance of a travel card in a kiosk
  using a verified credit card.

  Scenario: Successfully reload  travel card balance
  
    Given a travel card user at a reload kiosk at station "Norreport St"
  
    And his travel card has a balance of 50
  
    And his credit card "378282246310005" was successfully verified by the reload kiosk
  
    And his credit card accepts to charge 100      
  
    When the travel card user reloads the travel card with 100
  
    Then the travel card after reload has a new balance 150
  
    And the credit card is charged with 100
  
    And the reload kiosk displays a message that the travel card was reloaded successfully
  
    And the reload kiosk posts that message on the system log 

    
