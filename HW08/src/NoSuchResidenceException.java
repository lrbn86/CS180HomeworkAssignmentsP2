/**
 * NoSuchResidenceException.java
 *
 * Custom exception thrown in the ResidenceListings class when an attempt is
 * made to remove a Residence that does not exist.
 *
 * @author Brandon Nguyen, nguye299@purdue.edu, Lab Section G06
 *
 * @version October 30, 2016
 *
 */
public class NoSuchResidenceException extends Exception {

    /**
     * NoSuchResidenceException Constructor
     * @param message
     */
    public NoSuchResidenceException (String message) {
        super(message);
    }
}