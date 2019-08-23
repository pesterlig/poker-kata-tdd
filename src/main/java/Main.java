public class Main {

    public static void main(String[] args) {

        String[] blackHandCodes = new String[]{"2H", "9D", "5S", "3C", "KD"};
        String[] whiteHandCodes = new String[]{"4C", "3H", "2S", "8C", "AH"};
        Game game = new Game(1,"Black", blackHandCodes,"White", whiteHandCodes);
        PokerHand blackPokerHand = new PokerHand(game.getBlackName(),game.getBlackCardCodes());
        System.out.println(blackPokerHand);

    }
}
