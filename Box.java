/*Box class representing a box in Dots and Boxes game*/
public class Box extends Piece {
    private boolean completed;
    private int ownerId;

    public Box(int xPos, int yPos) {
        super(xPos, yPos);
        this.completed = false;
        this.ownerId = -1;
    }

    /*Check if the box is completed
     * returns: true if box is completed, false otherwise*/
    public boolean IsCompleted() {
        return completed;
    }

    /*Complete the box and assign owner
     * ownerId: ID of the player who completed the box*/
    public void CompleteBox(int ownerId) {
        this.completed = true;
        this.ownerId = ownerId;
    }

    /*Get the owner of the box
     * returns: owner ID or -1 if not completed*/
    public int GetOwnerId() {
        return ownerId;
    }
}