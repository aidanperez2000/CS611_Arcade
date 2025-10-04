# CS611-Assignment 1
## Slide Puzzle
---------------------------------------------------------------------------
- Name: Aidan Perez
- Email: aperez00@bu.edu
- Student ID: U83281909

## Files
---------------------------------------------------------------------------
Main.java: contains main program that plays the game
Board.java: keeps track of board with a given width and height and contains logic for playing the game
Tile.java: keeps track of the tiles' values, x-positions, and y-positions.



## Notes
---------------------------------------------------------------------------
- The board has min height and min width of 2.  If the user enters a value less than 2, it sets a default value for the width and height and the console shows a friendly message to the user that it's setting the default values.
- If the user enters a tile that doesn't exist in the board or cannot be moved, it throws an exception and writes this exception to the console.
- Use of Tile class to keep track of tiles and their positions.



## How to compile and run
---------------------------------------------------------------------------
1. Navigate to the directory "CS611_Arcade" in the terminal.
2. Run the following commands:
```
javac *.java
java Main
```



## Input/Output Example
---------------------------------------------------------------------------

```
Output:
Welcome!  Ready to play the slide game?
Let's play!  To begin, enter your desired height for your board.
Input:
3
Output:
Enter your desired width.
Input:
3
Output:
+-+-+-+
|1|4| |
+-+-+-+
|7|3|2|
+-+-+-+
|6|5|8|
+-+-+-+
Player, which tile do you want to slide to the empty space?
Input:
2
Output:
+-+-+-+
|1|4|2|
+-+-+-+
|7|3| |
+-+-+-+
|6|5|8|
+-+-+-+
Player, which tile do you want to slide to the empty space?
Input:
3
Output:
+-+-+-+
|1|4|2|
+-+-+-+
|7| |3|
+-+-+-+
|6|5|8|
+-+-+-+
Player, which tile do you want to slide to the empty space?
Input:
4
Output:
+-+-+-+
|1| |2|
+-+-+-+
|7|4|3|
+-+-+-+
|6|5|8|
+-+-+-+
Player, which tile do you want to slide to the empty space?
Input:
2
Output:
+-+-+-+
|1|2| |
+-+-+-+
|7|4|3|
+-+-+-+
|6|5|8|
+-+-+-+
Player, which tile do you want to slide to the empty space?
Input:
3
Output:
+-+-+-+
|1|2|3|
+-+-+-+
|7|4| |
+-+-+-+
|6|5|8|
+-+-+-+
Player, which tile do you want to slide to the empty space?
Input:
4
Output:
+-+-+-+
|1|2|3|
+-+-+-+
|7| |4|
+-+-+-+
|6|5|8|
+-+-+-+
Player, which tile do you want to slide to the empty space?
Input:
5
Output:
+-+-+-+
|1|2|3|
+-+-+-+
|7|5|4|
+-+-+-+
|6| |8|
+-+-+-+
Player, which tile do you want to slide to the empty space?
Input:
6
Output:
+-+-+-+
|1|2|3|
+-+-+-+
|7|5|4|
+-+-+-+
| |6|8|
+-+-+-+
Player, which tile do you want to slide to the empty space?
Input:
7
Output:
+-+-+-+
|1|2|3|
+-+-+-+
| |5|4|
+-+-+-+
|7|6|8|
+-+-+-+
Player, which tile do you want to slide to the empty space?
Input:
5
Output:
+-+-+-+
|1|2|3|
+-+-+-+
|5| |4|
+-+-+-+
|7|6|8|
+-+-+-+
Player, which tile do you want to slide to the empty space?
Input:
4
Output:
+-+-+-+
|1|2|3|
+-+-+-+
|5|4| |
+-+-+-+
|7|6|8|
+-+-+-+
Player, which tile do you want to slide to the empty space?
Input:
8
Output:
+-+-+-+
|1|2|3|
+-+-+-+
|5|4|8|
+-+-+-+
|7|6| |
+-+-+-+
Player, which tile do you want to slide to the empty space?
Input:
6
Output:
+-+-+-+
|1|2|3|
+-+-+-+
|5|4|8|
+-+-+-+
|7| |6|
+-+-+-+
Player, which tile do you want to slide to the empty space?
Input:
7
Output:
+-+-+-+
|1|2|3|
+-+-+-+
|5|4|8|
+-+-+-+
| |7|6|
+-+-+-+
Player, which tile do you want to slide to the empty space?
Input:
5
Output:
+-+-+-+
|1|2|3|
+-+-+-+
| |4|8|
+-+-+-+
|5|7|6|
+-+-+-+
Player, which tile do you want to slide to the empty space?
Input:
4
Output:
+-+-+-+
|1|2|3|
+-+-+-+
|4| |8|
+-+-+-+
|5|7|6|
+-+-+-+
Player, which tile do you want to slide to the empty space?
Input:
7
Output:
+-+-+-+
|1|2|3|
+-+-+-+
|4|7|8|
+-+-+-+
|5| |6|
+-+-+-+
Player, which tile do you want to slide to the empty space?
Input:
6
Output:
+-+-+-+
|1|2|3|
+-+-+-+
|4|7|8|
+-+-+-+
|5|6| |
+-+-+-+
Player, which tile do you want to slide to the empty space?
Input:
8
Output:
+-+-+-+
|1|2|3|
+-+-+-+
|4|7| |
+-+-+-+
|5|6|8|
+-+-+-+
Player, which tile do you want to slide to the empty space?
Input:
7
Output:
+-+-+-+
|1|2|3|
+-+-+-+
|4| |7|
+-+-+-+
|5|6|8|
+-+-+-+
Player, which tile do you want to slide to the empty space?
Input:
6
Output:
+-+-+-+
|1|2|3|
+-+-+-+
|4|6|7|
+-+-+-+
|5| |8|
+-+-+-+
Player, which tile do you want to slide to the empty space?
Input:
8
Output:
+-+-+-+
|1|2|3|
+-+-+-+
|4|6|7|
+-+-+-+
|5|8| |
+-+-+-+
Player, which tile do you want to slide to the empty space?
Input:
7
Output:
+-+-+-+
|1|2|3|
+-+-+-+
|4|6| |
+-+-+-+
|5|8|7|
+-+-+-+
Player, which tile do you want to slide to the empty space?
Input:
6
Output:
+-+-+-+
|1|2|3|
+-+-+-+
|4| |6|
+-+-+-+
|5|8|7|
+-+-+-+
Player, which tile do you want to slide to the empty space?
Input:
8
Output:
+-+-+-+
|1|2|3|
+-+-+-+
|4|8|6|
+-+-+-+
|5| |7|
+-+-+-+
Player, which tile do you want to slide to the empty space?
Input:
5
Output:
+-+-+-+
|1|2|3|
+-+-+-+
|4|8|6|
+-+-+-+
| |5|7|
+-+-+-+
Player, which tile do you want to slide to the empty space?
Input:
5
Output:
+-+-+-+
|1|2|3|
+-+-+-+
|4|8|6|
+-+-+-+
|5| |7|
+-+-+-+
Player, which tile do you want to slide to the empty space?
Input:
7
Output:
+-+-+-+
|1|2|3|
+-+-+-+
|4|8|6|
+-+-+-+
|5|7| |
+-+-+-+
Player, which tile do you want to slide to the empty space?
Input:
6
Output:
+-+-+-+
|1|2|3|
+-+-+-+
|4|8| |
+-+-+-+
|5|7|6|
+-+-+-+
Player, which tile do you want to slide to the empty space?
Input:
8
Output:
+-+-+-+
|1|2|3|
+-+-+-+
|4| |8|
+-+-+-+
|5|7|6|
+-+-+-+
Player, which tile do you want to slide to the empty space?
Input:
7
Output:
+-+-+-+
|1|2|3|
+-+-+-+
|4|7|8|
+-+-+-+
|5| |6|
+-+-+-+
Player, which tile do you want to slide to the empty space?
Input:
6
Output:
+-+-+-+
|1|2|3|
+-+-+-+
|4|7|8|
+-+-+-+
|5|6| |
+-+-+-+
Player, which tile do you want to slide to the empty space?
Input:
8
Output:
+-+-+-+
|1|2|3|
+-+-+-+
|4|7| |
+-+-+-+
|5|6|8|
+-+-+-+
Player, which tile do you want to slide to the empty space?
Input:
7
Output:
+-+-+-+
|1|2|3|
+-+-+-+
|4| |7|
+-+-+-+
|5|6|8|
+-+-+-+
Player, which tile do you want to slide to the empty space?
Input:
6
Output:
+-+-+-+
|1|2|3|
+-+-+-+
|4|6|7|
+-+-+-+
|5| |8|
+-+-+-+
Player, which tile do you want to slide to the empty space?
Input:
5
Output:
+-+-+-+
|1|2|3|
+-+-+-+
|4|6|7|
+-+-+-+
| |5|8|
+-+-+-+
Player, which tile do you want to slide to the empty space?
Input:
4
Output:
+-+-+-+
|1|2|3|
+-+-+-+
| |6|7|
+-+-+-+
|4|5|8|
+-+-+-+
Player, which tile do you want to slide to the empty space?
Input:
6
Output:
+-+-+-+
|1|2|3|
+-+-+-+
|6| |7|
+-+-+-+
|4|5|8|
+-+-+-+
Player, which tile do you want to slide to the empty space?
Input:
5
Output:
+-+-+-+
|1|2|3|
+-+-+-+
|6|5|7|
+-+-+-+
|4| |8|
+-+-+-+
Player, which tile do you want to slide to the empty space?
Input:
8
Output:
+-+-+-+
|1|2|3|
+-+-+-+
|6|5|7|
+-+-+-+
|4|8| |
+-+-+-+
Player, which tile do you want to slide to the empty space?
Input:
7
Output:
+-+-+-+
|1|2|3|
+-+-+-+
|6|5| |
+-+-+-+
|4|8|7|
+-+-+-+
Player, which tile do you want to slide to the empty space?
5
+-+-+-+
|1|2|3|
+-+-+-+
|6| |5|
+-+-+-+
|4|8|7|
+-+-+-+
Player, which tile do you want to slide to the empty space?
Input:
8
Output:
+-+-+-+
|1|2|3|
+-+-+-+
|6|8|5|
+-+-+-+
|4| |7|
+-+-+-+
Player, which tile do you want to slide to the empty space?
Input:
4
Output:
+-+-+-+
|1|2|3|
+-+-+-+
|6|8|5|
+-+-+-+
| |4|7|
+-+-+-+
Player, which tile do you want to slide to the empty space?
Input:
6
Output:
+-+-+-+
|1|2|3|
+-+-+-+
| |8|5|
+-+-+-+
|6|4|7|
+-+-+-+
Player, which tile do you want to slide to the empty space?
Input:
8
Output:
+-+-+-+
|1|2|3|
+-+-+-+
|8| |5|
+-+-+-+
|6|4|7|
+-+-+-+
Player, which tile do you want to slide to the empty space?
Input:
4
Output:
+-+-+-+
|1|2|3|
+-+-+-+
|8|4|5|
+-+-+-+
|6| |7|
+-+-+-+
Player, which tile do you want to slide to the empty space?
Input:
7
Output:
+-+-+-+
|1|2|3|
+-+-+-+
|8|4|5|
+-+-+-+
|6|7| |
+-+-+-+
Player, which tile do you want to slide to the empty space?
Input:
5
Output:
+-+-+-+
|1|2|3|
+-+-+-+
|8|4| |
+-+-+-+
|6|7|5|
+-+-+-+
Player, which tile do you want to slide to the empty space?
Input:
4
Output:
+-+-+-+
|1|2|3|
+-+-+-+
|8| |4|
+-+-+-+
|6|7|5|
+-+-+-+
Player, which tile do you want to slide to the empty space?
Input:
7
Output:
+-+-+-+
|1|2|3|
+-+-+-+
|8|7|4|
+-+-+-+
|6| |5|
+-+-+-+
Player, which tile do you want to slide to the empty space?
Input:
6
Output:
+-+-+-+
|1|2|3|
+-+-+-+
|8|7|4|
+-+-+-+
| |6|5|
+-+-+-+
Player, which tile do you want to slide to the empty space?
Input:
8
Output:
+-+-+-+
|1|2|3|
+-+-+-+
| |7|4|
+-+-+-+
|8|6|5|
+-+-+-+
Player, which tile do you want to slide to the empty space?
Input:
7
Output:
+-+-+-+
|1|2|3|
+-+-+-+
|7| |4|
+-+-+-+
|8|6|5|
+-+-+-+
Player, which tile do you want to slide to the empty space?
Input:
4
Output:
+-+-+-+
|1|2|3|
+-+-+-+
|7|4| |
+-+-+-+
|8|6|5|
+-+-+-+
Player, which tile do you want to slide to the empty space?
Input:
5
Output:
+-+-+-+
|1|2|3|
+-+-+-+
|7|4|5|
+-+-+-+
|8|6| |
+-+-+-+
Player, which tile do you want to slide to the empty space?
Input:
6
Output:
+-+-+-+
|1|2|3|
+-+-+-+
|7|4|5|
+-+-+-+
|8| |6|
+-+-+-+
Player, which tile do you want to slide to the empty space?
Input:
8
Output:
+-+-+-+
|1|2|3|
+-+-+-+
|7|4|5|
+-+-+-+
| |8|6|
+-+-+-+
Player, which tile do you want to slide to the empty space?
Input:
7
Output:
+-+-+-+
|1|2|3|
+-+-+-+
| |4|5|
+-+-+-+
|7|8|6|
+-+-+-+
Player, which tile do you want to slide to the empty space?
Input:
4
Output:
+-+-+-+
|1|2|3|
+-+-+-+
|4| |5|
+-+-+-+
|7|8|6|
+-+-+-+
Player, which tile do you want to slide to the empty space?
Input:
5
Output:
+-+-+-+
|1|2|3|
+-+-+-+
|4|5| |
+-+-+-+
|7|8|6|
+-+-+-+
Player, which tile do you want to slide to the empty space?
Input:
6
Output:
+-+-+-+
|1|2|3|
+-+-+-+
|4|5|6|
+-+-+-+
|7|8| |
+-+-+-+
Board has been played!  Good game!
```
