Feature: Using credit card to pay
  A kiosk located in a station. The user inserts the credit card and the kiosk reads the credit card number 
  and it verifies if the credit card is valid. 
  
  Background: 
   
    Given a kiosk at station "Norreport St"

  Scenario: Successfully verified: The three checks are met
   
    Given a credit card with number "378282246310005"
   
    When the kiosk verifies the credit card
   
    Then the kiosk informs the user that the provided credit card is valid


  Scenario: Unsuccesfully verified: The credit card number contains characters

    Given a credit card with number "3782822463100aa"

    When the kiosk verifies the credit card

    Then the kiosk informs the user that the provided credit card is invalid because it contains characters

  Scenario: Unsuccesfully verified: The credit card number has too few digits

    Given a credit card with number "55561"

    When the kiosk verifies the credit card

    Then the kiosk informs the user that the provided credit card is invalid because it has too few digits

  Scenario: Unsuccesfully verified: The credit card number does not belong to a company provider

    Given a credit card with number "13211111111111111"

    When the kiosk verifies the credit card

    Then the kiosk informs the user that the provided credit card because it does not belong to a company provider
    
