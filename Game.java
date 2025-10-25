import java.util.Scanner;

/* Base game class other games inherit from */
public abstract class Game {
    public Game(Board board) {
        this.board = board;
    }

    public Game(Board board, Player player) {
        this.board = board;
        this.player = player;
    }
    protected Board board;
    protected Player player;

    /* Base play method for playing the game
    * scanner: scanner for input*/
    public abstract void Play(Scanner scanner);
}
