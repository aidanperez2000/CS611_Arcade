import java.util.*;

/*The DotsAndBoxes class retains the main logic for determining the winner of the game
*
* This is a two-players game. Each player needs to input the coordinate of start point.
* The horizontal line is drawn from the left (starting point) to the adjacent point on the right.
* The vertical line is drawn from the top (starting point) to the adjacent point below.
*
* The condition for winning the game is to compare who has more closed grids
*
* */
public class DotsAndBoxes extends Game {
    private List<Edge> horizontalEdges;
    private List<Edge> verticalEdges;
    private List<Box> boxes;
    private Player player2;
    private int currentPlayerId;
    private boolean gameOver;
    private DotsAndBoxesRenderer renderer;

    public DotsAndBoxes(Board board, Player player1, Player player2) {
        super(board, player1);
        this.player2 = player2;
        this.currentPlayerId = player1.GetPlayerId();
        this.gameOver = false;
        this.renderer = new DotsAndBoxesRenderer();
        initializeGame();
    }


    /*Initialize the game board with edges and boxes*/
    private void initializeGame() {
        horizontalEdges = new ArrayList<>();
        verticalEdges = new ArrayList<>();
        boxes = new ArrayList<>();

        // horizontal
        for (int y = 0; y <= board.Height; y++) {
            for (int x = 0; x < board.Width; x++) {
                horizontalEdges.add(new Edge(x, y, Orientation.H));
            }
        }

        // vertical
        for (int y = 0; y < board.Height; y++) {
            for (int x = 0; x <= board.Width; x++) {
                verticalEdges.add(new Edge(x, y, Orientation.V));
            }
        }

        // Create boxes
        for (int y = 0; y < board.Height; y++) {
            for (int x = 0; x < board.Width; x++) {
                boxes.add(new Box(x, y));
            }
        }
    }

    // Play the Dots and Boxes game
    public void Play(Scanner scanner) {
        System.out.println("Welcome to Dots and Boxes!");
        System.out.println("Players: " + player.GetPlayerName() + " (Player 1) vs " + player2.GetPlayerName() + " (Player 2)");
        System.out.println("Board size: " + board.Width + "x" + board.Height);

        // reset scores
        player.ResetScore();
        player2.ResetScore();

        System.out.println("Scores: " + player.GetPlayerName() + ": " + player.GetScore() +
                " | " + player2.GetPlayerName() + ": " + player2.GetScore());

        int[][] boardArray = createEncodedBoardArray();
        renderer.Render(boardArray, board.Height, board.Width);

        while (!gameOver) {
            Player currentPlayer = getCurrentPlayer();
            System.out.println(currentPlayer.GetPlayerName() + "'s turn. Enter edge coordinates and orientation (x,y,H/V) or '" + Board.QUIT_SIGN + "' to quit:");

            String input = scanner.nextLine().trim();
            if (input.equals(Board.QUIT_SIGN)) {
                break;
            }

            try {
                if (processMove(input, currentPlayer)) {
                    int boxesCompleted = checkAndCompleteBoxes(currentPlayer);
                    boardArray = createEncodedBoardArray();
                    System.out.println("Scores: " + player.GetPlayerName() + ": " + player.GetScore() +
                            " | " + player2.GetPlayerName() + ": " + player2.GetScore());
                    renderer.Render(boardArray, board.Height, board.Width);

                    if (boxesCompleted > 0) {
                        System.out.println(currentPlayer.GetPlayerName() + " completed " + boxesCompleted + " box(es)! Go again!");
                    } else {
                        switchPlayer();
                    }

                    checkGameOver();
                } else {
                    System.out.println("Invalid move. Try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input format. Use: x,y,H or x,y,V");
            }
        }
        displayFinalResults();
    }

    private int[][] createEncodedBoardArray() {
        int[][] encoded = new int[board.Height * 2 + 1][Math.max(board.Width + 1, board.Width * 2)];

        // horizontal
        for (Edge edge : horizontalEdges) {
            if (edge.IsClaimed()) {
                int row = edge.GetYPos() * 2;
                int col = edge.GetXPos();
                if (row < encoded.length && col < encoded[row].length) {
                    encoded[row][col] = edge.GetPlayerId();
                }
            }
        }

        // vertical
        for (Edge edge : verticalEdges) {
            if (edge.IsClaimed()) {
                int row = edge.GetYPos() * 2 + 1;
                int col = edge.GetXPos();
                if (row < encoded.length && col < encoded[row].length) {
                    encoded[row][col] = edge.GetPlayerId();
                }
            }
        }

        // Encode completed boxes
        for (Box box : boxes) {
            if (box.IsCompleted()) {
                int row = box.GetYPos() * 2 + 1;
                int col = board.Width + 1 + box.GetXPos();
                if (row < encoded.length && col < encoded[row].length) {
                    encoded[row][col] = box.GetOwnerId();
                }
            }
        }

        return encoded;
    }


    /*Process a player's move
     * input: player input in format "x,y,H" or "x,y,V"
     * currentPlayer: player making the move
     * returns: true if move was valid and processed, false otherwise*/
    private boolean processMove(String input, Player currentPlayer) {
        String[] parts = input.split(",");
        if (parts.length != 3) {
            return false;
        }
        try {
            int x = Integer.parseInt(parts[0].trim());
            int y = Integer.parseInt(parts[1].trim());
            String orientationStr = parts[2].trim().toUpperCase();

            if (!orientationStr.equals("H") && !orientationStr.equals("V")) {
                return false;
            }

            Orientation orientation = orientationStr.equals("H") ? Orientation.H : Orientation.V;

            Edge edge = findEdge(x, y, orientation);
            if (edge != null && !edge.IsClaimed()) {
                edge.ClaimEdge(currentPlayer.GetPlayerId());
                return true;
            }
        } catch (NumberFormatException e) {
            return false;
        }

        return false;
    }

    /*Find an edge by coordinates and orientation
     * x: column index
     * y: row index
     * range: x ∈ [0, width-1], y ∈ [0, height-1]
     * orientation: H for horizontal, V for vertical
     * returns: Edge object or null if not found*/
    private Edge findEdge(int x, int y, Orientation orientation) {
        if (orientation == Orientation.H) {
            if (x >= 0 && x < board.Width && y >= 0 && y <= board.Height) {
                int index = y * board.Width + x;
                if (index < horizontalEdges.size()) {
                    return horizontalEdges.get(index);
                }
            }
        } else {
            if (x >= 0 && x <= board.Width && y >= 0 && y < board.Height) {
                int index = y * (board.Width + 1) + x;
                if (index < verticalEdges.size()) {
                    return verticalEdges.get(index);
                }
            }
        }
        return null;
    }

    private int checkAndCompleteBoxes(Player currentPlayer) {
        int completedCount = 0;
        for (Box box : boxes) {
            if (!box.IsCompleted() && isBoxComplete(box)) {
                box.CompleteBox(currentPlayer.GetPlayerId());
                currentPlayer.AddScore(1);
                completedCount++;
            }
        }
        return completedCount;
    }

    private boolean isBoxComplete(Box box) {
        int x = box.GetXPos();
        int y = box.GetYPos();

        Edge topEdge = findEdge(x, y, Orientation.H);
        Edge bottomEdge = findEdge(x, y + 1, Orientation.H);
        Edge leftEdge = findEdge(x, y, Orientation.V);
        Edge rightEdge = findEdge(x + 1, y, Orientation.V);

        return topEdge != null && topEdge.IsClaimed() &&
                bottomEdge != null && bottomEdge.IsClaimed() &&
                leftEdge != null && leftEdge.IsClaimed() &&
                rightEdge != null && rightEdge.IsClaimed();
    }

    private Player getCurrentPlayer() {
        return currentPlayerId == player.GetPlayerId() ? player : player2;
    }

    private void switchPlayer() {
        currentPlayerId = (currentPlayerId == player.GetPlayerId()) ? player2.GetPlayerId() : player.GetPlayerId();
    }

    private void checkGameOver() {
        boolean allEdgesClaimed = true;
        for (Edge edge : horizontalEdges) {
            if (!edge.IsClaimed()) {
                allEdgesClaimed = false;
                break;
            }
        }
        if (allEdgesClaimed) {
            for (Edge edge : verticalEdges) {
                if (!edge.IsClaimed()) {
                    allEdgesClaimed = false;
                    break;
                }
            }
        }
        gameOver = allEdgesClaimed;
    }

    private void displayFinalResults() {
        System.out.println("\n======= GAME OVER =======");
        System.out.println("Final Scores:");
        System.out.println(player.GetPlayerName() + ": " + player.GetScore() + " boxes");
        System.out.println(player2.GetPlayerName() + ": " + player2.GetScore() + " boxes");

        if (player.GetScore() > player2.GetScore()) {
            System.out.println("Congratulations, " + player.GetPlayerName() + "! You won!");
        } else if (player2.GetScore() > player.GetScore()) {
            System.out.println("Congratulations, " + player2.GetPlayerName() + "! You won!");
        } else {
            System.out.println("It's a tie! Great game!");
        }
    }
}