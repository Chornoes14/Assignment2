

/**
 * Base class of a user account that all acounts should have
 * Staff and managers are extensions of the user credentials
 */
public class UserCredentials {
    
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;

    /**
     * Constructor for the User credentials, will not be initialised but is here for the other classes
     * @param username
     * @param password
     * @param firstName
     * @param lastName
     * @param email
     */
    public UserCredentials(String username, String password, String firstName, String lastName, String email) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;

    }


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }


    /**
     * Method of checking if the password is correct with the given username
     * @param userPassword
     * @return  True if the password given by the user matches the password with the given username
     */
    public boolean validLogin(String userPassword) {
        return userPassword.equals(password);
    }
}
