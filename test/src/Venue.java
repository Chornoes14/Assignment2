
public class Venue {
    private String venueName;
    private String category;
    private int capacity;
    private double bookingPrice;
    private boolean isAvailable;


    //Add innerclass for suitability

    /**
     * Constructor for the venue class
     * @param venueName
     * @param category
     * @param capacity
     * @param bookingPrice
     */
    public Venue(String venueName, String category, int capacity, double bookingPrice) {
        this.venueName = venueName;
        this.category = category;
        this.capacity = capacity;
        this. bookingPrice = bookingPrice;

        isAvailable = true;
    } 

    /**
     * get the availability of the venue
     * @return Return true if the venue is available
     */
    public boolean venueAvailability() {
        return isAvailable;
    }

    /**
     * prints out the details of the venue
     * may just use getters for all the variables instead
     */
    public void getVenueDetails() {

    }

    /**
     * Set availability of the specific venue
     * @param isAvailable True if venue is available
     */
    public void updateVenueAvailability(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }


    /**
     * Returns the compatibility of the venue
     * may move this method into another class if not applicable here
     */
    public double getCompatibility() {
        return 0;
    }
}
