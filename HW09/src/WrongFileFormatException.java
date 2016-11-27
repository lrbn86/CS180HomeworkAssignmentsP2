/**
 * WrongFileFormatException.java
 *
 * This exception is thrown when format of the file is not correct.
 * This is when the delimiters are not placed properly.
 *
 * @author Brandon Nguyen, nguye299@purdue.edu, Lab Section G06
 *
 * @version November 05, 2016
 *
 */
public class WrongFileFormatException extends Exception {

    public WrongFileFormatException (String msg) {
        super(msg);
    }

}