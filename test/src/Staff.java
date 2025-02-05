
/**
 * Staff class as an extension of user credentials
 */
public class Staff extends UserCredentials{
    private int staffID;

    /**
     * Constructor for the staff object
     * @param username
     * @param password
     * @param firstName
     * @param lastName
     * @param email
     * @param staffID
     */
    public Staff(String username, String password, String firstName, String lastName, String email, int staffID) {
        super(username, password, firstName, lastName, email);
        this.staffID = staffID;
    }

    public int getStaffID() {
        return staffID;
    }
}
