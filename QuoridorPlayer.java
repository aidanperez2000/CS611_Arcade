/*Class for managing Quoridor players*/
public class QuoridorPlayer extends Player {
    public QuoridorPlayer(String name, int id) {
        super(name, id);
        wallsRemaining = 10;
    }
    private int wallsRemaining;

    /*Get the number of walls remaining that
    * a player has
    * return: number of walls remaining*/
    public int GetWallsRemaining() {
        return wallsRemaining;
    }

    /*Set number of walls remaining to value
    * wallsRemaining: number of walls remaining to set*/
    public void SetWallsRemaining(int wallsRemaining) {
        this.wallsRemaining = wallsRemaining;
    }
}
