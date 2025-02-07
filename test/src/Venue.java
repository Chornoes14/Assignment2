
public class Venue {
    private String venueName;
    private String category;
    private int capacity;
    private double bookingPrice;
    private boolean isAvailable;
    private String suitableFor;
    // private Suitability suitableFor;
    
                    
    public String getVenueName() {
        return venueName;
    }
    public String getCategory() {
        return category;
    }
    
    public int getCapacity() {
        return capacity;
    }
    
    public double getBookingPrice() {
        return bookingPrice;
    }
    
    public String getSuitableFor() {
        return suitableFor;
    }
    public boolean isAvailable() {
        return isAvailable;
    }

    /**
     * Constructor for the venue class
     * @param venueName
     * @param category
     * @param capacity
     * @param bookingPrice
     */
    public Venue(String venueName, String category, int capacity, double bookingPrice, String suitabilityString) {
        this.venueName = venueName;
        this.category = category;
        this.capacity = capacity;
        this.bookingPrice = bookingPrice;

        // String[] suitableSplit = suitabilityString.split(";", 2);

        suitableFor = suitabilityString;

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
