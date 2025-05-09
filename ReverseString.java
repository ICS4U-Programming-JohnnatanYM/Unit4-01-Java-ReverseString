import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * This program reads a word from a file,
 * reverses it using recursion, displays the result
 * in the terminal, and writes the reversed word to a new file.
 *
 * @author Johnnatan Yasin Medina
 * @version 1.0
 * @since 2025-05-09
 */
final class ReverseString {

    /**
     * Private constructor to prevent instantiation of utility class.
     *
     * @exception IllegalStateException
     * @see IllegalStateException
     */
    private ReverseString() {
        throw new IllegalStateException("Utility Class");
    }

    /**
     * Main method that drives the program.
     *
     * @param args Unused.
     */
    public static void main(final String[] args) {
        // Check if input file name is provided
        if (args.length < 1) {
            System.out.println("Usage: java ReverseString <inputFileName>");
            return;
        }

        // Store the input file name and set the output file name
        String inputFileName = args[0];
        String outputFileName = "output.txt";

        // Try block to read from the input file
        try (Scanner scanner = new Scanner(new File(inputFileName))) {
            // Check if the file has content
            if (scanner.hasNext()) {
                // Read the first word from the file
                String word = scanner.next();
                // Reverse the word using recursion
                String reversed = reverse(word);

                // Display the original and reversed words in the terminal
                System.out.println("Original: " + word);
                System.out.println("Reversed: " + reversed);

                // Try block to write the reversed word to the output file
                try (FileWriter writer = new FileWriter(outputFileName)) {
                    // Write the reversed word to the output file
                    writer.write(reversed);
                }

                // Confirm the reversed word has been saved
                System.out.println("Reversed word saved to output.txt.");
            } else {
                // If the file is empty or contains no valid word
                System.out.println("File is empty or contains no valid word.");
            }
        } catch (FileNotFoundException e) {
            // Handle the case where the input file is not found
            System.out.println("Error: File \""
             + inputFileName + "\" not found.");
        } catch (IOException e) {
            // Handle any I/O exceptions (e.g., issues with writing to the file)
            System.out.println("Error writing to output.txt.");
        }
    }

    /**
     * Recursively reverses a given string.
     *
     * @param str The string to reverse.
     * @return The reversed string.
     */
    private static String reverse(final String str) {
        // Base case: if the string is empty, return it as is
        if (str.isEmpty()) {
            return str;
        }
        return reverse(str.substring(1)) + str.charAt(0);
    }
}
