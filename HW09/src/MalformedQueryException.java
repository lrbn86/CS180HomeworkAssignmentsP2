/**
 * MalformedQueryException.java
 *
 * This exception is thrown when the query is not a valid SQL command type.
 *
 * @author Brandon Nguyen, nguye299@purdue.edu, Lab Section G06
 *
 * @version November 05, 2016
 *
 */
public class MalformedQueryException extends Exception {

    public MalformedQueryException (String msg) {
        super(msg);
    }

}