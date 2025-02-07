
public class Venue {
    private int venueID;
    private String venueName;
    private String category;
    private int capacity;
    private int bookingPrice;
    private boolean isAvailable;
    private String suitableFor;
    // private Suitability suitableFor;
    
                    
    
    /**
     * Constructor for the venue class
     * @param venueName
     * @param category
     * @param capacity
     * @param bookingPrice
     */
    public Venue(int venueID, String venueName, String category, int capacity, int bookingPrice, String suitabilityString) {
        this.venueID = venueID;
        this.venueName = venueName;
        this.category = category;
        this.capacity = capacity;
        this.bookingPrice = bookingPrice;
        
        // String[] suitableSplit = suitabilityString.split(";", 2);
        
        suitableFor = suitabilityString;
        
        isAvailable = true;
    } 
    
    public int getVenueID() {
        return venueID;
    }

    public String getVenueName() {
        return venueName;
    }
    public String getCategory() {
        return category;
    }
    
    public int getCapacity() {
        return capacity;
    }
    
    public int getBookingPrice() {
        return bookingPrice;
    }
    
    public String getSuitableFor() {
        return suitableFor;
    }
    public boolean isAvailable() {
        return isAvailable;
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
