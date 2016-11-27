import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Parser.java
 *
 * Analyze a given formatted SQL file
 *
 * @author Brandon Nguyen, nguye299@purdue.edu, Lab Section G06
 *
 * @version November 05, 2016
 *
 */
public class Parser {

    private String username;
    private int numQueries;


    /**
     * Parses a given file
     *
     * @param filePath
     * @throws WrongFileFormatException
     * @throws WrongNumberOfQueriesException
     * @throws InvalidInputException
     * @throws MalformedQueryException
     * @throws IOException
     */
    public void parse(String filePath) throws WrongFileFormatException, WrongNumberOfQueriesException, InvalidInputException, MalformedQueryException, IOException {

        int countQueries = 0;

        File file = new File(filePath);

        Scanner input = new Scanner(file);

        // TODO Check for wrong file format
        // TODO Check for correct number of queries
        // TODO Check for positive number of queries
        // TODO Check for valid SQL commands
        while (input.hasNextLine()) {

            String s = input.nextLine();

            if (s.equals("C")) {
                username = input.nextLine();
            } else {
                throw new WrongFileFormatException("Wrong File Format");
            }

            s = input.nextLine(); // Go to the next line

            if (!s.equals("c")) {
                throw new WrongFileFormatException("Wrong File Format");
            }

            s = input.nextLine(); // Go to the next line

            if (s.equals("N")) {
                numQueries = Integer.parseInt(input.nextLine());
            } else {
                throw new WrongFileFormatException("Wrong File Format");
            }

            s = input.nextLine(); // Go to the next line

            if (!s.equals("n")) {
                throw new WrongFileFormatException("Wrong File Format");
            }

            s = input.nextLine(); // Go to the next line

            if (s.equals("Q")) {

                s = input.nextLine(); // Go to the next line

                while (!s.equals("q")) { // While that line is not "q", check to see if SQL command is valid

                    if (s.substring(0, 1).equals("S") || s.substring(0, 1).equals("U") || s.substring(0, 1).equals("I") || s.substring(0, 1).equals("D")) {

                        countQueries++; // If SQL command is valid, increment countQueries


                    } else if (s.equals("q")) { // Once "q" has been reach, then break this loop
                        break;
                    } else if (!s.equals("q")) {
                        throw new WrongFileFormatException("Wrong File Format"); // If line with "q" is never reached, then it has a wrong file format
                    } else {
                        throw new MalformedQueryException("Invalid SQL Command");
                    }

                    if (!input.hasNextLine()) { // If there is no more lines to read, break this loop
                        break;
                    } else {
                        s = input.nextLine(); // However, if there is more lines to read then go to the next line
                    }
                }

            } else {
                throw new WrongFileFormatException("Wrong File Format");
            }
        }


        if (numQueries <= 0) { // If the number of queries is not 1 or larger, then throw exception
            throw new InvalidInputException("Invalid Integer, must be positive and greater than 1");
        }

        if (numQueries != countQueries) { // If the number of queries given does not match the expected number of queries, then throw exception
            throw new WrongNumberOfQueriesException("Number of Queries Mismatch");
        }

        // Close scanner
        input.close();

    }

    /**
     * Accessor for username
     * @return username
     */
    public String getUserName() {
        return this.username;
    }

    /**
     * Accessor method for numQueries
     * @return number of queries
     */
    public int getNumQueries() {
        return this.numQueries;
    }

    /**
     * Program's main entry point
     *
     * @param args commandline arguments
     */
    public static void main(String[] args) {

        File file = new File("/Users/brandonnguyen/Desktop/Purdue Stuffs/CS18000/Homework/HW09/Data/file11.sql");

        Parser parser = new Parser();

        try {
            parser.parse(file.getAbsolutePath());
        } catch (WrongFileFormatException e) {
            System.out.println(e.getMessage());
        } catch (WrongNumberOfQueriesException e) {
            System.out.println(e.getMessage());
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        } catch (MalformedQueryException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(parser.getUserName());
        System.out.println(parser.getNumQueries());
    }
}