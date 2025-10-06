# CS611-Assignment 1
## Slide Puzzle
---------------------------------------------------------------------------
- Name: Aidan Perez
- Email: aperez00@bu.edu
- Student ID: U83281909

- Name: Shuxun Zhou
- Email: shuxun@bu.edu
- Student ID: U30247554


## Files
---------------------------------------------------------------------------
-	Main.java: Contains the main program used to start and select games.
-	Board.java: Manages the game board of specified width and height.
-	Tile.java: Tracks the tile ID, coordinates, and labels in the sliding puzzle game.
-	Box.java: Represents a box in the Dots and Boxes game, tracking completion status and owner.
-	Edge.java: Represents a line connecting dots in the Dots and Boxes game, tracking activation status and owner.
-	Player.java: Stores player information, including name, score, and player ID.
-	DotsAndBoxes.java: Allows users to play the Dots and Boxes game.
-	Game.java: Base game class that other games inherit from.
-	Orientation.java: Enum that includes “HORIZONTAL” and “VERTICAL,” used to track edge direction.
-	Piece.java: Base component class; other classes that require coordinates and labels inherit from it.
-	SlidingPuzzle.java: Allows users to play the sliding puzzle game.
-	DotsAndBoxesRenderer.java: Renders the Dots and Boxes game interface.
-	SlidePuzzleRenderer.java: Renders the sliding puzzle game interface.
-	Renderer.java: Base rendering class.




## Notes
---------------------------------------------------------------------------
-	The board has a minimum height and width of 2. If the user enters a value smaller than 2, the program will set a default value and display a friendly message in the console.
-	If the user enters a tile that does not exist on the board or attempts to move an invalid tile, the program will throw an exception and display an error message in the console.
-	The Tile class tracks tiles and their positions in the sliding puzzle game.
-	The Tile class extends Piece, and any class that uses coordinates and labels also inherits from Piece.
-	All games inherit from the Game class.
-	The sliding puzzle tracks the number of moves as the score.
-	The Dots and Boxes game supports two-player mode. It uses Edge to track drawn lines and Box to track completed boxes.
-	The Player class supports multiple players, each with a unique ID and score tracking.




## How to compile and run
---------------------------------------------------------------------------
1. Navigate to the directory "CS611_Arcade" in the terminal.
2. Run the following commands:
```
javac *.java
java Main
```

## Game Rules
--------------------------------------------------------------------------
### Sliding Puzzle
-	Single-player mode; the goal is to arrange the tiles in numerical order.
-	Players can move tiles adjacent to the empty space.
-	The game tracks the number of moves as the score.
### Dots and Boxes
-	Two-player mode; players take turns drawing lines between dots.
-	Completing a box grants a point and allows an extra turn.
-	The player with the most boxes at the end of the game wins.




## Input/Output Example
---------------------------------------------------------------------------

Sliding Puzzle
```
output:
Welcome to the Game Arcade!
Let's play! To begin, enter your desired height for your board.
input:
2
output:
Enter your desired width.
input:
2
output:
Which game do you want to play?
[1] - Sliding Puzzle
[2] - Dots and Boxes
input:
1
output:
Player, what is your name?
input:
Aidan
output:
+-+-+
|3|1|
+-+-+
|2| |
+-+-+
Player Aidan, which tile do you want to slide to the empty space?  (Enter Q to quit)
input:
2
output:
+-+-+
|3|1|
+-+-+
| |2|
+-+-+
Player Aidan, which tile do you want to slide to the empty space?  (Enter Q to quit)
input:
1
output:
Invalid value to swap.  Choose a tile next to the empty one
+-+-+
|3|1|
+-+-+
| |2|
+-+-+
Player Aidan, which tile do you want to slide to the empty space?  (Enter Q to quit)
input:
3
output:
+-+-+
| |1|
+-+-+
|3|2|
+-+-+
Player Aidan, which tile do you want to slide to the empty space?  (Enter Q to quit)
input:
1
output:
+-+-+
|1| |
+-+-+
|3|2|
+-+-+
Player Aidan, which tile do you want to slide to the empty space?  (Enter Q to quit)
input:
2
output:
+-+-+
|1|2|
+-+-+
|3| |
+-+-+
Board has been played! Congrats, Aidan!
Num moves: 4
```
Dots and Boxes
```
output:
Welcome to the Game Arcade!
Let's play! To begin, enter your desired height for your board.
input:
3
output:
Enter your desired width.
input:
3
output:
Which game do you want to play?
[1] - Sliding Puzzle
[2] - Dots and Boxes
input:
2
output:
Player 1, what is your name?
input:
Aidan
output:
Player 2, what is your name?
input:
Shuxun
output:
Welcome to Dots and Boxes!
Players: Aidan (Player 1) vs Shuxun (Player 2)
Board size: 3x3
Scores: Aidan: 0 | Shuxun: 0

Current Board:
+ + + +
       
+ + + +
       
+ + + +
       
+ + + +

Instructions: Enter coordinates and orientation (e.g., '0,0,H' for horizontal edge at (0,0))
H = Horizontal edge, V = Vertical edge
Aidan's turn. Enter edge coordinates and orientation (x,y,H/V) or 'Q' to quit:
input:
0,0,H
output:
Scores: Aidan: 0 | Shuxun: 0

Current Board:
+-+ + +
       
+ + + +
       
+ + + +
       
+ + + +

Instructions: Enter coordinates and orientation (e.g., '0,0,H' for horizontal edge at (0,0))
H = Horizontal edge, V = Vertical edge
Shuxun's turn. Enter edge coordinates and orientation (x,y,H/V) or 'Q' to quit:
input:
0,1,H
output:
Scores: Aidan: 0 | Shuxun: 0

Current Board:
+-+ + +
       
+-+ + +
       
+ + + +
       
+ + + +

Instructions: Enter coordinates and orientation (e.g., '0,0,H' for horizontal edge at (0,0))
H = Horizontal edge, V = Vertical edge
Aidan's turn. Enter edge coordinates and orientation (x,y,H/V) or 'Q' to quit:
input:
1,1,H
output:
Scores: Aidan: 0 | Shuxun: 0

Current Board:
+-+ + +
       
+-+-+ +
       
+ + + +
       
+ + + +

Instructions: Enter coordinates and orientation (e.g., '0,0,H' for horizontal edge at (0,0))
H = Horizontal edge, V = Vertical edge
Shuxun's turn. Enter edge coordinates and orientation (x,y,H/V) or 'Q' to quit:
input:
1,1,V
output:
Scores: Aidan: 0 | Shuxun: 0

Current Board:
+-+ + +
       
+-+-+ +
  |    
+ + + +
       
+ + + +

Instructions: Enter coordinates and orientation (e.g., '0,0,H' for horizontal edge at (0,0))
H = Horizontal edge, V = Vertical edge
Aidan's turn. Enter edge coordinates and orientation (x,y,H/V) or 'Q' to quit:
input:
0,0,V
output:
Scores: Aidan: 0 | Shuxun: 0

Current Board:
+-+ + +
|      
+-+-+ +
  |    
+ + + +
       
+ + + +

Instructions: Enter coordinates and orientation (e.g., '0,0,H' for horizontal edge at (0,0))
H = Horizontal edge, V = Vertical edge
Shuxun's turn. Enter edge coordinates and orientation (x,y,H/V) or 'Q' to quit:
input:
0,1,V
output:
Scores: Aidan: 0 | Shuxun: 0

Current Board:
+-+ + +
|      
+-+-+ +
| |    
+ + + +
       
+ + + +

Instructions: Enter coordinates and orientation (e.g., '0,0,H' for horizontal edge at (0,0))
H = Horizontal edge, V = Vertical edge
Aidan's turn. Enter edge coordinates and orientation (x,y,H/V) or 'Q' to quit:
input:
1,1,V
output:
Invalid move. Try again.
Aidan's turn. Enter edge coordinates and orientation (x,y,H/V) or 'Q' to quit:
input:
1,1,H
output:
Invalid move. Try again.
Aidan's turn. Enter edge coordinates and orientation (x,y,H/V) or 'Q' to quit:
input:
1,2,H
output:
Scores: Aidan: 0 | Shuxun: 0

Current Board:
+-+ + +
|      
+-+-+ +
| |    
+ +-+ +
       
+ + + +

Instructions: Enter coordinates and orientation (e.g., '0,0,H' for horizontal edge at (0,0))
H = Horizontal edge, V = Vertical edge
Shuxun's turn. Enter edge coordinates and orientation (x,y,H/V) or 'Q' to quit:
input:
2,1,H
output:
Scores: Aidan: 0 | Shuxun: 0

Current Board:
+-+ + +
|      
+-+-+-+
| |    
+ +-+ +
       
+ + + +

Instructions: Enter coordinates and orientation (e.g., '0,0,H' for horizontal edge at (0,0))
H = Horizontal edge, V = Vertical edge
Aidan's turn. Enter edge coordinates and orientation (x,y,H/V) or 'Q' to quit:
input:
2,2,H
output:
Scores: Aidan: 0 | Shuxun: 0

Current Board:
+-+ + +
|      
+-+-+-+
| |    
+ +-+-+
       
+ + + +

Instructions: Enter coordinates and orientation (e.g., '0,0,H' for horizontal edge at (0,0))
H = Horizontal edge, V = Vertical edge
Shuxun's turn. Enter edge coordinates and orientation (x,y,H/V) or 'Q' to quit:
input:
1,2,V
output:
Scores: Aidan: 0 | Shuxun: 0

Current Board:
+-+ + +
|      
+-+-+-+
| |    
+ +-+-+
  |    
+ + + +

Instructions: Enter coordinates and orientation (e.g., '0,0,H' for horizontal edge at (0,0))
H = Horizontal edge, V = Vertical edge
Aidan's turn. Enter edge coordinates and orientation (x,y,H/V) or 'Q' to quit:
input:
2,1,V
output:
Scores: Aidan: 1 | Shuxun: 0

Current Board:
+-+ + +
|      
+-+-+-+
| |2|  
+ +-+-+
  |    
+ + + +

Instructions: Enter coordinates and orientation (e.g., '0,0,H' for horizontal edge at (0,0))
H = Horizontal edge, V = Vertical edge
Aidan completed 1 box(es)! Go again!
Aidan's turn. Enter edge coordinates and orientation (x,y,H/V) or 'Q' to quit:
input:
2,2,V
output:
Scores: Aidan: 1 | Shuxun: 0

Current Board:
+-+ + +
|      
+-+-+-+
| |2|  
+ +-+-+
  | |  
+ + + +

Instructions: Enter coordinates and orientation (e.g., '0,0,H' for horizontal edge at (0,0))
H = Horizontal edge, V = Vertical edge
Shuxun's turn. Enter edge coordinates and orientation (x,y,H/V) or 'Q' to quit:
input:
3,2,V
output:
Scores: Aidan: 1 | Shuxun: 0

Current Board:
+-+ + +
|      
+-+-+-+
| |2|  
+ +-+-+
  | | |
+ + + +

Instructions: Enter coordinates and orientation (e.g., '0,0,H' for horizontal edge at (0,0))
H = Horizontal edge, V = Vertical edge
Aidan's turn. Enter edge coordinates and orientation (x,y,H/V) or 'Q' to quit:
input:
3,3,H
output:
Invalid move. Try again.
Aidan's turn. Enter edge coordinates and orientation (x,y,H/V) or 'Q' to quit:
input:
3,1,H
output:
Invalid move. Try again.
Aidan's turn. Enter edge coordinates and orientation (x,y,H/V) or 'Q' to quit:
input:
1,3,H
output:
Scores: Aidan: 2 | Shuxun: 0

Current Board:
+-+ + +
|      
+-+-+-+
| |2|  
+ +-+-+
  |2| |
+ +-+ +

Instructions: Enter coordinates and orientation (e.g., '0,0,H' for horizontal edge at (0,0))
H = Horizontal edge, V = Vertical edge
Aidan completed 1 box(es)! Go again!
Aidan's turn. Enter edge coordinates and orientation (x,y,H/V) or 'Q' to quit:
input:
2,0,V
output:
Scores: Aidan: 2 | Shuxun: 0

Current Board:
+-+ + +
|   |  
+-+-+-+
| |2|  
+ +-+-+
  |2| |
+ +-+ +

Instructions: Enter coordinates and orientation (e.g., '0,0,H' for horizontal edge at (0,0))
H = Horizontal edge, V = Vertical edge
Shuxun's turn. Enter edge coordinates and orientation (x,y,H/V) or 'Q' to quit:
input:
2,1,V
output:
Invalid move. Try again.
Shuxun's turn. Enter edge coordinates and orientation (x,y,H/V) or 'Q' to quit:
input:
0,1,V
output:
Invalid move. Try again.
Shuxun's turn. Enter edge coordinates and orientation (x,y,H/V) or 'Q' to quit:
input:
1,0,V
output:
Scores: Aidan: 2 | Shuxun: 1

Current Board:
+-+ + +
|3| |  
+-+-+-+
| |2|  
+ +-+-+
  |2| |
+ +-+ +

Instructions: Enter coordinates and orientation (e.g., '0,0,H' for horizontal edge at (0,0))
H = Horizontal edge, V = Vertical edge
Shuxun completed 1 box(es)! Go again!
Shuxun's turn. Enter edge coordinates and orientation (x,y,H/V) or 'Q' to quit:
input:
1,0,H
output:
Scores: Aidan: 2 | Shuxun: 2

Current Board:
+-+-+ +
|3|3|  
+-+-+-+
| |2|  
+ +-+-+
  |2| |
+ +-+ +

Instructions: Enter coordinates and orientation (e.g., '0,0,H' for horizontal edge at (0,0))
H = Horizontal edge, V = Vertical edge
Shuxun completed 1 box(es)! Go again!
Shuxun's turn. Enter edge coordinates and orientation (x,y,H/V) or 'Q' to quit:
input:
2,0,H 
output:
Scores: Aidan: 2 | Shuxun: 2

Current Board:
+-+-+-+
|3|3|  
+-+-+-+
| |2|  
+ +-+-+
  |2| |
+ +-+ +

Instructions: Enter coordinates and orientation (e.g., '0,0,H' for horizontal edge at (0,0))
H = Horizontal edge, V = Vertical edge
Aidan's turn. Enter edge coordinates and orientation (x,y,H/V) or 'Q' to quit:
input:
3,0,V
output:
Scores: Aidan: 3 | Shuxun: 2

Current Board:
+-+-+-+
|3|3| |
+-+-+-+
| |2|  
+ +-+-+
  |2| |
+ +-+ +

Instructions: Enter coordinates and orientation (e.g., '0,0,H' for horizontal edge at (0,0))
H = Horizontal edge, V = Vertical edge
Aidan completed 1 box(es)! Go again!
Aidan's turn. Enter edge coordinates and orientation (x,y,H/V) or 'Q' to quit:
input:
3,1,V
output:
Scores: Aidan: 4 | Shuxun: 2

Current Board:
+-+-+-+
|3|3| |
+-+-+-+
| |2| |
+ +-+-+
  |2| |
+ +-+ +

Instructions: Enter coordinates and orientation (e.g., '0,0,H' for horizontal edge at (0,0))
H = Horizontal edge, V = Vertical edge
Aidan completed 1 box(es)! Go again!
Aidan's turn. Enter edge coordinates and orientation (x,y,H/V) or 'Q' to quit:
input:
3,2,H
output:
Invalid move. Try again.
Aidan's turn. Enter edge coordinates and orientation (x,y,H/V) or 'Q' to quit:
input:
3,3,H
output:
Invalid move. Try again.
Aidan's turn. Enter edge coordinates and orientation (x,y,H/V) or 'Q' to quit:
input:
2,0,V   
output:
Invalid move. Try again.
Aidan's turn. Enter edge coordinates and orientation (x,y,H/V) or 'Q' to quit:
input:
0,2,V
output:
Scores: Aidan: 4 | Shuxun: 2

Current Board:
+-+-+-+
|3|3| |
+-+-+-+
| |2| |
+ +-+-+
| |2| |
+ +-+ +

Instructions: Enter coordinates and orientation (e.g., '0,0,H' for horizontal edge at (0,0))
H = Horizontal edge, V = Vertical edge
Shuxun's turn. Enter edge coordinates and orientation (x,y,H/V) or 'Q' to quit:
input:
0,2,H
output:
Scores: Aidan: 4 | Shuxun: 3

Current Board:
+-+-+-+
|3|3| |
+-+-+-+
|3|2| |
+-+-+-+
| |2| |
+ +-+ +

Instructions: Enter coordinates and orientation (e.g., '0,0,H' for horizontal edge at (0,0))
H = Horizontal edge, V = Vertical edge
Shuxun completed 1 box(es)! Go again!
Shuxun's turn. Enter edge coordinates and orientation (x,y,H/V) or 'Q' to quit:
input:
0,3,H
output:
Scores: Aidan: 4 | Shuxun: 4

Current Board:
+-+-+-+
|3|3| |
+-+-+-+
|3|2| |
+-+-+-+
|3|2| |
+-+-+ +

Instructions: Enter coordinates and orientation (e.g., '0,0,H' for horizontal edge at (0,0))
H = Horizontal edge, V = Vertical edge
Shuxun completed 1 box(es)! Go again!
Shuxun's turn. Enter edge coordinates and orientation (x,y,H/V) or 'Q' to quit:
input:
2,3,H
output:
Scores: Aidan: 4 | Shuxun: 5

Current Board:
+-+-+-+
|3|3| |
+-+-+-+
|3|2| |
+-+-+-+
|3|2| |
+-+-+-+

Instructions: Enter coordinates and orientation (e.g., '0,0,H' for horizontal edge at (0,0))
H = Horizontal edge, V = Vertical edge
Shuxun completed 1 box(es)! Go again!

======= GAME OVER =======
Final Scores:
Aidan: 4 boxes
Shuxun: 5 boxes
Congratulations, Shuxun! You won!```
