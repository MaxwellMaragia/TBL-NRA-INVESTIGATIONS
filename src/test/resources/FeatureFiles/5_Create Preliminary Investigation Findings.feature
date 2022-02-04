Feature: Create Preliminary Investigation Findings

  @CREATE
  Scenario: Verify the Process of Create Preliminary Investigation Findings and submit
    Given Open CRM URL Module as "Investignoff1"
    And Close Popup Window
    And Click on Case management dropdown
    And click on Queues
    Then switch to frame0
    And enters Investigations reference number in search results
    Then Click on reference number
    Then Investigation status should be "Investigation Approved"
    Then Click create preliminary Investigation findings
    Then Add Investigation start date and end date
    Then Add visits
    Then Add preliminary findings conclusion
    Then Submit Investigation case
    Then Investigation status should be "Pending Preliminary Investigation Approval"