Feature: As a Supporter Services User I need to initiate the refund approval for a supporter
  So that the appropriate donation/gifts are refunded or sent for further approval


  Scenario Outline: The user should be able to save the record successfully with incomplete fields
    Given I login to Salesforce URL
    When I click on Contacts tag
    And I click on Recently Viewed dropdown Select List View
    And I select "All Contacts" from the list view
    And I type the contact "Samaira" in the Search box and press Enter to view the particular contact detail
    And I click on the searched contact name
    And I click the Opportunities button
    And I click on Opportunities name Samaira Malhotra FR00009 Donation link
    And I click on "Related" Tab
    And I click on Payment
    And I click "Refund" radio button
    And I provide the following details Case Origin,Refund Type,Subject,Status,Refund Amount,Refund Instrument,Bank Account No and Bank BSB
      | Case Origin | Refund Type | Subject | Status | Refund Amount | Refund Instrument | Bank Account No | Bank BSB |
      | <Case Origin> | <Refund Type> | <Subject> | <Status> | <Refund Amount> | <Refund Instrument> | <Bank Account No> | <Bank BSB> |

#    And I select on Refund "Save" button
    Then I verify message "Success /n Refund process initiated." ganerated


    Examples:
      | Case Origin | Refund Type | Subject | Status | Refund Amount | Refund Instrument | Bank Account No | Bank BSB |
      | Email | Full | Refund For sally den PMT-01963 | Open | 10  | Bank Deposit | 2901928653 | 203946 |


