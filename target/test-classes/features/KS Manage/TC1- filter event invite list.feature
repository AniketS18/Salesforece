Feature: KS Manage Event invite List


  Scenario Outline: Filter event invite list
    Given I login to Salesforce URL
    When I click on Contacts tag
    And I click on Recently Viewed dropdown Select List View
    And I select "All Contacts" from the list view
    And I type the contact "Andrew J McKnight" in the Search box and press Enter to view the particular contact detail
    And I click on the searched contact name
    And I click on "Activity" Tab
    And I clicked on New Event tab
    And I Provide the following details Assigned to,Subject,People and Related To under New Event Page
      | Assigned to   | Subject   | People   | Related To   |
      | <Assigned to> | <Subject> | <People> | <Related To> |
    And I click on Save button
    When I click on Reports tag



    Examples:
      | Assigned to    | Subject | People         | Related To          |
      | Bheem Kattikar | Email   | Bheem Kattikar | McKnight Household |
