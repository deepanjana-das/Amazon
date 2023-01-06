$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/Feature/Amazon.feature");
formatter.feature({
  "name": "Amazon shopping Feature",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Ordering an item in Amazon",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@SmokeSuite"
    }
  ]
});
formatter.step({
  "name": "User is on Amazon landing page on hitting \"\u003camazonUrl\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "name": "User clicks on sign in tab",
  "keyword": "When "
});
formatter.step({
  "name": "User logs in by providing \"\u003cuserid\u003e\" and \"\u003cpassword\u003e\"",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "amazonUrl",
        "userid",
        "password",
        "item-text",
        "quantityNumber"
      ]
    },
    {
      "cells": [
        "https://www.amazon.in/",
        "deepanjana.cse@gmail.com",
        "pinki123",
        "saree",
        "1"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Ordering an item in Amazon",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@SmokeSuite"
    }
  ]
});
formatter.step({
  "name": "User is on Amazon landing page on hitting \"https://www.amazon.in/\"",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDef.Steps.AmazonLandingStep(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User clicks on sign in tab",
  "keyword": "When "
});
formatter.match({
  "location": "StepDef.Steps.AmazonSignInStep()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User logs in by providing \"deepanjana.cse@gmail.com\" and \"pinki123\"",
  "keyword": "And "
});
formatter.match({
  "location": "StepDef.Steps.UserProvidesCredentialStep(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
});