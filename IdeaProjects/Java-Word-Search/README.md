# Java-Word-Search

Word Search Solver
The Word Search Solver is a Java program that reads in a word search puzzle and a list of words to search for, then outputs the starting and ending positions of each word in the puzzle.
## Accessing the Program

To access the Word Search Solver, you can download or clone the source code from its GitHub repository:

```bash
git clone https://github.com/johnnyw01/java-word-search-program.git
```
Once you have the source code on your local machine, you can open it in your preferred Java development environment (such as Eclipse or IntelliJ IDEA) to build and run the program.

## Usage


The Word Search Solver reads in a puzzle and a list of words from a text file. The file should be located in the src/main/java directory of the project, and should follow the format shown in the puzzle.txt file included with the code. The first line of the file should specify the dimensions of the puzzle, with the number of rows followed by an "x" and then the number of columns (e.g., "5x5"). The remaining lines should contain the characters of the puzzle, separated by spaces, and the list of words to search for.

To run the program, simply execute the main method of the WordSearchSolver class. The program will read in the puzzle and word list from the file, solve the word search puzzle, and output the starting and ending positions of each word in the puzzle to the console.

Example Usage
Here's an example of how to use the Word Search Solver program:

Clone the repository to your local machine:

```bash
git clone https://github.com/johnnyw01/java-word-search-program.git
```
Navigate to the java-word-search-program directory:
```
cd java-word-search-program
```
Create a new file called puzzle.txt in the src/main/java directory, and copy the following puzzle and word list into the file:
```
5x5
H A S D F
G E Y B H
J K L Z X
C V B L N
G O O D O
HELLO
GOOD
BYE
```
Save the file and run the program:
```
javac WordSearchSolver.java
java WordSearchSolver
```
The program will output the starting and ending positions of each word in the puzzle to the console:

```
Dimensions: 5 x 5
H A S D F
G E Y B H
J K L Z X
C V B L N
G O O D O
HELLO 0:0 4:3
GOOD 4:0 4:3
BYE 1:3 1:1
```
## Contributing

Pull requests are welcome. For major changes, please open an issue first
to discuss what you would like to change.

Please make sure to update tests as appropriate.
