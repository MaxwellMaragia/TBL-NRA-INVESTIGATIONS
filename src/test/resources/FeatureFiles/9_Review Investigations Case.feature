Feature: Create Investigations Case
  Background:
    Given User navigates to the login page
    Then Enters the username "tripsuser" and password "Passw0rd" to login

  @CREATE
  Scenario: Verify The Process of Create Investigations Case
    And Click on investigations > Create Investigation Case
    Then Enter case title
    Then Select suspicion type as "Analysis"
    Then Enter suspicion reason
    Then Enter suspicion offence as "Business misinformation"
    Then Enter suspicion description as "Gave false information"
    Then Click Add Information source button
    Then Enter Information source as "Informant"
    Then Enter source reliability as "Always Reliable"
    Then Enter confidentiality level as "Confidential"
    Then Enter name as random number
    Then Enter address as "Utawala"
    Then Enter phone number as "0707338839"
    Then Enter email as random
    Then Save information source
    Then Switch to default
    Then Click Add Suspect button
    Then Switch to backoffice frame
    Then Save suspect
    Then Verify error message "First Name: Validation Error: Value is required."
    Then Verify error message "Last Name: Validation Error: Value is required."
    Then Verify error message "Suspect Reason: Validation Error: Value is required."
    Then Verify error message "Review Date: Validation Error: Value is required."
    Then Verify error message "Address: Validation Error: Value is required."
    Then Enter suspect first name as random
    Then Enter suspect second name as random
#    Then Enter suspect type as "Individual"
    Then Enter suspect reason as "3rd Party Information"
    Then Enter review date
    Then Enter suspect address as "Utawala"
    Then Enter suspect email as random
    Then select suspect method of contact as email
    Then Save suspect
    Then Switch to default
    Then Save Investigations Case
    Then Verify success message "Processing Completed - Reference Number"
    Then Obtain Investigations Case ref number "Processing Completed - Reference Number"

  @CREATE
  Scenario: Verify the Process of Assign Investigations Case to officer
    Given Open CRM URL Module as "Investignmangr1"
    And Close Popup Window
    And Click on Case management dropdown
    And click on Queues
    Then switch to frame0
    And enters Investigations reference number in search results
    And click checkbox in case number
    And click assign button
    Then Assign pop up is displayed
    And search team to assign
    And selects the team "Investigations Officer"
    Then Switch to default
    Then Assign pop up is displayed
    And assigns to the team or user

  @CREATE
  Scenario: Verify the Process of  Create Investigations Case and submit
    Given Open CRM URL Module as "Investignoff1"
    And Close Popup Window
    And Click on Case management dropdown
    And click on Queues
    Then switch to frame0
    And enters Investigations reference number in search results
    Then Click on reference number
    Then Click create Investigations case
    Then Fill in background information and investigation objectives
    Then Submit Investigation case
    Then Investigation status should be "Pending Investigation Approval"

  @CREATE
  Scenario: Verify the Process of Approve Investigations Plan
    Given Open CRM URL Module as "Investigationdir1"
    And Close Popup Window
    And Click on Case management dropdown
    And click on Queues
    Then switch to frame0
    And enters Investigations reference number in search results
    And click checkbox in case number
    And pick the case
    Then switch to frame0
    Then Click on reference number
    Then Investigation status should be "Pending Investigation Approval"
    Then switch to frame1
    And wait for plan to load "Suspicion Type"
    Then switch to frame1
    And clicks Review from the dropdown
    Then switch to frame1
    And enters manager comments "Manager test comment"
    And Click on Save button
    Then Investigation status should be "Investigation Approved"