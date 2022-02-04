Feature: Approve Preliminary Investigations Findings

  @CREATE
  Scenario: Verify the Process of Approve Preliminary Investigation Findings
    Given Open CRM URL Module as "Investignmangr1"
    And Close Popup Window
    And Click on Case management dropdown
    And click on Queues
    Then switch to frame0
    And enters Investigations reference number in search results
    And click checkbox in case number
    And click pick button dropdown
    Then switch to frame0
    Then Click on reference number
    Then Investigation status should be "Pending Preliminary Investigation Approval"
    Then switch to frame1
    And wait for plan to load "Suspicion Type"
    Then switch to frame1
    And clicks Approve from the dropdown
    Then switch to frame1
    And enters preliminary approver comments "Approver test comment"
    And Click on Save button
    Then Investigation status should be "Preliminary Investigation Approved"