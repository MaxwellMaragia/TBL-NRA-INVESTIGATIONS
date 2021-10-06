Feature: [SUC:28-05]-Maintain Suspect
  Background:
    Given User navigates to the login page
    Then Enters the username "tripsuser" and password "Passw0rd" to login

  @SUC:28-05 @UAT_M6_28-05-01
  Scenario: UAT_M6_28-04-01-Verify the Fields in Create Suspect
    And Click on investigations > Maintain suspect
    Then Maintain Suspect screen should be displayed with the following fields and buttons
    Then Click add new suspect
    Then Verify fields in create suspect

  @SUC:28-05 @UAT_M6_28-05-02
  Scenario: UAT_M6_28-04-02-Verify the Process of Create Suspect
    #check validation
    And Click on investigations > Maintain suspect
    Then Click add new suspect
    Then Save suspect
    Then Verify error message "First Name: Validation Error: Value is required."
    Then Verify error message "Last Name: Validation Error: Value is required."
    Then Verify error message "Suspect Type: Validation Error: Value is required."
    Then Verify error message "Suspect Reason: Validation Error: Value is required."
    Then Verify error message "Review Date: Validation Error: Value is required."
    Then Verify error message "Address: Validation Error: Value is required."
    #check validation end
    #create suspect
    Then Enter suspect first name as random
    Then Enter suspect second name as random
    Then Enter suspect type as "Individual"
    Then Enter suspect reason as "3rd Party Information"
    Then Enter review date
    Then Enter suspect address as "Utawala"
    Then Enter suspect email as random
    Then select suspect method of contact as email
    Then Save suspect
    Then Verify success message "Suspect has been successfully saved - Reference Number"
    Then Obtain suspect ref number "Suspect has been successfully saved - Reference Number"
    #create suspect end
    #duplicate suspect validation
    And Click on investigations > Maintain suspect
    Then Click add new suspect
    Then Enter suspect first name
    Then Enter suspect second name
    Then Enter suspect type as "Individual"
    Then Enter suspect reason as "3rd Party Information"
    Then Enter review date
    Then Enter suspect address as "Utawala"
    Then Enter suspect email
    Then select suspect method of contact as email
    Then Save suspect
    Then Verify error message "Suspect already exist."
    #duplicate suspect validation end
    #suspect not found
    And Click on investigations > Maintain suspect
    Then search for suspect with invalid data
    Then Verify no data is found in table
    #suspect not found end
    #modify suspect
    Then Search for suspect
    Then Click edit suspect button
    Then modify suspect first name
    Then Save suspect
    Then Verify success message "Suspect has been successfully saved - Reference Number"
    Then Obtain suspect ref number "Suspect has been successfully saved - Reference Number"
    #modify suspect end