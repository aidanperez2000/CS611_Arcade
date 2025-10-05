/*Base Renderer interface for rendering b*/
public interface Renderer {
    /*Base method for rendering board of given height and width
    * boardArray: array of values in board
    * height: height of board
    * width: width of board*/
    void Render(int[][] boardArray, int height, int width);

    /*Build row for a board
    * arrayRow: values in row
    * width: width of row
    * returns: row for board*/
    String BuildRow(int[] arrayRow, int width);

    /*Build margin for a board
    * width: width of margin
    * returns: margin for board*/
    String BuildMargin(int width);
}
