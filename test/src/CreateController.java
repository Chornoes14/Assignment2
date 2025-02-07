import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.Action;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class CreateController {
    
	private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    private TextField createEmail;
    @FXML
    private TextField createFirst;
    @FXML
    private TextField createLast;
    @FXML
    private TextField createPassword;
    @FXML
    private TextField createUsername;
    @FXML
    private TextField managerPIN;
    @FXML
    private Label error;
    
    
    
    
    
    /**
     * Return to login screen when staff account is created
     * @param event
     * @throws IOException
     */
    public void staffRegisterLogin(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("fxml/MusicMatchmakerLogin.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Return to main menu with manager account created
     * @param event
     * @throws IOException
     * @throws SQLException 
     */
    public void managerRegisterLogin(ActionEvent event) throws IOException, SQLException {
    	
    	//Get all of the user inputs
        ObservableList<UserCredentials> users = managerData();
    	String firstname = createFirst.getText();
    	String lastname = createLast.getText();
    	String username = createUsername.getText();
    	String password = createPassword.getText();
    	String email = createEmail.getText();
    	String pinManager = managerPIN.getText();
        boolean valid = true;
    	

        //Check if the manager pin required to create a manager account is correct
    	if (pinManager.equals("909")) {
            
            //check if both username and email has been used, username and email must be unique
            //will check both managers and staff list, but for now to test proper functionality will simply use manager list
            for (UserCredentials user: users) {
                //Validate email
                if (user.getEmail().equals(email)) {
                    error.setText("\"" + email + "\" is already used, please use another email");
                    valid = false;
                    break;
                }
                else if (email.isEmpty()) {
                    error.setText("Please enter an email");
                    valid = false;
                    break;
                }
                //Validate username
                if (user.getUsername().equals(username)) {
                    error.setText("\"" + username + "\" is already used, please use another username.");
                    valid = false;
                    break;
                }
                else if(username.length() < 6) {
                    error.setText("Please enter a username with at least 6 characters");
                    valid = false;
                    break;
                }
            }
            //validate password, firstname and lastname
            if (password.length() < 6 && valid) {
                error.setText("Please enter a valid password with minimum 6 characters");
                valid = false;
            }
            else if (firstname.isEmpty() && valid) {
                error.setText("Please enter a first name");
                valid = false;
            }
            else if (lastname.isEmpty() && valid) {
                error.setText("Please enter a last name");
                valid = false;
            }

            // All fields are valid, add the new user to the managers list
            if (valid) {

                //insert new manager into the manager table
                SQLMethods.addManager(new Manager(username, password, firstname, lastname, email));

                root = FXMLLoader.load(getClass().getResource("fxml/MusicMatchmakerLogin.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
    	}
    	else {
    		managerPIN.clear();
    		error.setText("PIN was incorrect");
    	}
    }
    
    
    
    
    /**
     * Get the data for the managers
     * @return
     * @throws SQLException
     */
    ObservableList<UserCredentials> managerData() throws SQLException {
        ObservableList<UserCredentials> users = FXCollections.observableArrayList();    //create object

        try (Connection con = DatabaseConnection.getConnection();
			Statement stmt = con.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM MANAGERS")) {

            while (resultSet.next()) {
                UserCredentials user = new UserCredentials(resultSet.getString("Username"),
                    resultSet.getString("Password"),
                    resultSet.getString("Firstname"),
                    resultSet.getString("Lastname"),
                    resultSet.getString("Email")
                );
                users.add(user);
                
            }

		} catch (SQLException e) {
			System.out.println("Error: Unable to fetch data from the database");
            e.printStackTrace();
            return FXCollections.observableArrayList();
		}
        return users;
    }

}
