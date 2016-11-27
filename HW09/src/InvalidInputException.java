/**
 * InvalidInputException.java
 *
 * This exception is thrown when the data that is delimited in the second
 * section of the file (between N and n) is not an integer number 1 or larger.
 *
 * @author Brandon Nguyen, nguye299@purdue.edu, Lab Section G06
 *
 * @version November 05, 2016
 *
 */
public class InvalidInputException extends Exception {

    public InvalidInputException (String msg) {
        super(msg);
    }
}