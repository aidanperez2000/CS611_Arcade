import java.util.Scanner;

/*Main program which plays game user selects*/
public class Main {

    /*Main method for playing game
    * args: arguments, not used so will be ignored*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Let's play!  To begin, enter your desired height for your board.");
            int height = scanner.nextInt();
            System.out.println("Enter your desired width.");
            int width = scanner.nextInt();
            Board board = new Board(height, width);
            System.out.println("Player, what is your name?");
            String name = scanner.next();
            Player player = new Player(name);
            Game game;
            Game[] games = { new SlidingPuzzle(board, player), new DotsAndBoxes(board, player) };
            System.out.println("Which game do you want to play?");
            for (int i = 0; i < games.length; i++){
                int gameSelection = i + 1;
                System.out.println("[" + gameSelection + "] - " + games[i].GetGameName());
            }
            int gameToPlay = scanner.nextInt();
            scanner.nextLine();
            if (gameToPlay < 1 || gameToPlay > games.length) {
                System.out.println("Invalid game selection. Please select from one of the available options.");
            }
            else {
                game = games[gameToPlay - 1];
                game.Play(scanner);
            }
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}