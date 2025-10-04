package dots;

import core.Player;

/** A single box consisting of 4 edges. Owner set when all 4 claimed. */
public class Box {
    private final Edge top, right, bottom, left;
    private Player owner = null;

    public Box(Edge top, Edge right, Edge bottom, Edge left) {
        this.top = top; this.right = right; this.bottom = bottom; this.left = left;
    }

    public boolean isCompleted() {
        return top.isClaimed() && right.isClaimed() && bottom.isClaimed() && left.isClaimed();
    }

    public boolean hasOwner() { return owner != null; }

    public void setOwner(Player p) { this.owner = p; }

    public Player getOwner() { return owner; }
}