import java.util.*;

/*Class for Quoridor game*/
public class Quoridor extends Game {
    private final QuoridorPlayer player1;
    private final QuoridorPlayer player2;
    private final QuoridorRenderer renderer;
    private QuoridorPlayer currentPlayer;
    private int[][] boardArray;

    public Quoridor(Board board, QuoridorPlayer player1, QuoridorPlayer player2) {
        super(board);
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
        this.renderer = new QuoridorRenderer();
    }

    /*Play the Quoridor game
     * scanner: scanner for input*/
    public void Play(Scanner scanner) {
        System.out.println("Welcome to Quoridor!");
        initializeBoard();

        System.out.println("Game Rules:");
        System.out.println("- Move your pawn one step at a time to reach the opposite side");
        System.out.println("- You can move in 4 directions: N(orth), S(outh), E(ast), W(est)");
        System.out.println("- You can place walls to block your opponent: use format 'W x,y,H/V'");
        System.out.println("- Each player has 10 walls to use");
        System.out.println("- Type 'Q' to quit");
        System.out.println();

        displayGameState();

        while (!isGameOver()) {
            System.out.println(currentPlayer.GetPlayerName() + "'s turn.");
            System.out.println("Enter move (N/S/E/W) or wall placement (W x,y,H/V) or Q to quit:");

            String input = scanner.nextLine().trim().toUpperCase();

            if (input.equals("Q")) {
                System.out.println("Game ended by player.");
                break;
            }

            if (processMove(input)) {
                if (isGameOver()) {
                    displayGameState();
                    System.out.println("Congratulations " + currentPlayer.GetPlayerName() + "! You won!");
                    break;
                }
                switchPlayer();
                displayGameState();
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
    }

    /*Initialize the game board*/
    private void initializeBoard() {
        // Create expanded board: (2*size + 1) to accommodate walls
        int expandedSize = board.Height * 2 + 1;
        boardArray = new int[expandedSize][expandedSize];

        // Initialize all cells as empty
        for (int y = 0; y < expandedSize; y++) {
            for (int x = 0; x < expandedSize; x++) {
                if (y % 2 == 0 && x % 2 == 0) {
                    // Corner intersections
                    boardArray[y][x] = CellValue.EDGE.ordinal();
                } else {
                    boardArray[y][x] = CellValue.EMPTY.ordinal();
                }
            }
        }

        // Place players at their starting positions
        updatePlayerPositions();
    }

    /*Update player positions on the board*/
    private void updatePlayerPositions() {
        // Clear previous player positions
        for (int y = 1; y < boardArray.length; y += 2) {
            for (int x = 1; x < boardArray[y].length; x += 2) {
                if (boardArray[y][x] == CellValue.PLAYER_1.ordinal() ||
                        boardArray[y][x] == CellValue.PLAYER_2.ordinal()) {
                    boardArray[y][x] = CellValue.EMPTY.ordinal();
                }
            }
        }

        // Place players at current positions
        boardArray[player1.GetYPos() * 2 + 1][player1.GetXPos() * 2 + 1] = player1.GetPlayerId();
        boardArray[player2.GetYPos() * 2 + 1][player2.GetXPos() * 2 + 1] = player2.GetPlayerId();
    }

    /*Process player move
     * input: player input string
     * returns: true if move was valid and executed*/
    private boolean processMove(String input) {
        if (input.length() == 1) {
            // Movement command
            return processMovement(input.charAt(0));
        } else if (input.startsWith("W ") && input.length() >= 4) {
            // Wall placement command
            return processWallPlacement(input.substring(2));
        }
        return false;
    }

    /*Process player movement
     * direction: N, S, E, W
     * returns: true if move was valid*/
    private boolean processMovement(char direction) {
        int currentX = currentPlayer.GetXPos();
        int currentY = currentPlayer.GetYPos();
        int newX = currentX;
        int newY = currentY;

        switch (direction) {
            case 'N':
                newY = currentY - 1;
                break;
            case 'S':
                newY = currentY + 1;
                break;
            case 'E':
                newX = currentX + 1;
                break;
            case 'W':
                newX = currentX - 1;
                break;
            default:
                return false;
        }

        // Check bounds
        if (newX < 0 || newX >= board.Width || newY < 0 || newY >= board.Height) {
            return false;
        }

        // Check for walls blocking the path
        if (isPathBlocked(currentX, currentY, newX, newY)) {
            return false;
        }

        // Check if destination is occupied
        QuoridorPlayer otherPlayer = (currentPlayer == player1) ? player2 : player1;
        if (newX == otherPlayer.GetXPos() && newY == otherPlayer.GetYPos()) {
            // Try to jump over the other player
            return processJump(currentX, currentY, newX, newY, direction);
        }

        // Move is valid
        currentPlayer.SetPosition(newX, newY);
        updatePlayerPositions();
        return true;
    }

    /*Process jumping over opponent
     * fromX, fromY: starting position
     * jumpX, jumpY: opponent position
     * direction: movement direction
     * returns: true if jump was valid*/
    private boolean processJump(int fromX, int fromY, int jumpX, int jumpY, char direction) {
        int finalX = jumpX;
        int finalY = jumpY;

        // Calculate jump destination
        switch (direction) {
            case 'N':
                finalY = jumpY - 1;
                break;
            case 'S':
                finalY = jumpY + 1;
                break;
            case 'E':
                finalX = jumpX + 1;
                break;
            case 'W':
                finalX = jumpX - 1;
                break;
        }

        // Check if jump destination is valid and not blocked
        if (finalX < 0 || finalX >= board.Width || finalY < 0 || finalY >= board.Height) {
            return false;
        }

        if (isPathBlocked(jumpX, jumpY, finalX, finalY)) {
            return false;
        }

        currentPlayer.SetPosition(finalX, finalY);
        updatePlayerPositions();
        return true;
    }

    /*Check if path between two adjacent cells is blocked by a wall*/
    private boolean isPathBlocked(int x1, int y1, int x2, int y2) {
        // Convert to board array coordinates
        int boardX1 = x1 * 2 + 1;
        int boardY1 = y1 * 2 + 1;
        int boardX2 = x2 * 2 + 1;
        int boardY2 = y2 * 2 + 1;

        // Find the wall position between the cells
        int wallX = (boardX1 + boardX2) / 2;
        int wallY = (boardY1 + boardY2) / 2;

        return boardArray[wallY][wallX] == CellValue.HORIZONTAL_WALL.ordinal() ||
                boardArray[wallY][wallX] == CellValue.VERTICAL_WALL.ordinal();
    }

    /*Process wall placement
     * wallInput: format "x,y,H/V"
     * returns: true if wall was placed successfully*/
    private boolean processWallPlacement(String wallInput) {
        if (!currentPlayer.HasWallsRemaining()) {
            System.out.println("No walls remaining!");
            return false;
        }

        String[] parts = wallInput.split(",");
        if (parts.length != 3) {
            return false;
        }

        try {
            int x = Integer.parseInt(parts[0].trim());
            int y = Integer.parseInt(parts[1].trim());
            String orientation = parts[2].trim().toUpperCase();

            if (placeWall(x, y, orientation)) {
                currentPlayer.UseWall();
                return true;
            }
        } catch (NumberFormatException e) {
            return false;
        }

        return false;
    }

    /*Place wall at specified position
     * x, y: wall coordinates
     * orientation: H for horizontal, V for vertical
     * returns: true if wall was placed successfully*/
    private boolean placeWall(int x, int y, String orientation) {
        if (orientation.equals("H")) {
            // Horizontal wall
            if (x < 0 || x >= board.Width - 1 || y < 0 || y >= board.Height) {
                return false;
            }

            int wallY = y * 2;
            int wall1X = x * 2 + 1;
            int wall2X = (x + 1) * 2 + 1;

            // Check if positions are free
            if (boardArray[wallY][wall1X] == CellValue.HORIZONTAL_WALL.ordinal() ||
                    boardArray[wallY][wall2X] == CellValue.HORIZONTAL_WALL.ordinal()) {
                return false;
            }

            // Place wall temporarily to check path validity
            boardArray[wallY][wall1X] = CellValue.HORIZONTAL_WALL.ordinal();
            boardArray[wallY][wall2X] = CellValue.HORIZONTAL_WALL.ordinal();

            // Check if both players can still reach their goals
            if (canReachGoal(player1) && canReachGoal(player2)) {
                return true; // Wall is valid
            } else {
                // Remove wall and reject placement
                boardArray[wallY][wall1X] = CellValue.EMPTY.ordinal();
                boardArray[wallY][wall2X] = CellValue.EMPTY.ordinal();
                System.out.println("Wall would block a player's path to goal!");
                return false;
            }

        } else if (orientation.equals("V")) {
            // Vertical wall
            if (x < 0 || x >= board.Width || y < 0 || y >= board.Height - 1) {
                return false;
            }

            int wallX = x * 2;
            int wall1Y = y * 2 + 1;
            int wall2Y = (y + 1) * 2 + 1;

            // Check if positions are free
            if (boardArray[wall1Y][wallX] == CellValue.VERTICAL_WALL.ordinal() ||
                    boardArray[wall2Y][wallX] == CellValue.VERTICAL_WALL.ordinal()) {
                return false;
            }

            // Place wall temporarily to check path validity
            boardArray[wall1Y][wallX] = CellValue.VERTICAL_WALL.ordinal();
            boardArray[wall2Y][wallX] = CellValue.VERTICAL_WALL.ordinal();

            // Check if both players can still reach their goals
            if (canReachGoal(player1) && canReachGoal(player2)) {
                return true; // Wall is valid
            } else {
                // Remove wall and reject placement
                boardArray[wall1Y][wallX] = CellValue.EMPTY.ordinal();
                boardArray[wall2Y][wallX] = CellValue.EMPTY.ordinal();
                System.out.println("Wall would block a player's path to goal!");
                return false;
            }
        }

        return false;
    }

    /*Check if a player can reach their goal using BFS*/
    private boolean canReachGoal(QuoridorPlayer player) {
        Set<String> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{player.GetXPos(), player.GetYPos()});
        visited.add(player.GetXPos() + "," + player.GetYPos());

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int x = pos[0];
            int y = pos[1];

            // Check if reached target row
            if (y == player.GetTargetRow()) {
                return true;
            }

            // Try all four directions
            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                // Check bounds
                if (newX < 0 || newX >= board.Width || newY < 0 || newY >= board.Height) {
                    continue;
                }

                String key = newX + "," + newY;
                if (visited.contains(key)) {
                    continue;
                }

                // Check if path is blocked by wall
                if (!isPathBlocked(x, y, newX, newY)) {
                    queue.offer(new int[]{newX, newY});
                    visited.add(key);
                }
            }
        }

        return false;
    }

    /*Switch to the other player*/
    private void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    /*Check if game is over*/
    private boolean isGameOver() {
        return player1.HasWon() || player2.HasWon();
    }

    /*Display current game state*/
    private void displayGameState() {
        System.out.println("\n" + player1.GetPlayerName() + " (Player 1): " +
                player1.GetWallsRemaining() + " walls remaining");
        System.out.println(player2.GetPlayerName() + " (Player 2): " +
                player2.GetWallsRemaining() + " walls remaining");
        System.out.println();
        renderer.Render(boardArray, board.Height, board.Width);
        System.out.println();
    }
}