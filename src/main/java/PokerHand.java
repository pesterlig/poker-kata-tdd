import enums.Card;
import enums.Rank;
import enums.Suit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class PokerHand {
    private String handName;

    private boolean isFlush;

    private ArrayList<Card> cards;

    public PokerHand(String handName, String[] cardCodes) {
        this.handName = handName;
        this.cards = new ArrayList<>();
        Arrays.asList(cardCodes).forEach(cardCode -> cards.add(Card.findByCode(cardCode)));
    }

    public boolean checkForFlush() {
        //boolean isFlush = false;
        for (int i = 0; i < 4; i++) {
            if ((getCards().get(i).getSuit()).equals(getCards().get(i + 1).getSuit())) {
                setFlush(true);
            }
        }

        return isFlush;
    }

    public boolean isFlush() {
        return isFlush;
    }

    public void setFlush(boolean flush) {
        isFlush = flush;
    }


    public String getHandName() {
        return handName;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }
}
