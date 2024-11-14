Feature: Login Automation exercise

    @y
    Scenario Outline: Login to Automation exercise
      Then User opens Url "https://www.automationexercise.com/"
      When User is on the login page
      When user click on signup button
      Then User enters "<username>" and "<password>"

      Examples:
      | username                             |password|
      | sarath.sobhitharaj@testhouse.net     |Sobhs@500|



