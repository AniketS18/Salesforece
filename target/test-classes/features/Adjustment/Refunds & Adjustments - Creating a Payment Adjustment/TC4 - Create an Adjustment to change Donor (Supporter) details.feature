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
    And I click "Adjust Contact" radio button
    And I provide Primary Contact Name Abc
    And I select on Adjustment's "Adjust Contact" button
    Then I verify message "Success<new_line>Supporter has been changed on the Donation" generated
    When I click on Contacts tag
    And I click on Recently Viewed dropdown Select List View
    And I select "All Contacts" from the list view
    And I type the contact "Sandy B Pulsford" in the Search box and press Enter to view the particular contact detail
    And I click on the searched contact name
    And I click on "Related" Tab
    And I click the Opportunities button

    Examples:
      | Campaign Name        | Amount | Reason |
      | Campaign Finish Line | 50     | Other  |