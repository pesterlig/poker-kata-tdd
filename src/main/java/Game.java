public class Game {

    private int gameNumber;
    private String blackName;
    private String[] blackCardCodes;
    private String whiteName;
    private String[] whiteCardCodes;

    public Game(int gameNumber, String blackName, String[] blackCardCodes, String whiteName, String[] whiteCardCodes) {
        this.gameNumber = gameNumber;
        this.blackName = blackName;
        this.blackCardCodes = blackCardCodes;
        this.whiteName = whiteName;
        this.whiteCardCodes = whiteCardCodes;
    }

    public Game() {
    }

    public int getGameNumber() {
        return gameNumber;
    }

    public void setGameNumber(int gameNumber) {
        this.gameNumber = gameNumber;
    }

    public String getBlackName() {
        return blackName;
    }

    public void setBlackName(String blackName) {
        this.blackName = blackName;
    }

    public String[] getBlackCardCodes() {
        return blackCardCodes;
    }

    public void setBlackCardCodes(String[] blackCardCodes) {
        this.blackCardCodes = blackCardCodes;
    }

    public String getWhiteName() {
        return whiteName;
    }

    public void setWhiteName(String whiteName) {
        this.whiteName = whiteName;
    }

    public String[] getWhiteCardCodes() {
        return whiteCardCodes;
    }

    public void setWhiteCardCodes(String[] whiteCardCodes) {
        this.whiteCardCodes = whiteCardCodes;
    }
}
