Feature: Setup the system
  
  To Setup the system the following steps are executed: 
  * Initialize a log file recording system actions
  
  Scenario: Successfully verified: The three checks are met
  
    Given a manager wants to setup the system with the log file "Logfile.txt"
   
    When setup
    
    And the log file "Logfile.txt" recording system actions is generated