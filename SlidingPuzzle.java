import java.util.Scanner;

/*Class for sliding puzzle game extends from base game
* class*/
public class SlidingPuzzle extends Game {
    public SlidingPuzzle(Board board, Player player) {
        super(board, player);
    }

    /*Play the sliding puzzle game*/
    public void Play(Scanner scanner) {
        board.PlaySlideGame(scanner, player);
    }

    /*Get name of game
    * returns: the name of game which is Sliding Puzzle*/
    public String GetGameName() {
        return "Sliding Puzzle";
    }
}
