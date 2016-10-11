@Smoke
@Purchase
  Feature: Check that user can buy some product

    Background:
      Given I get the list of some products

      @AddBasket
      Scenario Outline: 001 Check that product added in the basket when user buy it
        When I click on Buy button on some product
        Then I see that the basket have "<count>" product
        And From main page in basket title I see "<count>" of products
        Examples:
        | count    |
        |   1      |
        |   2      |
        |   3      |

        @DeleteBasket
        Scenario: 002 Check that user can delete products from basket
          When I am in the basket
          And I put the checkmark into field 'delete'
          And I click on button 'update'
          Then I see the message "В Вашей корзине нет товаров."

