import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class WordSearchSolver {
    public static void main(String[] args) {
        // Parse the input file
        String filename = "src/main/java/puzzle.txt";
        ArrayList<String> wordList = new ArrayList<String>();
        char[][] puzzle;
        int numRows, numCols;
        try {
            Scanner input = new Scanner(new File(filename));
            String[] dimensions = input.nextLine().split("x");
            numRows = Integer.parseInt(dimensions[0]);
            numCols = Integer.parseInt(dimensions[1]);
            // Print the dimensions of the puzzle
            System.out.println("Dimensions: " + numRows + " x " + numCols);
            puzzle = new char[numRows][numCols];
            // Read in each row of the puzzle and store it in the puzzle array
            for (int row = 0; row < numRows; row++) {
                String[] rowChars = input.nextLine().split(" ");
                for (int col = 0; col < numCols; col++) {
                    puzzle[row][col] = rowChars[col].charAt(0);
                    // Print each character of the puzzle as it is added to the array
                    System.out.print(puzzle[row][col] + " ");
                }
                System.out.println();
            }
            // Read in the list of words to search for
            while (input.hasNextLine()) {
                wordList.add(input.nextLine());
            }
            input.close();
        } catch (FileNotFoundException e) {
            // Print an error message if the file cannot be found
            System.out.println("File not found: " + filename);
            return;
        }

        // Solve the word search puzzle
        boolean allWordsFound = false;
        for (String word : wordList) {
            boolean found = false;
            int startRow = -1, startCol = -1, endRow = -1, endCol = -1;
            for (int row = 0; row < numRows; row++) {
                for (int col = 0; col < numCols; col++) {
                    // Check all directions for the current word
                    for (int rowInc = -1; rowInc <= 1; rowInc++) {
                        for (int colInc = -1; colInc <= 1; colInc++) {
                            // Skip the case where both rowInc and colInc are 0
                            if (rowInc == 0 && colInc == 0) {
                                continue;
                            }
                            // Check if the current direction contains the word
                            if (checkWord(puzzle, word, row, col, rowInc, colInc)) {
                                found = true;
                                startRow = row;
                                startCol = col;
                                endRow = row + (word.length() - 1) * rowInc;
                                endCol = col + (word.length() - 1) * colInc;
                                // Stop searching for the word once it is found
                                break;
                            }
                        }
                        if (found) {
                            // Stop searching for the word once it is found
                            break;
                        }
                    }
                    if (found) {
                        // Stop searching for the word once it is found
                        break;
                    }
                }
                if (found) {
                    // Stop searching for the word once it is found
                    break;
                }
            }
            // Output the result of the search
            System.out.printf("%s %d:%d %d:%d\n", word, startRow, startCol, endRow, endCol);

            // Check if all the words have been found
            // If the current word is the last word in the list and it has been found, set allWordsFound to true
            if (wordList.indexOf(word) == wordList.size() - 1 && found) {
                allWordsFound = true;
            }
            if (allWordsFound) {
                // Stop searching for words once all the words have been found
                break;
            }
        }

    }
    // Helper method to check if a given direction contains a given word
    private static boolean checkWord(char[][] puzzle, String word, int row, int col, int rowInc, int colInc) {
        // Calculate the last row and column in the direction being checked
        int lastRow = row + rowInc * (word.length() - 1);
        int lastCol = col + colInc * (word.length() - 1);
        // Check if the last row or column is out of bounds for the puzzle
        boolean rowOutOfBounds = lastRow >= puzzle.length || lastRow < 0;
        boolean colOutOfBounds = lastCol >= puzzle[0].length || lastCol < 0;
        if (rowOutOfBounds || colOutOfBounds) {
            // The word cannot be in this direction if it goes out of bounds
            return false;
        }
        // Check if the characters in the direction being checked match the characters in the word
        for (int i = 0; i < word.length(); i++) {
            if (puzzle[row + i * rowInc][col + i * colInc] != word.charAt(i)) {
                return false;
            }
        }
        // If all the characters match, the word has been found in this direction
        return true;
    }
}
