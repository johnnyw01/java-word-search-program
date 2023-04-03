import org.junit.Test;

import java.io.*;
import java.util.Scanner;


import static org.junit.Assert.assertEquals;

public class WordSearchSolverTest {

    @Test
    public void testWordSearch() throws FileNotFoundException{
        // Define input data
        String input = "5x5\n" +
                "H A S D F\n" +
                "G E Y B H\n" +
                "J K L Z X\n" +
                "C V B L N\n" +
                "G O O D O\n" +
                "HELLO\n" +
                "GOOD\n" +
                "BYE";

        // Set up input and output streams
        File inputFile = new File("src/main/java/puzzle.txt");  // Define the input file
        PrintStream originalOut = System.out;  // Save the original System.out stream
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();  // Create a new output stream to capture program output
        System.setOut(new PrintStream(outputStream));  // Redirect System.out to the output stream we just created
        InputStream inputStream = new FileInputStream(inputFile);  // Create an input stream to read from the input file
        System.setIn(inputStream);  // Redirect System.in to the input stream we just created

        // Run the program
        WordSearchSolver.main(new String[]{});  // Call the main method of the WordSearchSolver class

        // Verify output
        String expectedOutput = "Dimensions: 5 x 5\n" +
                "H A S D F \n" +
                "G E Y B H \n" +
                "J K L Z X \n" +
                "C V B L N \n" +
                "G O O D O \n" +
                "HELLO 0:0 4:4\n" +
                "GOOD 4:0 4:3\n" +
                "BYE 1:3 1:1\n";
        assertEquals(expectedOutput, outputStream.toString());  // Compare the program output to the expected output

        // Restore original output stream
        System.setOut(originalOut);  // Redirect System.out back to its original stream
    }

}
