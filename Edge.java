package dots;

import core.Player;

/** A single edge; can be claimed once by exactly one player. */
public class Edge {
    private boolean claimed = false;
    private Player owner = null;

    public boolean isClaimed() { return claimed; }
    public Player getOwner() { return owner; }

    /** Claim the edge for a player exactly once. */
    public void claim(Player p) {
        if (p == null) throw new IllegalArgumentException("owner null");
        if (claimed) throw new IllegalStateException("Edge already claimed");
        claimed = true; owner = p;
    }
}
