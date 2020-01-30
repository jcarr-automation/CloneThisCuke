@example
Feature: Cucumber Examples

A set of scenarios to illustrate some basic usage with Cucumber and Gherkin

Scenario: Navigate to Cucumber home page
	Given navigate to cucumber home page
	When "view docs" button is clicked
	Then cucumber docs page is displayed