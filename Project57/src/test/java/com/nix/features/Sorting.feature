@Check_Sorting_Of_Processors
  Feature: Check descending and ascending sorting

    Background:
      Given I'm on start page 57
      And I click link 'processor AMD'
      And I see page of goods 'processor AMD'

      @Check_descending_sorting
      Scenario: 001 Check descending prise
      When I click on the 'descending' link
      And I check that prise of first product more than prise of second product
      Then I check that prise of second product more than prise of third product

      @Check_descending_sorting
        Scenario: 002 Check ascending price
        When I click on the 'ascending' link
        And I check that prise of first product less than prise of second product
        Then I check that prise of second product less than prise of third product
