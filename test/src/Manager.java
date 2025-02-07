

/**
 * Extension of user credentials class, has attributes of user credentials with additional benefits greater than staffs
 */
public class Manager extends UserCredentials {
    private int managerID;

    /**
     * Constructor for manager object
     * @param username
     * @param password
     * @param firstName
     * @param lastName
     * @param email
     */
    public Manager(int managerID, String username, String password, String firstName, String lastName, String email) {
        super(username, password, firstName, lastName, email);
        this.managerID = managerID;
    }

    public int getManagerID() {
        return managerID;
    }



    /**
     * Method to create a new account
     * will add inputs for the method
     */
    public void createAccount() {

    }

    /**
     * Method to create a new manager account
     * will add inputs for the method
     */
    public void createManagerAccount() {

    }

    /**
     * Method to delete an account
     */
    public void deleteAccount() {

    }

    /**
     * Method to update details of an account
     */
    public void updateAccount() {

    }

}
