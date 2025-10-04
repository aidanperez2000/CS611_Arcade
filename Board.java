package dots;

import core.Player;

/**
 * Board holds all edges/boxes and enforces Dots & Boxes rules.
 * Coordinates:
 * H edges: r in [0..rows], c in [0..cols-1]
 * V edges: r in [0..rows-1], c in [0..cols]
 */
public class Board {
    private final int rows; // number of boxes vertically
    private final int cols; // number of boxes horizontally

    private final Edge[][] h; // (rows+1) x cols : horizontal edges
    private final Edge[][] v; // rows x (cols+1) : vertical edges
    private final Box[][] boxes; // rows x cols
    private int remainingEdges;

    public Board(int rows, int cols) {
        if (rows < 1 || cols < 1) throw new IllegalArgumentException("rows/cols >= 1");
        this.rows = rows; this.cols = cols;

// allocate edges
        h = new Edge[rows + 1][cols];
        v = new Edge[rows][cols + 1];
        for (int r = 0; r < rows + 1; r++)
            for (int c = 0; c < cols; c++)
                h[r][c] = new Edge();
        for (int r = 0; r < rows; r++)
            for (int c = 0; c < cols + 1; c++)
                v[r][c] = new Edge();

// boxes reference edges by adjacency
        boxes = new Box[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                boxes[r][c] = new Box(
                        h[r][c], // top
                        v[r][c+1], // right
                        h[r+1][c], // bottom
                        v[r][c] // left
                );
            }
        }
        remainingEdges = (rows + 1) * cols + rows * (cols + 1);
    }

    public int getRows() { return rows; }
    public int getCols() { return cols; }

    /** Is the specified edge already claimed? */
    public boolean isEdgeClaimed(Orientation o, int r, int c) {
        return getEdge(o, r, c).isClaimed();
    }

    /** Returns uppercase initial of owner of a box or null if unowned. */
    public Character getBoxOwnerInitial(int r, int c) {
        Player p = boxes[r][c].getOwner();
        return p == null ? null : Character.toUpperCase(p.getName().charAt(0));
    }
    /**
     * Claims an edge for a player and returns number of boxes completed by this move.
     * @throws IndexOutOfBoundsException if coordinates are out of range
     * @throws IllegalStateException if the edge is already claimed
     */
    public int claimEdge(Orientation o, int r, int c, Player p) {
        Edge e = getEdge(o, r, c);
        if (e.isClaimed()) throw new IllegalStateException("Edge already claimed");
        e.claim(p);
        remainingEdges--;
        int completed = 0;
        if (o == Orientation.H) {
            if (r > 0) completed += completeIfReady(r-1, c, p); // box above
            if (r < rows) completed += completeIfReady(r, c, p); // box below
        } else { // V
            if (c > 0) completed += completeIfReady(r, c-1, p); // box left
            if (c < cols) completed += completeIfReady(r, c, p); // box right
        }
        return completed;
    }

    private int completeIfReady(int r, int c, Player p) {
        Box b = boxes[r][c];
        if (!b.hasOwner() && b.isCompleted()) {
            b.setOwner(p);
            return 1;
        }
        return 0;
    }

    public int edgesRemaining() { return remainingEdges; }

    private Edge getEdge(Orientation o, int r, int c) {
        if (o == Orientation.H) {
            if (r < 0 || r > rows || c < 0 || c >= cols)
                throw new IndexOutOfBoundsException("H edge out of range");
            return h[r][c];
        } else {
            if (r < 0 || r >= rows || c < 0 || c > cols)
                throw new IndexOutOfBoundsException("V edge out of range");
            return v[r][c];
        }
    }
}
