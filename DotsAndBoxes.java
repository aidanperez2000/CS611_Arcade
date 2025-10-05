import java.util.Scanner;

/*Class for Dots and Boxes game extends from base game
* class*/
public class DotsAndBoxes extends Game {
    public DotsAndBoxes(Board board, Player player) {
        super(board, player);
    }

    /*Plays the dots and boxes game
    * TODO: implement dots and boxes game*/
    public void Play(Scanner scanner) {
        System.out.println("This is the dots and boxes game.  This needs to be implemented");
    }

    /*Get name of game
    * returns: name of game which is dots and boxes*/
    public String GetGameName() {
        return "Dots and Boxes";
    }
}
