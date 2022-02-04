Feature: [SUC:28-04]-Maintain Information Source
  Background:
    Given User navigates to the login page
    Then Enters the username "tripsuser" and password "Passw0rd" to login

  @SUC:28-04 @UAT_M6_28-04-01
  Scenario: UAT_M6_28-04-01-Verify the Fields in Create Information Source
    And Click on investigations > Mantain information source
    Then Maintain Information Source screen should be displayed with the following fields and buttons
    Then click new button
    Then Verify fields in Create Information Source

  @SUC:28-04 @UAT_M6_28-04-02 @UAT_M6_28-04-03 @UAT_M6_28-04-04 @UAT_M6_28-04-05 @UAT_M6_28-04-06
  Scenario: UAT_M6_28-04-02-Verify the Process of Create Information Source
    And Click on investigations > Mantain information source
    Then click new button
    Then Enter Information source as "Customs Border Protection"
    Then Enter source reliability as "Always Reliable"
    Then Enter confidentiality level as "Confidential"
    Then Enter name as random number
#    Then Enter tin as "C0022970"
    Then Enter address as "Utawala"
    Then Enter phone number as "0707338839"
    Then Enter email as random
    Then Save information source
    Then Verify success message "Processing Completed - Reference Number"
    Then Obtain information source ref number "Processing Completed - Reference Number"
    And Click on investigations > Mantain information source
    Then Enter reference number
    Then Click search
    Then Click edit button
    Then Enter name as random number
    Then Save information source
    Then Verify success message "Processing Completed - Reference Number"
    Then Obtain information source ref number "Processing Completed - Reference Number"
    And Click on investigations > Mantain information source
    Then Enter reference number as wrong
    Then Click search
    Then Verify no data is found in table
    Then click new button
    Then Save information source
    Then Verify error message "Information Source: Validation Error: Value is required."
    Then Verify error message "Source Reliability: Validation Error: Value is required."
    Then Verify error message "Confidential Level: Validation Error: Value is required."
    Then Verify error message "Name: Validation Error: Value is required."
    Then Verify error message "Address: Validation Error: Value is required."
    Then Enter Information source as "Customs Border Protection"
    Then Enter source reliability as "Always Reliable"
    Then Enter confidentiality level as "Confidential"
    Then Enter duplicate name
    Then Enter address as "Utawala"
    Then Enter phone number as "0707338839"
    Then Enter duplicate email
    Then Save information source
    Then Verify error message "Information Source with the specified Name and Email is already exists"
    


