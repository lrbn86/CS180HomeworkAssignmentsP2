import java.util.Arrays;

/**
 * ResidenceListings.java
 *
 * Class representing a collection of Residences, providing methods for maintaing various properties of the collection and modifying the collection.
 *
 * @author Brandon Nguyen, nguye299@purdue.edu, Lab Section G06
 *
 * @version October 30, 2016
 *
 */
public class ResidenceListings {

    private int numResidences; // The total number of non-null elements in the residences array
    private int maxResidences; // The maximum number of elements that the residences array can hold
    private Residence[] residences; // Array containing all the Residences to be stored for the ResidenceListings object

    /**
     * ResidenceListings Constructor
     */
    public ResidenceListings() {
        this.maxResidences = 10;
        this.numResidences = 0;
        this.residences = new Residence[maxResidences];
    }

    /**
     * Adds a residence
     * @param residence
     */
    public void addResidence (Residence residence) {

        Residence[] temp = new Residence[(maxResidences * 2)];

        if (this.getNumResidences() >= this.getMaxResidences()) {
            for (int i = 0; i < this.getResidences().length; i++) {
                temp[i] = residences[i]; // Copy all contents from residences to temp
            }
            maxResidences = temp.length; // Change the current length to new length (which was doubled)
            residences = temp; // residences is now that temp array
            residences[numResidences] = residence; // Insert residence object into that new Residence array
        }

        residences[numResidences] = residence;
        numResidences++;
    }

    /**
     * Removes a residence
     * @param residence
     */
    public void removeResidence (Residence residence) throws NoSuchResidenceException {

            int indexOfResidenceToBeRemoved = 0;
            for (int i = 0; i < residences.length; i++) {

                if (residences[i] == null){
                    throw new NoSuchResidenceException("Residence not found.");
                } else if (residences[i].equals(residence)) {
                    indexOfResidenceToBeRemoved = i; // Keep track of the index of the residence to be removed
                    break;
                }
            }

            for (int i = indexOfResidenceToBeRemoved; i < residences.length - 1; i++) {

                residences[i] = residences[i + 1];
            }

            if (residences[residences.length - 1] != null) {
                residences[residences.length - 1] = null;
            }

            numResidences--;
    }


    /**
     * Gives a residence by address
     * @param address
     * @return a residence
     */
    public Residence findResidenceByAddress (String address) {

        // Searches through the array residences, looking for the first
        // Residence whose address is equal to that of the address passed as
        // argument to this method.
        // If a match is found, the matched Residence object in the residences
        // array is returned, else return null.
        for (int i = 0; i < residences.length; i++) {
            if (getResidences()[i].getAddress().equals(address) && getResidences()[i] != null) {
                return getResidences()[i];
            }
        }
        return null;
    }

    /**
     * Accessor for numResidences
     * @return number of residences
     */
    public int getNumResidences() {
        return this.numResidences;
    }

    /**
     * Accessor for maxResidences
     * @return max number of residences
     */
    public int getMaxResidences() {
        return this.maxResidences;
    }

    /**
     * Accessor for residences
     * @return residences
     */
    public Residence[] getResidences() {
        return this.residences;
    }

    public static void main(String[] args) {
        ResidenceListings rl = new ResidenceListings();
        Residence residenceToAdd;

        for (int i =0; i < 5; i++) {
            residenceToAdd = new Residence(String.valueOf(i), 0, 0, 0, 0);
            rl.addResidence(residenceToAdd);
        }

        System.out.println(Arrays.toString(rl.getResidences()));

        Residence residenceToRemove = new Residence("Remove Residence", 0, 0, 0, 0);
        rl.addResidence(residenceToRemove);
        for (int i = 6; i < 10; i++) {
            residenceToAdd = new Residence(String.valueOf(i), 0, 0, 0, 0);
            rl.addResidence(residenceToAdd);
        }

        System.out.println(Arrays.toString(rl.getResidences()));

        try {
            rl.removeResidence(residenceToRemove);
        } catch (NoSuchResidenceException e) {
            e.getMessage();
        }

        System.out.println(Arrays.toString(rl.getResidences()));
//        System.out.println(rl.findResidenceByAddress("2"));
    }
}