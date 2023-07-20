package test;

import main.LinksGame;
import main.LinksGameModel;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LinksGameImplTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    private final LinksGame linksGame = new LinksGame();

    @Before
    public final void before() {
        System.setOut(new PrintStream(outputStream));
    }

    private LinksGameModel initLinkedList() {
        LinkedList<Integer> links = new LinkedList<>();
        links.add(1);
        links.add(2);
        links.add(3);
        return new LinksGameModel(links);
    }

    @Test
    public void shouldReturnLeftLink() {
        int leftLinkActual = linksGame.getLinkValue(initLinkedList(), "First");
        int leftLinkExpected = initLinkedList().getLinkedList().getFirst();
        assertEquals(leftLinkActual, leftLinkExpected);
    }

    @Test
    public void shouldReturnRightLink() {
        int rightLinkActual = linksGame.getLinkValue(initLinkedList(), "Last");
        int rightLinkExpected = initLinkedList().getLinkedList().getLast();
        assertEquals(rightLinkActual, rightLinkExpected);
    }

    @Test
    public void shouldReturnPlayerTwoWon() {
        LinksGameModel linksGameModel = initLinkedList();
        linksGameModel.setPlayerOneScore(5);
        linksGameModel.setPlayerTwoScore(20);
        linksGame.getFinalScore(linksGameModel);

        assertEquals("Player Two won!\n" +
                        "Player 1 Score: 5\n" +
                        "Player 2 Score: 20",
                outputStream.toString()
                        .trim());
    }

    @Test
    public void shouldReturnPlayerOneWon() {
        LinksGameModel linksGameModel = initLinkedList();
        linksGameModel.setPlayerOneScore(27);
        linksGameModel.setPlayerTwoScore(25);
        linksGame.getFinalScore(linksGameModel);

        assertEquals("Player One won!\n" +
                        "Player 1 Score: 27\n" +
                        "Player 2 Score: 25",
                outputStream.toString()
                        .trim());
    }

    @Test
    public void shouldReturnTieGame() {
        LinksGameModel linksGameModel = initLinkedList();
        linksGameModel.setPlayerOneScore(27);
        linksGameModel.setPlayerTwoScore(27);
        linksGame.getFinalScore(linksGameModel);

        assertEquals("Tie game!\n" +
                        "Player 1 Score: 27\n" +
                        "Player 2 Score: 27",
                outputStream.toString()
                        .trim());
    }

    @Test
    public void shouldReturnLinkedList_WithCorrectSizeAndValues() {
        LinkedList<Integer> links = LinksGame.createLinks();
        assertTrue(links.size() != 0);
        links.forEach(link -> {
            assertTrue(link >= -100 && link <= 100);
        });
    }
}