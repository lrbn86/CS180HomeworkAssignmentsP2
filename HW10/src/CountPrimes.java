import java.util.concurrent.atomic.AtomicInteger;
import java.util.jar.Pack200;

/**
 * CountPrimes.java
 *
 * Perform the necessary computations for finding prime numbers in a given interval
 * and keeping track of the total count of prime numbers across all instances of this class
 *
 * @author Brandon Nguyen, nguye299@purdue.edu, Lab Section G06
 *
 * @version November 16, 2016
 *
 */
public class CountPrimes extends Thread {

    private long lower; // The start of the interval to search for prime numbers
    private long upper; // The end of the interval to search for prime numbers
    private static AtomicInteger numPrimes = new AtomicInteger(); // The total number of prime numbers found across all instances of this class

    /**
     * Sets the lower and upper fields of this class to the values of the
     * corresponding arguments to this constructor
     *
     * @param lower
     * @param upper
     */
    public CountPrimes(long lower, long upper) {
        this.lower = lower;
        this.upper = upper;
    }

    /**
     * Iterates over the given sub-interval and increments the numPrimes field
     * each time a prime number is found.
     *
     */
    @Override
    public void run() {
        for (int i = (int)lower; i < (int) upper; i++) {
            if (isPrime(i)) {
                numPrimes.incrementAndGet();
            }
        }
    }


    /**
     * Accessor for the field numPrimes
     *
     * @return integer representing number of primes
     */
    public static int getNumPrimes() {
        return numPrimes.get();
    }

    /**
     * Sets the value of the numPrimes field to 0.
     *
     */
    public static void resetNumPrimes() {
        numPrimes.set(0);
    }

    /**
     * Returns true if num is prime, else false
     *
     * @param num
     * @return boolean representing whether a number is a prime number
     */
    private boolean isPrime(long num) {

        // Prime numbers are positive integers greater than 1 that have no positive
        // integer divisors other than itself and 1.

        int sqrt = (int) Math.sqrt(num);
        if (!(num > 1)) { // Number must be greater than 1
            return false;
        }

        for (int i = 2; i <= sqrt; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}