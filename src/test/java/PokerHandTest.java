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
    public void testSortHandAscending(){
        String[] blackHand = new String[]{"2H", "9D", "5S", "3C", "KD"};
        String[] whiteHand = new String[]{"AC", "3H", "2S", "8C", "4H"};
        game = new Game(1, "Black", blackHand, "White", whiteHand);
        pokerHand = new PokerHand(game.getWhiteName(), game.getWhiteCardCodes());
        pokerHand = new PokerHand(game.getBlackName(), game.getBlackCardCodes());


    }

    @Test
    public void testCheckForFlushWithFlush() {
        String[] blackFlush = new String[]{"2H", "9H", "5H", "3H", "KH"};
        String[] whiteHand = new String[]{"4C", "3H", "2S", "8C", "AH"};
        game = new Game(1, "BlackFlush", blackFlush, "White", whiteHand);
        pokerHand = new PokerHand(game.getBlackName(), game.getBlackCardCodes());
        pokerHand.checkForFlush();
        assertEquals("A Flush hand sets pokerHandType to FLUSH", "FLUSH", pokerHand.getPokerHandType());
    }

    @Test
    public void testCheckForFlushWithNoFlush() {
        String[] blackFlush = new String[]{"2H", "9H", "5H", "3H", "KH"};
        String[] whiteHand = new String[]{"4C", "3H", "2S", "8C", "AH"};
        game = new Game(1, "BlackFlush", blackFlush, "White", whiteHand);
        pokerHand = new PokerHand(game.getWhiteName(), game.getWhiteCardCodes());
        pokerHand.checkForFlush();
        assertEquals("A non-Flush hand does not set pokerHandType to FLUSH", "Undetermined", pokerHand.getPokerHandType());
    }

    @Test
    public void testCheckForStraightWithStraightFlush() {
        String[] blackStraightFlush = new String[]{"2H", "3H", "4H", "5H", "6H"};
        String[] whiteHand = new String[]{"4C", "3D", "2S", "8C", "AH"};
        game = new Game(1, "BlackStraightFlush", blackStraightFlush, "White", whiteHand);
        pokerHand = new PokerHand(game.getBlackName(), game.getBlackCardCodes());
        pokerHand.checkForFlush();
        pokerHand.checkForStraight();
        assertEquals("A Straight Flush hand sets pokerHandType to STRAIGHT_FLUSH", "STRAIGHT_FLUSH", pokerHand.getPokerHandType());
    }

    @Test
    public void testFindValueOfHighestRankDuplicates() {
        String[] blackFullHouse = new String[]{"6D", "5C", "5D", "5H", "6H"};
        String[] whiteHand = new String[]{"4C", "3D", "2S", "8C", "AH"};
        game = new Game(1, "BlackThreeOfAKind", blackFullHouse, "White", whiteHand);
        pokerHand = new PokerHand(game.getBlackName(), game.getBlackCardCodes());
        //pokerHand.checkForFlush();
        //pokerHand.checkForStraight();
        //want to create a hashmap that contains the rank of the duplicates as the key, and the count of duplicates as the value

        assertEquals("Passed a pair of sixes and three fives, the value of the duplicates of Highest Rank is 6.", 6, pokerHand.findValueOfHighestRankDuplicates());
    }

  }
