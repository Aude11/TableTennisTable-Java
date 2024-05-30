package tabletennistable;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class GameSteps {
    // Current app instance
    private App app;

    // Last response
    private String response;

    @Before
    public void createApp()
    {
        League league = new League();
        LeagueRenderer leagueRenderer = new LeagueRenderer();
        FileService fileService = new FileService();
        app = new App(league, leagueRenderer, fileService);
    }

    @Given("the league has no players")
    public void givenTheLeagueHasNoPlayers()
    {
        // Nothing to do - the default league starts with no players
    }

    @When("I print the league")
    public void whenIPrintTheLeague()
    {
        response = app.sendCommand("print");
    }

    @Then("I should see {string}")
    public void iShouldSeeString(String expected)
    {
        Assert.assertEquals(expected, response);
    }

    @Given("the league has 3 players")
    public void givenTheLeagueHas3Players()
    {
        app.sendCommand("add player Alice");
        app.sendCommand("add player Bob");
        app.sendCommand("add player Dan");
    }

    @When("I record win {string}")
    public void whenIRecordWin(String action)
    {
        app.sendCommand("record win " + action);
        response = app.sendCommand("winner");
    }

    @Then("I should see {string} win")
    public void iShouldSeeWinner(String expected)
    {
        Assert.assertEquals(expected, response);
    }



}
