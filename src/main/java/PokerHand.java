import enums.Card;
import enums.Rank;
import enums.Suit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class PokerHand {

    private String handName;
    private String pokerHandType = "Undetermined";
    private ArrayList<Card> cards;

    public PokerHand(String handName, String[] cardCodes) {
        this.handName = handName;
        this.cards = new ArrayList<>();
        Arrays.asList(cardCodes).forEach(cardCode -> cards.add(Card.findByCode(cardCode)));
    }

    public void checkForFlush() {
        for (int i = 0; i < 4; i++) {
            if ((getCards().get(i).getSuit()).equals(getCards().get(i + 1).getSuit())) {
                setPokerHandType("FLUSH");
            }
        }
    }

    public void checkForStraight() {
        //also accounts for straight flush
        int count = 0;

        for (int i = 0; i < 4; i++) {
            int elementValue = getCards().get(i).getRank().value;
            int nextElementValue = getCards().get(i + 1).getRank().value;

            if (elementValue + 1 == nextElementValue) {
                count++;
            }

            if ((count == 4) | ((count == 3) && (nextElementValue == 14))) {
                if (getPokerHandType().equals("FLUSH")) {
                    setPokerHandType("STRAIGHT_FLUSH");
                } else {
                    setPokerHandType("STRAIGHT");
                }
            }
        }
    }




    public String getPokerHandType() {
        return pokerHandType;
    }

    public void setPokerHandType(String pokerHandType) {
        this.pokerHandType = pokerHandType;
    }

    public String getHandName() {
        return handName;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }
}
