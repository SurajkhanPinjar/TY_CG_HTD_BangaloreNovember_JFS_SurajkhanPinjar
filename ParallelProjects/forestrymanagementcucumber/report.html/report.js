$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("com/capgemini/forestrymanagementcucumber/runner/Feature.feature");
formatter.feature({
  "line": 1,
  "name": "Testing Google",
  "description": "",
  "id": "testing-google",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 4,
  "name": "",
  "description": "Search In Google",
  "id": "testing-google;",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 6,
  "name": "Opening in google",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "Searching In google",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "closing google",
  "keyword": "Then "
});
});