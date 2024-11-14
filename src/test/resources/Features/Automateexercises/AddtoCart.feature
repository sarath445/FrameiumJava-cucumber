Feature: Add the items to the Cart
  @t
  Scenario Outline: : Adding product to the cart

    Then User opens Url "https://www.automationexercise.com/"
    Then  User is on the login page
    When user click on signup button
    Then User enters "<username>" and "<password>"
    Then User verify the category name
    #And User storing the elements as List
    Then User have added items to the cart
    And User verify the SuccessfulAdded message
    Then User hit on continue button




    Examples:
      | username                             |password|
      | sarath.sobhitharaj@testhouse.net     |Sobhs@500|
