@example
Feature: Cucumber Examples

A set of scenarios to illustrate some basic usage with Cucumber and Gherkin

Scenario: Navigate to Cucumber home page
	Given navigate to cucumber home page
	When link with "View Docs" title is clicked
	Then page is displayed with header text "Cucumber Docs"