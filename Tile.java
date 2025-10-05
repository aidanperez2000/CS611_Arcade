import java.util.List;
import java.util.stream.Collectors;

/*Tile class which keeps track of a
* tile's value at a certain position*/
public class Tile extends Piece {
    public Tile(int xPos, int yPos, int value) {
        super(xPos, yPos);
        Value = value;
    }

    private int Value;

    /*Get value of tile
    * returns: value of tile*/
    public int GetValue() {
        return Value;
    }

    /*Set value of tile
    * value: value to set tile to*/
    public void SetValue(int value) {
        Value = value;
    }

    /*Gets the empty tile from a list of a tiles,
    * tiles: List of tiles to find empty
    * returns tile from list where value is -1
    * throws RuntimeException if no empty tile is found*/
    public static Tile GetEmptyTile(List<Tile> tiles) {
        Tile emptyTile = tiles.stream().filter(n -> n.GetValue() == -1).findFirst().orElse(null);
        if (emptyTile == null)
            throw new RuntimeException("No empty tile found");
        return emptyTile;
    }

    /*Gets the list of tiles that are could be swapped with the empty tile
    * tiles: tile list that contains list of all tiles in board
    * emptyTile: empty tile from list
    * returns tiles that are next to the empty tile, that is they're in the same row and
    * next to the empty tile or in the same column and next to the empty tile*/
    public static List<Tile> GetPossibleSwaps(List<Tile> tiles, Tile emptyTile) {
        return tiles.stream().filter(
                        n -> (n.GetXPos() == emptyTile.GetXPos() && (n.GetYPos() == emptyTile.GetYPos() - 1 || n.GetYPos() == emptyTile.GetYPos() + 1))
                                || (n.GetYPos() == emptyTile.GetYPos() && (n.GetXPos() == emptyTile.GetXPos() - 1 || n.GetXPos() == emptyTile.GetXPos() + 1)))
                .collect(Collectors.toList());
    }
}
