Feature: Hotel Booking on Adactin

  @SmokeTest
  Scenario: Logon to the Website
    Given I am on the Adactin Hotel login page
    When I log in with username "Shree1995" and password "Sreeramani"
    Then I verifies the new page contains expected URL
    And I verifies the new page contains expected text
    And I verifies log out button is Displayed on the page
    When I search for a hotel with location "London" and hotel "Hotel Creek"
    When I select the Room Type "Standard" and Number of Rooms "1"
    Then I select the Check In Date "20/09/2024" and Check Out Date "22/09/2024"
    And I select the Adults per Room "1" and Children per Room "0"
    Then I verifies the new page contains expected book URL
    When I enter the firstname "Shree" and lastname "Govindaraj"
    Then I enter the Billing Address "1st street abc city xyz country"
    And I enter the Credit Card No "1234567892365487"
    And I select the Credit Card Type "Master Card"
    Then I select the Expiry Date Month "March" and Year "2029"
    And I enter the CVV Number "098"
    Then I verifies the new page contains expected booking URL
    And I retrieve the booking Order No
    When I input the retrieve order no into Search Order ID
    Then I verify the final page and take a screenshot






