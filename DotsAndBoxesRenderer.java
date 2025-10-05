/* Class that renders Dots and Boxes board */
public class DotsAndBoxesRenderer implements Renderer {

    /*
        Renders Dots and Boxes board using a special encoding in boardArray
         * boardArray: encoded game state
         * height: height of board (number of box rows)
         * width: width of board (number of box columns)
     */
    public void Render(int[][] boardArray, int height, int width) {
        System.out.println("\nCurrent Board:");

        // Render the dots and boxes grid
        for (int y = 0; y <= height; y++) {
            // Render dots and horizontal edges
            for (int x = 0; x <= width; x++) {
                System.out.print(Board.PLUS_SIGN); // Dot

                if (x < width) {
                    // Check if horizontal edge exists at this position
                    int edgeValue = getHorizontalEdgeValue(boardArray, x, y, height, width);
                    if (edgeValue > 0) {
                        System.out.print(Board.MINUS_SIGN);
                    } else {
                        System.out.print(' ');
                    }
                }
            }
            System.out.println();

            // Render vertical edges and box contents
            if (y < height) {
                for (int x = 0; x <= width; x++) {
                    // Check if vertical edge exists at this position
                    int edgeValue = getVerticalEdgeValue(boardArray, x, y, height, width);
                    if (edgeValue > 0) {
                        System.out.print(Board.PIPE_SIGN);
                    } else {
                        System.out.print(' ');
                    }

                    if (x < width) {
                        // Show box owner or empty space
                        int boxValue = getBoxValue(boardArray, x, y, width);
                        if (boxValue > 0) {
                            System.out.print(boxValue);
                        } else {
                            System.out.print(' ');
                        }
                    }
                }
                System.out.println();
            }
        }

        System.out.println("\nInstructions: Enter coordinates and orientation (e.g., '0,0,H' for horizontal edge at (0,0))");
        System.out.println("H = Horizontal edge, V = Vertical edge");
    }

    /*Get horizontal edge value from encoded board array*/
    private int getHorizontalEdgeValue(int[][] boardArray, int x, int y, int height, int width) {
        // Horizontal edges are encoded in rows 0, 2, 4, ... (even rows)
        int encodedRow = y * 2;
        if (encodedRow < boardArray.length && x < boardArray[encodedRow].length) {
            return boardArray[encodedRow][x];
        }
        return 0;
    }

    /*Get vertical edge value from encoded board array*/
    private int getVerticalEdgeValue(int[][] boardArray, int x, int y, int height, int width) {
        // Vertical edges are encoded in rows 1, 3, 5, ... (odd rows)
        int encodedRow = y * 2 + 1;
        if (encodedRow < boardArray.length && x < boardArray[encodedRow].length) {
            return boardArray[encodedRow][x];
        }
        return 0;
    }

    /*Get box value from encoded board array*/
    private int getBoxValue(int[][] boardArray, int x, int y, int width) {
        // Boxes are encoded separately - we'll use a simple approach
        // Box ownership can be stored in a special encoding
        int encodedRow = y * 2 + 1;
        if (encodedRow < boardArray.length && (width + 1 + x) < boardArray[encodedRow].length) {
            return boardArray[encodedRow][width + 1 + x];
        }
        return 0;
    }

    /*Build row for a board - adapted for Dots and Boxes
     * arrayRow: values in row
     * width: width of row
     * returns: row for board*/
    public String BuildRow(int[] arrayRow, int width) {
        StringBuilder row = new StringBuilder();
        for (int i = 0; i < arrayRow.length && i < width; i++) {
            if (arrayRow[i] > 0) {
                row.append(Board.MINUS_SIGN);
            } else {
                row.append(' ');
            }
        }
        return row.toString();
    }

    /*Build margin for a board - adapted for Dots and Boxes
     * width: width of margin
     * returns: margin for board*/
    public String BuildMargin(int width) {
        StringBuilder margin = new StringBuilder();
        for (int i = 0; i <= width; i++) {
            margin.append(Board.PLUS_SIGN);
            if (i < width) {
                margin.append(' ');
            }
        }
        return margin.toString();
    }
}