/**
 * CountPrimesExecutor.java
 *
 * Split a given interval across a given number of threads, initialize instances
 * of CountPrimes threads for each sub-interval, then manage the execution and
 * coordination of threads
 *
 * @author Brandon Nguyen, nguye299@purdue.edu, Lab Section G06
 *
 * @version November 16, 2016
 *
 */
public class CountPrimesExecutor {

    private long lower; // The start of the interval to search for prime numbers
    private long upper; // The end of the interval to search for prime numbers
    private int numThreads; // The number of threads to split the search interval across
    private CountPrimes[] countPrimeThreads; // Array containing all the instances of CountPrimes threads

    /**
     * Sets the numThreads, lower, and upper fields of this class to the values of the
     * corresponding arguments to this constructor
     *
     * Splits the given interval [lower, upper] across numThreads instances of
     * CountPrimes objects as equally as possible and stores these instances in the
     * countPrimeThreads array field
     *
     * @param numThreads
     * @param lower
     * @param upper
     */
    public CountPrimesExecutor(int numThreads, long lower, long upper) {

        this.numThreads = numThreads;
        this.lower = lower;
        this.upper = upper;

        this.countPrimeThreads = new CountPrimes[numThreads];

        long increment = (upper - lower) / numThreads;

        for (int i = 0; i < this.countPrimeThreads.length; i++) {

            countPrimeThreads[i] = new CountPrimes(lower, lower + increment);
            lower = lower + increment + 1;

        }

    }

    /**
     * Starts all the threads in the countPrimeThreads array field and pause
     * execution of the main thread until all of the CountPrimes threads have
     * finished
     *
     */
    public void executeThreads() {
        for (CountPrimes countPrimes : countPrimeThreads) {
            countPrimes.start();
        }

        for (CountPrimes countPrimes : countPrimeThreads) {
            try {
                countPrimes.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}