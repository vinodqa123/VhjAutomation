Feature: Verify Login feature
 
  Scenario: Verify login with valid credenitals
    Given User is on Login page
    When User entered UserName & password 
    Then User should be on Home Page