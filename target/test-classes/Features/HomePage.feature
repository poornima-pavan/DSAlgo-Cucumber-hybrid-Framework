@tag
Feature: Home Page
  This feature has all the modules to get started and user registering and signing features

  @TS_HOMEPAGE_001
  Scenario: User should land in Home Page.
    Given User is on  Dsportal Page.
    When User clicks on the "Get Started" button.
    Then User should land in home page.

  @TS_HOMEPAGE_002
  Scenario: User clicks on Datastructure dropdown in home page,should list all the options.
  Given User is on home page.
  When User clicks on Datastructure dropdown.
  Then user should be able to see list all the options in the dropdown.
 
  @TS_HOMEPAGE_004
  Scenario: User is on Home page and clicks on Register link.
    Given User on Home page.
    When User clicks on Register link.
    Then user should land in Registration Page.

  
  @TS_HOMEPAGE_005
  Scenario: User is on Home page and clicks on Sign in link.
    Given User is on homepag.
    When User clicks on Sign in link.
    Then user should land in Login Page.

  @TS_HOMEPAGE_006
  Scenario Outline: User is on Home page without  signing in and clicking on Datastructure dropdown botton and selecting any option in the list.
    Given User enters home page.
    When User clicks on Datastructure dropdown and click on "<option>" in the list.
    Then user should get alert message.

    Examples: 
      | option |
      | Arrays |
      | Stack  |

  @TS_HOMEPAGE_007
  Scenario Outline: User is on Home page without signing in and clicking on "Get Started" button of any modules.
    Given User is on homepage.
    When User clicks on "Get Started" button of  any datastructures "<option>" in the HomePage.
    Then user should get alert message.

    Examples: 
      | option |
      | Arrays |
      | Stack  |
      
