import java.util.Scanner;

/*Class for Quoridor game*/
public class Quoridor extends Game {
    public Quoridor(QuoridorBoard board, QuoridorPlayer player1, QuoridorPlayer player2) {
        super(board, player1);
        this.player2 = player2;
    }

    QuoridorPlayer player2;
    /*Play the Quoridor game:
    * scanner: scanner for input*/
    public void Play(Scanner scanner) {
        System.out.println("Welcome to Quoridor!");
    }
}
