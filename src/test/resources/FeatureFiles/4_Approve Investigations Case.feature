Feature: Approve Investigations Plan

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
    And clicks Approve from the dropdown
    Then switch to frame1
    And enters manager comments "Manager test comment"
    And Click on Save button
    Then Investigation status should be "Investigation Approved"