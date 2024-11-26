Feature: SalesCampaign
  Background: 

    Then user navigate the url  "https://login.salesforce.com/?locale=in"
  @salescamp
  Scenario Outline: creating a campaign
    Given I login with username "<username>" and password "<password>"
    And I navigate to the saleconsole tab
    When User selecting the campaign from the sale dropdown
    Then I am creating a campaign with proper "<campaign>" name
    And User verifies the newly created campaign


    
    Examples:
    | username               | password    |campaign
    | saniga@testhouse.com   | Sobhs@890   | Flash
    