import java.util.*;

/*Class used for rendering board*/
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

    public static final int DEFAULT_HEIGHT = 3;
    public static final int DEFAULT_WIDTH = 3;
    public static final int MIN_HEIGHT = 2;
    public static final int MIN_WIDTH = 2;
    public static final char PLUS_SIGN = '+';
    public static final char MINUS_SIGN = '-';
    public static final char PIPE_SIGN = '|';
    public static final int SHUFFLE_TIMES = 300;
    public static final String QUIT_SIGN = "Q";
    private static final Random rng = new Random();

    public int Height = DEFAULT_HEIGHT;
    public int Width = DEFAULT_WIDTH;

    /*Takes a board array and arranges a list of tiles from it
    * boardArray: array that contains numbers in board
    * returns a list of tiles with xPos = value's horizontal position,
    * yPos = value's vertical position, value = value*/
    public List<Tile> BuildTilesFromBoardArray(int[][] boardArray) {
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

    /*Shuffle the board by swapping tile positions a certain
    * number of times
    * boardArray: board array that gets rearranged
    * tiles: list of tiles that has their positions swapped*/
    public void Shuffle(int[][] boardArray, List<Tile> tiles) {
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
    public void ArrangeBoardFromTiles(List<Tile> tiles, int[][] boardArray) {
        tiles.forEach(tile -> boardArray[tile.YPos][tile.XPos] = tile.GetValue());
    }

    /*Swaps two tiles
    * emptyTile: empty tile to swap, the new value will be tileToSwap's value
    * tileToSwap: tile to swap with empty tile, will now have empty tile's value */
    public void SwapTile(Tile emptyTile, Tile tileToSwap) {
        int tempVal = emptyTile.GetValue();
        emptyTile.SetValue(tileToSwap.GetValue());
        tileToSwap.SetValue(tempVal);
    }
}
