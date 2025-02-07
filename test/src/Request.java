

public class Request {

    // private int requestID;
    private int duration;
    private int numAudience;
    private String clientName;
    private String title;
    private String artist;
    private String requestDate;
    private String requestTime;
    private String type;
    private String category;
    
    
    /**
     * Constructor for the requests class
     * @param clientName
     * @param title
     * @param artist
     * @param requestDate
     * @param requestTime
     * @param duration
     * @param numAudience
     * @param type
     * @param category
     */
    public Request(String clientName, String title, String artist, String requestDate,String requestTime, int duration, 
                        int numAudience, String type, String category) {
    
        this.clientName = clientName;
        this.title = title;
        this.artist = artist;
        this.requestDate = requestDate;
        this.requestTime = requestTime;
        this.duration = duration;
        this.numAudience = numAudience;
        this.type = type;
        this.category = category;
    
    }
    

    public int getDuration() {
        return duration;
    }
    
    public int getNumAudience() {
        return numAudience;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getArtist() {
        return artist;
    }
    
    public String getRequestDate() {
        return requestDate;
    }
    
    public String getRequestTime() {
        return requestTime;
    }
    
    public String getClientName() {
        return clientName;
    }

    public String getType() {
        return type;
    }

    public String getCategory() {
        return category;
    }
    
    /**
     * Get the details of the event
     * may just have getters for each of the fields instead
     */
    public void getEventDetails() {

    }



}
