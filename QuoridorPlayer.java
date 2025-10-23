/*Class for managing Quoridor players*/
public class QuoridorPlayer extends Player {
    public QuoridorPlayer(String name) {
        super(name);
        wallsRemaining = 10;
    }
    private int wallsRemaining;
}
