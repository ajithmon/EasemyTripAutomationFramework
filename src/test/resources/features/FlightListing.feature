Feature: Validate Flight Listing Functionality

  Background:
    Given user open application
    Then verify user is on homepage
    When user click on Flight Tab
    Then verify flight search page is displayed

  @smoke
  Scenario: Verify Filter Functionality
    When user search flight with from city "flight.from.city" and to city "flight.to.city" with date "flight.date"
    Then verify user is on flight listing page
    When user select filter option "flight.filter.option"
    Then verify only "flight.filter.option" flights are displayed on the page

  @regression
  Scenario: Verify Round Trip tab activated after selecting return date
    When user select return date "flight.return.date"
    Then verify round trip tab is activated

  Scenario: Verify user can apply coupon
    When user search flight with from city "flight.from.city" and to city "flight.to.city" with date "flight.date"
    Then verify user is on flight listing page
    When user click on book now button
    Then verify user is on flight booking page
    When user apply coupon on flight
    Then verify coupon is applied and price changed
