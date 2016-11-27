/**
 * House.java
 *
 * Subclass of Residence representing a residence classified as a house.
 * This type of residence differs by two additional fields:
 * the total number of floors the house has, and a boolean value
 * indicating if the house has a garage or not.
 *
 * @author Brandon Nguyen, nguye299@purdue.edu, Lab Section G06
 *
 * @version October 30, 2016
 *
 */
public class House extends Residence {

    private int numFloors; // The number of floors the house has
    private boolean hasGarage; // If the house has a garage or not

    /**
     * House Constructor
     * @param address
     * @param numBedrooms
     * @param numBathrooms
     * @param squareFootage
     * @param monthlyRent
     * @param numFloors
     * @param hasGarage
     */
    public House (String address, int numBedrooms, int numBathrooms, int squareFootage, double monthlyRent, int numFloors, boolean hasGarage) {
        super(address, numBedrooms, numBathrooms, squareFootage, monthlyRent);
        this.numFloors = numFloors;
        this.hasGarage = hasGarage;
    }

    /**
     * Accessor for numFloors
     * @return number of floors
     */
    public int getNumFloors() {
        return this.numFloors;
    }

    /**
     * Accessor for hasGarage
     * @return if house has a garage or not
     */
    public boolean hasGarage() {
        return this.hasGarage;
    }

    /**
     * Return a formatted description of house
     * @return a formatted description
     */
    public String toString() {
        return "Address: " + getAddress() + "\n" +
                "Number of Bedrooms: " + getNumBedrooms() + "\n" +
                "Number of Bathrooms: " + getNumBathrooms() + "\n" +
                "Square Footage: " + getSquareFootage() + "\n" +
                "Monthly Rent: " + getMonthlyRent() + "\n" +
                "Number of Floors: " + getNumFloors() + "\n" +
                "Garage: " + hasGarage();
    }
}