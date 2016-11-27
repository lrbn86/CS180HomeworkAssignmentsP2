/**
 * Apartment.java
 *
 * Subclass of Residence representing a residence classified as an apartment.
 * This type of residence differs by an additional field, the floor number of the apartment
 *
 * @author Brandon Nguyen, nguye299@purdue.edu, Lab Section G06
 *
 * @version October 30, 2016
 *
 */
public class Apartment extends Residence {

    private int floorNumber; // The floor number of the apartment

    /**
     * Apartment Constructor
     * @param address
     * @param numBedrooms
     * @param numBathrooms
     * @param squareFootage
     * @param monthlyRent
     * @param floorNumber
     */
    public Apartment (String address, int numBedrooms, int numBathrooms, int squareFootage, double monthlyRent, int floorNumber) {
        super(address, numBedrooms, numBathrooms, squareFootage, monthlyRent);
        this.floorNumber = floorNumber;
    }

    /**
     * Accessor for floorNumber
     * @return number of floors
     */
    public int getFloorNumber() {
        return this.floorNumber;
    }

    /**
     * Return a formatted description of apartment
     * @return a formatted description
     */
    @Override
    public String toString() {
//        return "Address: " + getAddress() + "\n" +
//                "Number of Bedrooms: " + getNumBedrooms() + "\n" +
//                "Number of Bathrooms: " + getNumBathrooms() + "\n" +
//                "Square Footage: " + getSquareFootage() + "\n" +
//                "Monthly Rent: " + getMonthlyRent() + "\n" +
//                "Number of Floors: " + getFloorNumber();
        return "Address: " + getAddress();
    }

}