Feature: [SUC:28-07]-Create Investigations Case
  Background:
    Given User navigates to the login page
    Then Enters the username "tripsuser" and password "Passw0rd" to login

  @SUC:28-07 @UAT_M6_28-07-02 @UAT_M6_28-07-02
  Scenario: UAT_M6_28-07-02-Verify The Process of Create Investigations Case
    And Click on investigations > Create Investigation Case
    Then Enter case title
    Then Select suspicion type as "Analysis"
    Then Enter suspicion reason
    Then Enter suspicion offence as "Business misinformation"
    Then Enter suspicion description as "Gave false information"
    Then Select Information Source as previously saved
    Then Select Suspect as previously saved
    Then Save Investigations Case
    Then Verify success message "Processing Completed - Reference Number"
    Then Obtain Investigations Case ref number "Processing Completed - Reference Number"


