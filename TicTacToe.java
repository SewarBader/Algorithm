package application;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.scene.control.Button;

public class TicTacToe {
	Button[][] buttons = new Button[3][3];
	public char[][] board;
	public char currentPlayer;
	public static final char PLAYER_X = 'X';
	public static final char PLAYER_O = 'O';

    public TicTacToe() {
        board = new char[3][3];
        currentPlayer = PLAYER_X;
        initializeBoard();
    }

    public void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

  

    public void play() {
        while (true) {
            if (currentPlayer == PLAYER_X) {
                playerMove();
            } else {
                // Minimax algorithm for AI move
                minimaxMove();
            }

            if (checkWinner()) {
                System.out.println(currentPlayer + " wins!");
                break;
            } else if (isBoardFull()) {
                System.out.println("It's a draw!");
                break;
            }

            switchPlayer();
        }
    }

    public void playerMove() {
        // Implement code for player's move (e.g., take input from the user)
        // Update the board based on the player's move
    }
    private boolean isBoardFull2() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (buttons[i][j].getText().equals("")) {
					return false;
				}
			}
		}
		return true;
	}
    public void minimaxMove() {
        int[] bestMove = minimax(board, 0, true);
        int row = bestMove[0];
        int col = bestMove[1];
        board[row][col] = currentPlayer;
    }

    public int[] minimax(char[][] currentBoard, int depth, boolean isMaximizing) {
        char opponent = (currentPlayer == PLAYER_X) ? PLAYER_O : PLAYER_X;

        if (checkWinnerForPlayer(PLAYER_X, currentBoard)) {
            return new int[] { -1, -1, 10 - depth }; // The AI wins
        } else if (checkWinnerForPlayer(PLAYER_O, currentBoard)) {
            return new int[] { -1, -1, depth - 10 }; // The opponent wins
        } else if (isBoardFull(currentBoard)) {
            return new int[] { -1, -1, 0 }; // It's a draw
        }

        List<int[]> possibleMoves = generateMoves(currentBoard);

        if (isMaximizing) {
            int maxEval = Integer.MIN_VALUE;
            int[] bestMove = new int[] { -1, -1, maxEval };

            for (int[] move : possibleMoves) {
                int row = move[0];
                int col = move[1];

                if (currentBoard[row][col] == ' ') {
                    currentBoard[row][col] = currentPlayer;
                    int eval = minimax(currentBoard, depth + 1, false)[2];
                    currentBoard[row][col] = ' '; // Undo the move

                    if (eval > maxEval) {
                        maxEval = eval;
                        bestMove = new int[] { row, col, eval };
                    }
                }
            }

            return bestMove;
        } else {
            int minEval = Integer.MAX_VALUE;
            int[] bestMove = new int[] { -1, -1, minEval };

            for (int[] move : possibleMoves) {
                int row = move[0];
                int col = move[1];

                if (currentBoard[row][col] == ' ') {
                    currentBoard[row][col] = opponent;
                    int eval = minimax(currentBoard, depth + 1, true)[2];
                    currentBoard[row][col] = ' '; // Undo the move

                    if (eval < minEval) {
                        minEval = eval;
                        bestMove = new int[] { row, col, eval };
                    }
                }
            }

            return bestMove;
        }
    }

    public boolean isBoardFull(char[][] currentBoard) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (currentBoard[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkWinnerForPlayer(char player, char[][] currentBoard) {
        // Implement code to check if the specified player has won on the current board
        // Return true if the player wins, false otherwise
        // This method will depend on your specific logic for checking the winner
        return false;
    }

    private List<int[]> generateMoves(char[][] currentBoard) {
        List<int[]> moves = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (currentBoard[i][j] == ' ') {
                    moves.add(new int[] { i, j });
                }
            }
        }

        return moves;
    }
    private boolean checkWinner() {
        // Implement code to check for a winner
        // Return true if there is a winner, false otherwise
        return false;
    }

    public boolean isBoardFull() {
        // Implement code to check if the board is full
        // Return true if the board is full, false otherwise
        return false;
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == PLAYER_X) ? PLAYER_O : PLAYER_X;
    }
    
    private boolean checkWinCondition(int row, int col) {

		if (buttons[row][0].getText().equals(currentPlayer) && buttons[row][1].getText().equals(currentPlayer)
				&& buttons[row][2].getText().equals(currentPlayer)) {
			return true;
		}

		// Check the column
		if (buttons[0][col].getText().equals(currentPlayer) && buttons[1][col].getText().equals(currentPlayer)
				&& buttons[2][col].getText().equals(currentPlayer)) {
			return true;
		}

		// Check diagonals
		if (row == col && buttons[0][0].getText().equals(currentPlayer) && buttons[1][1].getText().equals(currentPlayer)
				&& buttons[2][2].getText().equals(currentPlayer)) {
			return true;
		}
		if (row + col == 2 && buttons[0][2].getText().equals(currentPlayer)
				&& buttons[1][1].getText().equals(currentPlayer) && buttons[2][0].getText().equals(currentPlayer)) {
			return true;
		}

		return false;
	}

    public char[][] getBoard() {
  		return board;
  	}

  	public void setBoard(char[][] board) {
  		this.board = board;
  	}

  	public char getCurrentPlayer() {
  		return currentPlayer;
  	}

  	public void setCurrentPlayer(char currentPlayer) {
  		this.currentPlayer = currentPlayer;
  	}

  	public static char getPlayerX() {
  		return PLAYER_X;
  	}

  	public static char getPlayerO() {
  		return PLAYER_O;
  	}

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.play();
    }
    
}
