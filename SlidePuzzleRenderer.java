/*Class that renders slide puzzle board*/
public class SlidePuzzleRenderer implements Renderer {
    /*Renders slide puzzle board of height and width
    * boardArray: array of tiles in board
    * height: height of board
    * width: width of board*/
    public void Render(int[][] boardArray, int height, int width) {
        for (int row = 0; row < height; row++) {
            System.out.println(BuildMargin(width));
            System.out.println(BuildRow(boardArray[row], width));
        }
        System.out.println(BuildMargin(width));
    }

    /*Build margin row (Example for board of width 3: +-+-+-+
    width: width of board
     * Returns margin as string*/
    public String BuildMargin(int width) {
        StringBuilder margin = new StringBuilder();
        for (int i = 0; i < width; i++) {
            margin.append(Board.PLUS_SIGN);
            margin.append(Board.MINUS_SIGN);
        }
        margin.append(Board.PLUS_SIGN);
        return margin.toString();
    }

    /*Builds row for a given row
     * arrayRow: Row to build row for
     * width: width of board
     * Returns row as string*/
    public String BuildRow(int[] arrayRow, int width) {
        StringBuilder row = new StringBuilder();
        for (int i = 0; i < width; i++) {
            row.append(Board.PIPE_SIGN);
            if (arrayRow[i] == -1) {
                row.append(" ");
            }
            else {
                row.append(arrayRow[i]);
            }
        }
        row.append(Board.PIPE_SIGN);
        return row.toString();
    }
}
