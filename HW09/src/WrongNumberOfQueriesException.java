/**
 * WrongNumberOfQueriesException.java
 *
 * This exception is thrown when the number of queries in the third block does
 * not match the number provided in the second block.
 *
 * @author Brandon Nguyen, nguye299@purdue.edu, Lab Section G06
 *
 * @version November 05, 2016
 *
 */
public class WrongNumberOfQueriesException extends Exception {

    public WrongNumberOfQueriesException (String msg) {
        super(msg);
    }

}