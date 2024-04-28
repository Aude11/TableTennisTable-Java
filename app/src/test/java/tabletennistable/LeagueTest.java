package tabletennistable;

import org.hamcrest.core.IsCollectionContaining;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class LeagueTest {
    @Test
    public void testAddPlayer()
    {
        // Given
        League league = new League();

        // When
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
    public void testAddPlayerInOnGoingLeagueNewInvalidPlayerNotAdded()
    {
        // Given
        League league = new League();
        league.addPlayer("A");
        league.addPlayer("B");

        // When
        //league.addPlayer("A");

        // Then
        assertThrows(IllegalArgumentException.class,
                () -> league.addPlayer("A"));


//        List<LeagueRow> rows = league.getRows();
//        Assert.assertEquals(2, rows.size());
//        List<String> lastRowPlayers = rows.get(1).getPlayers();
//        Assert.assertEquals(1, lastRowPlayers.size());
//        Assert.assertThat(lastRowPlayers, IsCollectionContaining.hasItem("B"));
    }


}
