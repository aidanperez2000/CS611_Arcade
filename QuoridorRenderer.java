/*Class for rendering Quoridor board*/
public class QuoridorRenderer implements Renderer {

    /*Render the quoridor board
    * boardArray: array of board values
    * height: height of board
    * width: width of board*/
    @Override
    public void Render(int[][] boardArray, int height, int width) {
        System.out.println("\nCurrent Quoridor Board:");
        for (int[] rows : boardArray) {
            for (int cell : rows) {
                System.out.print(MapCellToSymbol(cell));
            }
            System.out.println();
        }
        System.out.println("\nLegend");
        System.out.println(CellValue.PLAYER_1.ordinal() + " = Player " + CellValue.PLAYER_1.ordinal()  + ", " +
                CellValue.PLAYER_2.ordinal() + " = Player " + CellValue.PLAYER_2.ordinal() + ", " +
                Board.PIPE_SIGN + " = Vertical Wall, " + Board.MINUS_SIGN + " = Horizontal Wall");
    }

    /*Not used in this class, just needs to be implemented because of interface
    * arrayRow: row in array
    * width: width of board
    * returns: an empty string*/
    @Override
    public String BuildRow(int[] arrayRow, int width) {
        return "";
    }

    /*Not used in this class, just needs toe be implemented because of interface
    * width: width of board*/
    @Override
    public String BuildMargin(int width) {
        return "";
    }

    /*Gets appropriate symbol for cell
    * cell: current cell value
    * returns: symbol for cell*/
    private String MapCellToSymbol(int cell) {
        CellValue value = CellValue.values()[cell];

        switch (value) {
            case PLAYER_1:
            case PLAYER_2:
                return cell + "";
            case EDGE:
                return Board.PLUS_SIGN + "";
            case HORIZONTAL_WALL:
                return Board.MINUS_SIGN + "";
            case VERTICAL_WALL:
                return Board.PIPE_SIGN + "";
            default:
                return " ";
        }
    }
}
