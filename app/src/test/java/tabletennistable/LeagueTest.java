package tabletennistable;

import org.hamcrest.core.IsCollectionContaining;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LeagueTest {

    @Test
    public void testAddPlayerNewGame()
    {
        // Given a new game
        League league = new League();

        // When new player
        league.addPlayer("Bob");

        // Then
        List<LeagueRow> rows = league.getRows();
        Assert.assertEquals(1, rows.size());
        List<String> firstRowPlayers = rows.get(0).getPlayers();
        Assert.assertEquals(1, firstRowPlayers.size());
        Assert.assertThat(firstRowPlayers, IsCollectionContaining.hasItem("Bob"));
    }

    @Test
    public void testAddPlayerInOnGoingLeagueNewValidPlayerAddsAtBottom()
    {
        // Given
        League league = new League();
        league.addPlayer("A");

        // When
        league.addPlayer("NewPlayer");

        // Then
        List<LeagueRow> rows = league.getRows();
        Assert.assertEquals(2, rows.size());
        List<String> lastRowPlayers = rows.get(1).getPlayers();
        Assert.assertEquals(1, lastRowPlayers.size());
        Assert.assertThat(lastRowPlayers, IsCollectionContaining.hasItem("NewPlayer"));
    }


    @Test
    public void testAddPlayerInOnGoingLeagueWith2PlayersNewValidPlayerAddsAtBottom()
    {
        // Given
        League league = new League();
        league.addPlayer("A");
        league.addPlayer("B");

        // When
        league.addPlayer("C");
        List<LeagueRow> rows = league.getRows();
        List<String> lastRowPlayers = rows.get(1).getPlayers();

        // Then

        Assert.assertEquals(2, rows.size());
        Assert.assertEquals(2, lastRowPlayers.size());
        Assert.assertThat(lastRowPlayers, IsCollectionContaining.hasItem("C"));
    }


    @Test
    public void testAddPlayerInOnGoingLeagueNewInvalidPlayerNotAdded()
    {
        // Given game with 2 players A and B
        League league = new League();
        league.addPlayer("A");
        league.addPlayer("B");

        // When adding invalid name
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> league.addPlayer("C!!"));
        List<LeagueRow> rows = league.getRows();
        List<String> lastRowPlayers = rows.get(1).getPlayers();

        //Then
        Assert.assertEquals("Player name C!! contains invalid", exception.getMessage());
        assertFalse(lastRowPlayers.contains("C!!"));

    }

    @Test
    public void testAddPlayerInOnGoingLeagueNotUniquePlayerNotAdded()
    {
        // Given game with 2 players A and B
        League league = new League();
        league.addPlayer("A");
        league.addPlayer("B");

        // When adding existed player
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> league.addPlayer("A"));
        List<LeagueRow> rows = league.getRows();
        List<String> lastRowPlayers = rows.get(1).getPlayers();

        // Then player not added and message throws
        Assert.assertEquals("Cannot add player A because they are already in the game", exception.getMessage());
        assertFalse(lastRowPlayers.contains("A"));
    }

    @Test
    public void testRecordWinSuccess()
    {
        // Given game with 2 players A and B and A win
        League league = new League();
        league.addPlayer("A");
        league.addPlayer("B");

        // When B, 1 line above A, won
        league.recordWin("B", "A");
        List<LeagueRow> rows = league.getRows();
        List<String> firstRowPlayers = rows.get(0).getPlayers();
        List<String> lastRowPlayers = rows.get(1).getPlayers();

        // Then
        Assert.assertThat(firstRowPlayers, IsCollectionContaining.hasItem("B"));
        Assert.assertThat(lastRowPlayers, IsCollectionContaining.hasItem("A"));
    }

    @Test
    public void testRecordWinFailWinnerNotInGame()
    {
        // Given game with 2 players A and B and A win
        League league = new League();
        league.addPlayer("A");
        league.addPlayer("B");

        // When adding existed player
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> league.recordWin("BB", "A"));

        Assert.assertEquals("Player BB is not in the game", exception.getMessage());
    }

    @Test
    public void testRecordWinFailLoserNotInGame()
    {
        // Given game with 2 players A and B and A win
        League league = new League();
        league.addPlayer("A");
        league.addPlayer("B");

        // When adding existed player
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> league.recordWin("B", "AA"));

        Assert.assertEquals("Player AA is not in the game", exception.getMessage());
    }


    @Test
    public void testRecordWinFail()
    {
        // Given game with 2 players A and B and A win
        League league = new League();
        league.addPlayer("A");
        league.addPlayer("B");
        league.addPlayer("C");
        league.addPlayer("D");


        // When adding existed player
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> league.recordWin("A", "D"));

        Assert.assertEquals("Cannot record match result. Winner A must be one row below loser D", exception.getMessage());
    }

    @Test
    public void testGetWinnerSuccess()
    {
        // Given a new game
        League league = new League();
        league.addPlayer("A");
        league.addPlayer("B");
        league.recordWin("B","A");
        league.recordWin("A","B");
        // Then
        Assert.assertEquals("A", league.getWinner());
    }

    @Test
    public void testGetWinnerSuccessNewWinner()
    {
        // Given a new game
        League league = new League();
        league.addPlayer("A");
        league.addPlayer("B");
        league.recordWin("B","A");
        // Then
        Assert.assertEquals("B", league.getWinner());
    }

    @Test
    public void testGetWinnerEmptyGameReturnsNull()
    {
        // Given a new game
        League league = new League();

        // Then
        Assert.assertNull(league.getWinner());
    }

}
