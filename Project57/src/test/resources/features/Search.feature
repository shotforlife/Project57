@Smoke
@Search
Feature: Check that a search is working correctly

  Background:
    Given Get '57 shop' start page

  @ValidKeys @Medium @Positive
  Scenario Outline: 001 Check search valid keys
    When I enter the search "<keyword>"
    And I click 'search' button
    Then I see that page contains results with my "<keyword>"
    Examples:
      | keyword      |
      | ноутбук      |
      | ASUS         |
      | ноутбук asus |
      | мышь         |
      | клавиатура   |


  @InvalidKeys @Mediun @Negative
  Scenario Outline: 002 Check search invalid keys
    When I enter the search "<keyword>"
    And I click 'search' button
    Then I see that page contains a message "Ничего не найдено"
    Examples:
      | keyword  |
      | ahahahhh |
      | 23hf3    |
      | арппви   |
