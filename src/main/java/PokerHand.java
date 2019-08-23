import enums.Card;
import enums.Rank;
import enums.Suit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class PokerHand {
    private String handName;
    private ArrayList<Card> cards;

    public PokerHand(String handName, String[] cardCodes) {
        this.handName = handName;
        this.cards = new ArrayList<>();
        Arrays.asList(cardCodes).forEach(cardCode -> cards.add(Card.findByCode(cardCode)));
    }

    public String getHandName() {
        return handName;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }
}