import java.util.List;
import java.util.stream.Collectors;

public class Tile {
    public Tile(int xPos, int yPos, int value) {
        XPos = xPos;
        YPos = yPos;
        Value = value;
    }

    public int XPos;
    public int YPos;
    public int Value;

    /*Gets the empty tile from a list of a tiles,
    * tiles: List of tiles to find empty
    * returns tile from list where value is -1
    * throws RuntimeException if no empty tile is found*/
    public static Tile GetEmptyTile(List<Tile> tiles) {
        Tile emptyTile = tiles.stream().filter(n -> n.Value == -1).findFirst().orElse(null);
        if (emptyTile == null)
            throw new RuntimeException("No empty tile found");
        return emptyTile;
    }

    /*Gets the list of tiles that are could be swapped with the empty tile
    * tiles: tile list that contains list of all tiles in board
    * emptyTile: empty tile from list
    * returns tiles that are next to the empty tile, that is they're in the same row and
    * next to the empty tile or in the some column and next to the empty tile*/
    public static List<Tile> GetPossibleSwaps(List<Tile> tiles, Tile emptyTile) {
        return tiles.stream().filter(
                        n -> (n.XPos == emptyTile.XPos && (n.YPos == emptyTile.YPos - 1 || n.YPos == emptyTile.YPos + 1))
                                || (n.YPos == emptyTile.YPos && (n.XPos == emptyTile.XPos - 1 || n.XPos == emptyTile.XPos + 1)))
                .collect(Collectors.toList());
    }
}
