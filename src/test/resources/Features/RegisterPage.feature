@tag
Feature: Registration link

  @TS_register_01
  Scenario Outline: User enters  valid username and password
    Given User launches Register Page.
    When User enters username "username" ,"password" and "password confirmation".
      | username        | password   | password confirmation |
      | frame4@test.com | @dsalgo104 | @dsalgo104           |
    Then clicks on register button and should land in homepage.

  Scenario Outline: User enters  invalid username and password
    Given User launches Register Page.
    When User enters partial  data "<username>" "<password>" "<password confirmation>"
    Then It should display an error "Please fill out this field."

    Examples: 
      | username        | password   | password confirmation |
      | frame3@test.com | @dsalgo102 |    @dsalgo109         |
      #| test            |            | hello                 |
      #| test            | testers    |                       |
