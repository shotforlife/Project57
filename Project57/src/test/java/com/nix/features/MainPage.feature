@MainPage
Feature: Check the main links of the main page

  Background:
    Given I am on '57' start page

  Scenario Outline: 001 Check Products link
    When I click on "<type>" button
    Then I see the correct "<name>" of the page
    Examples:
      | type        | name                                             |
      | Logo        |   http://www.57.kharkov.ua/                      |
      | Basket      |   http://www.57.kharkov.ua/cart                  |
      | Srvc        |   http://www.57.kharkov.ua/servicecentres.html   |
      | Delivery    |   http://www.57.kharkov.ua/delivery.html         |
      | Contacts    |   http://www.57.kharkov.ua/contacts.html         |
      | Service     |   http://www.57.kharkov.ua/service.html          |
      | Question    |   http://www.57.kharkov.ua/ask.html              |
      | Parts       |   http://www.57.kharkov.ua/catalog/parts         |
      | Computers   |   http://www.57.kharkov.ua/catalog/notebooks     |
      | Periphery   |   http://www.57.kharkov.ua/catalog/perifery      |
      | Personal    |   http://www.57.kharkov.ua/catalog/personal      |
      | TV          |   http://www.57.kharkov.ua/catalog/70392         |
      | Houshold    |   http://www.57.kharkov.ua/catalog/tech          |
      | Other       |   http://www.57.kharkov.ua/catalog/other         |
      | Credit      |   http://www.57.kharkov.ua/credit.html           |
      | Social      |   https://vk.com/comp57                          |