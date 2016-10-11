@Smoke
@MainPage
Feature: Check the main links of the main page

  Background:
    Given I am on '57 shop' start page

  Scenario Outline: 001 Check Products link
    When I click on "<type>" button to go to another page
    Then I see the correct "<name>" of the page
    Examples:
      | type      | name                  |
      | Logo      | Новые поступления     |
      | Basket    | Корзина               |
      | Srvc      | Сервисные центры      |
      | Delivery  | Доставка и оплата     |
      | Contacts  | Контакты              |
      | Service   | Услуги                |
      | Question  | Задать вопрос         |
      | Parts     | Комплектующие         |
      | Computers | Компьютеры            |
      | Periphery | Периферия             |
      | Personal  | Личная техника        |
      | TV        | ТВ, фото, аудио/видео |
      | Houshold  | Бытовая техника       |
      | Other     | Разное                |
      | Credit    | Рассрочка             |
      | Social    | Компьютеры 57         |
