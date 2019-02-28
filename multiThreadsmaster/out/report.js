$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("scen.feature");
formatter.feature({
  "line": 1,
  "name": "Person operation",
  "description": "",
  "id": "person-operation",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Create a list of 100 persons",
  "description": "",
  "id": "person-operation;create-a-list-of-100-persons",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "I have a Stream with person supplier initialized",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "I call stream to create a list of 100 persons",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "I have list with 100 persons",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "line": 8,
  "name": "Create a list of persons with given names",
  "description": "",
  "id": "person-operation;create-a-list-of-persons-with-given-names",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 9,
  "name": "I have a list of users:",
  "rows": [
    {
      "cells": [
        "name",
        "lastName"
      ],
      "line": 10
    },
    {
      "cells": [
        "John",
        "Doe"
      ],
      "line": 11
    },
    {
      "cells": [
        "Jan",
        "Kowalski"
      ],
      "line": 12
    },
    {
      "cells": [
        "Anna",
        "Kowalska"
      ],
      "line": 13
    }
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 14,
  "name": "I get first user",
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "I get:",
  "rows": [
    {
      "cells": [
        "name",
        "lastName"
      ],
      "line": 16
    },
    {
      "cells": [
        "John",
        "Doe"
      ],
      "line": 17
    }
  ],
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});