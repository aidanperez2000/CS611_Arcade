/*Class which contains data about the player playing the game*/
public class Player {
    public Player(String playerName) {
        PlayerName = playerName;
    }
    private final String PlayerName;
    private int PlayerScore = 0;

    /*Get the name of the player
    * returns: name of player*/
    public String GetPlayerName() {
        return PlayerName;
    }

    /*add to the current player score
    * score: score to add*/
    public void AddScore(int score) {
        PlayerScore = PlayerScore + score;
    }

    /*Get the player's score
    * returns: player's score*/
    public int GetScore() {
        return PlayerScore;
    }
}
