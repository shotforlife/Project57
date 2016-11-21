@ST_4203 @Smoke @Check_Sorting_Of_Processors @Positive
Feature: Check descending and ascending sorting

Background: 

Given I'm on start page of internet site '57'
And I click link 'processor AMD'
And I see page of goods 'processor AMD'
And I click on the 'stock' link

@SC_27701 @Check_descending_sorting
Scenario: 001 Check descending prise
When I click on the 'descending' link
Then I check that prices of products are in descending order

@SC_27702 @Check_ascending_sorting
Scenario: 002 Check ascending price
When I click on the 'ascending' link
Then I check that prices of products are in ascending order