Feature: Verify Chargeback Processed is not allowed if Chargeback SST Response field is empty. Chargeback already initiated
  As a Salesforce user, login to Salesforce and Searching Payment Records with Chargeback Request

  Scenario Outline: Verify Chargeback Processed is not allowed if Chargeback SST Response field is empty
    Given I login to Salesforce URL
    When I click on Contacts tag
    And I click on Recently Viewed dropdown Select List View
    And I select "All Contacts" from the list view
    And I type the contact "Stephnie Meyer" in the Search box and press Enter to view the particular contact detail
    And I click on the searched contact name
    And I click the Opportunities button
    And I click on Opportunities name Stephnie Meyer 123 Donation link
    And I click on "Related" Tab
    And I click on Payment
    #And I click Chargeback radio button under Payment Type
    And I provide values in Chargeback Bank Action,Chargeback Received On,Chargeback Reference Number,Chargeback Response By,Chargeback Actual Response Date,Chargeback SST Response and Chargeback Bank Final Notification Date fields
      | Chargeback Bank Action   | Chargeback Received On   | Chargeback Reference Number   | Chargeback Response By   | Chargeback Actual Response Date   | Chargeback SST Response   | Chargeback Bank Final Notification Date   |
      | <Chargeback Bank Action> | <Chargeback Received On> | <Chargeback Reference Number> | <Chargeback Response By> | <Chargeback Actual Response Date> | <Chargeback SST Response> | <Chargeback Bank Final Notification Date> |
    And I select on Chargeback "Save" button
  #  And I click on Opportunity Name Joey Tribi FR00009 Donation under Details tab
    And I clicked Payments link
  # And I click on Payment Number
  # And I scroll down to page
    Then I verify Error messsage "Error For chargeback processing all fields are mandatory"

    Examples:
      | Chargeback Bank Action | Chargeback Response By | Chargeback Actual Response Date | Chargeback SST Response | Chargeback Bank Final Notification Date |
      | Chargeback processed   | 2019-08-30             | 2019-08-30                      |                         | 2019-08-30                              |
