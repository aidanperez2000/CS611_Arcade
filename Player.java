/*Class which contains data about the player playing the game*/
public class Player {
    private final String PlayerName;
    private int PlayerScore = 0;
    private int PlayerId = 0; // 添加玩家ID字段

    public Player(String playerName) {
        PlayerName = playerName;
        PlayerId = 0; // 默认ID为0（向后兼容滑块游戏）
    }

    // 新增构造函数，支持指定玩家ID
    public Player(String playerName, int playerId) {
        PlayerName = playerName;
        PlayerId = playerId;
    }

    /*Get the name of the player
     * returns: name of player*/
    public String GetPlayerName() {
        return PlayerName;
    }

    /*Get the player ID
     * returns: player ID*/
    public int GetPlayerId() {
        return PlayerId;
    }

    /*Set the player ID (for existing players)
     * playerId: ID to assign to player*/
    public void SetPlayerId(int playerId) {
        this.PlayerId = playerId;
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

    /*Reset player score to zero*/
    public void ResetScore() {
        PlayerScore = 0;
    }
}