import enums.Card;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class PokerHandTest {

    /*
    Black: 2H 3D 5S 9C KD  White: 2C 3H 4S 8C AH
    Black: 2H 4S 4C 2D 4H  White: 2S 8S AS QS 3S
    Black: 2H 3D 5S 9C KD  White: 2C 3H 4S 8C KH
    Black: 2H 3D 5S 9C KD  White: 2D 3H 5C 9S KH
    */

    PokerHand pokerHand;
    Game game;

    @Before
    public void before() throws Exception {
        String[] blackHand = new String[]{"2H", "9D", "5S", "3C", "KD"};
        String[] whiteHand = new String[]{"4C", "3H", "2S", "8C", "AH"};
    }

    @After
    public void after() {
        pokerHand = null;
    }

    // newPokerHandCovertsStringsToCards
    @Test
    public void testGetCards() {
        String[] blackHand = new String[]{"2H", "9D", "5S", "3C", "KD"};
        String[] whiteHand = new String[]{"4C", "3H", "2S", "8C", "AH"};
        game = new Game(1, "Black", blackHand, "White", whiteHand);
        pokerHand = new PokerHand(game.getWhiteName(), game.getWhiteCardCodes());
        assertEquals("Convert Strings to Cards in the Pokerhand constructor 1 of 5", Card.CLUBS_FOUR, pokerHand.getCards().get(0));
        assertEquals("Convert Strings to Cards in the Pokerhand constructor 2 of 5", Card.HEARTS_THREE, pokerHand.getCards().get(1));
        assertEquals("Convert Strings to Cards in the Pokerhand constructor 3 of 5", Card.SPADES_TWO, pokerHand.getCards().get(2));
        assertEquals("Convert Strings to Cards in the Pokerhand constructor 4 of 5", Card.CLUBS_EIGHT, pokerHand.getCards().get(3));
        assertEquals("Convert Strings to Cards in the Pokerhand constructor 5 of 5", Card.HEARTS_ACE, pokerHand.getCards().get(4));
    }

    @Test
    public void testCheckForFlushWithFlush() {
        String[] blackFlush = new String[]{"2H", "9H", "5H", "3H", "KH"};
        String[] whiteHand = new String[]{"4C", "3H", "2S", "8C", "AH"};
        game = new Game(1, "BlackFlush", blackFlush, "White", whiteHand);
        pokerHand = new PokerHand(game.getBlackName(), game.getBlackCardCodes());
        assertTrue((pokerHand.checkForFlush() == true));
    }

    @Test
    public void testCheckForFlushWithNoFlush() {
        String[] blackFlush = new String[]{"2H", "9H", "5H", "3H", "KH"};
        String[] whiteHand = new String[]{"4C", "3H", "2S", "8C", "AH"};
        game = new Game(1, "BlackFlush", blackFlush, "White", whiteHand);
        pokerHand = new PokerHand(game.getWhiteName(), game.getWhiteCardCodes());
        assertTrue((pokerHand.checkForFlush() == false));
    }

    /*@Test
    public void testCheckForFlushWithNoFlush() {
        String[] blackFlush = new String[]{"2H", "9H", "5H", "3H", "KH"};
        String[] whiteHand = new String[]{"4C", "3H", "2S", "8C", "AH"};
        game = new Game(1, "BlackFlush", blackFlush, "White", whiteHand);
        pokerHand = new PokerHand(game.getWhiteName(), game.getWhiteCardCodes());
        assertTrue((pokerHand.checkForFlush() == false));
    }*/

    /*@Test
    public void testCheckForStraightWithStraightFlush() {
        String[] blackStraightFlush = new String[]{"2H", "3H", "4H", "5H", "6H"};
        String[] whiteHand = new String[]{"4C", "3D", "2S", "8C", "AH"};
        game = new Game(1, "BlackFlush", blackStraightFlush, "White", whiteHand);
        pokerHand = new PokerHand(game.getWhiteName(), game.getWhiteCardCodes());
        assertTrue((pokerHand.checkForStraight() == true));


    }*/

}
