/* Edge class representing a line between two points in Dots and Boxes game */
public class Edge extends Piece {
    private boolean claimed;
    private int playerId;
    private Orientation orientation;

    public Edge(int xPos, int yPos, Orientation orientation) {
        super(xPos, yPos);
        this.orientation = orientation;
        this.claimed = false;
        this.playerId = -1;
    }

    /* check if the edge is claimed */
    public boolean IsClaimed() {
        return claimed;
    }

    /* claim the edge by a player */
    public void ClaimEdge(int playerId) {
        this.claimed = true;
        this.playerId = playerId;
    }

    /* get the player who claimed this edge */
    public int GetPlayerId() {
        return playerId;
    }

    /* get the orientation of the edge（H for horizontal, V for vertical）*/
    public Orientation GetOrientation() {
        return orientation;
    }
}