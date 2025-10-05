/*Base piece class.  Any classes that use x-position and y-position
* can inherit class*/
public abstract class Piece {
    protected int XPos;
    protected int YPos;

    public Piece(int xPos, int yPos) {
        XPos = xPos;
        YPos = yPos;
    }

    /*Get the x-position of a piece
    * returns: x-position of piece*/
    public int GetXPos() {
        return XPos;
    }

    /*Get the y-position
    * returns: y-position of piece*/
    public int GetYPos() {
        return YPos;
    }

    /*Set the x-position
    * xPos: x-position to set*/
    public void SetXPos(int xPos) {
        XPos = xPos;
    }

    /*Set the y-position
    * yPos: y-position to set*/
    public void SetYPos(int yPos) {
        YPos = yPos;
    }
}
