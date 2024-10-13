
public class Configurations {
	// Initialize the instance variables.
	char[][] gameBoard;
	int boardSize;
	int lengthToWin;
	int maxLevels;
	
	public Configurations (int boardSize, int lengthToWin, int maxLevels) {
		// Construct the board and fill it up with spaces.
		gameBoard = new char[boardSize][boardSize];
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				gameBoard[i][j] = ' ';
			}
		}
		// Set the instance variables equal to the given values.
		this.boardSize = boardSize;
		this.lengthToWin = lengthToWin;
		this.maxLevels = maxLevels;
	}
	
	
	public HashDictionary createDictionary() {
		// Create and return a new hash table.
		HashDictionary hashTable = new HashDictionary(9001);
		return hashTable;
	}
	
	
	public int repeatedConfiguration(HashDictionary hashTable) {
		// Initialize the configuration.
		String configuration = "";
		
		// Go through the game board.
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				// Add the current character to the configuration.
				configuration += Character.toString(gameBoard[i][j]);
			}
		}
		// Return the score of the configuration.
		return hashTable.get(configuration);
	}
	
	
	public void addConfiguration(HashDictionary hashDictionary, int score) {
		// Initialize the configuration.
		String configuration = "";
		
		// Go through the game board.
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				// Add the current character to the configuration.
				configuration += Character.toString(gameBoard[i][j]);
			}
		}
		
		// Create and add the data to the table.
		Data newData = new Data(configuration, score);
		hashDictionary.put(newData);
	}
	
	
	public void savePlay(int row, int col, char symbol) {
		// Update the game board using the given values.
		gameBoard[row][col] = symbol;
	}
	
	
	public boolean squareIsEmpty(int row, int col) {
		// Return true if the square is empty, false if not.
		if (gameBoard[row][col] == ' ') {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	public boolean wins (char symbol) {
		// Search the game board horizontally for any winning lines.
		for (int i = 0; i < boardSize; i++) {
        	for (int j = 0; j <= boardSize - lengthToWin; j++) {
        		// Initialize won and set it to true.
        		boolean won = true;
        		// Check to see that the rest of the characters are the same.
        		for (int k = 0; k < lengthToWin; k++) {
					/*
					 *  If another character is found set won to false and
					 *  break from the sub-loop.
					 */
        			if (gameBoard[i][j + k] != symbol) {
        				won = false;
        				break;
        			}
        		}
        		
        		// Return true if a winning line has been found.
        		if (won == true) {
        			return true;
        		}
        	}
		}
		
		// Search the game board vertically for any winning lines.
		for (int j = 0; j < boardSize; j++) {
			for (int i = 0; i <= boardSize - lengthToWin; i++) {
				// Initialize won and set it to true.
				boolean won = true;
				// Check to see that the rest of the characters are the same.
				for (int k = 0; k < lengthToWin; k++) {
					/*
					 *  If another character is found set won to false and
					 *  break from the sub-loop.
					 */
					if (gameBoard[i + k][j] != symbol) {				
						won = false;
						break;
					}
				}
				
				// Return true if a winning line has been found.
				if (won == true) {
					return true;
				}
			}
		}
		
		// Search the game board diagonally for any winning lines.
        for (int i = 0; i <= boardSize - lengthToWin; i++) {
            for (int j = 0; j <= boardSize - lengthToWin; j++) {
            	/*
            	 *  Initialize and set won1 and won2 to true.
            	 *  We need two booleans in order to check both directions.
            	 */
                boolean won1 = true;
                boolean won2 = true;
             // Check to see that the rest of the characters are the same.
                for (int k = 0; k < lengthToWin; k++) {
                	/*
                	 *  NOTE: We cannot break from this sub-loop since one
                	 *  boolean can be false and the other can be true.
                	 */
                	// If another character is found set won1 to false.
                    if (gameBoard[i + k][j + k] != symbol) {
                        won1 = false;
                    }
                    // If another character is found set won2 to false.
                    if (gameBoard[i + k][j + lengthToWin - 1 - k] != symbol) {
                        won2 = false;
                    }
                }
                
                // Return true if a winning line has been found.
                if ((won1 == true) || (won2 == true)) {
                	return true;
                }
            }
        }
        
        // Return false if no winning line has been found.
        return false;
	}
	
	
	public boolean isDraw() {
		// Go through the game board.
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				// Return false if the current square is empty.
				if (squareIsEmpty(i, j) == true) {
					return false;
				}
			}
		}
		
		// Return true if all of the squares have been filled.
		return true;
	}
	
	
	public int evalBoard() {
		// Return the corresponding evaluation based on the result of the game.
		if (wins('O') == true) {
			return 3;
		}
		else if (wins('X') == true) {
			return 0;
		}
		else if (isDraw() == true) {
			return 2;
		}
		else {
			return 1;
		}
	}
}
