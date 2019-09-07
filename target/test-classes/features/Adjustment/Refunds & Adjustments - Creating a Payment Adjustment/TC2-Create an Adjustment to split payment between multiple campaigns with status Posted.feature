Feature: Adjustments flow

  Scenario Outline: Create an Adjustment to change Campaign/Appeal details

    Given I login to Salesforce URL
    When I click on Contacts tag
    And I click on Recently Viewed dropdown Select List View
    And I select "All Contacts" from the list view
    And I type the contact "Sandy B Pulsford" in the Search box and press Enter to view the particular contact detail
    And I click on the searched contact name
    And I click the Opportunities button
    And I click on Opportunities name Sandy B Pulsford FR000013 Donation link
    And I click on "Related" Tab
    And I click on Payment
#    And I click on Paid CheckBox with click on Edit Paid option
#    And I select Payment Date from payment date 2019-09-27
#    And I click on Save button
    And I click "Adjustment" radio button
    And I click "Adjust Campaign/Product" radio button
    And I Provide the Campaign Name,Amount and Reason following details
      | Campaign Name   | Amount   | Reason   |
      | <Campaign Name> | <Amount> | <Reason> |

    And I click add button
    And I Provide the Campaign Name,Amount and Reason following details
      | Campaign Name   | Amount   | Reason   |
      | <Campaign Name> | <Amount> | <Reason> |

#    And I provide details Chargeback Bank Action,Chargeback Received On and Chargeback Reference Number
#      | Chargeback Bank Action | Chargeback Received On | Chargeback Reference Number |
#      | <Chargeback Bank Action> | <Chargeback Received On> | <Chargeback Reference Number> |
#    And I select on Adjustment's "Make Adjustment" button

    Then I verify message "Success<new_line>Adjustment has been done successfully for the record. You may check by going to the adjustment record." generated
    Examples:
      | Campaign Name        | Amount | Reason |
      | Campaign Finish Line | 50     | Other  |