/**
 * Residence.java
 *
 * Parent class of the class hierarchy for residence listings.
 * This class represents all common properties that all residence listings
 * have in common.
 *
 * @author Brandon Nguyen, nguye299@purdue.edu, Lab Section G06
 *
 * @version October 30, 2016
 *
 */
public class Residence {

    private String address; // The address of the residence
    private int numBedrooms; // The number of bedrooms in the residence
    private int numBathrooms; // The number of bathrooms in the residence
    private int squareFootage; // The square footage of the residence
    private double monthlyRent; // The monthly rent of the residence

    /**
     * Residence Constructor
     * @param address
     * @param numBedrooms
     * @param numBathrooms
     * @param squareFootage
     * @param monthlyRent
     */
    public Residence (String address, int numBedrooms, int numBathrooms, int squareFootage, double monthlyRent) {
        this.address = address;
        this.numBedrooms = numBedrooms;
        this.numBathrooms = numBathrooms;
        this.squareFootage = squareFootage;
        this.monthlyRent = monthlyRent;
    }

    /**
     * Accessor method for address
     * @return address
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * Accessor for numBedrooms
     * @return number of bedrooms
     */
    public int getNumBedrooms() {
        return this.numBedrooms;
    }

    /**
     * Accessor for numBathrooms
     * @return number of bathrooms
     */
    public int getNumBathrooms() {
        return this.numBathrooms;
    }

    /**
     * Accessor for squareFootage
     * @return square footage
     */
    public int getSquareFootage() {
        return this.squareFootage;
    }

    /**
     * Accessor for monthlyRent
     * @return monthly rent
     */
    public double getMonthlyRent() {
        return this.monthlyRent;
    }

}