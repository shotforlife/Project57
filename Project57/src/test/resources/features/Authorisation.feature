@Smoke
@Check_Authorization
  Feature: Check positive and negative authorization

    Background:
      Given I'm on start page of internet site '57'

      @Check_positive_authorization @Positive
      Scenario Outline: 001 Check authorization according to the available data
        When I click link "<authorization>"
        And I see page for authorization that has title authorization profile
        When I click on the Name field
        And I enter name "<name>"
        And I click on the Password field
        And I enter password "<password>"
        And I click on the "<enter>" button
        Then I get a page of user that has title "<name>"
        And I click on the "<exit>" button
        Examples:
        | name | password | enter | exit |authorization|
        |Gosha |123qwerty |Enter  | Exit |Authorization|

        @Check_negative_authorization @Negative
        Scenario Outline: 002 Check authorization according to nonexistent data
          When I click link "<authorization>"
          And I see page for authorization that has title authorization profile
          And I click on the Name field
          And I enter invalid name "<name>"
          And I click on the Password field
          And I enter invalid password "<password>"
          And I click on the "<enter>" button
          Then I get an error massage
          Examples:
          | name | password |enter|authorization|
          |123qw |123qwerty |Enter|Authorization|
          |ololo |12345678  |Enter|Authorization|
          |Roman |Ivanov    |Enter|Authorization|



