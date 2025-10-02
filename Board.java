import java.util.*;

public class Board {
    public Board(int height, int width) {
        if (height < MIN_HEIGHT)
            System.out.println("Height is invalid value.  Leaving as default height of " + DEFAULT_HEIGHT);
        else
            Height = height;

        if (width < MIN_WIDTH)
            System.out.println("Width is invalid value.  Leaving as default width of " + DEFAULT_WIDTH);
        else
            Width = width;
    }

    public final int DEFAULT_HEIGHT = 3;
    public final int DEFAULT_WIDTH = 3;
    public final int MIN_HEIGHT = 2;
    public final int MIN_WIDTH = 2;
    public final char PLUS_SIGN = '+';
    public final char MINUS_SIGN = '-';
    public final char PIPE_SIGN = '|';
    public final int SHUFFLE_TIMES = 300;
    public final String QUIT_SIGN = "Q";
    private final Random rng = new Random();

    public int Height = DEFAULT_HEIGHT;
    public int Width = DEFAULT_WIDTH;

    /*Plays slide game.  Starts out with a shuffled board of
    * size Height by Width.  Allows user to move tile in empty space.
    * Continues playing until board is in order
    * scanner: scanner for user input*/
    public void PlaySlideGame(Scanner scanner) {
        //build the solution
        int[][] boardArray = new int[Height][Width];
        int boardValue = 1;
        for (int i = 0; i < Height; i++) {
            for (int j = 0; j < Width; j++) {
                boardArray[i][j] = boardValue++;
            }
        }
        //the final element will be set to -1 so we have an empty space
        boardArray[Height - 1][Width - 1] = -1;
        //make a copy of the solution to keep track of the original
        int[][] solution = new int[Height][Width];
        for (int i = 0; i < Height; i++) {
            System.arraycopy(boardArray[i], 0, solution[i], 0, Width);
        }
        List<Tile> tiles = BuildTilesFromBoardArray(boardArray);
        Shuffle(boardArray, tiles);
        while (!Arrays.deepEquals(solution, boardArray)) {
            BuildBoard(boardArray);
            System.out.println("Player, which tile do you want to slide to the empty space?  (Enter " + QUIT_SIGN + " to quit)");
            String input = scanner.nextLine();
            int userValue = -1;
            try {
                userValue = Integer.parseInt(input);
            }
            catch (Exception e) {
                System.out.println("Input is not a number.");
            }
            Tile emptyTile = Tile.GetEmptyTile(tiles);
            List<Tile> possibleSwaps = Tile.GetPossibleSwaps(tiles, emptyTile);
            Tile tileToSwap = possibleSwaps.stream().filter(n -> n.Value == userValue).findFirst().orElse(null);
            if (tileToSwap == null)
                System.out.println("Invalid value to swap.  Choose a tile next to the empty one");
            else {
                SwapTile(emptyTile, tileToSwap);
                ArrangeBoardFromTiles(tiles, boardArray);
            }
        }
        //show the final board when game over
        BuildBoard(boardArray);
        System.out.println("Board has been played!  Good game!");
    }

    /*Build margin row (Example for 3 by 3 board: +-+-+-+
    * Returns margin as string*/
    private String BuildMargin() {
        StringBuilder margin = new StringBuilder();
        for (int i = 0; i < Width; i++) {
            margin.append(PLUS_SIGN);
            margin.append(MINUS_SIGN);
        }
        margin.append(PLUS_SIGN);
        return margin.toString();
    }

    /*Builds row for a given row
    * arrayRow: Row to build row for
    * Returns row as string*/
    private String BuildRow(int[] arrayRow) {
        StringBuilder row = new StringBuilder();
        for (int i = 0; i < Width; i++) {
            row.append(PIPE_SIGN);
            if (arrayRow[i] == -1) {
                row.append(" ");
            }
            else {
                row.append(arrayRow[i]);
            }
        }
        row.append(PIPE_SIGN);
        return row.toString();
    }

    /*Builds board with rows and margins for a given array
    * boardArray: array to build board for*/
    private void BuildBoard(int[][] boardArray) {
        for (int row = 0; row < Height; row++) {
            System.out.println(BuildMargin());
            System.out.println(BuildRow(boardArray[row]));
        }
        System.out.println(BuildMargin());
    }

    /*Takes a board array and arranges a list of tiles from it
    * boardArray: array that contains numbers in board
    * returns a list of tiles with xPos = value's horizontal position,
    * yPos = value's vertical position, value = value*/
    private List<Tile> BuildTilesFromBoardArray(int[][] boardArray) {
        List<Tile> tiles = new ArrayList<>();
        /*iterating through y first since arrays do vertical and then
         * horizontal*/
        for (int y = 0; y < Height; y++) {
            for (int x = 0; x < Width; x++) {
                tiles.add(new Tile(x, y, boardArray[y][x]));
            }
        }
        return tiles;
    }

    /*Shuffle board by swapping tile positions a certain
    * number of times
    * boardArray: board array that gets rearranged
    * tiles: list of tiles that has their positions swapped*/
    private void Shuffle(int[][] boardArray, List<Tile> tiles) {
        for (int i = 0; i < SHUFFLE_TIMES; i++) {
            Tile emptyTile = Tile.GetEmptyTile(tiles);
            List<Tile> possibleSwaps = Tile.GetPossibleSwaps(tiles, emptyTile);
            Tile tileToSwap = possibleSwaps.get(rng.nextInt(possibleSwaps.size()));
            SwapTile(emptyTile, tileToSwap);
        }
        ArrangeBoardFromTiles(tiles, boardArray);
    }

    /*Takes a list of tiles and rearranges board array from the tile's y-values
    * and x-values
    * tiles: List of tiles with new x and y positions
    * boardArray: array to rearrange*/
    private void ArrangeBoardFromTiles(List<Tile> tiles, int[][] boardArray) {
        tiles.forEach(tile -> {
            boardArray[tile.YPos][tile.XPos] = tile.Value;
        });
    }

    /*Swaps two tiles
    * emptyTile: empty tile to swap, the new value will be tileToSwap's value
    * tileToSwap: tile to swap with empty tile, will now have empty tile's value */
    private void SwapTile(Tile emptyTile, Tile tileToSwap) {
        int tempVal = emptyTile.Value;
        emptyTile.Value = tileToSwap.Value;
        tileToSwap.Value = tempVal;
    }
}
