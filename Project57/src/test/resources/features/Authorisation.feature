@Smoke
@Check_Authorisation
  Feature: Check positive and negative authorisation

    Background:
      Given I'm on start page 57
      And I click link 'authorisation'
      And I see page for authorisation

      @Check_positive_authorisation
      Scenario Outline: 001 Check authorisation with valid data
        When I click on the Name field
        And I enter name "<name>"
        And I click on the Password field
        And I enter password "<password>"
        And I click on the button 'enter'
        Then I get a page of user
        And I click on the button 'exit'
        Examples:
        | name | password |
        |Gosha |123qwerty |

        @Check_negative_authorisation
        Scenario Outline: 002 Check authorisation with invalid data
          And I click on the Name field
          And I enter invalid name "<name>"
          And I click on the Password field
          And I enter invalid password "<password>"
          And I click on the button 'enter'
          Then I get an error massage
          Examples:
          | name | password |
          |123qw |123qwerty |
          |ololo |12345678  |
          |Roman |Ivanov    |



