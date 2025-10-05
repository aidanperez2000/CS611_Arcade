import java.util.Scanner;

/*Main program which plays game user selects*/
public class Main {

    /*Main method for playing game
     * args: arguments, not used so will be ignored*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Welcome to the Game Arcade!");
            System.out.println("Let's play! To begin, enter your desired height for your board.");
            int height = scanner.nextInt();
            System.out.println("Enter your desired width.");
            int width = scanner.nextInt();
            Board board = new Board(height, width);

            // Game choosing
            System.out.println("Which game do you want to play?");
            System.out.println("[1] - Sliding Puzzle");
            System.out.println("[2] - Dots and Boxes");
            int gameChoice = scanner.nextInt();
            scanner.nextLine();

            Game game = null;

            if (gameChoice == 1) {
                // 滑块游戏 - 单人
                System.out.println("Player, what is your name?");
                String name = scanner.nextLine();
                Player player = new Player(name);
                game = new SlidingPuzzle(board, player);

            } else if (gameChoice == 2) {
                // Dots and Boxes - 双人
                System.out.println("Player 1, what is your name?");
                String name1 = scanner.nextLine();
                Player player1 = new Player(name1, 2); // ID = 1

                System.out.println("Player 2, what is your name?");
                String name2 = scanner.nextLine();
                Player player2 = new Player(name2, 3); // ID = 2

                game = new DotsAndBoxes(board, player1, player2);

            } else {
                System.out.println("Invalid game selection. Please select 1 or 2.");
                return;
            }

            if (game != null) {
                game.Play(scanner);
            }

        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}