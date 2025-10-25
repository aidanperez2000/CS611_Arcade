import java.util.Scanner;

/*Main program which plays game user selects*/
public class Main {

    /*Main method for playing game
     * args: arguments, not used so will be ignored*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Welcome to the Game Arcade!");
            // Game choosing
            System.out.println("Which game do you want to play?");
            // List of available game names
            String[] gameNames = { "Sliding Puzzle", "Dots and Boxes", "Quoridor" };
            for (int i = 0; i < gameNames.length; i++) {
                int gameSelection = i + 1;
                System.out.println("[" + gameSelection + "] - " + gameNames[i]);
            }
            int gameChoice = -1;
            try {
                gameChoice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
            }
            Game game = null;
            if (gameChoice == 1)
                game = CreateSlidingPuzzle(scanner);
            else if (gameChoice == 2)
                game = CreateDotsAndBoxes(scanner);
            else if (gameChoice == 3)
                game = CreateQuoridor(scanner);
            else {
                System.out.println("Invalid choice. Try again.");
                return;
            }
            game.Play(scanner);

        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    /*Initialize the Sliding Puzzle Game with appropriate input
    * scanner: scanner for reading input
    * returns SlidingPuzzle game with board and player*/
    private static Game CreateSlidingPuzzle(Scanner scanner) {
        Board board = SetBoardFromInput(scanner);
        // 滑块游戏 - 单人
        System.out.println("Player, what is your name?");
        String name = scanner.nextLine();
        Player player = new Player(name);
        return new SlidingPuzzle(board, player);
    }

    /*Initialize Dots and Boxes game with appropriate input
    * scanner: scanner for reading input
    * returns DotsAndBoxes game with board and players*/
    private static Game CreateDotsAndBoxes(Scanner scanner) {
        Board board = SetBoardFromInput(scanner);
        // Dots and Boxes - 双人
        System.out.println("Player 1, what is your name?");
        String name1 = scanner.nextLine();
        Player player1 = new Player(name1, 2); // ID = 1

        System.out.println("Player 2, what is your name?");
        String name2 = scanner.nextLine();
        Player player2 = new Player(name2, 3); // ID = 2

        return new DotsAndBoxes(board, player1, player2);
    }

    /*Gets the height and width from user input and builds board
    * with provided height and width
    * scanner: scanner for reading input
    * returns: board of given height and width*/
    private static Board SetBoardFromInput(Scanner scanner) {
        System.out.println("Let's play! To begin, enter your desired height for your board.");
        int height = -1;
        int width = -1;
        try {
            height = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException ex) {
            System.out.println("Invalid input. Try again.");
        }
        System.out.println("Enter your desired width.");
        try {
            width = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException ex) {
            System.out.println("Invalid input. Try again.");
        }
        return new Board(height, width);
    }

    /*Initializes Quoridor game with given input
    * scanner: scanner for reading input
    * returns: Quoridor game with board and given players*/
    private static Game CreateQuoridor(Scanner scanner) {
        System.out.println("Player 1, what is your name?");
        String name1 = scanner.nextLine();
        QuoridorPlayer player1 = new QuoridorPlayer(name1, CellValue.PLAYER_1.ordinal());
        System.out.println("Player 2, what is your name?");
        String name2 = scanner.nextLine();
        QuoridorPlayer player2 = new QuoridorPlayer(name2, CellValue.PLAYER_2.ordinal());
        Board board = new Board(9, 9);
        return new Quoridor(board, player1, player2);
    }
}