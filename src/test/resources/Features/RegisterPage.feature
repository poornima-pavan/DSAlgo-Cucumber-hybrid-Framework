@tag
Feature: Registration link

  @TS_register_01
  Scenario Outline: User enters  valid username and password
    Given User launches Register Page.
    When User enters details.
      | username         | password   | password confirmation |
      | frame21@test.com | @dsalgo224 | @dsalgo224           |
    Then clicks on register button and should land in homepage.

  Scenario Outline: User enters  invalid username and password
    Given User launches Register Page.
    When User enters partial  data <username> ,<password> and <password confirmation>
    Then user should not be allowed to register.

    Examples: 
      | username          | password          | password confirmation |
      | frame10@test.com  | frame10@test.com  |    frame10@test.com   |
      | test              |                   | hello                 |
      | test              | testers           |                       |
