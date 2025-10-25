/*QuoridorPlayer class extends Player with additional Quoridor-specific functionality*/
public class QuoridorPlayer extends Player {
    private int wallsRemaining;
    private int xPos;
    private int yPos;
    private final int targetRow;

    /*Constructor for QuoridorPlayer
     * name: player name
     * playerId: unique player identifier*/
    public QuoridorPlayer(String name, int playerId) {
        super(name, playerId);
        this.wallsRemaining = 10; // Each player starts with 10 walls

        // Set initial positions and target rows based on player ID
        if (playerId == CellValue.PLAYER_1.ordinal()) {
            this.xPos = 4; // Middle of 9x9 board (0-indexed)
            this.yPos = 0; // Top row
            this.targetRow = 8; // Bottom row
        } else {
            this.xPos = 4; // Middle of 9x9 board (0-indexed) 
            this.yPos = 8; // Bottom row
            this.targetRow = 0; // Top row
        }
    }

    /*Get number of walls remaining*/
    public int GetWallsRemaining() {
        return wallsRemaining;
    }

    /*Use a wall (decrease count by 1)*/
    public void UseWall() {
        if (wallsRemaining > 0) {
            wallsRemaining--;
        }
    }

    /*Check if player has walls remaining*/
    public boolean HasWallsRemaining() {
        return wallsRemaining > 0;
    }

    /*Get player's current X position*/
    public int GetXPos() {
        return xPos;
    }

    /*Get player's current Y position*/
    public int GetYPos() {
        return yPos;
    }

    /*Set player's position*/
    public void SetPosition(int x, int y) {
        this.xPos = x;
        this.yPos = y;
    }

    /*Get the target row for this player to win*/
    public int GetTargetRow() {
        return targetRow;
    }

    /*Check if player has reached their target row*/
    public boolean HasWon() {
        return yPos == targetRow;
    }
}