import java.util.Scanner;

public class SlidePuzzle {
    public static void main(String[] args) {
        System.out.println("Welcome!  Ready to play the slide game?");
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Let's play!  To begin, enter your desired height for your board.");
            int height = scanner.nextInt();
            System.out.println("Enter your desired width.");
            int width = scanner.nextInt();
            Board board = new Board(height, width);
            board.PlaySlideGame(scanner);
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}