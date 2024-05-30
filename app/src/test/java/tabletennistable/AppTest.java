package tabletennistable;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.mockito.Mockito.verify;

public class AppTest {
    @Mock
    LeagueRenderer renderer;

    @Mock
    FileService fileService;

    @Mock
    League leagueMock;

    @BeforeEach
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testPrintsCurrentState()
    {
        initMocks();
        League league = new League();
        Mockito.when(renderer.render(league)).thenReturn("Rendered League");

        App app = new App(league, renderer, null);

        Assert.assertEquals("Rendered League", app.sendCommand("print"));
    }

    @Test
    public void testAddPlayer()
    {
        initMocks();
        App app = new App(leagueMock, renderer, null);

        Assert.assertEquals("Added player Alice", app.sendCommand("add player Alice"));
        verify(leagueMock).addPlayer("Alice");
    }

    @Test
    public void testRecordWinAliceBob()
    {
        initMocks();
        App app = new App(leagueMock, renderer, null);

        Assert.assertEquals("Recorded Alice win against Bob", app.sendCommand("record win Alice Bob"));
        verify(leagueMock).recordWin("Alice", "Bob");
    }

    @Test
    public void testWinner()
    {
        initMocks();
        Mockito.when(leagueMock.getWinner()).thenReturn("Alice");

        App app = new App(leagueMock, renderer, null);

        Assert.assertEquals("Alice", app.sendCommand("winner"));
    }

    @Test
    public void testSave()
    {
        initMocks();
        //Mockito.when(leagueMock.getWinner()).thenReturn("Alice");

        App app = new App(leagueMock, renderer, fileService);

        Assert.assertEquals("Saved path", app.sendCommand("save path"));
        verify(fileService).save("path", leagueMock);
    }

    @Test
    public void testLoad()
    {
        initMocks();
        //Mockito.when(leagueMock.getWinner()).thenReturn("Alice");

        App app = new App(leagueMock, renderer, fileService);

        Assert.assertEquals("Loaded path", app.sendCommand("load path"));
        verify(fileService).load("path");
    }

}

