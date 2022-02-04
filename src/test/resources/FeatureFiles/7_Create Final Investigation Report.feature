Feature: Create Final Investigation Report

  @CREATE
  Scenario: Verify the Process of Create Final Investigation Report and submit
    Given Open CRM URL Module as "Investignoff1"
    And Close Popup Window
    And Click on Case management dropdown
    And click on Queues
    Then switch to frame0
    And enters Investigations reference number in search results
    Then Click on reference number
    Then Investigation status should be "Preliminary Investigation Approved"
    Then Click create final Investigation report
    Then Enter notes and comments
    Then Click on manager assessment
    Then Add assessment for PAYE
    Then Submit Investigation case
    Then Investigation status should be "Pending Reporting Investigation Approval"