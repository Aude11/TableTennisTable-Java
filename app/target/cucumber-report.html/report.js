$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/Game.feature");
formatter.feature({
  "name": "Game",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Empty League",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "the league has no players",
  "keyword": "Given "
});
formatter.match({
  "location": "tabletennistable.GameSteps.givenTheLeagueHasNoPlayers()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I print the league",
  "keyword": "When "
});
formatter.match({
  "location": "tabletennistable.GameSteps.whenIPrintTheLeague()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should see \"No players yet\"",
  "keyword": "Then "
});
formatter.match({
  "location": "tabletennistable.GameSteps.iShouldSeeString(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "On Going League",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "the league has 3 players",
  "keyword": "Given "
});
formatter.match({
  "location": "tabletennistable.GameSteps.givenTheLeagueHas3Players()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I record win \"Bob Alice\"",
  "keyword": "When "
});
formatter.match({
  "location": "tabletennistable.GameSteps.whenIRecordWin(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should see \"Bob\" win",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "name": "On Going League",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "the league has 3 players",
  "keyword": "Given "
});
formatter.match({
  "location": "tabletennistable.GameSteps.givenTheLeagueHas3Players()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I record win \"Bob Alice\"",
  "keyword": "When "
});
formatter.match({
  "location": "tabletennistable.GameSteps.whenIRecordWin(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should see \"Bob\" winner",
  "keyword": "Then "
});
formatter.match({
  "location": "tabletennistable.GameSteps.iShouldSeeWinner(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
});