import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*Class for sliding puzzle game extends from base game
* class*/
public class SlidingPuzzle extends Game {
    public SlidingPuzzle(Board board, Player player) {
        super(board, player);
    }
    /*Plays slide game.  Starts out with a shuffled board of
     * size Height by Width.  Allows user to move tile in empty space.
     * Continues playing until board is in order
     * scanner: scanner for user input
     * player: player who is playing the gamee*/
    public void Play(Scanner scanner) {
        //build the solution
        int[][] boardArray = new int[board.Height][board.Width];
        int boardValue = 1;
        for (int i = 0; i < board.Height; i++) {
            for (int j = 0; j < board.Width; j++) {
                boardArray[i][j] = boardValue++;
            }
        }
        //the final element will be set to -1 so we have an empty space
        boardArray[board.Height - 1][board.Width - 1] = -1;
        //make a copy of the solution to keep track of the original
        int[][] solution = new int[board.Height][board.Width];
        for (int i = 0; i < board.Height; i++) {
            System.arraycopy(boardArray[i], 0, solution[i], 0, board.Width);
        }
        List<Tile> tiles = board.BuildTilesFromBoardArray(boardArray);
        SlidePuzzleRenderer renderer = new SlidePuzzleRenderer();
        board.Shuffle(boardArray, tiles);
        renderer.Render(boardArray, board.Height, board.Width);
        while (!Arrays.deepEquals(solution, boardArray)) {
            System.out.println("Player " + player.GetPlayerName() + ", which tile do you want to slide to the empty space?  (Enter " + Board.QUIT_SIGN + " to quit)");
            String input = scanner.nextLine().trim();
            if (input.equals(Board.QUIT_SIGN)) {
                break;
            }
            try {
                int userValue = Integer.parseInt(input);
                Tile emptyTile = Tile.GetEmptyTile(tiles);
                List<Tile> possibleSwaps = Tile.GetPossibleSwaps(tiles, emptyTile);
                Tile tileToSwap = possibleSwaps.stream().filter(n -> n.GetValue() == userValue).findFirst().orElse(null);
                if (tileToSwap == null)
                    System.out.println("Invalid value to swap.  Choose a tile next to the empty one");
                else {
                    board.SwapTile(emptyTile, tileToSwap);
                    board.ArrangeBoardFromTiles(tiles, boardArray);
                    player.AddScore(1);
                }
                renderer.Render(boardArray, board.Height,  board.Width);
            }
            catch (Exception e) {
                System.out.println("Input is not a number.");
            }
        }
        System.out.println("Board has been played! Congrats, " + player.GetPlayerName() + "!");
        System.out.println("Num moves: " + player.GetScore());
    }

    /*Get name of game
    * returns: the name of game which is Sliding Puzzle*/
    public String GetGameName() {
        return "Sliding Puzzle";
    }
}
