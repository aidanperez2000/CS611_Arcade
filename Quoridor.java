import java.util.Scanner;

/*Class for Quoridor game*/
public class Quoridor extends Game {
    public Quoridor(Board board, QuoridorPlayer player1, QuoridorPlayer player2) {
        super(board);
        this.player1 = player1;
        this.player2 = player2;
        renderer = new QuoridorRenderer();
    }

    private final QuoridorPlayer player1;
    private final QuoridorPlayer player2;
    private final QuoridorRenderer renderer;

    /*Play the Quoridor game:
    * scanner: scanner for input*/
    public void Play(Scanner scanner) {
        System.out.println("Welcome to Quoridor!");
        int[][] boardArray = new int[board.Height * 2 + 1][board.Width * 2 + 1];
        for (int y = 0; y < boardArray.length; y++) {
            for (int x = 0; x < boardArray[y].length; x++) {
                if (y % 2 == 0 && x % 2 == 0) {
                    /*The even rows are the edge rows.  They'll have edge signs in
                    * the even columns and initially the odd columns will be empty*/
                    boardArray[y][x] = CellValue.EDGE.ordinal();
                }
                else {
                    boardArray[y][x] = CellValue.EMPTY.ordinal();
                }
            }
        }
        boardArray[1][board.Width] = player1.GetPlayerId();
        boardArray[boardArray.length - 2][board.Width] = player2.GetPlayerId();
        System.out.println("Player " + player1.GetPlayerId() + " " + player1.GetPlayerName() + ": " + player1.GetWallsRemaining());
        System.out.println("Player " + player2.GetPlayerId() + " " + player2.GetPlayerName() + ": " + player2.GetWallsRemaining());
        renderer.Render(boardArray, board.Height, board.Width);
    }
}
