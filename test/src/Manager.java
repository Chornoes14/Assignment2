

/**
 * Extension of user credentials class, has attributes of user credentials with additional benefits greater than staffs
 */
public class Manager extends UserCredentials {
    private int managerID;
    private int pin;

    /**
     * Constructor for manager object
     * @param username
     * @param password
     * @param firstName
     * @param lastName
     * @param email
     * @param managerID
     * @param pin
     */
    public Manager(String username, String password, String firstName, String lastName, String email, int managerID, int pin) {
        super(username, password, firstName, lastName, email);
        this.managerID = managerID;
        this.pin = pin;
    }

    public int getManagerID() {
        return managerID;
    }

    public int getPin() {
        return pin;
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
