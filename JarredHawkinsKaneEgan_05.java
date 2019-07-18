/*
 * Project 5, CS 2050
 * 
 * Takes an input file and converts the operations within it from infix to postfix
 * 
 * Windows Eclipse IDE
 * 
 * @version 1.0
 * 
 * @author Jarred Hawkins, Kane Egan
 * 
 * Girasol - A fire opal that glows like fire in a certain light
 * 
 * "We all make choices, but in the end our choices make us."
 * 		- Andrew Ryan(1902 - 1960)
 */
import java.io.*;
import java.util.Scanner;

public class JarredHawkinsKaneEgan_05 {

	public static void main(String[] args) throws IOException {
		// Creates the Input and Output file names to be used by
		// FileWriter and File
		final String INPUT_FILE = "2050 Project 05_Input.txt";
		final String OUTPUT_FILE = "2050 Project 05_Output.txt";
		
		Postfix converter = new Postfix();

		FileWriter outputDataFile = new FileWriter(OUTPUT_FILE); // File writer to be used by PrintWriter
		PrintWriter outputFile = new PrintWriter(outputDataFile); // Sets up the Output file to be used by all methods
		
		File inputDataFile = new File(INPUT_FILE);
		// Checks to see if there is an Input File to read.
		// If not, prints to the output File the error and terminates.
		if (inputDataFile == null || inputDataFile.length() == 0) {
			System.err.println("File " + INPUT_FILE + " not found.");
			outputFile.println("File " + INPUT_FILE + " not found.");
			outputFile.close();
			throw new FileNotFoundException("File " + INPUT_FILE + " not found.");
		}
		
		Scanner inputFile = new Scanner(inputDataFile);
		
		while (inputFile.hasNextLine()) {
			String inputLine = inputFile.nextLine();
			outputFile.println(converter.convertToPostfix(inputLine));
		} // End While
		
		inputFile.close();
		outputFile.close();
	}
}

