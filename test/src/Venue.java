
public class Venue {
    private String venueName;
    private String category;
    private int capacity;
    private double bookingPrice;
    private boolean isAvailable;
    private Suitability suitableFor;

    // private String eventType;
    // private String eventStyle;

    private class Suitability {
        private String eventType;
        private String eventStyle;

        public Suitability(String eventType, String eventStyle) {
            this.eventType = eventType;
            this.eventStyle = eventStyle;
        }

        public String getEventType() {
            return eventType;
        }

        public String getEventStyle() {
            return eventStyle;
        }

    }


    //Add innerclass for suitability

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
        this. bookingPrice = bookingPrice;

        String[] suitableSplit = suitabilityString.split(";", 2);

        suitableFor = new Suitability(suitableSplSit[0], suitableSplit[1]);

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
