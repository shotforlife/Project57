@Smoke
@Purchase
Feature: Check that user can buy some product

  Background:
    Given I get the list of some products

  @AddingToBasket @DeletingFromBasket @High
  Scenario Outline: 001 Check that product added in the basket when user buy it
    When I click on Buy button "<count>" times on some products
    And I go in the basket
    And I see that the basket have "<count>" product
    And I put the checkmark into field 'delete' when "<count>" bigger than zero
    And I click on button 'update' when "<count>" bigger than zero
    Then I see the message "В Вашей корзине нет товаров."
    Examples:
      | count |
      | 0     |
      | 1     |
      | 2     |
      | 3     |

  @BasketBug @High
  Scenario Outline: 002 Check that count of products in the basket are correct from main page of 57shop
    When I click on Buy button "<count>" times on some products
    And I go in the basket
    And I see that the basket have "<count>" product
    Then From main page in basket title I see "<count>" of products
    Examples:
      | count |
      | 3     |

