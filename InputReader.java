import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * InputReader reads typed text input from the standard text terminal. 
 * The text typed by a user is returned as a String.
 * 
 * @author     Michael Kölling and David J. Barnes
 * @author     Modified by Dr A J Beaumont
 * @version    December 2015
 */
public class InputReader {
    private Scanner reader;

    /**
     * Create a new InputReader that reads text from the text terminal.
     */
    public InputReader()
    {
        reader = new Scanner(System.in);
    }
    
    /**
     * Create a new InputReader that reads text from a file.
     * @param filename The name of the file to read from.
     */
    public InputReader(String filename) {
        try {
          reader = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            System.err.println("ERROR: The file called " + filename + 
                " was not found.");
            System.err.println("Please ensure the file is in the same folder as your BlueJ project OR provide the full path");
            System.exit(1);
        }
    }

    /**
     * Read a line of text from standard input (the text terminal),
     * and return it as a String.
     *
     * @return  A String typed by the user.
     */
    public String getTextInput(String prompt)
    {
        System.out.print(prompt);         // print prompt
        String inputLine = reader.nextLine();
        System.out.println(inputLine);
        return inputLine;
    }

    /**
     * Read an integer from standard input (the text terminal),
     * and return it as an int value.
     *
     * @return  An int value typed by the user.
     */
    public int getIntegerInput(String prompt)
    {
        System.out.print(prompt);         // print prompt
        int number = reader.nextInt();
        reader.nextLine();
        System.out.println(number);
        return number;
    }
    
}
